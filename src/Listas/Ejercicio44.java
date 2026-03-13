package Listas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio44 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList(Arrays.asList("manzana", "sandía", "melón", "kiwi", "granada"));
        
        final int MAX = 10; // número de máximo de intentos
        int intentos = 0;
        String fruta;
        
        while (intentos < MAX && !lista.isEmpty()){
            System.out.print("Nombre fruta (quedan " + (MAX - intentos) + " intentos) : ");
            fruta = in.nextLine();
            
            if (lista.remove(fruta))
                System.out.print("Acierto.");
            else
                System.out.print("Fallo.");
            System.out.println(" Faltan " + lista.size() + " frutas por acertar.");
            intentos++;
        }
        
        if (lista.isEmpty())
            System.out.println("Ganaste!!!");
        else
            System.out.println("Perdiste!!!");
        
    }

}