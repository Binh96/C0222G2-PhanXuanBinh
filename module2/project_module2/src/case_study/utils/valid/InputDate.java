package case_study.utils.valid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputDate {
    static Scanner sc = new Scanner(System.in);
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

   public static Date dateValid(){
       boolean check = true;
       Date objDate = null;
       while(check){
           try{
               objDate = simpleDateFormat.parse(sc.nextLine());
               check = false;
           }
           catch (ParseException e){
               e.printStackTrace();
               System.out.println(">>> Enter again <<<");
           }
       }
       return objDate;
   }

   public static Date covertDate(String date){
       Date dateConvert = null;
       try{
          dateConvert = simpleDateFormat.parse(date);
       }catch (ParseException e){
           e.printStackTrace();
       }
       return dateConvert;
   }
}
