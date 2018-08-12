package com.matrix;

public abstract class Matrix<T extends Number> implements MatrixInterface<T> {
	private int rows;
	private int cols;
	
	/**
	 * Initializes the Matrix to be 3x3 in size.
	 */
	public Matrix() {
		this.rows = 3;
		this.cols = 3;
	}

	/**
	 * Initialize the Matrix to be a square matrix
	 * based on the integer given.
	 * @param rowsAndCols Value to be used for both number of rows and number of cols.
	 */
	public Matrix(int rowsAndCols) {
		this.rows = rowsAndCols;
		this.cols = rowsAndCols;
	}

	/**
	 * Initializes the Matrix to be (rows)x(cols) in size.
	 * @param rows Number of rows in the matrix.
	 * @param cols Number of cols in the matrix.
	 */
	public Matrix(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
	}
	
	public int getRows() {
		return rows;
	}
	
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public int getCols() {
		return cols;
	}
	
	public void setCols(int cols) {
		this.cols = cols;
	}

	public boolean equals(Matrix<T> arg0) {
		if(getRows() != arg0.getRows() && getCols() != arg0.getCols())
			return false;
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getCols(); j++) {
				if(getAtIndex(i, j) != arg0.getAtIndex(i, j))
					return false;
			}
		}
		return true;
	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		for(int i = 0; i < getRows(); i++) {
			buf.append("[");
			for(int j = 0; j < getCols(); j++) {
				buf.append(this.getAtIndex(i, j));
				if(j != getCols() - 1)
					buf.append(" ");
			}
			if(i != getRows() - 1)
				buf.append("]\n");
			else
				buf.append("]");
		}
		return buf.toString();
	}
}
