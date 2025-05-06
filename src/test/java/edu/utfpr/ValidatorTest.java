package edu.utfpr;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    
    private Validator validator;
    
    @BeforeEach
    public void setUp() {
        validator = new Validator();
    }
    
    // Casos de teste de exceção
    @Test
    public void testNullString() {
        // Verifica se o método lança NullPointerException para input null
        assertThrows(NullPointerException.class, () -> validator.validateIdentifier(null));
    }
    
    @Test
    public void testEmptyString() {
        // Verifica se string vazia é considerada inválida
        assertFalse(validator.validateIdentifier(""));
    }
    
    // Casos de teste para comprimento 1
    @Test
    public void testSingleLowercaseLetter() {
        // Verifica se uma única letra minúscula é válida
        assertTrue(validator.validateIdentifier("a"));
    }
    
    @Test
    public void testSingleUppercaseLetter() {
        // Verifica se uma única letra maiúscula é válida
        assertTrue(validator.validateIdentifier("A"));
    }
    
    @Test
    public void testSingleDigit() {
        // Verifica se um único dígito é inválido
        assertFalse(validator.validateIdentifier("1"));
    }
    
    @Test
    public void testSingleSpecialChar() {
        // Verifica se um único caractere especial é inválido
        assertFalse(validator.validateIdentifier("@"));
    }
    
    // Casos de teste para comprimento entre 2 e 6 com primeiro caractere válido
    @Test
    public void testLowercaseLetters() {
        // Verifica se string com apenas letras minúsculas é válida
        assertTrue(validator.validateIdentifier("abcde"));
    }
    
    @Test
    public void testUppercaseLetters() {
        // Verifica se string com apenas letras maiúsculas é válida
        assertTrue(validator.validateIdentifier("ABCDE"));
    }
    
    @Test
    public void testMixedCaseLetters() {
        // Verifica se string com letras maiúsculas e minúsculas é válida
        assertTrue(validator.validateIdentifier("aBcDe"));
    }
    
    @Test
    public void testLettersAndDigits() {
        // Verifica se string com letras e dígitos é válida
        assertTrue(validator.validateIdentifier("a1b2c"));
    }
    
    @Test
    public void testUppercaseLettersAndDigits() {
        // Verifica se string com letras maiúsculas e dígitos é válida
        assertTrue(validator.validateIdentifier("A1B2C"));
    }
    
    // Casos de teste para comprimento entre 2 e 6 com primeiro caractere inválido
    @Test
    public void testStartsWithDigit() {
        // Verifica se string que começa com dígito é inválida
        assertFalse(validator.validateIdentifier("1abcd"));
    }
    
    @Test
    public void testStartsWithSpecialChar() {
        // Verifica se string que começa com caractere especial é inválida
        assertFalse(validator.validateIdentifier("#abcd"));
    }
    
    // Casos de teste para comprimento entre 2 e 6 com caracteres inválidos
    @Test
    public void testContainsSpecialChar() {
        // Verifica se string que contém caractere especial é inválida
        assertFalse(validator.validateIdentifier("ab#cd"));
    }
    
    @Test
    public void testContainsSpace() {
        // Verifica se string que contém espaço é inválida
        assertFalse(validator.validateIdentifier("ab cd"));
    }
    
    // Casos de teste para valores limite
    @Test
    public void testMaximumValidLength() {
        // Verifica se string com comprimento máximo válido (6) é válida
        assertTrue(validator.validateIdentifier("abcdef"));
    }
    
    @Test
    public void testExceedingMaximumLength() {
        // Verifica se string com comprimento excedendo o máximo (7) é inválida
        assertFalse(validator.validateIdentifier("abcdefg"));
    }
    
    @Test
    public void testUpperCaseZ() {
        // Verifica se string com letra Z maiúscula é válida
        assertTrue(validator.validateIdentifier("Z"));
    }
    
    @Test
    public void testLowerCaseZ() {
        // Verifica se string com letra z minúscula é válida
        assertTrue(validator.validateIdentifier("z"));
    }
    
    @Test
    public void testDigitZero() {
        // Verifica se string com dígito 0 após letra é válida
        assertTrue(validator.validateIdentifier("a0"));
    }
    
    @Test
    public void testDigitNine() {
        // Verifica se string com dígito 9 após letra é válida
        assertTrue(validator.validateIdentifier("a9"));
    }
    
    // Casos de teste adicionais
    @Test
    public void testContainsUnderscore() {
        // Verifica se string que contém underscore é inválida
        assertFalse(validator.validateIdentifier("a_bc"));
    }
    
    @Test
    public void testContainsMathOperator() {
        // Verifica se string que contém operador matemático é inválida
        assertFalse(validator.validateIdentifier("ab+c"));
    }
    
    @Test
    public void testContainsTab() {
        // Verifica se string que contém tabulação é inválida
        assertFalse(validator.validateIdentifier("abc\t"));
    }
    
    @Test
    public void testMaxLengthMixedCase() {
        // Verifica se string com exatamente 6 caracteres misturados é válida
        assertTrue(validator.validateIdentifier("abCDeF"));
    }
}