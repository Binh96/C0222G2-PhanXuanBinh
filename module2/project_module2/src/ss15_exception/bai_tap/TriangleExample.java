package ss15_exception.bai_tap;

import java.util.Scanner;

public class TriangleExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap canh a: ");
        double a = Double.parseDouble(input.nextLine());
        System.out.print("Nhap canh b: ");
        double b = Double.parseDouble(input.nextLine());
        System.out.print("Nhap canh c: ");
        double c = Double.parseDouble(input.nextLine());

        TriangleExample triangleExample = new TriangleExample();
        triangleExample.triangle(a,b,c);
    }

    private void triangle(double a, double b, double c){
        try{
            if(a>0 && b > 0 && c >0){
                if((a+b) > c &&  (b+c) >a && (c+a) > b){
                    System.out.println("Canh a: "+a+", canh b: "+b+", canh c: "+ c);
                }
                else {
                    throw new illegalTriangleException();
                }
            }
            else{
                throw new illegalTriangleException();
            }
        } catch (illegalTriangleException e) {
            e.printStackTrace();
        } finally {
            System.out.println("The 'try, catch' is finished");
        }
    }

    public static class illegalTriangleException extends Throwable {
        @Override
        public String toString() {
            return "Something went wrong";
        }
    }
}
