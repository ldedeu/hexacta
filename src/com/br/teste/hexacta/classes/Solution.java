package com.br.teste.hexacta.classes;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    /**
     * Devuele el menor número que no está en el arreglo dado.
     * @param A el arreglo de enteros a analizar
     * @author lauren.dedeu
     * @date 29/01/2021
     * @return
     */
    public int solution(int[] A) {
        this.quicksort(A, 0, A.length - 1);
        List<Integer> list = Arrays.stream(A).filter(x -> x > 0).boxed().collect(Collectors.toCollection(() -> new ArrayList<Integer>()));
        if(list.isEmpty())
            return 1;
        for (int i = 1; i < 1000; i++) {
            int finalI = i;
            Optional<Integer> first = list.stream().filter(x -> x == finalI).findFirst();
            if (!first.isPresent()) {
                Optional<Integer> max = list.stream().filter(x -> x > finalI).findFirst();
                if (max.isPresent()) {
                    return i;
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }

    /**
     * Método para ordenar el arreglo dado ascendentemente. Obtenido de Internet
     *
     * @param A   arreglo con datos a ordenar
     * @param izq primera posición del Array
     * @param der última posición del Array
     * @date 29/01/2021
     */
    public void quicksort(int A[], int izq, int der) {

        int pivote = A[izq]; // tomamos primer elemento como pivote
        int i = izq;         // i realiza la búsqueda de izquierda a derecha
        int j = der;         // j realiza la búsqueda de derecha a izquierda
        int aux;

        while (i < j) {                          // mientras no se crucen las búsquedas
            while (A[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
            while (A[j] > pivote) j--;           // busca elemento menor que pivote
            if (i < j) {                        // si no se han cruzado
                aux = A[i];                      // los intercambia
                A[i] = A[j];
                A[j] = aux;
            }
        }

        A[izq] = A[j];      // se coloca el pivote en su lugar de forma que tendremos
        A[j] = pivote;      // los menores a su izquierda y los mayores a su derecha

        if (izq < j - 1)
            quicksort(A, izq, j - 1);          // ordenamos subarray izquierdo
        if (j + 1 < der)
            quicksort(A, j + 1, der);        // ordenamos subarray derecho
    }
}
