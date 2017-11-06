
package cs331.project.pkg1;

import java.util.*;

/**
 *  This class will take two nxn size matrices and multiply them using the 
 *  divide and conquer matrix multiplication algorithm
 */
class DivideAndConquer
{
    private int n;  // array size
    int [][]A;      // first array 
    int [][]B;      // second array
    int [][]C;      // result array
    
    public DivideAndConquer(int size)
    {
        n = size;
        A = new int[n][n];
        B = new int[n][n];
        C = new int[n][n];
    }
    
    public int[][] getA()
    {
        return A;
    }
    public int[][] getB()
    {
        return B;
    }
    public int[][] getC()
    {
        return C;
    }
    
    public int getSize()
    {
        return n;
    }
    
    public void setA(int[][] arr)
    {
        A = Arrays.copyOf(arr, arr.length);
    }
    
    public void setB(int arr[][])
    {
        B = Arrays.copyOf(arr, arr.length);
    }
    

    // Entry point into recursive multiplication function
    public int[][] multEntryPoint(int[][] A, int[][] B, int n)
    {

        return  multiplicationRecursion(A, B, 0, 0, 0, 0, n);

    }

    // Recursive divide and conquer multpilication function
    public int[][] multiplicationRecursion(int[][] A, int[][] B, int matrixARow, int matrixAColumn, int matrixBRow, int matrixBColumn, int size)
    {
        int[][] C = new int[size][size];
        
        // base case
        if(size == 1)
        {
            C[0][0]= A[matrixARow][matrixAColumn]*B[matrixBRow][matrixBColumn];
        }

        // Split matrix into 4 quadrants and recurisvely multiply the elements
    	else
	{
            int newSize= size/2;
            addMatrices(C,multiplicationRecursion(A, B, matrixARow, matrixAColumn, matrixBRow, matrixBColumn, newSize),multiplicationRecursion(A, B, matrixARow, matrixAColumn+newSize, matrixBRow+ newSize, matrixBColumn, newSize),0, 0);

            addMatrices(C,multiplicationRecursion(A, B, matrixARow, matrixAColumn, matrixBRow, matrixBColumn + newSize, newSize),multiplicationRecursion(A, B, matrixARow, matrixAColumn+newSize, matrixBRow+ newSize, matrixBColumn+newSize, newSize),0, newSize);

            addMatrices(C,multiplicationRecursion(A, B, matrixARow+ newSize, matrixAColumn, matrixBRow, matrixBColumn, newSize), multiplicationRecursion(A, B, matrixARow+ newSize, matrixAColumn+newSize, matrixBRow+ newSize, matrixBColumn, newSize),newSize, 0);

            addMatrices(C,multiplicationRecursion(A, B, matrixARow+ newSize, matrixAColumn, matrixBRow, matrixBColumn+newSize, newSize),multiplicationRecursion(A, B, matrixARow+ newSize, matrixAColumn+newSize, matrixBRow+ newSize, matrixBColumn+newSize, newSize),newSize, newSize);
    	}
        return C;
    }


    // Nested for loop to add matrices
    private void addMatrices(int[][] C, int[][]A, int[][]B, int matrixCRow, int matrixCColumn)
    {
        int n=A.length;
        for(int i =0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                C[i+matrixCRow][j+matrixCColumn]=A[i][j]+B[i][j];
            }
        }

    }
    
    // Prints array
    public void print(int arr[][], String type)
    {
      String space = getSpacing(type);
      String format = "%" + space + "d";
      for(int i = 0; i < n; i ++)
        {
            System.out.print("| ");
            for(int j = 0; j < n; j ++)
            {
                System.out.printf(format, arr[i][j]);
                System.out.print(" ");
            }
            System.out.println("|");
        }
    }
    
    // Spacing needed to output array brackets
    public String getSpacing(String type)
    {
        int tempNum = 0;
        if(type.equals("result"))
        {
            tempNum = String.valueOf(n*n*n*n*n).length();
        }
        else if(type.equals("multiplier"))
        {
            tempNum = String.valueOf(n*n).length();
        }
        String spacing = Integer.toString(tempNum);
        return spacing;
    }
    
}