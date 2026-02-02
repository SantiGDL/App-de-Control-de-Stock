package GUI.PanelesPRINCIPALES;
import GUI.FramePrincipal;
import GUI.GUIController;
import GUI.PanelPrincipal;
import GUI.PanelesInternos.LoginJPanel;
import GUI.PanelesInternosConfiguraciones.ConfigurarAlertasJPanel;
import ImagenesHelpers.ImagenesHelper;
import ImagenesHelpers.PanelDeFondo;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
public class PanelDeConfiguracion extends javax.swing.JPanel {
    GUIController controller = new GUIController();
    private void montarMenuLateralReutilizable() {
        MenuLateral.removeAll();
        MenuLateral.setLayout(new BorderLayout());
        MenuLateral.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));

        PanelLateral lateral = new PanelLateral();   // tu menú reusable real
        MenuLateral.add(lateral, BorderLayout.CENTER);

        MenuLateral.revalidate();
        MenuLateral.repaint();
    }
    public PanelDeConfiguracion() {
        initComponents();
        int anchoMenuLateral = 220; 
        MenuLateral.setPreferredSize(new java.awt.Dimension(anchoMenuLateral, 0));
        MenuLateral.setMinimumSize(new java.awt.Dimension(anchoMenuLateral, 0));
        montarMenuLateralReutilizable();
        //CONFIURO EL FONDO PARA QUE SE VEA TODO JUNTO SIN SEPARACION
        Fondo.removeAll();
        Fondo.setLayout(new BorderLayout(0, 0));
        Fondo.setBorder(new EmptyBorder(0,0,0,0));

        MenuLateral.setBorder(new EmptyBorder(0,0,0,0));
        MenuSuperior.setBorder(new EmptyBorder(0,0,0,0));
        Integer alturaMenuSuperior = 100;
        MenuSuperior.setPreferredSize(new java.awt.Dimension(0, alturaMenuSuperior)); // probá 120..160
        MenuSuperior.setMinimumSize(new java.awt.Dimension(0, alturaMenuSuperior));
        MenuSuperior.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, alturaMenuSuperior));
        Contenido.setBorder(new EmptyBorder(0,0,0,0));
        int grosor = 2;

        MenuSuperior.setBorder(BorderFactory.createMatteBorder(0, 0, grosor, 0, java.awt.Color.BLACK));
        MenuLateral.setBorder(BorderFactory.createMatteBorder(0, 0, 0, grosor, java.awt.Color.BLACK)); // importante para que no se duplique

        Contenido.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, java.awt.Color.BLACK));
        Fondo.add(MenuLateral, BorderLayout.WEST);

        JPanel derecha = new JPanel(new BorderLayout(0, 0));
        derecha.setBorder(new EmptyBorder(0,0,0,0));
        derecha.add(MenuSuperior, BorderLayout.NORTH);
        derecha.add(Contenido, BorderLayout.CENTER);
        

        Fondo.add(derecha, BorderLayout.CENTER);

        Fondo.revalidate();
        Fondo.repaint();

        // Centrar título
        MenuSuperior.removeAll();
        MenuSuperior.setLayout(new BorderLayout());
        MenuSuperior.add(TextoMenuSuperior, BorderLayout.CENTER);
        TextoMenuSuperior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        // ARMO GRILLA
        ImagenesHelper.armarMenuEnGrilla(
        Contenido,
        new JButton[] {
            ConfigurarAlertasBoton
        },
        1,   // columnas
        30,  // gap horizontal
        30,  // gap vertical
        25   // padding
        );

        // 2) Seteo tamaño consistente (opcional, pero queda muy pro)
        ImagenesHelper.setTamanoTarjeta(ConfigurarAlertasBoton, 220, 140);

        // 3) Iconos escalados + texto centrado
        ImagenesHelper.configurarBotonTarjeta(ConfigurarAlertasBoton, "Configurar Alertas", "/Imagenes/ConfigurarAlertasBoton.png", 64, 64);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        MenuLateral = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        Atras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        MenuSuperior = new javax.swing.JPanel();
        TextoMenuSuperior = new javax.swing.JLabel();
        Contenido = new PanelDeFondo("/Imagenes/Fondo.png");
        ConfigurarAlertasBoton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setName(""); // NOI18N
        setLayout(new java.awt.BorderLayout());

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setName(""); // NOI18N

        MenuLateral.setBackground(new java.awt.Color(51, 153, 255));
        MenuLateral.setPreferredSize(new java.awt.Dimension(200, 500));
        MenuLateral.setRequestFocusEnabled(false);

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/TelecomLogo.png"))); // NOI18N

        Atras.setBackground(new java.awt.Color(153, 255, 255));
        Atras.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        Atras.setForeground(new java.awt.Color(0, 0, 0));
        Atras.setText("MENU PRINCIPAL");
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
                .addContainerGap(232, Short.MAX_VALUE))
        );

        MenuSuperior.setBackground(new java.awt.Color(0, 102, 255));

        TextoMenuSuperior.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        TextoMenuSuperior.setForeground(new java.awt.Color(255, 255, 255));
        TextoMenuSuperior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextoMenuSuperior.setText("MENU CONFIGURACIÓN");

        javax.swing.GroupLayout MenuSuperiorLayout = new javax.swing.GroupLayout(MenuSuperior);
        MenuSuperior.setLayout(MenuSuperiorLayout);
        MenuSuperiorLayout.setHorizontalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuSuperiorLayout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addComponent(TextoMenuSuperior)
                .addGap(79, 79, 79))
        );
        MenuSuperiorLayout.setVerticalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TextoMenuSuperior)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        Contenido.setBackground(new java.awt.Color(204, 204, 204));
        Contenido.setPreferredSize(new java.awt.Dimension(700, 320));
        Contenido.setVerifyInputWhenFocusTarget(false);

        ConfigurarAlertasBoton.setBackground(new java.awt.Color(153, 255, 255));
        ConfigurarAlertasBoton.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        ConfigurarAlertasBoton.setForeground(new java.awt.Color(0, 0, 0));
        ConfigurarAlertasBoton.setText("Configurar Alertas ");
        ConfigurarAlertasBoton.setBorder(null);
        ConfigurarAlertasBoton.setBorderPainted(false);
        ConfigurarAlertasBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ConfigurarAlertasBoton.addActionListener(this::ConfigurarAlertasBotonActionPerformed);

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ConfigurarAlertasBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(445, 445, 445))
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ConfigurarAlertasBoton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
   
    
    
    private void ConfigurarAlertasBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfigurarAlertasBotonActionPerformed
        JPanel configurarAlertas = new ConfigurarAlertasJPanel();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(configurarAlertas);
    }//GEN-LAST:event_ConfigurarAlertasBotonActionPerformed

    private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasActionPerformed
        JPanel panelPrincipal = new PanelPrincipal();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(panelPrincipal);
    }//GEN-LAST:event_AtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atras;
    private javax.swing.JButton ConfigurarAlertasBoton;
    private javax.swing.JPanel Contenido;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel MenuLateral;
    private javax.swing.JPanel MenuSuperior;
    private javax.swing.JLabel TextoMenuSuperior;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
