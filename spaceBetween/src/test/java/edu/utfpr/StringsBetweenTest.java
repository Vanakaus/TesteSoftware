package edu.utfpr;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static edu.utfpr.SubstringsBetween.substringsBetween;


public class StringsBetweenTest {
  @Test
  void strIsNullOrEmpty() {
    assertThat(substringsBetween(null, "a", "b"))
      .isEqualTo(null); // T01
    assertThat(substringsBetween("", "a", "b"))
      .isEqualTo(new String[]{}); // T02
  }

  @Test
  void openIsNullOrEmpty() {
    assertThat(substringsBetween("abc", null, "b")).isEqualTo(null); // T03
    assertThat(substringsBetween("abc", "", "b")).isEqualTo(null); // T04
  }

  @Test
  void closeIsNullOrEmpty() {
    assertThat(substringsBetween("abc", "a", null)).isEqualTo(null); // T05
    assertThat(substringsBetween("abc", "a", "")).isEqualTo(null); // T06
  }

  @Test
  void strOfLength1() {
    assertThat(substringsBetween("a", "a", "b")).isEqualTo(null); // T07
    assertThat(substringsBetween("a", "b", "a")).isEqualTo(null); // T08
    assertThat(substringsBetween("a", "b", "b")).isEqualTo(null); // T09
    assertThat(substringsBetween("a", "a", "a")).isEqualTo(null); // T10
  }

  @Test
  void openAndCloseOfLength1() {
    assertThat(substringsBetween("abc", "x", "y")).isEqualTo(null); // T11
    assertThat(substringsBetween("abc", "a", "y")).isEqualTo(null); // T12
    assertThat(substringsBetween("abc", "x", "c")).isEqualTo(null); // T13
    assertThat(substringsBetween("abc", "a", "c"))
      .isEqualTo(new String[] {"b"}); // T14
    assertThat(substringsBetween("abcabc", "a", "c"))
      .isEqualTo(new String[] {"b", "b"}); // T15
  }

  @Test
  void openAndCloseTagsOfDifferentSizes() {
    assertThat(substringsBetween("aabcc", "xx", "yy")).isEqualTo(null); // T16
    assertThat(substringsBetween("aabcc", "aa", "yy")).isEqualTo(null); // T17
    assertThat(substringsBetween("aabcc", "xx", "cc")).isEqualTo(null); // T18
    assertThat(substringsBetween("aabbcc", "aa", "cc"))
      .isEqualTo(new String[] {"bb"}); // T19
    assertThat(substringsBetween("aabbccaaeecc", "aa", "cc"))
      .isEqualTo(new String[] {"bb", "ee"}); // T20
  }

  @Test
  void noSubstringBetweenOpenAndCloseTags() {
    assertThat(substringsBetween("aabb", "aa", "bb"))
      .isEqualTo(new String[] {""}); // T21
  } 
}
