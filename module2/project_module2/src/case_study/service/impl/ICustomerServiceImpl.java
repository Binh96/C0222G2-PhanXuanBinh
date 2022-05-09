package case_study.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import case_study.modules.Customer;
import case_study.service.ICustomerService;
import case_study.utils.read_write_files.ReadFile;
import case_study.utils.read_write_files.WriteFile;
import case_study.utils.valid.InputDate;

public class ICustomerServiceImpl implements ICustomerService {
    Scanner sc = new Scanner(System.in);
    private final String pathCustomer = "case_study/utils/data/customer.csv";
    List<Customer> customerList = new ArrayList<>();

    @Override
    public void add() {
        customerList = ReadFile.readFileCustomer(pathCustomer);

        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter day of birth (dd-MM-yyyy)");
        Date dob = InputDate.dateValid();
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter customer code: ");
        String customerCode = sc.nextLine();
        System.out.println("Enter customer type: ");
        String customerType = chooseCustomerType();
        System.out.print("Enter address: ");
        String address = sc.nextLine();

        customerList.add(new Customer(name, dob, id, gender, phoneNumber, email, customerCode, customerType, address));
        WriteFile.writeFileAll(pathCustomer, customerList);
    }

    @Override
    public void display() {
        customerList = ReadFile.readFileCustomer(pathCustomer);
        if(customerList.isEmpty()){
            System.out.println("Your system too bad >>> so none want to be here <<<");
        }
        else{
            for(Customer customer : customerList){
                System.out.println("Name: "+customer.getName()+", Type: "+ customer.getCustomerType());
            }
        }
    }

    public void displayID(){
        customerList = ReadFile.readFileCustomer(pathCustomer);
        for(Customer customer : customerList){
            System.out.println("Name: "+ customer.getName()+", Customer code: "+customer.getCustomerCode());
        }
    }

    @Override
    public void edit() {
        boolean check = true;
        displayID();
        System.out.print("Enter employee code: ");
        String code = sc.nextLine();
        for(Customer customer : customerList){
            if(!customer.getCustomerCode().equals(code)){
                check = false;
            }
            else{
                check = true;
                boolean flag = true;
                do{
                    System.out.print("Choose part you want to change: ");
                    String editPart = sc.nextLine();
                    switch (editPart){
                        case "name" -> {
                            System.out.print("Edit name: ");
                            String name = sc.nextLine();
                            customer.setName(name);
                            WriteFile.writeFileAll(pathCustomer, customerList);
                        }
                        case "dob" -> {
                            Date dayOfBirth = InputDate.dateValid();
                            customer.setDateOfBirth(dayOfBirth);
                            WriteFile.writeFileAll(pathCustomer, customerList);
                        }
                        case "gender" -> {
                            System.out.print("Edit gender: ");
                            String gender = sc.nextLine();
                            customer.setGender(gender);
                            WriteFile.writeFileAll(pathCustomer, customerList);
                        }
                        case "id" -> {
                            System.out.print("Edit id: ");
                            String id2 = sc.nextLine();
                            customer.setId(id2);
                            WriteFile.writeFileAll(pathCustomer, customerList);
                        }
                        case "phone" -> {
                            System.out.print("Edit phone: ");
                            String phone = sc.nextLine();
                            customer.setPhoneMobile(phone);
                            WriteFile.writeFileAll(pathCustomer, customerList);
                        }
                        case "email" -> {
                            System.out.print("Edit email: ");
                            String email = sc.nextLine();
                            customer.setEmail(email);
                            WriteFile.writeFileAll(pathCustomer, customerList);
                        }
                        case "code" -> {
                            System.out.print("Edit customer code: ");
                            String customerCode = sc.nextLine();
                            customer.setCustomerCode(customerCode);
                            WriteFile.writeFileAll(pathCustomer, customerList);
                        }
                        case "type" -> {
                            System.out.print("Edit type customer: ");
                            String type = sc.nextLine();
                            customer.setCustomerType(type);
                            WriteFile.writeFileAll(pathCustomer, customerList);
                        }
                        case "address" -> {
                            System.out.print("Edit position: ");
                            String address = sc.nextLine();
                            customer.setAddress(address);
                            WriteFile.writeFileAll(pathCustomer, customerList);
                        }
                        default -> {
                            System.out.println("You has been disconnected");
                            flag = false;
                        }
                    }
                }while (flag);
                break;
            }
        }
        if(!check){
            System.out.println("Are you blind!! The one you want to edit doesn't exist >>> check you're eyes!!");
        }
    }

    @Override
    public void displayCustomerType() {
        System.out.println("""
                ---- List type customer ----
                1. Diamond
                2. Platinum
                3. Gold
                4. Silver
                5. Member
                """);
    }

    @Override
    public String chooseCustomerType() {
        displayCustomerType();
        System.out.print("Choose customer type: ");
        int num = Integer.parseInt(sc.nextLine());
        String str ="";
        switch (num){
            case 1 -> str = "Diamond";
            case 2 -> str = "Platinum";
            case 3 -> str = "Gold";
            case 4 -> str = "Silver";
            case 5 -> str = "Member";
            default -> System.out.println("doesn't exist");
        }
        return str;
    }
}
