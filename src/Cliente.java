import javax.swing.JRadioButton;

public class Cliente {
    private String nome;
    private int idade;
    private int dataDeRegistro;
    private int dataDeNascimento;
    private JRadioButton sexo;
    private String BI;
    private String bairro;
    private String curso;
    private String nacionalidade;
    private String Naturalidade;
    
    public Cliente(String nome, int idade, int dataDeRegistro, int dataDeNascimento, JRadioButton sexo,
            String bI, String bairro, String curso, String nacionalidade, String naturalidade) {
        this.nome = nome;
        this.idade = idade;
        this.dataDeRegistro = dataDeRegistro;
        this.dataDeNascimento = dataDeNascimento;
        this.sexo = sexo;
        BI = bI;
        this.bairro = bairro;
        this.curso = curso;
        this.nacionalidade = nacionalidade;
        Naturalidade = naturalidade;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public int getDataDeRegistro() {
        return dataDeRegistro;
    }
    public void setDataDeRegistro(int dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }
    
    public int getDataDeNascimento() {
        return dataDeNascimento;
    }
    public void setDataDeNascimento(int dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
    public JRadioButton getSexo() {
        return sexo;
    }
    public void setSexo(JRadioButton sexo) {
        this.sexo = sexo;
    }
    public String getBI() {
        return BI;
    }
    public void setBI(String bI) {
        BI = bI;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getNacionalidade() {
        return nacionalidade;
    }
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    public String getNaturalidade() {
        return Naturalidade;
    }
    public void setNaturalidade(String naturalidade) {
        Naturalidade = naturalidade;
    }
    

}
