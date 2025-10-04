import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Funcionario extends JFrame {

    // === Atributos ===
    private JTextField txtNome, txtIdade, txtAltura, txtBairro, txtNaturalidade, txtNacionalidade;
    private JTextField txtDataNasc, txtDocumento, txtBuscar;
    private JComboBox<String> comboSexo, comboDoc;
    private JButton btnAdicionar, btnBuscar, btnLogout;
    private JPanel painelBotoes, painelBusca;

    public Funcionario() {
        instanciar();
        Layouts();
        Funcao();
    }
    public void actionPerformed(ActionEvent e){
        String nome = txtNome.getText();
        String idade = txtIdade.getText();
        String altura = txtAltura.getText();
        String bairro = txtBairro.getText();
        String nacionalidade = txtNacionalidade.getText();
        String naturalidade = txtNaturalidade.getText();
        String dataNascimento = txtDataNasc.getText();
        String nrDoc = txtDocumento.getText();

    }

    // === Layout principal ===
    public void Layouts() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tela Inscricao");
        setSize(600, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(230, 230, 250));
        setLayout(new GridBagLayout());
    }

    // === Criação dos componentes ===
    public void instanciar() {
        // Campos de texto
        txtNome = new JTextField(15);
        txtIdade = new JTextField(15);
        txtAltura = new JTextField(15);
        txtBairro = new JTextField(15);
        txtNaturalidade = new JTextField(15);
        txtNacionalidade = new JTextField(15);
        txtDataNasc = new JTextField(15);
        txtDocumento = new JTextField(15);

        // Combos
        comboSexo = new JComboBox<>(new String[]{"Masculino", "Feminino", "Outro"});
    
        // Botões
        btnAdicionar = new JButton("Adicionar")
        btnLogout = new JButton("Logout");
        estilizarBotao(btnAdicionar);
        estilizarBotao(btnBuscar);
        estilizarBotao(btnLogout);

        // Painéis
        painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        painelBusca = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
    }

    // === Organização dos componentes na tela ===
    public void Funcao() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        int linha = 0;

        // Título
        JLabel titulo = new JLabel("Funcionário", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0; gbc.gridy = linha++; gbc.gridwidth = 2;
        add(titulo, gbc);
        gbc.gridwidth = 1;

        // Linhas de campos
        adicionarLinha(gbc, linha++, "Nome:", txtNome);
        adicionarLinha(gbc, linha++, "Sexo:", comboSexo);
        adicionarLinha(gbc, linha++, "Idade:", txtIdade);
        adicionarLinha(gbc, linha++, "Altura:", txtAltura);
        adicionarLinha(gbc, linha++, "Bairro:", txtBairro);
        adicionarLinha(gbc, linha++, "Naturalidade:", txtNaturalidade);
        adicionarLinha(gbc, linha++, "Nacionalidade:", txtNacionalidade);
        adicionarLinha(gbc, linha++, "Data de Nascimento:", txtDataNasc);
        adicionarLinha(gbc, linha++, "Número de BI", txtDocumento);

        

        // Painel de botões
        painelBotoes.add(btnAdicionar);
        painelBotoes.add(btnLogout);
        gbc.gridx = 0; gbc.gridy = linha; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        add(painelBotoes, gbc);
    }

    // === Método auxiliar para montar linhas ===
    private void adicionarLinha(GridBagConstraints gbc, int linha, String label, Component componente) {
        gbc.gridx = 0;
        gbc.gridy = linha;
        add(new JLabel(label), gbc);

        gbc.gridx = 1;
        add(componente, gbc);
    }

    // === Estilo dos botões ===
    private void estilizarBotao(JButton botao) {
        botao.setBackground(new Color(70, 130, 180));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setPreferredSize(new Dimension(120, 35));
    }

    // === MAIN ===
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Funcionario janela = new Funcionario();
            janela.setVisible(true);
        });
    }
}
