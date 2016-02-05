package ge.edu.sangu.teamproj.prefixautomata;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        String text = "aaaabaaaababb";
        String sample = "ab";

        List<Character> alphabet = new ArrayList<Character>();

        for (int i = 0; i < 26; i++)
            alphabet.add((char)((int)'a' + i));

        PrefixAutomata <Character> aut = new PrefixAutomata<>(new Text(sample), alphabet);

        for (int i = 0; i < text.length(); i++) {
            if (aut.nextState(text.charAt(i)) == sample.length()) {
                System.out.println(i - sample.length() + 1);
                aut.reset();
            }
        }

        System.out.println(aut);
    }
}