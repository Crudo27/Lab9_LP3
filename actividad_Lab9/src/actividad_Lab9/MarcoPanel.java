package actividad_Lab9;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class MarcoPanel extends JFrame {

    private final JPanel panelBotones; // panel que contiene los botones
    private final JButton[] botones;

    // constructor sin argumentos
    public MarcoPanel() {
        super("Gian Piero Khalil Rodríguez Fádel");

        botones = new JButton[3];
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, botones.length));

        botones[0] = new JButton("FlowLayout");
        botones[1] = new JButton("BorderLayout");
        botones[2] = new JButton("GridLayout");
        
        panelBotones.add(botones[0]);
        panelBotones.add(botones[1]);
        panelBotones.add(botones[2]);
        
        botones[0].addActionListener(e -> 
        {
                    JFrame NuevaVentana = new JFrame("FlowLayout");
        	
                    NuevaVentana.setLayout(new FlowLayout());
        	
                    NuevaVentana.add(new JButton("Botón 1"));
                    NuevaVentana.add(new JButton("Botón 2"));
                    NuevaVentana.add(new JButton("Botón 3"));
                    NuevaVentana.add(new JButton("Botón 4"));
                    NuevaVentana.add(new JButton("Botón 5"));
                    NuevaVentana.add(new JButton("Botón 6"));
        	
                    NuevaVentana.setSize(400,300);
                    NuevaVentana.setLocationRelativeTo(null);
                    NuevaVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    NuevaVentana.setVisible(true);    	
        });
        
        botones[1].addActionListener(e -> 
        {
                    JFrame NuevaVentana = new JFrame("BorderLayout");
        	
                    NuevaVentana.setLayout(new BorderLayout());
        	
                    NuevaVentana.add(new JButton("Botón 1"), BorderLayout.NORTH);
                    NuevaVentana.add(new JButton("Botón 2"), BorderLayout.SOUTH);
                    NuevaVentana.add(new JButton("Botón 3"), BorderLayout.EAST);
                    NuevaVentana.add(new JButton("Botón 4"), BorderLayout.WEST);
                    NuevaVentana.add(new JButton("Botón 5"), BorderLayout.CENTER);
        	
                    NuevaVentana.setSize(400,300);
                    NuevaVentana.setLocationRelativeTo(null);
                    NuevaVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    NuevaVentana.setVisible(true);    	
        });
        
        botones[2].addActionListener(e -> 
        {
                    JFrame NuevaVentana = new JFrame("GridLayout");
        	
                    NuevaVentana.setLayout(new GridLayout(2,3));
        	
                    NuevaVentana.add(new JButton("Botón 1"));
                    NuevaVentana.add(new JButton("Botón 2"));
                    NuevaVentana.add(new JButton("Botón 3"));
                    NuevaVentana.add(new JButton("Botón 4"));
                    NuevaVentana.add(new JButton("Botón 5"));
        	
                    NuevaVentana.setSize(400,300);
                    NuevaVentana.setLocationRelativeTo(null);
                    NuevaVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    NuevaVentana.setVisible(true);    	
        });


        add(panelBotones, BorderLayout.NORTH); // agrega el panel a JFrame
    }
} // fin de la clase MarcoPanel