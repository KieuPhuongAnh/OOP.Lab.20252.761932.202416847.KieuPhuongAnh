package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;

import java.io.IOException;
import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame{
    private Cart cart = new Cart();

    public CartScreen(Cart cart) {
        super();

        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        add(fxPanel);

        setTitle("Cart");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                        "/hust/soict/hedspi/aims/screen/cart.fxml"));

                loader.setController(
                    new CartScreenController(cart));

                Parent root = loader.load();

                fxPanel.setScene(new Scene(root));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        setVisible(true);
    }
    
    public static void main(String[] args) {

        Cart cart = new Cart();

        cart.addMedia(
            new Book(
                1,
                "Java Programming",
                "Programming",
                15.5f));

        cart.addMedia(
            new DigitalVideoDisc(
                2,
                "The Lion King",
                "Animation",
                "Roger Allers",
                87,
                19.95f));

        new CartScreen(cart);
    }
}