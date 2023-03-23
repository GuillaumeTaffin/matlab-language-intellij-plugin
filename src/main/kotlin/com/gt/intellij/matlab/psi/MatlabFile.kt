package com.gt.intellij.matlab.psi

import com.gt.intellij.matlab.language.MatlabFileType
import com.gt.intellij.matlab.language.MatlabLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class MatlabFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, MatlabLanguage) {
    override fun getFileType(): FileType = MatlabFileType.INSTANCE

    override fun toString(): String = "Matlab File"
}