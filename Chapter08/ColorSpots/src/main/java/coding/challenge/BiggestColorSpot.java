package coding.challenge;

public class BiggestColorSpot {

    private int currentColorSpot;

    void determineBiggestColorSpot(int cols, int rows, int a[][]) {

        int biggestColorSpot = 0;
        int color = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                
                if (a[i][j] > 0) {
                    currentColorSpot = 0;
                    computeBiggestColorSpot(i, j, cols, rows, a, a[i][j]);
                    if (currentColorSpot > biggestColorSpot) {
                        biggestColorSpot = currentColorSpot;
                        color = a[i][j] * (-1);
                    }
                }
            }
        }

        System.out.println("\nColor: " + color + " Bigest spot: " + biggestColorSpot);
    }

    private void computeBiggestColorSpot(int i, int j, int cols, int rows, int a[][], int color) {

        a[i][j] = -a[i][j];
        currentColorSpot++;

        if (i > 1 && a[i - 1][j] == color) {
            computeBiggestColorSpot(i - 1, j, cols, rows, a, color);
        }
        
        if ((i + 1) < rows && a[i + 1][j] == color) {
            computeBiggestColorSpot(i + 1, j, cols, rows, a, color);
        }
        
        if (j > 1 && a[i][j - 1] == color) {
            computeBiggestColorSpot(i, j - 1, cols, rows, a, color);
        }
        
        if ((j + 1) < cols && a[i][j + 1] == color) {
            computeBiggestColorSpot(i, j + 1, cols, rows, a, color);
        }
    }
}