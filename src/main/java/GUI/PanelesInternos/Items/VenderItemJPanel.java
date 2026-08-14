/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.PanelesInternos.Items;

import GUI.FramePrincipal;
import GUI.PanelPrincipal;
import GUI.PanelesInternos.Items.ComprarItem.ComprarItemJPanel;
import GUI.PanelesInternos.Items.ComprarItem.SeleccionarProveedorCompraJPanel;
import GUI.PanelesPRINCIPALES.PanelDeItems;
import ImagenesHelpers.ImagenesHelper;
import ImagenesHelpers.PanelDeFondo;
import ImagenesHelpers.RenderCantidadConAlerta;
import ImagenesHelpers.RenderDeImagenEnTablas;
import Persistencia.Clases.ItemDeSTOCK;
import Persistencia.FabricaEntityManager;
import Persistencia.ManejadorDePersistencia;
import jakarta.persistence.EntityManager;
import java.awt.BorderLayout;
import java.awt.Color;
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
public class VenderItemJPanel extends javax.swing.JPanel {
    
    private Long itemSeleccionadoId;
    
    private void irAVenderItemPantalla2(Long itemId){
        JPanel venderItemPantalla2 = new VenderItemPantalla2JPanel(itemId);
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(venderItemPantalla2);
    }

    

    private void cargarTablaItemsSTOCK() {
        // Llamo al manejador de persistencia que tiene la funcion de traerme los items
        ManejadorDePersistencia MDP = ManejadorDePersistencia.getInstancia();
        //invoco el entity manager para trabajar
        FabricaEntityManager FEM = new FabricaEntityManager();
        EntityManager em = FEM.getEntityManager();
        //Uso la funcion del manejador de persistencia que hice
        List<ItemDeSTOCK> itemsDeStock = MDP.getItemsDeStock(em);
        // 2) Armo el modelo con columnas
        javax.swing.table.DefaultTableModel modeloTabla = new javax.swing.table.DefaultTableModel(
            new Object[]{"ID", "Nombre", "Descripción", "Imagen", "Unidades", "Acción"}, 0
        ) {
            @Override public boolean isCellEditable(int row, int column) { return false; }

        };

        // 3) Cargás filas
        for (ItemDeSTOCK it : itemsDeStock) {
            modeloTabla.addRow(new Object[]{
                it.getId(),
                it.getNombre(),
                it.getDescripcion(),
                it.getImagen(),
                it.getCantUnidades(),
                "VENDER"
            });
        }
        TablaDeStock.setModel(modeloTabla);
        TablaDeStock.getTableHeader().setReorderingAllowed(false);
        //REDERIZO LA IMAGEN DE LA TABLA
        int colImagen = 3;
        TablaDeStock.getColumnModel().getColumn(colImagen)
                .setCellRenderer(new RenderDeImagenEnTablas(120, 120));


        ImagenesHelper.estilizarTablaGaming(
                TablaDeStock,
                jScrollPane1,
                120,
                colImagen,
                TablaDeStock.getColumnModel().getColumn(colImagen).getCellRenderer(),
                true,
                5
        );
        TablaDeStock.getColumnModel().getColumn(0).setMinWidth(0);
        TablaDeStock.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaDeStock.getColumnModel().getColumn(0).setPreferredWidth(0);
        TablaDeStock.getColumnModel().getColumn(1).setPreferredWidth(180);
        TablaDeStock.getColumnModel().getColumn(2).setPreferredWidth(260);
        TablaDeStock.getColumnModel().getColumn(3).setPreferredWidth(150);
        TablaDeStock.getColumnModel().getColumn(4).setPreferredWidth(100);

        //AHORA EL BOTON PARA APRETAR PARA SELECCIONAR ITEM Y VENDDERLO
        int columnaBoton = 5;
        TablaDeStock.getColumnModel().getColumn(columnaBoton).setCellRenderer(new DefaultTableCellRenderer() {
        @Override
        public java.awt.Component getTableCellRendererComponent(
                javax.swing.JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {

            var c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setHorizontalAlignment(CENTER);
            setFont(new java.awt.Font("Segoe UI Black", java.awt.Font.PLAIN, 12));
            setForeground(java.awt.Color.WHITE);
            setBackground(new java.awt.Color(0, 102, 255)); // azul
            return c;
        }
        });
        TablaDeStock.getColumnModel().getColumn(columnaBoton).setPreferredWidth(110);
        TablaDeStock.getColumnModel().getColumn(columnaBoton).setMinWidth(100);

         //AHORA DETECTAR LA INTERACCION CON LA COLOUMNA 5
        TablaDeStock.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int viewRow = TablaDeStock.rowAtPoint(e.getPoint());
                int viewCol = TablaDeStock.columnAtPoint(e.getPoint());
                if (viewRow == -1 || viewCol == -1) return;

                int colAccion = columnaBoton; // la de ">"
                if (viewCol != colAccion) return;

                int modelRow = TablaDeStock.convertRowIndexToModel(viewRow);
                Object idObj = TablaDeStock.getModel().getValueAt(modelRow, 0);
                Long itId = Long.valueOf(idObj.toString());

                // seteo la variable id
                itemSeleccionadoId = itId;

                // GUARDO EL ITEM ID SELECCIONADO Y ME CAMBIO DE PANTALLA
                irAVenderItemPantalla2(itId);
            }
        });

        if (itemsDeStock.isEmpty()) {
            ImagenesHelper.mostrarEstadoVacio(
                jScrollPane1,
                "No hay productos para vender",
                "Primero tenés que registrar una compra.<br>"
                + "Cuando el producto tenga unidades en stock, aparecerá en esta pantalla."
            );
        }
    }
                
                
                /**
     * Creates new form PanelDeStock
     */
    public VenderItemJPanel() {
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





        cargarTablaItemsSTOCK();
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
        MenuLateral = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        VenderItem1 = new javax.swing.JButton();
        ATRAS = new javax.swing.JButton();
        INICIO = new javax.swing.JButton();
        MenuSuperior = new javax.swing.JPanel();
        TextoMenuSuperior = new javax.swing.JLabel();
        Contenido = new PanelDeFondo("/Imagenes/Fondo.png");
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDeStock = new javax.swing.JTable();

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

        VenderItem1.setForeground(new java.awt.Color(0, 0, 0));
        VenderItem1.setBorder(null);
        VenderItem1.setBorderPainted(false);
        VenderItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VenderItem1.addActionListener(this::VenderItem1ActionPerformed);

        ATRAS.setBackground(new java.awt.Color(153, 255, 255));
        ATRAS.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        ATRAS.setForeground(new java.awt.Color(0, 0, 0));
        ATRAS.setText("ATRAS");
        ATRAS.setBorder(null);
        ATRAS.setBorderPainted(false);
        ATRAS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ATRAS.addActionListener(this::ATRASActionPerformed);

        INICIO.setBackground(new java.awt.Color(204, 255, 255));
        INICIO.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        INICIO.setForeground(new java.awt.Color(0, 0, 0));
        INICIO.setText("INICIO");
        INICIO.setBorder(null);
        INICIO.setBorderPainted(false);
        INICIO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        INICIO.addActionListener(this::INICIOActionPerformed);

        javax.swing.GroupLayout MenuLateralLayout = new javax.swing.GroupLayout(MenuLateral);
        MenuLateral.setLayout(MenuLateralLayout);
        MenuLateralLayout.setHorizontalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(ATRAS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(INICIO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuLateralLayout.setVerticalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLateralLayout.createSequentialGroup()
                .addComponent(Logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(INICIO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ATRAS)
                .addGap(193, 193, 193)
                .addComponent(VenderItem1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MenuSuperior.setBackground(new java.awt.Color(0, 102, 255));

        TextoMenuSuperior.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        TextoMenuSuperior.setForeground(new java.awt.Color(255, 255, 255));
        TextoMenuSuperior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextoMenuSuperior.setText("VENDER ITEM");

        javax.swing.GroupLayout MenuSuperiorLayout = new javax.swing.GroupLayout(MenuSuperior);
        MenuSuperior.setLayout(MenuSuperiorLayout);
        MenuSuperiorLayout.setHorizontalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuSuperiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TextoMenuSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        MenuSuperiorLayout.setVerticalGroup(
            MenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuSuperiorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(TextoMenuSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        Contenido.setBackground(new java.awt.Color(204, 204, 204));
        Contenido.setPreferredSize(new java.awt.Dimension(700, 320));
        Contenido.setVerifyInputWhenFocusTarget(false);

        TablaDeStock.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TablaDeStock);

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addContainerGap())
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
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
                    .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(MenuSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(Fondo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void VenderItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenderItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VenderItem1ActionPerformed

    private void ATRASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ATRASActionPerformed
        JPanel panelDeItems = new PanelDeItems();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(panelDeItems);
    }//GEN-LAST:event_ATRASActionPerformed

    private void INICIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INICIOActionPerformed
        JPanel panelPrincipal = new PanelPrincipal();
        FramePrincipal frame = (FramePrincipal) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.cambiarFondo(panelPrincipal);
    }//GEN-LAST:event_INICIOActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ATRAS;
    private javax.swing.JPanel Contenido;
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton INICIO;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel MenuLateral;
    private javax.swing.JPanel MenuSuperior;
    private javax.swing.JTable TablaDeStock;
    private javax.swing.JLabel TextoMenuSuperior;
    private javax.swing.JButton VenderItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
