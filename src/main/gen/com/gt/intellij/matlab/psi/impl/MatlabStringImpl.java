// This is a generated file. Not intended for manual editing.
package com.gt.intellij.matlab.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.gt.intellij.matlab.psi.MatlabTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.gt.intellij.matlab.psi.*;

public class MatlabStringImpl extends ASTWrapperPsiElement implements MatlabString {

  public MatlabStringImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MatlabVisitor visitor) {
    visitor.visitString(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MatlabVisitor) accept((MatlabVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getShellString() {
    return findChildByType(SHELL_STRING);
  }

  @Override
  @Nullable
  public PsiElement getStringQuotedDouble() {
    return findChildByType(STRING_QUOTED_DOUBLE);
  }

  @Override
  @Nullable
  public PsiElement getStringQuotedSingle() {
    return findChildByType(STRING_QUOTED_SINGLE);
  }

}
