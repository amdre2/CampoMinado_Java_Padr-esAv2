import Padrões.GameManager;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Bem vindo ao Campo Seguro :) ---");

        GameManager jogo = GameManager.getInstance();
        jogo.iniciar();
    }
}