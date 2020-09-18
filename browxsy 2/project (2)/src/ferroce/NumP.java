package ferroce;

import java.util.*;

public class NumP {
// 17, 19, 23,284, 29, 31, 37, 6, 28, 496, 220
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 @SuppressWarnings("resource")
		java.util.Scanner lector = new java.util.Scanner(System.in);
	        System.out.println("Ingresar numeros del vector separados por coma");
	        String lista = lector.nextLine();
	        System.out.println("Ingresar amigo");
	        int a = Integer.parseInt(lector.nextLine());
	        int[]vectorNum=Arrays.asList(lista.split(",")).stream()
			        .map(String::trim)
			        .mapToInt(Integer::parseInt).toArray();
	        Num prueba1=new Num(vectorNum, a);
	        prueba1.ordenarV();
	        prueba1.imprimirV();
	        prueba1.setSum();
	        prueba1.recorrerVector();
	        prueba1.imprimirlist();
	}

}

class Num{
		int []v;
		int a;
		int sum;
		List <Integer> listPrimo;
		List <Integer> listPerfecto;
		List <Integer> listAmigo;
		
		public Num(int [] v, int a) {
			this.v=v;
			this.a=a;
			sum=1;
			listPrimo=new ArrayList<Integer>();
			listPerfecto=new ArrayList<Integer>();
			listAmigo=new ArrayList<Integer>();
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
		public void setSum() {
			for(int i=2; i<a; i++){ 
				int restoAmigo=dividirN(a,i);
				sum+=(restoAmigo==0 && sum<a)? i : 0 ;
			}
		}
		public void recorrerVector() {
			for(int i=0; i<v.length; i++) {
				setCalculos(v[i]);
			}
		}
		public void intercambiar(int[] array, int a, int b) {
		      int guardar = array[b];
		      array[b] = array[a];
		      array[a] = guardar;
		    }
		
		public void setCalculos(int n) {
			boolean primoi=false;
			int restoN=-1, restoPerf=-1, sumPerfecto=1;
			int restoPor2=n%2;			
			if(restoPor2==0) {sumPerfecto+=2;}
			for(int i=3; i<n; i++){ 
				restoPerf= dividirN(n,i);
				sumPerfecto+= (restoPerf==0 && sumPerfecto<n)? i : 0;
				
				int x=2;
				while(x<i && restoPor2!=0){ 
					 int resto=i%x;
					 if(resto!=0) { x++; primoi=true;}else {x=i; primoi=false;}
				} 
				if(primoi==true) {
					restoN= dividirN(n, i); 
					i = (restoN==0) ? n : i;
				}
				primoi=false;
//(n=i) se termina : (i) para seguir; (primoi=false) es de uso interno;
			}
			if(sumPerfecto==n) {listPerfecto.add(n);}
			if(sum==n && sumPerfecto==a) {listAmigo.add(n); listAmigo.add(a);}
			if(restoN==2 || n==2 || n==3) { listPrimo.add(n); }
		}
		 
		 public int dividirN(int n, int i) {
			int clave=0;
// clave 0= *es primo pero seguir dividiendo // clave=2 *no es primo;
			 if(n==i){
					clave=2;
					}else {
						int resto=n%i;
						//int division=n(de 3 digitos)/i es <= al cociente =>clave1;
						clave= (resto!=0) ? 2 : 0;
					}
			return clave;
		 }
		 
		 public void imprimirV() {
		      for (int i = 0; i < v.length; i++) {
		        System.out.print(v[i] + " ");
		      }
		      System.out.println();
		    }
		 
		 public void imprimirlist() {
			 System.out.println("Lista Primos: " +
					 Arrays.toString(listPrimo.toArray()));
			 System.out.println("Lista Perfecto: " +
					 Arrays.toString(listPerfecto.toArray()));
			 System.out.println("Lista Amigos: " +
					 Arrays.toString(listAmigo.toArray()));
		    }
	
}
