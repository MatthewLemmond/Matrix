package matrix;

public class Matrix {
	private int rows;
	private int cols;
	private int[][] matrix;
	
	public Matrix() {
		setRows(3);
		setCols(3);
		this.matrix = new int[getRows()][getCols()];
	}
	
	public Matrix(int rows, int cols) {
		setRows(rows);
		setCols(cols);
		this.matrix = new int[getRows()][getCols()];
	}
	
	public int getRows() {
		return this.rows;
	}
	
	public int getCols() {
		return this.cols;
	}
	
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public void setCols(int cols) {
		this.cols = cols;
	}
	
	public void setAtIndex(int row, int col, int value) {
		this.matrix[row][col] = value;
	}
	
	public int getAtIndex(int row, int col) {
		return this.matrix[row][col];
	}
	
	public Matrix add(Matrix other) throws UnsupportedOperationException {
		if(getRows() == other.getRows() && getCols() == other.getCols()) {
			Matrix temp = new Matrix(getRows(), getCols());
			for(int i = 0; i < getRows(); i++) {
				for(int j = 0; j < getCols(); j++) {
					temp.setAtIndex(i, j, this.getAtIndex(i, j) + other.getAtIndex(i, j));
				}
			}
			return temp;
		}
		else {
			throw(new UnsupportedOperationException());
		}
	}
	
	public Matrix subtract(Matrix other) throws UnsupportedOperationException {
		if(getRows() == other.getRows() && getCols() == other.getCols()) {
			Matrix temp = new Matrix(getRows(), getCols());
			for(int i = 0; i < getRows(); i++) {
				for(int j = 0; j < getCols(); j++) {
					temp.setAtIndex(i, j, this.getAtIndex(i, j) - other.getAtIndex(i, j));
				}
			}
			return temp;
		}
		else {
			throw(new UnsupportedOperationException());
		}
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
