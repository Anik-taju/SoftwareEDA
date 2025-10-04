// File: Identificacao.java
import java.util.Vector;

public class Identificacao extends Estudante implements InterfaceGeral {
    private int id;
    private Vector<Estudante> lista = new Vector<>();

    public Identificacao(String nome, int idade, int dataDeRegistro, int dataDeNascimento, String sexo,
                         String bI, String bairro, String curso, String nacionalidade, String naturalidade, int id) {
        super(nome, idade, dataDeRegistro, dataDeNascimento, sexo, bI, bairro, curso, nacionalidade, naturalidade);
        this.id = id;
    }

    public Vector<Estudante> getLista() {
        return lista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void adicinaPosicao(int posicao, Estudante elemento) {
        lista.add(posicao, elemento);
    }

    @Override
    public void adicionaFim(Estudante elemento) {
        lista.add(elemento);
    }

    @Override
    public void adicionaInicio(Estudante elemento) {
        lista.add(0, elemento);
    }

    @Override
    public boolean contem(Estudante elemento) {
        if (elemento == null) return false;
        return lista.contains(elemento);
    }

    @Override
    public String pegaPosicao(Estudante elemento) {
        if (elemento == null) {
            return "⚠️ Estudante inválido (nulo).";
        }
        int posicao = lista.indexOf(elemento);
        if (posicao == -1) {
            return "❌ Estudante não encontrado na lista.";
        }
        return "✅ Estudante encontrado na posição: " + posicao;
    }

    @Override
    public void removeFim() {
        if (!lista.isEmpty()) {
            lista.remove(lista.size() - 1);
        }
    }

    @Override
    public void removeInicio() {
        if (!lista.isEmpty()) {
            lista.remove(0);
        }
    }

    @Override
    public void removePosicao(int posicao) {
        if (posicao >= 0 && posicao < lista.size()) {
            lista.remove(posicao);
        }
    }
}
