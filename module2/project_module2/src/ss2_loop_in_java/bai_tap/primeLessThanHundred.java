package ss2_loop_in_java.bai_tap;

public class primeLessThanHundred {
    public static void main(String[] args) {
        int numbers = 100;
        int n=0;
        while(n<numbers){
            if(isPrime(n)){
                System.out.printf("%d\t", n);
            }
            n++;
        }
    }

    public static boolean isPrime(int number){
        if(number < 2){
            return false;
        }
        else{
            for(int i=2; i<number; i++){
                if(number % i == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
