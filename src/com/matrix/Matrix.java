package com.matrix;

public abstract class Matrix implements MatrixInterface {
	private int rows;
	private int cols;
	
	public Matrix() {
		this.rows = 3;
		this.cols = 3;
	}
	
	public Matrix(int rowsAndCols) {
		this.rows = rowsAndCols;
		this.cols = rowsAndCols;
	}
	
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
	
	public IntegerMatrix add(IntegerMatrix arg0) throws IllegalArgumentException {
		if(getRows() == arg0.getRows() && getCols() == arg0.getCols()) {
			IntegerMatrix temp = new IntegerMatrix(getRows(), getCols());
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

	public IntegerMatrix subtract(IntegerMatrix arg0) throws IllegalArgumentException {
		if(getRows() == arg0.getRows() && getCols() == arg0.getCols()) {
			IntegerMatrix temp = new IntegerMatrix(getRows(), getCols());
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

	public int compareTo(IntegerMatrix arg0) {
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

	public boolean equals(IntegerMatrix arg0) {
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
