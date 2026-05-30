public interface Tabuleiro {
    void montar();
    void imprimir();
    boolean revelar(int linha, int coluna);
    int getTamanho();
    boolean verificarVitoria();
}
