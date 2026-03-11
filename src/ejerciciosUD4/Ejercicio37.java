package ejerciciosUD4;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio37 {
    static Scanner in = new Scanner(System.in);
 
    static int[][] leerImagen(int filas, int cols){
        int[][] resultado = new int[filas][cols];
        
        for (int f = 0; f < filas; f++) 
            for (int c = 0; c < cols; c++) 
                resultado[f][c] = in.nextInt();
        
        return resultado;
    }
    
    static void imprimirMatriz(int[][] m){
        for (int f = 0; f < m.length; f++) 
            System.out.println(Arrays.toString(m[f]));
    }
    
    static int[][] suavizar(int[][] imagen){
        int[][] resultado = new int[imagen.length][imagen[0].length];
        
        for (int f = 0; f < imagen.length; f++) 
            for (int c = 0; c < imagen[f].length; c++) 
                resultado[f][c] = suavizar(imagen, f, c);
        
        return resultado;
    }
    
    public static void main(String[] args) {
        int casos = in.nextInt();
        int filas;
        int cols;
        int[][] imagen;
        int[][] resultado;
        
        while (casos-- > 0){
            filas = in.nextInt();
            cols = in.nextInt();
            
            imagen = leerImagen(filas, cols);
            resultado = suavizar(imagen);
            imprimirMatriz(resultado);
        }
    }
}