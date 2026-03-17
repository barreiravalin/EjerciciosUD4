package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Ejercicio48 {

    static boolean equilibrada(String expresion){
        Stack<Character> pila = new Stack();
        
        for (int i = 0; i < expresion.length(); i++) 
            pila.push(expresion.charAt(i));
        
        while (!pila.isEmpty())
            System.out.println(pila.pop());
        
        return true;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String expresion = in.nextLine();
        
        if (equilibrada(expresion))
            System.out.println("SI");
        else
            System.out.println("NO");
    }

}