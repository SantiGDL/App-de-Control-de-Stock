/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.PanelesInternos.Proveedores;

import GUI.PanelesInternos.Items.ComprarItem.ComprarItemJPanel;
import GUI.FramePrincipal;
import GUI.GUIController;
import GUI.PanelPrincipal;
import GUI.PanelesPRINCIPALES.PanelDeConfiguracion;
import GUI.PanelesPRINCIPALES.PanelDeProveedores;
import ImagenesHelpers.ImagenesHelper;
import Persistencia.Clases.Proveedor;
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
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Santi-kun
 */
public class CrearProveedorJPanel extends javax.swing.JPanel {
    private String rutaImagenSeleccionada = "";
    private final JLabel vistaPreviaImagen = new JLabel("Sin imagen", SwingConstants.CENTER);
    private final JLabel nombreArchivoImagen = new JLabel("Ningún archivo seleccionado");
    GUIController controller = new GUIController();

    private void configurarVista() {
        MenuLateral.setBackground(new Color(22, 73, 138));
        MenuLateral.setPreferredSize(new Dimension(200, 0));
        MenuLateral.setMinimumSize(new Dimension(200, 0));
        MenuLateral.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));

        MenuSuperior.removeAll();
        MenuSuperior.setLayout(new BorderLayout());
        MenuSuperior.setPreferredSize(new Dimension(0, 100));
        MenuSuperior.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        jLabel3.setText("CREAR PROVEEDOR");
        jLabel3.setFont(new Font("Segoe UI Black", Font.PLAIN, 36));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        MenuSuperior.add(jLabel3, BorderLayout.CENTER);
        jLabel4.setVisible(false);

        estilizarCampo(NombreContenido);
        estilizarCampo(ContactoContenido);
        estilizarCampo(UbicacionContenido);
        estilizarCampo(DescripcionContenido);
        estilizarBoton(ImagenContenido, "ELEGIR IMAGEN", new Color(0, 102, 255));
        estilizarBoton(ACEPTAR, "CREAR PROVEEDOR", new Color(30, 170, 105));

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
            new EmptyBorder(24, 30, 24, 30)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        agregarCampo(tarjeta, gbc, "Nombre del proveedor", NombreContenido);
        agregarCampo(tarjeta, gbc, "Contacto", ContactoContenido);
        agregarCampo(tarjeta, gbc, "Ubicación", UbicacionContenido);
        agregarCampo(tarjeta, gbc, "Descripción (opcional)", DescripcionContenido);

        gbc.insets = new Insets(0, 0, 6, 28);
        tarjeta.add(crearEtiqueta("Imagen (opcional)"), gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 5, 28);
        tarjeta.add(ImagenContenido, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 18, 28);
        tarjeta.add(nombreArchivoImagen, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 0, 28);
        tarjeta.add(ACEPTAR, gbc);

        gbc.gridx = 1; gbc.gridy = 0; gbc.gridheight = 12;
        gbc.weightx = 0; gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 0, 0);
        tarjeta.add(vistaPreviaImagen, gbc);

        Contenido.removeAll();
        Contenido.setLayout(new GridBagLayout());
        Contenido.setBackground(new Color(0, 87, 174));
        Contenido.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, Color.BLACK));
        Contenido.add(tarjeta);

        JPanel derecha = new JPanel(new BorderLayout(0, 0));
        derecha.add(MenuSuperior, BorderLayout.NORTH);
        derecha.add(Contenido, BorderLayout.CENTER);
        Fondo.removeAll();
        Fondo.setLayout(new BorderLayout(0, 0));
        Fondo.add(MenuLateral, BorderLayout.WEST);
        Fondo.add(derecha, BorderLayout.CENTER);
        Fondo.revalidate();
        Fondo.repaint();
    }

    private void agregarCampo(JPanel tarjeta, GridBagConstraints gbc, String texto, javax.swing.JTextField campo) {
        gbc.insets = new Insets(0, 0, 6, 28);
        tarjeta.add(crearEtiqueta(texto), gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 14, 28);
        tarjeta.add(campo, gbc);
        gbc.gridy++;
    }

    private JLabel crearEtiqueta(String texto) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        etiqueta.setForeground(new Color(35, 45, 58));
        return etiqueta;
    }

    private void estilizarCampo(javax.swing.JTextField campo) {
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campo.setPreferredSize(new Dimension(330, 36));
        campo.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(185, 196, 208), 1),
            new EmptyBorder(5, 9, 5, 9)
        ));
    }

    private void estilizarBoton(javax.swing.JButton boton, String texto, Color fondo) {
        boton.setText(texto);
        boton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        boton.setBackground(fondo);
        boton.setForeground(Color.WHITE);
        boton.setOpaque(true);
        boton.setContentAreaFilled(true);
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton.setPreferredSize(new Dimension(200, 38));
    }

    private void mostrarVistaPrevia(File archivo) {
        ImageIcon original = new ImageIcon(archivo.getAbsolutePath());
        if (original.getIconWidth() <= 0) return;
        int maximo = 204;
        double escala = Math.min((double) maximo / original.getIconWidth(), (double) maximo / original.getIconHeight());
        int ancho = Math.max(1, (int) Math.round(original.getIconWidth() * escala));
        int alto = Math.max(1, (int) Math.round(original.getIconHeight() * escala));
        Image imagen = original.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        vistaPreviaImagen.setText("");
        vistaPreviaImagen.setIcon(new ImageIcon(imagen));
        nombreArchivoImagen.setText(archivo.getName());
        nombreArchivoImagen.setToolTipText(archivo.getAbsolutePath());
    }
    /**
     * Creates new form CrearProveedor
     */
    public CrearProveedorJPanel() {
        initComponents();
        
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
        ImagenesHelper.iconoTintado("/Imagenes/ProveedoresBoton.png", Color.WHITE, 37, 37),
        //Color Base
        new Color(153, 255, 153),
        //Color del hover
        new Color(99, 166, 99),
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

        Fondo = new javax.swing.JPanel();
        MenuSuperior = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Contenido = new javax.swing.JPanel();
        NombreLbl = new javax.swing.JLabel();
        NombreContenido = new javax.swing.JTextField();
        ContactoLbl = new javax.swing.JLabel();
        ContactoContenido = new javax.swing.JTextField();
        UbicacionContenido = new javax.swing.JTextField();
        UbicacionLbl = new javax.swing.JLabel();
        DescripcionLbl = new javax.swing.JLabel();
        DescripcionContenido = new javax.swing.JTextField();
        ImagenLbl = new javax.swing.JLabel();
        ImagenContenido = new javax.swing.JButton();
        ACEPTAR = new javax.swing.JButton();
        MenuLateral = new javax.swing.JPanel();
        Logo1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        VenderItem1 = new javax.swing.JButton();
        INICIO = new javax.swing.JButton();
        ATRAS = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(0, 320));
        setRequestFocusEnabled(false);
        setLayout(new java.awt.BorderLayout());

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setPreferredSize(new java.awt.Dimension(800, 500));
        Fondo.setRequestFocusEnabled(false);

        MenuSuperior.setBackground(new java.awt.Color(0, 102, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Crear Proveedor");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ingrese los datos del nuevo proveedor");

        javax.swing.GroupLayout MenuSuperiorLayout = new javax.swing.GroupLayout(MenuSuperior);
        MenuSuperior.setLayout(MenuSuperiorLayout);
        MenuSuperiorLayout.setHorizontalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuSuperiorLayout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuSuperiorLayout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(77, 77, 77))
        );
        MenuSuperiorLayout.setVerticalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        Contenido.setBackground(new java.awt.Color(204, 204, 204));
        Contenido.setPreferredSize(new java.awt.Dimension(700, 320));
        Contenido.setVerifyInputWhenFocusTarget(false);

        NombreLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        NombreLbl.setForeground(new java.awt.Color(0, 0, 0));
        NombreLbl.setText("Nombre:");

        NombreContenido.addActionListener(this::NombreContenidoActionPerformed);

        ContactoLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        ContactoLbl.setForeground(new java.awt.Color(0, 0, 0));
        ContactoLbl.setText("Contacto:");

        ContactoContenido.addActionListener(this::ContactoContenidoActionPerformed);

        UbicacionContenido.addActionListener(this::UbicacionContenidoActionPerformed);

        UbicacionLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        UbicacionLbl.setForeground(new java.awt.Color(0, 0, 0));
        UbicacionLbl.setText("Ubicación");

        DescripcionLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        DescripcionLbl.setForeground(new java.awt.Color(0, 0, 0));
        DescripcionLbl.setText("Descripción:");

        DescripcionContenido.addActionListener(this::DescripcionContenidoActionPerformed);

        ImagenLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        ImagenLbl.setForeground(new java.awt.Color(0, 0, 0));
        ImagenLbl.setText("Imágen (opcional):");

        ImagenContenido.setText("Seleccionar");
        ImagenContenido.setBorder(null);
        ImagenContenido.setBorderPainted(false);
        ImagenContenido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ImagenContenido.addActionListener(this::ImagenContenidoActionPerformed);

        ACEPTAR.setBackground(new java.awt.Color(0, 102, 255));
        ACEPTAR.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        ACEPTAR.setForeground(new java.awt.Color(255, 255, 255));
        ACEPTAR.setText("ACEPTAR");
        ACEPTAR.setBorder(null);
        ACEPTAR.addActionListener(this::ACEPTARActionPerformed);

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContenidoLayout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(ImagenContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenidoLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(ACEPTAR, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ContenidoLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ImagenLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(ContenidoLayout.createSequentialGroup()
                            .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(UbicacionLbl)
                                .addComponent(DescripcionLbl)
                                .addComponent(ContactoLbl)
                                .addComponent(NombreLbl))
                            .addGap(18, 18, 18)
                            .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(UbicacionContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ContactoContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(NombreContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(DescripcionContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenidoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ImagenContenido)
                .addGap(18, 18, 18)
                .addComponent(ACEPTAR, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ContenidoLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NombreContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(NombreLbl))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ContactoContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ContactoLbl))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(UbicacionContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(UbicacionLbl))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DescripcionContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DescripcionLbl))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(ImagenLbl)
                    .addContainerGap(36, Short.MAX_VALUE)))
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

        ATRAS.setBackground(new java.awt.Color(153, 255, 153));
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
            .addComponent(INICIO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(ATRAS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuLateralLayout.setVerticalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addComponent(Logo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(INICIO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ATRAS)
                .addGap(174, 174, 174)
                .addComponent(VenderItem1)
                .addContainerGap(18, Short.MAX_VALUE))
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
                    .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(MenuSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(MenuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
        );

        add(Fondo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void NombreContenidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreContenidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreContenidoActionPerformed

    private void ContactoContenidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactoContenidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContactoContenidoActionPerformed

    private void UbicacionContenidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UbicacionContenidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UbicacionContenidoActionPerformed

    private void DescripcionContenidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescripcionContenidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescripcionContenidoActionPerformed

    private void ImagenContenidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImagenContenidoActionPerformed
        Window ventana = SwingUtilities.getWindowAncestor(this);
        FileDialog selector = new FileDialog(
            ventana instanceof Frame ? (Frame) ventana : null,
            "Seleccionar imagen del proveedor",
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

    private void ACEPTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ACEPTARActionPerformed
      String nombreProveedor = NombreContenido.getText().trim();
      String contacto = ContactoContenido.getText().trim();
      String ubicacion = UbicacionContenido.getText().trim();
      String descripcion = DescripcionContenido.getText().trim();
      String imagen = "";
      if (nombreProveedor.isEmpty() || contacto.isEmpty() || ubicacion.isEmpty()) {
          javax.swing.JOptionPane.showMessageDialog(this, "Completá nombre, contacto y ubicación.");
          return;
      }
      try {
        // Copia la imagen elegida a la carpeta raíz (si el usuario eligió una)
        imagen = controller.cargarImagen(rutaImagenSeleccionada);
        } catch (IOException io) {
        javax.swing.JOptionPane.showMessageDialog(this, "No se pudo copiar la imagen:\n" + io.getMessage());
        return;
        }
     Proveedor nuevoProveedor = new Proveedor(nombreProveedor, contacto, ubicacion, descripcion, imagen);
     try{
     ManejadorDePersistencia MDP = ManejadorDePersistencia.getInstancia();
     MDP.persistirProveedor(nuevoProveedor);
     javax.swing.JOptionPane.showMessageDialog(null, "Proveedor OK");
     //Limpio los campos de texto
     NombreContenido.setText("");
     ContactoContenido.setText("");
     UbicacionContenido.setText("");
     DescripcionContenido.setText("");
     rutaImagenSeleccionada = "";
     vistaPreviaImagen.setIcon(null);
     vistaPreviaImagen.setText("Sin imagen");
     nombreArchivoImagen.setText("Ningún archivo seleccionado");
     nombreArchivoImagen.setToolTipText(null);
     } catch (Exception ex) {
        javax.swing.JOptionPane.showMessageDialog(null, "Error creando Proveedor: " + ex.getMessage());
        ex.printStackTrace();
     }
    }//GEN-LAST:event_ACEPTARActionPerformed

    private void INICIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INICIOActionPerformed
        JPanel panelPrincipal = new PanelPrincipal();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(panelPrincipal);
    }//GEN-LAST:event_INICIOActionPerformed

    private void ATRASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ATRASActionPerformed
     JPanel panelDeProveedores = new PanelDeProveedores();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(panelDeProveedores);
    }//GEN-LAST:event_ATRASActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ACEPTAR;
    private javax.swing.JButton ATRAS;
    private javax.swing.JTextField ContactoContenido;
    private javax.swing.JLabel ContactoLbl;
    private javax.swing.JPanel Contenido;
    private javax.swing.JTextField DescripcionContenido;
    private javax.swing.JLabel DescripcionLbl;
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton INICIO;
    private javax.swing.JButton ImagenContenido;
    private javax.swing.JLabel ImagenLbl;
    private javax.swing.JLabel Logo1;
    private javax.swing.JPanel MenuLateral;
    private javax.swing.JPanel MenuSuperior;
    private javax.swing.JTextField NombreContenido;
    private javax.swing.JLabel NombreLbl;
    private javax.swing.JTextField UbicacionContenido;
    private javax.swing.JLabel UbicacionLbl;
    private javax.swing.JButton VenderItem1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
