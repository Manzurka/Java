
public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB) {
       double a =  legA;
       double b =  legB;
       double cSquared = ((a*a)+(b*b));
       double c = Math.sqrt(cSquared);
       return c;
    }
}