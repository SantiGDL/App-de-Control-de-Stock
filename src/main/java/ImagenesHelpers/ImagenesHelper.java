package ImagenesHelpers;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
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
 
    // =========================================================
    // NUEVO: Fondo escalable desde resources (/Imagenes/...)
    // =========================================================

    /**
     * Envuelve tu panel "contenido" dentro de un panel que dibuja una imagen de fondo
     * escalada al tamaño actual. Ideal para que se vea al maximizar.
     *
     * @param contenido Panel que ya tenés creado (el del cuadro gris).
     * @param resourcePath Ruta del recurso en classpath. Ej: "/Imagenes/fondo_menu.png"
     * @return Un JPanel nuevo con el fondo, que contiene adentro al panel contenido.
     */
    public static JPanel envolverConFondoEscalable(JPanel contenido, String resourcePath) {
        if (contenido == null) throw new IllegalArgumentException("contenido no puede ser null");

        BufferedImage img = cargarImagenDesdeResources(resourcePath);

        JPanel fondo = new JPanel() {

            private Image cache;
            private int cacheW = -1, cacheH = -1;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                if (img == null) return;

                int w = getWidth();
                int h = getHeight();
                if (w <= 0 || h <= 0) return;

                // Cache para no reescalar en cada repintado
                if (cache == null || w != cacheW || h != cacheH) {
                    cache = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
                    cacheW = w;
                    cacheH = h;
                }

                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2.drawImage(cache, 0, 0, w, h, this);
                g2.dispose();
            }
        };

        // Para que el fondo se pinte y el contenido no lo tape:
        fondo.setOpaque(false);
        contenido.setOpaque(false);

        // Mantener el layout del contenido:
        fondo.setLayout(new BorderLayout());
        fondo.add(contenido, BorderLayout.CENTER);

        return fondo;
    }

    private static BufferedImage cargarImagenDesdeResources(String resourcePath) {
        if (resourcePath == null || resourcePath.isBlank()) return null;

        try {
            URL url = ImagenesHelper.class.getResource(resourcePath);
            if (url == null) {
                throw new IllegalArgumentException("No se encontró el recurso: " + resourcePath
                        + " (debería estar en src/main/resources)");
            }
            return ImageIO.read(url);
        } catch (IOException e) {
            throw new RuntimeException("Error cargando imagen: " + resourcePath, e);
        }
    }
}
