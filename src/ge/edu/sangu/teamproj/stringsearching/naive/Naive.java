package ge.edu.sangu.teamproj.stringsearching.naive;

import ge.edu.sangu.teamproj.stringsearching.Word;

import java.util.ArrayList;
import java.util.List;

public class Naive<T> {
    public List<Integer> findOccurences(Word<T> text, Word<T> sample) {
        int n = text.getLength();
        int m = sample.getLength();

        List<Integer> occurences = new ArrayList();

        for (int i = 0, j; i < n - m + 1; i++) {
            for (j = 0; j < m; j++) {
                if (text.getSymbol(i + j) != sample.getSymbol(j))
                    break;
            }
            if (j == m) {
                occurences.add(i);
            }
        }

        return occurences;
    }
}
