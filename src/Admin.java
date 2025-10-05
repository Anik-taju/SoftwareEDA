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
    private JButton editButton;
    private JButton removeButton;
    private JButton logoutButton;

    // ==== CONSTRUTOR ====
    public Admin() {
        instanciar();
        Layouts();
        Funcao();
        Fontes();
        Cores();
        Accao();
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
        editButton = new JButton("Editar");
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
        buttonPanel.add(editButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(logoutButton);

        topPanel.add(buttonPanel);

        main.add(topPanel, BorderLayout.NORTH);
        main.setVisible(true);
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
        editButton.setFont(fonte);
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
        this.editButton.addActionListener(this);
        this.removeButton.addActionListener(this);
        this.logoutButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	
        if (e.getSource() == this.addButton) {
        	Funcionario funcionario = new Funcionario();
        } else if (e.getSource() == this.searchButton) {
            // ação do botão buscar
        } else if (e.getSource() == this.editButton) {
            // ação do botão editar
        } else if (e.getSource() == this.removeButton) {
            // ação do botão remover
        } else if (e.getSource() == this.logoutButton) {
            // ação do botão sair
        }
    }

    // ==== MAIN ====
    public static void main(String[] args) {
        new Admin();
    }
}
