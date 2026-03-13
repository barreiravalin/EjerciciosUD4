package Listas;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio43 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //ArrayList<String> lista = new ArrayList();
        ArrayList<String> lista =
             new ArrayList(Arrays.asList("Manzana", "Pera", "Plátano"));
 //       String fruta;
        
//        while (!(fruta = in.nextLine()).equalsIgnoreCase("fin"))
//            lista.add(fruta);

        // a)
        for (int i = 0; i < lista.size(); i++) 
            System.out.println(lista.get(i));
        // b)
        for(String fruta: lista)
            System.out.println(fruta);
        // c)
        lista.forEach(System.out::println);
        // d)
        lista.forEach(fruta -> System.out.println(fruta));
        // e)
        Iterator<String> it = lista.iterator();
        while (it.hasNext())
            System.out.println(it.next());
        
    }

}