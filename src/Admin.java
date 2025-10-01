import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Admin extends JFrame {

    private JTextField textField;
    private DefaultListModel<String> itemListModel;
    private JList<String> itemList;

    public Admin() {
        setTitle("Painel do Administrador");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(2, 1));

                JPanel inputPanel = new JPanel();
        textField = new JTextField(20);
        inputPanel.add(new JLabel("Texto:"));
        inputPanel.add(textField);
        topPanel.add(inputPanel);

        
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Adicionar");
        JButton searchButton = new JButton("Buscar");
        JButton editButton = new JButton("Editar");
        JButton removeButton = new JButton("Remover");
        JButton logoutButton = new JButton("Sair");

        
        addButton.addActionListener(this::handleAdd);
        searchButton.addActionListener(this::handleSearch);
        editButton.addActionListener(this::handleEdit);
        removeButton.addActionListener(this::handleRemove);
        logoutButton.addActionListener(this::handleLogout);

        buttonPanel.add(addButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(editButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(logoutButton);
        topPanel.add(buttonPanel);

        add(topPanel, BorderLayout.NORTH);

        
        itemListModel = new DefaultListModel<>();
        itemList = new JList<>(itemListModel);
        add(new JScrollPane(itemList), BorderLayout.CENTER);
    }



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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Admin adminWindow = new Admin();
            adminWindow.setVisible(true);
        });
    }
}