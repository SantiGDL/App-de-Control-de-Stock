package GUI;
import GUI.MenusSuperiores.EliminarItemMenuSuperior;
import GUI.MenusSuperiores.MenuSuperiorPrincipal;
import GUI.PanelesInternos.LoginJPanel;
import GUI.PanelesInternos.PanelPrincipal;
import GUI.PanelesInternosConfiguracion.EliminarItemJPanel;
import javax.swing.JPanel;
public class ConfiguracionJPanel extends javax.swing.JPanel {
    public ConfiguracionJPanel() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuLateral = new javax.swing.JPanel();
        EliminarItem = new javax.swing.JButton();
        ConfigurarAlertas = new javax.swing.JButton();
        Logo = new javax.swing.JLabel();
        Atras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Configuracion = new javax.swing.JButton();
        MenuSuperior = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Contenido = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setName(""); // NOI18N

        MenuLateral.setBackground(new java.awt.Color(51, 153, 255));
        MenuLateral.setPreferredSize(new java.awt.Dimension(200, 500));
        MenuLateral.setRequestFocusEnabled(false);

        EliminarItem.setForeground(new java.awt.Color(0, 0, 0));
        EliminarItem.setText("<html> <div style ='text-align:center;'> Eliminar Item <br> Permanentemente /<html>");
        EliminarItem.setBorder(null);
        EliminarItem.setBorderPainted(false);
        EliminarItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EliminarItem.addActionListener(this::EliminarItemActionPerformed);

        ConfigurarAlertas.setForeground(new java.awt.Color(0, 0, 0));
        ConfigurarAlertas.setText("Configurar Alertas");
        ConfigurarAlertas.setBorder(null);
        ConfigurarAlertas.setBorderPainted(false);
        ConfigurarAlertas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ConfigurarAlertas.addActionListener(this::ConfigurarAlertasActionPerformed);

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/TelecomLogo.png"))); // NOI18N

        Atras.setForeground(new java.awt.Color(0, 0, 0));
        Atras.setText("Regresar");
        Atras.setBorder(null);
        Atras.setBorderPainted(false);
        Atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Atras.addActionListener(this::AtrasActionPerformed);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ACCIONES");

        Configuracion.setForeground(new java.awt.Color(0, 0, 0));
        Configuracion.setText("sin uso por ahora");
        Configuracion.setBorder(null);
        Configuracion.setBorderPainted(false);
        Configuracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Configuracion.addActionListener(this::ConfiguracionActionPerformed);

        javax.swing.GroupLayout MenuLateralLayout = new javax.swing.GroupLayout(MenuLateral);
        MenuLateral.setLayout(MenuLateralLayout);
        MenuLateralLayout.setHorizontalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ConfigurarAlertas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Atras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Configuracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(EliminarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addGroup(MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Logo))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuLateralLayout.setVerticalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addComponent(Logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Atras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConfigurarAlertas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EliminarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Configuracion)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        MenuSuperior.setBackground(new java.awt.Color(0, 102, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CONFIGURACION");

        javax.swing.GroupLayout MenuSuperiorLayout = new javax.swing.GroupLayout(MenuSuperior);
        MenuSuperior.setLayout(MenuSuperiorLayout);
        MenuSuperiorLayout.setHorizontalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuSuperiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        MenuSuperiorLayout.setVerticalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        Contenido.setBackground(new java.awt.Color(204, 204, 204));
        Contenido.setPreferredSize(new java.awt.Dimension(700, 320));
        Contenido.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MenuSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    //FUNCIONES
    public void cambiarContenido(JPanel panelNuevo) {
    panelNuevo.setSize(Contenido.getMaximumSize());
    panelNuevo.setLocation(0, 0);
    Contenido.removeAll();
    Contenido.add(panelNuevo);
    Contenido.revalidate();
    Contenido.repaint();
    }
    
    public void cambiarMenuSuperior(JPanel menuNuevo){
        menuNuevo.setSize(MenuSuperior.getMaximumSize());
        menuNuevo.setLocation(0, 0);
        MenuSuperior.removeAll();
        MenuSuperior.add(menuNuevo);
        MenuSuperior.revalidate();
        MenuSuperior.repaint();
        
    }
    
    //cam
    public void volverAMenuPrincipal(){
        //Borro la Barra de Arriba, el Menu y El Contenido del Configuracion JPanel para volver al Menu Principal
        MenuSuperior.removeAll();
        MenuLateral.removeAll();
        Contenido.removeAll();
        //Crep el Menu superior Principal y lo agrego nuevamente al JFrame, en si lo agrego al mismo JPanel, lo reutilizo como nunca salgo del JFrame
        JPanel menuSuperiorP = new MenuSuperiorPrincipal();
        MenuSuperior.add(menuSuperiorP);
        MenuSuperior.revalidate();
        MenuSuperior.repaint();
        /*
        JPanel menuLateral = new MenuLateralPrincipal();
        MenuLateral.add(menuLateral);
        MenuLateral.revalidate();
        MenuLateral.repaint();
        */
        JPanel contenidoPrincipal = new PanelPrincipal();
        Contenido.add(contenidoPrincipal);
        Contenido.revalidate();
        Contenido.repaint();
        
    }
    
   
    
    
    private void EliminarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarItemActionPerformed
        // Creo el panel CrearProveedor
        //JPanel eliminarItem = new EliminarItemJPanel();
        //cambiarContenido(eliminarItem);
        JPanel eliminarItemMenuSuperior = new EliminarItemMenuSuperior();
        cambiarMenuSuperior(eliminarItemMenuSuperior);
        
    }//GEN-LAST:event_EliminarItemActionPerformed

    private void ConfigurarAlertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfigurarAlertasActionPerformed
        //JPanel configAlertas = new ConfigurarAlertasJPanel();
        //cambiarContenido(configAlertas);
    }//GEN-LAST:event_ConfigurarAlertasActionPerformed

    private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasActionPerformed
        JPanel loginPanel = new LoginJPanel();
        cambiarContenido(loginPanel);
    }//GEN-LAST:event_AtrasActionPerformed

    private void ConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiguracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfiguracionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atras;
    private javax.swing.JButton Configuracion;
    private javax.swing.JButton ConfigurarAlertas;
    private javax.swing.JPanel Contenido;
    private javax.swing.JButton EliminarItem;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel MenuLateral;
    private javax.swing.JPanel MenuSuperior;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
