package ss6_inheritance.bai_tap.bai_tap_4;

import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Triangle triangle = new Triangle();
        System.out.println(triangle);

        System.out.print("Enter color: ");
        String color = input.nextLine();

        System.out.print("Enter side 1: ");
        double side1 = input.nextDouble();

        System.out.print("Enter side 2: ");
        double side2 = input.nextDouble();

        System.out.print("Enter side 3: ");
        double side3 = input.nextDouble();

        System.out.print("Enter height: ");
        double height = input.nextDouble();

        Triangle triangle1 = new Triangle(side1, side2, side3, height, color);
        System.out.println(triangle1);
        System.out.print("side1: "+ side1);
        System.out.print("side3: "+ side3);

    }
}
