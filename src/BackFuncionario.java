
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BackFuncionario {
    private String Nome;
    private  String Sexo;
    private  String Idade;
    private  String Altura;
    private  String Bairro;
    private  String Naturalidade;
    private  String Nacionalidade;
    private  String DataNascimento;
    private  String TipoDocumento;
    private  String NumeroDocumento;
    private static int criarId = 0;
	String cArquivo = "src\\Salvar\\Estudante.txt";
	
	public BackFuncionario() {}
	public BackFuncionario(String Nome, String Sexo,String Idade, String Altura, String Bairro, String Naturalidade, String Nacionalidade, String DataNascimento, String TipoDocumento, String NumeroDocumento, int criarId) {
        this.Nome = Nome;
        this.Sexo = Sexo;
        this.Idade = Idade;
        this.Altura = Altura;
        this.Bairro = Bairro;
        this.Naturalidade = Naturalidade;
        this.Nacionalidade = Nacionalidade;
        this.DataNascimento = DataNascimento;
        this.TipoDocumento = TipoDocumento;
        this.NumeroDocumento = NumeroDocumento;
        this.criarId = criarId;
	}
	
	public void Escrever(String Nome, String Sexo,String Idade, String Altura, String Bairro, String Naturalidade, String Nacionalidade, String DataNascimento, String TipoDocumento, String NumeroDocumento) {	
        boolean acresArquivo = true;
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(cArquivo, acresArquivo))) {
        	criarId++;
            escritor.write( Nome + "," +
                    Sexo + "," +
                    Idade + "," +
                    Altura + "," +
                    Bairro + "," +
                    Naturalidade + "," +
                    Nacionalidade + "," +
                    DataNascimento + "," +
                    TipoDocumento + "," +
                    NumeroDocumento+ "; ID: " + criarId);
            escritor.newLine();
            System.out.println("Estudante salvo com sucesso no ficheiro!");
        } catch (Exception erro) {
            System.out.println("Houve um erro na gravação. Tente novamente.");
        }
    }
	
    public boolean Ler(String usuario) {
        try (BufferedReader leitor = new BufferedReader(new FileReader(cArquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                // Separar usuario e senha da linha
                String[] dados = linha.split(",");
                if (dados.length == 2) {
                    String Nomearq = dados[0].trim();
                    if (usuario.equalsIgnoreCase(Nomearq)) {
                        System.out.println("Estudante encontrado!");
                        return true;
                    }
                }
            }
        } catch (Exception erro) {
            System.out.println("Erro ao ler o arquivo: " + erro.getMessage());
        }
        return false;
    }
}
