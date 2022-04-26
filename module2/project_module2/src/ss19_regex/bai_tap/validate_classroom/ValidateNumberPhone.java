package ss19_regex.bai_tap.validate_classroom;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNumberPhone {
    private static final String MOBILE_REGEX = "^\\(\\d{2}\\)-\\([0]\\d{1,9}\\)$";
    private static String[] valid = new String[] {"(84)-(0978489648)", "(75)-(0274439648)", "(54)-(0978909098)"};
    private static String[] invalid = new String[]{"(ab)-(0978489648)", "(7)-(02744648)", "(54)-(197890998)"};
    public static void main(String[] args) {
        ValidateNumberPhone validateNumberPhone = new ValidateNumberPhone();
        for(String number: valid){
            boolean isvalid = validateNumberPhone.validate(number);
            System.out.println("Number phone is: "+ number + " is valid: " + isvalid);
        }
        for(String number: invalid){
            boolean isvalid = validateNumberPhone.validate(number);
            System.out.println("Number phone is: "+ number + " is valid: " + isvalid);
        }
    }

    public boolean validate(String regex){
        Pattern p = Pattern.compile(MOBILE_REGEX);
        Matcher m = p.matcher(regex);

        return m.matches();
    }
}
