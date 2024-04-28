package com.cc.data.structres.base.mrtrix;

public class Matrix {
    private int[][] data;
    private int rows;
    private int cols;

    // 构造函数，初始化矩阵
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
    }

    // 获取矩阵的行数
    public int getRows() {
        return rows;
    }

    // 获取矩阵的列数
    public int getCols() {
        return cols;
    }

    // 获取矩阵中指定位置的元素值
    public int getElement(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IllegalArgumentException("Invalid index");
        }
        return data[row][col];
    }

    // 设置矩阵中指定位置的元素值
    public void setElement(int row, int col, int value) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IllegalArgumentException("Invalid index");
        }
        data[row][col] = value;
    }

    // 打印矩阵
    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 创建一个3行3列的矩阵
        Matrix matrix = new Matrix(3, 3);

        // 设置矩阵的元素值
        matrix.setElement(0, 0, 1);
        matrix.setElement(0, 1, 2);
        matrix.setElement(0, 2, 3);
        matrix.setElement(1, 0, 4);
        matrix.setElement(1, 1, 5);
        matrix.setElement(1, 2, 6);
        matrix.setElement(2, 0, 7);
        matrix.setElement(2, 1, 8);
        matrix.setElement(2, 2, 9);

        // 打印矩阵
        matrix.print();
    }
}

