package ficherosTareas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		 
		Scanner sc =new Scanner (System.in);
		
		int num_frases; //numero de frases a introducir desde la terminal por el usuario
		
		System.out.println("¿Cuántas frases quieres introducir?");
		
		num_frases=sc.nextInt();
		
		sc.nextLine();//Limpiamos buffer
		
		String []frase=new String[num_frases]; //Creamos una array para almacenar las frases
		
		//al trabajar con ficheros es obligatorio trabajar con la estructura de manejo de errores try catch
		
		try(BufferedWriter bw=new BufferedWriter(new FileWriter("ficherosTareas.txt"))){ //Creamos el objeto bw llamando a la clase BufferedWriter y FileWriter 
																       //para escribir en el archivo que se encuentra en la ruta que le pasamos 
																	   //como argumento			
			for(int i=0;i<num_frases;i++) {
				System.out.println("Frase "+(i+1)+":");
				bw.write(frase[i]=sc.nextLine()); //Escribimos en el fichero la frase introducida por teclado
				bw.newLine(); //Salto de linea
			}
		}catch(IOException e) {
			System.out.println("Error1");
		}
		
		//Tenemos las frases introducidas por teclado ya. Ahora queremos que el programa las lea y diga de cuantos caracteres se compone cada una
		
		try(BufferedReader br=new BufferedReader(new FileReader("ficherosTareas.txt"))){//Creamos el objeto br llamando a la clase BufferedReader y FileReader 
		       															//para leer el archivo que se encuentra en la ruta que le pasamos 
																		//como argumento		
			
			
			for(int i=0;i<num_frases;i++) { 
				if((frase[i]=br.readLine())!=null) {//Leemos cada frase mientras que el valor no sea null, lo que significa que ha terminado de leer la linea
				  System.out.println("Frase: "+frase[i]+", tiene "+frase[i].length()+" caracteres");
				}
				
			}
			
		}catch(IOException e) {
			System.out.println("Error2");
		}
		
	}

}
