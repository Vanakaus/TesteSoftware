package edu.utfpr;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LeftPadTest {


  // ================== Testes Baseados em Especificação ==================
  @Test
  void testeNull() {

    // T01: Testa se a string é nula
    String result = LeftPad.pad(null, 5, " ");
    assertThat(result).isEqualTo(null);
  }


  @Test
  void testeSize() {

    // T02: Teste str vazio e tamanho menor que 0
    String result = LeftPad.pad("", -1, "-");
    assertThat(result).isEqualTo("");

    // T03: Teste str vazio e tamanho igual a 0
    result = LeftPad.pad("", 0, "-");
    assertThat(result).isEqualTo("");

    // T04: Teste str vazio e tamanho maior que 0
    result = LeftPad.pad("", 1, "-");
    assertThat(result).isEqualTo("-");

    // T05: Teste str não vazio e tamanho menor que 0
    result = LeftPad.pad("abc", -1, "-");
    assertThat(result).isEqualTo("abc");

    // T06: Teste str não vazio e tamanho igual a 0
    result = LeftPad.pad("abc", 0, "-");
    assertThat(result).isEqualTo("abc");

    // T07: Teste str não vazio e tamanho maior que 0
    result = LeftPad.pad("abc", 5, "-");
    assertThat(result).isEqualTo("--abc");
  }


  @Test
  void testePadStr() {

    // T08: Teste str vazio preenchido com espaços
    String result = LeftPad.pad("", 3, "");
    assertThat(result).isEqualTo("   ");

    // T09: Teste str vazio preenchido com null
    result = LeftPad.pad("", 3, null);
    assertThat(result).isEqualTo("   ");

    // T10: Teste str vazio preenchido com "-"
    result = LeftPad.pad("", 3, "-");
    assertThat(result).isEqualTo("---");

    // T11: Teste str vazio preenchido com "--"
    result = LeftPad.pad("", 3, "--");
    assertThat(result).isEqualTo("----");

    // T12: Teste str não vazio preenchido com espaços
    result = LeftPad.pad("abc", 5, "");
    assertThat(result).isEqualTo("  abc");

    // T13: Teste str não vazio preenchido com null
    result = LeftPad.pad("abc", 5, null);
    assertThat(result).isEqualTo("  abc");

    // T14: Teste str não vazio preenchido com "-"
    result = LeftPad.pad("abc", 5, "-");
    assertThat(result).isEqualTo("--abc");
    
    // T15: Teste str não vazio preenchido com "--"
    result = LeftPad.pad("abc", 6, "--");
    assertThat(result).isEqualTo("----abc");
  }



  // // ================== Testes Baseados em Estrutura ==================
  // @Test
  // void testeStrESize() {

  //   // T01: Testa se a string é nula e o tamanho é maior que size
  //   String result = LeftPad.pad(null, -3, "-");
  //   assertThat(result).isEqualTo(null);

  //   // T02: Testa se a string é nula e o tamanho é menor que size
  //   result = LeftPad.pad(null, 3, "-");
  //   assertThat(result).isEqualTo(null);

  //   // T03: Testa se a string é não nula e o tamanho é maior que size
  //   result = LeftPad.pad("abc", 1, "-");
  //   assertThat(result).isEqualTo("abc");
  // }

  // @Test
  // void testePadStrLength() {

  //   // T04: Testa se padStr é nulo e comprimento é 0
  //   String result = LeftPad.pad("", 3, null);
  //   assertThat(result).isEqualTo("   ");

  //   // T05: Testa se padStr é nulo e comprimento é diferente de 0
  //   result = LeftPad.pad("", 3, null);
  //   assertThat(result).isEqualTo("   ");

  //   // T06: Testa se padStr é não nula e o tamanho é menor que size
  //   result = LeftPad.pad("", 3, "");
  //   assertThat(result).isEqualTo("   ");
  // }

  // @Test
  // void testeStrLength() {

  //   // T06: Testa se size menos o comprimento da string é menor que 0
  //   String result = LeftPad.pad("abc", 1, "-");
  //   assertThat(result).isEqualTo("abc");

  //   // T07: Testa se size menos o comprimento da string é igual ou maior que 0
  //   result = LeftPad.pad("abc", 3, "-");
  //   assertThat(result).isEqualTo("abc");
  // }

}
