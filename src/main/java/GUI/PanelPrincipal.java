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
import GUI.PanelesPRINCIPALES.PanelLateral;
import ImagenesHelpers.ImagenesHelper;
import ImagenesHelpers.PanelDeFondo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;


/**
 *
 * @author Santi-kun
 */
public class PanelPrincipal extends javax.swing.JPanel {
    private JScrollPane scrollContenido;
    private void montarMenuLateralReutilizable() {
        MenuLateral.removeAll();
        MenuLateral.setLayout(new BorderLayout());
        PanelLateral lateral = new PanelLateral();   // menú reusable real
        MenuLateral.add(lateral, BorderLayout.CENTER);
        MenuLateral.revalidate();
        MenuLateral.repaint();
    }
    
    /**
     * Creates new form PanelPrincipal
     */
    public PanelPrincipal() {
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
        scrollContenido = new JScrollPane(Contenido);
        scrollContenido.setBorder(null);
        scrollContenido.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollContenido.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollContenido.setOpaque(false);
        scrollContenido.getViewport().setOpaque(false);
        scrollContenido.getVerticalScrollBar().setUnitIncrement(18);
        derecha.add(scrollContenido, BorderLayout.CENTER);
        

        Fondo.add(derecha, BorderLayout.CENTER);

        Fondo.revalidate();
        Fondo.repaint();
        Fondo.add(MenuLateral, BorderLayout.WEST);
        // Centrar título
        MenuSuperior.removeAll();
        MenuSuperior.setLayout(new BorderLayout());
        MenuSuperior.add(TextoMenuSuperior, BorderLayout.CENTER);
        TextoMenuSuperior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        // 1) Armo grilla centrada 
        JButton[] botonesPrincipales = new JButton[] {
            StockBotonGrande, ItemBotonGrande, ProveedoresBotonGrande,
            CatalogosBotonGrande, HistorialBotonGrande, ConfiguracionBotonGrande
        };

        // 2) Seteo tamaño consistente 
        ImagenesHelper.setTamanoTarjeta(StockBotonGrande, 220, 140);
        ImagenesHelper.setTamanoTarjeta(ItemBotonGrande, 220, 140);
        ImagenesHelper.setTamanoTarjeta(ProveedoresBotonGrande, 220, 140);
        ImagenesHelper.setTamanoTarjeta(CatalogosBotonGrande, 220, 140);
        ImagenesHelper.setTamanoTarjeta(HistorialBotonGrande, 220, 140);
        ImagenesHelper.setTamanoTarjeta(ConfiguracionBotonGrande, 220, 140);

        // 3) Iconos escalados + texto centrado
        ImagenesHelper.configurarBotonTarjeta(StockBotonGrande, "STOCK", "/Imagenes/StockBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(ItemBotonGrande, "ITEMS", "/Imagenes/ItemsBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(ProveedoresBotonGrande, "PROVEEDORES", "/Imagenes/ProveedoresBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(CatalogosBotonGrande, "CATÁLOGOS", "/Imagenes/CatalogoBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(HistorialBotonGrande, "HISTORIAL", "/Imagenes/HistorialBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(ConfiguracionBotonGrande, "CONFIGURACIÓN", "/Imagenes/ConfiguracionBoton.png", 64, 64);
    
       
        
        
        //CONFIGURO EL HOVER DE LOS BOTONES CENTRALES
        ImagenesHelper.aplicarHoverOscuro(StockBotonGrande, 0.65);
        ImagenesHelper.aplicarHoverOscuro(ItemBotonGrande, 0.65);
        ImagenesHelper.aplicarHoverOscuro(ProveedoresBotonGrande, 0.65);
        ImagenesHelper.aplicarHoverOscuro(CatalogosBotonGrande, 0.65);
        ImagenesHelper.aplicarHoverOscuro(HistorialBotonGrande, 0.65);
        ImagenesHelper.aplicarHoverOscuro(ConfiguracionBotonGrande, 0.65);

        instalarInicioResponsivo(botonesPrincipales);

    }

    private void instalarInicioResponsivo(JButton[] botones) {
        Runnable adaptar = () -> {
            int ancho = Math.max(scrollContenido.getViewport().getWidth(), 220);
            int anchoTarjeta = 220;
            int altoTarjeta = 140;
            int gap = 24;
            int margen = 20;
            int columnas = Math.max(1, Math.min(3,
                    (ancho - margen * 2 + gap) / (anchoTarjeta + gap)));
            int filas = (int) Math.ceil(botones.length / (double) columnas);

            Contenido.removeAll();
            Contenido.setLayout(new GridBagLayout());
            Contenido.setBorder(BorderFactory.createEmptyBorder(margen, margen, margen, margen));
            for (int i = 0; i < botones.length; i++) {
                JButton boton = botones[i];
                ImagenesHelper.setTamanoTarjeta(boton, anchoTarjeta, altoTarjeta);
                GridBagConstraints c = new GridBagConstraints();
                c.gridx = i % columnas;
                c.gridy = i / columnas;
                c.insets = new Insets(gap / 2, gap / 2, gap / 2, gap / 2);
                Contenido.add(boton, c);
            }

            int altoNecesario = margen * 2 + filas * altoTarjeta + filas * gap;
            int altoViewport = scrollContenido.getViewport().getHeight();
            Contenido.setPreferredSize(new Dimension(ancho, Math.max(altoNecesario, altoViewport)));
            Contenido.revalidate();
            Contenido.repaint();
        };

        scrollContenido.getViewport().addComponentListener(new ComponentAdapter() {
            @Override public void componentResized(ComponentEvent e) { adaptar.run(); }
        });
        javax.swing.SwingUtilities.invokeLater(adaptar);
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
        StockBotonGrande = new javax.swing.JButton();
        ItemBotonGrande = new javax.swing.JButton();
        ProveedoresBotonGrande = new javax.swing.JButton();
        HistorialBotonGrande = new javax.swing.JButton();
        CatalogosBotonGrande = new javax.swing.JButton();
        ConfiguracionBotonGrande = new javax.swing.JButton();

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
                .addComponent(VenderItem1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(63, 63, 63))
        );
        MenuLateralLayout.setVerticalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addGap(408, 408, 408)
                .addComponent(VenderItem1)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        MenuSuperior.setBackground(new java.awt.Color(0, 102, 255));

        TextoMenuSuperior.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        TextoMenuSuperior.setForeground(new java.awt.Color(255, 255, 255));
        TextoMenuSuperior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextoMenuSuperior.setText("MENÚ PRINCIPAL");

        javax.swing.GroupLayout MenuSuperiorLayout = new javax.swing.GroupLayout(MenuSuperior);
        MenuSuperior.setLayout(MenuSuperiorLayout);
        MenuSuperiorLayout.setHorizontalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuSuperiorLayout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addComponent(TextoMenuSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
        );
        MenuSuperiorLayout.setVerticalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuSuperiorLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(TextoMenuSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        ItemBotonGrande.setBackground(new java.awt.Color(204, 102, 255));
        ItemBotonGrande.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        ItemBotonGrande.setForeground(new java.awt.Color(255, 255, 255));
        ItemBotonGrande.setText("ITEMS");
        ItemBotonGrande.setBorder(null);
        ItemBotonGrande.setBorderPainted(false);
        ItemBotonGrande.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ItemBotonGrande.addActionListener(this::ItemBotonGrandeActionPerformed);

        ProveedoresBotonGrande.setBackground(new java.awt.Color(153, 255, 153));
        ProveedoresBotonGrande.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        ProveedoresBotonGrande.setForeground(new java.awt.Color(255, 255, 255));
        ProveedoresBotonGrande.setText("PROVEEDORES");
        ProveedoresBotonGrande.setBorder(null);
        ProveedoresBotonGrande.setBorderPainted(false);
        ProveedoresBotonGrande.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ProveedoresBotonGrande.addActionListener(this::ProveedoresBotonGrandeActionPerformed);

        HistorialBotonGrande.setBackground(new java.awt.Color(0, 204, 204));
        HistorialBotonGrande.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        HistorialBotonGrande.setForeground(new java.awt.Color(255, 255, 255));
        HistorialBotonGrande.setText("HISTORIAL");
        HistorialBotonGrande.setBorder(null);
        HistorialBotonGrande.setBorderPainted(false);
        HistorialBotonGrande.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HistorialBotonGrande.addActionListener(this::HistorialBotonGrandeActionPerformed);

        CatalogosBotonGrande.setBackground(new java.awt.Color(255, 153, 153));
        CatalogosBotonGrande.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        CatalogosBotonGrande.setForeground(new java.awt.Color(255, 255, 255));
        CatalogosBotonGrande.setText("CATÁLOGOS");
        CatalogosBotonGrande.setBorder(null);
        CatalogosBotonGrande.setBorderPainted(false);
        CatalogosBotonGrande.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CatalogosBotonGrande.addActionListener(this::CatalogosBotonGrandeActionPerformed);

        ConfiguracionBotonGrande.setBackground(new java.awt.Color(153, 255, 255));
        ConfiguracionBotonGrande.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        ConfiguracionBotonGrande.setForeground(new java.awt.Color(255, 255, 255));
        ConfiguracionBotonGrande.setText("CONFIGURACIÓN");
        ConfiguracionBotonGrande.setBorder(null);
        ConfiguracionBotonGrande.setBorderPainted(false);
        ConfiguracionBotonGrande.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ConfiguracionBotonGrande.addActionListener(this::ConfiguracionBotonGrandeActionPerformed);

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(CatalogosBotonGrande, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(StockBotonGrande, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(HistorialBotonGrande, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(ItemBotonGrande, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ProveedoresBotonGrande, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ConfiguracionBotonGrande, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContenidoLayout.createSequentialGroup()
                        .addComponent(StockBotonGrande, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ItemBotonGrande, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProveedoresBotonGrande, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63)
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CatalogosBotonGrande, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HistorialBotonGrande, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConfiguracionBotonGrande, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
        );

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(MenuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(MenuSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
        );

        add(Fondo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void VenderItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenderItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VenderItem1ActionPerformed

    private void ConfiguracionBotonGrandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiguracionBotonGrandeActionPerformed
        JPanel configuracionPanel = new PanelDeConfiguracion();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(configuracionPanel);
    }//GEN-LAST:event_ConfiguracionBotonGrandeActionPerformed

    private void CatalogosBotonGrandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatalogosBotonGrandeActionPerformed
        JPanel  menuCatalogos = new PanelDeCatalogos();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(menuCatalogos);
    }//GEN-LAST:event_CatalogosBotonGrandeActionPerformed

    private void HistorialBotonGrandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistorialBotonGrandeActionPerformed
        JPanel  menuHistoriales = new PanelDeHistoriales();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(menuHistoriales);
    }//GEN-LAST:event_HistorialBotonGrandeActionPerformed

    private void ProveedoresBotonGrandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProveedoresBotonGrandeActionPerformed
        JPanel  menuProveedores = new PanelDeProveedores();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(menuProveedores);
    }//GEN-LAST:event_ProveedoresBotonGrandeActionPerformed

    private void ItemBotonGrandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemBotonGrandeActionPerformed
        JPanel  menuItems = new PanelDeItems();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(menuItems);
    }//GEN-LAST:event_ItemBotonGrandeActionPerformed

    private void StockBotonGrandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StockBotonGrandeActionPerformed
        JPanel  stockPanel = new PanelDeStock();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(stockPanel);
    }//GEN-LAST:event_StockBotonGrandeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CatalogosBotonGrande;
    private javax.swing.JButton ConfiguracionBotonGrande;
    private javax.swing.JPanel Contenido;
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton HistorialBotonGrande;
    private javax.swing.JButton ItemBotonGrande;
    private javax.swing.JPanel MenuLateral;
    private javax.swing.JPanel MenuSuperior;
    private javax.swing.JButton ProveedoresBotonGrande;
    private javax.swing.JButton StockBotonGrande;
    private javax.swing.JLabel TextoMenuSuperior;
    private javax.swing.JButton VenderItem1;
    // End of variables declaration//GEN-END:variables
}
