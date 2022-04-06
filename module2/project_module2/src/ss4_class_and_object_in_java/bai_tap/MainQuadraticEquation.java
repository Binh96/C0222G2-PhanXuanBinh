package ss4_class_and_object_in_java.bai_tap;

import java.util.Scanner;

public class MainQuadraticEquation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = input.nextDouble();
        System.out.print("Enter b: ");
        double b = input.nextDouble();
        System.out.print("Enter c: ");
        double c = input.nextDouble();

        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        System.out.println("Delta: "+ quadraticEquation.getDiscriminant());

        if(quadraticEquation.getDiscriminant()>=0){
            System.out.println("Root 1: "+ quadraticEquation.getRoot1());
            System.out.println("Root 2: "+ quadraticEquation.getRoot2());
        }
        else if(quadraticEquation.getDiscriminant()==0){
            System.out.println("Two root equal each other");
            System.out.println("Root: "+ quadraticEquation.getRoot1());
        }
        else{
            System.out.println("The equation has no roots");
        }
    }
}
