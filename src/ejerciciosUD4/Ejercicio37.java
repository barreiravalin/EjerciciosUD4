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
    
    static boolean estaDentro(int[][] imagen, int f, int c){
        return f >= 0 && f < imagen.length &&
               c >= 0 && c < imagen[0].length;
    }
    
    static int suavizar(int[][] imagen, int f, int c){
        int[] df = {0, -1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {0, -1, 0, 1, -1, 1, -1, 0, 1};
        
        int nf;
        int nc;
        int suma = 0;
        int contador = 0;
        
        for (int i = 0; i < df.length; i++) {
            nf = f + df[i];
            nc = c + dc[i];
            if (estaDentro(imagen, nf, nc)){
                suma += imagen[nf][nc];
                contador++;
            }
        }
        
        return suma / contador;
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