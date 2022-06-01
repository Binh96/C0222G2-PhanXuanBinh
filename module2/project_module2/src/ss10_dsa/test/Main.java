package test;

public class Main {
    public static void main(String[] args) {
        int h = 10;
        for(int i=1; i<=h  ; i++){
            for(int j  = i; j <=h ; j++){
                System.out.print(" ");
            }
            for(int k=1; k<=i*2 ; k++){
                if(k==1 || (k==(i*2-1)) || i==h){
                    System.out.print(" ");
                }
                else{
                    System.out.print("*");
                }
            }
        }
    }
}
