package _ARetroPractice;


import java.util.concurrent.ExecutionException;

public class QuadraticEquation {
    public static Roots findRoots(double a, double b, double c) {
        double x1 = (-b+Math.sqrt(b*b-4*a*c))/(2*a);
        double x2 = (-b-Math.sqrt(b*b-4*a*c))/(2*a);

        return new Roots(x1, x2);

    }

    public static void main(String[] args) {
        try{
            throw new Exception("hello");
        }
        catch (Exception e){
            System.out.println("hello");
        }
        finally {
            System.out.println("finally");
        }
        System.out.println("exit");
    }
}

class Roots {
    public final double x1, x2;

    public Roots(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}
