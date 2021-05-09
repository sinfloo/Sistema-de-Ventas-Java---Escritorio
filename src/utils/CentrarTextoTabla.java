package utils;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class CentrarTextoTabla {

    public static void centrarText(JTable jTable) {
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        DefaultTableCellRenderer modeloleft = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jTable.getColumnCount(); i++) {
            jTable.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);
            if (i == 2) {
                modeloleft.setHorizontalAlignment(SwingConstants.LEFT);
                jTable.getColumnModel().getColumn(i).setCellRenderer(modeloleft);
            }
        }

    }
    public static void centrarText2(JTable jTable) {
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        DefaultTableCellRenderer modeloleft = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jTable.getColumnCount(); i++) {
            jTable.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);
            if (i == 1) {
                modeloleft.setHorizontalAlignment(SwingConstants.LEFT);
                jTable.getColumnModel().getColumn(i).setCellRenderer(modeloleft);
            }
        }

    }

    public void izq_datos(JTable jTable) {
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.LEFT);
        jTable.getColumnModel().getColumn(Integer.valueOf(jTable.getModel().getColumnName(0))).setCellRenderer(modelocentrar);
    }
    public void der_datos(JTable jTable) {
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.RIGHT);
        jTable.getColumnModel().getColumn(Integer.valueOf(jTable.getModel().getColumnName(0))).setCellRenderer(modelocentrar);
    }
    public void der_datos2(JTable jTable) {
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.RIGHT);
        jTable.getColumnModel().getColumn(Integer.valueOf(jTable.getModel().getColumnName(0))).setCellRenderer(modelocentrar);
    }
}
