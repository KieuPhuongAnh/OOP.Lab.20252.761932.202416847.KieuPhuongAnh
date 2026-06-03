package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.exception.*;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CartScreenController {

    private Cart cart;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;
    
    @FXML
    private Label lblTotalCost;
    
    @FXML
    private TextField tfFilter;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }
    
    @FXML
    private void btnPlayPressed() {

        Media media =
                tblMedia.getSelectionModel()
                        .getSelectedItem();

        if (media == null)
            return;

        if (media instanceof Playable) {
        	try {
        	    ((Playable) media).play();
        	} catch (PlayerException e) {
        	    System.out.println(e.getMessage());
        	}
        }
    }
    
    @FXML
    private void btnRemovePressed() {

        Media media =
                tblMedia.getSelectionModel()
                        .getSelectedItem();

        if (media == null)
            return;

        cart.removeMedia(media);

        tblMedia.getItems().remove(media);

        lblTotalCost.setText(
                cart.totalCost() + " $");
    }

    @FXML
    private void initialize() {
    	colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));
        
        ObservableList<Media> mediaList =
                FXCollections.observableArrayList(
                    cart.getItemsOrdered());
        tblMedia.setItems(mediaList);
        lblTotalCost.setText(cart.totalCost() + " $");
        
        tfFilter.textProperty()
        .addListener((obs,
                      oldValue,
                      newValue) -> {
                    	  ObservableList<Media> filtered = FXCollections.observableArrayList();
                    	  for(Media media : cart.getItemsOrdered()) {
                    		  if(media.getTitle().toLowerCase().contains(newValue.toLowerCase())) {
                    			  filtered.add(media);
                    			  }
                    		  }
                    	  tblMedia.setItems(filtered);
                    	  });
    }
}