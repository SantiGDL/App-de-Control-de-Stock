/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.PanelesInternos.Proveedores;

import GUI.FramePrincipal;
import GUI.PanelPrincipal;
import GUI.PanelesInternos.Items.EliminarItemPantalla2JPanel;
import GUI.PanelesPRINCIPALES.PanelDeProveedores;
import ImagenesHelpers.ImagenesHelper;
import ImagenesHelpers.PanelDeFondo;
import ImagenesHelpers.RenderDeImagenEnTablas;
import Persistencia.Clases.Item;
import Persistencia.Clases.Proveedor;
import Persistencia.FabricaEntityManager;
import Persistencia.ManejadorDePersistencia;
import jakarta.persistence.EntityManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Santi-kun
 */
public class EliminarProveedorJPanel extends javax.swing.JPanel {
    private Long proveedorId;

    private void configurarVista() {
        MenuLateral.setBackground(new Color(22, 73, 138));
        MenuLateral.setPreferredSize(new Dimension(200, 0));
        MenuLateral.setMinimumSize(new Dimension(200, 0));
        MenuLateral.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));

        MenuSuperior.removeAll();
        MenuSuperior.setLayout(new BorderLayout());
        MenuSuperior.setPreferredSize(new Dimension(0, 100));
        MenuSuperior.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        jLabel3.setText("ELIMINAR PROVEEDOR");
        jLabel3.setFont(new Font("Segoe UI Black", Font.PLAIN, 36));
        jLabel3.setHorizontalAlignment(CENTER);
        MenuSuperior.add(jLabel3, BorderLayout.CENTER);

        Contenido.removeAll();
        Contenido.setLayout(new BorderLayout(0, 0));
        Contenido.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, Color.BLACK));
        Contenido.add(jScrollPane1, BorderLayout.CENTER);

        JPanel derecha = new JPanel(new BorderLayout(0, 0));
        derecha.add(MenuSuperior, BorderLayout.NORTH);
        derecha.add(Contenido, BorderLayout.CENTER);
        Fondo.removeAll();
        Fondo.setLayout(new BorderLayout(0, 0));
        Fondo.setBorder(new EmptyBorder(0, 0, 0, 0));
        Fondo.add(MenuLateral, BorderLayout.WEST);
        Fondo.add(derecha, BorderLayout.CENTER);
        Fondo.revalidate();
        Fondo.repaint();
    }
    
    private void irAEliminarProveedorPantalla2(Long itemId){
            JPanel pantalla2 = new EliminarProveedorPantalla2JPanel(itemId);
            FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
            frame.cambiarFondo(pantalla2);
        }
    private void cargarTablaProveedores() {
    ManejadorDePersistencia MDP = ManejadorDePersistencia.getInstancia();
    EntityManager em = FabricaEntityManager.getEntityManager();
    List<Proveedor> proveedores = MDP.obtenerTodosLosProveedoresOrderByNombre(em);
    javax.swing.table.DefaultTableModel modeloTabla = new javax.swing.table.DefaultTableModel(
        new Object[]{"ID", "Nombre", "Contacto", "Ubicación", "Descripción", "Imagen", "Acción"}, 0
    ) {
        @Override public boolean isCellEditable(int row, int column) { return false; }
        
    };

    // 3) Cargás filas
    boolean hayProveedoresEliminables = false;
    for (Proveedor p : proveedores) {
        if ("DEFAULT".equalsIgnoreCase(p.getNombre())) continue;
        hayProveedoresEliminables = true;
        modeloTabla.addRow(new Object[]{
            p.getId(),
            p.getNombre(),
            p.getContacto(),
            p.getUbicacion(),
            p.getDescripcion(),
            p.getImagen(),
            "ELIMINAR"
        });
    }
    ListaDeProveedores.setModel(modeloTabla);
    ListaDeProveedores.getTableHeader().setReorderingAllowed(false);
     // oculto ID (col 0)
    ListaDeProveedores.getColumnModel().getColumn(0).setMinWidth(0);
    ListaDeProveedores.getColumnModel().getColumn(0).setMaxWidth(0);
    ListaDeProveedores.getColumnModel().getColumn(0).setPreferredWidth(0);
    ListaDeProveedores.getColumnModel().getColumn(1).setPreferredWidth(135);
    ListaDeProveedores.getColumnModel().getColumn(2).setPreferredWidth(125);
    ListaDeProveedores.getColumnModel().getColumn(3).setPreferredWidth(125);
    ListaDeProveedores.getColumnModel().getColumn(4).setPreferredWidth(195);
    ListaDeProveedores.getColumnModel().getColumn(5).setPreferredWidth(140);
    //HAY QUE RENDERIZAR DESPUES DE SETEAR EL MODELO
    int colImagen = 5;
    ListaDeProveedores.getColumnModel().getColumn(colImagen)
            .setCellRenderer(new RenderDeImagenEnTablas(120, 120));
    ImagenesHelper.estilizarTablaGaming(
            ListaDeProveedores,
            jScrollPane1,
            120,
            colImagen,
            ListaDeProveedores.getColumnModel().getColumn(colImagen).getCellRenderer(),
            true,
            null  // 👈 NO TOCAR esta columna (alertas)
    );

    
    //AHORA EL BOTON PARA APRETAR PARA SELECCIONAR PROVEEDOR
    Integer columnaBoton = 6;
    ListaDeProveedores.getColumnModel().getColumn(columnaBoton).setCellRenderer(new DefaultTableCellRenderer() {
    @Override
    public java.awt.Component getTableCellRendererComponent(
            javax.swing.JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        var c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setHorizontalAlignment(CENTER);
        setFont(getFont().deriveFont(java.awt.Font.BOLD, 11f));
        setForeground(java.awt.Color.WHITE);
        setBackground(new java.awt.Color(196, 54, 65));
        return c;
    }
    });
    ListaDeProveedores.getColumnModel().getColumn(columnaBoton).setMaxWidth(100);
    ListaDeProveedores.getColumnModel().getColumn(columnaBoton).setMinWidth(100);
   
    //AHORA DETECTAR LA INTERACCION CON LA COLOUMNA 4
    
    ListaDeProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        int viewRow = ListaDeProveedores.rowAtPoint(e.getPoint());
        int viewCol = ListaDeProveedores.columnAtPoint(e.getPoint());
        if (viewRow == -1 || viewCol == -1) return;

        int colAccion = columnaBoton; // la de "<"
        if (viewCol != colAccion) return;

        int modelRow = ListaDeProveedores.convertRowIndexToModel(viewRow);
        Object idObj = ListaDeProveedores.getModel().getValueAt(modelRow, 0);
        Long id = Long.valueOf(idObj.toString());
        //seteo la variable id 
        proveedorId= id;
        
        //GUARDO EL ITEM ID SELECCIONADO Y ME CAMBIO DE PANTALLA
        irAEliminarProveedorPantalla2(id);
    }
    });

    if (!hayProveedoresEliminables) {
        ImagenesHelper.mostrarEstadoVacio(
            jScrollPane1,
            "No hay proveedores para eliminar",
            "Creá un proveedor para que aparezca en esta pantalla.<br>"
            + "El proveedor DEFAULT está protegido y no puede eliminarse."
        );
    }
    }
    /**
     * Creates new form EliminarProveedorJPanel
     */
    public EliminarProveedorJPanel() {
        initComponents();
        configurarVista();
        cargarTablaProveedores();
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
        Contenido = new PanelDeFondo("/Imagenes/Fondo.png");
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaDeProveedores = new javax.swing.JTable();
        MenuLateral = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        VenderItem1 = new javax.swing.JButton();
        INICIO = new javax.swing.JButton();
        ATRAS = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setPreferredSize(new java.awt.Dimension(800, 500));
        Fondo.setRequestFocusEnabled(false);

        MenuSuperior.setBackground(new java.awt.Color(0, 102, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ELIMINAR ITEM");

        javax.swing.GroupLayout MenuSuperiorLayout = new javax.swing.GroupLayout(MenuSuperior);
        MenuSuperior.setLayout(MenuSuperiorLayout);
        MenuSuperiorLayout.setHorizontalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuSuperiorLayout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        MenuSuperiorLayout.setVerticalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuSuperiorLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        Contenido.setBackground(new java.awt.Color(204, 204, 204));
        Contenido.setPreferredSize(new java.awt.Dimension(700, 320));
        Contenido.setVerifyInputWhenFocusTarget(false);

        ListaDeProveedores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(ListaDeProveedores);

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        MenuLateral.setBackground(new java.awt.Color(51, 153, 255));
        MenuLateral.setPreferredSize(new java.awt.Dimension(200, 500));
        MenuLateral.setRequestFocusEnabled(false);

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/TelecomLogo.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ACCIONES");

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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
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
            .addGroup(MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(INICIO, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addComponent(ATRAS, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
        );
        MenuLateralLayout.setVerticalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addComponent(Logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247)
                .addComponent(VenderItem1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MenuLateralLayout.createSequentialGroup()
                    .addGap(185, 185, 185)
                    .addComponent(INICIO)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(ATRAS)
                    .addContainerGap(186, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(MenuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(MenuSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
            .addComponent(MenuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
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
        JPanel panelDeProveedores = new PanelDeProveedores();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(panelDeProveedores);
    }//GEN-LAST:event_ATRASActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ATRAS;
    private javax.swing.JPanel Contenido;
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton INICIO;
    private javax.swing.JTable ListaDeProveedores;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel MenuLateral;
    private javax.swing.JPanel MenuSuperior;
    private javax.swing.JButton VenderItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
