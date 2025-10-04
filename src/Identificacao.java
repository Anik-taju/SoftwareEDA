import javax.swing.JRadioButton;
import java.util.Vector;

public class Identificacao extends Cliente implements InterfaceGeral {
    private int id;
    private Vector<Cliente> lista = new Vector<>();

    public Identificacao(String nome, int idade, int dataDeRegistro, int dataDeNascimento, JRadioButton sexo,
                         String bI, String bairro, String curso, String nacionalidade, String naturalidade, int id) {
        super(nome, idade, dataDeRegistro, dataDeNascimento, sexo, bI, bairro, curso, nacionalidade, naturalidade);
        this.id = id;
    }

    public Vector<Cliente> getLista() {
        return lista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void adicinaPosicao(int posicao, Cliente elemento) {
        lista.add(posicao, elemento);
    }

    @Override
    public void adicionaFim(Cliente elemento) {
        lista.add(elemento);
    }

    @Override
    public void adicionaInicio(Cliente elemento) {
        lista.add(0, elemento);
    }

    @Override
    public boolean contem(Cliente elemento) {
        if (elemento == null) return false;
        return lista.contains(elemento);
    }
    @Override
    public String pegaPosicao(Cliente elemento) {
    if (elemento == null) {
        return "⚠️ Cliente inválido (nulo).";
    }
    int posicao = lista.indexOf(elemento);
    if (posicao == -1) {
        return "❌ Cliente não encontrado na lista.";
    }
    return "✅ Cliente encontrado na posição: " + posicao;
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
