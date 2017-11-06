
package cs331.project.pkg1;

import java.util.Arrays;
import java.util.Random;

/**
 *  This class will take two nxn size matrices and multiply them using the 
 * classic matrix multiplication algorithm
 */
public class ClassicMultiplication 
{
    private int [][] A;     // first matrix
    private int [][] B;     // second matrix
    private int[][] result; // result matrix
    private int n;          // size of matrix
    
    public ClassicMultiplication(int size)
    {
        n = size;
        A = new int[n][n];
        B = new int[n][n];
        result = new int[n][n];
    }
    
    public int[][] getA()
    {
        return A;
    }
    public int[][] getB()
    {
        return B;
    }
    public int[][] getResult()
    {
        return result;
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
    
    public void clearResult()
    {
        result = new int[n][n];
    }
    
    // Classical multiplication algorithm
    public void classicalMutliplication()
    {
        // Three nested for loops, goes through each index and multiplies each
        // index
         for (int i = 0; i < n; i++) 
         { 
            for (int j = 0; j < n; j++) 
            { 
                for (int k = 0; k < n; k++) 
                {
                    result[i][j] += A[i][k] * B[k][j];
                }
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
