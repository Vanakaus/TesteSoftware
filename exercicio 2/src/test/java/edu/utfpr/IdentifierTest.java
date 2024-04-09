package edu.utfpr;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



@DisplayName("Identifier")
public class IdentifierTest {

    Identifier identifier = new Identifier();


    @Test
    @DisplayName("Teste 1 - null")
    public void testIdentifierNull() {
        assertEquals(identifier.validateIdentifier(null), false);
    }


    @Test
    @DisplayName("Teste 2 - vazio")
    public void testIdentifierVazio() {
        assertEquals(identifier.validateIdentifier(""), false);
    }


    @Test
    @DisplayName("Teste 3 - 1 caractere")
    public void testIdentifier1Caractere() {
        
        // Teste com letras
        assertEquals(identifier.validateIdentifier("a"), true);
        assertEquals(identifier.validateIdentifier("A"), true);

        // Teste com caracteres diferentes de letras
        assertEquals(identifier.validateIdentifier("1"), false);
        assertEquals(identifier.validateIdentifier("@"), false);
        assertEquals(identifier.validateIdentifier(" "), false);
    }


    @Test
    @DisplayName("Teste 4 - 6 caracteres")
    public void testIdentifier6Caracteres() {

        // Teste com apenas letras
        assertEquals(identifier.validateIdentifier("abcdef"), true);
        assertEquals(identifier.validateIdentifier("ABCDEF"), true);

        // Teste com letras e números
        assertEquals(identifier.validateIdentifier("a1b2c3"), true);
        assertEquals(identifier.validateIdentifier("A1B2C3"), true);
        assertEquals(identifier.validateIdentifier("a1B2c3"), true);

        // Teste com caracteres diferentes de letras e números
        assertEquals(identifier.validateIdentifier("A@B2C3"), false);
        assertEquals(identifier.validateIdentifier("a b c"), false);
    }


    @Test
    @DisplayName("Teste 5 - 7 caracteres")
    public void testIdentifier7Caracteres() {

        // Teste com apenas letras
        assertEquals(identifier.validateIdentifier("abcdefg"), false);
        assertEquals(identifier.validateIdentifier("ABCDEFG"), false);

        // Teste com letras e números
        assertEquals(identifier.validateIdentifier("a1b2c3d"), false);
        assertEquals(identifier.validateIdentifier("A1B2C3D"), false);
        assertEquals(identifier.validateIdentifier("a1B2c3d"), false);

        // Teste com caracteres diferentes de letras e números
        assertEquals(identifier.validateIdentifier("A@B2C3D"), false);
        assertEquals(identifier.validateIdentifier("a b c d"), false);
    }
}
