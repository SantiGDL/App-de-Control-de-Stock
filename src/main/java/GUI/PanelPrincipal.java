/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import GUI.PanelesPRINCIPALES.PanelDeConfiguracion;
import GUI.PanelesPRINCIPALES.PanelDeProveedores;
import GUI.PanelesPRINCIPALES.PanelDeItems;
import GUI.PanelesInternos.LoginJPanel;
import GUI.PanelesPRINCIPALES.PanelDeCatalogos;
import GUI.PanelesPRINCIPALES.PanelDeHistoriales;
import GUI.PanelesPRINCIPALES.PanelDeStock;
import GUI.PanelesPRINCIPALES.PanelDeTODASLasFunciones;
import ImagenesHelpers.ImagenesHelper;
import ImagenesHelpers.PanelDeFondo;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Santi-kun
 */
public class PanelPrincipal extends javax.swing.JPanel {

    /**
     * Creates new form PanelPrincipal
     */
    public PanelPrincipal() {
        JPanel fondo = new PanelDeFondo("/Imagenes/Fondo.png");
        fondo.setLayout(new BorderLayout()); // o el layout que uses
        initComponents();
        
        // 1) Armo grilla centrada (3 columnas)
        ImagenesHelper.armarMenuEnGrilla(
        Contenido,
        new JButton[] {
            StockBotonGrande, ITEMS1, PROVEEDORES1,
            menuCatalogos1, Historial1, Configuracion1
        },
        3,   // columnas
        30,  // gap horizontal
        30,  // gap vertical
        25   // padding
        );

        // 2) Seteo tamaño consistente (opcional, pero queda muy pro)
        ImagenesHelper.setTamanoTarjeta(StockBotonGrande, 220, 140);
        ImagenesHelper.setTamanoTarjeta(ITEMS1, 220, 140);
        ImagenesHelper.setTamanoTarjeta(PROVEEDORES1, 220, 140);
        ImagenesHelper.setTamanoTarjeta(menuCatalogos1, 220, 140);
        ImagenesHelper.setTamanoTarjeta(Historial1, 220, 140);
        ImagenesHelper.setTamanoTarjeta(Configuracion1, 220, 140);

        // 3) Iconos escalados + texto centrado
        ImagenesHelper.configurarBotonTarjeta(StockBotonGrande, "STOCK", "/Imagenes/StockBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(ITEMS1, "ITEMS", "/Imagenes/ItemsBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(PROVEEDORES1, "PROVEEDORES", "/Imagenes/ProveedoresBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(menuCatalogos1, "CATÁLOGOS", "/Imagenes/CatalogoBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(Historial1, "HISTORIAL", "/Imagenes/HistorialBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(Configuracion1, "CONFIGURACIÓN", "/Imagenes/ConfiguracionBoton.png", 64, 64);
    }
        
        /*
        JPanel fondoMenu = ImagenesHelper.envolverConFondoEscalable(Contenido, "/Imagenes/Fondo.png");
        Fondo.remove(Contenido);    
        Fondo.setLayout(new BorderLayout());
        Fondo.add(fondoMenu, BorderLayout.CENTER);
        Fondo.revalidate();
        Fondo.repaint();
        
    }
    private void configurarContenidoCentrado() {
        // 1) El panel que ya tenés (Contenido) lo dejamos como contenedor principal
        Contenido.removeAll();
        Contenido.setOpaque(false); // clave si Contenido tiene fondo pintado por tu PanelDeFondo
        Contenido.setLayout(new java.awt.GridBagLayout());

        // 2) Panel "grilla" transparente que contiene los botones
        javax.swing.JPanel grilla = new javax.swing.JPanel(new java.awt.GridBagLayout());
        grilla.setOpaque(false);

        java.awt.GridBagConstraints c = new java.awt.GridBagConstraints();
        c.insets = new java.awt.Insets(20, 20, 20, 20); // separación entre botones
        c.fill = java.awt.GridBagConstraints.NONE;      // no estirar botones
        c.anchor = java.awt.GridBagConstraints.CENTER;

        // tamaño fijo tipo “tarjeta”
        java.awt.Dimension card = new java.awt.Dimension(220, 120);
        aplicarTamanioCard(StockBotonGrande, card);
        aplicarTamanioCard(ITEMSBotonGrande, card);
        aplicarTamanioCard(PROVEEDORES1, card);
        aplicarTamanioCard(CatalogosBotonGrande, card);
        aplicarTamanioCard(HistorialBotonGrande, card);
        aplicarTamanioCard(ConfiguracionBotonGrande, card);

        // fila 0
        c.gridx = 0; c.gridy = 0; grilla.add(StockBotonGrande, c);
        c.gridx = 1; c.gridy = 0; grilla.add(ITEMSBotonGrande, c);
        c.gridx = 2; c.gridy = 0; grilla.add(PROVEEDORES1, c);

        // fila 1
        c.gridx = 0; c.gridy = 1; grilla.add(CatalogosBotonGrande, c);
        c.gridx = 1; c.gridy = 1; grilla.add(HistorialBotonGrande, c);
        c.gridx = 2; c.gridy = 1; grilla.add(ConfiguracionBotonGrande, c);

        // 3) Meter la grilla centrada dentro de Contenido
        java.awt.GridBagConstraints wrap = new java.awt.GridBagConstraints();
        wrap.weightx = 1.0;
        wrap.weighty = 1.0;
        wrap.anchor = java.awt.GridBagConstraints.CENTER;
        Contenido.add(grilla, wrap);

        Contenido.revalidate();
        Contenido.repaint();
    }

    private void aplicarTamanioCard(javax.swing.JButton b, java.awt.Dimension d) {
        b.setPreferredSize(d);
        b.setMinimumSize(d);
        b.setMaximumSize(d); // evita que GroupLayout/GridBag lo agrande
        b.setFocusPainted(false);
        b.setBorderPainted(false);
    }
    */
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        MenuLateral = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Configuracion = new javax.swing.JButton();
        VenderItem1 = new javax.swing.JButton();
        ITEMS = new javax.swing.JButton();
        PROVEEDORES = new javax.swing.JButton();
        Historial = new javax.swing.JButton();
        menuCatalogos = new javax.swing.JButton();
        Stock = new javax.swing.JButton();
        MenuSuperior = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Contenido = new PanelDeFondo("/Imagenes/Fondo.png");
        StockBotonGrande = new javax.swing.JButton();
        ITEMS1 = new javax.swing.JButton();
        PROVEEDORES1 = new javax.swing.JButton();
        Historial1 = new javax.swing.JButton();
        menuCatalogos1 = new javax.swing.JButton();
        Configuracion1 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setPreferredSize(new java.awt.Dimension(800, 500));
        Fondo.setRequestFocusEnabled(false);

        MenuLateral.setBackground(new java.awt.Color(51, 153, 255));
        MenuLateral.setPreferredSize(new java.awt.Dimension(200, 500));
        MenuLateral.setRequestFocusEnabled(false);

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/TelecomLogo.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ACCIONES");

        Configuracion.setBackground(new java.awt.Color(153, 255, 255));
        Configuracion.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        Configuracion.setForeground(new java.awt.Color(0, 0, 0));
        Configuracion.setText("CONFIGURACIÓN");
        Configuracion.setBorder(null);
        Configuracion.setBorderPainted(false);
        Configuracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Configuracion.addActionListener(this::ConfiguracionActionPerformed);

        VenderItem1.setForeground(new java.awt.Color(0, 0, 0));
        VenderItem1.setBorder(null);
        VenderItem1.setBorderPainted(false);
        VenderItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VenderItem1.addActionListener(this::VenderItem1ActionPerformed);

        ITEMS.setBackground(new java.awt.Color(204, 102, 255));
        ITEMS.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        ITEMS.setForeground(new java.awt.Color(0, 0, 0));
        ITEMS.setText("ITEMS");
        ITEMS.setBorder(null);
        ITEMS.setBorderPainted(false);
        ITEMS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ITEMS.addActionListener(this::ITEMSActionPerformed);

        PROVEEDORES.setBackground(new java.awt.Color(153, 255, 153));
        PROVEEDORES.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        PROVEEDORES.setForeground(new java.awt.Color(0, 0, 0));
        PROVEEDORES.setText("PROVEEDORES");
        PROVEEDORES.setBorder(null);
        PROVEEDORES.setBorderPainted(false);
        PROVEEDORES.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PROVEEDORES.addActionListener(this::PROVEEDORESActionPerformed);

        Historial.setBackground(new java.awt.Color(255, 255, 204));
        Historial.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        Historial.setForeground(new java.awt.Color(0, 0, 0));
        Historial.setText("HISTORIAL");
        Historial.setBorder(null);
        Historial.setBorderPainted(false);
        Historial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Historial.addActionListener(this::HistorialActionPerformed);

        menuCatalogos.setBackground(new java.awt.Color(255, 153, 153));
        menuCatalogos.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        menuCatalogos.setForeground(new java.awt.Color(0, 0, 0));
        menuCatalogos.setText("CATÁLOGOS");
        menuCatalogos.setBorder(null);
        menuCatalogos.setBorderPainted(false);
        menuCatalogos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuCatalogos.addActionListener(this::menuCatalogosActionPerformed);

        Stock.setBackground(new java.awt.Color(29, 63, 243));
        Stock.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        Stock.setForeground(new java.awt.Color(0, 0, 0));
        Stock.setText("STOCK");
        Stock.setBorder(null);
        Stock.setBorderPainted(false);
        Stock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Stock.addActionListener(this::StockActionPerformed);

        javax.swing.GroupLayout MenuLateralLayout = new javax.swing.GroupLayout(MenuLateral);
        MenuLateral.setLayout(MenuLateralLayout);
        MenuLateralLayout.setHorizontalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(Configuracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ITEMS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PROVEEDORES, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Historial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuCatalogos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLateralLayout.createSequentialGroup()
                        .addComponent(Logo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLateralLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(VenderItem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(63, 63, 63))))
            .addComponent(Stock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuLateralLayout.setVerticalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addComponent(Logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Stock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ITEMS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PROVEEDORES)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Historial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuCatalogos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Configuracion)
                .addGap(94, 94, 94)
                .addComponent(VenderItem1)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        MenuSuperior.setBackground(new java.awt.Color(0, 102, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MENÚ PRINCIPAL");

        javax.swing.GroupLayout MenuSuperiorLayout = new javax.swing.GroupLayout(MenuSuperior);
        MenuSuperior.setLayout(MenuSuperiorLayout);
        MenuSuperiorLayout.setHorizontalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuSuperiorLayout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
        );
        MenuSuperiorLayout.setVerticalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuSuperiorLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        Contenido.setBackground(new java.awt.Color(204, 204, 204));
        Contenido.setPreferredSize(new java.awt.Dimension(700, 320));
        Contenido.setVerifyInputWhenFocusTarget(false);

        StockBotonGrande.setBackground(new java.awt.Color(29, 63, 243));
        StockBotonGrande.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        StockBotonGrande.setForeground(new java.awt.Color(255, 255, 255));
        StockBotonGrande.setText("STOCK");
        StockBotonGrande.setBorder(null);
        StockBotonGrande.setBorderPainted(false);
        StockBotonGrande.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        StockBotonGrande.addActionListener(this::StockBotonGrandeActionPerformed);

        ITEMS1.setBackground(new java.awt.Color(204, 102, 255));
        ITEMS1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        ITEMS1.setForeground(new java.awt.Color(255, 255, 255));
        ITEMS1.setText("ITEMS");
        ITEMS1.setBorder(null);
        ITEMS1.setBorderPainted(false);
        ITEMS1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ITEMS1.addActionListener(this::ITEMS1ActionPerformed);

        PROVEEDORES1.setBackground(new java.awt.Color(153, 255, 153));
        PROVEEDORES1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        PROVEEDORES1.setForeground(new java.awt.Color(255, 255, 255));
        PROVEEDORES1.setText("PROVEEDORES");
        PROVEEDORES1.setBorder(null);
        PROVEEDORES1.setBorderPainted(false);
        PROVEEDORES1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PROVEEDORES1.addActionListener(this::PROVEEDORES1ActionPerformed);

        Historial1.setBackground(new java.awt.Color(234, 252, 82));
        Historial1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        Historial1.setForeground(new java.awt.Color(255, 255, 255));
        Historial1.setText("HISTORIAL");
        Historial1.setBorder(null);
        Historial1.setBorderPainted(false);
        Historial1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Historial1.addActionListener(this::Historial1ActionPerformed);

        menuCatalogos1.setBackground(new java.awt.Color(255, 153, 153));
        menuCatalogos1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        menuCatalogos1.setForeground(new java.awt.Color(255, 255, 255));
        menuCatalogos1.setText("CATÁLOGOS");
        menuCatalogos1.setBorder(null);
        menuCatalogos1.setBorderPainted(false);
        menuCatalogos1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuCatalogos1.addActionListener(this::menuCatalogos1ActionPerformed);

        Configuracion1.setBackground(new java.awt.Color(153, 255, 255));
        Configuracion1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        Configuracion1.setForeground(new java.awt.Color(255, 255, 255));
        Configuracion1.setText("CONFIGURACIÓN");
        Configuracion1.setBorder(null);
        Configuracion1.setBorderPainted(false);
        Configuracion1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Configuracion1.addActionListener(this::Configuracion1ActionPerformed);

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(menuCatalogos1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(StockBotonGrande, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Historial1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(ITEMS1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PROVEEDORES1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Configuracion1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContenidoLayout.createSequentialGroup()
                        .addComponent(StockBotonGrande, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ITEMS1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PROVEEDORES1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63)
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menuCatalogos1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Historial1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Configuracion1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
        );

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(MenuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(MenuSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
        );

        add(Fondo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void ConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiguracionActionPerformed
        JPanel configuracionPanel = new PanelDeConfiguracion();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(configuracionPanel);
    }//GEN-LAST:event_ConfiguracionActionPerformed

    private void VenderItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenderItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VenderItem1ActionPerformed

    private void ITEMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ITEMSActionPerformed
        JPanel  menuItems = new PanelDeItems();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(menuItems);
    }//GEN-LAST:event_ITEMSActionPerformed

    private void PROVEEDORESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PROVEEDORESActionPerformed
        JPanel  menuProveedores = new PanelDeProveedores();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(menuProveedores);
    }//GEN-LAST:event_PROVEEDORESActionPerformed

    private void HistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistorialActionPerformed
      JPanel  menuHistoriales = new PanelDeHistoriales();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(menuHistoriales);
    }//GEN-LAST:event_HistorialActionPerformed

    private void menuCatalogosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCatalogosActionPerformed
      JPanel  menuCatalogos = new PanelDeCatalogos();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(menuCatalogos);
    }//GEN-LAST:event_menuCatalogosActionPerformed

    private void StockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StockActionPerformed
     JPanel  stockPanel = new PanelDeStock();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(stockPanel);
    }//GEN-LAST:event_StockActionPerformed

    private void Configuracion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Configuracion1ActionPerformed
        JPanel configuracionPanel = new PanelDeConfiguracion();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(configuracionPanel);
    }//GEN-LAST:event_Configuracion1ActionPerformed

    private void menuCatalogos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCatalogos1ActionPerformed
        JPanel  menuCatalogos = new PanelDeCatalogos();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(menuCatalogos);
    }//GEN-LAST:event_menuCatalogos1ActionPerformed

    private void Historial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Historial1ActionPerformed
        JPanel  menuHistoriales = new PanelDeHistoriales();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(menuHistoriales);
    }//GEN-LAST:event_Historial1ActionPerformed

    private void PROVEEDORES1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PROVEEDORES1ActionPerformed
        JPanel  menuProveedores = new PanelDeProveedores();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(menuProveedores);
    }//GEN-LAST:event_PROVEEDORES1ActionPerformed

    private void ITEMS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ITEMS1ActionPerformed
        JPanel  menuItems = new PanelDeItems();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(menuItems);
    }//GEN-LAST:event_ITEMS1ActionPerformed

    private void StockBotonGrandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StockBotonGrandeActionPerformed
        JPanel  stockPanel = new PanelDeStock();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(stockPanel);
    }//GEN-LAST:event_StockBotonGrandeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Configuracion;
    private javax.swing.JButton Configuracion1;
    private javax.swing.JPanel Contenido;
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton Historial;
    private javax.swing.JButton Historial1;
    private javax.swing.JButton ITEMS;
    private javax.swing.JButton ITEMS1;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel MenuLateral;
    private javax.swing.JPanel MenuSuperior;
    private javax.swing.JButton PROVEEDORES;
    private javax.swing.JButton PROVEEDORES1;
    private javax.swing.JButton Stock;
    private javax.swing.JButton StockBotonGrande;
    private javax.swing.JButton VenderItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton menuCatalogos;
    private javax.swing.JButton menuCatalogos1;
    // End of variables declaration//GEN-END:variables
}
