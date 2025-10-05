public interface InterfaceGeral<T> {
    void adicionaInicio(T elemento);
    void adicionaFim(T elemento);
    void adicinaPosicao(int posicao, T elemento);
    void removeInicio();
    void removeFim();
    void removePosicao(int posicao);
    boolean contem(T elemento);
    String pegaPosicao(T elemento);
}
