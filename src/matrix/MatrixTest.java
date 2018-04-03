package matrix;

public class MatrixTest {

	public static void main(String[] args) {
		Matrix a = new Matrix();
		fillMatrix(a, 1);
		Matrix b = new Matrix();
		fillMatrix(b, 2);
		System.out.println("Testing adding two matrices...");
		System.out.println(a.add(b));
	}

	public static void fillMatrix(Matrix a, int values) {
		for(int i = 0; i < a.getRows(); i++) {
			for(int j = 0; j < a.getCols(); j++) {
				a.setAtIndex(i, j, values);
			}
		}
	}
	
}
