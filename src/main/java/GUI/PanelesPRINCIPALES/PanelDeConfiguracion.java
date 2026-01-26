package GUI.PanelesPRINCIPALES;
import GUI.FramePrincipal;
import GUI.GUIController;
import GUI.PanelPrincipal;
import GUI.PanelesInternos.LoginJPanel;
import GUI.PanelesInternosConfiguraciones.EliminarItemJPanel;
import javax.swing.JPanel;
public class PanelDeConfiguracion extends javax.swing.JPanel {
    GUIController controller = new GUIController();
    public PanelDeConfiguracion() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        MenuLateral = new javax.swing.JPanel();
        ConfigurarAlertas = new javax.swing.JButton();
        Logo = new javax.swing.JLabel();
        Atras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        MenuSuperior = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Contenido = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setName(""); // NOI18N
        setLayout(new java.awt.BorderLayout());

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setName(""); // NOI18N

        MenuLateral.setBackground(new java.awt.Color(51, 153, 255));
        MenuLateral.setPreferredSize(new java.awt.Dimension(200, 500));
        MenuLateral.setRequestFocusEnabled(false);

        ConfigurarAlertas.setBackground(new java.awt.Color(102, 102, 255));
        ConfigurarAlertas.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        ConfigurarAlertas.setForeground(new java.awt.Color(0, 0, 0));
        ConfigurarAlertas.setText("Configurar Alertas (NOK)");
        ConfigurarAlertas.setBorder(null);
        ConfigurarAlertas.setBorderPainted(false);
        ConfigurarAlertas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ConfigurarAlertas.addActionListener(this::ConfigurarAlertasActionPerformed);

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/TelecomLogo.png"))); // NOI18N

        Atras.setBackground(new java.awt.Color(153, 255, 255));
        Atras.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        Atras.setForeground(new java.awt.Color(0, 0, 0));
        Atras.setText("Atrás");
        Atras.setBorder(null);
        Atras.setBorderPainted(false);
        Atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Atras.addActionListener(this::AtrasActionPerformed);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ACCIONES");

        javax.swing.GroupLayout MenuLateralLayout = new javax.swing.GroupLayout(MenuLateral);
        MenuLateral.setLayout(MenuLateralLayout);
        MenuLateralLayout.setHorizontalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ConfigurarAlertas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Atras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(207, Short.MAX_VALUE))
        );

        MenuSuperior.setBackground(new java.awt.Color(0, 102, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MENU CONFIGURACIÓN");

        javax.swing.GroupLayout MenuSuperiorLayout = new javax.swing.GroupLayout(MenuSuperior);
        MenuSuperior.setLayout(MenuSuperiorLayout);
        MenuSuperiorLayout.setHorizontalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuSuperiorLayout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(79, 79, 79))
        );
        MenuSuperiorLayout.setVerticalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        Contenido.setBackground(new java.awt.Color(204, 204, 204));
        Contenido.setPreferredSize(new java.awt.Dimension(700, 320));
        Contenido.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 802, Short.MAX_VALUE)
            .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FondoLayout.createSequentialGroup()
                    .addComponent(MenuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MenuSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE))))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
            .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FondoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(MenuSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                .addComponent(MenuLateral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE))
        );

        add(Fondo, java.awt.BorderLayout.CENTER);
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
    /*
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
        
        JPanel menuLateral = new MenuLateralPrincipal();
        MenuLateral.add(menuLateral);
        MenuLateral.revalidate();
        MenuLateral.repaint();
        
        JPanel contenidoPrincipal = new ContenidoDePanelPrincipal();
        Contenido.add(contenidoPrincipal);
        Contenido.revalidate();
        Contenido.repaint();
        
    }
    */
   
    
    
    private void ConfigurarAlertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfigurarAlertasActionPerformed
        //JPanel configAlertas = new ConfigurarAlertasJPanel();
        //cambiarContenido(configAlertas);
    }//GEN-LAST:event_ConfigurarAlertasActionPerformed

    private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasActionPerformed
        JPanel panelPrincipal = new PanelPrincipal();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(panelPrincipal);
    }//GEN-LAST:event_AtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atras;
    private javax.swing.JButton ConfigurarAlertas;
    private javax.swing.JPanel Contenido;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel MenuLateral;
    private javax.swing.JPanel MenuSuperior;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
