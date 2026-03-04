package ejerciciosUD4;

import java.util.Scanner;

public class Elecciones {

    static int[] getCoordenadas(int[][] reparto){
        int max = Integer.MIN_VALUE;
        int[] c = new int[2];
        
        for (int fila = 0; fila < reparto.length; fila++) 
            for (int col = 0; col < reparto[0].length; col++) 
                if (reparto[fila][col] > max){
                    max = reparto[fila][col];
                    c[0] = fila;
                    c[1] = col;
                }
        return c;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int casos = in.nextInt();
        in.nextLine();
        
        String[] partidos;
        int[][] reparto;
        int numEscaños;
        int[] escaños;
        
        while (casos-- > 0){
            partidos = in.nextLine().split(" ");
            
            numEscaños = in.nextInt();
            reparto = new int[partidos.length][numEscaños];
            escaños = new int[partidos.length];
            
            for (int i = 0; i < partidos.length; i++) 
                reparto[i][0] = in.nextInt();
            
            for (int i = 1; i < numEscaños; i++) 
                for (int f = 0; f < partidos.length; f++) 
                    reparto[f][i] = reparto[f][0] / (i + 1);
            
            for (int i = 0; i < numEscaños; i++) {
                int[] coordenadas = getCoordenadas(reparto);
                escaños[coordenadas[0]]++;
                reparto[coordenadas[0]][coordenadas[1]] = 0;
            }

            for (int i = 0; i < partidos.length - 1; i++) 
                System.out.print(partidos[i] + ": " + escaños[i] + ", ");
            System.out.println(partidos[partidos.length - 1] + ": " + escaños[partidos.length - 1]);
            in.nextLine();
        }
    }

}
/*
3
A B C
5 20 29 25
A B C
5 80000 65000 23000
A B C D
5 340000 280000 160000 60000
*/