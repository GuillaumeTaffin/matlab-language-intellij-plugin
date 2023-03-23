package com.gt.intellij.matlab.language.lexer

import com.intellij.lexer.FlexAdapter

class MatlabLexerAdapter : FlexAdapter(MatlabLexer(null))