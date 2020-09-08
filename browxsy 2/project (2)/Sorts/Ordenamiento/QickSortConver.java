package Ordenamiento;
public class QickSortConver {

  public static void main(String[] args) {
    int[] vector = new int[] { 7, 4, 5, 9, 8, 2, 1 };
    imprimirVector(vector);
    quickSort(vector, 0, vector.length - 1);
  }

  static void quickSort(int vector[], int inicio1, int fin1) {
	  int inicio=inicio1;int fin=fin1;
    if (inicio < fin) {
      int indiceParticion = particionar(vector, inicio, fin);
      //      
      quickSort(vector, inicio, indiceParticion - 1);
      // llamar a quickSort con la sublista derecha
      quickSort(vector, indiceParticion + 1, fin);
    }
  }
  static int particionar(int vector[], int inicio, int fin) {
    int pivote = vector[fin];
    int i = (inicio - 1);
    for (int j = inicio; j < fin; j++) {
      if (vector[j] <= pivote) {
        i++;
        intercambiar(vector, i, j);
        imprimirVector(vector);
      }
    }
    intercambiar(vector, i + 1, fin);
    imprimirVector(vector);
    return i + 1;
  }
  
  
  static void intercambiar(int[] arr, int indice1, int indice2) {
    if (indice1 != indice2) {
      int valorTemporal = arr[indice1];
      arr[indice1] = arr[indice2];
      arr[indice2] = valorTemporal;
    }
  }

  static void imprimirVector(int[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }

}
