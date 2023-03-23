package com.gt.intellij.matlab.language.parser

import com.gt.intellij.matlab.language.MatlabLanguage
import com.gt.intellij.matlab.language.lexer.MatlabLexerAdapter
import com.gt.intellij.matlab.psi.MatlabFile
import com.gt.intellij.matlab.psi.MatlabTokenSets
import com.gt.intellij.matlab.psi.MatlabTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class MatlabParserDefinition : ParserDefinition {

    companion object {
        @JvmStatic
        val FILE = IFileElementType(MatlabLanguage)
    }

    override fun createLexer(project: Project?): Lexer = MatlabLexerAdapter()

    override fun createParser(project: Project?): PsiParser = MatlabParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = MatlabTokenSets.COMMENTS

    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun createElement(node: ASTNode?): PsiElement = MatlabTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = MatlabFile(viewProvider)
}