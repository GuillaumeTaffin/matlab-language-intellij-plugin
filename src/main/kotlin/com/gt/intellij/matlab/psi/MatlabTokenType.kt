package com.gt.intellij.matlab.psi

import com.gt.intellij.matlab.language.MatlabLanguage
import com.intellij.psi.tree.IElementType

class MatlabTokenType(debugName: String) : IElementType(debugName, MatlabLanguage) {
    override fun toString(): String {
        return "MatlabTokenType." + super.toString()
    }
}