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

	public Matrix add(Matrix other) throws IllegalArgumentException {
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
			throw(new IllegalArgumentException("\nCannot add matrices with dimesnions of "
					+ getRows() + "x" + getCols() + " and " + other.getRows() + "x" + other.getCols()
					+ ".\nTry different matrices where all dimensions match."));
		}
	}

	public Matrix subtract(Matrix other) throws IllegalArgumentException {
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
			throw(new IllegalArgumentException("\nCannot subtract matrices with dimesnions of "
					+ getRows() + "x" + getCols() + " and " + other.getRows() + "x" + other.getCols()
					+ ".\nTry different matrices where all dimensions match."));
		}
	}
	
	public Matrix multiply(Matrix other) throws IllegalArgumentException {
		if(getCols() == other.getRows()) {
			Matrix temp = new Matrix(getRows(), other.getCols());
			for(int i = 0; i < getRows(); i++) {
				for(int j = 0; j < other.getCols(); j++) {
					for(int k = 0; k < getCols(); k++) {
						temp.setAtIndex(i, j, temp.getAtIndex(i, j) + (getAtIndex(i, k) * other.getAtIndex(k, j)));
					}
				}
			}
			return temp;
		}
		else {
			throw(new IllegalArgumentException("\nCannot multiply matrices with dimesnions of "
					+ getRows() + "x" + getCols() + " and " + other.getRows() + "x" + other.getCols()
					+ ".\nTry different matrices where the columns of the first \nmatch the rows of the second."));
		}
	}


	public int compareTo(Matrix other) {
		int diff = 0;
		if(getRows() != other.getRows())
			return Integer.MIN_VALUE;
		else if(getCols() != other.getCols())
			return Integer.MAX_VALUE;
		else {
			for(int i = 0; i < getRows(); i++) {
				for(int j = 0; j < getCols(); j++) {
					diff += getAtIndex(i, j) - other.getAtIndex(i, j);
				}
			}
		}
		return diff;
	}

	public boolean equals(Matrix other) {
		if(getRows() != other.getRows() && getCols() != other.getCols())
			return false;
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getCols(); j++) {
				if(getAtIndex(i, j) != other.getAtIndex(i, j))
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
