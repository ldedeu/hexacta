package com.br.teste.hexacta;

import com.br.teste.hexacta.classes.Solution;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //int[] A = {-5, 7, 0, 3, -2, 12, 1, 1}; //devolver 2
        //int[] A = {-5, -2, -15, -18, -25}; //devolver 1
        //int[] A = {9, 16, 8, 98, 105, 999}; //devolver 1
        //int[] A = {5, 8, 4, 10, 1, 2, 15, -18, 0, 3, 6, 7, 9, 11, 12, 13, 14}; //devolver 16
        // int[] A = {1001, -1001, -58, 0, 5, 7, 4, 1, 3, 2};
        // int[] A = {1001, -58, 0, 1002, 1003, 1005, -1001}; //1
        int[] A = {1001, 1002, 1003, 1005, -1001}; // return -1. Não há valores inteiros permitidos para análise. O intervalo permitido é -1000 - 1000.

        //int[] A = {1, 3, 6, 4, 1, 2};//, a função deve retornar 5;
        // int[] A = {1, 2, 3};//, a função deve retornar 4;
        //int[] A = {-1, -3};//, a função deve retornar 1.

        Solution solution = new Solution();
        if (A.length > 100) {
            System.out.println("La longitud del arreglo no puede ser mayor a 100");
            return;
        } else {
            System.out.println(solution.solution(A));
        }

        //int[] C = {-998, -58, 0, 1, 2, 3, 4, 5, 7};
        //int[] C = {-2, -1, -1, 0, 2, 4, 7, 8, 9, 9};
        // int[] C = {0, 1, 2, 3, 4, 5, 7};
        // int[] C = {0, 1, 2, 3, 4, 5, 7};
       // int[] C = {-11, -8, -4, -2, - 3, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 11};
        int[] C = {};
        System.out.println(solution.combinationsOfX(C, 9));
    }
}
