package com.cc.algo.ext;

/**
 * 我们定义了 matrixMultiply 方法来计算两个矩阵的乘积。
 * 在 main 方法中，我们创建了两个矩阵 A 和 B，调用 matrixMultiply 方法来计算它们的乘积，
 * 并使用 printMatrix 方法打印结果。
 */
public class MatrixMultiplication {

    public static int[][] matrixMultiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;

        int[][] C = new int[m][p];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] A = { {1, 2, 3}, {4, 5, 6} };
        int[][] B = { {7, 8}, {9, 10}, {11, 12} };

        int[][] C = matrixMultiply(A, B);
        printMatrix(C);
    }
}

