public class FizzBuzz {
    public String fizzBuzz(int number) {
        boolean canBeDevidedBy3 =(number % 3) == 0;
        boolean canBeDevidedBy5 =(number % 5) == 0;
        
        if(number %3 == 0){
            if(number %5 == 0){
                return "FizzBuzz";
            } else {
                return "Fizz";
            }          
        } else if(number %5 == 0) {
            return "Buzz";
        } else {
            String numberAsString = Integer.toString(number);
            return numberAsString;
        }
    }
}