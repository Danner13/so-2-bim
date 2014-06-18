/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabso2;

import java.util.Arrays;

/**
 *
 * @author Alexandre
 */
public class MMU {

    private int p;
    private int d;

    public MMU() {
    }

    public void traduzirlinha(String linha) {
        String P = linha.substring(0, 5); //Número da página
        String D = linha.substring(5, 8); //Deslocamento
        String RW = linha.substring(9, 10); //Leitura ou escrita

        //convertendo hexadecimal para decimal
        int valor = 0;
        int posicaoCaractere = -1;
        char[] hexa = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        // soma ao valor final o dígito binário da posição * 16 elevado ao contador da posição (começa em 0)
        for (int i = P.length(); i > 0; i--) {
            posicaoCaractere = Arrays.binarySearch(hexa, P.charAt(i - 1));
            valor += posicaoCaractere * Math.pow(16, (P.length() - i));
        }
        p = valor;

        valor = 0;
        posicaoCaractere = -1;
        for (int i = D.length(); i > 0; i--) {
            posicaoCaractere = Arrays.binarySearch(hexa, D.charAt(i - 1));
            valor += posicaoCaractere * Math.pow(16, (D.length() - i));
        }
        d = valor;
        System.out.println(d);
    }

}
