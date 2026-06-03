package hust.soict.hedspi.aims.screen;

import java.awt.*;
import javax.swing.*;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add DVD");
    }

    @Override
    protected JPanel createForm() {

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));

        panel.add(new JLabel("ID"));
        tfId = new JTextField();
        panel.add(tfId);

        panel.add(new JLabel("Title"));
        tfTitle = new JTextField();
        panel.add(tfTitle);

        panel.add(new JLabel("Category"));
        tfCategory = new JTextField();
        panel.add(tfCategory);

        panel.add(new JLabel("Director"));
        tfDirector = new JTextField();
        panel.add(tfDirector);

        panel.add(new JLabel("Length"));
        tfLength = new JTextField();
        panel.add(tfLength);

        panel.add(new JLabel("Cost"));
        tfCost = new JTextField();
        panel.add(tfCost);

        JButton btnAdd = new JButton("Add");

        btnAdd.addActionListener(e -> addItem());

        panel.add(new JLabel());
        panel.add(btnAdd);

        return panel;
    }

    @Override
    protected void addItem() {

        try {

            int id = Integer.parseInt(tfId.getText());
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String director = tfDirector.getText();
            int length = Integer.parseInt(tfLength.getText());
            float cost = Float.parseFloat(tfCost.getText());

            DigitalVideoDisc dvd =
                    new DigitalVideoDisc(
                            id,
                            title,
                            category,
                            director,
                            length,
                            cost
                    );

            store.addMedia(dvd);

            JOptionPane.showMessageDialog(
                    this,
                    "DVD added successfully!"
            );

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}