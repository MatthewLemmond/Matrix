package com.matrix;

/**
 * Implementation of the MatrixInterface using integer values within the matrix itself.
 * @author Matthew Lemmond
 */
public class IntegerMatrix extends Matrix implements MatrixInterface {
	private int[][] matrix;

	/**
	 * Initializes the Matrix to be 3x3 in size.
	 */
	public IntegerMatrix() {
		super();
		this.matrix = new int[getRows()][getCols()];
	}
	
	/**
	 * Initialize the Matrix to be a square matrix
	 * based on the integer given.
	 * @param rowsAndCols Value to be used for both number of rows and number of cols.
	 */
	public IntegerMatrix(int rowsAndCols) {
		super(rowsAndCols);
		this.matrix = new int[getRows()][getCols()];
	}

	/**
	 * Initializes the Matrix to be (rows)x(cols) in size.
	 * @param rows Number of rows in the matrix.
	 * @param cols Number of cols in the matrix.
	 */
	public IntegerMatrix(int rows, int cols) {
		super(rows, cols);
		this.matrix = new int[getRows()][getCols()];
	}
	
	/**
	 * Initialize the Matrix to be the same size as the array
	 * then copies over the contents of the array into the matrix.
	 * @param array Array to be copied into the Matrix.
	 */
	public IntegerMatrix(int[][] array) {
		setRows(array.length);
		setCols(array[0].length);
		this.matrix = new int[getRows()][getCols()];
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getCols(); j++) {
				setAtIndex(i, j, array[i][j]);
			}
		}
	}
	
	/**
	 * Copy-Constructor.
	 * Takes the Matrix from the argument and make a deep copy of the contents.
	 * @param arg0 Matrix to be copied.
	 */
	public IntegerMatrix(IntegerMatrix arg0) {
		setRows(arg0.getRows());
		setCols(arg0.getCols());
		this.matrix = new int[getRows()][getCols()];
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getCols(); j++) {
				setAtIndex(i, j, arg0.getAtIndex(i, j));
			}
		}
	}

	public void setAtIndex(int row, int col, int value) throws ArrayIndexOutOfBoundsException {
		if(row >= 0 && row < getRows() && col >= 0 && col < getCols())
			this.matrix[row][col] = value;
		else
			throw(new ArrayIndexOutOfBoundsException("Index Out of Bounds"
					+ "\nCheck that your values for row and col are correct"
					+ " and try again."));
	}

	public int getAtIndex(int row, int col) throws ArrayIndexOutOfBoundsException {
		if(row >= 0 && row < getRows() && col >= 0 && col < getCols())
			return this.matrix[row][col];
		else
			throw(new ArrayIndexOutOfBoundsException("Index Out of Bounds"
					+ "\nCheck that your values for row and col are correct"
					+ " and try again."));
		
	}
	
	public IntegerMatrix multiply(int scalar) {
		IntegerMatrix temp = new IntegerMatrix(this);
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getCols(); j++) {
				temp.setAtIndex(i, j, getAtIndex(i, j) * scalar);
			}
		}
		return temp;
	}
	
	public IntegerMatrix multiply(IntegerMatrix arg0) throws IllegalArgumentException {
		if(getCols() == arg0.getRows()) {
			IntegerMatrix temp = new IntegerMatrix(getRows(), arg0.getCols());
			for(int i = 0; i < getRows(); i++) {
				for(int j = 0; j < arg0.getCols(); j++) {
					for(int k = 0; k < getCols(); k++) {
						temp.setAtIndex(i, j, temp.getAtIndex(i, j) + (getAtIndex(i, k) * arg0.getAtIndex(k, j)));
					}
				}
			}
			return temp;
		}
		else {
			throw(new IllegalArgumentException("\nCannot multiply matrices with dimesnions of "
					+ getRows() + "x" + getCols() + " and " + arg0.getRows() + "x" + arg0.getCols()
					+ ".\nTry different matrices where the columns of the first \nmatch the rows of the second."));
		}
	}

	public IntegerMatrix transpose() {
		IntegerMatrix temp = new IntegerMatrix(getCols(), getRows());
		for(int i = 0; i < getCols(); i++) {
			for(int j = 0; j < getRows(); j++) {
				temp.setAtIndex(i, j, getAtIndex(j, i));
			}
		}
		return temp;
	}
}
