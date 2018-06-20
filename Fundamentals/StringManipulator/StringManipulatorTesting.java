public class StringManipulatorTesting {
    public static void main(String[] args) {
    StringManipulator manipulator = new StringManipulator();
    System.out.println(manipulator.trimAndConcat("    Hello     ","     World    "));
    System.out.println(manipulator.getIndexOrNull("Coding",'o'));
    System.out.println(manipulator.getIndexOrNull("Hello World", 'o')); 
    System.out.println(manipulator.getIndexOrNull("Hi", 'o'));
    System.out.println(manipulator.getIndexOrNull("HelloWorld", "ello"));
    System.out.println(manipulator.concatSubstring("Hello", 1, 2, "world"));
    }
}