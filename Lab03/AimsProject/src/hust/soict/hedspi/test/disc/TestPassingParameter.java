package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {

    public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2) {
        DigitalVideoDisc temp = o1;
        o1 = o2;
        o2 = temp;
    }

    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("DVD 1");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("DVD 2");

        swap(dvd1, dvd2);

        System.out.println(dvd1.getTitle());
        System.out.println(dvd2.getTitle());
    }
}