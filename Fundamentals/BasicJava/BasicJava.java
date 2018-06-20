import java.util.ArrayList;
public class BasicJava {
    public static void Print1to255(){
        for (int i=1; i<256; i++){
            System.out.println(i);
        }
    }
    public static void PrintOdd1to255(){
        for (int i=1; i<256; i+=2){
            System.out.println(i);
        }
    }
    public static void PrintSum1to255(){
        int sum =0;
        for (int i=1; i<256; i++){
            sum = sum + i;
        }
        System.out.println(sum);
    }
    public static void Iterate(int[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static void FindMax(int[] arr){
        int max=arr[0];
        for (int i=0; i<arr.length; i++){
            if (arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println(max);
    }
    public static void PrintAverage(int[] arr){
        int sum =0;
        for (int i=0; i<arr.length; i++){
            sum = sum + arr[i];
        }
        int average = sum/arr.length;
        System.out.println(average);
    }
    public static void ArrayOdd1to255(){
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        for (int i=1; i<256; i+=2){
            myArray.add(i);
        }
        System.out.println(myArray);
    }
    public static void GreaterThanY(int[] arr, int y){
        int count=0;
        for (int i=0; i<arr.length; i++){
            if(arr[i]>y) {
                count+=1;
            }
        }
        System.out.println(count);
    }
    public static void SquareArrayValues(int[] arr){
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        for (int i=0; i<arr.length; i++){
            newArray.add(arr[i]*arr[i]);
        }
        System.out.println(newArray);
    }
    public static void EliminateNegativeValues(int[] arr){
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        for (int i=0; i<arr.length; i++){
            if (arr[i]<0){
                arr[i]=0;
            }
            newArray.add(arr[i]);
        }
        System.out.println(newArray);
    }
    public static void MaxMinAverage(int[] arr){
        ArrayList<Double> newArray = new ArrayList<Double>();
        double max=arr[0]; 
        double min=arr[0];
        double sum=arr[0];
        for(int i=0; i<arr.length; i++){
            if (arr[i] > max){
                max=arr[i];
            }
            if (arr[i] < min){
                min=arr[i];
            }
            sum+=arr[i];
        }
        double avg=sum/arr.length;
        newArray.add(max);
        newArray.add(min);
        newArray.add(avg);
        System.out.println(newArray);
    } 
    public static void ShiftArrayValues(int[] arr){
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        int temp=arr[0];
        for(int i=0; i<arr.length-1; i++){
            arr[i]=arr[i+1];
            newArray.add(arr[i]);
        }
        arr[arr.length-1]=temp;
        newArray.add(0);
        System.out.println(newArray);
    }
}