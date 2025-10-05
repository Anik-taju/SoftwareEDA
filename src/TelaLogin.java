import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TelaLogin implements ActionListener  {
	//Tela Principal
	private JFrame main;
	
	//Telas
	private JPanel tela1;
	private JPanel tela2;
	private JPanel tela3;
	private JPanel tela4;
	private JPanel tela5;
	private JPanel telaArm1;
	private JPanel telaArm2;
	
	//Titulo
	private JLabel Titulo;
	private JLabel Titulo2;
	
	//butoes
	private JButton login;
	private JButton singUp;
	
	//Areas de texto
	private JLabel user;
	private JLabel pass;
	private JTextField userSpace;
	private JPasswordField pasSpace;
	
	//Centralizador
	private GridBagConstraints centro;
	
	//imagem
    private ImageIcon image;
    private ImageIcon FotoLogin;
    private JLabel img;
	
	public TelaLogin() {
		instanciar();
		Layouts();
		Funcao();
		Fontes();
		Cores();
		Accao();
	}
	
	public void instanciar() {
		main = new JFrame("Tela Login");
		
		Titulo = new JLabel("Login");
		Titulo2 = new JLabel("Seja Bem Vindo!");
		
		tela1 = new JPanel();
		tela2 = new JPanel();
		tela3 = new JPanel();
		tela4 = new JPanel();
		tela5 = new JPanel();
		telaArm1 = new JPanel();
		telaArm2 = new JPanel();
		
		user = new JLabel("Usuario: ");
		pass = new JLabel("Senha: ");
		userSpace = new JTextField(15);
		pasSpace = new JPasswordField(15);
		
		login = new JButton("Login");
		singUp= new JButton("Sing up");
		
		centro = new GridBagConstraints();
		
		image = new ImageIcon("src\\Fotos\\ISUTC.png");
		FotoLogin = new ImageIcon(image.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
		img = new JLabel(FotoLogin);
	}
	
	public void Layouts() {
		tela1.setLayout(new GridBagLayout());
		telaArm1.setLayout(new GridLayout(7, 1));
		telaArm2.setLayout(new GridLayout(2, 1));
		tela5.setLayout(new GridLayout(1, 2));
	}
	
	public void Funcao() {
		
		//tela de Login
		telaArm1.add(Titulo);
		telaArm1.add(user);
		telaArm1.add(userSpace);
		telaArm1.add(pass);
		telaArm1.add(pasSpace);
		telaArm1.add(tela3);
		telaArm1.setPreferredSize(new Dimension(400, 400));
		tela2.add(telaArm1);
		
		//Tela antes Login
		telaArm2.add(img);
		telaArm2.add(Titulo2);
		tela4.add(telaArm2);
		telaArm2.setPreferredSize(new Dimension(450, 250));
		
		//organizar Telas
		tela5.add(tela4);
		tela5.add(tela2);
		tela3.add(login);
		tela3.add(singUp);
		
		//Centralizar Login e wallpaper
	    centro.gridx = 0;
	    centro.gridy = 0;
	    centro.weightx = 1;
	    centro.weighty = 1;
	    centro.anchor = GridBagConstraints.CENTER;
	    tela1.add(tela5, centro);
	    
	    //TiTulos
	    Titulo.setHorizontalAlignment(SwingConstants.CENTER);
	    Titulo2.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    //main
		main.add(tela1);
		main.setSize(400, 350);
	    main.setLocationRelativeTo(null); 
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);
	}
	
	private void Fontes() {
		Titulo.setFont(new Font("Arial", Font.BOLD, 40));
		Titulo2.setFont(new Font("Arial", Font.BOLD, 40));
		user.setFont(new Font("Arial", Font.BOLD, 15));
		pass.setFont(new Font("Arial", Font.BOLD, 15));
		login.setFont(new Font("Arial", Font.BOLD, 15));
		singUp.setFont(new Font("Arial", Font.BOLD, 15));
		userSpace.setFont(new Font("Arial", Font.BOLD, 15));
	}
	
	public void Cores() {
		//botoes
	    login.setBackground(Color.decode("#3e8fd8"));
	    singUp.setBackground(Color.decode("#3e8fd8"));
	    
	    //texto
	    Titulo.setForeground(Color.decode("#3e8fd8"));
	    Titulo2.setForeground(Color.WHITE);
	    login.setForeground(Color.WHITE);
	    singUp.setForeground(Color.WHITE);
	    
	    //borda
	    tela2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY),BorderFactory.createEmptyBorder(0, 0, 0, 0)));
	    tela4.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY),BorderFactory.createEmptyBorder(-1, 0, 0, 0)));
	    userSpace.setBorder(BorderFactory.createEmptyBorder());
	    pasSpace.setBorder(BorderFactory.createEmptyBorder());
	    
	    //telas
	    tela4.setBackground(Color.decode("#AED6F1"));
	    telaArm2.setBackground(Color.decode("#AED6F1"));
	}
	
	public void Accao() {
		login.addActionListener(this);
		singUp.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    BackTelaLogin back = new BackTelaLogin();

	    String usuario = userSpace.getText();
	    String senha = new String(pasSpace.getPassword());

	    if (e.getSource() == login) {
	        // Login
	        if (usuario.isEmpty() || senha.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Preencha usuário e senha.");
	            
	        } else if(usuario.equalsIgnoreCase("AdminAnik") && senha.equalsIgnoreCase("123Anik")) {
	        	JOptionPane.showMessageDialog(null, "Login bem sucedido, Bem vindo Administrador");
	        	
	        }else if (back.Ler(usuario, senha)) {
	            JOptionPane.showMessageDialog(null, "Login bem sucedido");
	            
	        } else {
	            JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos ou nao registrados");
	        }
	    } else if (e.getSource() == singUp) {
	        // Sing up
	        if (usuario.isEmpty() || senha.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Preencha usuário e senha.");
	        } else {
	            back.Escrever(usuario, senha);
	            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
	        }
	    }
	}		
}
