package helpers.testData;

import helpers.properties.BaseProperties;

public class InputTestData extends BaseProperties {
    public static String getCorrectUserName() {
        return PROPERTIES.getProperty("correct.userName");
    }
    public static String getLockedUserName(){ return PROPERTIES.getProperty("locked.userName"); }
    public static String getGlitchUserName(){ return PROPERTIES.getProperty("glitch.userName"); }
    public static String getCorrectPassword() {
        return PROPERTIES.getProperty("correct.password");
    }
    public static String getTestFirstName() {
        return PROPERTIES.getProperty("firstNameText");
    }
    public static String getTestLastName() {
        return PROPERTIES.getProperty("secondNameText");
    }
    public static String getTestPostalCode() {
        return PROPERTIES.getProperty("postalCodeText");
    }
    public static int getStartedTotalPrice(){return Integer.parseInt(PROPERTIES.getProperty("startedTotalPrice"));}

}
