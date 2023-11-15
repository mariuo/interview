package com.company;

public class MatrizProduto {
    public static int absolute(int[][] mat){
        if(mat == null) return 0;

        int sumR=0, sumL=0;
        int row = mat.length;
        int col = mat[0].length;
        System.out.println("Row: "+row);
        System.out.println("Col: "+col);
        for(int i = 0 ; i< row; i++){
            sumR += mat[i][i];
            sumL += mat[i][col-1];
            col--;
        }
        return Math.abs(sumR-sumL);

    }
    public static int[][] produtoMatrizes(int[][] matriz1, int[][] matriz2) {
        int linhasMatriz1 = matriz1.length;
        int colunasMatriz1 = matriz1[0].length;
        int colunasMatriz2 = matriz2[0].length;

        int[][] resultado = new int[linhasMatriz1][colunasMatriz2];

        for (int i = 0; i < linhasMatriz1; i++) {
            for (int j = 0; j < colunasMatriz2; j++) {
                for (int k = 0; k < colunasMatriz1; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[][] matriz1 = { { 1, 2, 3 }, { 4, 5, 6 } };
        int[][] matriz2 = { { 7, 8 }, { 9, 10 }, { 11, 12 } };
        int[][] matriz3 = { { 11, 2, 4 }, { 4, 5, 6 }, {10,8,-12}};

//        int[][] resultado = produtoMatrizes(matriz1, matriz2);
        int[][] resultado = (matriz3);

        // Exibir o resultado
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[0].length; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Valor absoluto: " + absolute(matriz3));
    }
}
