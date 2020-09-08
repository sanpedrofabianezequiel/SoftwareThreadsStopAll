package ThreadsBalls;

import java.awt.Component;

import javax.swing.JFrame;

public class ThreadsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoRebote miMarco=new MarcoRebote();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
		
		
	}

}

class pelotaThread implements Runnable{

	private Pelota pelota;
	private Component componente;
	
	public  pelotaThread(Pelota miPelota,Component miComponente) {	//Constructor
		this.pelota=miPelota;
		this.componente=miComponente;
	}	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		
		//Repetimos est eproceso 3000veces
		
		
		
				//for (int i = 1; i <3000; i++) {	//La lamina es la creada en el CENTER para 
					
				//while(!Thread.interrupted()) {//Mientras no se interrupa se repeti el bucle
				while(!Thread.currentThread().isInterrupted()) {//Devuelve la REFERNCIA DEL HILO QUE SE ESTA EJECUTANDO	
					
					pelota.muevePelota(componente.getBounds());//Cuando choca con los bordes del Marco/Lamina// Le enviamos el MARCO/LAMINA
					componente.paint(componente.getGraphics());//Retorna el componente dibujado
					
					//Sleep para el for y crear un delay
					
					try {
						Thread.sleep(4);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						System.out.println("Se produzco una interrupcion global");
						//Thread.interrupted();
						Thread.currentThread().interrupt();
					}
					
				}
	}
	
	
}