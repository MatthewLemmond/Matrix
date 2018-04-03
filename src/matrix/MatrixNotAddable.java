package matrix;

public class MatrixNotAddable extends Exception {
	private static final long serialVersionUID = 7008144117965057916L;
	private String message;
	public MatrixNotAddable() {
		message = "These two matrices are not addable, check that they have the same"
				+ "number of rows and columns and try again.";
	}
	
	public void printMessage() {
		System.out.println(message);
	}
}
