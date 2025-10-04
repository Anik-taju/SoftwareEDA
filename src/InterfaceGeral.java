// File: InterfaceGeral.java
public interface InterfaceGeral {
    // Adiciona elemento em uma posição específica
    void adicinaPosicao(int posicao, Estudante elemento);

    // Adiciona elemento no fim da lista
    void adicionaFim(Estudante elemento);

    // Adiciona elemento no início da lista
    void adicionaInicio(Estudante elemento);

    // Verifica se a lista contém o elemento
    boolean contem(Estudante elemento);

    // Retorna a posição do elemento (mensagem)
    String pegaPosicao(Estudante elemento);

    // Remove o último elemento
    void removeFim();

    // Remove o primeiro elemento
    void removeInicio();

    // Remove elemento em posição específica
    void removePosicao(int posicao);

    
}
