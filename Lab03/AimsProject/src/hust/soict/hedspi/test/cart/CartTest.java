package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("DVD 1");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("DVD 2");

        cart.addDigitalVideoDisc(dvd1, dvd2);

        cart.print();
    }
}