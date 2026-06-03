package hust.soict.hedspi.aims.screen;

import java.awt.*;
import javax.swing.*;

import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {

    protected Store store;

    protected JTextField tfId;
    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;

    public AddItemToStoreScreen(Store store) {
        this.store = store;

        setTitle("Add Item");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(createForm());

        setVisible(true);
    }

    protected JPanel createForm() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("ID"));
        tfId = new JTextField();
        panel.add(tfId);

        panel.add(new JLabel("Title"));
        tfTitle = new JTextField();
        panel.add(tfTitle);

        panel.add(new JLabel("Category"));
        tfCategory = new JTextField();
        panel.add(tfCategory);

        panel.add(new JLabel("Cost"));
        tfCost = new JTextField();
        panel.add(tfCost);

        JButton btnAdd = new JButton("Add");

        btnAdd.addActionListener(e -> addItem());

        panel.add(new JLabel());
        panel.add(btnAdd);

        return panel;
    }

    protected abstract void addItem();
}