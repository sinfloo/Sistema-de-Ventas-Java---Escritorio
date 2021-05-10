package vistas;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modeloDAO.VentasDAO;
import utils.CentrarTextoTabla;
import utils.ImprimirObject;

public class Imprimir extends javax.swing.JInternalFrame implements Printable {

    ImprimirObject io = null;

    public Imprimir() {
        initComponents();
        imprimir();
    }

    final void imprimir() {
        DecimalFormat dfoFormat = new DecimalFormat("#,###.00");
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        DefaultTableModel model = (DefaultTableModel) jTableImprimir.getModel();
        io = VentasDAO.getDocumento(VentasDAO.IdVenta());

        txtSerie.setText("Nro Serie:" + io.getNroSerie());
        txtDatosCliente.setText("CLIENTE:" + io.getNomCliente() + "\t  DNI:" + io.getDocClient() + "\t  FECHA:" + io.getFecha() + " " + dateFormat.format(new Date().getTime()));
        txtDatosVendedor.setText("VENDEDOR:" + io.getUserName());
        io.getDetalle().forEach(object -> {
            model.addRow(object);
        });
        jTableImprimir.setModel(model);
        txtSubTotal.setText(dfoFormat.format(io.getTotalPagar() / (1.18)));
        txtIgv.setText(dfoFormat.format(io.getTotalPagar() - (io.getTotalPagar() / 1.18)));
        txtTotalPagar.setText(dfoFormat.format(io.getTotalPagar()));
        CentrarTextoTabla.centrarText2(jTableImprimir);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnImprimir = new javax.swing.JButton();
        jPanelImprimir = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableImprimir = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JLabel();
        txtDatosCliente = new javax.swing.JLabel();
        txtDatosVendedor = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIgv = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTotalPagar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/impresora2.png"))); // NOI18N
        btnImprimir.setText("IMPRIMIR");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        jPanelImprimir.setBackground(new java.awt.Color(255, 255, 255));
        jPanelImprimir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelImprimir.setForeground(new java.awt.Color(153, 153, 153));

        jTableImprimir.setForeground(new java.awt.Color(102, 102, 102));
        jTableImprimir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "PRODUCTO", "PRECIO", "CANT", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableImprimir.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTableImprimir);
        if (jTableImprimir.getColumnModel().getColumnCount() > 0) {
            jTableImprimir.getColumnModel().getColumn(0).setMinWidth(40);
            jTableImprimir.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTableImprimir.getColumnModel().getColumn(0).setMaxWidth(40);
            jTableImprimir.getColumnModel().getColumn(2).setMinWidth(80);
            jTableImprimir.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTableImprimir.getColumnModel().getColumn(2).setMaxWidth(80);
            jTableImprimir.getColumnModel().getColumn(3).setMinWidth(60);
            jTableImprimir.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTableImprimir.getColumnModel().getColumn(3).setMaxWidth(60);
            jTableImprimir.getColumnModel().getColumn(4).setMinWidth(80);
            jTableImprimir.getColumnModel().getColumn(4).setPreferredWidth(80);
            jTableImprimir.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PUNTO DE VENTA TECNOLOGY");

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Centro Comercial Tecnology S.A.C. - RUC:20212888912");

        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Av. Los Campos de Norte Sureña - Km 29 Panamericana sur");

        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Telefono: 345- 567");

        txtSerie.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtSerie.setForeground(new java.awt.Color(153, 153, 153));
        txtSerie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSerie.setText("0000000001");

        txtDatosCliente.setForeground(new java.awt.Color(153, 153, 153));
        txtDatosCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDatosCliente.setText("Datos Cliente...................................");

        txtDatosVendedor.setForeground(new java.awt.Color(153, 153, 153));
        txtDatosVendedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDatosVendedor.setText("Datos del Vendedor..........................");

        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("consultas a soporteventas@soporte.com");

        txtSubTotal.setForeground(new java.awt.Color(153, 153, 153));
        txtSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtSubTotal.setText("0.00");

        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("SUB TOTAL :");

        txtIgv.setForeground(new java.awt.Color(153, 153, 153));
        txtIgv.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtIgv.setText("0.00");

        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("IGV :");

        txtTotalPagar.setForeground(new java.awt.Color(153, 153, 153));
        txtTotalPagar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtTotalPagar.setText("0.00");

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("TOTAL A PAGAR :");

        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("______________________________________________________________________");

        javax.swing.GroupLayout jPanelImprimirLayout = new javax.swing.GroupLayout(jPanelImprimir);
        jPanelImprimir.setLayout(jPanelImprimirLayout);
        jPanelImprimirLayout.setHorizontalGroup(
            jPanelImprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImprimirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelImprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSerie, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDatosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDatosVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelImprimirLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelImprimirLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelImprimirLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelImprimirLayout.setVerticalGroup(
            jPanelImprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelImprimirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDatosCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelImprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubTotal)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelImprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIgv)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelImprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalPagar)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(txtDatosVendedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        try {
            PrinterJob pjob = PrinterJob.getPrinterJob();
            pjob.setPrintable(this);
            boolean r = pjob.printDialog();
            if (r) {
                pjob.print();
            }
        } catch (HeadlessException | PrinterException e) {
            System.out.println("Error:" + e);
        }
        //procesar(jTableImprimir, "CLIENTE:"+io.getNomCliente()+" FECHA:"+io.getFecha(), "Vendedor:"+io.getUserName()+" Correo:soporteventas@soporte.com", true);
        dispose();
    }//GEN-LAST:event_btnImprimirActionPerformed
    void procesar(JTable jTable, String header, String footer, boolean showPrintDialog) {
        boolean fitWidth = true;
        boolean interactive = true;
        // We define the print mode (Definimos el modo de impresión)
        JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
        try {
            // Print the table (Imprimo la tabla)    
            boolean complete = jTable.print(mode,
                    new MessageFormat(header),
                    new MessageFormat(footer),
                    showPrintDialog,
                    null,
                    interactive);

            if (complete) {
                // Mostramos el mensaje de impresión existosa
                JOptionPane.showMessageDialog(jTable,
                        "Print complete (Impresión completa)",
                        "Print result (Resultado de la impresión)",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Mostramos un mensaje indicando que la impresión fue cancelada                 
                JOptionPane.showMessageDialog(jTable,
                        "Print canceled (Impresión cancelada)",
                        "Print result (Resultado de la impresión)",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (PrinterException pe) {
            JOptionPane.showMessageDialog(jTable,
                    "Print fail (Fallo de impresión): " + pe.getMessage(),
                    "Print result (Resultado de la impresión)",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelImprimir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableImprimir;
    private javax.swing.JLabel txtDatosCliente;
    private javax.swing.JLabel txtDatosVendedor;
    private javax.swing.JLabel txtIgv;
    private javax.swing.JLabel txtSerie;
    private javax.swing.JLabel txtSubTotal;
    private javax.swing.JLabel txtTotalPagar;
    // End of variables declaration//GEN-END:variables

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.translate(pageFormat.getImageableX() + 10, pageFormat.getImageableY() + 10);
        graphics2D.scale(1.0, 1.0);

        jPanelImprimir.printAll(graphics);

        return PAGE_EXISTS;
    }

}
