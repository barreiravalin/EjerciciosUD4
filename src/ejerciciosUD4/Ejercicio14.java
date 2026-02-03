package ejerciciosUD4;

import java.util.Arrays;

public class Ejercicio14 {

    static void rellenar(int[] v){
        for (int i = 0; i < v.length; i++) 
            v[i] = i;
    }
    
    static void barajar(int[] v){
        // Algoritmo Ficher-Yates
        int n;
        int temp;
        
        for (int i = 0; i < v.length; i++) {
            n = (int)(Math.random() * v.length);
            temp = v[i];
            v[i] = v[n];
            v[n] = temp;
        }
    }
    
    public static void main(String[] args) {
        final int MAX = 10;
        
        int[] v = new int[MAX];
        rellenar(v);
        System.out.println(Arrays.toString(v));
        barajar(v);
        System.out.println(Arrays.toString(v));
    }
}