package ThreadsBalls;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Pelota {

	///Aca configuraremos y diseñaremos la pelota 
	//Propiedades necesarias
	private double x=0;
	private double y=0;
	private double dx=1;
	private double dy=1;
	
	private static final int TAMX=15;	//Tamaños maximo de la pelota
	private static final int TAMY=15;//Tamaños maximo de la pelota
	
	//------------Formamos la pelota en su POSICION INICIAL
	
	public Ellipse2D getShape() {	//Retornamos una pelota nueva//Metodo
		return new Ellipse2D.Double(x, y, TAMX, TAMY);
	}
	
	//-------------Creamos el Movimiento
		//Recibimos 
	public void muevePelota(Rectangle2D limites) {	//Cuando choca con los bordes del Marco/Lamina
		//Movemos las cordenadas segund el DeltaX/Y
		//Cada vez que es llamado en el ForEach
		
		x += dx;
		y += dy;
		
		//----------Setiamos EJE X
		if(x<limites.getMinX()) {	//Lado izquierdo
			x=limites.getMinX();	//Setiamos el limite izquierdo
			dx= -dx;//Invertimos el orden de X (Rebote)
		}
		if (x +TAMX >= limites.getMaxX()) {	//Lado derecho
			x=limites.getMaxX()- TAMX;	//Setiamos el limite derecho
			dx=-dx;
		}
		//----------Setiamos EJE Y
		if (y<limites.getMinY()) { //Lado superior
			y=limites.getMinY();	//Setiamos el limite superior
			dy= -dy;				//Invertimos el orde Y Rebote
		}
		if(y >= limites.getMaxY()) {
			y=limites.getMaxY() - TAMY;	//Setiamos el limite inferior
			dy=-dy;					//Invertimos el orden
		}
	
		
		
	}
	
	
}
