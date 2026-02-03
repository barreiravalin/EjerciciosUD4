package ejerciciosUD4;

import java.util.Arrays;

public class Ejercicio22 {
    
    static void rellenar(int[] v){
        for (int i = 0; i < v.length; i++) 
            v[i] = (int)(Math.random() * v.length);
    }

    static boolean busquedaLineal(int[] v, int elem){
//        for (int i = 0; i < v.length; i++) 
//            if (v[i] == elem)
//                return true;
//        return false;
        for(int n: v)
            if (n == elem)
                return true;
        return false;
    }
    
    static int busquedaDicotomica(int[] v, int elem){
        // datos: 1  5   7    8   9   10   20
        // pos:   0  1   2    3   4    5    6
        
        Arrays.sort(v); // Requisito para la búsqueda dicotómica
        int desde = 0;
        int hasta = v.length - 1;
        int central;
        
        while (desde <= hasta){
            central = (hasta + desde) / 2;
            
            if (v[central] == elem)
                return central;
            
            if (v[central] > elem)
                hasta = central - 1;
            else
                desde = central + 1;
        }
        return -1;
    }
    
    static int interno(int[] v, int elem, int desde, int hasta){
        if (hasta < desde)
            return -1;
        
        int central = (desde + hasta) / 2;
        
        if (v[central] == elem)
            return central;
        
        if (v[central] > elem)
            return interno(v, elem, desde, central - 1);
        else
            return interno(v, elem, central + 1, hasta);
    }
    
    static int busquedaDicotomicaRecursiva(int[] v, int elem){
        Arrays.sort(v);
        return interno(v, elem, 0, v.length - 1);
    }
    
    public static void main(String[] args) {
        final int MAX = 30;
        int[] v = new int[MAX];
       
        rellenar(v);
        System.out.println(Arrays.toString(v));
        
        System.out.println(busquedaDicotomicaRecursiva(v, 15));
    }

}