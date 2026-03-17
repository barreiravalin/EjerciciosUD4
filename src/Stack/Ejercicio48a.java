package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Ejercicio48a {

    static boolean equilibrada(String expresion){
        Stack<Character> pila = new Stack();
        
        for (int i = 0; i < expresion.length(); i++) {
            if (expresion.charAt(i) == '(')
                pila.push('(');
            else if (expresion.charAt(i) == ')'){
                if (pila.isEmpty())
                    return false;
                else
                    pila.pop();
            }
        }
        
        return pila.isEmpty();
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