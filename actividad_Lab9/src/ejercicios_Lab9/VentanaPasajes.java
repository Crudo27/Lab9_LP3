package ejercicios_Lab9;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

/** Ejercicio 2: formulario de compra de pasajes de transporte terrestre. */
public class VentanaPasajes extends JFrame {
    private final JTextField txtNombres = new JTextField(24);
    private final JTextField txtDocumento = new JTextField(24);
    private final JTextField txtFecha = new JTextField(24);

    private final JComboBox<String> cmbOrigen = new JComboBox<>(new String[] {
            "Seleccione origen", "Arequipa", "Lima", "Cusco", "Tacna", "Puno", "Moquegua"
    });
    private final JComboBox<String> cmbDestino = new JComboBox<>(new String[] {
            "Seleccione destino", "Arequipa", "Lima", "Cusco", "Tacna", "Puno", "Moquegua"
    });

    private final JRadioButton rbPrimerPiso = new JRadioButton("Primer piso");
    private final JRadioButton rbSegundoPiso = new JRadioButton("Segundo piso");
    private final JCheckBox chkAudifonos = new JCheckBox("Audífonos");
    private final JCheckBox chkManta = new JCheckBox("Manta");
    private final JCheckBox chkRevistas = new JCheckBox("Revistas");

    private final JList<String> listaServicios = new JList<>(new String[] {
            "Económico", "Standard", "VIP"
    });
    private final JButton btnResumen = new JButton("Mostrar resumen");
    private final JButton btnLimpiar = new JButton("Reiniciar formulario");

    public VentanaPasajes() {
        super("Compra de pasajes - Transporte Santa María");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(790, 665);
        setMinimumSize(new java.awt.Dimension(680, 590));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("REGISTRO DE COMPRA DE PASAJES", SwingConstants.CENTER);
        titulo.setFont(titulo.getFont().deriveFont(java.awt.Font.BOLD, 19f));
        titulo.setBorder(BorderFactory.createEmptyBorder(18, 6, 8, 6));
        add(titulo, BorderLayout.NORTH);

        JPanel formulario = new JPanel(new GridBagLayout());
        formulario.setBorder(BorderFactory.createTitledBorder("Información del pasajero y viaje"));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(8, 12, 8, 12);
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;

        agregarFila(formulario, c, 0, "Nombres y apellidos:", txtNombres);
        agregarFila(formulario, c, 1, "Documento de identidad:", txtDocumento);
        txtFecha.setToolTipText("Formato dd/MM/aaaa; ejemplo: 20/11/2026");
        agregarFila(formulario, c, 2, "Fecha de viaje (dd/MM/aaaa):", txtFecha);
        agregarFila(formulario, c, 3, "Ciudad de origen:", cmbOrigen);
        agregarFila(formulario, c, 4, "Ciudad de destino:", cmbDestino);

        ButtonGroup grupoPiso = new ButtonGroup();
        grupoPiso.add(rbPrimerPiso);
        grupoPiso.add(rbSegundoPiso);
        JPanel panelPiso = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        panelPiso.add(rbPrimerPiso);
        panelPiso.add(rbSegundoPiso);
        agregarFila(formulario, c, 5, "Ubicación del asiento:", panelPiso);

        JPanel panelExtras = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        panelExtras.add(chkAudifonos);
        panelExtras.add(chkManta);
        panelExtras.add(chkRevistas);
        agregarFila(formulario, c, 6, "Servicios adicionales:", panelExtras);

        listaServicios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaServicios.setVisibleRowCount(3);
        JScrollPane scrollServicios = new JScrollPane(listaServicios);
        agregarFila(formulario, c, 7, "Calidad de servicio:", scrollServicios);
        add(formulario, BorderLayout.CENTER);

        JPanel inferior = new JPanel();
        inferior.setLayout(new BoxLayout(inferior, BoxLayout.Y_AXIS));
        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 9));
        acciones.add(btnResumen);
        acciones.add(btnLimpiar);
        inferior.add(acciones);
        JLabel aclaracion = new JLabel("Simulación académica: no realiza pagos ni reservas.", SwingConstants.CENTER);
        aclaracion.setAlignmentX(CENTER_ALIGNMENT);
        inferior.add(aclaracion);
        inferior.setBorder(BorderFactory.createEmptyBorder(0, 10, 12, 10));
        add(inferior, BorderLayout.SOUTH);

        btnResumen.addActionListener(e -> mostrarResumen());
        btnLimpiar.addActionListener(e -> reiniciarFormulario());
    }

    private void agregarFila(JPanel panel, GridBagConstraints c,
                            int fila, String etiqueta, java.awt.Component componente) {
        c.gridx = 0;
        c.gridy = fila;
        c.weightx = 0;
        panel.add(new JLabel(etiqueta), c);
        c.gridx = 1;
        c.weightx = 1;
        panel.add(componente, c);
    }

    private void mostrarResumen() {
        try {
            Pasaje pasaje = construirPasaje();
            JOptionPane.showMessageDialog(this, pasaje.generarResumen(),
                    "Resumen del pasaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalArgumentException error) {
            JOptionPane.showMessageDialog(this, error.getMessage(),
                    "Datos incompletos o inválidos", JOptionPane.WARNING_MESSAGE);
        }
    }

    private Pasaje construirPasaje() {
        String nombre = txtNombres.getText().trim();
        String documento = txtDocumento.getText().trim();
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("Ingrese los nombres y apellidos del pasajero.");
        }
        if (!documento.matches("[0-9]{8}")) {
            throw new IllegalArgumentException("El documento debe contener ocho dígitos (DNI).");
        }

        LocalDate fecha;
        try {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/uuuu")
                    .withResolverStyle(ResolverStyle.STRICT);
            fecha = LocalDate.parse(txtFecha.getText().trim(), formato);
        } catch (DateTimeParseException error) {
            throw new IllegalArgumentException("La fecha debe ser válida y usar dd/MM/aaaa.");
        }
        if (fecha.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de viaje no puede ser anterior a hoy.");
        }

        if (cmbOrigen.getSelectedIndex() == 0 || cmbDestino.getSelectedIndex() == 0) {
            throw new IllegalArgumentException("Seleccione las ciudades de origen y destino.");
        }
        String origen = (String) cmbOrigen.getSelectedItem();
        String destino = (String) cmbDestino.getSelectedItem();
        if (origen.equals(destino)) {
            throw new IllegalArgumentException("El origen y el destino deben ser diferentes.");
        }
        if (!rbPrimerPiso.isSelected() && !rbSegundoPiso.isSelected()) {
            throw new IllegalArgumentException("Indique si desea viajar en el primer o segundo piso.");
        }
        if (listaServicios.getSelectedValue() == null) {
            throw new IllegalArgumentException("Seleccione la calidad de servicio.");
        }

        List<String> adicionales = new ArrayList<>();
        if (chkAudifonos.isSelected()) adicionales.add("Audífonos");
        if (chkManta.isSelected()) adicionales.add("Manta");
        if (chkRevistas.isSelected()) adicionales.add("Revistas");

        return new Pasaje(nombre, documento, fecha, origen, destino,
                rbPrimerPiso.isSelected() ? "Primer piso" : "Segundo piso",
                listaServicios.getSelectedValue(), adicionales);
    }

    private void reiniciarFormulario() {
        txtNombres.setText("");
        txtDocumento.setText("");
        txtFecha.setText("");
        cmbOrigen.setSelectedIndex(0);
        cmbDestino.setSelectedIndex(0);
        rbPrimerPiso.setSelected(false);
        rbSegundoPiso.setSelected(false);
        chkAudifonos.setSelected(false);
        chkManta.setSelected(false);
        chkRevistas.setSelected(false);
        listaServicios.clearSelection();
        txtNombres.requestFocusInWindow();
    }
}