package matrix;

public class MatrixTest {

	public static void main(String[] args) {
		Matrix a = new Matrix();
		fillMatrix(a, 5);
		Matrix b = new Matrix();
		fillMatrix(b, 3);
		Matrix c = new Matrix(2, 2);
		fillMatrix(c, 2);
		Matrix f = new Matrix(3,1);
		fillMatrix(f, 9);
		Matrix z = new Matrix(3,3);
		int q = 11;
		for(int i = 0; i < z.getRows(); i++) {
			for(int j = 0; j < z.getCols(); j++) {
				z.setAtIndex(i, j, q);
				q += 2;
			}
		}
		System.out.println("Testing adding two matrices...");
		try {
			System.out.println(a.add(b));
		}
		catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		System.out.println("Testing Exception in addition method...");
		Matrix d = null;
		try {
			d = a.add(c);
		}
		catch(IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("Successfully caught exception.");
		}
		System.out.println("Testing subtracting two matrices...");
		try {
			System.out.println(b.subtract(a));
		}
		catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		System.out.println("Testing Exception in subtraction method...");
		try {
			d = a.subtract(c);
			System.out.println(d);
		}
		catch(IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("Successfully caught exception.");
		}
		System.out.println("Testing multiplying two matrices...");
		try {
			Matrix e = z.multiply(f);
			System.out.println(z + "\n	*\n" + f + "\n-----------------------------------");
			System.out.println(e);
			System.out.println("Successfully multiplied two matrices.");
		}
		catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		System.out.println("Testing Exception in multiply method...");
		try {
			System.out.println(a.multiply(c));
		}
		catch(IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("Successfully caught exception.");
		}
	}

	public static void fillMatrix(Matrix a, int values) {
		for(int i = 0; i < a.getRows(); i++) {
			for(int j = 0; j < a.getCols(); j++) {
				a.setAtIndex(i, j, values);
			}
		}
	}

}
