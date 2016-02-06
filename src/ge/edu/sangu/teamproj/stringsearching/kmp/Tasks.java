package ge.edu.sangu.teamproj.stringsearching.kmp;

import ge.edu.sangu.teamproj.stringsearching.Text;
import ge.edu.sangu.teamproj.stringsearching.kmp.PrefixAutomata;

import java.util.ArrayList;
import java.util.List;

public class Tasks {

    static PrefixAutomata<Character> createAutomata(String sample) {
        List<Character> alphabet = new ArrayList<>();

        for (int i = 0; i < 26; i++)
            alphabet.add((char)((int)'a' + i));

        return new PrefixAutomata<>(new Text(sample), alphabet);
    }

    static int occurencesInGreyString(int n, String sample, int mod) {
        int sampleLength = sample.length();

        int[][] state = new int[n + 1][sampleLength + 1];
        int[][] cnt = new int[n + 1][sampleLength + 1];

        PrefixAutomata <Character> aut = createAutomata(sample);

        for (int i = 0; i <= sampleLength; i++) {
            state[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sampleLength; j++) {

                int tmp = aut.nextState(state[i - 1][j], (char)('a' + (i - 1) % 26));

                state[i][j] = state[i - 1][tmp];
                cnt[i][j] = cnt[i - 1][j] + cnt[i - 1][tmp];

                if (tmp == sampleLength)
                    cnt[i][j]++;

                cnt[i][j] %= mod;
            }
        }

        return cnt[n][0];
    }

    public static List<Integer> substringSearch(String text, String sample) {

        PrefixAutomata <Character> aut = createAutomata(sample);
        List<Integer> res = new ArrayList<>();

        int state = 0;
        for (int i = 0; i < text.length(); i++) {
            state = aut.nextState(state, text.charAt(i));
            if (state == sample.length()) {
                res.add(i - sample.length() + 1);
                state = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(occurencesInGreyString(6, "abacabadabacabaeabacabadabacaba", 1000009));
    }
}