package Listas;

import java.util.*;
import java.util.Iterator;

public class Ejercicio45 {

    static int contadorApariciones(ArrayList<String> ciudades, String ciudad){
        int contador = 0;
        
        for (int i = 0; i < ciudades.size(); i++) 
            if (ciudades.get(i).equals(ciudad))
                contador++;
        
        return contador;
    }
    
    public static void main(String[] args) {
        ArrayList<String> ciudades = new ArrayList(Arrays.asList("Lugo", "Lugo", "Coruña", "Lugo", "Vigo", "Pontevedra", "Ávila", "Ávila"));
        ArrayList<String> repetidas = new ArrayList();
        ArrayList<Integer> veces = new ArrayList();
        
        int vecesRepetida;
        
        for (int i = 0; i < ciudades.size(); i++) {
            if (!repetidas.contains(ciudades.get(i))) {
                vecesRepetida = contadorApariciones(ciudades, ciudades.get(i));

                System.out.println(ciudades.get(i) + ": aparece " + vecesRepetida);

                if (vecesRepetida > 1) {
                    repetidas.add(ciudades.get(i));
                    veces.add(vecesRepetida);
                }
            }
        }

        for (int i = 0; i < repetidas.size(); i++) 
            for (int j = 0; j < veces.get(i) - 1; j++)
                ciudades.remove(repetidas.get(i));


        ciudades.forEach(System.out::println);
        
        for (String ciudad: ciudades) 
            System.out.println(ciudad);
        
        for (int i = 0; i < ciudades.size(); i++) {
            System.out.println(ciudades.get(i));
        }
        
        Iterator<String> it = ciudades.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }

}