package security;


import java.util.UUID;


public class DigestHelper {


    //region Description
    /*public static String getMd5HashWithTime(String inputString){

        String time = Calendar.getInstance().toString();

        return DigestUtils.md5Hex(time + inputString);
    }*/
    //endregion

    public static String getUuid(){

        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
