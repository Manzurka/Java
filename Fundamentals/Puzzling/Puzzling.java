import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
public class Puzzling {
    public static void SumOfValues(int[] arr){
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        int sum =0;
        for (int i=0; i<arr.length; i++){
                sum += arr[i];
                if(arr[i]>10){
                    newArray.add(arr[i]);
                }
        }
        System.out.println(sum);
        System.out.println(newArray);
    }

    public static void Shuffle(String[] arr){
        ArrayList<String> newArray = new ArrayList<String>();
        for (int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
            if(arr[i].length()>5){
                newArray.add(arr[i]);
            }
        }
        System.out.println(newArray);
    }   
    
    public static void Alphabet(){
        char[] alpha = new char[26];
        int k = 0;
        for(int i = 0; i < 26; i++){
            alpha[i] = (char)(97 + (k++));
            if (alpha[i]=='a' || alpha[i]=='o' || alpha[i]=='e' || alpha[i]=='i' || alpha[i]=='u'){
                System.out.println("It is a vowel at the index of " +i);
            }
        }
        System.out.println(alpha);
        System.out.println(alpha[0]);
        System.out.println(alpha[25]);
    }  

    public static void ReturnRandomNums(){
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++) {
            newArray.add((int)(Math.random()*100 + 55));
        }
        System.out.println(newArray);
    }

    public static void ReturnRandomNumsSorted(){
        ArrayList<Integer> newArrayList = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++) {
            newArrayList.add((int)(Math.random()*100 + 55));
        }
        Collections.sort(newArrayList);
        System.out.println(newArrayList);
        Integer min = Collections.min(newArrayList);
        Integer max = Collections.max(newArrayList);
        System.out.println(min);
        System.out.println(max);
        // int min=newArrayList.get(0);
        // int max=newArrayList.get(0);
        // for(int i = 0; i < 10; i++){
        //     if(newArrayList.get(i) > max){
        //     max = newArrayList.get(i);
        //     }
        //     if(newArrayList.get(i) < min){
        //     min = newArrayList.get(i);
        //     }
        // }
        // System.out.println(min);
        // System.out.println(max);
    }

    public static void generateRandomString(String candidateChars, int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }
        System.out.println(sb.toString());
    }

    public static void generateRandomStringsArray(String candidateChars, int length){
        ArrayList<String> list = new ArrayList<String>();
        for(int index = 0; index < 10; index++) {
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            for (int i = 0; i < length; i++) {
                sb.append(candidateChars.charAt(random.nextInt(candidateChars
                        .length())));
            }
            list.add(sb.toString());
        }
        System.out.println(list);
    }
    
}

