package hust.soict.hedspi.aims.screen;

import java.awt.*;
import javax.swing.*;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfArtist;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add CD");
    }

    @Override
    protected JPanel createForm() {

        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));

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

        panel.add(new JLabel("Artist"));
        tfArtist = new JTextField();
        panel.add(tfArtist);

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
            String artist = tfArtist.getText();

            CompactDisc cd =
                    new CompactDisc(
                            id,
                            title,
                            category,
                            director,
                            length,
                            cost,
                            artist
                    );

            store.addMedia(cd);

            JOptionPane.showMessageDialog(
                    this,
                    "CD added successfully!"
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