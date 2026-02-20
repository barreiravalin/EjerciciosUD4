package ejerciciosUD4;

import java.util.Arrays;

public class MergeSort {

    public static int[] merge(int[] izquierda, int[] derecha) {
        int[] resultado = new int[izquierda.length + derecha.length];
        int i = 0, j = 0, k = 0;
        // Comparar y añadir el menor
        while(i < izquierda.length && j < derecha.length)
            if(izquierda[i] < derecha[j])
                resultado[k++] = izquierda[i++];
            else
                resultado[k++] = derecha[j++];
        
        // Añadir lo que quede
        while(i < izquierda.length)
            resultado[k++] = izquierda[i++];
        while(j < derecha.length)
            resultado[k++] = derecha[j++];
        return resultado;
    }
    
    public static int[] mergeSort(int[] array) {
        if(array.length <= 1)
            return array; // Base: ya está ordenado
        
        // Dividir el array en dos mitades
        int mid = array.length / 2;
        int[] izquierda = new int[mid];
        int[] derecha = new int[array.length-mid];
        
        // Copiar elementos a las mitades
        for(int i = 0; i < mid; i++)
            izquierda[i] = array[i];
        for(int i = mid; i < array.length; i++)
            derecha[i -mid] = array[i];
        
        // Ordenar recursivamente cada mitad
        izquierda = mergeSort(izquierda);
        derecha = mergeSort(derecha);
        
        // Combinar las mitades ordenadas
        return merge(izquierda, derecha);
    }
    
    static void rellenar(int[] v){
        for (int i = 0; i < v.length; i++) 
            v[i] = (int)(Math.random() * v.length);
    }
    
    public static void burbuja(int[] v) {
        int i, j, aux;
        for(i = 0; i < v.length-1; i++) {
            for(j = 0; j < v.length-i -1; j++) {
                if(v[j + 1] < v[j]) {
                    aux= v[j + 1];
                    v[j + 1] = v[j];
                    v[j] = aux;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        final int MAX = 1_000_000;
        
        int[] v = new int[MAX];
        int[] c1 = new int[MAX];
        int[] c2 = new int[MAX];
        
        rellenar(v);
        System.arraycopy(v, 0, c1, 0, MAX);
        System.arraycopy(v, 0, c2, 0, MAX);
        
        long inicio, fin;
        inicio = System.currentTimeMillis();
        c1 = mergeSort(c1);
        fin = System.currentTimeMillis();
        System.out.println("Merge sort: " + (fin-inicio));
        
        inicio = System.currentTimeMillis();
        burbuja(c2);
        fin = System.currentTimeMillis();
        System.out.println("Burbuja: " + (fin-inicio));
    }

}