package case_study.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import case_study.modules.Employee;
import case_study.service.IEmployeeService;
import case_study.utils.read_write_files.ReadFile;
import case_study.utils.read_write_files.WriteFile;
import case_study.utils.valid.CheckInput;
import case_study.utils.valid.InputDate;

public class IEmployeeServiceImpl implements IEmployeeService {
    Scanner sc = new Scanner(System.in);
    private final String pathEmployee = "case_study/utils/data/employee.csv";
    List<Employee> employeeList = new ArrayList<>();

    @Override
    public void add() {
        employeeList = ReadFile.readFileEmployee(pathEmployee);

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
        System.out.print("Enter level: ");
        String level = chooseLevel();
        System.out.println("Enter position: ");
        String position = choosePosition();
        System.out.print("Enter salary: ");
        Long salary = Long.parseLong(sc.nextLine());

        Employee employee = new Employee(name, dob, id, gender, phoneNumber, email, level, position, salary);
        employeeList.add(employee);
        WriteFile.writeFileAll(pathEmployee, employeeList);
    }

    @Override
    public void display() {
        employeeList = ReadFile.readFileEmployee(pathEmployee);
        if(employeeList.isEmpty()){
            System.out.println("None get in a job >> you're suck <<");
        }
        else{
            for(Employee employee : employeeList){
                System.out.println(employee.getInfor());
            }
        }
    }

    @Override
    public void edit() {
        employeeList = ReadFile.readFileEmployee(pathEmployee);
        boolean check = true;
        displayID();
        System.out.print("Enter employee code: ");
        int code = CheckInput.intInput();
        for(Employee employee : employeeList){
            if(Employee.getEmployeeCode() != code){
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
                            employee.setName(name);
                            WriteFile.writeFileAll(pathEmployee, employeeList);
                        }
                        case "dob" -> {
                            Date dayOfBirth = InputDate.dateValid();
                            employee.setDateOfBirth(dayOfBirth);
                            WriteFile.writeFileAll(pathEmployee, employeeList);
                        }
                        case "gender" -> {
                            System.out.print("Edit gender: ");
                            String gender = sc.nextLine();
                            employee.setGender(gender);
                            WriteFile.writeFileAll(pathEmployee, employeeList);
                        }
                        case "id" -> {
                            System.out.print("Edit id: ");
                            String id2 = sc.nextLine();
                            employee.setId(id2);
                            WriteFile.writeFileAll(pathEmployee, employeeList);
                        }
                        case "phone" -> {
                            System.out.print("Edit phone: ");
                            String phone = sc.nextLine();
                            employee.setPhoneMobile(phone);
                            WriteFile.writeFileAll(pathEmployee, employeeList);
                        }
                        case "email" -> {
                            System.out.print("Edit email: ");
                            String email = sc.nextLine();
                            employee.setEmail(email);
                            WriteFile.writeFileAll(pathEmployee, employeeList);
                        }
                        case "idstaff" -> {
                            System.out.print("Edit id staff: ");
                            int employeeCode = CheckInput.intInput();
                            Employee.setEmployeeCode(employeeCode);
                            WriteFile.writeFileAll(pathEmployee, employeeList);
                        }
                        case "level" -> {
                            System.out.print("Edit level: ");
                            String level = sc.nextLine();
                            employee.setLevel(level);
                            WriteFile.writeFileAll(pathEmployee, employeeList);
                        }
                        case "position" -> {
                            System.out.print("Edit position: ");
                            String position = sc.nextLine();
                            employee.setPosition(position);
                            WriteFile.writeFileAll(pathEmployee, employeeList);
                        }
                        case "salary" -> {
                            System.out.print("Edit id salary: ");
                            Long salary = Long.parseLong(sc.nextLine());
                            employee.setSalary(salary);
                            WriteFile.writeFileAll(pathEmployee, employeeList);
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

    public void displayID(){
        employeeList = ReadFile.readFileEmployee(pathEmployee);
        for(Employee employee : employeeList){
            System.out.println("Name: "+ employee.getName()+ ", Employee code: "+ Employee.getEmployeeCode());
        }
    }

    public void displayMenuLevel(){
        System.out.println("""
                            ---- List level------
                           1. Intermediate
                           2. Colleges
                           3. University
                           4. After University
                """);
    }

    public void displayMenuPosition(){
        System.out.println("""
                            ---- List position------
                           1. Reception
                           2. Service
                           3. Expert
                           4. Supervisor
                           5. Manager
                           6. Director
                """);
    }

    public String chooseLevel(){
        displayMenuLevel();
        System.out.print("Choose level: ");
        int num = Integer.parseInt(sc.nextLine());
        String level="";
        switch (num){
            case 1 -> level = "Intermediate";
            case 2 -> level = "Colleges";
            case 3 -> level = "University";
            case 4 -> level = "After University";
            default -> System.out.println("doesn't exist in list");
        }
        return level;
    }

    public String choosePosition(){
        displayMenuPosition();
        System.out.print("Choose position: ");
        int num = Integer.parseInt(sc.nextLine());
        String position="";
        switch (num){
            case 1 -> position = "Reception";
            case 2 -> position = "Service";
            case 3 -> position = "Expert";
            case 4 -> position = "Supervisor";
            case 5 -> position = "Manager";
            case 6 -> position = "Director";
            default -> System.out.println("doesn't exist in list");
        }
        return position;
    }
}


