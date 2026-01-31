package ImagenesHelpers;

import Persistencia.Clases.EstadoAlerta;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderCantidadConAlerta extends DefaultTableCellRenderer {

    private final int colEstado; // columna (en el modelo) donde viene EstadoAlerta

    public RenderCantidadConAlerta(int colEstado) {
        this.colEstado = colEstado;
        setHorizontalAlignment(SwingConstants.CENTER);
        setOpaque(true); // importante para que pinte el fondo
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // si está seleccionada la fila, no le pises el highlight del look&feel
        if (isSelected) return this;

        // OJO: row/column son "view". Para agarrar la colEstado del modelo, convertimos.
        int modelRow = table.convertRowIndexToModel(row);
        Object estadoObj = table.getModel().getValueAt(modelRow, colEstado);

        EstadoAlerta estado = (estadoObj instanceof EstadoAlerta)
                ? (EstadoAlerta) estadoObj
                : EstadoAlerta.GRIS;

        // Colores (ajustalos a tu estética)
        Color bg;
        Color fg = Color.BLACK;

        switch (estado) {
            case ROJO:
                bg = new Color(255, 110, 110);
                fg = Color.BLACK;
                break;
            case AMARILLO:
                bg = new Color(255, 235, 120);
                fg = Color.BLACK;
                break;
            case VERDE:
                bg = new Color(140, 255, 170);
                fg = Color.BLACK;
                break;
            case GRIS:
            default:
                bg = new Color(210, 210, 210);
                fg = Color.BLACK;
                break;
        }

        setBackground(bg);
        setForeground(fg);

        // por si querés que el número quede más grande/bold:
        // setFont(getFont().deriveFont(java.awt.Font.BOLD, 16f));

        return this;
    }
}