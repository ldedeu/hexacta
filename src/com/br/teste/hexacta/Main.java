package com.br.teste.hexacta;

import com.br.teste.hexacta.classes.Solution;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //int[] A = {-5, 7, 0, 3, -2, 12, 1, 1}; //devolver 2
        //int[] A = {-5, -2, -15, -18, -25}; //devolver 1
        //int[] A = {9, 16, 8, 98, 105, 999}; //devolver 1
        //int[] A = {5, 8, 4, 10, 1, 2, 15, -18, 0, 3, 6, 7, 9, 11, 12, 13, 14}; //devolver -1 porque esta toda la secuencia no hay menor que mostrar
        int[] A = {998, -58, 0, 5, 7, 4, 1, 3, 2}; //devolver 6
        if (A.length > 100) {
            System.out.println("La longitud del arreglo no puede ser mayor a 100");
            return;
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(A));
    }
}
