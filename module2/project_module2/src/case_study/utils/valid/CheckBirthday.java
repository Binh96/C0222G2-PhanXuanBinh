package case_study.utils.valid;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class CheckBirthday {
    private static final int lessAge = 18;
    private static final int biggerAge = 100;

    public static boolean checkBirthday(String dobString){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dob = LocalDate.parse(dobString, dateTimeFormatter);
        LocalDate currentDate = LocalDate.now();
        Period p = Period.between(dob, currentDate);
        try{
            if(p.getYears() > lessAge && p.getYears() < biggerAge){
                return true;
            }
            else{
                throw new DateException(">>>>> Age inappropriate <<<<<<");
            }
        }
        catch (DateException e){
            e.printStackTrace();
            System.out.println(">>> Enter again, please! <<<");
        }
        return false;
    }
}
