import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Funcionario extends JFrame implements ActionListener {

    // Painéis
    private JPanel panel1; // painel do formulário
    private JPanel panelBotoes;
    private JPanel panelBusca;

    // Labels
    private JLabel Titulo;

    // Campos de formulário
    private JTextField txtNome;
    private JComboBox<String> comboSexo;
    private JTextField txtIdade;
    private JTextField txtAltura;
    private JTextField txtBairro;
    private JTextField txtNaturalidade;
    private JTextField txtNacionalidade;
    private JTextField txtDataNasc;
    private JComboBox<String> comboDocumento;
    private JTextField txtNumDocumento;
    private JTextField txtBuscar;

    // Botões
    private JButton btnAdicionar;
    private JButton btnLogout;
    private JButton btnBuscar;

    public Funcionario() {
        instanciar();
        Layouts();
        Funcao();
        Fontes();
        Cores();
        Accao();
        setVisible(true);
    }

    public void instanciar() {
        setTitle("Tela Funcionário");
        setSize(600, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Painéis
        panel1 = new JPanel();
        panelBotoes = new JPanel();
        panelBusca = new JPanel();

        // Título
        Titulo = new JLabel("Cadastro de Funcionário");

        // Campos
        txtNome = new JTextField(15);
        comboSexo = new JComboBox<>(new String[]{"Masculino", "Feminino", "Outro"});
        txtIdade = new JTextField(15);
        txtAltura = new JTextField(15);
        txtBairro = new JTextField(15);
        txtNaturalidade = new JTextField(15);
        txtNacionalidade = new JTextField(15);
        txtDataNasc = new JTextField(15);
        comboDocumento = new JComboBox<>(new String[]{"BI", "Carta de Condução", "Cartão de Eleitor", "Passaporte"});
        txtNumDocumento = new JTextField(15);
        txtBuscar = new JTextField(10);

        // Botões
        btnAdicionar = new JButton("Adicionar");
        btnLogout = new JButton("Logout");
        btnBuscar = new JButton("Buscar");
    }

    public void Layouts() {
        setLayout(new BorderLayout(10, 10));
        panel1.setLayout(new GridLayout(11, 2, 10, 10)); // 11 linhas, 2 colunas
        panelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBusca.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
    }

    public void Funcao() {
        // Adicionando campos ao panel1 (formulário)
        panel1.add(new JLabel("Nome:"));
        panel1.add(txtNome);

        panel1.add(new JLabel("Sexo:"));
        panel1.add(comboSexo);

        panel1.add(new JLabel("Idade:"));
        panel1.add(txtIdade);

        panel1.add(new JLabel("Altura:"));
        panel1.add(txtAltura);

        panel1.add(new JLabel("Bairro:"));
        panel1.add(txtBairro);

        panel1.add(new JLabel("Naturalidade:"));
        panel1.add(txtNaturalidade);

        panel1.add(new JLabel("Nacionalidade:"));
        panel1.add(txtNacionalidade);

        panel1.add(new JLabel("Data Nascimento:"));
        panel1.add(txtDataNasc);

        panel1.add(new JLabel("Tipo Documento:"));
        panel1.add(comboDocumento);

        panel1.add(new JLabel("Número Documento:"));
        panel1.add(txtNumDocumento);

        // Busca
        panelBusca.add(new JLabel("Buscar Funcionário:"));
        panelBusca.add(txtBuscar);
        panelBusca.add(btnBuscar);

        // Botoes
        panelBotoes.add(btnAdicionar);
        panelBotoes.add(btnLogout);

        // Adicionando ao JFrame
        add(Titulo, BorderLayout.NORTH);
        add(panel1, BorderLayout.CENTER);
        add(panelBusca, BorderLayout.SOUTH);
        add(panelBotoes, BorderLayout.PAGE_END);
    }

    public void Fontes() {
        Titulo.setFont(new Font("Arial", Font.BOLD, 24));
    }

    public void Cores() {
        // Fundo
        panel1.setBackground(new Color(230, 230, 250));
        panelBotoes.setBackground(new Color(230, 230, 250));
        panelBusca.setBackground(new Color(230, 230, 250));
        getContentPane().setBackground(new Color(230, 230, 250));

        // Botões
        estilizarBotao(btnAdicionar);
        estilizarBotao(btnLogout);
        estilizarBotao(btnBuscar);
    }

    private void estilizarBotao(JButton botao) {
        botao.setBackground(new Color(70, 130, 180));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setPreferredSize(new Dimension(120, 35));
    }
    
    public void Accao() {
        btnAdicionar.addActionListener(this);
        btnLogout.addActionListener(this);
        btnBuscar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	BackFuncionario backF = new  BackFuncionario ();
    	
    	String Nome = txtNome.getText();
    	String Sexo = comboSexo.getSelectedItem().toString();
    	String Idade = txtIdade.getText();
    	String Altura = txtAltura.getText();
    	String Bairro = txtBairro.getText();
    	String Naturalidade = txtNaturalidade.getText();
    	String Nacionalidade = txtNacionalidade.getText();
    	String DataNascimento = txtDataNasc.getText();
    	String TipoDocumento = comboDocumento.getSelectedItem().toString();
    	String NumeroDocumento = txtNumDocumento.getText();

        if (e.getSource() == btnAdicionar) {
    	        // Adicionar
    	        if (Nome.isEmpty() || Sexo.isEmpty() || Idade.isEmpty() || Altura.isEmpty() || Bairro.isEmpty() || Naturalidade.isEmpty()) {
    	            JOptionPane.showMessageDialog(null, "Preencha Todos os campos.");
    	        } else {
    	        	 backF.Escrever( Nome, Sexo, Idade, Altura,Bairro, Naturalidade, Nacionalidade, DataNascimento, TipoDocumento, NumeroDocumento);
    		         JOptionPane.showMessageDialog(null, "Estudante Adicionado com sucesso");
    	        }
        } else if (e.getSource() == btnLogout) {
        	dispose();
        	Admin admin = new Admin();
        } else if (e.getSource() == btnBuscar) {
            String busca = txtBuscar.getText();
            JOptionPane.showMessageDialog(this, "Buscar: " + busca);
        }
    }

    public static void main(String[] args) {
        new Funcionario();
    }
}
