package ejerciciosUD4;

import java.util.Scanner;

public class GuerraUcrania {
    static Scanner in = new Scanner(System.in);
    static boolean[][] visitado;
    
    static char[][] leerMapa(int filas, int cols){
        char[][] mapa = new char[filas][];
        
        for (int f = 0; f < filas; f++) 
            mapa[f] = in.nextLine().toCharArray();
        
        return mapa;
    }
    
    static boolean estaDentro(char[][] mapa, int f, int c){
        return f >= 0 && f < mapa.length &&
               c >= 0 && c < mapa[0].length;
    }
    
    static boolean hayCamino (char[][] mapa, int fOrigen, int cOrigen, 
                                             int fDestino, int cDestino){
        
        if (fOrigen == fDestino && cOrigen == cDestino)
            return true;
        
        int[] df = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        int nf;
        int nc;
        
        visitado[fOrigen][cOrigen] = true;
        
        for (int i = 0; i < df.length; i++) {
            nf = fOrigen + df[i];
            nc = cOrigen + dc[i];
            
            if (estaDentro(mapa, nf, nc) &&
                !visitado[nf][nc] &&
                mapa[nf][nc] == '.')
                return hayCamino(mapa, nf, nc, fDestino, cDestino);
        }
        return false;
    }
    
    public static void main(String[] args) {
        int casos = in.nextInt();
        int filas;
        int cols;
        int fOrigen;
        int cOrigen;
        int fDestino;
        int cDestino;
        char[][] mapa;
        
        while (casos-- > 0){
            filas = in.nextInt();
            cols = in.nextInt();
            in.nextLine();
            
            visitado = new boolean[filas][cols];
            mapa = leerMapa(filas, cols);
            
            cOrigen = in.nextInt() - 1;
            fOrigen = in.nextInt() - 1;
            cDestino = in.nextInt() - 1;
            fDestino = in.nextInt() - 1;
                    
            if (hayCamino(mapa, fOrigen, cOrigen, fDestino, cDestino))
                System.out.println("Paso seguro");
            else
                System.out.println("Destino inalcanzable");
        }
    }

}