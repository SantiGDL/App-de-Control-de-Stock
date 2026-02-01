package GUI;
import ImagenesHelpers.ImagenesHelper;
import Persistencia.Clases.Item;
import Persistencia.DTOs.DTItem;
import Persistencia.DTOs.DTItemDeSTOCK;
import Persistencia.DTOs.DTProveedor;
import Persistencia.FabricaEntityManager;
import Persistencia.ManejadorDePersistencia;
import jakarta.persistence.EntityManager;
import java.awt.Image;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
//imports para cargar imagenes
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

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
     
     public DTItemDeSTOCK recuperarDTItemDeSTOCKDeId(Long itemId){
        //Primero llamo al manejado de persistencia para obtener la insantncia de Item a partir de la id
        ManejadorDePersistencia MDP = ManejadorDePersistencia.getInstancia();
        EntityManager em = FabricaEntityManager.getEntityManager();
        DTItemDeSTOCK dt = MDP.getDTItemDeSTOCK(em, itemId);
        return dt;
     }
     
     
     //Funciones Auxiliares de Cargar Imagen
    
     public String cargarImagen(String rutaImagen) throws IOException{
         //Llamo al Imagen Helper para que se encergue de cargar la imagen que le paso 
         return ImagenesHelper.copiarImagenAAppSources(rutaImagen);
     }
     
     public DTProveedor recuperarDTProveedorDeId(Long proveedorId){
        //Primero llamo al manejado de persistencia para obtener la insantncia de Item a partir de la id
        ManejadorDePersistencia MDP = ManejadorDePersistencia.getInstancia();
        EntityManager em = FabricaEntityManager.getEntityManager();
        DTProveedor dt = MDP.getDTProveedor(em, proveedorId);
        return dt;
     }
     
    public void mostrarImagenEnPanel(JPanel panel, JLabel label, String ruta) {
    if (ruta == null || ruta.isBlank()) {
        label.setIcon(null);
        return;
    }

    ImageIcon icon = new ImageIcon(ruta);
    if (icon.getIconWidth() <= 0) { // no cargó
        label.setIcon(null);
        return;
    }

    int w = panel.getWidth();
    int h = panel.getHeight();
    if (w <= 0 || h <= 0) { // si todavía no se layout-eó
        w = 160; h = 160;   // fallback
    }

    Image escalada = icon.getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
    label.setIcon(new ImageIcon(escalada));
}
    
}
