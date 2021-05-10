package utils;

import java.awt.Component;

public class Activate {

    public static void On(Component[]c) {
        for (Component component : c) {
            component.setEnabled(true);
        }        
    }
    public static void Of(Component[]c) {
        for (Component component : c) {
            component.setEnabled(false);
        }        
    }
}
