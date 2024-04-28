package com.cc.algo.search.floodFill;

import java.util.*;

public class FloodFill {
    static class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            if (image == null || image.length == 0 || image[0].length == 0) return image;

            int rows = image.length;
            int cols = image[0].length;
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右、下、左、上

            int originalColor = image[sr][sc];
            if (originalColor == newColor) return image; // 新颜色和原始颜色相同，无需填充

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{sr, sc});
            image[sr][sc] = newColor; // 修改起始位置的颜色

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && image[nx][ny] == originalColor) {
                        queue.offer(new int[]{nx, ny});
                        image[nx][ny] = newColor; // 修改颜色
                    }
                }
            }

            return image;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;
        int[][] result = solution.floodFill(image, sr, sc, newColor);
        System.out.println("Flood filled image:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}

