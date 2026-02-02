package ImagenesHelpers;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

import static javax.swing.SwingConstants.CENTER;

public class RenderDeImagenEnTablas extends DefaultTableCellRenderer {
    private final int anchoMiniatura;
    private final int altoMiniatura;

    // Cache por ruta + tamaño (por si reutilizás el renderer con otros tamaños)
    private final Map<String, ImageIcon> cacheIconos = new HashMap<>();

    public RenderDeImagenEnTablas(int anchoMiniatura, int altoMiniatura) {
        this.anchoMiniatura = anchoMiniatura;
        this.altoMiniatura = altoMiniatura;
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
    }

    private String key(String ruta) {
        return ruta + "@" + anchoMiniatura + "x" + altoMiniatura;
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        JLabel lbl = (JLabel) super.getTableCellRendererComponent(table, "", isSelected, hasFocus, row, column);
        lbl.setHorizontalAlignment(CENTER);
        lbl.setVerticalAlignment(CENTER);

        // ===== Fondo correcto según selección / foco =====
        // Si la fila está seleccionada pero la tabla no tiene foco, NO queremos que quede “pegado”.
        boolean tablaTieneFoco = table.isFocusOwner();

        if (isSelected && tablaTieneFoco) {
            lbl.setOpaque(true);
            lbl.setBackground(table.getSelectionBackground());
        } else {
            // dejamos transparente para que se vea el zebra del renderer general
            lbl.setOpaque(false);
            lbl.setBackground(new Color(0, 0, 0, 0));
        }

        // ===== icono =====
        String ruta = (value == null) ? "" : value.toString().trim();
        if (ruta.isEmpty()) {
            lbl.setIcon(null);
            return lbl;
        }

        ImageIcon icono = cacheIconos.get(key(ruta));
        if (icono == null) {
            try {
                BufferedImage src = leerImagen(ruta);
                if (src == null) {
                    lbl.setIcon(null);
                    return lbl;
                }

                BufferedImage scaled = escalarARGB(src, anchoMiniatura, altoMiniatura);
                icono = new ImageIcon(scaled);
                cacheIconos.put(key(ruta), icono);

            } catch (Exception e) {
                lbl.setIcon(null);
                return lbl;
            }
        }

        lbl.setIcon(icono);
        return lbl;
    }

    private BufferedImage leerImagen(String ruta) throws Exception {
        // recurso del classpath
        if (ruta.startsWith("/")) {
            URL url = getClass().getResource(ruta);
            if (url == null) return null;
            return ImageIO.read(url);
        }

        // archivo local
        File f = new File(ruta);
        if (!f.exists()) return null;
        return ImageIO.read(f);
    }

    private BufferedImage escalarARGB(BufferedImage src, int w, int h) {
        // Aseguramos ARGB (alpha real)
        BufferedImage out = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = out.createGraphics();
        g2.setComposite(AlphaComposite.Src); // CLAVE: no mezcla rara con fondo
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.drawImage(src, 0, 0, w, h, null);
        g2.dispose();
        return out;
    }
}