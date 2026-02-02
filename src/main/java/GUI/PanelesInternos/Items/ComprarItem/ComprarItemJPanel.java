/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.PanelesInternos.Items.ComprarItem;

import GUI.FramePrincipal;
import GUI.PanelPrincipal;
import GUI.PanelesInternos.Items.CrearItemJPanel;
import GUI.PanelesInternos.Proveedores.CrearProveedorJPanel;
import GUI.PanelesInternos.LoginJPanel;
import GUI.PanelesPRINCIPALES.PanelDeConfiguracion;
import GUI.PanelesPRINCIPALES.PanelDeItems;
import ImagenesHelpers.ImagenesHelper;
import ImagenesHelpers.PanelDeFondo;
import ImagenesHelpers.RenderDeImagenEnTablas;
import Persistencia.Clases.CatalogoGeneral;
import Persistencia.Clases.Item;
import Persistencia.FabricaEntityManager;
import Persistencia.ManejadorDePersistencia;
import jakarta.persistence.EntityManager;
import java.awt.Color;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Santi-kun
 */
public class ComprarItemJPanel extends javax.swing.JPanel {
    
    //Atributos
    private Long itemId; //aca voy a guardar el id del item que elija el usuario
   
    
    //Cambio de pantalla con Seleccionar proveedor
    private void irASeleccionProveedor(Long itemId){
        JPanel seleccionarProveedor = new SeleccionarProveedorCompraJPanel(itemId);
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(seleccionarProveedor);
    }
    
  
    public void setItemId(Long id){this.itemId = id;}
    private void cargarTablaItems() {
    // Llamo al manejador de persistencia que tiene la funcion de traerme los items
    ManejadorDePersistencia MDP = ManejadorDePersistencia.getInstancia();
    //invoco el entity manager para trabajar
    EntityManager em = FabricaEntityManager.getEntityManager();
    //Uso la funcion del manejador de persistencia que hice
    List<Item> items = MDP.getItemsDeCatalogoGeneralOptimizado();
    // 2) Armo el modelo con columnas
    javax.swing.table.DefaultTableModel modeloTabla = new javax.swing.table.DefaultTableModel(
        new Object[]{"ID", "Nombre", "Descripcion", "Imagen", ">"}, 0
    ) {
        @Override public boolean isCellEditable(int r, int c) { return false; }
    };

    // 3) Cargás filas
    for (Item it : items) {
        modeloTabla.addRow(new Object[]{
            it.getId(),
            it.getNombre(),
            it.getDescripcion(),
            it.getImagen(),
            ">"
        });
    }
    CatalogoGeneral.setModel(modeloTabla);
    // oculto ID (col 0)
    CatalogoGeneral.getColumnModel().getColumn(0).setMinWidth(0);
    CatalogoGeneral.getColumnModel().getColumn(0).setMaxWidth(0);
    CatalogoGeneral.getColumnModel().getColumn(0).setPreferredWidth(0);
    //Renderizo la imagen
    int colImagen = 3;
    CatalogoGeneral.getColumnModel().getColumn(colImagen)
            .setCellRenderer(new RenderDeImagenEnTablas(120, 120));
    ImagenesHelper.estilizarTablaGaming(
            CatalogoGeneral,
            jScrollPane1,
            120,
            colImagen,
            CatalogoGeneral.getColumnModel().getColumn(colImagen).getCellRenderer(),
            true,
            null  // 👈 NO TOCAR esta columna (alertas)
    );
    
    //AHORA EL BOTON PARA APRETAR PARA SELECCIONAR PROVEEDOR
    
    CatalogoGeneral.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
    @Override
    public java.awt.Component getTableCellRendererComponent(
            javax.swing.JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        var c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setHorizontalAlignment(CENTER);
        setFont(getFont().deriveFont(java.awt.Font.BOLD, 18f));
        setForeground(java.awt.Color.WHITE);
        setBackground(new java.awt.Color(0, 102, 255)); // azul
        return c;
    }
    });
    CatalogoGeneral.getColumnModel().getColumn(4).setMaxWidth(45);
    CatalogoGeneral.getColumnModel().getColumn(4).setMinWidth(45);
   
    //AHORA DETECTAR LA INTERACCION CON LA COLOUMNA 4
    
    CatalogoGeneral.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        int viewRow = CatalogoGeneral.rowAtPoint(e.getPoint());
        int viewCol = CatalogoGeneral.columnAtPoint(e.getPoint());
        if (viewRow == -1 || viewCol == -1) return;

        int colAccion = 4; // la de "<"
        if (viewCol != colAccion) return;

        int modelRow = CatalogoGeneral.convertRowIndexToModel(viewRow);
        Object idObj = CatalogoGeneral.getModel().getValueAt(modelRow, 0);
        Long it = Long.valueOf(idObj.toString());
        //seteo la variable id 
        setItemId(it);
        
        //GUARDO EL ITEM ID SELECCIONADO Y ME CAMBIO DE PANTALLA
        irASeleccionProveedor(it);
    }
});
    }
   
    
    
    
    
    
    
    
    public ComprarItemJPanel() {
        initComponents();
        cargarTablaItems();
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
        Contenido = new PanelDeFondo("/Imagenes/Fondo.png");
        jScrollPane1 = new javax.swing.JScrollPane();
        CatalogoGeneral = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        MenuLateral = new javax.swing.JPanel();
        Logo1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        VenderItem1 = new javax.swing.JButton();
        INICIO = new javax.swing.JButton();
        ATRAS = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setPreferredSize(new java.awt.Dimension(800, 500));
        Fondo.setRequestFocusEnabled(false);

        MenuSuperior.setBackground(new java.awt.Color(0, 102, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Comprar Item");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("seleccione uno de los items disponibles");

        javax.swing.GroupLayout MenuSuperiorLayout = new javax.swing.GroupLayout(MenuSuperior);
        MenuSuperior.setLayout(MenuSuperiorLayout);
        MenuSuperiorLayout.setHorizontalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuSuperiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuSuperiorLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuSuperiorLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        MenuSuperiorLayout.setVerticalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        Contenido.setBackground(new java.awt.Color(204, 204, 204));
        Contenido.setPreferredSize(new java.awt.Dimension(700, 320));
        Contenido.setVerifyInputWhenFocusTarget(false);

        CatalogoGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(CatalogoGeneral);

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CATÁLOGO GENERAL");

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenidoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
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
            .addComponent(INICIO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ATRAS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuLateralLayout.setVerticalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addComponent(Logo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(INICIO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ATRAS)
                .addGap(168, 168, 168)
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
                    .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(MenuSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
            .addComponent(MenuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
        );

        add(Fondo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JTable CatalogoGeneral;
    private javax.swing.JPanel Contenido;
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton INICIO;
    private javax.swing.JLabel Logo1;
    private javax.swing.JPanel MenuLateral;
    private javax.swing.JPanel MenuSuperior;
    private javax.swing.JButton VenderItem1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
