import java.util.Arrays;
import java.util.Collections;
public class PuzzlingTest {
    public static void main(String[] args) {
       Puzzling arrays= new Puzzling();
       int[] array1 = {3,5,1,2,7,9,8,13,25,32};
       arrays.SumOfValues(array1);
       String[] array2 = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
       arrays.Shuffle(array2);
       arrays.Alphabet();
       arrays.ReturnRandomNums();
       arrays.ReturnRandomNumsSorted();
       arrays.generateRandomString("abcdefghijklmnopqrstuvwxyz", 5);
       arrays.generateRandomStringsArray("abcdefghijklmnopqrstuvwxyz", 5);
    }
}