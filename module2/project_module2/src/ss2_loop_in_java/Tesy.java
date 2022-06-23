package ss2_loop_in_java;

public class Tesy {
    public static void main(String[] args) {
        String str = "abcbdcef";
        check(str);
    }

    public static void check(String string){
        String[] arr = string.split("");
        System.out.println(arr.toString());
    }
}
