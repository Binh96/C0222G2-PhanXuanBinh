package ss11_dsa_stack_queue.bai_tap.organize;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class OrganizeData {
    public static void main(String[] args) {
        Queue<String> NU = new LinkedList<>();
        Queue<String> NAM = new LinkedList<>();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter num: ");
        int num = Integer.parseInt(input.nextLine());
        Person[] person = new Person[num];

        for(int i = 0; i < num; i++){
            System.out.print("Enter name: ");
            String name = input.nextLine();
            System.out.print("Enter gender: ");
            String gender = input.nextLine();
            person[i] = new Person(name, gender);
        }

        for (Person value : person) {
            if (value.getGender().equals("female")) {
                NU.add(String.valueOf(value));
            } else {
                NAM.add(String.valueOf(value));
            }
        }

        System.out.println(NU);
        System.out.println(NAM);
    }
}
