package rref;

import org.apfloat.Apint;

public class Matrix {
	
	private Fraction[][] matrix;
	
	public Matrix(Fraction[][] matrx) {
		this.matrix = matrx;
	}
	
	public void rref() {
		for (int col = 0; col<matrix[0].length-1; col++) {
			for (int row = 0; row<matrix.length; row++) {
				Fraction multiple = new Fraction(Apint.ONE,Apint.ONE);
				if(matrix[row][col].equals(new Fraction(Apint.ZERO,Apint.ONE))==false) {
					multiple = matrix[col][col].divide(matrix[row][col]);
//					System.out.println(multiple + " " + row + " " + col + " " + matrix[col][col] + " " + matrix[row][col]);
				}
				if (col<row) {
					multrowadd(multiple, col, row);
				}
				else if (col>row) {
					multrowadd(multiple, col, row);
				}
			}
		}
		for (int i = 0; i<matrix.length; i++) {
			for (int col = 0; col<matrix[0].length-1; col++) {
				matrix[i][col]=matrix[i][col].divide(matrix[col][col]);
			}
		}
	}
	private void multrowadd(Fraction multiple, int row1, int row2) {
		for (int col = 0; col<matrix[0].length; col++) {
			matrix[row2][col]=matrix[row1][col].subtract(matrix[row2][col].multiply(multiple));
		}
	}
	public String toString() {
		String grid = "";
		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix[i].length; j++) {
		        grid += matrix[i][j] + " ";
		    }
		    grid += "\n";
		}
		return grid;
	}
	public String toStringLast() {
		String grid = "";
		for (int j = 0; j < matrix.length; j++) {
		    grid += matrix[j][matrix.length] + "\n";
		}
		return grid;
	}

}
