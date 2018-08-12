package com.matrix;

public class DoubleMatrix extends Matrix<Double> implements MatrixInterface<Double> {
	private double[][] matrix;
	
	public DoubleMatrix() {
		super();
		initArr();
	}

	public DoubleMatrix(int rowsAndCols) {
		super(rowsAndCols);
		initArr();
	}

	public DoubleMatrix(int rows, int cols) {
		super(rows, cols);
		initArr();
	}
	
	public DoubleMatrix(double[][] array) {
		setRows(array.length);
		setCols(array[0].length);
		initArr();
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getCols(); j++) {
				setAtIndex(i, j, array[i][j]);
			}
		}
	}
	
	public DoubleMatrix(DoubleMatrix arg0) {
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
	public void setAtIndex(int row, int col, Double value) throws ArrayIndexOutOfBoundsException {
		if(row >= 0 && row < getRows() && col >= 0 && col < getCols())
			this.matrix[row][col] = (double)value;
		else
			throw(new ArrayIndexOutOfBoundsException("Index Out of Bounds"
					+ "\nCheck that your values for row and col are correct"
					+ " and try again."));
	}

	@Override
	public Double getAtIndex(int row, int col) {
		if(row >= 0 && row < getRows() && col >= 0 && col < getCols())
			return this.matrix[row][col];
		else
			throw(new ArrayIndexOutOfBoundsException("Index Out of Bounds"
					+ "\nCheck that your values for row and col are correct"
					+ " and try again."));
	}
	
	@Override
	public Matrix<Double> add(Matrix<Double> arg0) {
		if(getRows() == arg0.getRows() && getCols() == arg0.getCols()) {
			Matrix<Double> temp = new DoubleMatrix(getRows(), getCols());
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

	@Override
	public Matrix<Double> subtract(Matrix<Double> arg0) {
		if(getRows() == arg0.getRows() && getCols() == arg0.getCols()) {
			Matrix<Double> temp = new DoubleMatrix(getRows(), getCols());
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

	@Override
	public Matrix<Double> multiply(int scalar) {
		Matrix<Double> temp = new DoubleMatrix(this);
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getCols(); j++) {
				temp.setAtIndex(i, j, getAtIndex(i, j) * scalar);
			}
		}
		return temp;
	}

	@Override
	public Matrix<Double> multiply(Matrix<Double> arg0) {
		if(getCols() == arg0.getRows()) {
			Matrix<Double> temp = new DoubleMatrix(getRows(), arg0.getCols());
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

	@Override
	public Matrix<Double> transpose() {
		Matrix<Double> temp = new DoubleMatrix(getCols(), getRows());
		for(int i = 0; i < getCols(); i++) {
			for(int j = 0; j < getRows(); j++) {
				temp.setAtIndex(i, j, getAtIndex(j, i));
			}
		}
		return temp;
	}

	@Override
	public int compareTo(Matrix<Double> arg0) {
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
	private void initArr() {
		this.matrix = new double[getRows()][getCols()];
	}
}
