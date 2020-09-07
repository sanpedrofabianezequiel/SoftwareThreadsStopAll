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
	
	public MarcoRebote() {	//Constructor
		
		setBounds(600, 300, 400, 350);
		setTitle("Rebotes");
		//----------------Lamina que dibuja las pelotas
		lamina=new LaminaPelota();	//	instanciamos la clase LaminaPelota
		
		add(lamina,BorderLayout.CENTER);	//La agregamos al Marco
		
		
		//------------------------------------Agregamos laminas para los botones
		JPanel laminaBotones=new JPanel();
		//Llamamos al metodo para crear botones
		ponerBotones(laminaBotones, "Iniciar", new ActionListener() {//Ponemos el metodo que Inicia
			
			@Override
			public void actionPerformed(ActionEvent e) {
				iniciarJuego();
				
			}
		});
		
		ponerBotones(laminaBotones, "Stop ultimo Hilo", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				detener();
			}
		});
		ponerBotones(laminaBotones, "Salir", new ActionListener() {//Ponemos el metodo Exit
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	//Salir del sistema
			}
		});

		add(laminaBotones,BorderLayout.SOUTH);	//Ponemos la lamina en la parte sur
	}
	
	
	
	
	
	//--------------------------------------METODO PARA PONER BOTONES
		//Container= lamina donde estoy/trabajar
	public void ponerBotones(Container c,String titulo, ActionListener oyente) {
		JButton boton= new  JButton(titulo);
		//----Agregamos el boton a la LAMINA/MARCO/CONTAINER
		c.add(boton);
		//----Ponemos a la escucha el boton
		boton.addActionListener(oyente);
	}
	
	
	
	//--------------------------------------METODO PARA INICIAR el Juego
	
	
	
	Thread t;
	
	
	
	
	//---------------------
	public void iniciarJuego() {
		Pelota pelota= new Pelota();
		//Agregamos a la lamina  la nueva pelota
		lamina.add(pelota);
		
		
		//Creamos una isntancia de la CLASE que implementa la interfaz Runnable
		//La intanciamos dentro de una Runnable ya que Que esta clase la implenta POLIMORFIMOS
		
		Runnable r=	new pelotaThread(pelota, lamina);
		
		//--------------Constructores de la cas Thread (Runnable)
		//Usamos el metodo start de la clase Thread que recibe un parametro del tipo URNNABLE
		 t=new Thread(r);
		t.start();
		
	}
	
	
	
	public void detener() {//NECESITAMOS DECLARAR COMO GLOBAL LA VARIABLE T DEL TIPO THREAD
			//Como el metodo RUN de la clase que implementa el Runnable tiene un Sleep
			//Lanza una excepcion ya que no se pude Interrupir un bloqueo
			//En esta excepcion podemos usar el metodo interrumpir parar detenerlo cuando sale la excepcion
		//t.stop();
		t.interrupt();//Lanzamos la exepcion y en el catch ponemos la interrupcion
		
	}
	
}





