package utils;

public class Utils {

    public static boolean isNumeric(String texto) {
        boolean r;
        try {
            Integer.valueOf(texto);
            r=true;
        } catch (NumberFormatException e) {
            System.out.println("Error:" + e);
            r=false;
        }
        return r;
    }
}
