public class ListaLigada<T> implements InterfaceGeral<T> {

    private No<T> primeiro;
    private No<T> ultimo;
    private int tamanho;

    public ListaLigada() {
        this.tamanho = 0;
        this.primeiro = null;
        this.ultimo = null;
    }

    @Override
    public void adicionaInicio(T elemento) {
        No<T> novoNo = new No<>(elemento);
        if (primeiro == null) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            novoNo.setProximo(primeiro);
            primeiro = novoNo;
        }
        tamanho++;
    }

    @Override
    public void adicionaFim(T elemento) {
        No<T> novoNo = new No<>(elemento);
        if (primeiro == null) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            ultimo.setProximo(novoNo);
            ultimo = novoNo;
        }
        tamanho++;
    }

    @Override
    public void adicinaPosicao(int posicao, T elemento) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida: " + posicao);
        }

        if (posicao == 0) {
            adicionaInicio(elemento);
            return;
        }
        if (posicao == tamanho) {
            adicionaFim(elemento);
            return;
        }

        No<T> anterior = primeiro;
        for (int i = 0; i < posicao - 1; i++) {
            anterior = anterior.getProximo();
        }

        No<T> novoNo = new No<>(elemento);
        novoNo.setProximo(anterior.getProximo());
        anterior.setProximo(novoNo);
        tamanho++;
    }

    @Override
    public void removeInicio() {
        if (primeiro == null) return;

        primeiro = primeiro.getProximo();
        if (primeiro == null) {
            ultimo = null;
        }
        tamanho--;
    }

    @Override
    public void removeFim() {
        if (primeiro == null) return;

        if (primeiro == ultimo) {
            primeiro = null;
            ultimo = null;
        } else {
            No<T> atual = primeiro;
            while (atual.getProximo() != ultimo) {
                atual = atual.getProximo();
            }
            atual.setProximo(null);
            ultimo = atual;
        }
        tamanho--;
    }

    @Override
    public void removePosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida: " + posicao);
        }

        if (posicao == 0) {
            removeInicio();
            return;
        }

        No<T> anterior = primeiro;
        for (int i = 0; i < posicao - 1; i++) {
            anterior = anterior.getProximo();
        }

        anterior.setProximo(anterior.getProximo().getProximo());

        if (posicao == tamanho - 1) {
            ultimo = anterior;
        }

        tamanho--;
    }

    @Override
    public boolean contem(T elemento) {
        No<T> atual = primeiro;
        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    @Override
    public String pegaPosicao(T elemento) {
        No<T> atual = primeiro;
        int pos = 0;
        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                return "Elemento encontrado na posição: " + pos;
            }
            atual = atual.getProximo();
            pos++;
        }
        return "Elemento não encontrado.";
    }

    // Métodos auxiliares
    public int getTamanho() {
        return tamanho;
    }

    public void exibir() {
        No<T> atual = primeiro;
        System.out.print("[ ");
        while (atual != null) {
            System.out.print(atual.getElemento() + " ");
            atual = atual.getProximo();
        }
        System.out.println("]");
    }
}
