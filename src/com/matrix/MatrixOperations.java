package com.matrix;

public class MatrixOperations {
	public static IntegerMatrix identityMatrix(int arg0) {
		IntegerMatrix matrix = new IntegerMatrix(arg0);
		for(int i = 0; i < arg0; i++) {
				matrix.setAtIndex(i, i, 1);
		}
		return matrix;
	}
	
	public static IntegerMatrix identityMatrix(IntegerMatrix arg0) {
		IntegerMatrix matrix = new IntegerMatrix(arg0.getRows());
		if(arg0.getRows() != arg0.getCols())
			return new IntegerMatrix();
		for(int i = 0; i < arg0.getRows(); i++) {
				matrix.setAtIndex(i, i, 1);
		}
		return matrix;
	}

	public static DoubleMatrix identityMatrix(DoubleMatrix arg0) {
		DoubleMatrix matrix = new DoubleMatrix(arg0.getRows());
		for(int i = 0; i < arg0.getRows(); i++) {
			matrix.setAtIndex(i, i, 1.0);
		}
		return matrix;
	}
}
