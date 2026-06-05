import Padroes.GameManager;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Bem vindo ao Campo Minado :) ---");

        GameManager jogo = GameManager.getInstance();
        jogo.iniciar();
    }
}