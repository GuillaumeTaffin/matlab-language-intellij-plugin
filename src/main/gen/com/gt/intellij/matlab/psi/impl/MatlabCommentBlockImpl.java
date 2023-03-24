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

public class MatlabCommentBlockImpl extends ASTWrapperPsiElement implements MatlabCommentBlock {

  public MatlabCommentBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MatlabVisitor visitor) {
    visitor.visitCommentBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MatlabVisitor) accept((MatlabVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MatlabCommentBlock> getCommentBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MatlabCommentBlock.class);
  }

  @Override
  @NotNull
  public PsiElement getCommentBlockBegin() {
    return findNotNullChildByType(COMMENT_BLOCK_BEGIN);
  }

  @Override
  @NotNull
  public PsiElement getCommentBlockEnd() {
    return findNotNullChildByType(COMMENT_BLOCK_END);
  }

}
