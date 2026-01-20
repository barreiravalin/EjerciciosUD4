package ejerciciosUD4;

import java.text.NumberFormat;

public class Ejercicio5 {

    public static void main(String[] args) {
        final int MAX = 1_000_000;
        int[] contadores = new int[7];
        
        for (int i = 0; i < MAX; i++) 
            contadores[(int)((Math.random() * 6) + 1)]++;
        
        // Número de veces que salió cada número
        for (int i = 1; i < 7; i++) 
            System.out.println(i + ": " + contadores[i]);
        
        for (int i = 1; i < 7; i++) 
            System.out.println(i + ": " + contadores[i] * 100D / MAX + "%");
        
        NumberFormat porcentaje = NumberFormat.getPercentInstance();
        porcentaje.setMinimumFractionDigits(2);

        for (int i = 1; i < 7; i++) {
            double probabilidad = (double) contadores[i] / MAX;
            System.out.println(i + ": " + porcentaje.format(probabilidad));
        }
    }

}