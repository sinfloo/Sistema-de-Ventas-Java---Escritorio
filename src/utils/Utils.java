package utils;

import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JTable;

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

    public static void imprimir(JTable table,String celular) {
         PrinterMatrix printer = new PrinterMatrix();

         Extenso e = new Extenso();

        e.setNumber(80);

        //Definir el tamanho del papel para la impresion  aca 25 lineas y 80 columnas
        printer.setOutSize(20, 60);
        //Imprimir * de la 2da linea a 25 en la columna 1;
        // printer.printCharAtLin(2, 25, 1, "*");
        //Imprimir * 1ra linea de la columa de 1 a 80
        printer.printCharAtCol(1, 1, 60, "-");
        //Imprimir Encabezado nombre del La EMpresa
        printer.printTextWrap(1, 2, 30, 60, "TICKET DE COMPRA");
        //printer.printTextWrap(linI, linE, colI, colE, null);
        printer.printTextWrap(2, 3, 1, 25, "Num. TICKET : " + "Serie");
        printer.printTextWrap(2, 3, 25,55, "Fecha de Emision: " + "2021-05-12");
        //printer.printTextWrap(2, 3, 60,80, "Hora: 12:22:51");
        printer.printTextWrap(3, 3, 1, 25, "Vendedor.  : SISTEMA");
        printer.printTextWrap(4, 4, 1, 25, "CLIENTE: " + "Cliente Tienda");
        printer.printTextWrap(5, 5, 1, 25, "RUC/CI.: " + "12345678");
        printer.printTextWrap(6, 6, 1, 25, "DIRECCION: " + "");
        printer.printCharAtCol(7, 1, 60, "=");
        printer.printTextWrap(7, 8, 1, 10, "Codigo");
        printer.printTextWrap(7, 8, 10, 35, "Descripcion");
        printer.printTextWrap(7, 8, 35, 46, "P.Unit.");
        printer.printTextWrap(7, 8, 46, 53, "Cant.");
        printer.printTextWrap(7, 8, 53, 60, "P.Total");
        printer.printCharAtCol(9, 1, 60, "=");
        int filas = table.getRowCount();

        for (int i = 0; i < filas; i++) {
            printer.printTextWrap(9 + i, 9+i, 1, 10, table.getValueAt(i, 0).toString());
            printer.printTextWrap(9 + i, 9+i, 10, 40, table.getValueAt(i, 1).toString());
            printer.printTextWrap(9 + i, 9+i, 40, 47, table.getValueAt(i, 2).toString());
            printer.printTextWrap(9 + i, 9+i, 47, 54, table.getValueAt(i, 3).toString());
            printer.printTextWrap(9 + i, 9+i, 54, 60, table.getValueAt(i, 4).toString());
        }

        printer.printCharAtCol(15, 1, 60, "=");
        printer.printTextWrap(15, 1, 1, 60, "TOTAL A PAGAR " + "30303.00");
        printer.printCharAtCol(17, 1, 60, "=");
        printer.printTextWrap(17, 1, 1, 60, "Esta ticket no tiene valor fiscal solo uso interno");

        printer.toFile(celular + ".txt");

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(celular + ".txt");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        if (inputStream == null) {
            return;
        }

        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc document = new SimpleDoc(inputStream, docFormat, null);

        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();

        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

        if (defaultPrintService != null) {
            DocPrintJob printJob = defaultPrintService.createPrintJob();
            try {
                printJob.print(document, attributeSet);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.err.println("No existen impresoras instaladas");
        }
    }
}
