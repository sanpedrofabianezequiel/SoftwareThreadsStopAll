package ThreadsBalls;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ThreadsBalls.ThreadsMain;

public class MarcoRebote extends JFrame {

	private LaminaPelota lamina;

	Thread t1,t2,t3;
	JButton start1,start2,start3,stop1,stop2,stop3;
	
	public MarcoRebote() {	//Constructor
		
		setBounds(600, 300, 700, 350);
		setTitle("Rebotes");
		//----------------Lamina que dibuja las pelotas
		lamina=new LaminaPelota();	//	instanciamos la clase LaminaPelota
		
		add(lamina,BorderLayout.CENTER);	//La agregamos al Marco
		
		
		//------------------------------------Agregamos laminas para los botones
		JPanel laminaBotones=new JPanel();
		//Llamamos al metodo para EX-crear botones
		
		start1 =new JButton("Thread 1");
		start1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				iniciarJuego(e);	//Le enviamos el evento Accionador
			}
		});
		
		laminaBotones.add(start1);	//Agregamos el boton a la lamina y luego agregamos la lamina al marco
		//------------
		start2 =new JButton("Thread 2");
		start2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				iniciarJuego(e);		//Le enviamos el evento Accionador
				
			}
		});
		
		laminaBotones.add(start2);	//Agregamos el boton a la lamina y luego agregamos la lamina al marco
		//-----------
		start3 =new JButton("Thread 3");
		start3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				iniciarJuego(e);    //Le enviamos el evento Accionador
				
			}
		});
		
		laminaBotones.add(start3);	//Agregamos el boton a la lamina y luego agregamos la lamina al marco
		//-----------
	
		stop1 =new JButton("Stop 1");
		stop1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				detener(e);
				
			}
		});
		
		laminaBotones.add(stop1);	//Agregamos el boton a la lamina y luego agregamos la lamina al marco
		//---------------
		stop2 =new JButton("Stop 2");
		stop2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				detener(e);
				
			}
		});
		
		laminaBotones.add(stop2);	//Agregamos el boton a la lamina y luego agregamos la lamina al marco
		//----------------
		stop3 =new JButton("Stop 3");
		stop3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				detener(e);
			}
		});
		
		laminaBotones.add(stop3);	//Agregamos el boton a la lamina y luego agregamos la lamina al marco		
		
		
	
		add(laminaBotones,BorderLayout.SOUTH);	//Ponemos la lamina en la parte sur
	}
	
	
	
	
	
	//--------------------------------------METODO PARA PONER BOTONES

	
	//--------------------------------------METODO PARA INICIAR el Juego
	
	
	
	
	
	
	
	//---------------------
	public void iniciarJuego(ActionEvent e) {//Recibo el evento disparador
		Pelota pelota= new Pelota();
		//Agregamos a la lamina  la nueva pelota
		lamina.add(pelota);
		
		
		//Creamos una isntancia de la CLASE que implementa la interfaz Runnable
		//La intanciamos dentro de una Runnable ya que Que esta clase la implenta POLIMORFIMOS
		
		Runnable r=	new pelotaThread(pelota, lamina);
		
		//--------------Constructores de la cas Thread (Runnable)
		//Usamos el metodo start de la clase Thread que recibe un parametro del tipo URNNABLE
		
		//Determinamos que evento fue el Disparador
		
		if(e.getSource().equals(start1)) {	//Le enviamos el Nombre de la instancia
			//Creamos una nueva isntancia de la pelota
			t1=new Thread(r);
			t1.start();
		}else if (e.getSource().equals(start2)) {
			t2 = new Thread (r);
			t2.start();
		}else if (e.getSource().equals(start3)) {
			t3 = new Thread (r);
			t3.start();
		}
	}
	
	
	
	public void detener(ActionEvent e) {//NECESITAMOS DECLARAR COMO GLOBAL LA VARIABLE T DEL TIPO THREAD
			//Como el metodo RUN de la clase que implementa el Runnable tiene un Sleep
			//Lanza una excepcion ya que no se pude Interrupir un bloqueo
			//En esta excepcion podemos usar el metodo interrumpir parar detenerlo cuando sale la excepcion
		//t.stop();
		if (e.getSource().equals(stop1)) {
			t1.interrupt();
		}else if (e.getSource().equals(stop2)) {
			t2.interrupt();
		}else if (e.getSource().equals(stop3)) {
			t3.interrupt();
		}
		
		
		
		
		
	}
	
}





