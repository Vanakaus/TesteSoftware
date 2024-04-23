package edu.utfpr;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CountWordsTest {
    @Test
    // Duas palavras que terminam em "s" (cães e gatos): esperamos que o programa retorne 2.
    void twoWordsEndingWithS() {
      int words = new CountWords().count("dogs cats");
      assertThat(words).isEqualTo(2);
    }
    
    @Test
    // Nenhuma palavra que termine em “s” ou “r” na string: o programa retorna 0.
    void noWordsAtAll() {
      int words = new CountWords().count("dog cat");
      assertThat(words).isEqualTo(0);
    }
}
