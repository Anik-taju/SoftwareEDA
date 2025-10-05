import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin implements ActionListener{

    // ==== TELA PRINCIPAL ====
    private JFrame main;

    // ==== PAINÉIS ====
    private JPanel topPanel;
    private JPanel inputPanel;
    private JPanel buttonPanel;

    // ==== CAMPOS ====
    private JTextField textField;

    // ==== LISTA ====

    // ==== BOTÕES ====
    private JButton addButton;
    private JButton searchButton;
    private JButton removeButton;
    private JButton logoutButton;
    
	private String usuario;
	private String senha;
	
    public Admin(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
        instanciar();
        Layouts();
        Funcao();
        Fontes();
        Cores();
        Accao();
        main.setVisible(true);
    }
    
    // ==== CONSTRUTOR ====
    public Admin() {
    	instanciar();
    	main.setVisible(true);
    }

    // ==== INICIALIZAÇÃO DE COMPONENTES ====
    public void instanciar() {
        main = new JFrame("Painel do Administrador");

        topPanel = new JPanel(new GridLayout(2, 1));
        inputPanel = new JPanel();
        buttonPanel = new JPanel();

        textField = new JTextField(20);

        addButton = new JButton("Adicionar");
        searchButton = new JButton("Buscar");
        removeButton = new JButton("Remover");
        logoutButton = new JButton("Sair");
    }

    // ==== CONFIGURAÇÃO DO FRAME ====
    public void Layouts() {

        main.setLayout(new BorderLayout());
    }

    // ==== ORGANIZAÇÃO DOS COMPONENTES ====
    public void Funcao() {
        inputPanel.add(new JLabel("Texto:"));
        inputPanel.add(textField);

        topPanel.add(inputPanel);

        buttonPanel.add(addButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(logoutButton);

        topPanel.add(buttonPanel);

        main.add(topPanel, BorderLayout.NORTH);
        
        main.setSize(500, 400);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setLocationRelativeTo(null);
    }

    // ==== FONTES ====
    public void Fontes() {
        Font fonte = new Font("Arial", Font.PLAIN, 14);
        textField.setFont(fonte);
        addButton.setFont(fonte);
        searchButton.setFont(fonte);
        removeButton.setFont(fonte);
        logoutButton.setFont(fonte);
    }

    // ==== CORES ====
    public void Cores() {
        topPanel.setBackground(Color.LIGHT_GRAY);
        inputPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setBackground(Color.GRAY);
    }

    public void Accao() {
        this.addButton.addActionListener(this);
        this.searchButton.addActionListener(this);
        this.removeButton.addActionListener(this);
        this.logoutButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.addButton) {
        	main.dispose();
        	Funcionario funcionario = new Funcionario();
        	
        } else if (e.getSource() == this.searchButton) {
            // ação do botão buscar
        	
        }
        else if (this.usuario.equalsIgnoreCase("AdminAnik") && this.senha.equalsIgnoreCase("123Anik")) {
            if(e.getSource() == this.removeButton) {
            	JOptionPane.showMessageDialog(null, "Voce e um administrador");
            }
        }
        else if(e.getSource() == this.removeButton) {
        	//por Opcao remover Aqui!!!
        }

    }

    // ==== MAIN ====
    public static void main(String[] args) {
        new Admin();
    }
}
