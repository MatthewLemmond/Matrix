package com.matrix;

public interface MatrixInterface<T extends Number> {
	
	/**
	 * @return int The number of rows in the Matrix.
	 */
	public int getRows();
	
	/**
	 * @return int The number of columns in the Matrix.
	 */
	public int getCols();
	
	/**
	 * Sets the index at [row][column] to be the value passed.
	 * Implementing classes should do checks to make sure the row and col values are valid.
	 * @param row The row at which to place the value.
	 * @param col The col at which to place the value.
	 * @param value The value to be set at that location.
	 */
	public void setAtIndex(int row, int col, T value) throws ArrayIndexOutOfBoundsException;
	
	/**
	 * Gets the value from the corresponding index.
	 * Implementing classes should check that the row and column are valid.
	 * @param row Row from which to get the value.
	 * @param col Col from which to get the value.
	 * @return int Value from the corresponding row, column pair.
	 */
	public T getAtIndex(int row, int col) throws ArrayIndexOutOfBoundsException;
	
	/**
	 * Add two matrices together.
	 * Implementing classes should check for the validity of the operation.
	 * @param other The matrix to add to the calling matrix.
	 * @return Matrix The resulting matrix after the addition.
	 */
	public Matrix<T> add(Matrix<T> arg0) throws IllegalArgumentException;
	
	/**
	 * Subtract one matrix from the other.
	 * Implementing classes should check for the validity of the operation.
	 * @param other The matrix to subtract from the calling matrix.
	 * @return Matrix The resulting matrix after the subtraction.
	 */
	public Matrix<T> subtract(Matrix<T> arg0) throws IllegalArgumentException;
	
	/**
	 * Multiply the contents of the calling matrix by the value passed in.
	 * @param value Value to scale the contents of the matrix by.
	 * @return Matrix The resulting matrix after the scaling.
	 */
	public Matrix<T> multiply(int scalar);
	
	/**
	 * Multiply two matrices together.
	 * Implementing classes should check for the validity of the operation.
	 * @param other The matrix to multiply to the calling matrix.
	 * @return Matrix The resulting matrix after the multiplication.
	 */
	public Matrix<T> multiply(Matrix<T> arg0) throws IllegalArgumentException;
	
	/**
	 * Transpose the calling matrix.
	 * @return Matrix The resulting matrix after transposition.
	 */
	public Matrix<T> transpose();
	
	/**
	 * Compare two matrices together and return an integer to signify their difference.
	 * @param other The matrix to compare against the calling matrix.
	 * @return int The result of the comparison.
	 */
	public int compareTo(Matrix<T> other) throws IllegalArgumentException;
	
	/**
	 * Determine if two matrices are equal to one another.
	 * @param other The matrix to check equality against the calling matrix.
	 * @return boolean True or false depending on the equality of the matrices.
	 */
	public boolean equals(Matrix<T> other) throws IllegalArgumentException;
	
	/**
	 * @return String A textual representation of the matrix.
	 */
	public String toString();
}
