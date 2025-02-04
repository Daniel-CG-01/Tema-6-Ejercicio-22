package tema6Ejercicio022;
import java.util.Scanner;

public class Tema6Ejercicio022 {

static void menu() {
	System.out.println("Introducir un término y su definición en el diccionario (1)");
	System.out.println("Mostrar todos los términos (sin definiciones) (2)");
	System.out.println("Obtener la definición de un término que el usuario introduzca (o no mostrar nada si el término no está en el diccionario) (3)");
	System.out.println("Eliminar un término y su definición (4)");
	System.out.println("Salir (5)");
	System.out.println();
}
	
	public static void main(String[] args) {
	Scanner entrada=new Scanner(System.in);
	Palabra[] diccionario=new Palabra[100];
	
	int opcion;
	int contador=0;
	
	String termino="Mesa";
	String definicion="Mueble para apoyar objetos";
	
	Palabra p=new Palabra(termino, definicion);
	
	do {
		Tema6Ejercicio022.menu();
		
		System.out.print("Selecciona una opción: ");
		opcion=entrada.nextInt();
		
		switch (opcion) {
		case 1:
			System.out.print("Introduce un término: ");
			termino=entrada.next();
			entrada.nextLine();
			
			System.out.print("Introduce su definición: ");
			definicion=entrada.nextLine();
			
			p=new Palabra(termino, definicion);
			diccionario[contador]=p;
			
			contador++;
			
			System.out.println();
			break;
		case 2:
			try {
				for(int i=0; i<contador; i++) {
					System.out.print(diccionario[i].getTermino()+"-");
				}
			} catch (Exception NullPointerException) {
				System.out.println("No hay más términos");
			}
			
			System.out.println();
			break;
		case 3:
			try {
				System.out.println("Introduce el término");
				termino=entrada.next();
				for(Palabra pal:diccionario) {
					if(pal.getTermino().equals(termino)) {
						System.out.println(pal.getTermino()+": "+pal.getDefinicion());
					}
					
				}
			}catch(NullPointerException e) {
				System.out.println();
			}
			break;
		case 4:
			try {
				int eliminada=0;
				System.out.println("Introduce el término");
				termino=entrada.next();
				for(int i=0; i<contador; i++) {
					if(diccionario[i].getTermino().equals(termino)) {
						eliminada=i;
					}
				}
				for(int i=eliminada+1; i<contador; i++) {
					diccionario[i-1]=diccionario[i];
				}
				contador--;

			}catch(NullPointerException e) {
				System.out.println();
			}
			break;
		case 5:
			System.out.println("Fin del programa");
		default:
			System.out.print("Opción no válida. Por favor, selecciona una opción del menu");
		}
	} while (opcion!=5);
	
	}
}