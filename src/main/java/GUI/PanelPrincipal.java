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
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


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

        // Ahora sí: centrar título
        MenuSuperior.removeAll();
        MenuSuperior.setLayout(new BorderLayout());
        MenuSuperior.add(TextoMenuSuperior, BorderLayout.CENTER);
        TextoMenuSuperior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        
        // 1) Armo grilla centrada (3 columnas)
        ImagenesHelper.armarMenuEnGrilla(
        Contenido,
        new JButton[] {
            StockBotonGrande, ItemBotonGrande, ProveedoresBotonGrande,
            CatalogosBotonGrande, HistorialBotonGrande, ConfiguracionBotonGrande
        },
        3,   // columnas
        30,  // gap horizontal
        30,  // gap vertical
        25   // padding
        );

        // 2) Seteo tamaño consistente (opcional, pero queda muy pro)
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
    
        //CONFIGURAR BOTONES LATERALES
        ImagenesHelper.estilizarBotonMenuLateral(
        Stock,
        "STOCK",
        //Icono
        ImagenesHelper.iconoTintado("/Imagenes/StockBoton.png", Color.BLACK, 37, 37),
        //Color Base
        new Color(29, 63, 243),
        //Color del hover
        new Color(19, 41, 158),
        //Color del texto
        Color.WHITE
        );
        
        ImagenesHelper.estilizarBotonMenuLateral(
        ITEMS,
        "ITEMS",
        //Icono
        ImagenesHelper.iconoTintado("/Imagenes/ItemsBoton.png", Color.BLACK, 37, 37),
        //Color Base
        new Color(204, 102, 255),
        //Color del hover
        new Color(133, 66, 166),
        //Color del texto
        Color.WHITE
        );
        
        ImagenesHelper.estilizarBotonMenuLateral(
        PROVEEDORES,
        "PROVEEDORES",
        //Icono
        ImagenesHelper.iconoTintado("/Imagenes/ProveedoresBoton.png", Color.BLACK, 37, 37),
        //Color Base
        new Color(153, 255, 153),
        //Color del hover
        new Color(99, 166, 99),
        //Color del texto
        Color.WHITE
        );
        
        ImagenesHelper.estilizarBotonMenuLateral(
        HISTORIAL,
        "HISTORIAL",
        //Icono
        ImagenesHelper.iconoTintado("/Imagenes/HistorialBoton.png", Color.BLACK, 37, 37),
        //Color Base
        new Color (0, 204, 204),
        //Color del hover
        new Color(0, 140, 140),
        //Color del texto
        Color.WHITE
        );
        
        ImagenesHelper.estilizarBotonMenuLateral(
        CATALOGOS,
        "CATALOGOS",
        //Icono
        ImagenesHelper.iconoTintado("/Imagenes/ConfiguracionBoton.png", Color.BLACK, 37, 37),
        //Color Base
        new Color(255, 153, 153),
        //Color del hover
        new Color(166, 99, 99),
        //Color del texto
        Color.WHITE
        );
        
        ImagenesHelper.estilizarBotonMenuLateral(
        CONFIGURACION,
        "CONFIGURACION",
        //Icono
        ImagenesHelper.iconoTintado("/Imagenes/ItemsBoton.png", Color.BLACK, 37, 37),
        //Color Base
        new Color(153, 255, 255),
        //Color del hover
        new Color(99, 166, 166),
        //Color del texto
        Color.WHITE
        );
        
        
        
        ImagenesHelper.aplicarHoverOscuro(StockBotonGrande, 0.65);
        ImagenesHelper.aplicarHoverOscuro(ItemBotonGrande, 0.65);
        ImagenesHelper.aplicarHoverOscuro(ProveedoresBotonGrande, 0.65);
        ImagenesHelper.aplicarHoverOscuro(CatalogosBotonGrande, 0.65);
        ImagenesHelper.aplicarHoverOscuro(HistorialBotonGrande, 0.65);
        ImagenesHelper.aplicarHoverOscuro(ConfiguracionBotonGrande, 0.65);
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
        CONFIGURACION = new javax.swing.JButton();
        VenderItem1 = new javax.swing.JButton();
        ITEMS = new javax.swing.JButton();
        PROVEEDORES = new javax.swing.JButton();
        HISTORIAL = new javax.swing.JButton();
        CATALOGOS = new javax.swing.JButton();
        Stock = new javax.swing.JButton();
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
                .addComponent(HISTORIAL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CATALOGOS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CONFIGURACION)
                .addGap(94, 94, 94)
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
                .addContainerGap(152, Short.MAX_VALUE)
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

        HistorialBotonGrande.setBackground(new java.awt.Color(234, 252, 82));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(HistorialBotonGrande, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(ItemBotonGrande, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ProveedoresBotonGrande, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ConfiguracionBotonGrande, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
        );

        add(Fondo, java.awt.BorderLayout.CENTER);
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
    private javax.swing.JButton CATALOGOS;
    private javax.swing.JButton CONFIGURACION;
    private javax.swing.JButton CatalogosBotonGrande;
    private javax.swing.JButton ConfiguracionBotonGrande;
    private javax.swing.JPanel Contenido;
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton HISTORIAL;
    private javax.swing.JButton HistorialBotonGrande;
    private javax.swing.JButton ITEMS;
    private javax.swing.JButton ItemBotonGrande;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel MenuLateral;
    private javax.swing.JPanel MenuSuperior;
    private javax.swing.JButton PROVEEDORES;
    private javax.swing.JButton ProveedoresBotonGrande;
    private javax.swing.JButton Stock;
    private javax.swing.JButton StockBotonGrande;
    private javax.swing.JLabel TextoMenuSuperior;
    private javax.swing.JButton VenderItem1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
