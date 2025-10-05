import java.awt.event.*;
import java.io.*;

public class BackTelaLogin implements ActionListener {
	private String usuario;
	private String senha;
	String cArquivo = "src\\Salvar\\Login.txt";
	
	public BackTelaLogin() {}
	public BackTelaLogin(String usuario, String senha) {
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

	
	@Override
	public void actionPerformed(ActionEvent e) {}
}
