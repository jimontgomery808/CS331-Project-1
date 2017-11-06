
package cs331.project.pkg1;

import java.util.*;

/**
 *  This class will take two nxn size matrices and multiply them using
 *  Strassen's multiplication algorithm
 */
class Strassen
{
    private int N;      // matrix size
    private int[][] A;  // first matrix
    private int[][] B;  // second matrix
    
    public Strassen(int size)
    {
        A = new int[size][size];
        B = new int[size][size];
        N = size;
    }
    
    public void setA(int[][] arr)
    {
        A = Arrays.copyOf(arr, arr.length);
    }
    
    public void setB(int arr[][])
    {
        B = Arrays.copyOf(arr, arr.length);
    }
    
    public int[][] getA()
    {
        return A;
    }
    public int[][] getB()
    {
        return B;
    }
    public int getSize()
    {
        return N;
    }
    
    
    public int[][] calculate(int[][]a, int[][]b)
    {
        int n = a.length;
        int[][] R = new int[n][n];
        if(n==1)
                R[0][0] = a[0][0]*b[0][0];
        else
        {
                int[][] a11 = new int[n/2][n/2];
                int[][] a12 = new int[n/2][n/2];
                int[][] a21 = new int[n/2][n/2];
                int[][] a22 = new int[n/2][n/2];
                int[][] b11 = new int[n/2][n/2];
                int[][] b12 = new int[n/2][n/2];
                int[][] b21 = new int[n/2][n/2];
                int[][] b22 = new int[n/2][n/2];

                split(a,a11,0,0);
                split(a,a12,0,n/2);
                split(a,a21,n/2,0);
                split(a,a22,n/2,n/2);
                split(b,b11,0,0);
                split(b,b12,0,n/2);
                split(b,b21,n/2,0);
                split(b,b22,n/2,n/2);

                int [][] M1 = calculate(add(a11, a22), add(b11, b22));
                int [][] M2 = calculate(add(a21, a22), b11);
                int [][] M3 = calculate(a11, sub(b12, b22));
                int [][] M4 = calculate(a22, sub(b21, b11));
                int [][] M5 = calculate(add(a11, a12), b22);
                int [][] M6 = calculate(sub(a21, a11), add(b11, b12));
                int [][] M7 = calculate(sub(a12, a22), add(b21, b22));

                int [][] C11 = add(sub(add(M1, M4), M5), M7);
                int [][] C12 = add(M3, M5);
                int [][] C21 = add(M2, M4);
                int [][] C22 = add(sub(add(M1, M3), M2), M6);

                join(C11, R, 0 , 0);
                join(C12, R, 0 , n/2);
                join(C21, R, n/2, 0);
                join(C22, R, n/2, n/2);


        }
        return R;
    }

    public static void split(int[][]P,int[][]C,int iB,int jB)
    {
        int i2 = iB;
        for(int i1=0;i1< C.length;i1++)
        {
                int j2 = jB;
                for(int j1=0; j1<C.length;j1++)
                {
                        C[i1][j1] = P[i2][j2];
                        j2++;
                }
                i2++;
        }
    }

    // Strasen addition component
    public static int[][] add(int[][] a,int[][] b)
    {
        int n = a.length;
        int[][] c = new int[n][n];
        for(int i = 0;i<n;i++)
        {
                for(int j=0;j<n;j++)
                        c[i][j] = a[i][j] + b[i][j];
        }
        return c;
    }

    // Strasen subtraction component
    public static int[][] sub(int[][] a,int[][] b)
    {
        int n = a.length;
        int[][] c = new int[n][n];
        for(int i = 0;i<n;i++)
        {
                for(int j=0;j<n;j++)
                        c[i][j] = a[i][j] - b[i][j];
        }
        return c;
    }
    
    // Strasen join component
    public static void join(int[][]P,int[][]C,int iB,int jB)
    {
        int i2 = iB;
        for(int i1=0;i1< P.length;i1++)
        {
                int j2 = jB;
                for(int j1=0; j1< P.length;j1++)
                {
                        C[i2][j2] = P[i1][j1];
                        j2++;
                }
                i2++;
        }
    }
    
    // prints matrices
    public void print(int arr[][], String type)
    {
      String space = getSpacing(type);
      String format = "%" + space + "d";
      for(int i = 0; i < N; i ++)
        {
            System.out.print("| ");
            for(int j = 0; j < N; j ++)
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
            tempNum = String.valueOf(N*N*N*N*N).length();
        }
        else if(type.equals("multiplier"))
        {
            tempNum = String.valueOf(N*N).length();
        }
        String spacing = Integer.toString(tempNum);
        return spacing;
    }
}
