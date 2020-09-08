package Ordenamiento;

public class qickSortLara {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] v = new int[] {2,4,3,7,9,8,1};
	    imprimirVector(v);
	   // int quiebre=comparacion(v, 0, v.length - 1, 2, v[0]);
	    quickSort(v, 0, v.length - 1 );
	}
	
	static void quickSort(int[]v, int izq, int d) {
		int rsta;
		int pivote=v[izq];
		int direccion=2;
		rsta=comparacion(v, izq, d, direccion, pivote);

		if(izq<d) {
			if(rsta>=0) {
				System.out.println("izq " + izq + " d " + d);
				int d1=rsta-1;
				if(izq<d1) {quickSort(v, izq, d1);}
				quickSort(v, rsta+1, v.length-1);
			}
		}
	}
	
	static int comparacion(int[]v, int izq, int d, int direccion, int pivote){
		int rsta=0;
		if(izq==d ) {
			v[izq]=pivote;
			imprimirVector(v);
			rsta=izq;
			//devuelve el punto de union.
			return rsta;
		}
		//direccion 2 es: segui comparando en izquierda;
		if(d!=izq) {
			if(direccion==2) {
				if(v[d]<pivote) {
					v[izq]=v[d];
					System.out.println( "direccion 2;" +  direccion);
					imprimirVector(v);
					izq++;
					System.out.println(" Izq++ "+ izq + d);
					rsta=comparacion(v, izq, d, 1, pivote);
				}else {
					imprimirVector(v);
					d--;
					rsta=comparacion(v, izq, d, 2, pivote);
				}
			}
			//direccion 1 es: segui comparando en derecha;
			if(direccion==1 && d!=izq){
				if(v[izq]>pivote) {
					v[d]=v[izq];
					d--;
					rsta=comparacion(v, izq, d, 2, pivote);
					imprimirVector(v);
				}else {
					imprimirVector(v);
					izq++;
					rsta=comparacion(v, izq, d, 1, pivote);
				}
			}
		}
		return rsta;
	}
	
	static void imprimirVector(int[] array) {
	    for (int i = 0; i < array.length; i++) {
	      System.out.print(array[i] + " ");
	    }
	    System.out.println();
	  }

}
