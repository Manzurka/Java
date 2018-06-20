import java.util.ArrayList;
public class Exceptions {
    public static void Exc(){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        for (Object obj : myList) {
            try {
                Integer castedValue = (Integer) obj;
                System.out.println(castedValue);
                myList.set(myList.indexOf(castedValue), castedValue);
            } catch (ClassCastException e) {
                System.out.println("Error on index " + myList.indexOf(obj));
            }
        }
    }

}