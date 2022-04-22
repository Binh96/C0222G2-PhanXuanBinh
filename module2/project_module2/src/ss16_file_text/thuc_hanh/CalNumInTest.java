package ss16_file_text.thuc_hanh;

import java.io.*;
import java.util.Scanner;

public class CalNumInTest {
    public static void main(String[] args) {
        System.out.println("Nhap duong dan file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        CalNumInTest calNumInTest = new CalNumInTest();
        calNumInTest.readFileText(path);
    }

    public void readFileText(String filepath){

        try{
            File file = new File(filepath);
            if(!file.exists()){
                throw new FileNotFoundException();
            }

            BufferedReader rd = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while((line = rd.readLine()) != null){
                System.out.println(line);
                sum+= Integer.parseInt(line);
            }
            rd.close();
            System.out.println("Tong: "+ sum);
        }catch (Exception e){
            System.out.println("File khong ton tai hoac khong co noi dung");
        }
    }
}
