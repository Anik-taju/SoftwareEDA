import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Admin extends JFrame {

    private JTextField textField;
    private DefaultListModel<String> itemListModel;
    private JList<String> itemList;
    private JButton addButton;
    private JButton searchButton;
    private JButton editButton;
    private JButton removeButton;
    private JButton logoutButton;
    private JPanel buttonPanel;
    private JPanel topPanel;

    public Admin() {
        instanciar();
        Layouts();
        Funcao();
    }

    public void Layouts() {
        setTitle("Painel do Administrador");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    public void instanciar() {
        // Criar os paineis principais
        topPanel = new JPanel(new GridLayout(2, 1));
        JPanel inputPanel = new JPanel();

        // Campo de texto
        textField = new JTextField(20);
        inputPanel.add(new JLabel("Texto:"));
        inputPanel.add(textField);
        topPanel.add(inputPanel);

        // Botões
        buttonPanel = new JPanel();
        addButton = new JButton("Adicionar");
        searchButton = new JButton("Buscar");
        editButton = new JButton("Editar");
        removeButton = new JButton("Remover");
        logoutButton = new JButton("Sair");

        // Lista de itens
        itemListModel = new DefaultListModel<>();
        itemList = new JList<>(itemListModel);
    }

    public void Funcao() {
        // Adicionar listeners
        addButton.addActionListener(this::handleAdd);
        searchButton.addActionListener(this::handleSearch);
        editButton.addActionListener(this::handleEdit);
        removeButton.addActionListener(this::handleRemove);
        logoutButton.addActionListener(this::handleLogout);

        // Montar painel de botões
        buttonPanel.add(addButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(editButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(logoutButton);

        // Adicionar tudo ao frame
        topPanel.add(buttonPanel);
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(itemList), BorderLayout.CENTER);
    }

    // ==== AÇÕES ====

    private void handleAdd(ActionEvent e) {
        String text = textField.getText().trim();
        if (!text.isEmpty()) {
            itemListModel.addElement(text);
            textField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Digite um texto para adicionar.");
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
        } else {
            JOptionPane.showMessageDialog(this, "Digite um texto para buscar.");
        }
    }

    private void handleEdit(ActionEvent e) {
        int selectedIndex = itemList.getSelectedIndex();
        if (selectedIndex != -1) {
            String newText = textField.getText().trim();
            if (!newText.isEmpty()) {
                itemListModel.set(selectedIndex, newText);
                textField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Digite um novo texto para editar.");
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


    // ==== MAIN ====
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Admin adminWindow = new Admin();
            adminWindow.setVisible(true);
        });
    }
}
