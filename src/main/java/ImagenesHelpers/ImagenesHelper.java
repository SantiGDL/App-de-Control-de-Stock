package ImagenesHelpers;
import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.FontMetrics;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
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
    public static ImageIcon iconoTintado(String rutaRecurso, Color color, int w, int h) {
    try {
        URL url = ImagenesHelper.class.getResource(rutaRecurso);
        if (url == null) {
            System.err.println("No se encontró el recurso: " + rutaRecurso);
            return null;
        }

        BufferedImage src = ImageIO.read(url);

        // Escalado suave primero
        Image scaled = src.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        img.getGraphics().drawImage(scaled, 0, 0, null);

        // Tintado: conserva ALPHA del pixel original
        BufferedImage out = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        int tr = color.getRed(), tg = color.getGreen(), tb = color.getBlue();

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int argb = img.getRGB(x, y);
                int a = (argb >>> 24) & 0xFF;

                // Si el pixel es transparente, lo dejamos
                if (a == 0) {
                    out.setRGB(x, y, 0x00000000);
                    continue;
                }

                // Nuevo color, mismo alpha
                int newArgb = (a << 24) | (tr << 16) | (tg << 8) | tb;
                out.setRGB(x, y, newArgb);
            }
        }

        return new ImageIcon(out);
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
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
        // Icono blanco:
        boton.setIcon(iconoTintado(rutaIcono, Color.WHITE, iconW, iconH));
    }

    boton.setHorizontalAlignment(SwingConstants.CENTER);
    boton.setVerticalAlignment(SwingConstants.CENTER);
    boton.setHorizontalTextPosition(SwingConstants.CENTER);
    boton.setVerticalTextPosition(SwingConstants.BOTTOM);
    boton.setIconTextGap(12);

    boton.setFocusPainted(false);
    boton.setBorderPainted(false);
    boton.setContentAreaFilled(true);
    boton.setOpaque(true);
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
    private static Icon escalarIcon(Icon icon, int w, int h) {
    if (icon == null) return null;

    if (icon instanceof ImageIcon) {
        Image img = ((ImageIcon) icon).getImage();
        Image scaled = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);
    }

    // Si no es ImageIcon, lo renderizo a BufferedImage y lo escalo igual
    BufferedImage bi = new BufferedImage(
            icon.getIconWidth(), icon.getIconHeight(),
            BufferedImage.TYPE_INT_ARGB
    );
    Graphics2D g2 = bi.createGraphics();
    icon.paintIcon(null, g2, 0, 0);
    g2.dispose();

    Image scaled = bi.getScaledInstance(w, h, Image.SCALE_SMOOTH);
    return new ImageIcon(scaled);
}
public static void estilizarBotonMenuLateral(
        JButton boton,
        String texto,
        Icon icono,
        Color colorBase,
        Color colorHover,
        Color colorTexto
) {
    // ====== AJUSTES CLAVE ======
    final int altoBoton = 35;
    final int tamIcono  = 25;
    final int paddingIzq = 8;
    final int separacionTexto = 12;

    // ====== ICON BG (estilo referencia) ======
    final int iconBgPad = 4;        // margen dentro del fondo del icono
    final int iconBgRound = 10;     // redondeo
    final float iconBgDarkNormal = 0.20f; // 20% más oscuro (suave)
    final float iconBgDarkHover  = 0.30f; // 30% más oscuro (hover)

    boton.setText(texto);
    boton.setIcon(escalarIcon(icono, tamIcono, tamIcono));
    boton.setForeground(colorTexto);

    // Altura fija (ancho lo maneja el layout)
    boton.setPreferredSize(new Dimension(Short.MAX_VALUE, altoBoton));
    boton.setMinimumSize(new Dimension(0, altoBoton));
    boton.setMaximumSize(new Dimension(Integer.MAX_VALUE, altoBoton));

    // Quitar look default
    boton.setOpaque(false);
    boton.setContentAreaFilled(false);
    boton.setBorderPainted(false);
    boton.setFocusPainted(false);
    boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    boton.setHorizontalAlignment(SwingConstants.LEFT);
    boton.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));

    // Guardamos colores y estado hover
    boton.putClientProperty("ml.normal", colorBase);
    boton.putClientProperty("ml.hover", colorHover);
    boton.putClientProperty("ml.hovered", false);

    // Hover listener (evita duplicados)
    for (var l : boton.getMouseListeners()) boton.removeMouseListener(l);
    boton.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override public void mouseEntered(java.awt.event.MouseEvent e) {
            boton.putClientProperty("ml.hovered", true);
            boton.repaint();
        }
        @Override public void mouseExited(java.awt.event.MouseEvent e) {
            boton.putClientProperty("ml.hovered", false);
            boton.repaint();
        }
    });

    boton.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
        @Override
        public void paint(Graphics g, JComponent c) {
            JButton b = (JButton) c;
            Graphics2D g2 = (Graphics2D) g.create();

            // IMPORTANTE: aseguramos alpha 100% sólido
            g2.setComposite(AlphaComposite.SrcOver.derive(1f));

            // Anti alias para texto (lindo)
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int w = b.getWidth();
            int h = b.getHeight();

            Color normal = (Color) b.getClientProperty("ml.normal");
            Color hover  = (Color) b.getClientProperty("ml.hover");
            boolean hovered = Boolean.TRUE.equals(b.getClientProperty("ml.hovered"));

            Color fondoBoton = hovered ? hover : normal;

            // 1) Fondo del botón (sólido)
            g2.setColor(fondoBoton);
            g2.fillRect(0, 0, w, h);

            // 2) Fondo detrás del icono (sólido, sin "semi transparencia visual")
            Icon ic = b.getIcon();
            int xIcono = paddingIzq;

            if (ic != null) {
                int yIcono = (h - ic.getIconHeight()) / 2;

                int bgX = xIcono - iconBgPad;
                int bgY = yIcono - iconBgPad;
                int bgW = ic.getIconWidth() + iconBgPad * 2;
                int bgH = ic.getIconHeight() + iconBgPad * 2;

                Color iconBg = hovered
                        ? oscurecerSolido(fondoBoton, iconBgDarkHover)
                        : oscurecerSolido(fondoBoton, iconBgDarkNormal);

                // Para que el borde redondeado NO se vea "mezclado"
                Object oldAA = g2.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

                g2.setColor(iconBg);
                g2.fillRoundRect(bgX, bgY, bgW, bgH, iconBgRound, iconBgRound);

                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, oldAA);

                // 3) Icono encima
                ic.paintIcon(b, g2, xIcono, yIcono);
            }

            // 4) Texto
            String t = b.getText();
            if (t != null && !t.isBlank()) {
                g2.setColor(b.getForeground());
                g2.setFont(b.getFont());
                FontMetrics fm = g2.getFontMetrics();

                int anchoIcono = (ic != null) ? ic.getIconWidth() : 0;
                int xTexto = xIcono + anchoIcono + separacionTexto;
                int yTexto = (h + fm.getAscent() - fm.getDescent()) / 2;

                g2.drawString(t, xTexto, yTexto);
            }

            g2.dispose();
        }
    });

    boton.repaint();
}

/**
 * Oscurece "definido" mezclando con negro, SIEMPRE sólido (alpha 255).
 * cuanto: 0..1 (0 = igual, 0.14 = 14% más oscuro).
 */
private static Color oscurecerSolido(Color c, float cuanto) {
    cuanto = Math.max(0f, Math.min(1f, cuanto));
    int r = Math.round(c.getRed()   * (1f - cuanto));
    int g = Math.round(c.getGreen() * (1f - cuanto));
    int b = Math.round(c.getBlue()  * (1f - cuanto));
    return new Color(r, g, b);
}
    
    public static void aplicarHoverOscuro(JButton boton, double factorOscurecer) {
    // Guardamos el color base UNA sola vez
    Color base = boton.getBackground();
    boton.putClientProperty("hover.base", base);
    boton.putClientProperty("hover.factor", factorOscurecer);

    // Evitar duplicados si llamás esto varias veces

    boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    boton.setOpaque(true);
    boton.setContentAreaFilled(true);

    boton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            Color base = (Color) boton.getClientProperty("hover.base");
            double factor = (double) boton.getClientProperty("hover.factor");
            boton.setBackground(oscurecer(base, factor));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            Color base = (Color) boton.getClientProperty("hover.base");
            boton.setBackground(base);
        }
    });
}

private static Color oscurecer(Color c, double factor) {
    // factor 0.65 = bastante más oscuro
    int r = (int) Math.max(0, Math.min(255, c.getRed()   * factor));
    int g = (int) Math.max(0, Math.min(255, c.getGreen() * factor));
    int b = (int) Math.max(0, Math.min(255, c.getBlue()  * factor));
    return new Color(r, g, b);
}
// ==========================
//  ESTILO REUSABLE DE TABLAS
// ==========================

public static void estilizarTablaGaming(
        JTable table,
        JScrollPane scroll,
        int rowHeight,
        int colImagen,
        TableCellRenderer rendererImagen,
        boolean zebra,
        int... columnasNoTocar
) {
    // --- scroll ---
    scroll.setBorder(null);
    scroll.getViewport().setOpaque(false);
    scroll.setOpaque(false);

    // --- tabla base ---
    table.setOpaque(false);
    table.setShowGrid(false);
    table.setIntercellSpacing(new Dimension(0, 0));
    table.setRowHeight(rowHeight);
    table.setFillsViewportHeight(true);

    // Fuente general (celdas)
    table.setFont(new Font("Segoe UI", Font.PLAIN, 16)); // ⬅ más grande
    table.setForeground(Color.WHITE);

    table.setSelectionBackground(new Color(0, 160, 255, 120));
    table.setSelectionForeground(Color.WHITE);

    // --- header ---
    JTableHeader header = table.getTableHeader();
    header.setFont(new Font("Segoe UI Black", Font.PLAIN, 16)); // ⬅ más grande
    header.setForeground(Color.WHITE);
    header.setBackground(Color.BLUE);
    //header.setBackground(new Color(0, 102, 255));
    header.setOpaque(true);
    header.setReorderingAllowed(false);
    header.setPreferredSize(new Dimension(0, 42)); // ⬅ más alto

    // 🔥 Header centrado
    DefaultTableCellRenderer headerCenter = (DefaultTableCellRenderer) header.getDefaultRenderer();
    headerCenter.setHorizontalAlignment(SwingConstants.CENTER);

    // --- aseguramos renderer imagen ---
    if (colImagen >= 0 && rendererImagen != null) {
        table.getColumnModel().getColumn(colImagen).setCellRenderer(rendererImagen);
    }

    if (!zebra) return;

    // --- zebra renderer base (celdas centradas) ---
    DefaultTableCellRenderer zebraRenderer = new DefaultTableCellRenderer() {
        final Color filaA = new Color(0, 60, 140, 120);
        final Color filaB = new Color(0, 90, 190, 120);

        {
            setHorizontalAlignment(SwingConstants.CENTER); // 🔥 celdas centradas
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable t, Object v, boolean isSelected, boolean hasFocus, int row, int col) {

            super.getTableCellRendererComponent(t, v, isSelected, hasFocus, row, col);

            boolean foco = t.isFocusOwner();

            setOpaque(true);
            setForeground(Color.WHITE);
            setBackground((row % 2 == 0) ? filaA : filaB);

            // 🔥 fuerza tamaño (por si otro renderer cambia fuente)
            setFont(new Font("Segoe UI", Font.PLAIN, 16));

            if (isSelected && foco) {
                setBackground(t.getSelectionBackground());
                setForeground(t.getSelectionForeground());
            }
            return this;
        }
    };

    // --- columnas protegidas ---
    java.util.Set<Integer> noTocar = new java.util.HashSet<>();
    if (columnasNoTocar != null) {
        for (int c : columnasNoTocar) noTocar.add(c);
    }
    noTocar.add(colImagen);

    for (int c = 0; c < table.getColumnCount(); c++) {
        if (noTocar.contains(c)) continue; // no pisar renderers especiales
        table.getColumnModel().getColumn(c).setCellRenderer(zebraRenderer);
    }
}
}

