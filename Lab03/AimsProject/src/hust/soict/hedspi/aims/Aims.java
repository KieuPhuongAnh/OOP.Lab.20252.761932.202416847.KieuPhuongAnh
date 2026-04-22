package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
    public static void main(String[] args) {

        Store store = new Store();
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Lion King", "Animation", 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sci-fi", 24.95f);

        store.addDVD(dvd1);
        store.addDVD(dvd2);

        cart.addDigitalVideoDisc(dvd1, dvd2);

        cart.print();
    }
}