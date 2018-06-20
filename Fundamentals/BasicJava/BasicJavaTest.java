public class BasicJavaTest {
    public static void main(String[] args) {
         BasicJava list = new BasicJava();
         list.Print1to255();
         list.PrintOdd1to255();
         list.PrintSum1to255();
         int [] array1 = {1,3,5,7,9,13};
         list.Iterate(array1);
         int [] array2 = {-3, -5, -7};
         list.FindMax(array2);
         list.PrintAverage(array1);
         list.ArrayOdd1to255();
         int [] array3 = {1, 3, 5, 7};
         list.GreaterThanY(array3, 3);
         int [] array4 ={1, 5, 10, -2};
         list.SquareArrayValues(array4);
         list.EliminateNegativeValues(array4);
         list.EliminateNegativeValues(array2);
         list.MaxMinAverage(array4);
         int [] array5 ={1, 5, 10, 7, -2};
         list.ShiftArrayValues(array5);
    } 
}