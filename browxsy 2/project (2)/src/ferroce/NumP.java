package ferroce;

import java.util.Arrays;

public class NumP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 java.util.Scanner lector = new java.util.Scanner(System.in);
	        System.out.println("Ingresar numeros del vector separados por coma");
	        String numeros = lector.nextLine();
	        int[] vector = toArray(numeros);
	        NumPpA prueba1=new NumPpA(vector);
	        prueba1.ordenarV();
	        prueba1.setVP();
	        prueba1.imprimirV();
	        prueba1.imprimirVP();

	}

	public static int[] toArray(String lista){
		 int[] numeros = Arrays.asList(lista.split(",")).stream()
			        .map(String::trim)
			        .mapToInt(Integer::parseInt).toArray();    
			      return numeros;		
	}
}

class NumPpA{
	
		int []v;
		int []vP;
		
		public NumPpA(int [] v) {
			this.v=v;
			this.vP=new int[v.length];
		}
		
		public void ordenarV () {
	    	for(int i=0; i<v.length; i++) {
	      	  int menor=i;
	      	  for(int j=i+1; j<v.length; j++) {
	      		  if(v[j]<v[menor]) {
	      			  menor=j;
	      		  }
	      	  }
	  		  intercambiar(v, menor,i);
	        }
	    }
		
		public void intercambiar(int[] array, int a, int b) {
		      int guardar = array[b];
		      array[b] = array[a];
		      array[a] = guardar;
		    }
		
		public void setVP() {
			int indice=0;
			while(indice<=v.length-1) {
				int n=v[indice];
				boolean primoi=true, primoV=false;
				for(int i=3; i<=n; i++) {
					int x=2;
					while(x<i && primoi==true){
						int resto=i%x;
						if(resto!=0) {
							x++;
							primoi=true;
							if(n==i) {
								primoV=true;
								}else {
									int resto2=n%i;
									int division=n/i;
									if(resto2!=0 && division>=i){
										primoV=true;
										}else {
											primoV=false;
										}
								}
						}else{
							x++;
							primoi=false;
							}
					}
					primoi=true;
				}
				int resto=n%2;
				if(primoV==true && resto!=0 || n==2) {
					vP[indice]=n;
					}
				indice++;
			}
			
		}
		
		 public void imprimirV() {
		      for (int i = 0; i < v.length; i++) {
		        System.out.print(v[i] + " ");
		      }
		      System.out.println();
		    }
		 public void imprimirVP() {
		      for (int i = 0; i < vP.length; i++) {
		        System.out.print(vP[i] + " ");
		      }
		      System.out.println();
		    }
	
}
