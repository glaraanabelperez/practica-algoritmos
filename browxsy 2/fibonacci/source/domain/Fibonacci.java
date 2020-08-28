package domain;

public class Fibonacci {

    public static void main(String[] args) {
        java.util.Scanner lector = new java.util.Scanner(System.in);
        System.out.println("Ingresar la posicion en la serie:");
        int numero = Integer.parseInt(lector.nextLine());
        int resultado = fibonacci(numero);
        if (resultado >= 0) {
            System.out.println("Resultado: " + fibonacci(numero));
        } else {
            System.out.println("Debes ingresar un tamano mayor o igual a 1");
        }
    }
    
    // Implementar la funcion    
    static int fibonacci(int n) {
        int x=n-1, z=n-2;
         if(n<2){
             return n;
        }else {
            n=fibonacci(x)+fibonacci(z);
            return n;
        }
    }
}

 
