package matrix;

public class MatrixTest {

	public static void main(String[] args) {
		Matrix a = new Matrix();
		fillMatrix(a, 1);
		Matrix b = new Matrix();
		fillMatrix(b, 2);
		Matrix c = new Matrix(2,2);
		fillMatrix(c,2);
		System.out.println("Testing adding two matrices...");
		try {
			System.out.println(a.add(b));
		} catch (UnsupportedOperationException e) {
			e.printStackTrace(System.out);
		}
		System.out.println("Testing Exception...");
		Matrix d = null;
		try {
			d = a.add(c);
		} catch (UnsupportedOperationException e) {
			e.printStackTrace(System.out);
			System.out.println("Successfully caught exception.");
		}
		System.out.println(d);
	}

	public static void fillMatrix(Matrix a, int values) {
		for(int i = 0; i < a.getRows(); i++) {
			for(int j = 0; j < a.getCols(); j++) {
				a.setAtIndex(i, j, values);
			}
		}
	}
	
}
