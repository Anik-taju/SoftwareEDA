
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
    
	String cArquivo = "src\\Salvar\\Estudante.txt";
	
	public BackFuncionario() {}
	public BackFuncionario(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
		
		Ler(usuario, senha);
		Escrever(usuario, senha);
	}
	
	public void Escrever(String usuario, String senha) {
        boolean acresArquivo = true;
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(cArquivo, acresArquivo))) {
            escritor.write(usuario + "," + senha);
            escritor.newLine();
            System.out.println("Usuário salvo com sucesso no ficheiro!");
        } catch (Exception erro) {
            System.out.println("Houve um erro na gravação. Tente novamente.");
        }
    }
	
    public boolean Ler(String usuario, String senha) {
        try (BufferedReader leitor = new BufferedReader(new FileReader(cArquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                // Separar usuario e senha da linha
                String[] dados = linha.split(",");
                if (dados.length == 2) {
                    String usuarioArquivo = dados[0].trim();
                    String senhaArquivo = dados[1].trim();

                    if (usuario.equalsIgnoreCase(usuarioArquivo) && senha.equals(senhaArquivo)) {
                        System.out.println("Login encontrado!");
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
