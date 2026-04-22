import javax.swing.JOptionPane;
public class EquationSolver {
	public static void main(String[] args) {
		String[] options = {"Linear 1 variable",
					"Linear system 2 variables",
					"Quadratic", "Exit"
		};
		int choice = JOptionPane.showOptionDialog(null,
					"Select the equation type to solve:",
					"Equation Solver Menu",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					null, options, options[0]);
		
		switch(choice) {
			case 0: solveLinear(); break;
			case 1: solveSystem(); break;
			case 2: solveQuadratic(); break;
			default: System.exit(0);
		}
	}
	
	private static void solveLinear() {
		double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a:"));
		double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));
		
		if(a == 0) {
			if(b == 0) {
				JOptionPane.showMessageDialog(null, "Infinite solutions.");
			} else {
				JOptionPane.showMessageDialog(null, "No solution.");
			}
		} else {
			double x = -b / a;
			JOptionPane.showMessageDialog(null, "x = " + x);
		}
	}
	
	private static void solveSystem() {
		double a11 = Double.parseDouble(JOptionPane.showInputDialog("Enter a11:"));
		double a12 = Double.parseDouble(JOptionPane.showInputDialog("Enter a12:"));
		double b1 = Double.parseDouble(JOptionPane.showInputDialog("Enter b1:"));
		double a21 = Double.parseDouble(JOptionPane.showInputDialog("Enter a21:"));
		double a22 = Double.parseDouble(JOptionPane.showInputDialog("Enter a22:"));
		double b2 = Double.parseDouble(JOptionPane.showInputDialog("Enter b2:"));
		
		double D = a11 * a22 - a21 * a12;
		double D1 = b1 * a22 - b2 * a12;
		double D2 = a11 * b2 - a21 * b1;
		
		if(D != 0) {
			double x1 = D1 / D;
			double x2 = D2 / D;
			JOptionPane.showMessageDialog(null, "x1 = " + x1 + "\nx2 = " + x2);
		} else {
			if(D1 == 0 && D2 == 0) {
				JOptionPane.showMessageDialog(null, "Infinite solutions.");
			} else {
				JOptionPane.showMessageDialog(null, "No solution.");
			}
		}
	}
	
	private static void solveQuadratic() {
		double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a:"));
		double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));
		double c = Double.parseDouble(JOptionPane.showInputDialog("Enter c:"));
		
		if(a == 0) {
			if(b == 0) {
				JOptionPane.showMessageDialog(null,
						(c == 0) ? "Infinite solutions." : "No solution.");
			} else {
				JOptionPane.showMessageDialog(null, "x = " + (-c / b));
			}
		} else {
			double delta = b * b - 4 * a * c;
			
			if(delta < 0) {
				JOptionPane.showMessageDialog(null, "No real root.");
			} else if(delta == 0) {
				double x = -b / (2 * a);
				JOptionPane.showMessageDialog(null, "Double root: x = " + x);
			} else {
				double x1 = (-b + Math.sqrt(delta)) / (2 * a);
				double x2 = (-b - Math.sqrt(delta)) / (2 * a);
				JOptionPane.showMessageDialog(null, "x1 = " + x1 + "\nx2 = " + x2);
			}
		}
	}
}