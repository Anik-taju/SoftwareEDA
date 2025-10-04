// File: Estudante.java
public class Estudante {
    private String nome;
    private int idade;
    private int dataDeNascimento;
    private String sexo; // "Masculino", "Feminino"
    private String BI;
    private String bairro;
    private String curso;
    private String nacionalidade;
    private String naturalidade;

    public Estudante(String nome, int idade, int dataDeNascimento, String sexo,
            String bI, String bairro, String curso, String nacionalidade, String naturalidade) {
        this.nome = nome;
        this.idade = idade;
        this.dataDeNascimento = dataDeNascimento;
        this.sexo = sexo;
        BI = bI;
        this.bairro = bairro;
        this.curso = curso;
        this.nacionalidade = nacionalidade;
        this.naturalidade = naturalidade;
    }

    // Getters 
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
   
    public int getDataDeNascimento() { return dataDeNascimento; }
    public String getSexo() { return sexo; }
    public String getBI() { return BI; }
    public String getBairro() { return bairro; }
    public String getCurso() { return curso; }
    public String getNacionalidade() { return nacionalidade; }
    public String getNaturalidade() { return naturalidade; }
}
