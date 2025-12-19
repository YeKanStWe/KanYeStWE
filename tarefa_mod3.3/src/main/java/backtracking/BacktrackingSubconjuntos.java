package backtracking;

import java.util.*;

public class BacktrackingSubconjuntos {

    public static void main(String[] args) {
        int[] s = new int[21];
        for (int i = 0; i < 21; i++) s[i] = i + 1;
        combinar(s, 20, 0, new ArrayList<>());
    }

    private static void combinar(int[] s, int n, int start, List<Integer> atual) {
        if (atual.size() == n) {
            System.out.println(atual);
            return;
        }
        for (int i = start; i < s.length; i++) {
            atual.add(s[i]);
            combinar(s, n, i + 1, atual);
            atual.remove(atual.size() - 1);
        }
    }
}