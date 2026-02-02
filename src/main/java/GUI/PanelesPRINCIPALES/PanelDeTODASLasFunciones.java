/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.PanelesPRINCIPALES;

import GUI.FramePrincipal;
import GUI.FramePrincipal;
import GUI.GUIController;
import GUI.GUIController;
import GUI.PanelPrincipal;
import GUI.PanelesInternos.Catalogos.CatalogoGeneralJPanel;
import GUI.PanelesPRINCIPALES.PanelDeConfiguracion;
import GUI.PanelesPRINCIPALES.PanelDeItems;
import GUI.PanelesPRINCIPALES.PanelDeProveedores;
import GUI.PanelesInternos.Items.ComprarItem.ComprarItemJPanel;
import GUI.PanelesInternos.Items.CrearItemJPanel;
import GUI.PanelesInternos.Proveedores.CrearProveedorJPanel;
import GUI.PanelesInternos.LoginJPanel;
import GUI.PanelesInternos.Proveedores.ListaDeProveedoresJPanel;
import GUI.PanelesInternos.Stocks.VerStockJPanel;
import ImagenesHelpers.ImagenesHelper;
import ImagenesHelpers.PanelDeFondo;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Santi-kun
 */
public class PanelDeTODASLasFunciones extends javax.swing.JPanel {
    GUIController controller = new GUIController();
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
    public PanelDeTODASLasFunciones() {
        initComponents(); // UNA sola vez

        montarMenuLateralReutilizable();

        // Título centrado
        MenuSuperior.removeAll();
        MenuSuperior.setLayout(new BorderLayout());
        MenuSuperior.add(TextoMenuSuperior, BorderLayout.CENTER);
        TextoMenuSuperior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        // Scrollpane bien seteado
        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setOpaque(false);

        // Layout raíz
        Fondo.removeAll();
        Fondo.setLayout(new BorderLayout(0,0));

        JPanel derecha = new JPanel(new BorderLayout(0,0));
        derecha.setOpaque(false);
        derecha.add(MenuSuperior, BorderLayout.NORTH);
        derecha.add(jScrollPane1, BorderLayout.CENTER); // <-- el scrollpane, no Contenido

        Fondo.add(MenuLateral, BorderLayout.WEST);
        Fondo.add(derecha, BorderLayout.CENTER);

        // 1) Tamaño tarjetas (ANTES de armar grilla)
        int w = 220, h = 140;
        JButton[] botones = {
            CrearProveedor, listaProveedores, EliminarProveedor,
            CrearItem, ComprarItem, VenderItem, EliminarItem,
            HistorialGeneral, HistorialXProveedor,
            CatalogoGeneral, CatalogoXProveedor, verStock, ConfigurarAlertas
        };

        for (JButton b : botones) {
            ImagenesHelper.setTamanoTarjeta(b, w, h);
        }

        ImagenesHelper.configurarBotonTarjeta(CrearProveedor, "Crear Proveedor", "/Imagenes/ItemsBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(listaProveedores, "Lista Proveedores", "/Imagenes/ProveedoresBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(EliminarProveedor, "Eliminar Proveedor", "/Imagenes/EliminarProveedorBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(CrearItem, "Crear Item", "/Imagenes/CrearItemBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(ComprarItem, "Comprar Item", "/Imagenes/ComprarItemBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(VenderItem, "Vender Item", "/Imagenes/VenderItemBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(EliminarItem, "Eliminar Item", "/Imagenes/EliminarItemBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(HistorialGeneral, "Historial General", "/Imagenes/HistorialGeneralBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(HistorialXProveedor, "Historial por Proveedor", "/Imagenes/HistorialXProveedorBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(CatalogoGeneral, "Catalogo General", "/Imagenes/CatalogoGeneralBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(CatalogoXProveedor, "Catalogo X Proveedor", "/Imagenes/CatalogoXProveedorBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(verStock, "Ver Stock", "/Imagenes/VerStockBoton.png", 64, 64);
        ImagenesHelper.configurarBotonTarjeta(ConfigurarAlertas, "Configurar Alertas", "/Imagenes/ConfigurarAlertasBoton.png", 64, 64);

        
        //CONFIGURO EL HOVER DE LOS BOTONES CENTRALES
        ImagenesHelper.aplicarHoverOscuro(CrearProveedor, 0.65);
        ImagenesHelper.aplicarHoverOscuro(listaProveedores, 0.65);
        ImagenesHelper.aplicarHoverOscuro(EliminarProveedor, 0.65);
        ImagenesHelper.aplicarHoverOscuro(CrearItem, 0.65);
        ImagenesHelper.aplicarHoverOscuro(ComprarItem, 0.65);
        ImagenesHelper.aplicarHoverOscuro(VenderItem, 0.65);
        ImagenesHelper.aplicarHoverOscuro(EliminarItem, 0.65);
        ImagenesHelper.aplicarHoverOscuro(HistorialGeneral, 0.65);
        ImagenesHelper.aplicarHoverOscuro(HistorialXProveedor, 0.65);
        ImagenesHelper.aplicarHoverOscuro(CatalogoGeneral, 0.65);
        ImagenesHelper.aplicarHoverOscuro(CatalogoXProveedor, 0.65);
        ImagenesHelper.aplicarHoverOscuro(verStock, 0.65);
        ImagenesHelper.aplicarHoverOscuro(ConfigurarAlertas, 0.65);

        // 3) Armar grilla al final
        ImagenesHelper.armarMenuEnGrilla(Contenido, botones, 4, 30, 30, 25);

        // 4) Forzar que el viewport respete el tamaño preferido del Contenido
        Contenido.revalidate();
        jScrollPane1.revalidate();
        Fondo.revalidate();
        Fondo.repaint();


        // 3) Iconos escalados + texto centrado
        
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
        MenuLateral = new javax.swing.JPanel();
        VenderItem1 = new javax.swing.JButton();
        MenuSuperior = new javax.swing.JPanel();
        TextoMenuSuperior = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Contenido = new PanelDeFondo("/Imagenes/Fondo.png");
        menuItems = new javax.swing.JButton();
        menuProveedores = new javax.swing.JButton();
        listaProveedores = new javax.swing.JButton();
        CrearProveedor = new javax.swing.JButton();
        CrearItem = new javax.swing.JButton();
        ComprarItem = new javax.swing.JButton();
        VenderItem = new javax.swing.JButton();
        MenuStock = new javax.swing.JButton();
        HistorialGeneral = new javax.swing.JButton();
        HistorialXProveedor = new javax.swing.JButton();
        menuCatalogo = new javax.swing.JButton();
        CatalogoGeneral = new javax.swing.JButton();
        CatalogoXProveedor = new javax.swing.JButton();
        EliminarItem = new javax.swing.JButton();
        MenuHistorial = new javax.swing.JButton();
        MenuConfiguracion = new javax.swing.JButton();
        ConfigurarAlertas = new javax.swing.JButton();
        verStock = new javax.swing.JButton();
        ComprarItem1 = new javax.swing.JButton();
        VenderItem2 = new javax.swing.JButton();
        EliminarProveedor = new javax.swing.JButton();

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
                .addGap(396, 396, 396)
                .addComponent(VenderItem1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MenuSuperior.setBackground(new java.awt.Color(0, 102, 255));

        TextoMenuSuperior.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        TextoMenuSuperior.setForeground(new java.awt.Color(255, 255, 255));
        TextoMenuSuperior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextoMenuSuperior.setText("TODAS LAS FUNCIONES");

        javax.swing.GroupLayout MenuSuperiorLayout = new javax.swing.GroupLayout(MenuSuperior);
        MenuSuperior.setLayout(MenuSuperiorLayout);
        MenuSuperiorLayout.setHorizontalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuSuperiorLayout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(TextoMenuSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuSuperiorLayout.setVerticalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TextoMenuSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        Contenido.setBackground(new java.awt.Color(204, 204, 204));
        Contenido.setVerifyInputWhenFocusTarget(false);

        menuItems.setBackground(new java.awt.Color(204, 102, 255));
        menuItems.setForeground(new java.awt.Color(0, 0, 0));
        menuItems.setText("Menu Items");
        menuItems.setBorder(null);
        menuItems.setBorderPainted(false);
        menuItems.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuItems.addActionListener(this::menuItemsActionPerformed);

        menuProveedores.setBackground(new java.awt.Color(153, 255, 153));
        menuProveedores.setForeground(new java.awt.Color(0, 0, 0));
        menuProveedores.setText("Menu Proveedores");
        menuProveedores.setBorder(null);
        menuProveedores.setBorderPainted(false);
        menuProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuProveedores.addActionListener(this::menuProveedoresActionPerformed);

        listaProveedores.setBackground(new java.awt.Color(153, 255, 153));
        listaProveedores.setForeground(new java.awt.Color(0, 0, 0));
        listaProveedores.setText("Lista de Proveedores");
        listaProveedores.setBorder(null);
        listaProveedores.setBorderPainted(false);
        listaProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listaProveedores.addActionListener(this::listaProveedoresActionPerformed);

        CrearProveedor.setBackground(new java.awt.Color(153, 255, 153));
        CrearProveedor.setForeground(new java.awt.Color(0, 0, 0));
        CrearProveedor.setText("Crear Proveedor ");
        CrearProveedor.setBorder(null);
        CrearProveedor.setBorderPainted(false);
        CrearProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CrearProveedor.addActionListener(this::CrearProveedorActionPerformed);

        CrearItem.setBackground(new java.awt.Color(204, 102, 255));
        CrearItem.setForeground(new java.awt.Color(0, 0, 0));
        CrearItem.setText("Crear Item");
        CrearItem.setBorder(null);
        CrearItem.setBorderPainted(false);
        CrearItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CrearItem.addActionListener(this::CrearItemActionPerformed);

        ComprarItem.setBackground(new java.awt.Color(204, 102, 255));
        ComprarItem.setForeground(new java.awt.Color(0, 0, 0));
        ComprarItem.setText("Comprar Item");
        ComprarItem.setBorder(null);
        ComprarItem.setBorderPainted(false);
        ComprarItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ComprarItem.addActionListener(this::ComprarItemActionPerformed);

        VenderItem.setBackground(new java.awt.Color(204, 102, 255));
        VenderItem.setForeground(new java.awt.Color(0, 0, 0));
        VenderItem.setText("Vender Item");
        VenderItem.setBorder(null);
        VenderItem.setBorderPainted(false);
        VenderItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VenderItem.addActionListener(this::VenderItemActionPerformed);

        MenuStock.setBackground(new java.awt.Color(29, 63, 243));
        MenuStock.setForeground(new java.awt.Color(0, 0, 0));
        MenuStock.setText("Menu Stock");
        MenuStock.setBorder(null);
        MenuStock.setBorderPainted(false);
        MenuStock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuStock.addActionListener(this::MenuStockActionPerformed);

        HistorialGeneral.setBackground(new java.awt.Color(0, 204, 204));
        HistorialGeneral.setForeground(new java.awt.Color(0, 0, 0));
        HistorialGeneral.setText("Historial General");
        HistorialGeneral.setBorder(null);
        HistorialGeneral.setBorderPainted(false);
        HistorialGeneral.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HistorialGeneral.addActionListener(this::HistorialGeneralActionPerformed);

        HistorialXProveedor.setBackground(new java.awt.Color(0, 204, 204));
        HistorialXProveedor.setForeground(new java.awt.Color(0, 0, 0));
        HistorialXProveedor.setText("Historial por Proveedor");
        HistorialXProveedor.setBorder(null);
        HistorialXProveedor.setBorderPainted(false);
        HistorialXProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HistorialXProveedor.addActionListener(this::HistorialXProveedorActionPerformed);

        menuCatalogo.setBackground(new java.awt.Color(255, 153, 153));
        menuCatalogo.setForeground(new java.awt.Color(0, 0, 0));
        menuCatalogo.setText("Menu Catálogo");
        menuCatalogo.setBorder(null);
        menuCatalogo.setBorderPainted(false);
        menuCatalogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuCatalogo.addActionListener(this::menuCatalogoActionPerformed);

        CatalogoGeneral.setBackground(new java.awt.Color(255, 153, 153));
        CatalogoGeneral.setForeground(new java.awt.Color(0, 0, 0));
        CatalogoGeneral.setText("Catálogo General");
        CatalogoGeneral.setBorder(null);
        CatalogoGeneral.setBorderPainted(false);
        CatalogoGeneral.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CatalogoGeneral.addActionListener(this::CatalogoGeneralActionPerformed);

        CatalogoXProveedor.setBackground(new java.awt.Color(255, 153, 153));
        CatalogoXProveedor.setForeground(new java.awt.Color(0, 0, 0));
        CatalogoXProveedor.setText("Catálogo por Proveedor");
        CatalogoXProveedor.setBorder(null);
        CatalogoXProveedor.setBorderPainted(false);
        CatalogoXProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CatalogoXProveedor.addActionListener(this::CatalogoXProveedorActionPerformed);

        EliminarItem.setBackground(new java.awt.Color(204, 102, 255));
        EliminarItem.setForeground(new java.awt.Color(0, 0, 0));
        EliminarItem.setText("Eliminar Item");
        EliminarItem.setBorder(null);
        EliminarItem.setBorderPainted(false);
        EliminarItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EliminarItem.addActionListener(this::EliminarItemActionPerformed);

        MenuHistorial.setBackground(new java.awt.Color(0, 204, 204));
        MenuHistorial.setForeground(new java.awt.Color(0, 0, 0));
        MenuHistorial.setText("Menu Hisotorial");
        MenuHistorial.setBorder(null);
        MenuHistorial.setBorderPainted(false);
        MenuHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuHistorial.addActionListener(this::MenuHistorialActionPerformed);

        MenuConfiguracion.setBackground(new java.awt.Color(153, 255, 255));
        MenuConfiguracion.setForeground(new java.awt.Color(0, 0, 0));
        MenuConfiguracion.setText("Menu Configuración");
        MenuConfiguracion.setBorder(null);
        MenuConfiguracion.setBorderPainted(false);
        MenuConfiguracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuConfiguracion.addActionListener(this::MenuConfiguracionActionPerformed);

        ConfigurarAlertas.setBackground(new java.awt.Color(153, 255, 255));
        ConfigurarAlertas.setForeground(new java.awt.Color(0, 0, 0));
        ConfigurarAlertas.setText("Configurar Alertas");
        ConfigurarAlertas.setBorder(null);
        ConfigurarAlertas.setBorderPainted(false);
        ConfigurarAlertas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ConfigurarAlertas.addActionListener(this::ConfigurarAlertasActionPerformed);

        verStock.setBackground(new java.awt.Color(29, 63, 243));
        verStock.setForeground(new java.awt.Color(0, 0, 0));
        verStock.setText("Ver Stock");
        verStock.setBorder(null);
        verStock.setBorderPainted(false);
        verStock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        verStock.addActionListener(this::verStockActionPerformed);

        ComprarItem1.setBackground(new java.awt.Color(29, 63, 243));
        ComprarItem1.setForeground(new java.awt.Color(0, 0, 0));
        ComprarItem1.setText("Comprar Item");
        ComprarItem1.setBorder(null);
        ComprarItem1.setBorderPainted(false);
        ComprarItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ComprarItem1.addActionListener(this::ComprarItem1ActionPerformed);

        VenderItem2.setBackground(new java.awt.Color(29, 63, 243));
        VenderItem2.setForeground(new java.awt.Color(0, 0, 0));
        VenderItem2.setText("Vender Item");
        VenderItem2.setBorder(null);
        VenderItem2.setBorderPainted(false);
        VenderItem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VenderItem2.addActionListener(this::VenderItem2ActionPerformed);

        EliminarProveedor.setBackground(new java.awt.Color(153, 255, 153));
        EliminarProveedor.setForeground(new java.awt.Color(0, 0, 0));
        EliminarProveedor.setText("Eliminar Proveedor");
        EliminarProveedor.setBorder(null);
        EliminarProveedor.setBorderPainted(false);
        EliminarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EliminarProveedor.addActionListener(this::EliminarProveedorActionPerformed);

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                    .addComponent(listaProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                    .addComponent(CrearProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(VenderItem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComprarItem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HistorialXProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HistorialGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MenuStock, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                    .addComponent(MenuHistorial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(verStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EliminarProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CrearItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(VenderItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComprarItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EliminarItem, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addComponent(menuItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ConfigurarAlertas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuCatalogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CatalogoGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CatalogoXProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MenuConfiguracion, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
                .addContainerGap())
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContenidoLayout.createSequentialGroup()
                        .addComponent(menuProveedores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CrearProveedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listaProveedores))
                    .addGroup(ContenidoLayout.createSequentialGroup()
                        .addComponent(menuItems)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CrearItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComprarItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(VenderItem)
                            .addComponent(EliminarProveedor))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ContenidoLayout.createSequentialGroup()
                        .addComponent(EliminarItem)
                        .addGap(27, 27, 27)
                        .addComponent(menuCatalogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CatalogoGeneral)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CatalogoXProveedor)
                        .addGap(23, 23, 23)
                        .addComponent(MenuConfiguracion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ConfigurarAlertas))
                    .addGroup(ContenidoLayout.createSequentialGroup()
                        .addComponent(MenuHistorial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HistorialGeneral)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HistorialXProveedor)
                        .addGap(23, 23, 23)
                        .addComponent(MenuStock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(verStock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComprarItem1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VenderItem2)))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(Contenido);

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(MenuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(MenuSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        add(Fondo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void CrearItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearItemActionPerformed
        JPanel crearItemPanel = new CrearItemJPanel();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(crearItemPanel);
    }//GEN-LAST:event_CrearItemActionPerformed

    private void HistorialGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistorialGeneralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HistorialGeneralActionPerformed

    private void ComprarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprarItemActionPerformed
     JPanel  comprarItem = new ComprarItemJPanel();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(comprarItem);
    }//GEN-LAST:event_ComprarItemActionPerformed

    private void VenderItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenderItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VenderItemActionPerformed

    private void VenderItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenderItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VenderItem1ActionPerformed

    private void CatalogoGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatalogoGeneralActionPerformed
    JPanel catalogoGeneral = new CatalogoGeneralJPanel();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(catalogoGeneral);
    }//GEN-LAST:event_CatalogoGeneralActionPerformed

    private void CatalogoXProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatalogoXProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CatalogoXProveedorActionPerformed

    private void listaProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaProveedoresActionPerformed
   JPanel  listaProveedores = new ListaDeProveedoresJPanel();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(listaProveedores);
    }//GEN-LAST:event_listaProveedoresActionPerformed

    private void CrearProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearProveedorActionPerformed
    JPanel crearProveedor = new CrearProveedorJPanel();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(crearProveedor);
    }//GEN-LAST:event_CrearProveedorActionPerformed

    private void menuItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemsActionPerformed
     JPanel  menuItems = new PanelDeItems();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(menuItems);
    }//GEN-LAST:event_menuItemsActionPerformed

    private void menuProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProveedoresActionPerformed
       JPanel  menuProveedores = new PanelDeProveedores();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(menuProveedores);
    }//GEN-LAST:event_menuProveedoresActionPerformed

    private void MenuStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuStockActionPerformed
   JPanel  stockPanel = new VerStockJPanel();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(stockPanel);
    }//GEN-LAST:event_MenuStockActionPerformed

    private void HistorialXProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistorialXProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HistorialXProveedorActionPerformed

    private void menuCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCatalogoActionPerformed
      JPanel  menuCatalogos = new PanelDeCatalogos();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(menuCatalogos);
    }//GEN-LAST:event_menuCatalogoActionPerformed

    private void EliminarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminarItemActionPerformed

    private void MenuHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuHistorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuHistorialActionPerformed

    private void MenuConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuConfiguracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuConfiguracionActionPerformed

    private void ConfigurarAlertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfigurarAlertasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfigurarAlertasActionPerformed

    private void verStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verStockActionPerformed

    private void ComprarItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprarItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComprarItem1ActionPerformed

    private void VenderItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenderItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VenderItem2ActionPerformed

    private void EliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminarProveedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CatalogoGeneral;
    private javax.swing.JButton CatalogoXProveedor;
    private javax.swing.JButton ComprarItem;
    private javax.swing.JButton ComprarItem1;
    private javax.swing.JButton ConfigurarAlertas;
    private javax.swing.JPanel Contenido;
    private javax.swing.JButton CrearItem;
    private javax.swing.JButton CrearProveedor;
    private javax.swing.JButton EliminarItem;
    private javax.swing.JButton EliminarProveedor;
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton HistorialGeneral;
    private javax.swing.JButton HistorialXProveedor;
    private javax.swing.JButton MenuConfiguracion;
    private javax.swing.JButton MenuHistorial;
    private javax.swing.JPanel MenuLateral;
    private javax.swing.JButton MenuStock;
    private javax.swing.JPanel MenuSuperior;
    private javax.swing.JLabel TextoMenuSuperior;
    private javax.swing.JButton VenderItem;
    private javax.swing.JButton VenderItem1;
    private javax.swing.JButton VenderItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listaProveedores;
    private javax.swing.JButton menuCatalogo;
    private javax.swing.JButton menuItems;
    private javax.swing.JButton menuProveedores;
    private javax.swing.JButton verStock;
    // End of variables declaration//GEN-END:variables
}
