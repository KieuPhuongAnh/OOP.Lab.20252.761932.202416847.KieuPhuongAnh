package hust.soict.hedspi.garbage;

public class NoGarbage {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        // Không tạo nhiều object rác
        for (int i = 0; i < 100000; i++) {
            sb.append("a");
        }

        System.out.println("Done efficiently without garbage problem");
    }
}