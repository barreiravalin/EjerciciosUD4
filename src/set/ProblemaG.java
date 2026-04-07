package set;

import java.util.HashSet;
import java.util.Scanner;

public class ProblemaG {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
                
        int numEmpleados;
        int numProyectos;
        String[] datos;
        boolean esPosible;
        
        // Lectura de habilidades de los empleados
        numEmpleados = in.nextInt();
        in.nextLine(); // Vaciar el enter

        while (numEmpleados-- > 0){
            datos = in.nextLine().split(" ");
            for (int i = 1; i < datos.length; i++) 
                set.add(datos[i]);
        }
        
        // Lectura de datos de proyectos
        numProyectos = in.nextInt();
        in.nextLine();
        while (numProyectos-- > 0){
            datos = in.nextLine().split(" ");
            
            esPosible = true;
            for (int i = 1; i < datos.length; i++) 
                if (!set.contains(datos[i])){
                    esPosible = false;
                    break;
                }
            
            System.out.println(esPosible? "POSIBLE" : "IMPOSIBLE");
        }
    }
}
/*
5
Alice FRONTEND BACKEND
Bob DATABASE SECURITY
Charlie FULLSTACK
Diana FULLSTACK DATABASE
Eva SECURITY
3
SistemaGestion FRONTEND BACKEND DATABASE
WebSegura SECURITY DATABASE
PlataformaEducativa FULLSTACK UI/UX

*/