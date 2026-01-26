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
import ImagenesHelpers.RenderDeImagenEnTablas;
import Persistencia.Clases.Item;
import Persistencia.Clases.ItemDeProveedorX;
import Persistencia.Clases.Proveedor;
import Persistencia.FabricaEntityManager;
import Persistencia.ManejadorDePersistencia;
import jakarta.persistence.EntityManager;
import java.util.List;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Santi-kun
 */
public class SeleccionarProveedorCompraJPanel extends javax.swing.JPanel {
    //Atributos
    private Long ProveedorId;
    private Long ItemId;
    //<<CONSTRUCTOR>>
    public SeleccionarProveedorCompraJPanel(Long itemId) {
        this.ItemId = itemId;
        initComponents();
        cargarTablaItems();
    }
   
    
    private void irARellenarDatosCompra(Long itemId, Long ProveedorId){
        JPanel datosCompra = new RellenarDatosCompraJPanel(itemId, ProveedorId);
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(datosCompra);
    }
    private void cargarTablaItems() {
    // Llamo al manejador de persistencia que tiene la funcion de traerme los items
    ManejadorDePersistencia MDP = ManejadorDePersistencia.getInstancia();
    //invoco el entity manager para trabajar
    FabricaEntityManager FEM = new FabricaEntityManager();
    EntityManager em = FEM.getEntityManager();
    //Uso la funcion del manejador de persistencia que hice
    //Los ordeno por nombre
    List<Proveedor> proveedores = MDP.obtenerTodosLosProveedoresOrderByNombre(em);
    // 2) Armo el modelo con columnas
    javax.swing.table.DefaultTableModel modeloTabla = new javax.swing.table.DefaultTableModel(
        new Object[]{"ID", "Nombre", "Contacto", "Ubicación" , "Descripción", "Imágen", ""}, 0
    ) {
        @Override public boolean isCellEditable(int r, int c) { return false; }
    };
    
    modeloTabla.addRow(new Object[]{
        0L,
        "Proveedor sin especificar",
        "",                 // Contacto
        "",                 // Ubicación
        "Elija este proveedor cuando no quiera especificar dónde compró el item",
        "",                 // Imagen 
        ">"                 // columna acción
    });
    // 3) Cargás filas
    for (Proveedor p : proveedores) {
        modeloTabla.addRow(new Object[]{
            p.getId(),
            p.getNombre(),
            p.getContacto(),
            p.getUbicacion(),
            p.getDescripcion(),
            p.getImagen(),
            ">"
        });
    }
    CatalogoGeneral.setModel(modeloTabla);
    // oculto ID (col 0)
    CatalogoGeneral.getColumnModel().getColumn(0).setMinWidth(0);
    CatalogoGeneral.getColumnModel().getColumn(0).setMaxWidth(0);
    CatalogoGeneral.getColumnModel().getColumn(0).setPreferredWidth(0);
    
     //HAY QUE RENDERIZAR DESPUES DE SETEAR EL MODELO
    int colImagen = 5;
    CatalogoGeneral.setRowHeight(120);
    //RENDERIZO LA IMAGEN USANDO EL HELPER
    CatalogoGeneral.getColumnModel().getColumn(colImagen)
              .setCellRenderer(new RenderDeImagenEnTablas(120, 120));
    
    //AHORA EL BOTON PARA APRETAR PARA SELECCIONAR PROVEEDOR
    
    CatalogoGeneral.getColumnModel().getColumn(6).setCellRenderer(new DefaultTableCellRenderer() {
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
    CatalogoGeneral.getColumnModel().getColumn(6).setMaxWidth(45);
    CatalogoGeneral.getColumnModel().getColumn(6).setMinWidth(45);
   
    //AHORA DETECTAR LA INTERACCION CON LA COLOUMNA 4
    
    CatalogoGeneral.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        int viewRow = CatalogoGeneral.rowAtPoint(e.getPoint());
        int viewCol = CatalogoGeneral.columnAtPoint(e.getPoint());
        if (viewRow == -1 || viewCol == -1) return;

        int colAccion = 6; // la de "<"
        if (viewCol != colAccion) return;

        int modelRow = CatalogoGeneral.convertRowIndexToModel(viewRow);
        Object idObj = CatalogoGeneral.getModel().getValueAt(modelRow, 0);
        ProveedorId = Long.valueOf(idObj.toString());
        //Me voy a la pantalla de compra teniendo en memoria el ID del Item y del Proveedor, en caso de no especificar
        //el Proveedor porque eligió el default que lo dejo arriba del todo o en un boton NO CREO UN ItemDeProveedorX
        irARellenarDatosCompra(ItemId, ProveedorId);
    }
});
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
        jScrollPane1 = new javax.swing.JScrollPane();
        CatalogoGeneral = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        MenuLateral = new javax.swing.JPanel();
        Logo1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        VenderItem1 = new javax.swing.JButton();
        menuPrincipal = new javax.swing.JButton();
        Atras = new javax.swing.JButton();

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
            .addGroup(MenuSuperiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuSuperiorLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(151, 151, 151))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuSuperiorLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
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
        jLabel5.setText("Proveedores Disponibles");

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenidoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
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
            .addGroup(MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(menuPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addComponent(Atras, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
        );
        MenuLateralLayout.setVerticalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addComponent(Logo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232)
                .addComponent(VenderItem1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MenuLateralLayout.createSequentialGroup()
                    .addGap(175, 175, 175)
                    .addComponent(menuPrincipal)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(Atras)
                    .addContainerGap(175, Short.MAX_VALUE)))
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
                    .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(MenuSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
            .addComponent(MenuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
        );

        add(Fondo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void VenderItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenderItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VenderItem1ActionPerformed

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
    private javax.swing.JTable CatalogoGeneral;
    private javax.swing.JPanel Contenido;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel Logo1;
    private javax.swing.JPanel MenuLateral;
    private javax.swing.JPanel MenuSuperior;
    private javax.swing.JButton VenderItem1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton menuPrincipal;
    // End of variables declaration//GEN-END:variables
}
