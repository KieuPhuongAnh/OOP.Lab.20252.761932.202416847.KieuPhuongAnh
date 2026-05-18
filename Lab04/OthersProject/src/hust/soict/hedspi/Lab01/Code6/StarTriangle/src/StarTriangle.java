import java.util.Scanner;
public class StarTriangle {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the height (n): ");		
		if(scanner.hasNextInt()) {
			int n = scanner.nextInt();
			
			for(int i = 1; i <= n; i++) {
				for(int j = 0; j < n - i; j++) {
					System.out.print(" ");
				}
				
				int numStars = 2 * i - 1;
				for(int k = 0; k < numStars; k++) {
					System.out.print("*");
				}
				
				System.out.println();
			}
		} else {
			System.out.println("Please enter a valid integer");
		}
		scanner.close();

	}

}