import javax.swing.*;
import java.awt.*;

public class Funcionario extends JFrame {

    public Funcionario() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tela Funcionario");
        setSize(600, 700);
        setLocationRelativeTo(null);

        // Fundo suave
        getContentPane().setBackground(new Color(230, 230, 250));

        // Layout principal centralizado
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8); // margem entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int linha = 0; // linha inicial

        // Título centralizado
        JLabel titulo = new JLabel("Funcionário", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = linha++;
        gbc.gridwidth = 2;
        add(titulo, gbc);

        gbc.gridwidth = 1; // resetar

        // Nome
        gbc.gridx = 0;
        gbc.gridy = linha;
        add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        JTextField txtNome = new JTextField(15);
        add(txtNome, gbc);
        linha++;

        // Sexo (ComboBox)
        gbc.gridx = 0;
        gbc.gridy = linha;
        add(new JLabel("Sexo:"), gbc);

        gbc.gridx = 1;
        JComboBox<String> comboSexo = new JComboBox<>(new String[]{"Masculino", "Feminino", "Outro"});
        add(comboSexo, gbc);
        linha++;

        // Idade
        gbc.gridx = 0;
        gbc.gridy = linha;
        add(new JLabel("Idade:"), gbc);

        gbc.gridx = 1;
        JTextField txtIdade = new JTextField(15);
        add(txtIdade, gbc);
        linha++;

        // Altura
        gbc.gridx = 0;
        gbc.gridy = linha;
        add(new JLabel("Altura:"), gbc);

        gbc.gridx = 1;
        JTextField txtAltura = new JTextField(15);
        add(txtAltura, gbc);
        linha++;

        // Bairro
        gbc.gridx = 0;
        gbc.gridy = linha;
        add(new JLabel("Bairro:"), gbc);

        gbc.gridx = 1;
        JTextField txtBairro = new JTextField(15);
        add(txtBairro, gbc);
        linha++;

        // Naturalidade
        gbc.gridx = 0;
        gbc.gridy = linha;
        add(new JLabel("Naturalidade:"), gbc);

        gbc.gridx = 1;
        JTextField txtNaturalidade = new JTextField(15);
        add(txtNaturalidade, gbc);
        linha++;

        // Nacionalidade
        gbc.gridx = 0;
        gbc.gridy = linha;
        add(new JLabel("Nacionalidade:"), gbc);

        gbc.gridx = 1;
        JTextField txtNacionalidade = new JTextField(15);
        add(txtNacionalidade, gbc);
        linha++;

        // Data de nascimento
        gbc.gridx = 0;
        gbc.gridy = linha;
        add(new JLabel("Data de Nascimento:"), gbc);

        gbc.gridx = 1;
        JTextField txtDataNasc = new JTextField(15);
        add(txtDataNasc, gbc);
        linha++;

        // Documento (ComboBox + campo de texto)
        gbc.gridx = 0;
        gbc.gridy = linha;
        add(new JLabel("Tipo de Documento:"), gbc);

        gbc.gridx = 1;
        JComboBox<String> comboDoc = new JComboBox<>(new String[]{
                "BI", "Carta de Condução", "Cartão de Eleitor", "Passaporte"
        });
        add(comboDoc, gbc);
        linha++;

        gbc.gridx = 0;
        gbc.gridy = linha;
        add(new JLabel("Número Documento:"), gbc);

        gbc.gridx = 1;
        JTextField txtDocumento = new JTextField(15);
        add(txtDocumento, gbc);
        linha++;

        // Campo Buscar + Botão
        gbc.gridx = 0;
        gbc.gridy = linha;
        add(new JLabel("Buscar Funcionário:"), gbc);

        gbc.gridx = 1;
        JPanel painelBusca = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JTextField txtBuscar = new JTextField(10);
        JButton btnBuscar = new JButton("Buscar");
        estilizarBotao(btnBuscar);
        painelBusca.add(txtBuscar);
        painelBusca.add(btnBuscar);
        add(painelBusca, gbc);
        linha++;

        // Botões finais (Adicionar e Logout)
        gbc.gridx = 0;
        gbc.gridy = linha;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));

        JButton btnAdicionar = new JButton("Adicionar");
        estilizarBotao(btnAdicionar);

        JButton btnLogout = new JButton("Logout");
        estilizarBotao(btnLogout);

        painelBotoes.add(btnAdicionar);
        painelBotoes.add(btnLogout);

        add(painelBotoes, gbc);

        setVisible(true);
    }

    // Método para estilizar botões
    private void estilizarBotao(JButton botao) {
        botao.setBackground(new Color(70, 130, 180));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setPreferredSize(new Dimension(120, 35));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Funcionario::new);
    }
}
