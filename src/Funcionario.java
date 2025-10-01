import javax.swing.*;
import java.awt.*;

public class Funcionario extends JFrame {

    public Funcionario(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("TelaFuncionario");
        setSize(700,700); 
        setLocationRelativeTo(null);
        setLayout(new GridLayout(14,2,5,5));

        add(new JLabel("Tela do Funcionario") );
        add(new JLabel(""));

        add(new JLabel("Nome"));
        add(new JTextField(20)); 

        add(new JLabel("Sexo"));
        JRadioButton masculino = new JRadioButton("Masculino");
        JRadioButton feminino = new JRadioButton("Feminino");
        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(masculino);
        grupoSexo.add(feminino);
        JPanel painelSexo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelSexo.add(masculino);
        painelSexo.add(feminino);
        add(painelSexo);

        add(new JLabel("Idade"));
        add(new JTextField(5)); 

        add(new JLabel("Altura"));
        add(new JTextField(5)); 

        add(new JLabel("Bairro"));
        add(new JTextField(15)); 

        add(new JLabel("Naturalidade"));
        add(new JTextField(15)); 

        add(new JLabel("Nacionalidade"));
        add(new JTextField(15)); 

        add(new JLabel("Data de Nascimento"));
        add(new JTextField(10)); 

        
        add(new JLabel("Documento de Identificacao"));

        JPanel painelDoc = new JPanel(new FlowLayout(FlowLayout.LEFT));
        String[] tiposDoc = {"BI", "Carta de Conducao", "Cartao de Eleitor", "Passaporte"};
        JComboBox<String> comboDoc = new JComboBox<>(tiposDoc);
        JTextField campoDoc = new JTextField(12); 
        painelDoc.add(comboDoc);
        painelDoc.add(campoDoc);
        add(painelDoc);
        add(new JLabel(""));

        JPanel painelFinal = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnLogout = new JButton("Logout");
        JTextField campoBuscar = new JTextField(12); 
        JButton btnBuscar = new JButton("Buscar");

        painelFinal.add(btnAdicionar);
        painelFinal.add(btnLogout);
        painelFinal.add(new JLabel("Pesquisar:"));
        painelFinal.add(campoBuscar);
        painelFinal.add(btnBuscar);

        add(painelFinal);
        

        setVisible(true);
    }

    public static void main(String[] args) {
        new Funcionario();
    }
}
