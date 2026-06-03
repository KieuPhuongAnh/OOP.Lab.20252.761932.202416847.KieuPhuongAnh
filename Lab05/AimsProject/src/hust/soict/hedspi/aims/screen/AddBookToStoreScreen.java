package hust.soict.hedspi.aims.screen;

import javax.swing.JOptionPane;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book");
    }

    @Override
    protected void addItem() {

        try {

            int id = Integer.parseInt(tfId.getText());
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());

            Book book = new Book(
                    id,
                    title,
                    category,
                    cost
            );

            store.addMedia(book);

            JOptionPane.showMessageDialog(
                    this,
                    "Book added successfully!"
            );

            tfId.setText("");
            tfTitle.setText("");
            tfCategory.setText("");
            tfCost.setText("");

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "ID phải là số nguyên và Cost phải là số!",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
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