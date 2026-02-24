package ejerciciosUD4;

import java.util.Scanner;

public class TalarArboles {
    
    static boolean sePuedeTirarDireccion(int[][] finca, byte f, byte c, int vf, int vc){
        byte nf = f;
        byte nc = c;
        
        for (int i = 0; i < finca[f][c] - 1; i++) {
            nf += vf;
            nc += vc;
            
            if (finca[nf][nc] != 0 ||
                nf < 0 || nf >= finca.length ||
                nc < 0 || nc >= finca[0].length)
                return false;
        }
        
        return true;
    }
    
    static boolean sePuedeTirar(int[][] finca, byte f, byte c){
        final int[] DF = {-1, -1, -1, 0, 0, 1, 1, 1};
        final int[] DC = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        if (finca[f][c] == 1)
            return true;
        
        for (int i = 0; i < 8; i++) 
            if (sePuedeTirarDireccion(finca, f, c, DF[i], DC[i]))
                return true;
        
        return false;
    }
    
    static int getNumeroArboles(int[][] finca){
        int contador = 0;
        
        for (byte f = 0; f < finca.length; f++) 
            for (byte c = 0; c < finca[f].length; c++) 
                if (finca[f][c] > 0 && sePuedeTirar(finca, f, c))
                    contador++;
        
        return contador;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        byte filas;
        byte cols;
        byte f;
        byte c;
        int numArboles;
        int[][] finca;
        
        while ((cols = in.nextByte()) != 0){
            filas = in.nextByte();
            numArboles = in.nextInt();
            
            finca = new int[filas][cols];
            for (int i = 0; i < numArboles; i++) {
                c = in.nextByte();
                f = in.nextByte();
                
                finca[f][c] = in.nextInt();
            }
            
            System.out.println(getNumeroArboles(finca));
        }
    }
}
/*
4 4 4
1 1 1 2 2 3 3 2 3 3 3 4
5 4 8
1 1 3 2 1 2 4 1 3 2 2 4 4 2 3 1 3 3 3 3 3 1 4 5
4 2 3
2 1 3 1 2 5 3 2 3
0 0 0
*/