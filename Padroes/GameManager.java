package Padroes;

import Mapas.Tabuleiro;

import java.util.Scanner;

public class GameManager {

    private static GameManager instancia;
    private Scanner teclado;

    private GameManager() {
        teclado = new Scanner(System.in);
    }

    public static GameManager getInstance() {
        if (instancia == null) {
            instancia = new GameManager();
        }
        return instancia;
    }

    public void iniciar() {
        System.out.println("Escolha a dificuldade facil ou dificil: ");
        String escolha = teclado.nextLine();

        TabuleiroFactory fabrica = new TabuleiroFactory();
        Tabuleiro mapaEscolhido = fabrica.criar(escolha);

        if (mapaEscolhido != null) {
            mapaEscolhido.montar();
            jogar(mapaEscolhido);
        } else {
            System.out.println("ERRO 404(Você não sabe ler?)");
        }
    }

    private void jogar(Tabuleiro mapa) {
        boolean jogando = true;

        while (jogando) {
            mapa.imprimir();

            int linha = -1;
            int coluna = -1;

            try {
                System.out.println("\nDigite a LINHA (0 a " + (mapa.getTamanho() - 1) + "): ");
                linha = Integer.parseInt(teclado.nextLine());

                System.out.println("Digite a COLUNA (0 a " + (mapa.getTamanho() - 1) + "): ");
                coluna = Integer.parseInt(teclado.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("\n Você precisa digitar alguma coisa...");
                continue;
            }

            if (linha < 0 || linha >= mapa.getTamanho() || coluna < 0 || coluna >= mapa.getTamanho()) {
                System.out.println("\n ... Só vai de 0 a " + (mapa.getTamanho() - 1) + ". Tenta de novo.");
                continue;
            }

            boolean explodiu = mapa.revelar(linha, coluna);

            if (explodiu) {
                mapa.imprimir();
                System.out.println("\n BOOM! It's over, não sobrou nada.");
                jogando = false;
            } else if (mapa.verificarVitoria()) {
                mapa.imprimir();
                System.out.println("\n PARABÉNS! Você revelou todos os espaços seguros!");
                jogando = false;
            } else {
                System.out.println("\n Aqui não tem nada, vamos continuar....");
            }
        }
    }
}
