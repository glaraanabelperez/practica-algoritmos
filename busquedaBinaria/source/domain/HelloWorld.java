package domain;
import java.io.IOException;
import java.util.Collections;
import java.util.Arrays;

public class HelloWorld {

    public static void main(String[] args) {
        java.util.Scanner lector = new java.util.Scanner(System.in);
        System.out.println("Ingresar el codigo:");
        String codigo = lector.nextLine();
        System.out.println("Ingresar la letra a buscar:");
        String letra = lector.nextLine();
        
        byte[] letraNum=letra.getBytes();
        byte letraNumB=letraNum[0];
        	//	System.out.println("letra en numero "+letraNumB);
        byte [] codigoByte=codigo.getBytes();
        Arrays.sort(codigoByte);
        //codigoByte=ordenarVector(codigoByte);
        
        String string = new String(codigoByte);
	//	System.out.println(string);
        int sizeVec=codigoByte.length;
        int pos= busquedaBinaria (codigoByte, letraNumB, (sizeVec/2)) ;
		System.out.println("La letra " + letra + " se encuentra en la posicion " + pos);

    
    // Implementar la funcion busquedaBinaria dividiendo en 2; 
    
    }

 static int busquedaBinaria (byte [] vector, byte letra,  int size) {
       // System.out.println("size " +size);
        int medio=(vector.length)/2;
            if(vector[size]==letra){
                //TODO se recnoceria que estan repetidos deberia guardar cada posicion en un array int para devolver cada pos
                //TODO el final de la recursividad seria cuando termina el array;
                   return size;
               }
               if(letra>vector[size] && letra <vector[medio]){
                   int division= size== medio ? (medio)/2:  ((medio-size))/2;
                   size=division==2 || division==1 || division==0  ? size+1 : size+division;
                   //if(size<0){size=size*-1;}
                              //System.out.println("avanza en izquierda/relacion al medio" +size);
               }
               if(letra<vector[size] && letra<vector[medio]){
                       int division= size==medio ? medio/2 : (medio-(medio-size))/2;
                        size=division==2 || division==1 || division==0 ? size-1 : size-division;
                       // if(size<0){size=size*-1;}
                 // System.out.println(" retrocede izquierda en relacion al medio "+ size);
               }
               if(letra>vector[size] && letra>vector[medio]){
                  // if((vector.length-1)-size==1){size=size+1;}
                   int division= ((vector.length-1)-size)/2;
                   size=division==2||division==0 ? size+1 : size+division;
                   //if(size<0){size=size*-1;}
                         //     System.out.println("avanza derecha/ relacion a .length" +size);
               }
               
               if(letra<vector[size] && letra> vector[medio]){
                   int division= ((vector.length-1)-size)/2;
                   size=division==2||division==0 ? size-1 : size-division;
                  // if(size<0){size=size*-1;}
                  // System.out.println("retrocede en derecha en relacion a .length "+ size);
               }
            return size=busquedaBinaria (vector, letra, size);
            }

     static byte[] ordenarVector (byte [] vector) {
        byte []b=new byte[vector.length];
        b[0]=0;
        for(int i=0; i<vector.length; i++){
            if(vector[i]<b[i]){
                b[i+1]=b[i]; b[i]=vector[i];
            }else{
                b[i]=vector[i];
            }
        }
        return b;
    }


}

