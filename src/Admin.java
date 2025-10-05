import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Admin extends JFrame implements ActionListener {
	
	//Campos de texto
	private JTextField textField;
	
	//Lista
	private DefaultListModel<String> itemListModel;
	private JList<String> itemList;
	
	//Painéis
	private JPanel painelTopo;
	private JPanel painelInput;
	private JPanel painelBotoes;
	
	//Botões
	private JButton addButton;
	private JButton searchButton;
	private JButton editButton;
	private JButton removeButton;
	private JButton logoutButton;
	
	public Admin() {
		instanciar();
		Layouts();
		Funcao();
		Fontes();
		Cores();
	}
	
	private void instanciar() {
		
		//painéis
		painelTopo = new JPanel(new GridLayout(2, 1));
		painelInput = new JPanel();
		painelBotoes = new JPanel();
		
		//campo de texto
		textField = new JTextField(20);
		
		//botões
		addButton = new JButton("Adicionar");
		searchButton = new JButton("Buscar");
		editButton = new JButton("Editar");
		removeButton = new JButton("Remover");
		logoutButton = new JButton("Sair");
		
		//lista
		itemListModel = new DefaultListModel<>();
		itemList = new JList<>(itemListModel);
	}
	
	private void Layouts() {
		setLayout(new BorderLayout());
		add(painelTopo, BorderLayout.NORTH);
		add(new JScrollPane(itemList), BorderLayout.CENTER);
	}
	
	private void Funcao() {
		
		//painel input
		painelInput.add(new JLabel("Texto:"));
		painelInput.add(textField);
		painelTopo.add(painelInput);
		
		//painel botões
		painelBotoes.add(addButton);
		painelBotoes.add(searchButton);
		painelBotoes.add(editButton);
		painelBotoes.add(removeButton);
		painelBotoes.add(logoutButton);
		painelTopo.add(painelBotoes);
		
		//ações
		addButton.addActionListener(this::handleAdd);
		searchButton.addActionListener(this::handleSearch);
		editButton.addActionListener(this::handleEdit);
		removeButton.addActionListener(this::handleRemove);
		logoutButton.addActionListener(this::handleLogout);
		
		setTitle("Painel do Administrador");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	private void Fontes() {
		Font fonte = new Font("Arial", Font.BOLD, 14);
		addButton.setFont(fonte);
		searchButton.setFont(fonte);
		editButton.setFont(fonte);
		removeButton.setFont(fonte);
		logoutButton.setFont(fonte);
		textField.setFont(fonte);
	}
	
	private void Cores() {
		Color azul = Color.decode("#3e8fd8");
		Color branco = Color.WHITE;
		
		addButton.setBackground(azul);
		searchButton.setBackground(azul);
		editButton.setBackground(azul);
		removeButton.setBackground(azul);
		logoutButton.setBackground(azul);
		
		addButton.setForeground(branco);
		searchButton.setForeground(branco);
		editButton.setForeground(branco);
		removeButton.setForeground(branco);
		logoutButton.setForeground(branco);
	}
	
	//Ações
	private void handleAdd(ActionEvent e) {
		String text = textField.getText().trim();
		if (!text.isEmpty()) {
			itemListModel.addElement(text);
			textField.setText("");
		}
	}
	
	private void handleSearch(ActionEvent e) {
		String searchText = textField.getText().trim();
		if (!searchText.isEmpty()) {
			for (int i = 0; i < itemListModel.size(); i++) {
				if (itemListModel.get(i).equalsIgnoreCase(searchText)) {
					itemList.setSelectedIndex(i);
					itemList.ensureIndexIsVisible(i);
					JOptionPane.showMessageDialog(this, "Item encontrado: " + searchText);
					return;
				}
			}
			JOptionPane.showMessageDialog(this, "Item não encontrado.");
		}
	}
	
	private void handleEdit(ActionEvent e) {
		int selectedIndex = itemList.getSelectedIndex();
		if (selectedIndex != -1) {
			String newText = textField.getText().trim();
			if (!newText.isEmpty()) {
				itemListModel.set(selectedIndex, newText);
				textField.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Selecione um item para editar.");
		}
	}
	
	private void handleRemove(ActionEvent e) {
		int selectedIndex = itemList.getSelectedIndex();
		if (selectedIndex != -1) {
			itemListModel.remove(selectedIndex);
		} else {
			JOptionPane.showMessageDialog(this, "Selecione um item para remover.");
		}
	}
	
	private void handleLogout(ActionEvent e) {
		int confirm = JOptionPane.showConfirmDialog(this, "Deseja realmente sair?", "Logout", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {}
	
}
