package vistas;

import java.awt.Dimension;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import modelo.EntidadVendedor;

public class Principal extends javax.swing.JFrame {
    
    EntidadVendedor ev=null;
    public Principal(EntidadVendedor ev) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.ev=ev;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VentanaPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuGenerarVenta = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        MenuCliente = new javax.swing.JMenuItem();
        MenuProducto = new javax.swing.JMenuItem();
        MenuVendedor = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        VentanaPrincipal.setBackground(new java.awt.Color(0, 102, 153));
        VentanaPrincipal.setForeground(new java.awt.Color(0, 51, 255));

        javax.swing.GroupLayout VentanaPrincipalLayout = new javax.swing.GroupLayout(VentanaPrincipal);
        VentanaPrincipal.setLayout(VentanaPrincipalLayout);
        VentanaPrincipalLayout.setHorizontalGroup(
            VentanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
        );
        VentanaPrincipalLayout.setVerticalGroup(
            VentanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/home.png"))); // NOI18N
        jMenu1.setText("Menu");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ayuda.png"))); // NOI18N
        jMenuItem1.setText("Ayuda");
        jMenu1.add(jMenuItem1);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cliente.png"))); // NOI18N
        jMenuItem7.setText("Acerca");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/enter.png"))); // NOI18N
        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logoventas.png"))); // NOI18N
        jMenu2.setText("Ventas");

        menuGenerarVenta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        menuGenerarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ticket.png"))); // NOI18N
        menuGenerarVenta.setText("Generar Venta");
        menuGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGenerarVentaActionPerformed(evt);
            }
        });
        jMenu2.add(menuGenerarVenta);

        jMenuBar1.add(jMenu2);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reportes.png"))); // NOI18N
        jMenu4.setText("Reportes");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/opcreport.png"))); // NOI18N
        jMenuItem6.setText("Reporte de Ventas");
        jMenu4.add(jMenuItem6);

        jMenuBar1.add(jMenu4);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logomanten.png"))); // NOI18N
        jMenu3.setText("Mantenimiento");

        MenuCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        MenuCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cliente.png"))); // NOI18N
        MenuCliente.setText("Cliente");
        MenuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuClienteActionPerformed(evt);
            }
        });
        jMenu3.add(MenuCliente);

        MenuProducto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        MenuProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/producto.png"))); // NOI18N
        MenuProducto.setText("Producto");
        MenuProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuProductoActionPerformed(evt);
            }
        });
        jMenu3.add(MenuProducto);

        MenuVendedor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        MenuVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/vendedor.png"))); // NOI18N
        MenuVendedor.setText("Vendedor");
        MenuVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuVendedorActionPerformed(evt);
            }
        });
        jMenu3.add(MenuVendedor);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VentanaPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VentanaPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Acerca a = new Acerca();
        CentrarVentana(a);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int r=JOptionPane.showConfirmDialog(null,"Esta seguro de Salir?");
        if(r==0){
           System.exit(0);
        }
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menuGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGenerarVentaActionPerformed
        VentasForm vf = new VentasForm(this.ev);
        CentrarVentana(vf);
    }//GEN-LAST:event_menuGenerarVentaActionPerformed

    private void MenuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuClienteActionPerformed
        ClienteForm c = new ClienteForm();
        CentrarVentana(c);
    }//GEN-LAST:event_MenuClienteActionPerformed

    private void MenuProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuProductoActionPerformed
        ProductoForm pf = new ProductoForm();
        CentrarVentana(pf);

    }//GEN-LAST:event_MenuProductoActionPerformed

    private void MenuVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuVendedorActionPerformed
        VendedorForm v = new VendedorForm();
        CentrarVentana(v);
    }//GEN-LAST:event_MenuVendedorActionPerformed
    
    public static void CentrarVentana(JInternalFrame frame) {
        VentanaPrincipal.add(frame);
        Dimension dimension = VentanaPrincipal.getSize();
        Dimension Dframe = frame.getSize();
        frame.setLocation((dimension.width - Dframe.width) / 2, (dimension.height - Dframe.height) / 2);
        frame.show();
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuCliente;
    private javax.swing.JMenuItem MenuProducto;
    private javax.swing.JMenuItem MenuVendedor;
    public static javax.swing.JDesktopPane VentanaPrincipal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem menuGenerarVenta;
    // End of variables declaration//GEN-END:variables
}
