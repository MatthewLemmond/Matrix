package com.matrix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MatrixTest {
	
	private Matrix constructorTester;
	private Matrix setAtIndexTester;
	public static Matrix a;
	public static Matrix b;
	public static Matrix c;
	public static Matrix d;
	public static Matrix diffRows;
	public static Matrix diffCols;
	public static Matrix zeroMatrix;
	public static Matrix oneMatrix;
	public static Matrix twoMatrix;
	public static Matrix aTimesB;
	public static Matrix transposedC;
	
	@BeforeAll public static void initialize() throws InterruptedException {
		diffRows = new Matrix(4,3);
		diffCols = new Matrix(3,5);
		a = new Matrix();
		b = new Matrix();
		c = new Matrix(3,1);
		for(int i = 0; i < a.getRows(); i++) {
			for(int j = 0; j < b.getRows(); j++) {
				a.setAtIndex(i, j, i + j);
				b.setAtIndex(i, j, (i + 1) * (j + 1));
			}
		}
		for(int i = 0; i < c.getRows(); i++) {
			for(int j = 0; j < c.getCols(); j++) {
				c.setAtIndex(i, j, i + 10);
			}
		}
		int[][] tmp = {{1,3,5},{3,6,9},{5,9,13}};
		d = new Matrix(tmp);
		int[][] zeroArr = {{0,0,0},{0,0,0},{0,0,0}};
		zeroMatrix = new Matrix(zeroArr);
		int[][] oneArr = {{1,1,1},{1,1,1},{1,1,1}};
		oneMatrix = new Matrix(oneArr);
		int[][] twoArr = {{2,2,2},{2,2,2},{2,2,2}};
		twoMatrix = new Matrix(twoArr);
		int[][] aTimesBArr = {{8,16,24},{14,28,42},{20,40,60}};
		aTimesB = new Matrix(aTimesBArr);
		int[][] transposedArr = {{10,11,12}};
		transposedC = new Matrix(transposedArr);
	}
	
	@Test public void constructorTest() {
		constructorTester = new Matrix();
		assertEquals(3, constructorTester.getRows());
		assertEquals(3, constructorTester.getCols());
	}
	
	@Test public void constructorWithIntegerArgumentsTest() {
		constructorTester = new Matrix(2,2);
		assertEquals(2, constructorTester.getRows());
		assertEquals(2, constructorTester.getCols());
	}
	
	@Test public void constructorWithArrayArgumentTest() {
		int[][] arr = {{1,2,3},{4,5,6}};
		constructorTester = new Matrix(arr);
		assertEquals(constructorTester.getRows(), 2);
		assertEquals(constructorTester.getCols(), 3);
		assertEquals(constructorTester.getAtIndex(0, 0), 1);
	}
	
	@Test public void constructorWithMatrixArgumentTest() {
		constructorTester = new Matrix(c);
		assertEquals(3, constructorTester.getRows());
		assertEquals(1, constructorTester.getCols());
		assertEquals(10, constructorTester.getAtIndex(0, 0));
	}
	
	@Test public void getAtIndexTest() {
		assertEquals(2, a.getAtIndex(0, 2));
	}
	
	@Test public void getAtIndexExceptionTest() {
		Throwable e = assertThrows(IndexOutOfBoundsException.class, () -> a.getAtIndex(100, 0));
		assertEquals(("Index Out of Bounds"
				+ "\nCheck that your values for row and col are correct"
				+ " and try again."), e.getMessage());
		e = assertThrows(IndexOutOfBoundsException.class, () -> a.getAtIndex(0, 100));
		assertEquals(("Index Out of Bounds"
				+ "\nCheck that your values for row and col are correct"
				+ " and try again."), e.getMessage());
	}
	
	@Test public void setAtIndexTest() {
		setAtIndexTester = new Matrix();
		setAtIndexTester.setAtIndex(0, 0, 1);
		assertEquals(setAtIndexTester.getAtIndex(0, 0), 1);
	}
	
	@Test public void setAtIndexExceptionTest() {
		Throwable e = assertThrows(IndexOutOfBoundsException.class, () -> a.setAtIndex(100, 0, 0));
		assertEquals(("Index Out of Bounds"
				+ "\nCheck that your values for row and col are correct"
				+ " and try again."), e.getMessage());
		e = assertThrows(IndexOutOfBoundsException.class, () -> a.setAtIndex(0, 100, 0));
		assertEquals(("Index Out of Bounds"
				+ "\nCheck that your values for row and col are correct"
				+ " and try again."), e.getMessage());
	}
	
	@Test public void addTest() {
		assertEquals(true, d.equals(a.add(b)));
	}
	
	@Test public void addExceptionTest() {
		Throwable e = assertThrows(IllegalArgumentException.class, () -> a.add(diffCols));
		assertEquals(("\nCannot add matrices with dimesnions of "
					+ a.getRows() + "x" + a.getCols() + " and " + diffCols.getRows() + "x" + diffCols.getCols()
					+ ".\nTry different matrices where all dimensions match."), e.getMessage());
		e = assertThrows(IllegalArgumentException.class, () -> c.add(diffRows));
		assertEquals(("\nCannot add matrices with dimesnions of "
					+ c.getRows() + "x" + c.getCols() + " and " + diffRows.getRows() + "x" + diffRows.getCols()
					+ ".\nTry different matrices where all dimensions match."), e.getMessage());
	}
	
	@Test public void subtractTest() {
		assertEquals(true, d.subtract(d).equals(zeroMatrix));
	}
	
	@Test public void subtractExceptionTest() {
		Throwable e = assertThrows(IllegalArgumentException.class, () -> a.subtract(diffCols));
		assertEquals(("\nCannot subtract matrices with dimesnions of "
					+ a.getRows() + "x" + a.getCols() + " and " + diffCols.getRows() + "x" + diffCols.getCols()
					+ ".\nTry different matrices where all dimensions match."), e.getMessage());
		e = assertThrows(IllegalArgumentException.class, () -> c.subtract(diffRows));
		assertEquals(("\nCannot subtract matrices with dimesnions of "
					+ c.getRows() + "x" + c.getCols() + " and " + diffRows.getRows() + "x" + diffRows.getCols()
					+ ".\nTry different matrices where all dimensions match."), e.getMessage());
	}
	
	@Test public void scalarMultiplicationTest() {
		assertEquals(true, oneMatrix.multiply(2).equals(twoMatrix));
	}
	
	@Test public void multiplyTest() {
		assertEquals(true, aTimesB.equals(a.multiply(b)));
	}
	
	@Test public void multiplyExceptionTest() {
		Throwable e = assertThrows(IllegalArgumentException.class, () -> diffCols.multiply(diffRows));
		assertEquals(("\nCannot multiply matrices with dimesnions of "
				+ diffCols.getRows() + "x" + diffCols.getCols() + " and " + diffRows.getRows() + "x" + diffRows.getCols()
				+ ".\nTry different matrices where the columns of the first \nmatch the rows of the second."), e.getMessage());
	}
	
	@Test public void transposeTest() {
		assertEquals(true, transposedC.equals(c.transpose()));
	}
	
	@Test public void compareToTest() {
		assertEquals(Integer.MIN_VALUE, diffRows.compareTo(a));
		assertEquals(Integer.MAX_VALUE, diffCols.compareTo(b));
		assertEquals(0, a.compareTo(a));
		assertEquals(9, oneMatrix.compareTo(zeroMatrix));
	}
	
	@Test public void equalsTest() {
		assertEquals(false, a.equals(diffRows));
		assertEquals(false, a.equals(diffCols));
		assertEquals(false, a.equals(b));
		assertEquals(false, a.equals(new Matrix(5,5)));
		assertEquals(true, a.equals(a));
	}
	
	@Test public void toStringTest() {
		assertEquals("[0 0 0]\n[0 0 0]\n[0 0 0]", zeroMatrix.toString());
	}

}
