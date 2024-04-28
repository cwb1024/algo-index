package com.cc.algo.ext;

import java.util.Arrays;

/**
 * 我们定义了sieveOfEratosthenes方法来实现埃拉托斯特尼筛法。
 * 在main方法中，我们调用sieveOfEratosthenes方法来找出小于等于30的所有质数，
 * 并使用printPrimes方法打印结果。
 */
public class PrimeSieve {

    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }

    public static void printPrimes(boolean[] isPrime) {
        System.out.println("质数列表：");
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 30;
        boolean[] primes = sieveOfEratosthenes(n);
        printPrimes(primes);
    }
}

