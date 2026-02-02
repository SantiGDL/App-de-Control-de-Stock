/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.PanelesPRINCIPALES;

import GUI.FramePrincipal;
import GUI.PanelPrincipal;
import GUI.PanelesPRINCIPALES.PanelDeConfiguracion;
import GUI.PanelesPRINCIPALES.PanelDeProveedores;
import GUI.PanelesPRINCIPALES.PanelDeItems;
import GUI.PanelesInternos.LoginJPanel;
import GUI.PanelesPRINCIPALES.PanelDeCatalogos;
import GUI.PanelesPRINCIPALES.PanelDeHistoriales;
import GUI.PanelesPRINCIPALES.PanelDeTODASLasFunciones;
import GUI.PanelesPRINCIPALES.PanelLateral;
import ImagenesHelpers.ImagenesHelper;
import ImagenesHelpers.PanelDeFondo;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Santi-kun
 */
public class PanelLateral extends javax.swing.JPanel {

    /**
     * Creates new form PanelLateral
     */
    public PanelLateral() {
        initComponents();
        // matar el GroupLayout que dejó un gap
        this.removeAll();
        this.setLayout(new BorderLayout(0, 0));
        this.add(MenuLateral, BorderLayout.CENTER);

        // (opcional) el borde de separación esté acá
        MenuLateral.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));

        this.revalidate();
        this.repaint();
        //CONFIGURACION DEL MENU LATERAL
        int anchoMenuLateral = 220; 
        MenuLateral.setPreferredSize(new java.awt.Dimension(anchoMenuLateral, 0));
        MenuLateral.setMinimumSize(new java.awt.Dimension(anchoMenuLateral, 0));
        MenuLateral.setBorder(new EmptyBorder(0,0,0,0));      
        int grosor = 2;
        MenuLateral.setBorder(BorderFactory.createMatteBorder(0, 0, 0, grosor, java.awt.Color.BLACK)); // importante para que no se duplique

        //CONFIGURAR BOTONES LATERALES
        ImagenesHelper.estilizarBotonMenuLateral(
        Stock,
        "STOCK",
        //Icono
        ImagenesHelper.iconoTintado("/Imagenes/StockBoton.png", Color.WHITE, 37, 37),
        //Color Base
        new Color(29, 63, 243),
        //Color del hover
        new Color(19, 41, 158),
        //Color del texto
        Color.BLACK
        );
        
        ImagenesHelper.estilizarBotonMenuLateral(
        ITEMS,
        "ITEMS",
        //Icono
        ImagenesHelper.iconoTintado("/Imagenes/ItemsBoton.png", Color.WHITE, 37, 37),
        //Color Base
        new Color(204, 102, 255),
        //Color del hover
        new Color(133, 66, 166),
        //Color del texto
        Color.BLACK
        );
        
        ImagenesHelper.estilizarBotonMenuLateral(
        PROVEEDORES,
        "PROVEEDORES",
        //Icono
        ImagenesHelper.iconoTintado("/Imagenes/ProveedoresBoton.png", Color.WHITE, 37, 37),
        //Color Base
        new Color(153, 255, 153),
        //Color del hover
        new Color(99, 166, 99),
        //Color del texto
        Color.BLACK
        );
        
        ImagenesHelper.estilizarBotonMenuLateral(
        HISTORIAL,
        "HISTORIAL",
        //Icono
        ImagenesHelper.iconoTintado("/Imagenes/HistorialBoton.png", Color.WHITE, 37, 37),
        //Color Base
        new Color (0, 204, 204),
        //Color del hover
        new Color(0, 140, 140),
        //Color del texto
        Color.BLACK
        );
        
        ImagenesHelper.estilizarBotonMenuLateral(
        CATALOGOS,
        "CATÁLOGOS",
        //Icono
        ImagenesHelper.iconoTintado("/Imagenes/CatalogoBoton.png", Color.WHITE, 37, 37),
        //Color Base
        new Color(255, 153, 153),
        //Color del hover
        new Color(166, 99, 99),
        //Color del texto
        Color.BLACK
        );
        
        ImagenesHelper.estilizarBotonMenuLateral(
        CONFIGURACION,
        "CONFIGURACIÓN",
        //Icono
        ImagenesHelper.iconoTintado("/Imagenes/ConfiguracionBoton.png", Color.WHITE, 37, 37),
        //Color Base
        new Color(153, 255, 255),
        //Color del hover
        new Color(99, 166, 166),
        //Color del texto
        Color.BLACK
        );
        
        ImagenesHelper.estilizarBotonMenuLateral(
        INICIO,
        "INICIO",
        //Icono
        ImagenesHelper.iconoTintado("/Imagenes/InicioBoton.png", Color.WHITE, 37, 37),
        //Color Base
        new Color(153, 255, 255),
        //Color del hover
        new Color(99, 166, 166),
        //Color del texto
        Color.BLACK
        );
        
        ImagenesHelper.estilizarBotonMenuLateral(
        TodasLasFunciones,
        "TODO",
        //Icono
        ImagenesHelper.iconoTintado("/Imagenes/TodasLasFuncionesBoton.png", Color.WHITE, 37, 37),
        //Color Base
        new Color(153,255,255),
        //Color del hover
        new Color(99, 166, 166),
        //Color del texto
        Color.BLACK
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuLateral = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        CONFIGURACION = new javax.swing.JButton();
        VenderItem1 = new javax.swing.JButton();
        ITEMS = new javax.swing.JButton();
        PROVEEDORES = new javax.swing.JButton();
        HISTORIAL = new javax.swing.JButton();
        CATALOGOS = new javax.swing.JButton();
        Stock = new javax.swing.JButton();
        INICIO = new javax.swing.JButton();
        TodasLasFunciones = new javax.swing.JButton();

        MenuLateral.setBackground(new java.awt.Color(51, 153, 255));
        MenuLateral.setPreferredSize(new java.awt.Dimension(200, 500));
        MenuLateral.setRequestFocusEnabled(false);

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/TelecomLogo.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ACCIONES");

        CONFIGURACION.setBackground(new java.awt.Color(153, 255, 255));
        CONFIGURACION.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        CONFIGURACION.setForeground(new java.awt.Color(0, 0, 0));
        CONFIGURACION.setText("CONFIGURACIÓN");
        CONFIGURACION.setBorder(null);
        CONFIGURACION.setBorderPainted(false);
        CONFIGURACION.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CONFIGURACION.addActionListener(this::CONFIGURACIONActionPerformed);

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

        HISTORIAL.setBackground(new java.awt.Color(255, 255, 204));
        HISTORIAL.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        HISTORIAL.setForeground(new java.awt.Color(0, 0, 0));
        HISTORIAL.setText("HISTORIAL");
        HISTORIAL.setBorder(null);
        HISTORIAL.setBorderPainted(false);
        HISTORIAL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HISTORIAL.addActionListener(this::HISTORIALActionPerformed);

        CATALOGOS.setBackground(new java.awt.Color(255, 153, 153));
        CATALOGOS.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        CATALOGOS.setForeground(new java.awt.Color(0, 0, 0));
        CATALOGOS.setText("CATÁLOGOS");
        CATALOGOS.setBorder(null);
        CATALOGOS.setBorderPainted(false);
        CATALOGOS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CATALOGOS.addActionListener(this::CATALOGOSActionPerformed);

        Stock.setBackground(new java.awt.Color(29, 63, 243));
        Stock.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        Stock.setForeground(new java.awt.Color(0, 0, 0));
        Stock.setText("STOCK");
        Stock.setBorder(null);
        Stock.setBorderPainted(false);
        Stock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Stock.addActionListener(this::StockActionPerformed);

        INICIO.setBackground(new java.awt.Color(153, 255, 255));
        INICIO.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        INICIO.setForeground(new java.awt.Color(0, 0, 0));
        INICIO.setText("INICIO");
        INICIO.setBorder(null);
        INICIO.setBorderPainted(false);
        INICIO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        INICIO.addActionListener(this::INICIOActionPerformed);

        TodasLasFunciones.setBackground(new java.awt.Color(153, 255, 255));
        TodasLasFunciones.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        TodasLasFunciones.setForeground(new java.awt.Color(0, 0, 0));
        TodasLasFunciones.setText("TODAS LAS FUNCIONES");
        TodasLasFunciones.setBorder(null);
        TodasLasFunciones.setBorderPainted(false);
        TodasLasFunciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TodasLasFunciones.addActionListener(this::TodasLasFuncionesActionPerformed);

        javax.swing.GroupLayout MenuLateralLayout = new javax.swing.GroupLayout(MenuLateral);
        MenuLateral.setLayout(MenuLateralLayout);
        MenuLateralLayout.setHorizontalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(CONFIGURACION, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ITEMS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PROVEEDORES, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(HISTORIAL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CATALOGOS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Stock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(INICIO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(TodasLasFunciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuLateralLayout.setVerticalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addComponent(Logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(INICIO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Stock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ITEMS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PROVEEDORES)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HISTORIAL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CATALOGOS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CONFIGURACION)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TodasLasFunciones)
                .addGap(49, 49, 49)
                .addComponent(VenderItem1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 208, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CONFIGURACIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONFIGURACIONActionPerformed
        JPanel configuracionPanel = new PanelDeConfiguracion();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(configuracionPanel);
    }//GEN-LAST:event_CONFIGURACIONActionPerformed

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

    private void HISTORIALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HISTORIALActionPerformed
        JPanel  menuHistoriales = new PanelDeHistoriales();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(menuHistoriales);
    }//GEN-LAST:event_HISTORIALActionPerformed

    private void CATALOGOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CATALOGOSActionPerformed
        JPanel  menuCatalogos = new PanelDeCatalogos();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(menuCatalogos);
    }//GEN-LAST:event_CATALOGOSActionPerformed

    private void StockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StockActionPerformed
       JPanel  stockPanel = new PanelDeStock();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(stockPanel);
    }//GEN-LAST:event_StockActionPerformed

    private void INICIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INICIOActionPerformed
        JPanel panelPrincipal = new PanelPrincipal();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(panelPrincipal);
    }//GEN-LAST:event_INICIOActionPerformed

    private void TodasLasFuncionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TodasLasFuncionesActionPerformed
      JPanel todasLasFunciones = new PanelDeTODASLasFunciones();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(todasLasFunciones);
    }//GEN-LAST:event_TodasLasFuncionesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CATALOGOS;
    private javax.swing.JButton CONFIGURACION;
    private javax.swing.JButton HISTORIAL;
    private javax.swing.JButton INICIO;
    private javax.swing.JButton ITEMS;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel MenuLateral;
    private javax.swing.JButton PROVEEDORES;
    private javax.swing.JButton Stock;
    private javax.swing.JButton TodasLasFunciones;
    private javax.swing.JButton VenderItem1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
