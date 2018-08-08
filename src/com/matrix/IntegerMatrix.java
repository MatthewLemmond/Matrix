package com.matrix;

/**
 * Implementation of the MatrixInterface using integer values within the matrix itself.
 * @author Matthew Lemmond
 */
public class IntegerMatrix extends Matrix<Integer> implements MatrixInterface<Integer> {
	private int[][] matrix;

	public IntegerMatrix() {
		super();
		initArr();
	}

	public IntegerMatrix(int rowsAndCols) {
		super(rowsAndCols);
		initArr();
	}

	public IntegerMatrix(int rows, int cols) {
		super(rows, cols);
		initArr();
	}
	
	/**
	 * Initialize the Matrix to be the same size as the array
	 * then copies over the contents of the array into the matrix.
	 * @param array Array to be copied into the Matrix.
	 */
	public IntegerMatrix(int[][] array) {
		setRows(array.length);
		setCols(array[0].length);
		initArr();
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
		initArr();
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getCols(); j++) {
				setAtIndex(i, j, arg0.getAtIndex(i, j));
			}
		}
	}

	@Override
	public void setAtIndex(int row, int col, Integer value) throws ArrayIndexOutOfBoundsException {
		if(row >= 0 && row < getRows() && col >= 0 && col < getCols())
			this.matrix[row][col] = (int)value;
		else
			throw(new ArrayIndexOutOfBoundsException("Index Out of Bounds"
					+ "\nCheck that your values for row and col are correct"
					+ " and try again."));
	}

	public Integer getAtIndex(int row, int col) throws ArrayIndexOutOfBoundsException {
		if(row >= 0 && row < getRows() && col >= 0 && col < getCols())
			return this.matrix[row][col];
		else
			throw(new ArrayIndexOutOfBoundsException("Index Out of Bounds"
					+ "\nCheck that your values for row and col are correct"
					+ " and try again."));
	}
	
	public Matrix<Integer> add(Matrix<Integer> arg0) throws IllegalArgumentException {
		if(getRows() == arg0.getRows() && getCols() == arg0.getCols()) {
			Matrix<Integer> temp = new IntegerMatrix(getRows(), getCols());
			for(int i = 0; i < getRows(); i++) {
				for(int j = 0; j < getCols(); j++) {
					temp.setAtIndex(i, j, this.getAtIndex(i, j) + arg0.getAtIndex(i, j));
				}
			}
			return temp;
		}
		else {
			throw(new IllegalArgumentException("\nCannot add matrices with dimesnions of "
					+ getRows() + "x" + getCols() + " and " + arg0.getRows() + "x" + arg0.getCols()
					+ ".\nTry different matrices where all dimensions match."));
		}
	}

	public Matrix<Integer> subtract(Matrix<Integer> arg0) throws IllegalArgumentException {
		if(getRows() == arg0.getRows() && getCols() == arg0.getCols()) {
			Matrix<Integer> temp = new IntegerMatrix(getRows(), getCols());
			for(int i = 0; i < getRows(); i++) {
				for(int j = 0; j < getCols(); j++) {
					temp.setAtIndex(i, j, this.getAtIndex(i, j) - arg0.getAtIndex(i, j));
				}
			}
			return temp;
		}
		else {
			throw(new IllegalArgumentException("\nCannot subtract matrices with dimesnions of "
					+ getRows() + "x" + getCols() + " and " + arg0.getRows() + "x" + arg0.getCols()
					+ ".\nTry different matrices where all dimensions match."));
		}
	}
	
	public Matrix<Integer> multiply(int scalar) {
		Matrix<Integer> temp = new IntegerMatrix(this);
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getCols(); j++) {
				temp.setAtIndex(i, j, getAtIndex(i, j) * scalar);
			}
		}
		return temp;
	}
	
	public Matrix<Integer> multiply(Matrix<Integer> arg0) throws IllegalArgumentException {
		if(getCols() == arg0.getRows()) {
			Matrix<Integer> temp = new IntegerMatrix(getRows(), arg0.getCols());
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

	public Matrix<Integer> transpose() {
		Matrix<Integer> temp = new IntegerMatrix(getCols(), getRows());
		for(int i = 0; i < getCols(); i++) {
			for(int j = 0; j < getRows(); j++) {
				temp.setAtIndex(i, j, getAtIndex(j, i));
			}
		}
		return temp;
	}

	public int compareTo(Matrix<Integer> arg0) {
		int diff = 0;
		if(getRows() != arg0.getRows())
			return Integer.MIN_VALUE;
		else if(getCols() != arg0.getCols())
			return Integer.MAX_VALUE;
		else {
			for(int i = 0; i < getRows(); i++) {
				for(int j = 0; j < getCols(); j++) {
					diff += getAtIndex(i, j) - arg0.getAtIndex(i, j);
				}
			}
		}
		return diff;
	}

	/* PRIVATE HELPER METHODS */
	private void initArr(){
		this.matrix = new int[getRows()][getCols()];
	}
}
