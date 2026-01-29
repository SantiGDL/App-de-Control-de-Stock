/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.PanelesInternos.Items.ComprarItem;

import GUI.FramePrincipal;
import GUI.GUIController;
import GUI.PanelPrincipal;
import GUI.PanelesInternos.Items.CrearItemJPanel;
import GUI.PanelesInternos.Proveedores.CrearProveedorJPanel;
import GUI.PanelesInternos.LoginJPanel;
import GUI.PanelesPRINCIPALES.PanelDeConfiguracion;
import GUI.PanelesPRINCIPALES.PanelDeItems;
import Persistencia.Clases.CompraItemAProveedorDefault;
import Persistencia.Clases.CompraItemAProveedorX;
import Persistencia.Clases.HistorialGeneral;
import Persistencia.Clases.Item;
import Persistencia.Clases.ItemDeProveedorX;
import Persistencia.Clases.ItemDeSTOCK;
import Persistencia.Clases.Proveedor;
import Persistencia.DTOs.DTItem;
import Persistencia.DTOs.DTProveedor;
import Persistencia.ManejadorDePersistencia;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Santi-kun
 */
public class RellenarDatosCompraDefaultJPanel extends javax.swing.JPanel {
    //Atributos
    private GUIController controller = new GUIController();
    private Long itemId;
    private Long proveedorId;
    private Float precioUnidad;
    private Integer cantUni;
    private Float precioTotal;
    private DTItem dtItem;
    private DTProveedor dtProveedor;
    private Item itemComprado;
    private Proveedor proveedorSeleccionado;
    
    public RellenarDatosCompraDefaultJPanel(Long itemId, Long ProveedorId) {
        this.itemId = itemId;
        this.proveedorId = ProveedorId;
        initComponents();
          //obtengo los datos del item
        dtItem = controller.recuperarDTItemDeId(itemId);
            //Obtengo los datos del proveedor
        dtProveedor = controller.recuperarDTProveedorDeId(proveedorId);
        
        ManejadorDePersistencia MDP = ManejadorDePersistencia.getInstancia();
        itemComprado = MDP.getItemAPartirDeId(itemId);
        proveedorSeleccionado =  MDP.getProveedorAPartirDeId(ProveedorId);
        cargarDatos();
        configurarAutoTotal();
    }
    
    

    //Cuando creo la clase inicializo los atributos con los id que le pase del item y proveedor de las 2 pantallas anteriores
    
    //SI eligio el default entonces no genero un ItemDeProveedorX, entonces lo que tengo que hacer es:
    //aumentar el STOCK
    //Y generar una fila en el historial general, no en el de proveedor
    //LOS GASTOS POR AHORA LOS IGNORAMOS
    public void cargarDatos(){
        //Datos Item
        NombreItem.setText(dtItem.getNombre()); 
        NombreItem.setEditable(false);
        DescripcionItem.setText(dtItem.getDescripcion());
        DescripcionItem.setEditable(false);
        controller.mostrarImagenEnPanel(ImagenItem, RellenoImagenItem, dtItem.getImagen());
        //Datos Proveedor
        NombreProveedor.setText(dtProveedor.getNombre());
        NombreProveedor.setEditable(false);
        ContactoProveedor.setText(dtProveedor.getContacto());
        ContactoProveedor.setEditable(false);
        UbicacionProveedor.setText(dtProveedor.getUbicacion());
        UbicacionProveedor.setEditable(false);
        DescripcionProveedor.setText(dtProveedor.getDescripcion());
        DescripcionProveedor.setEditable(false);
        controller.mostrarImagenEnPanel(ImagenProveedor, RellenoImagenProveedor, dtProveedor.getImagen());
        //hago que el precio total no sea editable sino calculado
        PrecioTotal.setEditable(false);
    }
    
    //CALCULAR PRECIO TOTAL EN VIVO
    
    private void configurarAutoTotal() {
    DocumentListener dl = new javax.swing.event.DocumentListener() {
        @Override public void insertUpdate(javax.swing.event.DocumentEvent e) { recalcularTotal(); }
        @Override public void removeUpdate(javax.swing.event.DocumentEvent e) { recalcularTotal(); }
        @Override public void changedUpdate(javax.swing.event.DocumentEvent e) { recalcularTotal(); }
    };

    PrecioUnidad.getDocument().addDocumentListener(dl);
    cantUnidades.getDocument().addDocumentListener(dl);

    // por si ya viene con algo cargado:
    recalcularTotal();
}

private void recalcularTotal() {
    String PrecioUnidadStr = PrecioUnidad.getText().trim().replace(",", ".");
    String CantidadUnidadesStr = cantUnidades.getText().trim();

    if (PrecioUnidadStr.isEmpty() || CantidadUnidadesStr.isEmpty()) {
        PrecioTotal.setText("");
        return;
    }

    try {
        float precioUnidad = Float.parseFloat(PrecioUnidadStr);
        int unidades = Integer.parseInt(CantidadUnidadesStr);

        float total = precioUnidad * unidades;
        PrecioTotal.setText(String.format(java.util.Locale.US, "%.2f", total)); 
        //Locale.US fuerza a usar punto como decimal (no coma), para que salga tipo 37.50.
        //"%.2f" significa: “float con 2 decimales”.
    } catch (NumberFormatException ex) {
        // si está escribiendo algo incompleto, no rompas: solo vaciá
        PrecioTotal.setText("");
    }
}
    
    public void crearCompra(){
        ManejadorDePersistencia MDP = ManejadorDePersistencia.getInstancia();
       //Se cual sea el tipo de proveedor esto es igual para todos
       
//------->OBTENGO LA CANTIDAD DE UNIDADES <--------
        String cantStr = cantUnidades.getText().trim();
        //parseo de string a  integer las unidades
        this.cantUni = Integer.valueOf(cantStr);
        
        
//------->CREO EL ITEM DE STOCK <--------, luego me fijo si existe previamente o no, y decido si aumento o le agrego uno nuevo
        ItemDeSTOCK nuevoItemDeStock = new ItemDeSTOCK(dtItem, cantUni);

        
        
//-------> AUMENTO EL STOCK <----------- PERSITO EL ITEM DE STOCK  (si no existe ya, sino solo aumento)----->
        try {
            MDP.AumentarStock(nuevoItemDeStock);
            JOptionPane.showMessageDialog(null, "Item de Stock creado OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error creando item: " + ex.getMessage());
            ex.printStackTrace();
        }
//------->OBTENGO EL PRECIO POR UNIDAD <----------- 
       String precioUnidadstr = PrecioUnidad.getText().trim();
           try {
            this.precioUnidad = Float.valueOf(precioUnidadstr);
        } catch (NumberFormatException e) {JOptionPane.showMessageDialog(this, "Ingresá un precio por unidad válido.");return;}
        
//------->CALCULO EL PRECIO TOTAL <----------- 
        this.precioTotal =  precioUnidad * cantUni;
        //Ya tengo el precio total, cant unis, y proveedor id, puedo hacer el historial general
        
        
        
//------->GENERO LA COMPRA PARA PROVEEDOR DEFAULT  <-----------
            CompraItemAProveedorDefault compraDefault = new CompraItemAProveedorDefault(
                    dtItem.getNombre(), 
                    itemComprado,  
                    cantUni, 
                    precioUnidad, 
                    precioTotal, 
                    LocalDate.now());
            
//------->persito la compra de proveedor Default   <-----------             
            MDP.persistirCompra(compraDefault, proveedorId);
            //Luego de generada la agrego al historial general y al historial x proveedor del default 

    
    
    
}      

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        MenuSuperior = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        MenuLateral = new javax.swing.JPanel();
        Logo1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        VenderItem1 = new javax.swing.JButton();
        menuPrincipal = new javax.swing.JButton();
        Atras = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Contenido = new javax.swing.JPanel();
        ContenedorDatosItem = new javax.swing.JPanel();
        NombreItemLbl = new javax.swing.JLabel();
        NombreItem = new javax.swing.JTextField();
        DescripcionItemLbl = new javax.swing.JLabel();
        DescripcionItem = new javax.swing.JTextField();
        ImagenItemLbl = new javax.swing.JLabel();
        ImagenItem = new javax.swing.JPanel();
        RellenoImagenItem = new javax.swing.JLabel();
        TituloDatosItem = new javax.swing.JLabel();
        ContenidoDatosCompra = new javax.swing.JPanel();
        TituloDatosCompra = new javax.swing.JLabel();
        PrecioUniLbl = new javax.swing.JLabel();
        CantUniLbl = new javax.swing.JLabel();
        PrecioTotLbl = new javax.swing.JLabel();
        PrecioUnidad = new javax.swing.JTextField();
        cantUnidades = new javax.swing.JTextField();
        PrecioTotal = new javax.swing.JTextField();
        Comprar = new javax.swing.JButton();
        ContenidoDatosProveedor = new javax.swing.JPanel();
        ImagenProveedorLbl = new javax.swing.JLabel();
        DescripcionProvLbl = new javax.swing.JLabel();
        ContactoProvLbl = new javax.swing.JLabel();
        NombreProvLbl = new javax.swing.JLabel();
        NombreProveedor = new javax.swing.JTextField();
        ContactoProveedor = new javax.swing.JTextField();
        DescripcionProveedor = new javax.swing.JTextField();
        DatosProveedorTitulo = new javax.swing.JLabel();
        ImagenProveedor = new javax.swing.JPanel();
        RellenoImagenProveedor = new javax.swing.JLabel();
        UbicacionProvLbl = new javax.swing.JLabel();
        UbicacionProveedor = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setPreferredSize(new java.awt.Dimension(800, 500));
        Fondo.setRequestFocusEnabled(false);

        MenuSuperior.setBackground(new java.awt.Color(0, 102, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Seleccion de Proveedor");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("<html> <div style:'text-alignment:center'>seleccione uno de los proveedores disponibles <br> o cree uno nuevo</html>");

        javax.swing.GroupLayout MenuSuperiorLayout = new javax.swing.GroupLayout(MenuSuperior);
        MenuSuperior.setLayout(MenuSuperiorLayout);
        MenuSuperiorLayout.setHorizontalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuSuperiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuSuperiorLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(110, 110, 110))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(160, 160, 160))
        );
        MenuSuperiorLayout.setVerticalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuSuperiorLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
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

        menuPrincipal.setBackground(new java.awt.Color(204, 255, 255));
        menuPrincipal.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        menuPrincipal.setForeground(new java.awt.Color(0, 0, 0));
        menuPrincipal.setText("MENÚ PRINCIPAL");
        menuPrincipal.setBorder(null);
        menuPrincipal.setBorderPainted(false);
        menuPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuPrincipal.addActionListener(this::menuPrincipalActionPerformed);

        Atras.setBackground(new java.awt.Color(204, 102, 255));
        Atras.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        Atras.setForeground(new java.awt.Color(0, 0, 0));
        Atras.setText("ATRÁS");
        Atras.setBorder(null);
        Atras.setBorderPainted(false);
        Atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Atras.addActionListener(this::AtrasActionPerformed);

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
            .addComponent(menuPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Atras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuLateralLayout.setVerticalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addComponent(Logo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menuPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Atras)
                .addGap(168, 168, 168)
                .addComponent(VenderItem1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Contenido.setBackground(new java.awt.Color(204, 204, 204));
        Contenido.setVerifyInputWhenFocusTarget(false);

        ContenedorDatosItem.setBackground(new java.awt.Color(189, 249, 249));

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

        javax.swing.GroupLayout ContenedorDatosItemLayout = new javax.swing.GroupLayout(ContenedorDatosItem);
        ContenedorDatosItem.setLayout(ContenedorDatosItemLayout);
        ContenedorDatosItemLayout.setHorizontalGroup(
            ContenedorDatosItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorDatosItemLayout.createSequentialGroup()
                .addGroup(ContenedorDatosItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContenedorDatosItemLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(TituloDatosItem, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenedorDatosItemLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ContenedorDatosItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ContenedorDatosItemLayout.createSequentialGroup()
                                .addComponent(NombreItemLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenedorDatosItemLayout.createSequentialGroup()
                                .addComponent(DescripcionItemLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(ContenedorDatosItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ContenedorDatosItemLayout.createSequentialGroup()
                                .addComponent(DescripcionItem, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(NombreItem))))
                .addContainerGap())
            .addGroup(ContenedorDatosItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImagenItemLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ImagenItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ContenedorDatosItemLayout.setVerticalGroup(
            ContenedorDatosItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorDatosItemLayout.createSequentialGroup()
                .addContainerGap()
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
                    .addComponent(ImagenItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ContenidoDatosCompra.setBackground(new java.awt.Color(189, 249, 249));

        TituloDatosCompra.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        TituloDatosCompra.setForeground(new java.awt.Color(0, 0, 0));
        TituloDatosCompra.setText("Datos Compra:");

        PrecioUniLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        PrecioUniLbl.setForeground(new java.awt.Color(0, 0, 0));
        PrecioUniLbl.setText("Precio por unidad:");

        CantUniLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        CantUniLbl.setForeground(new java.awt.Color(0, 0, 0));
        CantUniLbl.setText("Cantidad de unidades:");

        PrecioTotLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        PrecioTotLbl.setForeground(new java.awt.Color(0, 0, 0));
        PrecioTotLbl.setText("Precio Total:");

        PrecioUnidad.addActionListener(this::PrecioUnidadActionPerformed);

        cantUnidades.addActionListener(this::cantUnidadesActionPerformed);

        PrecioTotal.addActionListener(this::PrecioTotalActionPerformed);

        Comprar.setBackground(new java.awt.Color(51, 204, 255));
        Comprar.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        Comprar.setForeground(new java.awt.Color(255, 255, 255));
        Comprar.setText("COMPRAR");
        Comprar.setBorder(null);
        Comprar.addActionListener(this::ComprarActionPerformed);

        javax.swing.GroupLayout ContenidoDatosCompraLayout = new javax.swing.GroupLayout(ContenidoDatosCompra);
        ContenidoDatosCompra.setLayout(ContenidoDatosCompraLayout);
        ContenidoDatosCompraLayout.setHorizontalGroup(
            ContenidoDatosCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoDatosCompraLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(ContenidoDatosCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CantUniLbl)
                    .addComponent(PrecioTotLbl)
                    .addComponent(PrecioUniLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ContenidoDatosCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PrecioUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ContenidoDatosCompraLayout.createSequentialGroup()
                        .addComponent(PrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(Comprar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(142, 202, Short.MAX_VALUE))
            .addGroup(ContenidoDatosCompraLayout.createSequentialGroup()
                .addGap(329, 329, 329)
                .addComponent(TituloDatosCompra)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ContenidoDatosCompraLayout.setVerticalGroup(
            ContenidoDatosCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoDatosCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloDatosCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ContenidoDatosCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrecioUniLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrecioUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ContenidoDatosCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CantUniLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ContenidoDatosCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrecioTotLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Comprar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        ContenidoDatosProveedor.setBackground(new java.awt.Color(189, 249, 249));

        ImagenProveedorLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        ImagenProveedorLbl.setForeground(new java.awt.Color(0, 0, 0));
        ImagenProveedorLbl.setText("Imágen");

        DescripcionProvLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        DescripcionProvLbl.setForeground(new java.awt.Color(0, 0, 0));
        DescripcionProvLbl.setText("Descripción");

        ContactoProvLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        ContactoProvLbl.setForeground(new java.awt.Color(0, 0, 0));
        ContactoProvLbl.setText("Contacto");

        NombreProvLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        NombreProvLbl.setForeground(new java.awt.Color(0, 0, 0));
        NombreProvLbl.setText("Nombre");

        NombreProveedor.addActionListener(this::NombreProveedorActionPerformed);

        ContactoProveedor.addActionListener(this::ContactoProveedorActionPerformed);

        DescripcionProveedor.addActionListener(this::DescripcionProveedorActionPerformed);

        DatosProveedorTitulo.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        DatosProveedorTitulo.setForeground(new java.awt.Color(0, 0, 0));
        DatosProveedorTitulo.setText("Datos Proveedor:");

        javax.swing.GroupLayout ImagenProveedorLayout = new javax.swing.GroupLayout(ImagenProveedor);
        ImagenProveedor.setLayout(ImagenProveedorLayout);
        ImagenProveedorLayout.setHorizontalGroup(
            ImagenProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RellenoImagenProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );
        ImagenProveedorLayout.setVerticalGroup(
            ImagenProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImagenProveedorLayout.createSequentialGroup()
                .addComponent(RellenoImagenProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        UbicacionProvLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        UbicacionProvLbl.setForeground(new java.awt.Color(0, 0, 0));
        UbicacionProvLbl.setText("Ubicación");

        UbicacionProveedor.addActionListener(this::UbicacionProveedorActionPerformed);

        javax.swing.GroupLayout ContenidoDatosProveedorLayout = new javax.swing.GroupLayout(ContenidoDatosProveedor);
        ContenidoDatosProveedor.setLayout(ContenidoDatosProveedorLayout);
        ContenidoDatosProveedorLayout.setHorizontalGroup(
            ContenidoDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoDatosProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContenidoDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContenidoDatosProveedorLayout.createSequentialGroup()
                        .addGap(0, 98, Short.MAX_VALUE)
                        .addComponent(DatosProveedorTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))
                    .addGroup(ContenidoDatosProveedorLayout.createSequentialGroup()
                        .addGroup(ContenidoDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ContenidoDatosProveedorLayout.createSequentialGroup()
                                .addGroup(ContenidoDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ImagenProveedorLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DescripcionProvLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(ContenidoDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DescripcionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ImagenProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(ContenidoDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(ContenidoDatosProveedorLayout.createSequentialGroup()
                                    .addComponent(NombreProvLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(NombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(ContenidoDatosProveedorLayout.createSequentialGroup()
                                    .addComponent(ContactoProvLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(ContactoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(ContenidoDatosProveedorLayout.createSequentialGroup()
                                    .addComponent(UbicacionProvLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(UbicacionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        ContenidoDatosProveedorLayout.setVerticalGroup(
            ContenidoDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoDatosProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DatosProveedorTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ContenidoDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreProvLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ContenidoDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ContactoProvLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ContactoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ContenidoDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UbicacionProvLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UbicacionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ContenidoDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DescripcionProvLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DescripcionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(ContenidoDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContenidoDatosProveedorLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(ImagenProveedorLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenidoDatosProveedorLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ImagenProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addComponent(ContenedorDatosItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ContenidoDatosProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(ContenidoDatosCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ContenedorDatosItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ContenidoDatosProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ContenidoDatosCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(Contenido);

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(MenuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(MenuSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE))
            .addComponent(MenuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
        );

        add(Fondo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void VenderItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenderItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VenderItem1ActionPerformed

    private void NombreProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreProveedorActionPerformed

    private void PrecioUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecioUnidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecioUnidadActionPerformed

    private void DescripcionItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescripcionItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescripcionItemActionPerformed

    private void NombreItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreItemActionPerformed

    private void PrecioTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecioTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecioTotalActionPerformed

    private void cantUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantUnidadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantUnidadesActionPerformed

    private void ComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprarActionPerformed
     crearCompra();
     JOptionPane.showMessageDialog(null, "Compra Realizada Exitosamente");
    }//GEN-LAST:event_ComprarActionPerformed

    private void ContactoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactoProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContactoProveedorActionPerformed

    private void DescripcionProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescripcionProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescripcionProveedorActionPerformed

    private void UbicacionProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UbicacionProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UbicacionProveedorActionPerformed

    private void menuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPrincipalActionPerformed
        JPanel panelPrincipal = new PanelPrincipal();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(panelPrincipal);
    }//GEN-LAST:event_menuPrincipalActionPerformed

    private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasActionPerformed
        JPanel panelDeItems = new PanelDeItems();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(panelDeItems);
    }//GEN-LAST:event_AtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atras;
    private javax.swing.JLabel CantUniLbl;
    private javax.swing.JButton Comprar;
    private javax.swing.JLabel ContactoProvLbl;
    private javax.swing.JTextField ContactoProveedor;
    private javax.swing.JPanel ContenedorDatosItem;
    private javax.swing.JPanel Contenido;
    private javax.swing.JPanel ContenidoDatosCompra;
    private javax.swing.JPanel ContenidoDatosProveedor;
    private javax.swing.JLabel DatosProveedorTitulo;
    private javax.swing.JTextField DescripcionItem;
    private javax.swing.JLabel DescripcionItemLbl;
    private javax.swing.JLabel DescripcionProvLbl;
    private javax.swing.JTextField DescripcionProveedor;
    private javax.swing.JPanel Fondo;
    private javax.swing.JPanel ImagenItem;
    private javax.swing.JLabel ImagenItemLbl;
    private javax.swing.JPanel ImagenProveedor;
    private javax.swing.JLabel ImagenProveedorLbl;
    private javax.swing.JLabel Logo1;
    private javax.swing.JPanel MenuLateral;
    private javax.swing.JPanel MenuSuperior;
    private javax.swing.JTextField NombreItem;
    private javax.swing.JLabel NombreItemLbl;
    private javax.swing.JLabel NombreProvLbl;
    private javax.swing.JTextField NombreProveedor;
    private javax.swing.JLabel PrecioTotLbl;
    private javax.swing.JTextField PrecioTotal;
    private javax.swing.JLabel PrecioUniLbl;
    private javax.swing.JTextField PrecioUnidad;
    private javax.swing.JLabel RellenoImagenItem;
    private javax.swing.JLabel RellenoImagenProveedor;
    private javax.swing.JLabel TituloDatosCompra;
    private javax.swing.JLabel TituloDatosItem;
    private javax.swing.JLabel UbicacionProvLbl;
    private javax.swing.JTextField UbicacionProveedor;
    private javax.swing.JButton VenderItem1;
    private javax.swing.JTextField cantUnidades;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton menuPrincipal;
    // End of variables declaration//GEN-END:variables
}
