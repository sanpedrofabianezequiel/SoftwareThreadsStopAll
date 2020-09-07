package ThreadsBalls;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class LaminaPelota extends JPanel {

	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();	//Propiedades
	
	//Añadimos la pelota  al arraylist con el siguiente metodo
	public void add(Pelota b) {
		
		pelotas.add(b);
	}
	
	//Utilizamos el metodo de la clase Padre de paintComponente(graphics g)
	public void paintComponent(Graphics g) {
		//Usamos el metodo de la clase padre
		super.paintComponent(g);
		
		//Castemos la Graphics2D
		Graphics2D g2=(Graphics2D) g;
		
		//Pintamos todas las PELOTAS del arraylist con el Foreach
		
		for (Pelota var : pelotas) {
			//Fill rellenamos con el metodo de la clase Pelota obtenemos las pelotas creadas
			g2.fill(var.getShape());	
		}
		
	}
	
	
}
