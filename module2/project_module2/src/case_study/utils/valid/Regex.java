package case_study.utils.valid;

public class Regex {
    public static final String SERVICECODEHOUSE_REGEX = "^SVHO\\-\\d{4}$";
    public static final String SERVICECODEVILLA_REGEX = "^SVVL\\-\\d{4}$";
    public static final String SERVICECODEROOM_REGEX = "^SVRO\\-\\d{4}$";
    public static final String SERVICENAME_REGEX = "^[A-Z][a-z]+$";
    public static final String AREAOFPOOLANDAREAUSE_REGEX = "^[3-9][0-9]{1,2}\\.+\\d+$";
    public static final String FEERENT_REGEX = "^[1-9]\\d+$";
    public static final String MAXIMUMPERSON_REGEX = "^[1-9]{1}$|[1][0-9]{1}$";
    public static final String NUMBERFLOOR_REGEX ="^[1-9]$";
    public static final String TYPEOFRENT_REGEX = "^[A-Z][a-z]+$";
    public static final String ROOMSTANDARD_REGEX = "^[A-Z][a-z]+$";
}
