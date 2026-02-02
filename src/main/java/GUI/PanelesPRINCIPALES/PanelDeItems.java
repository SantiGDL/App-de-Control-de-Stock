/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.PanelesPRINCIPALES;

import GUI.FramePrincipal;
import GUI.PanelPrincipal;
import GUI.PanelesInternos.Items.ComprarItem.ComprarItemJPanel;
import GUI.PanelesInternos.Items.CrearItemJPanel;
import GUI.PanelesInternos.Items.EliminarItemJPanel;
import GUI.PanelesInternos.Items.VenderItemJPanel;
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
public class PanelDeItems extends javax.swing.JPanel {
    private void montarMenuLateralReutilizable() {
        MenuLateral.removeAll();
        MenuLateral.setLayout(new BorderLayout());
        MenuLateral.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));

        PanelLateral lateral = new PanelLateral();   // tu menú reusable real
        MenuLateral.add(lateral, BorderLayout.CENTER);

        MenuLateral.revalidate();
        MenuLateral.repaint();
    }
    /**
     * Creates new form PanelDeItems
     */
    
    public PanelDeItems() {
        initComponents();
        JPanel fondo = new PanelDeFondo("/Imagenes/Fondo.png");
        fondo.setLayout(new BorderLayout()); // o el layout que uses
        initComponents();
        //CONFIURO EL FONDO PARA QUE SE VEA TODO JUNTO SIN SEPARACION
        Fondo.removeAll();
        Fondo.setLayout(new BorderLayout(0, 0));
        Fondo.setBorder(new EmptyBorder(0,0,0,0));
        montarMenuLateralReutilizable();
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
        

        JPanel derecha = new JPanel(new BorderLayout(0, 0));
        derecha.setBorder(new EmptyBorder(0,0,0,0));
        derecha.add(MenuSuperior, BorderLayout.NORTH);
        derecha.add(Contenido, BorderLayout.CENTER);
        

        Fondo.add(derecha, BorderLayout.CENTER);

        Fondo.revalidate();
        Fondo.repaint();
        Fondo.add(MenuLateral, BorderLayout.WEST);
        // Centrar título
        MenuSuperior.removeAll();
        MenuSuperior.setLayout(new BorderLayout());
        MenuSuperior.add(TextoMenuSuperior, BorderLayout.CENTER);
        TextoMenuSuperior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        
        // 1) Armo grilla centrada (3 columnas)
        ImagenesHelper.armarMenuEnGrilla(
        Contenido,
        new JButton[] {
            CrearItemBoton, ComprarItemBoton, VenderItemBoton, EliminarItemBoton, 
        },
        2,   // columnas
        30,  // gap horizontal
        30,  // gap vertical
        25   // padding
        );

        // 2) Seteo tamaño consistente 
        ImagenesHelper.setTamanoTarjeta(CrearItemBoton, 220, 140);
        ImagenesHelper.setTamanoTarjeta(ComprarItemBoton, 220, 140);
        ImagenesHelper.setTamanoTarjeta(VenderItemBoton, 220, 140);
        ImagenesHelper.setTamanoTarjeta(EliminarItemBoton, 220, 140);

        // 3) Iconos escalados + texto centrado
        ImagenesHelper.configurarBotonTarjeta(CrearItemBoton, "Crear Item", "/Imagenes/CrearItemBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(ComprarItemBoton, "Comprar Item", "/Imagenes/ComprarItemBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(VenderItemBoton, "Vender Item", "/Imagenes/VenderItemBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(EliminarItemBoton, "Eliminar Item", "/Imagenes/EliminarItemBoton.png", 64, 64);
        
        //CONFIGURO EL HOVER DE LOS BOTONES CENTRALES
        ImagenesHelper.aplicarHoverOscuro(CrearItemBoton, 0.65);
        ImagenesHelper.aplicarHoverOscuro(ComprarItemBoton, 0.65);
        ImagenesHelper.aplicarHoverOscuro(VenderItemBoton, 0.65);
        ImagenesHelper.aplicarHoverOscuro(EliminarItemBoton, 0.65);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        MenuLateral = new PanelLateral();
        VenderItem1 = new javax.swing.JButton();
        MenuSuperior = new javax.swing.JPanel();
        TextoMenuSuperior = new javax.swing.JLabel();
        Contenido = new PanelDeFondo("/Imagenes/Fondo.png");
        CrearItemBoton = new javax.swing.JButton();
        ComprarItemBoton = new javax.swing.JButton();
        VenderItemBoton = new javax.swing.JButton();
        EliminarItemBoton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setPreferredSize(new java.awt.Dimension(800, 500));
        Fondo.setRequestFocusEnabled(false);

        MenuLateral.setBackground(new java.awt.Color(51, 153, 255));
        MenuLateral.setPreferredSize(new java.awt.Dimension(200, 500));
        MenuLateral.setRequestFocusEnabled(false);

        VenderItem1.setForeground(new java.awt.Color(0, 0, 0));
        VenderItem1.setBorder(null);
        VenderItem1.setBorderPainted(false);
        VenderItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VenderItem1.addActionListener(this::VenderItem1ActionPerformed);

        javax.swing.GroupLayout MenuLateralLayout = new javax.swing.GroupLayout(MenuLateral);
        MenuLateral.setLayout(MenuLateralLayout);
        MenuLateralLayout.setHorizontalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(VenderItem1, javax.swing.GroupLayout.DEFAULT_SIZE, 7, Short.MAX_VALUE)
                .addGap(63, 63, 63))
        );
        MenuLateralLayout.setVerticalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addGap(399, 399, 399)
                .addComponent(VenderItem1)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        MenuSuperior.setBackground(new java.awt.Color(0, 102, 255));

        TextoMenuSuperior.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        TextoMenuSuperior.setForeground(new java.awt.Color(255, 255, 255));
        TextoMenuSuperior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextoMenuSuperior.setText("MENU ITEMS");

        javax.swing.GroupLayout MenuSuperiorLayout = new javax.swing.GroupLayout(MenuSuperior);
        MenuSuperior.setLayout(MenuSuperiorLayout);
        MenuSuperiorLayout.setHorizontalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuSuperiorLayout.createSequentialGroup()
                .addContainerGap(238, Short.MAX_VALUE)
                .addComponent(TextoMenuSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        MenuSuperiorLayout.setVerticalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuSuperiorLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(TextoMenuSuperior)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        Contenido.setBackground(new java.awt.Color(204, 204, 204));
        Contenido.setPreferredSize(new java.awt.Dimension(700, 320));
        Contenido.setVerifyInputWhenFocusTarget(false);

        CrearItemBoton.setBackground(new java.awt.Color(204, 102, 255));
        CrearItemBoton.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        CrearItemBoton.setForeground(new java.awt.Color(255, 255, 255));
        CrearItemBoton.setText("Crear Item");
        CrearItemBoton.setBorder(new javax.swing.border.MatteBorder(null));
        CrearItemBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CrearItemBoton.addActionListener(this::CrearItemBotonActionPerformed);

        ComprarItemBoton.setBackground(new java.awt.Color(204, 102, 255));
        ComprarItemBoton.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        ComprarItemBoton.setForeground(new java.awt.Color(255, 255, 255));
        ComprarItemBoton.setText("Comprar Item ");
        ComprarItemBoton.setBorder(new javax.swing.border.MatteBorder(null));
        ComprarItemBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ComprarItemBoton.addActionListener(this::ComprarItemBotonActionPerformed);

        VenderItemBoton.setBackground(new java.awt.Color(204, 102, 255));
        VenderItemBoton.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        VenderItemBoton.setForeground(new java.awt.Color(255, 255, 255));
        VenderItemBoton.setText("Vender Item");
        VenderItemBoton.setBorder(new javax.swing.border.MatteBorder(null));
        VenderItemBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VenderItemBoton.addActionListener(this::VenderItemBotonActionPerformed);

        EliminarItemBoton.setBackground(new java.awt.Color(204, 102, 255));
        EliminarItemBoton.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        EliminarItemBoton.setForeground(new java.awt.Color(255, 255, 255));
        EliminarItemBoton.setText("Elimnar Item");
        EliminarItemBoton.setBorder(new javax.swing.border.MatteBorder(null));
        EliminarItemBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EliminarItemBoton.addActionListener(this::EliminarItemBotonActionPerformed);

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EliminarItemBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CrearItemBoton, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(ComprarItemBoton, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(VenderItemBoton, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CrearItemBoton)
                    .addComponent(ComprarItemBoton)
                    .addComponent(VenderItemBoton))
                .addGap(29, 29, 29)
                .addComponent(EliminarItemBoton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(33, 33, 33)
                .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(Fondo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void CrearItemBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearItemBotonActionPerformed
        JPanel crearItemPanel = new CrearItemJPanel();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(crearItemPanel);
    }//GEN-LAST:event_CrearItemBotonActionPerformed

    private void ComprarItemBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprarItemBotonActionPerformed
        JPanel  comprarItem = new ComprarItemJPanel();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(comprarItem);
    }//GEN-LAST:event_ComprarItemBotonActionPerformed

    private void VenderItemBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenderItemBotonActionPerformed
    JPanel venderItem = new VenderItemJPanel();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(venderItem);  
    }//GEN-LAST:event_VenderItemBotonActionPerformed

    private void VenderItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenderItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VenderItem1ActionPerformed

    private void EliminarItemBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarItemBotonActionPerformed
       JPanel eliminarItem = new EliminarItemJPanel();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(eliminarItem);
    }//GEN-LAST:event_EliminarItemBotonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ComprarItemBoton;
    private javax.swing.JPanel Contenido;
    private javax.swing.JButton CrearItemBoton;
    private javax.swing.JButton EliminarItemBoton;
    private javax.swing.JPanel Fondo;
    private javax.swing.JPanel MenuLateral;
    private javax.swing.JPanel MenuSuperior;
    private javax.swing.JLabel TextoMenuSuperior;
    private javax.swing.JButton VenderItem1;
    private javax.swing.JButton VenderItemBoton;
    // End of variables declaration//GEN-END:variables
}
