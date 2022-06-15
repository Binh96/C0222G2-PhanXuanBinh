package service.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static final String NAME_REGEX = "^\\D{1,10}$";
    private static final String CUSTOMER_CODE_REGEX = "^KH\\-\\d{4}$";
    private static final String SERVICE_CODE_REGEX = "^DV\\-\\d{4}$";
    private static final String EMPLOYEE_CODE_REGEX = "^NV-\\d{4}$";
    private static final String PHONE_NUMBER_REGEX = "^(090)\\d{7}$|(091)\\d{7}$|\\(84\\)(\\+90)\\d{7}$|\\(84\\)(\\+91)\\d{7}$";
    private static final String IDENTITY_NUMBER_REGEX = "^\\d{9}|\\d{12}$";
    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final String REGEX_DATE = "^\\d{2}(\\/|-)\\d{2}(\\/|-)\\d{4}$";
    private static final String NUMBER_REGEX = "^\\d{1,}$|^\\d{1,}.\\d{1,}$";
    private static final String FLOOR_REGEX = "^\\d{1,}$";


    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean checkNameRegex(String syntax){
        pattern = Pattern.compile(NAME_REGEX);
        matcher = pattern.matcher(syntax);
        if(!matcher.find()){
            return true;
        }
        return false;
    }


    public static boolean checkCustomerCodeRegex(String syntax){
        pattern = Pattern.compile(CUSTOMER_CODE_REGEX);
        matcher = pattern.matcher(syntax);
        if(!matcher.find()){
            return true;
        }
        return false;
    }


    public static boolean checkServiceCodeRegex(String syntax){
        pattern = Pattern.compile(SERVICE_CODE_REGEX);
        matcher = pattern.matcher(syntax);
        if(!matcher.find()){
            return true;
        }
        return false;
    }

    public static boolean checkEmployeeCodeRegex(String syntax){
        pattern = Pattern.compile(EMPLOYEE_CODE_REGEX);
        matcher = pattern.matcher(syntax);
        if(!matcher.find()){
            return true;
        }
        return false;
    }

    public static boolean checkPhoneRegex(String syntax){
        pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        matcher = pattern.matcher(syntax);
        if(!matcher.find()){
            return true;
        }
        return false;
    }

    public static boolean checkIdentityRegex(String syntax){
        pattern = Pattern.compile(IDENTITY_NUMBER_REGEX);
        matcher = pattern.matcher(syntax);
        if(!matcher.find()){
            return true;
        }
        return false;
    }

    public static boolean checkEmailRegex(String syntax){
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(syntax);
        if(!matcher.find()){
            return true;
        }
        return false;
    }

    public static boolean checkDate(String date){
        pattern = Pattern.compile(REGEX_DATE);
        matcher = pattern.matcher(date);
        if (!matcher.find()){
            return true;
        }
        return false;
    }

    public static boolean checkNumber(String number){
        pattern = Pattern.compile(NUMBER_REGEX);
        matcher = pattern.matcher(number);
        if (!matcher.find()){
            return true;
        }
        return false;
    }

    public static boolean checkFloorAndPeople(String number){
        pattern = Pattern.compile(FLOOR_REGEX);
        matcher = pattern.matcher(number);
        if (!matcher.find()){
            return true;
        }
        return false;
    }
}
