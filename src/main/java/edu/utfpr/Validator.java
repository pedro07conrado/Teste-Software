package edu.utfpr;
public class Validator {
    
    /**
     * Verifica se uma string contém um identificador válido em 'Silly Pascal'.
     * Regras:
     * 1. Deve começar com uma letra e conter apenas letras ou dígitos
     * 2. Deve ter no mínimo 1 caractere e no máximo 6 caracteres de comprimento
     * 
     * @param s string a ser validada
     * @return true se a string é um identificador válido, false caso contrário
     */
    public boolean validateIdentifier(String s) {
        // Implementação original com bugs
        char achar;
        boolean valid_id = false;
        achar = s.charAt(0);
        valid_id = ((achar >= 'A') && (achar <= 'Z')) || ((achar >= 'a') && (achar <= 'z'));

        if (s.length() > 1) {
            achar = s.charAt(1);
            int i = 1;
            while (i < s.length() - 1) {
                achar = s.charAt(i);
                if (((achar >= 'A') && (achar <= 'Z')) || ((achar >= 'a') && (achar <= 'z')) || ((achar >= '0') && (achar <= '9'))) {
                    valid_id = false;
                }
                i++;
            }
        }
        if (valid_id && (s.length() >= 1) && (s.length() < 6))
            return true;
        else
            return false;
    }
    
    /**
     * Versão corrigida do método validateIdentifier
     */
    public boolean validateIdentifierFixed(String s) {
        // Verificação para string null ou vazia
        if (s == null || s.length() == 0) {
            return false;
        }
        
        char achar = s.charAt(0);
        boolean valid_id = ((achar >= 'A') && (achar <= 'Z')) || ((achar >= 'a') && (achar <= 'z'));
        
        if (valid_id) {
            // Verifica os demais caracteres
            for (int i = 1; i < s.length(); i++) {
                achar = s.charAt(i);
                if (!(((achar >= 'A') && (achar <= 'Z')) || 
                      ((achar >= 'a') && (achar <= 'z')) || 
                      ((achar >= '0') && (achar <= '9')))) {
                    valid_id = false;
                    break;
                }
            }
        }
        
        // Verifica o comprimento
        return valid_id && (s.length() >= 1) && (s.length() <= 6);
    }
}