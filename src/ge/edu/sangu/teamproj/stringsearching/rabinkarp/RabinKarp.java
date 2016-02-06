package ge.edu.sangu.teamproj.stringsearching.rabinkarp;

import ge.edu.sangu.teamproj.stringsearching.Text;

import java.util.ArrayList;
import java.util.List;

public class RabinKarp {

    private int textLength;
    private long hashValues[];

    public List<Integer> findOccurences(Text text, Text sample) {

        int prime = 31;

        int n = text.getLength();
        int m = sample.getLength();

        long primePowers[] = new long[n];
        long sampleHash = sample.getSymbol(0) - 'a' + 1;
        long curHash = text.getSymbol(0) - 'a' + 1;

        List<Integer> occurences = new ArrayList<>();

        primePowers[0] = 1;
        for (int i = 1; i < n; i++) {
            primePowers[i] = prime * primePowers[i - 1];
        }
        for (int i = 1; i < m; i++) {
            curHash += primePowers[i] * (text.getSymbol(i) - 'a' + 1);
            sampleHash += primePowers[i] * (sample.getSymbol(i) - 'a' + 1);
        }

        for (int i = 0, j = 0; i < n - m + 1; i++) {
            if (sampleHash * primePowers[i] == curHash) {
                for (j = 0; j < m; j++) {
                    if (text.getSymbol(i + j) != sample.getSymbol(j)) break;
                }
                if (j == m) {
                    occurences.add(i);
                }
            }
            curHash -= (text.getSymbol(i) - 'a' + 1) * primePowers[i];
            if (i + m < n) {
                curHash += (text.getSymbol(i + m) - 'a' + 1) * primePowers[i + m];
            }
        }

        return occurences;
    }

    public static void main(String[] args) {
        RabinKarp a = new RabinKarp();
        System.out.println(a.findOccurences(new Text("ababcabababcababababababababcababababc"), new Text("ababc")));
    }
}
