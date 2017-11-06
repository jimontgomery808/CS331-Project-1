
/*
    Josh Montgomery
    CS 331 Fall 2017
    T/Th 3:00pm
    G Young
*/
package cs331.project.pkg1;

/*
 * CS 331 PROJECT #1: Matrix Algorithm Analysis
 ----------------------------------------------------------------------------
 This test will run and analyze the time complexity of three different matrix
 multiplication algorithms. Each algorithm is contained in its own 'for-loop' 
 which will run the number of times equal to the variable NUM_TESTS. For this
 test I decided to run each algorithm 100 times. Each test will use the same
 matrices to multiply in order to be as accurate as possible.
 */
public class CS331Project1 
{
    public static void main(String[] args) 
    {
        final int SIZE = 256;       // matrix size of current test
        final int NUM_TESTS = 100;  // number of times to run each test
        double totalTime = 0;       // counter
        double averageTime = 0.0;   // counter
        
        // Different Matrix sizes
        Matrix A2 = new Matrix(2);
        Matrix B2 = new Matrix(2);
        Matrix A4 = new Matrix(4);
        Matrix B4 = new Matrix(4);
        Matrix A8 = new Matrix(8);
        Matrix B8 = new Matrix(8);
        Matrix A16 = new Matrix(16);
        Matrix B16 = new Matrix(16);
        Matrix A32 = new Matrix(32);
        Matrix B32 = new Matrix(32);
        Matrix A64 = new Matrix(64);
        Matrix B64 = new Matrix(64);
        Matrix A128 = new Matrix(128);
        Matrix B128 = new Matrix(128);
        Matrix A256 = new Matrix(256);
        Matrix B256 = new Matrix(256);
        Matrix A512 = new Matrix(512);
        Matrix B512 = new Matrix(512);
        
    
        /*
            CLASSICAL MATRIX MULTIPLICATION TEST
            ------------------------------------------------------------------
            This test will run NUM_TESTS number of times and take the average
            time. It utlizes the classic matrix multiplication algorithm
        */
       for(int i = 0; i < NUM_TESTS; i ++)
        {
            ClassicMultiplication test = new ClassicMultiplication(SIZE);
            test.setA(A256.getMatrix());
            test.setB(B256.getMatrix());
            // Start timing
            double start = System.nanoTime();
            // Perform classic multiplication
            test.classicalMutliplication();
            // End timing
            double end = System.nanoTime();
            totalTime += (end - start);
        }
       
        averageTime = totalTime/NUM_TESTS;
        System.out.println("Classical Multiplication Test:\n"
                           + "Time taken for n = "+ SIZE +" is : "
                           +averageTime/1000000000 + " Seconds");
        System.out.println();
        
        
        /*
            DIVIDE AND CONQUER MATRIX MULTIPLICATION TEST
            ------------------------------------------------------------------
            This test will run NUM_TESTS number of times and take the average
            time. It utlizes the divde and conquer matrix multiplication 
            algorithm
        */
        
        totalTime = 0.0;
        averageTime = 0.0;
        for(int i = 0; i < NUM_TESTS; i ++)
        {
            DivideAndConquer test = new DivideAndConquer(SIZE);
            test.setA(A256.getMatrix());
            test.setB(B256.getMatrix());
            // Start timing
            double start = System.nanoTime();
            // Perform divide and conquer multiplication
            int[][]arr = test.multEntryPoint(test.getA(),test.getB(),test.getSize());
            // End timing
            double end = System.nanoTime();
            totalTime += (end-start);
        }
        averageTime = totalTime/NUM_TESTS;
        System.out.print("Divide and Conquer Test:\n"
                         + "Time taken for n = "+ SIZE +" is : "
                         +averageTime/1000000000 + " Seconds");
        System.out.println();
        System.out.println();
        
        
        /*
            STRASSEN MATRIX MULTIPLICATION TEST
            ------------------------------------------------------------------
            This test will run NUM_TESTS number of times and take the average
            time. It utlizes Strassen's matrix multiplication algorithm
        */
        totalTime = 0.0;
        averageTime = 0.0;
        for(int i = 0; i < NUM_TESTS; i ++)
        {
            Strassen test = new Strassen(SIZE);
            test.setA(A256.getMatrix());
            test.setB(B256.getMatrix());
            // Start timing
            double start = System.nanoTime();
            // Perform Strassen's multiplication
            int[][]arr = test.calculate(test.getA(),test.getB());
            // End timing
            double end = System.nanoTime();
            totalTime += (end-start);
        }
        averageTime = totalTime/NUM_TESTS;
        System.out.println("Strassen Test:\n"
                           + "Time taken for n = "+ SIZE +" is : "
                           +averageTime/1000000000 + " Seconds");
        
    }
    
}
