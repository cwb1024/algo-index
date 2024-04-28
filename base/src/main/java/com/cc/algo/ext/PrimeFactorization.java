package com.cc.algo.ext;

import java.util.*;

//质因数分解
public class PrimeFactorization {

    public static List<Integer> primeFactorization(int n) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        if (n > 1) {
            factors.add(n);
        }

        return factors;
    }

    public static void main(String[] args) {
        int n = 120;
        List<Integer> factors = primeFactorization(n);

        System.out.println("正整数 " + n + " 的质因数分解结果为：" + factors);
    }
}

