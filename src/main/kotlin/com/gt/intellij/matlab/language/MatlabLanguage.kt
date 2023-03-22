package com.gt.intellij.matlab.language

import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader

const val MATLAB_ID = "Matlab"

object MatlabLanguage : Language(MATLAB_ID)

object Icons {
    val SMALL = IconLoader.getIcon("/icons/icons8-matlab-48.png", javaClass)
}

class MatlabFileType : LanguageFileType(MatlabLanguage) {

    companion object {
        @JvmStatic
        val INSTANCE = MatlabFileType()
    }

    override fun getName() = "Matlab File"

    override fun getDescription() = "A file written in Matlab Language"

    override fun getDefaultExtension() = "m"

    override fun getIcon() = Icons.SMALL
}
