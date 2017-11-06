/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs331.project.pkg1;

import java.util.Random;

/**
 * This is a simple class which creates a matrix and fill it with random values
 */
public class Matrix 
{
    private int [][] matrix;
    private int n;
    
    public Matrix(int size)
    {
        matrix = new int[size][size];
        n = size;
        initArrayRandom();
    }
    
    public int[][] getMatrix()
    {
        return matrix;
    }
    
    // initialzes values to random values
    public void initArrayRandom()
    {
        Random rand = new Random();
        
        for(int i = 0; i < n; i ++)
        {
            for(int j = 0; j < n; j ++)
            {
                matrix[i][j] = rand.nextInt(n*n) + 1;
            }
        }
    }
}
