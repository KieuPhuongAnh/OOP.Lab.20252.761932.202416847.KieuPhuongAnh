import java.util.Scanner;
public class MatrixAddition {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter number of rows: ");
		int rows = scanner.nextInt();
		System.out.print("Enter number of columns: ");
		int cols = scanner.nextInt();
		
		int[][] matrix1 = new int[rows][cols];
		int[][] matrix2 = new int[rows][cols];
		int[][] sumMatrix = new int[rows][cols];
		
		System.out.println("Enter elements for Matrix 1:");
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				matrix1[i][j] = scanner.nextInt();
			}
		}
		
		System.out.println("Enter elements for Matrix 2:");
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				matrix2[i][j] = scanner.nextInt();
			}
		}
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		
		System.out.println("\nResultant Sum Matrix:");
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				System.out.print(sumMatrix[i][j] + "\t");
			}
			System.out.println();
		}
		
		scanner.close();

	}

}