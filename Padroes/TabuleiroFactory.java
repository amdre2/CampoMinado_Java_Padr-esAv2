package Padroes;

import Mapas.ModoDificil;
import Mapas.ModoFacil;
import Mapas.Tabuleiro;

public class TabuleiroFactory {

    public Tabuleiro criar(String escolha) {

        if (escolha.equalsIgnoreCase("facil")) {
            return new ModoFacil();
        }
        else if (escolha.equalsIgnoreCase("dificil")) {
            return new ModoDificil();
        }

        return null;
    }
}