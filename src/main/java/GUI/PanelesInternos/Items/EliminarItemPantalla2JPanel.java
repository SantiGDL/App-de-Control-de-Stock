/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.PanelesInternos.Items;
import GUI.FramePrincipal;
import GUI.GUIController;
import GUI.PanelPrincipal;
import ImagenesHelpers.ImagenesHelper;
import ImagenesHelpers.PanelDeFondo;
import Persistencia.Clases.ItemDeSTOCK;
import Persistencia.DTOs.DTItem;
import Persistencia.DTOs.DTItemDeSTOCK;
import Persistencia.ManejadorDePersistencia;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Santi-kun
 */
public class EliminarItemPantalla2JPanel extends javax.swing.JPanel {
    Long itemId;
    private DTItem dtItem;
    GUIController controller = new GUIController();

    private void configurarVista() {
        MenuLateral2.setBackground(new Color(22, 73, 138));
        MenuLateral2.setPreferredSize(new Dimension(200, 0));
        MenuLateral2.setMinimumSize(new Dimension(200, 0));
        MenuLateral2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));

        MenuSuperior2.removeAll();
        MenuSuperior2.setLayout(new BorderLayout());
        MenuSuperior2.setPreferredSize(new Dimension(0, 100));
        MenuSuperior2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        jLabel8.setText("CONFIRMAR ELIMINACIÓN");
        jLabel8.setFont(new Font("Segoe UI Black", Font.PLAIN, 36));
        jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
        MenuSuperior2.add(jLabel8, BorderLayout.CENTER);

        NombreItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        DescripcionItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        NombreItem.setPreferredSize(new Dimension(320, 38));
        DescripcionItem.setPreferredSize(new Dimension(320, 38));
        NombreItem.setBorder(new EmptyBorder(7, 10, 7, 10));
        DescripcionItem.setBorder(new EmptyBorder(7, 10, 7, 10));

        ImagenItem.setPreferredSize(new Dimension(180, 180));
        ImagenItem.setMinimumSize(new Dimension(180, 180));
        ImagenItem.setBorder(BorderFactory.createLineBorder(new Color(205, 213, 222), 2));
        ImagenItem.removeAll();
        ImagenItem.setLayout(new BorderLayout());
        RellenoImagenItem.setHorizontalAlignment(SwingConstants.CENTER);
        ImagenItem.add(RellenoImagenItem, BorderLayout.CENTER);

        Eliminar.setText("ELIMINAR DEFINITIVAMENTE");
        Eliminar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        Eliminar.setBackground(new Color(196, 54, 65));
        Eliminar.setForeground(Color.WHITE);
        Eliminar.setOpaque(true);
        Eliminar.setContentAreaFilled(true);
        Eliminar.setBorderPainted(false);
        Eliminar.setFocusPainted(false);
        Eliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Eliminar.setPreferredSize(new Dimension(250, 42));

        JPanel tarjeta = new JPanel(new GridBagLayout());
        tarjeta.setBackground(new Color(250, 248, 244));
        tarjeta.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(207, 216, 226), 1),
            new EmptyBorder(26, 32, 26, 32)
        ));

        JLabel advertencia = new JLabel(
            "<html><div style='text-align:center'><b>¿Querés eliminar este ítem?</b><br>"
            + "Dejará de aparecer en el catálogo y en las operaciones nuevas.</div></html>",
            SwingConstants.CENTER
        );
        advertencia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        advertencia.setForeground(new Color(92, 55, 58));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 24, 0);
        tarjeta.add(advertencia, gbc);

        gbc.gridwidth = 1; gbc.gridx = 0; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 6, 28);
        tarjeta.add(NombreItemLbl, gbc);
        gbc.gridy = 2; gbc.insets = new Insets(0, 0, 18, 28);
        tarjeta.add(NombreItem, gbc);
        gbc.gridy = 3; gbc.insets = new Insets(0, 0, 6, 28);
        tarjeta.add(DescripcionItemLbl, gbc);
        gbc.gridy = 4; gbc.insets = new Insets(0, 0, 22, 28);
        tarjeta.add(DescripcionItem, gbc);
        gbc.gridy = 5; gbc.insets = new Insets(0, 0, 0, 28);
        tarjeta.add(Eliminar, gbc);

        gbc.gridx = 1; gbc.gridy = 1; gbc.gridheight = 5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 0, 0);
        tarjeta.add(ImagenItem, gbc);

        Contenido.removeAll();
        Contenido.setLayout(new GridBagLayout());
        Contenido.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, Color.BLACK));
        Contenido.add(tarjeta);

        JPanel derecha = new JPanel(new BorderLayout(0, 0));
        derecha.add(MenuSuperior2, BorderLayout.NORTH);
        derecha.add(Contenido, BorderLayout.CENTER);
        Fondo.removeAll();
        Fondo.setLayout(new BorderLayout(0, 0));
        Fondo.add(MenuLateral2, BorderLayout.WEST);
        Fondo.add(derecha, BorderLayout.CENTER);
        Fondo.revalidate();
        Fondo.repaint();
    }
    /**
     * Creates new form EliminarItemPantalla2JPanel
     */
    public EliminarItemPantalla2JPanel(Long itemId) {
        initComponents();
        configurarVista();
        this.itemId = itemId;
        dtItem = controller.recuperarDTItemDeId(itemId);
        cargarDatos();
        //CONFIGURAR BOTONES LATERALES
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
        ATRAS,
        "ATRÁS",
        //Icono
        ImagenesHelper.iconoTintado("/Imagenes/ItemsBoton.png", Color.WHITE, 37, 37),
        //Color Base
        new Color(204, 102, 255),
        //Color del hover
        new Color(133, 66, 166),
        //Color del texto
        Color.BLACK
        );
    }
    public void cargarDatos(){
        //Datos Item
        NombreItem.setText(dtItem.getNombre()); 
        NombreItem.setEditable(false);
        DescripcionItem.setText(dtItem.getDescripcion());
        DescripcionItem.setEditable(false);
        controller.mostrarImagenEnPanel(ImagenItem, RellenoImagenItem, dtItem.getImagen());
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
        MenuSuperior2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        MenuLateral2 = new javax.swing.JPanel();
        Logo3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        VenderItem3 = new javax.swing.JButton();
        INICIO = new javax.swing.JButton();
        ATRAS = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Contenido = new PanelDeFondo("/Imagenes/Fondo.png");
        ContenedorDatosItem = new PanelDeFondo("/Imagenes/Fondo.png");
        NombreItemLbl = new javax.swing.JLabel();
        NombreItem = new javax.swing.JTextField();
        DescripcionItemLbl = new javax.swing.JLabel();
        DescripcionItem = new javax.swing.JTextField();
        ImagenItemLbl = new javax.swing.JLabel();
        ImagenItem = new javax.swing.JPanel();
        RellenoImagenItem = new javax.swing.JLabel();
        TituloDatosItem = new javax.swing.JLabel();
        Eliminar = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setPreferredSize(new java.awt.Dimension(800, 500));
        Fondo.setRequestFocusEnabled(false);

        MenuSuperior2.setBackground(new java.awt.Color(0, 102, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("VENDER ITEM");

        javax.swing.GroupLayout MenuSuperior2Layout = new javax.swing.GroupLayout(MenuSuperior2);
        MenuSuperior2.setLayout(MenuSuperior2Layout);
        MenuSuperior2Layout.setHorizontalGroup(
            MenuSuperior2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuSuperior2Layout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(270, 270, 270))
        );
        MenuSuperior2Layout.setVerticalGroup(
            MenuSuperior2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuSuperior2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        MenuLateral2.setBackground(new java.awt.Color(51, 153, 255));
        MenuLateral2.setPreferredSize(new java.awt.Dimension(200, 500));
        MenuLateral2.setRequestFocusEnabled(false);

        Logo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/TelecomLogo.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ACCIONES");

        VenderItem3.setForeground(new java.awt.Color(0, 0, 0));
        VenderItem3.setBorder(null);
        VenderItem3.setBorderPainted(false);
        VenderItem3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VenderItem3.addActionListener(this::VenderItem3ActionPerformed);

        INICIO.setBackground(new java.awt.Color(204, 255, 255));
        INICIO.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        INICIO.setForeground(new java.awt.Color(0, 0, 0));
        INICIO.setText("INICIO");
        INICIO.setBorder(null);
        INICIO.setBorderPainted(false);
        INICIO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        INICIO.addActionListener(this::INICIOActionPerformed);

        ATRAS.setBackground(new java.awt.Color(204, 102, 255));
        ATRAS.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        ATRAS.setForeground(new java.awt.Color(0, 0, 0));
        ATRAS.setText("ATRÁS");
        ATRAS.setBorder(null);
        ATRAS.setBorderPainted(false);
        ATRAS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ATRAS.addActionListener(this::ATRASActionPerformed);

        javax.swing.GroupLayout MenuLateral2Layout = new javax.swing.GroupLayout(MenuLateral2);
        MenuLateral2.setLayout(MenuLateral2Layout);
        MenuLateral2Layout.setHorizontalGroup(
            MenuLateral2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLateral2Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(MenuLateral2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuLateral2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLateral2Layout.createSequentialGroup()
                        .addComponent(Logo3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLateral2Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(VenderItem3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(63, 63, 63))))
            .addComponent(INICIO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ATRAS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuLateral2Layout.setVerticalGroup(
            MenuLateral2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLateral2Layout.createSequentialGroup()
                .addComponent(Logo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(INICIO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ATRAS)
                .addGap(168, 168, 168)
                .addComponent(VenderItem3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Contenido.setBackground(new java.awt.Color(204, 204, 204));
        Contenido.setVerifyInputWhenFocusTarget(false);

        ContenedorDatosItem.setBackground(new java.awt.Color(189, 249, 249));
        ContenedorDatosItem.setOpaque(false);

        NombreItemLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        NombreItemLbl.setForeground(new java.awt.Color(0, 0, 0));
        NombreItemLbl.setText("Nombre");

        NombreItem.addActionListener(this::NombreItemActionPerformed);

        DescripcionItemLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        DescripcionItemLbl.setForeground(new java.awt.Color(0, 0, 0));
        DescripcionItemLbl.setText("Descripción");

        DescripcionItem.addActionListener(this::DescripcionItemActionPerformed);

        ImagenItemLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        ImagenItemLbl.setForeground(new java.awt.Color(0, 0, 0));
        ImagenItemLbl.setText("Imágen");

        javax.swing.GroupLayout ImagenItemLayout = new javax.swing.GroupLayout(ImagenItem);
        ImagenItem.setLayout(ImagenItemLayout);
        ImagenItemLayout.setHorizontalGroup(
            ImagenItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
            .addGroup(ImagenItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ImagenItemLayout.createSequentialGroup()
                    .addComponent(RellenoImagenItem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        ImagenItemLayout.setVerticalGroup(
            ImagenItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
            .addGroup(ImagenItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ImagenItemLayout.createSequentialGroup()
                    .addComponent(RellenoImagenItem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        TituloDatosItem.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        TituloDatosItem.setForeground(new java.awt.Color(0, 0, 0));
        TituloDatosItem.setText("Datos Item:");

        Eliminar.setBackground(new java.awt.Color(51, 204, 255));
        Eliminar.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        Eliminar.setText("ELIMINAR");
        Eliminar.setBorder(null);
        Eliminar.addActionListener(this::EliminarActionPerformed);

        javax.swing.GroupLayout ContenedorDatosItemLayout = new javax.swing.GroupLayout(ContenedorDatosItem);
        ContenedorDatosItem.setLayout(ContenedorDatosItemLayout);
        ContenedorDatosItemLayout.setHorizontalGroup(
            ContenedorDatosItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorDatosItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContenedorDatosItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContenedorDatosItemLayout.createSequentialGroup()
                        .addGroup(ContenedorDatosItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ContenedorDatosItemLayout.createSequentialGroup()
                                .addComponent(NombreItemLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenedorDatosItemLayout.createSequentialGroup()
                                .addComponent(DescripcionItemLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(ContenedorDatosItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DescripcionItem, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(NombreItem))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ContenedorDatosItemLayout.createSequentialGroup()
                        .addComponent(ImagenItemLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ImagenItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenedorDatosItemLayout.createSequentialGroup()
                .addGap(0, 339, Short.MAX_VALUE)
                .addComponent(TituloDatosItem, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(231, 231, 231))
        );
        ContenedorDatosItemLayout.setVerticalGroup(
            ContenedorDatosItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorDatosItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContenedorDatosItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ContenedorDatosItemLayout.createSequentialGroup()
                        .addComponent(TituloDatosItem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ContenedorDatosItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NombreItemLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NombreItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ContenedorDatosItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DescripcionItem, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DescripcionItemLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(ContenedorDatosItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ImagenItemLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ImagenItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addComponent(ContenedorDatosItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(186, 186, 186))
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContenedorDatosItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(736, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(Contenido);

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(MenuLateral2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuSuperior2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(MenuSuperior2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(MenuLateral2, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
        );

        add(Fondo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void VenderItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenderItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VenderItem3ActionPerformed

    private void INICIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INICIOActionPerformed
        JPanel panelPrincipal = new PanelPrincipal();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(panelPrincipal);
    }//GEN-LAST:event_INICIOActionPerformed

    private void ATRASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ATRASActionPerformed
        JPanel eliminarItems = new EliminarItemJPanel();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(eliminarItems);
    }//GEN-LAST:event_ATRASActionPerformed

    private void NombreItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreItemActionPerformed

    private void DescripcionItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescripcionItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescripcionItemActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(
            this,
            "¿Confirmás que querés eliminar \"" + dtItem.getNombre() + "\"?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
        if (confirmacion != JOptionPane.YES_OPTION) return;

        ManejadorDePersistencia MDP = ManejadorDePersistencia.getInstancia();
        MDP.desactivarItem(itemId);
        JOptionPane.showMessageDialog(this, "Ítem eliminado correctamente");
        JPanel eliminarItems = new EliminarItemJPanel();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(eliminarItems);
    }//GEN-LAST:event_EliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ATRAS;
    private javax.swing.JPanel ContenedorDatosItem;
    private javax.swing.JPanel Contenido;
    private javax.swing.JTextField DescripcionItem;
    private javax.swing.JLabel DescripcionItemLbl;
    private javax.swing.JButton Eliminar;
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton INICIO;
    private javax.swing.JPanel ImagenItem;
    private javax.swing.JLabel ImagenItemLbl;
    private javax.swing.JLabel Logo3;
    private javax.swing.JPanel MenuLateral2;
    private javax.swing.JPanel MenuSuperior2;
    private javax.swing.JTextField NombreItem;
    private javax.swing.JLabel NombreItemLbl;
    private javax.swing.JLabel RellenoImagenItem;
    private javax.swing.JLabel TituloDatosItem;
    private javax.swing.JButton VenderItem3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
