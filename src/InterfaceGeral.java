public interface InterfaceGeral {
    
    // Adiciona elemento em uma posição específica
    void adicinaPosicao(int posicao, Cliente elemento);

    // Adiciona elemento no fim da lista
    void adicionaFim(Cliente elemento);

    // Adiciona elemento no início da lista
    void adicionaInicio(Cliente elemento);

    // Verifica se a lista contém o elemento
    boolean contem(Cliente elemento);

    // Retorna o elemento na posição indicada
    String pegaPosicao(Cliente elemento);

    // Remove o último elemento
    void removeFim();

    // Remove o primeiro elemento
    void removeInicio();

    // Remove elemento em posição específica
    void removePosicao(int posicao);
}
