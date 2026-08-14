/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.PanelesInternos.Items;

import GUI.PanelesInternos.Items.ComprarItem.ComprarItemJPanel;
import GUI.FramePrincipal;
import GUI.GUIController;
import GUI.PanelPrincipal;
import GUI.PanelesPRINCIPALES.PanelDeConfiguracion;
import GUI.PanelesPRINCIPALES.PanelDeItems;
import GUI.PanelesPRINCIPALES.PanelDeProveedores;
import ImagenesHelpers.ImagenesHelper;
import ImagenesHelpers.PanelDeFondo;
import Persistencia.Clases.Item;
import Persistencia.ManejadorDePersistencia;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Window;
import javax.swing.JPanel;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Santi-kun
 */
public class CrearItemJPanel extends javax.swing.JPanel {
    private String rutaImagenSeleccionada = "";
    private final JLabel vistaPreviaImagen = new JLabel("Sin imagen", SwingConstants.CENTER);
    private final JLabel nombreArchivoImagen = new JLabel("Ningún archivo seleccionado");
    GUIController controller = new GUIController();

    private void configurarVista() {
        final Color azulSidebar = new Color(22, 73, 138);
        final Color azulAccion = new Color(0, 102, 255);

        Fondo.removeAll();
        Fondo.setLayout(new BorderLayout(0, 0));
        Fondo.setBorder(new EmptyBorder(0, 0, 0, 0));

        MenuLateral.setBackground(azulSidebar);
        MenuLateral.setPreferredSize(new Dimension(200, 0));
        MenuLateral.setMinimumSize(new Dimension(200, 0));
        MenuLateral.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));

        MenuSuperior.removeAll();
        MenuSuperior.setLayout(new BorderLayout());
        MenuSuperior.setPreferredSize(new Dimension(0, 100));
        MenuSuperior.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        TextoMenuSuperior.setText("CREAR ITEM");
        TextoMenuSuperior.setFont(new Font("Segoe UI Black", Font.PLAIN, 36));
        TextoMenuSuperior.setHorizontalAlignment(SwingConstants.CENTER);
        MenuSuperior.add(TextoMenuSuperior, BorderLayout.CENTER);

        estilizarCampo(NombreContenido);
        estilizarCampo(DescripcionContenido);
        estilizarBoton(ImagenContenido, "ELEGIR IMAGEN", azulAccion, Color.WHITE);
        estilizarBoton(Aceptar, "CREAR ITEM", new Color(30, 170, 105), Color.WHITE);

        nombreArchivoImagen.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        nombreArchivoImagen.setForeground(new Color(90, 98, 108));

        vistaPreviaImagen.setPreferredSize(new Dimension(220, 220));
        vistaPreviaImagen.setMinimumSize(new Dimension(220, 220));
        vistaPreviaImagen.setOpaque(true);
        vistaPreviaImagen.setBackground(new Color(242, 245, 249));
        vistaPreviaImagen.setForeground(new Color(105, 115, 125));
        vistaPreviaImagen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        vistaPreviaImagen.setBorder(BorderFactory.createLineBorder(new Color(205, 213, 222), 2));

        JPanel tarjeta = new JPanel(new GridBagLayout());
        tarjeta.setBackground(new Color(250, 248, 244));
        tarjeta.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(207, 216, 226), 1),
            new EmptyBorder(28, 32, 28, 32)
        ));

        JLabel descripcionFlujo = new JLabel(
            "<html><div style='text-align:center'>"
            + "Primero creá el ítem para incorporarlo al catálogo general.<br>"
            + "Después, desde <b>Comprar ítem</b>, registrá una compra para agregar unidades al stock."
            + "</div></html>",
            SwingConstants.CENTER
        );
        descripcionFlujo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        descripcionFlujo.setForeground(new Color(115, 123, 133));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 7, 28);
        tarjeta.add(crearEtiqueta("Nombre del ítem"), gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 18, 28);
        tarjeta.add(NombreContenido, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 7, 28);
        tarjeta.add(crearEtiqueta("Descripción"), gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 18, 28);
        tarjeta.add(DescripcionContenido, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 7, 28);
        tarjeta.add(crearEtiqueta("Imagen del producto"), gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 5, 28);
        tarjeta.add(ImagenContenido, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 22, 28);
        tarjeta.add(nombreArchivoImagen, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 0, 28);
        tarjeta.add(Aceptar, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 8;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 0, 0);
        tarjeta.add(vistaPreviaImagen, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 0, 0);
        tarjeta.add(descripcionFlujo, gbc);

        Contenido.removeAll();
        Contenido.setLayout(new GridBagLayout());
        Contenido.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, Color.BLACK));
        Contenido.add(tarjeta);

        JPanel derecha = new JPanel(new BorderLayout(0, 0));
        derecha.add(MenuSuperior, BorderLayout.NORTH);
        derecha.add(Contenido, BorderLayout.CENTER);
        Fondo.add(MenuLateral, BorderLayout.WEST);
        Fondo.add(derecha, BorderLayout.CENTER);
        Fondo.revalidate();
        Fondo.repaint();
    }

    private JLabel crearEtiqueta(String texto) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        etiqueta.setForeground(new Color(35, 45, 58));
        return etiqueta;
    }

    private void estilizarCampo(javax.swing.JTextField campo) {
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        campo.setPreferredSize(new Dimension(330, 38));
        campo.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(185, 196, 208), 1),
            new EmptyBorder(6, 10, 6, 10)
        ));
    }

    private void estilizarBoton(javax.swing.JButton boton, String texto, Color fondo, Color frente) {
        boton.setText(texto);
        boton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        boton.setBackground(fondo);
        boton.setForeground(frente);
        boton.setOpaque(true);
        boton.setContentAreaFilled(true);
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton.setPreferredSize(new Dimension(190, 40));
    }

    private void mostrarVistaPrevia(File archivo) {
        ImageIcon original = new ImageIcon(archivo.getAbsolutePath());
        if (original.getIconWidth() <= 0 || original.getIconHeight() <= 0) {
            vistaPreviaImagen.setIcon(null);
            vistaPreviaImagen.setText("No se pudo cargar la imagen");
            return;
        }

        int maximo = 204;
        double escala = Math.min(
            (double) maximo / original.getIconWidth(),
            (double) maximo / original.getIconHeight()
        );
        int ancho = Math.max(1, (int) Math.round(original.getIconWidth() * escala));
        int alto = Math.max(1, (int) Math.round(original.getIconHeight() * escala));
        Image imagen = original.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        vistaPreviaImagen.setText("");
        vistaPreviaImagen.setIcon(new ImageIcon(imagen));
        nombreArchivoImagen.setText(archivo.getName());
        nombreArchivoImagen.setToolTipText(archivo.getAbsolutePath());
    }
    /**
     * Creates new form CrearItem
     */
    public CrearItemJPanel() {
        initComponents();
        //CONFIURO EL FONDO PARA QUE SE VEA TODO JUNTO SIN SEPARACION
        Fondo.removeAll();
        Fondo.setLayout(new BorderLayout(0, 0));
        Fondo.setBorder(new EmptyBorder(0,0,0,0));
        //CONFIGURAR MENU SUPERIOR
        MenuSuperior.setBorder(new EmptyBorder(0,0,0,0));
        Integer alturaMenuSuperior = 100;
        MenuSuperior.setPreferredSize(new java.awt.Dimension(0, alturaMenuSuperior)); // probá 120..160
        MenuSuperior.setMinimumSize(new java.awt.Dimension(0, alturaMenuSuperior));
        MenuSuperior.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, alturaMenuSuperior));
        Contenido.setBorder(new EmptyBorder(0,0,0,0));
        int grosor = 2;
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
        configurarVista();
        
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        Fondo = new javax.swing.JPanel();
        MenuSuperior = new javax.swing.JPanel();
        TextoMenuSuperior = new javax.swing.JLabel();
        Contenido = new PanelDeFondo("/Imagenes/Fondo.png");
        NombreLbl = new javax.swing.JLabel();
        DescrpcionLbl = new javax.swing.JLabel();
        DescripcionContenido = new javax.swing.JTextField();
        Imagen = new javax.swing.JLabel();
        ImagenContenido = new javax.swing.JButton();
        Aceptar = new javax.swing.JButton();
        NombreContenido = new javax.swing.JTextField();
        MenuLateral = new javax.swing.JPanel();
        Logo1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        VenderItem1 = new javax.swing.JButton();
        INICIO = new javax.swing.JButton();
        ATRAS = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setPreferredSize(new java.awt.Dimension(800, 500));
        Fondo.setRequestFocusEnabled(false);

        MenuSuperior.setBackground(new java.awt.Color(0, 102, 255));

        TextoMenuSuperior.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        TextoMenuSuperior.setForeground(new java.awt.Color(255, 255, 255));
        TextoMenuSuperior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextoMenuSuperior.setText("Crear Item");

        javax.swing.GroupLayout MenuSuperiorLayout = new javax.swing.GroupLayout(MenuSuperior);
        MenuSuperior.setLayout(MenuSuperiorLayout);
        MenuSuperiorLayout.setHorizontalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuSuperiorLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(TextoMenuSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        MenuSuperiorLayout.setVerticalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuSuperiorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(TextoMenuSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        Contenido.setBackground(new java.awt.Color(204, 204, 204));
        Contenido.setPreferredSize(new java.awt.Dimension(700, 320));
        Contenido.setVerifyInputWhenFocusTarget(false);

        NombreLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        NombreLbl.setForeground(new java.awt.Color(0, 0, 0));
        NombreLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NombreLbl.setText("Nombre:");

        DescrpcionLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        DescrpcionLbl.setForeground(new java.awt.Color(0, 0, 0));
        DescrpcionLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DescrpcionLbl.setText("Descrpción:");

        Imagen.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        Imagen.setForeground(new java.awt.Color(0, 0, 0));
        Imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Imagen.setText("Imágen:");

        ImagenContenido.setText("Seleccionar:");
        ImagenContenido.setBorder(null);
        ImagenContenido.setBorderPainted(false);
        ImagenContenido.addActionListener(this::ImagenContenidoActionPerformed);

        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(this::AceptarActionPerformed);

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(NombreContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ContenidoLayout.createSequentialGroup()
                    .addGap(72, 72, 72)
                    .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Aceptar)
                        .addGroup(ContenidoLayout.createSequentialGroup()
                            .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(DescrpcionLbl)
                                .addComponent(Imagen))
                            .addGap(18, 18, 18)
                            .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(DescripcionContenido, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                .addComponent(ImagenContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(NombreLbl))
                    .addContainerGap(72, Short.MAX_VALUE)))
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(NombreContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ContenidoLayout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(NombreLbl)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DescrpcionLbl)
                        .addComponent(DescripcionContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Imagen)
                        .addComponent(ImagenContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(Aceptar)
                    .addContainerGap(125, Short.MAX_VALUE)))
        );

        MenuLateral.setBackground(new java.awt.Color(51, 153, 255));
        MenuLateral.setPreferredSize(new java.awt.Dimension(200, 500));
        MenuLateral.setRequestFocusEnabled(false);

        Logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/TelecomLogo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ACCIONES");

        VenderItem1.setForeground(new java.awt.Color(0, 0, 0));
        VenderItem1.setBorder(null);
        VenderItem1.setBorderPainted(false);
        VenderItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VenderItem1.addActionListener(this::VenderItem1ActionPerformed);

        INICIO.setBackground(new java.awt.Color(153, 255, 255));
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

        javax.swing.GroupLayout MenuLateralLayout = new javax.swing.GroupLayout(MenuLateral);
        MenuLateral.setLayout(MenuLateralLayout);
        MenuLateralLayout.setHorizontalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLateralLayout.createSequentialGroup()
                        .addComponent(Logo1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLateralLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(VenderItem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(63, 63, 63))))
            .addGroup(MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(INICIO, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addComponent(ATRAS, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
        );
        MenuLateralLayout.setVerticalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addComponent(Logo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232)
                .addComponent(VenderItem1)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MenuLateralLayout.createSequentialGroup()
                    .addGap(184, 184, 184)
                    .addComponent(INICIO)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(ATRAS)
                    .addContainerGap(184, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(MenuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(MenuSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
            .addComponent(MenuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
        );

        add(Fondo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        
        String nombre = NombreContenido.getText().trim();
        String descripcion = DescripcionContenido.getText().trim();
        String imagen = ""; 
        if (nombre.isEmpty()) {
        JOptionPane.showMessageDialog(this, "El nombre es obligatorio");
        return;
        }
        try {
        // Copia la imagen elegida a la carpeta raíz (si el user eligió una)
        imagen = controller.cargarImagen(rutaImagenSeleccionada);
        } catch (IOException io) {
        JOptionPane.showMessageDialog(this, "No se pudo copiar la imagen:\n" + io.getMessage());
        return;
        }
        Item nuevo = new Item(nombre, descripcion, imagen);
        try {
        
        ManejadorDePersistencia MDP = ManejadorDePersistencia.getInstancia();
        MDP.persistirItem(nuevo);
        javax.swing.JOptionPane.showMessageDialog(null, "Item creado OK");
        
        // limpiar campos
        NombreContenido.setText("");
        DescripcionContenido.setText("");
        rutaImagenSeleccionada = "";
        vistaPreviaImagen.setIcon(null);
        vistaPreviaImagen.setText("Sin imagen");
        nombreArchivoImagen.setText("Ningún archivo seleccionado");
        nombreArchivoImagen.setToolTipText(null);
        

    } catch (Exception ex) {
        javax.swing.JOptionPane.showMessageDialog(null, "Error creando item: " + ex.getMessage());
        ex.printStackTrace();
    }

    }//GEN-LAST:event_AceptarActionPerformed

    private void ImagenContenidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImagenContenidoActionPerformed
        Window ventana = SwingUtilities.getWindowAncestor(this);
        FileDialog selector = new FileDialog(
            ventana instanceof Frame ? (Frame) ventana : null,
            "Seleccionar imagen del producto",
            FileDialog.LOAD
        );
        selector.setFilenameFilter((directorio, nombre) -> {
            String archivo = nombre.toLowerCase();
            return archivo.endsWith(".png") || archivo.endsWith(".jpg")
                || archivo.endsWith(".jpeg") || archivo.endsWith(".gif")
                || archivo.endsWith(".webp");
        });
        selector.setVisible(true);

        if (selector.getFile() != null) {
            File archivo = new File(selector.getDirectory(), selector.getFile());
            rutaImagenSeleccionada = archivo.getAbsolutePath();
            mostrarVistaPrevia(archivo);
        }
    }//GEN-LAST:event_ImagenContenidoActionPerformed

    private void VenderItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenderItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VenderItem1ActionPerformed

    private void INICIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INICIOActionPerformed
        JPanel panelPrincipal = new PanelPrincipal();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(panelPrincipal);
    }//GEN-LAST:event_INICIOActionPerformed

    private void ATRASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ATRASActionPerformed
        JPanel panelDeItems = new PanelDeItems();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(panelDeItems);
    }//GEN-LAST:event_ATRASActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ATRAS;
    private javax.swing.JButton Aceptar;
    private javax.swing.JPanel Contenido;
    private javax.swing.JTextField DescripcionContenido;
    private javax.swing.JLabel DescrpcionLbl;
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton INICIO;
    private javax.swing.JLabel Imagen;
    private javax.swing.JButton ImagenContenido;
    private javax.swing.JLabel Logo1;
    private javax.swing.JPanel MenuLateral;
    private javax.swing.JPanel MenuSuperior;
    private javax.swing.JTextField NombreContenido;
    private javax.swing.JLabel NombreLbl;
    private javax.swing.JLabel TextoMenuSuperior;
    private javax.swing.JButton VenderItem1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
