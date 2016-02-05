package ge.edu.sangu.teamproj.prefixautomata;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Represents a deterministic finite automata for substring searching.
 */
public class PrefixAutomata<T> {

    private static class TransitionArg<T> {
        public int currentState;
        public T nextSymbol;

        public TransitionArg(int currentState, T nextSymbol) {
            this.currentState = currentState;
            this.nextSymbol = nextSymbol;
        }

        @Override
        public boolean equals(Object o) {
            TransitionArg<T> obj = (TransitionArg<T>) o;
            return currentState == obj.currentState && nextSymbol.equals(obj.nextSymbol);
        }

        @Override
        public int hashCode() {
            return currentState ^ nextSymbol.hashCode();
        }

        @Override
        public String toString() {
            return String.format("(%s, %s)", currentState, nextSymbol);
        }
    }

    private Word<T> word;
    private int wordLength;
    private List<T> alphabet;

    private int[] prefixFunction;

    private int state;
    private Map<TransitionArg<T>, Integer> transitionTable = new HashMap<>();

    PrefixAutomata(Word<T> word, List<T> alphabet) {
        this.word = word;
        this.alphabet = alphabet;

        wordLength = word.getLength();
        prefixFunction = new int[wordLength];

        computePrefixFunction();
        buildAutomata();
    }

    void computePrefixFunction() {
        int curValue;
        T curSymbol;
        for (int i = 1; i < wordLength; i++) {
            curValue = prefixFunction[i - 1];
            curSymbol = word.getSymbol(i);
            while (curValue > 0 && !curSymbol.equals(word.getSymbol(curValue))) {
                curValue = prefixFunction[curValue - 1];
            }
            prefixFunction[i] = curValue + (curSymbol.equals(word.getSymbol(curValue)) ? 1 : 0);
        }
    }

    void buildAutomata() {
        for (int i = 0; i < wordLength; i++) {
            for (T symbol : alphabet) {
                if (word.getSymbol(i) == symbol) {
                    transitionTable.put(new TransitionArg(i, symbol), i + 1);
                } else if (i != 0) {
                    transitionTable.put(new TransitionArg(i, symbol),
                            transitionTable.get(new TransitionArg(prefixFunction[i - 1], symbol)));
                }
            }
        }
    }

    public int getState() {
        return state;
    }

    public void reset() {
        state = 0;
    }

    public int nextState(T symbol) {
        Integer res = transitionTable.get(new TransitionArg(state, symbol));

        state = res == null ? 0 : res;

        return state;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("");
        for (Iterator it = transitionTable.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            TransitionArg<T> arg = (TransitionArg<T>) entry.getKey();
            res.append(String.format("%s -> %s", arg, entry.getValue()));
            res.append("\n");
        }
        return res.toString();
    }
}
