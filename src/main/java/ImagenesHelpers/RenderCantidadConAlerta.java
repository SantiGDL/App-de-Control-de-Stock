package ImagenesHelpers;

import Persistencia.Clases.EstadoAlerta;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import javax.swing.border.Border;

public class RenderCantidadConAlerta extends DefaultTableCellRenderer {

    private final int colEstado;

    // Estado del cell actual (lo guardamos para pintar el círculo)
    private EstadoAlerta estadoActual = EstadoAlerta.GRIS;

    // Ajustes visuales
    private final int diametro = 25;      // tamaño del círculo
    private final int margenDer = 14;     // margen derecho
    private final int gapNumero = 10;     // separación entre número y círculo

    public RenderCantidadConAlerta(int colEstado) {
        this.colEstado = colEstado;

        setOpaque(false); // CLAVE: no pintar fondo completo
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Le damos texto al label (valor)
        setText(value == null ? "" : String.valueOf(value));

        // Traemos el estado desde el modelo
        int modelRow = table.convertRowIndexToModel(row);
        Object estadoObj = table.getModel().getValueAt(modelRow, colEstado);

        estadoActual = (estadoObj instanceof EstadoAlerta)
                ? (EstadoAlerta) estadoObj
                : EstadoAlerta.GRIS;

        // Colores del texto: elegí negro si el fondo zebra es oscuro? (en tu UI blanca no aplica)
        // Como tu zebra es azul oscuro, blanco suele quedar mejor:
        setForeground(Color.WHITE);

        // Si está seleccionada y la tabla tiene foco, dejamos que se note (sin pisar tu estilo)
        // (el fondo lo pinta el zebra renderer; nosotros solo cuidamos que se vea el texto)
        if (isSelected && table.isFocusOwner()) {
            setForeground(table.getSelectionForeground());
        }

        return this;
    }

    @Override
    protected void paintComponent(Graphics g) {
        // NO llamamos super primero, porque queremos controlar el texto + el círculo
        // Igual necesitamos que pinte el texto como JLabel normalmente.
        // Entonces pintamos "como label", pero ajustando el texto para que no choque con el círculo.

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 1) Pintar texto con un "padding" a la derecha (para dejar lugar al círculo)
        //    Truco: temporalmente ajustamos el border para reservar espacio.
        Border old = getBorder();
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, margenDer + diametro + gapNumero));
        super.paintComponent(g2);
        setBorder(old);

        // 2) Pintar círculo a la derecha, centrado vertical
        int w = getWidth();
        int h = getHeight();

        int x = w - margenDer - diametro;
        int y = (h - diametro) / 2;

        Color color = colorPorEstado(estadoActual);

        // borde sutil para que destaque
        g2.setColor(new Color(0, 0, 0, 130));
        g2.fillOval(x - 1, y - 1, diametro + 2, diametro + 2);

        g2.setColor(color);
        g2.fillOval(x, y, diametro, diametro);

        g2.dispose();
    }

    private Color colorPorEstado(EstadoAlerta estado) {
        switch (estado) {
            case ROJO:     return new Color(255, 90, 90);
            case AMARILLO: return new Color(255, 235, 120);
            case VERDE:    return new Color(120, 255, 160);
            case GRIS:
            default:       return new Color(200, 200, 200);
        }
    }
}