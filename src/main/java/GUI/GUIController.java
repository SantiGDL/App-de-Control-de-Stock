package GUI;
import Persistencia.DTOs.DTItem;
import Persistencia.FabricaEntityManager;
import Persistencia.ManejadorDePersistencia;
import jakarta.persistence.EntityManager;
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

     public void cambiarPanelGeneral(JPanel panelACambiar, JPanel panelNuevo){
        panelNuevo.setSize(panelACambiar.getMaximumSize());
        panelACambiar.removeAll();
        panelACambiar.add(panelNuevo);
        panelACambiar.revalidate();
        panelACambiar.repaint();
    }
     
     public DTItem recuperarDTItemDeId(Long itemId){
        //Primero llamo al manejado de persistencia para obtener la insantncia de Item a partir de la id
        ManejadorDePersistencia MDP = ManejadorDePersistencia.getInstancia();
        EntityManager em = FabricaEntityManager.getEntityManager();
        DTItem dt = MDP.getDTItem(em, itemId);
        return dt;
     }
}
