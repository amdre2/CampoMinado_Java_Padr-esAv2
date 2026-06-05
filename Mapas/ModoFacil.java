package Mapas;

import java.util.Random;

public class ModoFacil implements Tabuleiro {

    private char[][] mapa;
    private boolean[][] revelado;

    @Override
    public void montar() {
        mapa = new char[5][5];
        revelado = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                mapa[i][j] = '-';
                revelado[i][j] = false;
            }
        }

        Random gerador = new Random();
        int bombas = 0;

        while (bombas < 3) {
            int linha = gerador.nextInt(5);
            int coluna = gerador.nextInt(5);

            if (mapa[linha][coluna] != '*') {
                mapa[linha][coluna] = '*';
                bombas++;
            }
        }
    }

    @Override
    public void imprimir() {
        System.out.println("\n--- Tabuleiro do Modo Fácil (5 por 5) ---");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (revelado[i][j]) {
                    System.out.print(mapa[i][j] + " ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public boolean revelar(int linha, int coluna) {
        revelado[linha][coluna] = true;
        return mapa[linha][coluna] == '*';
    }

    @Override
    public int getTamanho() {
        return 5;
    }

    @Override
    public boolean verificarVitoria() {
        int espacosRevelados = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (revelado[i][j]) {
                    espacosRevelados++;
                }
            }
        }

        return espacosRevelados == 22;
    }
}