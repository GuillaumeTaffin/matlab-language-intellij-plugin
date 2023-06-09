// This is a generated file. Not intended for manual editing.
package com.gt.intellij.matlab.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.gt.intellij.matlab.psi.impl.*;

public interface MatlabTypes {

  IElementType COMMENT = new MatlabElementType("COMMENT");
  IElementType STRING = new MatlabElementType("STRING");

  IElementType COMMENT_BLOCK = new MatlabTokenType("COMMENT_BLOCK");
  IElementType EOL = new MatlabTokenType("EOL");
  IElementType INLINED_COMMENT = new MatlabTokenType("INLINED_COMMENT");
  IElementType NUMBER = new MatlabTokenType("NUMBER");
  IElementType SHELL_STRING = new MatlabTokenType("SHELL_STRING");
  IElementType STRING_QUOTED_DOUBLE = new MatlabTokenType("STRING_QUOTED_DOUBLE");
  IElementType STRING_QUOTED_SINGLE = new MatlabTokenType("STRING_QUOTED_SINGLE");
  IElementType WHITE_SPACE = new MatlabTokenType("WHITE_SPACE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == COMMENT) {
        return new MatlabCommentImpl(node);
      }
      else if (type == STRING) {
        return new MatlabStringImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
