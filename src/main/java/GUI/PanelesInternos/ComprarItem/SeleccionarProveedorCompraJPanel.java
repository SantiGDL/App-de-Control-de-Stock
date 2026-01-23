/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.PanelesInternos.ComprarItem;

import GUI.FramePrincipal;
import GUI.PanelesInternos.CrearItemJPanel;
import GUI.PanelesInternos.CrearProveedorJPanel;
import GUI.PanelesInternos.LoginJPanel;
import GUI.PanelesPRINCIPALES.PanelDeConfiguracion;
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
    List<Proveedor> proveedores = MDP.obtenerTodosLosProveedores(em);
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
        Long ProveedorId = Long.valueOf(idObj.toString());
        //LO CREO POR AHORA PARA QUE FUNCIONE NOMAS
        Long itemId = 8L;
        
        //Me voy a la pantalla de compra teniendo en memoria el ID del Item y del Proveedor, en caso de no especificar
        //el Proveedor porque eligió el default que lo dejo arriba del todo o en un boton NO CREO UN ItemDeProveedorX
        irARellenarDatosCompra(itemId, ProveedorId);
    }
});
    }
    
    
    
    //<<CONSTRUCTOR>>
    public SeleccionarProveedorCompraJPanel(Long itemId) {
        initComponents();
        cargarTablaItems();
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
        CrearProveedor1 = new javax.swing.JButton();
        CrearItem1 = new javax.swing.JButton();
        Logo1 = new javax.swing.JLabel();
        Login1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Configuracion1 = new javax.swing.JButton();
        Configuracion2 = new javax.swing.JButton();
        ComprarItem = new javax.swing.JButton();
        VenderItem = new javax.swing.JButton();
        VenderItem1 = new javax.swing.JButton();
        Configuracion3 = new javax.swing.JButton();
        Configuracion4 = new javax.swing.JButton();

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

        CrearProveedor1.setForeground(new java.awt.Color(0, 0, 0));
        CrearProveedor1.setText("Crear Proveedor (ok)");
        CrearProveedor1.setBorder(null);
        CrearProveedor1.setBorderPainted(false);
        CrearProveedor1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CrearProveedor1.addActionListener(this::CrearProveedor1ActionPerformed);

        CrearItem1.setForeground(new java.awt.Color(0, 0, 0));
        CrearItem1.setText("Crear Item (ok)");
        CrearItem1.setBorder(null);
        CrearItem1.setBorderPainted(false);
        CrearItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CrearItem1.addActionListener(this::CrearItem1ActionPerformed);

        Logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/TelecomLogo.png"))); // NOI18N

        Login1.setForeground(new java.awt.Color(0, 0, 0));
        Login1.setText("Iniciar Sesion (ok)");
        Login1.setBorder(null);
        Login1.setBorderPainted(false);
        Login1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Login1.addActionListener(this::Login1ActionPerformed);

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ACCIONES");

        Configuracion1.setForeground(new java.awt.Color(0, 0, 0));
        Configuracion1.setText("Configuración (ok)");
        Configuracion1.setBorder(null);
        Configuracion1.setBorderPainted(false);
        Configuracion1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Configuracion1.addActionListener(this::Configuracion1ActionPerformed);

        Configuracion2.setForeground(new java.awt.Color(0, 0, 0));
        Configuracion2.setText("Historial");
        Configuracion2.setBorder(null);
        Configuracion2.setBorderPainted(false);
        Configuracion2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Configuracion2.addActionListener(this::Configuracion2ActionPerformed);

        ComprarItem.setForeground(new java.awt.Color(0, 0, 0));
        ComprarItem.setText("Comprar Item");
        ComprarItem.setBorder(null);
        ComprarItem.setBorderPainted(false);
        ComprarItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ComprarItem.addActionListener(this::ComprarItemActionPerformed);

        VenderItem.setForeground(new java.awt.Color(0, 0, 0));
        VenderItem.setText("Vender Item");
        VenderItem.setBorder(null);
        VenderItem.setBorderPainted(false);
        VenderItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VenderItem.addActionListener(this::VenderItemActionPerformed);

        VenderItem1.setForeground(new java.awt.Color(0, 0, 0));
        VenderItem1.setBorder(null);
        VenderItem1.setBorderPainted(false);
        VenderItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VenderItem1.addActionListener(this::VenderItem1ActionPerformed);

        Configuracion3.setForeground(new java.awt.Color(0, 0, 0));
        Configuracion3.setText("Catálogo General");
        Configuracion3.setBorder(null);
        Configuracion3.setBorderPainted(false);
        Configuracion3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Configuracion3.addActionListener(this::Configuracion3ActionPerformed);

        Configuracion4.setForeground(new java.awt.Color(0, 0, 0));
        Configuracion4.setText("Catálogo por Proveedor");
        Configuracion4.setBorder(null);
        Configuracion4.setBorderPainted(false);
        Configuracion4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Configuracion4.addActionListener(this::Configuracion4ActionPerformed);

        javax.swing.GroupLayout MenuLateralLayout = new javax.swing.GroupLayout(MenuLateral);
        MenuLateral.setLayout(MenuLateralLayout);
        MenuLateralLayout.setHorizontalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CrearItem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Login1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addComponent(VenderItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ComprarItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(CrearProveedor1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Configuracion2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Configuracion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Configuracion3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Configuracion4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuLateralLayout.setVerticalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addComponent(Logo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Login1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CrearItem1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComprarItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VenderItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CrearProveedor1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Configuracion2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Configuracion3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Configuracion4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Configuracion1)
                .addGap(34, 34, 34)
                .addComponent(VenderItem1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void CrearProveedor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearProveedor1ActionPerformed
        // Creo el panel CrearProveedor
        JPanel crearProveedorPanel = new CrearProveedorJPanel();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(crearProveedorPanel);
    }//GEN-LAST:event_CrearProveedor1ActionPerformed

    private void CrearItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearItem1ActionPerformed
        JPanel crearItemPanel = new CrearItemJPanel();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(crearItemPanel);
    }//GEN-LAST:event_CrearItem1ActionPerformed

    private void Login1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login1ActionPerformed
        JPanel loginPanel = new LoginJPanel();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(loginPanel);
    }//GEN-LAST:event_Login1ActionPerformed

    private void Configuracion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Configuracion1ActionPerformed
        JPanel configuracionPanel = new PanelDeConfiguracion();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(configuracionPanel);
    }//GEN-LAST:event_Configuracion1ActionPerformed

    private void Configuracion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Configuracion2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Configuracion2ActionPerformed

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

    private void Configuracion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Configuracion3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Configuracion3ActionPerformed

    private void Configuracion4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Configuracion4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Configuracion4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CatalogoGeneral;
    private javax.swing.JButton ComprarItem;
    private javax.swing.JButton Configuracion1;
    private javax.swing.JButton Configuracion2;
    private javax.swing.JButton Configuracion3;
    private javax.swing.JButton Configuracion4;
    private javax.swing.JPanel Contenido;
    private javax.swing.JButton CrearItem1;
    private javax.swing.JButton CrearProveedor1;
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton Login1;
    private javax.swing.JLabel Logo1;
    private javax.swing.JPanel MenuLateral;
    private javax.swing.JPanel MenuSuperior;
    private javax.swing.JButton VenderItem;
    private javax.swing.JButton VenderItem1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
