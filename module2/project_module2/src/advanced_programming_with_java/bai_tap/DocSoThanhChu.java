package advanced_programming_with_java.bai_tap;

import java.util.Scanner;

public class DocSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap so muon doc thanh chu: ");
        int number = scanner.nextInt();

        if(number >= 0 && number <= 10){
            switch (number){
                case 0 -> System.out.println("Zero");
                case 1 -> System.out.println("One");
                case 2 -> System.out.println("Two");
                case 3 -> System.out.println("Three");
                case 4 -> System.out.println("Four");
                case 5 -> System.out.println("Five");
                case 6 -> System.out.println("Six");
                case 7 -> System.out.println("Seven");
                case 8 -> System.out.println("Eight");
                case 9 -> System.out.println("Nine");
                case 10 -> System.out.println("Ten");
            }
        }
        else if(number < 20){
            int n = number % 10;
            switch (n){
                case 1 -> System.out.println("Eleven");
                case 2 -> System.out.println("Twelve");
                case 3 -> System.out.println("Thirteen");
                case 4 -> System.out.println("Fourteen");
                case 5 -> System.out.println("Fifteen");
                case 6 -> System.out.println("Sixteen");
                case 7 -> System.out.println("Seventeen");
                case 8 -> System.out.println("Eighteen");
                case 9 -> System.out.println("Nineteen");
            }
        }

        else if(number > 20 && number < 100){
            int dozens = number / 10;
            int units = number % 10;
            String str="";
            switch (dozens){
                case 2 -> str = "Twenty";
                case 3 -> str = "Thirty";
                case 4 -> str = "Forty";
                case 5 -> str = "Fifty";
                case 6 -> str = "Sixty";
                case 7 -> str = "Seventy";
                case 8 -> str = "Eighty";
                case 9 -> str = "Ninety";
            }
            switch (units){
                case 0 -> str += "";
                case 1 -> str += "-one";
                case 2 -> str += "-two";
                case 3 -> str += "-three";
                case 4 -> str += "-four";
                case 5 -> str += "-five";
                case 6 -> str += "-six";
                case 7 -> str += "-seven";
                case 8 -> str += "-eight";
                case 9 -> str += "-nine";
            }
            System.out.printf("So thanh chu: %s", str);
        }
        else if(number >=100 && number < 1000){
            int hundreds = number / 100;
            int dozens = number%100;
            int units = number % 10;
            String str = "";

            switch (hundreds){
                case 1 -> str = "One hundred and ";
                case 2 -> str = "Two hundred and ";
                case 3 -> str = "Three hundred and ";
                case 4 -> str = "Four hundred and ";
                case 5 -> str = "Five hundred and ";
                case 6 -> str = "Six hundred and ";
                case 7 -> str = "Seven hundred and ";
                case 8 -> str = "Eight hundred and ";
                case 9 -> str = "Nine hundred and ";
            }
            if(dozens >= 10 && dozens < 20){
                switch (dozens){
                    case 10 -> str += "ten";
                    case 11 -> str += "eleven";
                    case 12 -> str += "twelve";
                    case 13 -> str += "Thirteen";
                    case 14 -> str += "Fourteen";
                    case 15 -> str += "Fifteen";
                    case 16 -> str += "Sixteen";
                    case 17 -> str += "Seventeen";
                    case 18 -> str += "Eighteen";
                    case 19 -> str += "Nineteen";
                }
            }
            else {
                int m = dozens / 10;
                System.out.println(m);
                switch (m) {
                    case 2 -> str += "twenty ";
                    case 3 -> str += "thirty ";
                    case 4 -> str += "forty ";
                    case 5 -> str += "fifty ";
                    case 6 -> str += "sixty ";
                    case 7 -> str += "seventy ";
                    case 8 -> str += "eighty ";
                    case 9 -> str += "ninety ";
                }
                switch (units){
                    case 1 -> str += "one";
                    case 2 -> str += "two";
                    case 3 -> str += "three";
                    case 4 -> str += "four";
                    case 5 -> str += "five";
                    case 6 -> str += "six";
                    case 7 -> str += "seven";
                    case 8 -> str += "eight";
                    case 9 -> str += "nine";
                }
            }
            System.out.printf("So thanh chu: %s", str);
        }
        else{
            System.out.println("Out of ability");
        }
    }
}
