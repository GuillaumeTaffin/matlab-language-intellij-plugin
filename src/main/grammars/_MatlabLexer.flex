package com.gt.intellij.matlab.language.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.gt.intellij.matlab.psi.MatlabTypes.*;

%%

%{
  public _MatlabLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _MatlabLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

NUMBER=[0-9]+(\.[0-9]+)?([eE][-+]?[0-9]+)?
COMMENT_BLOCK=([ \t\f]*)(%\{)([^\r\n]*)[\r\n](.|\n)*%}
INLINED_COMMENT=%[^\r\n]*
SHELL_STRING=\!.*
STRING_QUOTED_SINGLE='([^'\r\n]|'')*'
STRING_QUOTED_DOUBLE=\"([^\"\r\n]|\"\")*\"
WHITE_SPACE=[ \t\f]+
EOL=[\r\n\f]+

%%
<YYINITIAL> {
  {WHITE_SPACE}               { return WHITE_SPACE; }


  {NUMBER}                    { return NUMBER; }
  {COMMENT_BLOCK}             { return COMMENT_BLOCK; }
  {INLINED_COMMENT}           { return INLINED_COMMENT; }
  {SHELL_STRING}              { return SHELL_STRING; }
  {STRING_QUOTED_SINGLE}      { return STRING_QUOTED_SINGLE; }
  {STRING_QUOTED_DOUBLE}      { return STRING_QUOTED_DOUBLE; }
  {WHITE_SPACE}               { return WHITE_SPACE; }
  {EOL}                       { return EOL; }

}

[^] { return BAD_CHARACTER; }
