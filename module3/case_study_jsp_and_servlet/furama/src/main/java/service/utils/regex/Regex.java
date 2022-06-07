package service.utils.regex;

public class Regex {
    public final static String NAME_REGEX = "^\\D{1,10}$";
    public final static String CUSTOMER_CODE_REGEX = "^KH\\-\\d{4}$";
    public final static String SERVICE_CODE_REGEX = "^DV\\-\\d{4}$";
    public final static String PHONE_NUMBER_REGEX = "^(090)\\d{7}$|(091)\\d{7}$|\\(84\\)(\\+90)\\d{7}$|\\(84\\)(\\+91)\\d{7}$";
    public final static String IDENTITY_NUMBER_REGEX = "^\\d{9}$|^\\d{12}$";
    public final static String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";



    public boolean checkRegex(String syntax, String regex){
        return syntax.matches(regex);
    }
}
