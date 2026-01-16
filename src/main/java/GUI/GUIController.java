package GUI;

import GUI.MenusSuperiores.MenuSuperiorPrincipal;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIController {
    
    public GUIController(){}
    
   public void cambiarContenido(JPanel panelNuevo, JPanel panelAnterior) {
    panelNuevo.setSize(panelAnterior.getMaximumSize());
    panelNuevo.setLocation(0, 0);
    panelAnterior.removeAll();
    panelAnterior.add(panelNuevo);
    panelAnterior.revalidate();
    panelAnterior.repaint();
    }
    public void cambiarPanelEntero(JPanel MenuSuperior, JPanel MenuLateral, JPanel Contenido, JPanel Fondo, JPanel panelNuevo, JFrame frameDeTrabajo){
        panelNuevo.setSize(frameDeTrabajo.getMaximumSize()); //Obtengo el tamaño del JFrame 
        panelNuevo.setLocation(0, 0);
        //Borro el Menu, la Barra de Arriba, El Contenido y el Fondo, luego lo reemplazo por el nuevo panel
        MenuSuperior.removeAll();
        MenuLateral.removeAll();
        Contenido.removeAll();
        Fondo.removeAll();
        Fondo.add(panelNuevo);
        Fondo.revalidate();
        Fondo.repaint();
    }
    
    public void volverAMenuPrincipal(JPanel MenuSuperior, JPanel MenuLateral, JPanel Contenido){
        //Borro la Barra de Arriba, el Menu y El Contenido del Configuracion JPanel para volver al Menu Principal
        MenuSuperior.removeAll();
        MenuLateral.removeAll();
        Contenido.removeAll();
        
        JPanel menuPrincipal = new MenuSuperiorPrincipal();
        MenuSuperior.add(menuPrincipal);
        MenuSuperior.revalidate();
        MenuSuperior.repaint();
        
    }
}
