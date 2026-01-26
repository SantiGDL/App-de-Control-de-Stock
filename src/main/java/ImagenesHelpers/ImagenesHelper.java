package ImagenesHelpers;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
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
 
}
