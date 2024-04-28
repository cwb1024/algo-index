package com.cc.data.structres.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ArrayDequeSwapStackMapping {
    public static void main(String[] args) {
        System.out.println("[stack ==> LinkedList]");
        System.out.println("LinkedList Swap Stack Mapping Last尾缀系, peek() == peekLast() , pop() == pollLast() , push() == addLast() ");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        for (Integer i : stack) {
            System.out.println("[存储完成 for遍历] Stack push i [1,3] , Stack for i = " + i);
        }
        while (!stack.isEmpty()) {
            int top = stack.peek();
            int pop = stack.pop();
            System.out.println("Stack top = " + top + " ,  Stack pop = " + pop);
        }
        Deque<Integer> linklistLikeStack = new LinkedList<>();
        linklistLikeStack.push(1);
        linklistLikeStack.push(2);
        linklistLikeStack.push(3);
        for (Integer i : linklistLikeStack) {
            System.out.println("[存储完成 for遍历] linklistLikeStack push i [1,3] , linklistLikeStack for i = " + i);
        }
        while (!linklistLikeStack.isEmpty()) {
            int top = linklistLikeStack.peek();
            int pop = linklistLikeStack.pop();
            System.out.println("linklistLikeStack peek = " + top + " , linklistLikeStack pop = " + pop);
        }
        Deque<Integer> linklistLast = new ArrayDeque<>();
        linklistLast.addLast(1);
        linklistLast.addLast(2);
        linklistLast.addLast(3);
        for (Integer i : linklistLast) {
            System.out.println("[存储完成 for遍历] linklistLast addLast i [1,3] , linklistLast for i = " + i);
        }
        while (!linklistLast.isEmpty()) {
            int top = linklistLast.peekLast();
            int pop = linklistLast.pollLast();
            System.out.println("linklistLast peekLast = " + top + " ,linklistLast  pollLast = " + pop);
        }
    }
}
