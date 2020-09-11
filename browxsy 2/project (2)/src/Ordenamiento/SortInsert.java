package Ordenamiento;

import java.util.Arrays;

public class SortInsert {

    public static void main(String[] args) {
        java.util.Scanner lector = new java.util.Scanner(System.in);
        System.out.println("Ingresar numeros del vector separados por coma");
        String numeros = lector.nextLine();
        int[] vector = convertirListaSeparadaPorComaEnArrayDeEnteros(numeros);
        ordenarInsercion(vector);
        System.out.println("Resultado:");
        imprimirVector(vector);
    }
    
    // Implementar la funcion ordenarInsercion para que ordene en forma descedente    
    static void ordenarInsercion(int[] vector) {
    	for(int i=0; i<vector.length; i++) {
    		int guardado=vector[i];
    		for(int j=i; j<vector.length; j++) {
    			if(guardado<vector[j]) {
    				int valor=vector[j];
    				vector[j]=guardado;
    				guardado=valor;
    			}
    	        imprimirVector(vector);

    		}
    		intercambiar(vector,guardado, i);
    	}
    }

    static int[] convertirListaSeparadaPorComaEnArrayDeEnteros(String lista) {
      int[] numeros = Arrays.asList(lista.split(",")).stream()
        .map(String::trim)
        .mapToInt(Integer::parseInt).toArray();    
      return numeros;      
    }
    
    static void imprimirVector(int[] array) {
      for (int i = 0; i < array.length; i++) {
        System.out.print(array[i] + " ");
      }
      System.out.println();
    }

    static void intercambiar(int[] array,int guardado, int i ) {
      array[i] = guardado;
    }

}
