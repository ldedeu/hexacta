package com.br.teste.hexacta.classes;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class Solution {

    /**
     * Devuele el menor número positivo que no está en el arreglo dado.
     *
     * @param A el arreglo de enteros a analizar
     * @return Menor número que no este presente en el array.
     * @author lauren.dedeu
     */
    public int solution(int[] A) {
        IntPredicate positiveNumbers = x -> x <= 1000;
        IntPredicate allowedNumbers = positiveNumbers.and(x -> x >= -1000);
        List<Integer> list = Arrays.stream(A).filter(allowedNumbers).boxed().collect(Collectors.toCollection(ArrayList::new));
        A = list.stream().mapToInt(i -> i).toArray();
        this.quicksort(A, 0, A.length - 1);
        list = Arrays.stream(A).filter(x -> x > 0).boxed().collect(Collectors.toCollection(ArrayList::new));

        if (list.isEmpty())
            return 1;
        for (int i = 1; i < 1000; i++) {
            int finalI = i;
            Optional<Integer> first = list.stream().filter(x -> x == finalI).findFirst();
            if (!first.isPresent()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Método para obtener todas las combinaciones de dos números en un arreglo dado,
     * que sumen el mismo valor que tenga la variable dada.
     *
     * @param A arreglo de valores enteros.
     * @param x valor dado
     * @return combinationResult ArrayList bidimensional con todas las posibles combinaciones.
     * @author lauren.dedeu
     */
    public ArrayList<ArrayList<String>> combinationsOfX(int[] A, int x) {
        ArrayList<ArrayList<String>> combinationResult = new ArrayList<>();
        List<Integer> list = Arrays.stream(A).distinct().boxed().collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            if (temp + temp == x) {
                String numberI = temp + "," + temp;
                ArrayList<String> arrayTI = new ArrayList<>();
                arrayTI.add(numberI);
                combinationResult.add(arrayTI);
            }
            for (int j = i + 1; j < list.size(); j++) {
                int subTemp = list.get(j);
                if (temp + subTemp == x) {
                    String number = temp + "," + subTemp;
                    ArrayList<String> arrayT = new ArrayList<>();
                    arrayT.add(number);
                    combinationResult.add(arrayT);
                }
            }
        }
        return combinationResult;
    }

    /**
     * Método para ordenar el arreglo dado ascendentemente. Obtenido de Internet
     *
     * @param A   arreglo con datos a ordenar
     * @param izq primera posición del Array
     * @param der última posición del Array
     */
    public void quicksort(int[] A, int izq, int der) {

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
