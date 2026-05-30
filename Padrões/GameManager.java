package Padrões;

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
        System.out.println("Escolha a dificuldade facil ou dificil(relaxa não tem nada aqui!): ");
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

            System.out.println("\nDigite a LINHA (0 a " + (mapa.getTamanho() - 1) + "): ");
            int linha = Integer.parseInt(teclado.nextLine());

            System.out.println("Digite a COLUNA (0 a " + (mapa.getTamanho() - 1) + "): ");
            int coluna = Integer.parseInt(teclado.nextLine());

            boolean explodiu = mapa.revelar(linha, coluna);

            if (explodiu) {
                mapa.imprimir();
                System.out.println("\nBOOM! Não sobrou nada!");
                jogando = false;
            } else if (mapa.verificarVitoria()) {
                mapa.imprimir();
                System.out.println("\n🎉Acabou, não tem nada aqui exatamente como me prometeram");
                jogando = false;
            } else {
                System.out.println("\nAqui não tem nada.");
            }
        }
    }
}
