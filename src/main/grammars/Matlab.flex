package com.gt.intellij.matlab.language.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.gt.intellij.matlab.psi.MatlabTypes.*;

%%

%class MatlabLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

EOL=\R
WHITE_SPACE=[\ \t\f]

NUMBER=[0-9]+(\.[0-9]+)?([eE][-+]?[0-9]+)?
SINGLE_LINE_COMMENT=%[^\r\n]*
SHELL_STRING=\!.*
STRING_QUOTED_SINGLE='([^'\n]|'')*'
STRING_QUOTED_DOUBLE=\"([^\"\n]|\"\")*\"


%%
<YYINITIAL> {
  {EOL}+                     { return EOL; }
  {WHITE_SPACE}+             { return WHITE_SPACE; }

  {NUMBER}                   { return NUMBER; }
  {SINGLE_LINE_COMMENT}      { return SINGLE_LINE_COMMENT; }
  {SHELL_STRING}             { return SHELL_STRING; }
  {STRING_QUOTED_SINGLE}     { return STRING_QUOTED_SINGLE; }
  {STRING_QUOTED_DOUBLE}     { return STRING_QUOTED_DOUBLE; }

}


[^] { return BAD_CHARACTER; }
