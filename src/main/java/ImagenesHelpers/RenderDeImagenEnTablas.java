package ImagenesHelpers;

import java.awt.Component;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderDeImagenEnTablas extends DefaultTableCellRenderer {
    private final int anchoMiniatura;
    private final int altoMiniatura;

    private final Map<String, ImageIcon> cacheIconos = new HashMap<>();

    public RenderDeImagenEnTablas(int anchoMiniatura, int altoMiniatura) {
        this.anchoMiniatura = anchoMiniatura;
        this.altoMiniatura = altoMiniatura;
        setHorizontalAlignment(CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        JLabel lbl = (JLabel) super.getTableCellRendererComponent(
                table, "", isSelected, hasFocus, row, column
        );
        lbl.setHorizontalAlignment(CENTER);

        String ruta = (value == null) ? "" : value.toString().trim();
        if (ruta.isEmpty()) {
            lbl.setIcon(null);
            return lbl;
        }

        ImageIcon icono = cacheIconos.get(ruta);
        if (icono == null) {

            ImageIcon original;

            // ✅ FIX: resource vs archivo
            if (ruta.startsWith("/")) {
                java.net.URL url = getClass().getResource(ruta);
                if (url == null) {
                    lbl.setIcon(null);
                    return lbl;
                }
                original = new ImageIcon(url);
            } else {
                original = new ImageIcon(ruta);
            }

            if (original.getIconWidth() <= 0) {
                lbl.setIcon(null);
                return lbl;
            }

            Image escalada = original.getImage().getScaledInstance(
                    anchoMiniatura, altoMiniatura, Image.SCALE_SMOOTH
            );
            icono = new ImageIcon(escalada);
            cacheIconos.put(ruta, icono);
        }

        lbl.setIcon(icono);
        return lbl;
    }
}