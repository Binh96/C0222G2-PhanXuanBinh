package case_study.utils.read_write_files;

import case_study.modules.*;
import case_study.utils.valid.CheckInput;
import case_study.utils.valid.InputDate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public List<String> readFile(String path){
        List<String> stringList = new ArrayList<>();
        try{
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                stringList.add(line);
            }
            br.close();
            fr.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return stringList;
    }

    public static List<Employee> readFileEmployee(String path){
        List<Employee> employeeList = new ArrayList<>();
        String[] str;
        try{
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                str = line.split(", ");
                employeeList.add(new Employee(str[0], InputDate.covertDate(str[1]), str[2], str[3], str[4], str[5],
                        Integer.parseInt(str[6]),str[7], str[8], Long.parseLong(str[9])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public static List<Customer> readFileCustomer(String path){
        List<Customer> customerList = new ArrayList<>();
        String[] str;
        try{
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                if(line.isEmpty()){
                    continue;
                }
                str = line.split(", ");
                customerList.add(new Customer(str[0], InputDate.covertDate(str[1]), str[2], str[3], str[4], str[5], str[6], str[7], str[8]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public static List<House> readFileHouse(String path){
        List<House> houseList = new ArrayList<>();
        String[] str;
        try{
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                if(line.isEmpty()){
                    continue;
                }
                str = line.split(", ");
                houseList.add(new House(str[0], str[1], Double.parseDouble(str[2]), Integer.parseInt(str[3]), Integer.parseInt(str[4]), str[5], str[6], Integer.parseInt(str[7])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return houseList;
    }

    public static List<Villa> readFileVilla(String path){
        List<Villa> villaList = new ArrayList<>();
        String[] str;
        try{
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                if(line.isEmpty()){
                    continue;
                }
                str = line.split(", ");
                villaList.add(new Villa(str[0], str[1], Double.parseDouble(str[2]), Integer.parseInt(str[3]), Integer.parseInt(str[4]), str[5], str[6], Double.parseDouble(str[7]), Integer.parseInt(str[8])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return villaList;
    }

    public static List<Room> readFileRoom(String path){
        List<Room> roomList = new ArrayList<>();
        String[] str;
        try{
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                if(line.isEmpty()){
                    continue;
                }
                str = line.split(", ");
                roomList.add(new Room(str[0], str[1], Double.parseDouble(str[2]), Integer.parseInt(str[3]), Integer.parseInt(str[4]), str[5], str[6]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roomList;
    }
}
