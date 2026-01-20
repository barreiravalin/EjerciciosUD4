package ejerciciosUD4;

import java.util.Arrays;

public class Ejercicio7 {

    private static boolean esPrimo(int n){
        for (int i = 2; i * i <= n; i++) 
            if (n % i == 0)
                return false;
        return true;
    }
    
    public static void main(String[] args) {
        final int MAX = 100;
        int[] primos = new int[MAX];
        int encontrados = 0;
        int n = 2;
        
        while (encontrados < MAX) {
            if (esPrimo(n)) 
                primos[encontrados++] = n;
            n++;
        }
        
        System.out.println(Arrays.toString(primos));
    }
}