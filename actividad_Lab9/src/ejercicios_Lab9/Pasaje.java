package ejercicios_Lab9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/** Datos de una solicitud de pasaje. Es un modelo en memoria, sin persistencia. */
public class Pasaje {
    private final String pasajero;
    private final String documento;
    private final LocalDate fecha;
    private final String origen;
    private final String destino;
    private final String piso;
    private final String servicio;
    private final List<String> adicionales;

    public Pasaje(String pasajero, String documento, LocalDate fecha,
                  String origen, String destino, String piso,
                  String servicio, List<String> adicionales) {
        this.pasajero = pasajero;
        this.documento = documento;
        this.fecha = fecha;
        this.origen = origen;
        this.destino = destino;
        this.piso = piso;
        this.servicio = servicio;
        this.adicionales = List.copyOf(adicionales);
    }

    /** Genera el texto que se muestra en JOptionPane. */
    public String generarResumen() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String extras = adicionales.isEmpty()
                ? "Ninguno" : String.join(", ", adicionales);

        return "RESUMEN DE COMPRA DE PASAJE\n"
                + "----------------------------------------\n"
                + "Pasajero: " + pasajero + "\n"
                + "Documento: " + documento + "\n"
                + "Fecha de viaje: " + fecha.format(formato) + "\n"
                + "Origen: " + origen + "\n"
                + "Destino: " + destino + "\n"
                + "Ubicación: " + piso + "\n"
                + "Servicio: " + servicio + "\n"
                + "Adicionales: " + extras + "\n"
                + "----------------------------------------\n"
                + "Solicitud ingresada (simulación).";
    }
}