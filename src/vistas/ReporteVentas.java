/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import config.Fecha;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modeloDAO.VentasDAO;
import utils.CentrarTextoTabla;
import utils.LimpiarJTable;

public class ReporteVentas extends javax.swing.JInternalFrame {

    static final DecimalFormat DFORMAT = new DecimalFormat("0.00");
    DefaultTableModel modelo = new DefaultTableModel();
    LocalDate localDate = LocalDate.now();

    public ReporteVentas() {
        initComponents();
        dateIni.setDateFormatString("yyyy-MM-dd");
        dateFin.setDateFormatString("yyyy-MM-dd");
        dateIni.setDate(Fecha.primerDiaMes());
        dateFin.setDate(Fecha.ultimoDiaMes());
        btnBuscarVenta.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dateIni = new com.toedter.calendar.JDateChooser();
        dateFin = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        btnBuscarVenta = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVentaReport = new javax.swing.JTable();
        btnExportatPDF = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblTotalMonto = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pametros de búsqueda"));

        jLabel1.setText("Fecha Inicio : ");

        dateIni.setDateFormatString("yyyy-MM-dd");
        dateIni.setMinSelectableDate(new java.util.Date(-62135747883000L));

        jLabel2.setText("Fecha Inicio : ");

        btnBuscarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        btnBuscarVenta.setText("Buscar");
        btnBuscarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateIni, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateFin, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateIni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscarVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Reporte"));

        tableVentaReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "FECHA", "SERIE", "MONTO", "CLIENTE", "VENDEDOR", "ACCION"
            }
        ));
        jScrollPane1.setViewportView(tableVentaReport);
        if (tableVentaReport.getColumnModel().getColumnCount() > 0) {
            tableVentaReport.getColumnModel().getColumn(0).setMinWidth(40);
            tableVentaReport.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableVentaReport.getColumnModel().getColumn(0).setMaxWidth(40);
            tableVentaReport.getColumnModel().getColumn(1).setMinWidth(80);
            tableVentaReport.getColumnModel().getColumn(1).setPreferredWidth(80);
            tableVentaReport.getColumnModel().getColumn(1).setMaxWidth(80);
            tableVentaReport.getColumnModel().getColumn(2).setMinWidth(80);
            tableVentaReport.getColumnModel().getColumn(2).setPreferredWidth(80);
            tableVentaReport.getColumnModel().getColumn(2).setMaxWidth(80);
            tableVentaReport.getColumnModel().getColumn(3).setMinWidth(80);
            tableVentaReport.getColumnModel().getColumn(3).setPreferredWidth(80);
            tableVentaReport.getColumnModel().getColumn(3).setMaxWidth(80);
            tableVentaReport.getColumnModel().getColumn(6).setMinWidth(80);
            tableVentaReport.getColumnModel().getColumn(6).setPreferredWidth(80);
            tableVentaReport.getColumnModel().getColumn(6).setMaxWidth(80);
        }

        btnExportatPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf16.png"))); // NOI18N
        btnExportatPDF.setText("Export PDF");
        btnExportatPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportatPDFActionPerformed(evt);
            }
        });

        jLabel3.setText("Total Monto Vendidos en Rango de Fechas:");

        lblTotalMonto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotalMonto.setForeground(new java.awt.Color(0, 0, 255));
        lblTotalMonto.setText("0.0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnExportatPDF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotalMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTotalMonto)
                    .addComponent(btnExportatPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVentaActionPerformed
        obtenerReporteVentas();
    }//GEN-LAST:event_btnBuscarVentaActionPerformed

    private void btnExportatPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportatPDFActionPerformed
        try {
            exportarPDF();
        } catch (IOException ex) {
            Logger.getLogger(ReporteVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportatPDFActionPerformed
    void exportarPDF() throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String file = "Ventas del " + Fecha.FechaBD(dateIni.getDate()) + " Al " + Fecha.FechaBD(dateFin.getDate()) + "_" + dateFormat.format(new Date())+".pdf";

        try {
            try ( Document document = new Document(PageSize.A4)) {
                PdfWriter.getInstance(document, new FileOutputStream(file));
                document.open();
                Font font = FontFactory.getFont(FontFactory.HELVETICA);
                font.setSize(20);
                font.setColor(Color.BLUE);

                Paragraph paragraph = new Paragraph("Ventas del " + Fecha.FechaBD(dateIni.getDate()) + " Al " + Fecha.FechaBD(dateFin.getDate()), font);
                paragraph.setAlignment(Paragraph.ALIGN_CENTER);
                document.add(paragraph);

                PdfPTable pdfPTable = new PdfPTable(6);
                pdfPTable.setWidthPercentage(100f);
                pdfPTable.setWidths(new float[]{1.5f, 2.5f, 3.0f, 3.5f, 4.0f, 4.0f});
                pdfPTable.setSpacingBefore(10);

                writeHeader(pdfPTable);
                writeBody(pdfPTable);

                document.add(pdfPTable);
                Desktop.getDesktop().open(new File(file));
                
            }
        
        } catch (DocumentException e) {
            System.out.println("Error:" + e);
        }
    }

    public void writeHeader(PdfPTable pdfTable) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.darkGray);
        cell.setPadding(6);
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("ID", font));
        pdfTable.addCell(cell);
        cell.setPhrase(new Phrase("FECHA", font));
        pdfTable.addCell(cell);
        cell.setPhrase(new Phrase("NRO-SERIE", font));
        pdfTable.addCell(cell);
        cell.setPhrase(new Phrase("MONTO", font));
        pdfTable.addCell(cell);
        cell.setPhrase(new Phrase("CLIENTE", font));
        pdfTable.addCell(cell);
        cell.setPhrase(new Phrase("VENDEDOR", font));
        pdfTable.addCell(cell);

    }

    public void writeBody(PdfPTable pdfTable) {
        List<Object[]> ventas = VentasDAO.getVentas(Fecha.FechaBD(dateIni.getDate()), Fecha.FechaBD(dateFin.getDate()));
        ventas.stream().map(venta -> {
            pdfTable.addCell(venta[0].toString());
            return venta;
        }).map(venta -> {
            pdfTable.addCell(venta[1].toString());
            return venta;
        }).map(venta -> {
            pdfTable.addCell(venta[2].toString());
            return venta;
        }).map(venta -> {
            pdfTable.addCell(venta[3].toString());
            return venta;
        }).map(venta -> {
            pdfTable.addCell(venta[4].toString());
            return venta;
        }).forEachOrdered(venta -> {
            pdfTable.addCell(venta[5].toString());
        });

    }

    void obtenerReporteVentas() {
        double montoVenta = 0.00;
        modelo = (DefaultTableModel) tableVentaReport.getModel();
        LimpiarJTable.limpiarTabla(modelo);
        List<Object[]> ventas = VentasDAO.getVentas(Fecha.FechaBD(dateIni.getDate()), Fecha.FechaBD(dateFin.getDate()));
        ventas.forEach(venta -> {
            modelo.addRow(venta);
        });
        for (Object[] v : ventas) {
            montoVenta = montoVenta + (Double.parseDouble(v[3].toString()));
        }
        tableVentaReport.setModel(modelo);
        lblTotalMonto.setText("S/." + DFORMAT.format(montoVenta));
        CentrarTextoTabla.centrarText3(tableVentaReport);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarVenta;
    private javax.swing.JButton btnExportatPDF;
    private com.toedter.calendar.JDateChooser dateFin;
    private com.toedter.calendar.JDateChooser dateIni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotalMonto;
    private javax.swing.JTable tableVentaReport;
    // End of variables declaration//GEN-END:variables
}
