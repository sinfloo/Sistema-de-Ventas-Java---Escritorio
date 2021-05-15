
package utils;

import javax.swing.table.DefaultTableModel;

public class LimpiarJTable {
    public static  void limpiarTabla(DefaultTableModel modelo) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
}
