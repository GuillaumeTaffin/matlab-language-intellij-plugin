// This is a generated file. Not intended for manual editing.
package com.gt.intellij.matlab.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.gt.intellij.matlab.psi.MatlabTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class MatlabParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return matlabFile(b, l + 1);
  }

  /* ********************************************************** */
  // INLINED_COMMENT
  //                 | COMMENT_BLOCK
  public static boolean comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment")) return false;
    if (!nextTokenIs(b, "<comment>", COMMENT_BLOCK, INLINED_COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMENT, "<comment>");
    r = consumeToken(b, INLINED_COMMENT);
    if (!r) r = consumeToken(b, COMMENT_BLOCK);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // string
  static boolean expression(PsiBuilder b, int l) {
    return string(b, l + 1);
  }

  /* ********************************************************** */
  // (WHITE_SPACE | EOL)+
  static boolean inlined_white_space(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inlined_white_space")) return false;
    if (!nextTokenIs(b, "", EOL, WHITE_SPACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = inlined_white_space_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!inlined_white_space_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "inlined_white_space", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITE_SPACE | EOL
  private static boolean inlined_white_space_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inlined_white_space_0")) return false;
    boolean r;
    r = consumeToken(b, WHITE_SPACE);
    if (!r) r = consumeToken(b, EOL);
    return r;
  }

  /* ********************************************************** */
  // comment
  //                     | inlined_white_space
  //                     | standalone_expression
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = comment(b, l + 1);
    if (!r) r = inlined_white_space(b, l + 1);
    if (!r) r = standalone_expression(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // item_*
  static boolean matlabFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matlabFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "matlabFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // expression WHITE_SPACE? !expression INLINED_COMMENT?
  static boolean standalone_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "standalone_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && standalone_expression_1(b, l + 1);
    r = r && standalone_expression_2(b, l + 1);
    r = r && standalone_expression_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITE_SPACE?
  private static boolean standalone_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "standalone_expression_1")) return false;
    consumeToken(b, WHITE_SPACE);
    return true;
  }

  // !expression
  private static boolean standalone_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "standalone_expression_2")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // INLINED_COMMENT?
  private static boolean standalone_expression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "standalone_expression_3")) return false;
    consumeToken(b, INLINED_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // SHELL_STRING
  //             | STRING_QUOTED_SINGLE
  //             | STRING_QUOTED_DOUBLE
  public static boolean string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING, "<string>");
    r = consumeToken(b, SHELL_STRING);
    if (!r) r = consumeToken(b, STRING_QUOTED_SINGLE);
    if (!r) r = consumeToken(b, STRING_QUOTED_DOUBLE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
