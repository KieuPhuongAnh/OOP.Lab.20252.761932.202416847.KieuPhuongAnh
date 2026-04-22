package hust.soict.hedspi.garbage;

public class ConcatenationInLoops {

    public static void main(String[] args) {

        // STRING (+ operator)
        long start = System.currentTimeMillis();

        String s = "";
        for (int i = 0; i < 20000; i++) {
            s += "a";
        }

        long end = System.currentTimeMillis();
        System.out.println("String (+) time: " + (end - start) + " ms");

        // STRINGBUILDER
        start = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20000; i++) {
            sb.append("a");
        }

        end = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (end - start) + " ms");

        // STRINGBUFFER
        start = System.currentTimeMillis();

        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < 20000; i++) {
            sbf.append("a");
        }

        end = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (end - start) + " ms");
    }
}