plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.7.20"
    id("org.jetbrains.intellij") version "1.13.2"
    id("org.jetbrains.grammarkit") version "2022.3.1"
}

group = "com.gt"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
val psiViewerPlugin = "PsiViewer:2022.3"
intellij {
    version.set("2022.3")
    type.set("IC") // Target IDE Platform

    plugins.set(listOf(psiViewerPlugin))
}

idea {
    module {
        generatedSourceDirs.add(file("src/gen"))
    }
}

val generatedSourcesRoot = "build/generated-sources"

sourceSets {
    main {
        java.srcDirs(generatedSourcesRoot)
    }
}

tasks {

    compileKotlin {
        dependsOn("generateParser", "generateLexer")
    }

    generateLexer {
        sourceFile.set(file("src/main/grammars/Matlab.flex"))
        targetDir.set("$generatedSourcesRoot/com/gt/intellij/matlab/language/lexer")
        targetClass.set("MatlabLexer")
        purgeOldFiles.set(true)
    }

    generateParser {
        sourceFile.set(file("src/main/grammars/Matlab.bnf"))
        targetRoot.set(generatedSourcesRoot)
        pathToParser.set("com/gt/intellij/matlab/language/parser/MatlabParser.java")
        pathToPsiRoot.set("com/gt/intellij/matlab/psi")
        purgeOldFiles.set(true)
    }

    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }

    patchPluginXml {
        sinceBuild.set("223")
        untilBuild.set("231.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}
