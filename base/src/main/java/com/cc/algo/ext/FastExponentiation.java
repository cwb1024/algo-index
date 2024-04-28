package com.cc.algo.ext;

//递归的方式实现快速幂

/**
 * fastPow 方法接受底数 x 和指数 n，返回 x^n 的值。如果指数 n 是偶数，则递归计算 x^(n/2) 并返回其平方；如果指数 n 是奇数，则额外乘以底数 x。通过这种分治的方式，快速幂算法可以将计算复杂度从
 * 𝑂
 * (
 * 𝑛
 * )
 * O(n) 降低到
 * 𝑂
 * (
 * log
 * ⁡
 * 𝑛
 * )
 * O(logn)，大大提高了计算效率。
 */
public class FastExponentiation {

    public static long fastPow(int x, int n) {
        if (n == 0) {
            return 1;
        }

        long half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }

    public static void main(String[] args) {
        int x = 2;
        int n = 10;
        long result = fastPow(x, n);
        System.out.println(x + "^" + n + " = " + result);
    }
}

