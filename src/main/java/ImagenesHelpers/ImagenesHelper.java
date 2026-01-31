package ImagenesHelpers;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.*;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author Santi-kun
 */
public class ImagenesHelper {
    private static Path getRutaBaseImagenes() {
        Path raiz = Paths.get(File.listRoots()[0].getAbsolutePath());
        return raiz.resolve("StockAppSources");
    }

    private static String limpiarCarateresEspeciales (String nombreImagen) {
        if (nombreImagen == null || nombreImagen.isBlank()) return "imagen";
        return nombreImagen.replaceAll("[\\\\/:*?\"<>|]", "_").trim();
    }

    private static String getExtension(String nombreArchivoImagen) {
        int punto = nombreArchivoImagen.lastIndexOf('.');
        if (punto < 0 || punto == nombreArchivoImagen.length() - 1) return "";
        return nombreArchivoImagen.substring(punto); // incluye el punto: ".png"
    }

    public static String copiarImagenAAppSources(String rutaOrigen) throws IOException {
        if (rutaOrigen == null || rutaOrigen.isBlank()) return "";

        Path origen = Paths.get(rutaOrigen);
        if (!Files.exists(origen)) return "";

        Files.createDirectories(getRutaBaseImagenes());

        String nombreArchivoImagen = origen.getFileName().toString();
        String ext = getExtension(nombreArchivoImagen);            // ".png"
        String nombreBase = nombreArchivoImagen;
        if (!ext.isEmpty()) {
            nombreBase = nombreArchivoImagen.substring(0, nombreArchivoImagen.length() - ext.length());
        }
        nombreBase = limpiarCarateresEspeciales (nombreBase);

        Path rutaBase = getRutaBaseImagenes();
        Path destino = rutaBase.resolve(nombreBase + ext);

        // Si existe, genero baseName-1.png, baseName-2.png, etc.
        int i = 1;
        while (Files.exists(destino)) {
            destino = rutaBase.resolve(nombreBase + "-" + i + ext);
            i++;
        }

        Files.copy(origen, destino);
        return destino.toAbsolutePath().toString();
    }
 
        // ========= ICONOS =========
  public static ImageIcon iconoEscalado(String rutaRecurso, int ancho, int alto) {
        URL url = ImagenesHelper.class.getResource(rutaRecurso);
        if (url == null) {
            System.err.println("No se encontró el recurso: " + rutaRecurso);
            return null;
        }

        ImageIcon original = new ImageIcon(url);
        Image escalada = original.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(escalada);
    }

    public static void ponerIconoEscalado(AbstractButton boton, String rutaRecurso, int ancho, int alto) {
        ImageIcon icon = iconoEscalado(rutaRecurso, ancho, alto);
        boton.setIcon(icon);
    }

    // ========= ESTILO BOTON TIPO TARJETA (como tu imagen) =========

    public static void configurarBotonTarjeta(
            JButton boton,
            String texto,
            String rutaIcono,
            int iconW,
            int iconH
    ) {
        boton.setText(texto);

        if (rutaIcono != null && !rutaIcono.isBlank()) {
            ponerIconoEscalado(boton, rutaIcono, iconW, iconH);
        }

        // icono arriba, texto abajo, todo centrado
        boton.setHorizontalAlignment(SwingConstants.CENTER);
        boton.setVerticalAlignment(SwingConstants.CENTER);

        boton.setHorizontalTextPosition(SwingConstants.CENTER);
        boton.setVerticalTextPosition(SwingConstants.BOTTOM);

        boton.setIconTextGap(12);

        // “look pro”: sin bordes feos ni focus pintado
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(true); // dejalo true si querés que se vea el color de fondo
        boton.setOpaque(true);

        // Cursor mano
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    // ========= GRILLA CENTRADA (2 o 3 columnas) =========
    // Esto te permite NO pelearte con GroupLayout: lo reemplazás en runtime.

    public static void armarMenuEnGrilla(
            JPanel panelContenido,
            JButton[] botones,
            int columnas,
            int gapH,
            int gapV,
            int padding
    ) {
        panelContenido.removeAll();

        // Para que se vea el fondo si el panel de atrás está pintando
        panelContenido.setOpaque(false);

        panelContenido.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(gapV / 2, gapH / 2, gapV / 2, gapH / 2);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        // padding externo
        panelContenido.setBorder(new EmptyBorder(padding, padding, padding, padding));

        for (int i = 0; i < botones.length; i++) {
            int fila = i / columnas;
            int col  = i % columnas;

            gbc.gridx = col;
            gbc.gridy = fila;

            // Truco para que la grilla se “distribuya” bien
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;

            panelContenido.add(botones[i], gbc);
        }

        panelContenido.revalidate();
        panelContenido.repaint();
    }

    // ========= TAMAÑO FIJO (opcional) =========
    // Si querés que todas las tarjetas tengan el mismo tamaño, te lo deja consistente.

    public static void setTamanoTarjeta(JButton boton, int w, int h) {
        Dimension d = new Dimension(w, h);
        boton.setPreferredSize(d);
        boton.setMinimumSize(d);
        boton.setMaximumSize(d);
    }
}

