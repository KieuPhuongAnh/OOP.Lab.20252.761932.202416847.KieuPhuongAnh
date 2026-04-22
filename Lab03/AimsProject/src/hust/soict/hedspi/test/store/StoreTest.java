package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("DVD A");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("DVD B");

        store.addDVD(dvd1);
        store.addDVD(dvd2);

        store.removeDVD(dvd1);
    }
}