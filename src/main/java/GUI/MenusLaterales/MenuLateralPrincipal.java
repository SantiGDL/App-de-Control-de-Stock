/*
package GUI.MenusLaterales;

import GUI.ConfiguracionJPanel;
import GUI.GUIController;
import javax.swing.JPanel;

public class MenuLateralPrincipal extends javax.swing.JPanel {

    public MenuLateralPrincipal() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuLateral = new javax.swing.JPanel();
        CrearProveedor = new javax.swing.JButton();
        CrearItem = new javax.swing.JButton();
        Logo = new javax.swing.JLabel();
        Login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Configuracion = new javax.swing.JButton();

        MenuLateral.setBackground(new java.awt.Color(51, 153, 255));
        MenuLateral.setPreferredSize(new java.awt.Dimension(200, 500));
        MenuLateral.setRequestFocusEnabled(false);

        CrearProveedor.setForeground(new java.awt.Color(255, 255, 255));
        CrearProveedor.setText("Crear Proveedor");
        CrearProveedor.setBorder(null);
        CrearProveedor.setBorderPainted(false);
        CrearProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CrearProveedor.addActionListener(this::CrearProveedorActionPerformed);

        CrearItem.setForeground(new java.awt.Color(255, 255, 255));
        CrearItem.setText("Crear Item");
        CrearItem.setBorder(null);
        CrearItem.setBorderPainted(false);
        CrearItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CrearItem.addActionListener(this::CrearItemActionPerformed);

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/TelecomLogo.png"))); // NOI18N

        Login.setForeground(new java.awt.Color(255, 255, 255));
        Login.setText("Login");
        Login.setBorder(null);
        Login.setBorderPainted(false);
        Login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Login.addActionListener(this::LoginActionPerformed);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("OPCIONES");

        Configuracion.setForeground(new java.awt.Color(255, 255, 255));
        Configuracion.setText("Configuración");
        Configuracion.setBorder(null);
        Configuracion.setBorderPainted(false);
        Configuracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Configuracion.addActionListener(this::ConfiguracionActionPerformed);

        javax.swing.GroupLayout MenuLateralLayout = new javax.swing.GroupLayout(MenuLateral);
        MenuLateral.setLayout(MenuLateralLayout);
        MenuLateralLayout.setHorizontalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CrearItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(CrearProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(Configuracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuLateralLayout.setVerticalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addComponent(Logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CrearItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CrearProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Configuracion)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CrearProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearProveedorActionPerformed
        // Creo el panel CrearProveedor
        JPanel crearProveedorPanel = new CrearProveedorJPanel();
        controller.cambiarContenido(crearProveedorPanel, Contenido);
    }//GEN-LAST:event_CrearProveedorActionPerformed

    private void CrearItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearItemActionPerformed
        JPanel crearItemPanel = new CrearItemJPanel();
        controller.cambiarContenido(crearItemPanel, Contenido);
    }//GEN-LAST:event_CrearItemActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        JPanel loginPanel = new LoginJPanel();
        controller.cambiarContenido(loginPanel, Contenido);
    }//GEN-LAST:event_LoginActionPerformed

    private void ConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiguracionActionPerformed
        JPanel configuracionPanel = new ConfiguracionJPanel();
        GUIController controller = new GUIController();
        controller.cambiarPanelEntero(MenuSuperior, MenuLateral, Contenido, Fondo, configuracionPanel, this);

    }//GEN-LAST:event_ConfiguracionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Configuracion;
    private javax.swing.JButton CrearItem;
    private javax.swing.JButton CrearProveedor;
    private javax.swing.JButton Login;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel MenuLateral;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
*/