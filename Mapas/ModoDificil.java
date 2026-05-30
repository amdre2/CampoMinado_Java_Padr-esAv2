package Mapas;

import java.util.Random;

public class ModoDificil implements Tabuleiro {

    private char[][] mapa;
    private boolean[][] revelado;

    @Override
    public void montar() {
        mapa = new char[8][8];
        revelado = new boolean[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                mapa[i][j] = '-';
                revelado[i][j] = false;
            }
        }

        Random gerador = new Random();
        int bombas = 0;

        while (bombas < 10) {
            int linha = gerador.nextInt(8);
            int coluna = gerador.nextInt(8);

            if (mapa[linha][coluna] != '*') {
                mapa[linha][coluna] = '*';
                bombas++;
            }
        }
    }

    @Override
    public void imprimir() {
        System.out.println("\n--- Tabuleiro do Modo Difícil (8 por 8) ---");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
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
        return 8;
    }

    @Override
    public boolean verificarVitoria() {
        int espacosRevelados = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (revelado[i][j]) {
                    espacosRevelados++;
                }
            }
        }

        return espacosRevelados == 54;
    }
}