package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Ejercicio48b {

    static boolean equilibrada(String expresion){
        char[] pila = new char[expresion.length()];
        int cima = -1;
        
        for (int i = 0; i < expresion.length(); i++) {
            if (expresion.charAt(i) == '(')
                pila[++cima] = '(';
            else if (expresion.charAt(i) == ')'){
                if (cima == -1)
                    return false;
                else
                    cima--;
            }
        }
        
        return cima == -1;
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