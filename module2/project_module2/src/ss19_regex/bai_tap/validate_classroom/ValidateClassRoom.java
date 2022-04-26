package ss19_regex.bai_tap.validate_classroom;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClassRoom {
    private static final String CLASS_REGEX = "^[ACP]+\\d{4}+[GHIKML]$";
    private static String[] valid = new String[] {"A0318G", "A2121H", "P9898K"};
    private static String[] invalid = new String[] {"B0318G", "A21221H", "P9898C"};

    public static void main(String[] args) {
        ValidateClassRoom validateClassRoom = new ValidateClassRoom();
        for(String classRoom : valid){
            boolean isValid = validateClassRoom.validate(classRoom);
            System.out.println("Class room "+classRoom+" is "+isValid);
        }
        for(String classRoom : invalid){
            boolean isValid = validateClassRoom.validate(classRoom);
            System.out.println("Class room "+classRoom+" is "+isValid);
        }
    }

    public boolean validate(String regex){
        Pattern p = Pattern.compile(CLASS_REGEX);
        Matcher m = p.matcher(regex);
        return m.matches();
    }
}
