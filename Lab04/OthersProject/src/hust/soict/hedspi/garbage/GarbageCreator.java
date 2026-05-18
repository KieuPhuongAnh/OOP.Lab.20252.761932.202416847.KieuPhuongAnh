package hust.soict.hedspi.garbage;

public class GarbageCreator {

    public static void main(String[] args) {

        String s = "";

        // Tạo rất nhiều object String (garbage)
        for (int i = 0; i < 100000; i++) {
            s += "a";
        }

        System.out.println("Done creating garbage with String + operator");
    }
}