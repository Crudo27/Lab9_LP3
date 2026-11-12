package ejercicios_Lab9;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/** Punto de entrada del ejercicio 2 del Laboratorio 09. */
public class AppPasajes {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                for (UIManager.LookAndFeelInfo estilo : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(estilo.getName())) {
                        UIManager.setLookAndFeel(estilo.getClassName());
                        break;
                    }
                }
            } catch (Exception ex) {
                System.err.println("Apariencia predeterminada: " + ex.getMessage());
            }
            new VentanaPasajes().setVisible(true);
        });
    }
}