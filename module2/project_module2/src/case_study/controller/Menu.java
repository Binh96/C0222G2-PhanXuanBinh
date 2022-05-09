package case_study.controller;

import case_study.service.impl.ICustomerServiceImpl;
import case_study.service.impl.IEmployeeServiceImpl;
import case_study.service.impl.IFacilityServiceImpl;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    IEmployeeServiceImpl employeeService = new IEmployeeServiceImpl();
    ICustomerServiceImpl customerService = new ICustomerServiceImpl();
    IFacilityServiceImpl facilityService = new IFacilityServiceImpl();
    public void displayMenu(){
        boolean flag = true;
        do{
            System.out.println("------* Welcome to Furama resort *-------");
            System.out.println("---------------* Menu *--------------");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.print("Enter your choose: ");
            try{
                int num = Integer.parseInt(sc.nextLine());
                switch (num){
                    case 1 -> {
                        System.out.println("--------* Employee management *-----------");
                        subMenuForEmployee();
                    }
                    case 2 -> {
                        System.out.println("--------* Customer management *-----------");
                        subMenuForCustomer();
                    }
                    case 3 -> {
                        System.out.println("--------* Facility management *-----------");
                        subMenuForFacility();
                    }
                    case 4 -> {
                        System.out.println("--------* Booking management *-----------");
                        subMenuForBooking();
                    }
                    case 5 -> {
                        System.out.println("--------* Promotion management *-----------");
                        subMenuForPromotion();
                    }
                    case 6 -> {
                        System.out.println("--------* You're out *-----------");
                        flag = false;
                    }
                    default -> System.out.println("It's not an option!");
                }
            }
            catch (NumberFormatException e){
                System.err.println("Something goes wrong, please check input!");
                e.printStackTrace();
            }
        }while(flag);
    }

    public void subMenuForEmployee(){
        boolean flag = true;
        do{
            System.out.print("""
                            1. Display list employees
                            2. Add new employee
                            3. Edit employee
                            4. Return menu
                            """
            );
            System.out.print("Enter your choose: ");
            try {
                int num = Integer.parseInt(sc.nextLine());
                switch (num) {
                    case 1 -> {
                        System.out.println("--------* Display list employees *-----------");
                        employeeService.display();
                    }
                    case 2 -> {
                        System.out.println("--------* Add new employee *-----------");
                        employeeService.add();
                    }
                    case 3 -> {
                        System.out.println("--------* Edit employee *-----------");
                        employeeService.edit();
                    }
                    case 4 -> {
                        System.out.println("--------* you returned main menu *-----------");
                        flag = false;
                    }
                    default -> System.out.println("It's not an option!");
                }
            }
            catch (NumberFormatException e){
                System.err.println("Something goes wrong, please check input!");
                e.printStackTrace();
            }
        }while(flag);
    }
    public void subMenuForCustomer(){
        boolean flag = true;

        do{
            System.out.print("""
                            1. Display list customers
                            2. Add new customer
                            3. Edit customer
                            4. Return main menu
                            """
            );
            System.out.print("Enter your choose: ");
            try{
                int num = Integer.parseInt(sc.nextLine());
                switch (num){
                    case 1 -> {
                        System.out.println("--------* Display list customers *-----------");
                        customerService.display();
                    }
                    case 2 -> {
                        System.out.println("--------* Add new customer *-----------");
                        customerService.add();
                    }
                    case 3 -> {
                        System.out.println("--------* Edit customer *-----------");
                        customerService.edit();
                    }
                    case 4 -> {
                        System.out.println("--------* You returned main menu *-----------");
                        flag = false;
                    }
                    default -> System.out.println("It's not an option!");
                }
            }
            catch (NumberFormatException e){
                System.err.println("Something goes wrong, please check input!");
                e.printStackTrace();
            }
        }while(flag);
    }
    public void subMenuForFacility(){
        boolean flag = true;

        do{
            System.out.print("""
                            1. Display list facilities
                            2. Add new facility
                            3. Display list facility maintenance
                            4. Return main menu
                            """
            );
            System.out.print("Enter your choose: ");
            try{
                int num = Integer.parseInt(sc.nextLine());
                switch (num){
                    case 1 -> {
                        System.out.println("--------* Display list facilities *-----------");
                        facilityService.displayListFacilities();
                    }
                    case 2 -> {
                        System.out.println("--------* Add new facility *-----------");
                        facilityService.add();
                    }
                    case 3 -> {
                        System.out.println("--------* Display list facility maintenance *-----------");
                        facilityService.displayMaintain();
                    }
                    case 4 -> {
                        System.out.println("--------* you have returned  main menu *-----------");
                        flag = false;
                    }
                    default -> System.out.println("It's not an option!");
                }
            }
            catch (NumberFormatException e){
                System.err.println("Something goes wrong, please check input!");
                e.printStackTrace();
            }
        }while(flag);
    }
    public void subMenuForBooking(){
        boolean flag = true;

        do{
            System.out.print("""
                            1. Add new booking
                            2. Display list booking
                            3. Create new contracts
                            4. Display list contracts
                            5. Edit contracts
                            6. Return main menu
                            """
            );
            System.out.print("Enter your choose: ");
            try{
                int num = Integer.parseInt(sc.nextLine());
                switch (num){
                    case 1 -> {
                        System.out.println("--------* Add new booking *-----------");
                    }
                    case 2 -> {
                        System.out.println("--------* Display list booking *-----------");
                    }
                    case 3 -> {
                        System.out.println("--------* Create new contracts *-----------");
                    }
                    case 4 -> {
                        System.out.println("--------* Display list contracts *-----------");
                    }
                    case 5 -> {
                        System.out.println("--------* Edit contracts *-----------");
                    }
                    case 6 -> {
                        System.out.println("--------* you returned main menu *-----------");
                        flag = false;
                    }
                    default -> System.out.println("It's not an option!");
                }
            }
            catch (NumberFormatException e){
                System.err.println("Something goes wrong, please check input!");
                e.printStackTrace();
            }
        }while(flag);
    }
    public void subMenuForPromotion(){
        boolean flag = true;

        do{
            System.out.print("""
                            1. Display list customers use service
                            2. Display list customers get voucher
                            3. Return main menu
                            """
            );
            System.out.print("Enter your choose: ");
            try{
                int num = Integer.parseInt(sc.nextLine());
                switch (num){
                    case 1 -> {
                        System.out.println("--------* Display list customers use service *-----------");
                    }
                    case 2 -> {
                        System.out.println("--------* Display list customers get voucher *-----------");
                    }
                    case 3 -> {
                        System.out.println("--------* you returned main menu *-----------");
                        flag = false;
                    }
                    default -> System.out.println("It's not an option! ");
                }
            }
            catch (NumberFormatException e){
                System.err.println("Something goes wrong, please check input!");
                e.printStackTrace();
            }
        }while(flag);
    }
}
