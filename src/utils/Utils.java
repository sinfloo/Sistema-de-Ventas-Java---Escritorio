package utils;

import java.text.DecimalFormat;

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
    public static String formatMoney(Double monto){
        DecimalFormat decimalFormat=new DecimalFormat("0.00");
        return decimalFormat.format(monto);
    }
}
