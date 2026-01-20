package ejerciciosUD4;

import java.util.Arrays;

public class Ejercicio3 {

    static void generar(int[] notas){
        for (int i = 0; i < notas.length; i++) 
            notas[i] = (int)(Math.random() * 10 + 1);
    }
    
    static void imprimir(int[] notas){
        System.out.println(Arrays.toString(notas));
//        for (int i = 0; i < notas.length - 1; i++) 
//            System.out.print(notas[i] + ", ");
//        System.out.println(notas[notas.length - 1]);
    }
    
    static int getSuspensos(int[] notas){
        int suspensos = 0;
        
        for (int i = 0; i < notas.length; i++) 
            if (notas[i] < 4)
                suspensos++;
        
        return suspensos;
    }
    
    static int getHacenMedia(int[] notas){
        int hacenMedia = 0;
        
        for (int nota: notas)
            if (nota == 4)
                hacenMedia++;
        
        return hacenMedia;
    }
    
    static int getAprobados(int[] notas){
        int aprobados = 0;
        
        for (int nota: notas)
            if (nota > 4)
                aprobados++;
        
        return aprobados;
    }
    
    static double getMedia(int[] notas){
        int suma = 0;
        
        for (int nota: notas)
            suma += nota;
        
        return (double)suma / notas.length;
    }
    
    static int getMinima(int[] notas){
        int minima = Integer.MAX_VALUE;
        
        for (int nota: notas)
            if (nota < minima)
                minima = nota;
        
        return minima;
    }
    
    static int getMaxima(int[] notas){
        int maxima = notas[0];
        
        for (int i = 1; i < notas.length; i++) 
            if (notas[i] > maxima)
                maxima = notas[i];
        
        return maxima;
    }
    
    static int getModa(int[] notas){
        int[] contadores = new int[11];

        for (int nota: notas)
            contadores[nota]++;
        
        int maximo = contadores[0];
        int pos = 0;
        for (int i = 1; i < contadores.length; i++) 
            if (contadores[i] > maximo){
                maximo = contadores[i];
                pos = i;
            }
        
        return pos;
    }
    
    public static void main(String[] args) {
        int[] notas = new int[10];

        generar(notas);
        imprimir(notas);
        
        System.out.println("Suspensos [1, 4): " + getSuspensos(notas));
        System.out.println("Hacen media [4, 5):" + getHacenMedia(notas));
        System.out.println("Aprobados: [5, 10]: " + getAprobados(notas));
        
        System.out.println("Nota media: " + getMedia(notas));
        System.out.println("Nota más baja: " + getMinima(notas));
        System.out.println("Nota más alta: " + getMaxima(notas));
        System.out.println("Moda: " + getModa(notas));
    }
}