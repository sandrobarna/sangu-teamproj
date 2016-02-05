package ge.edu.sangu.teamproj.prefixautomata;

/**
 * Defines basic methods for immutable string.
 * @param <T> Type of symbols the string consist of.
 */
public interface Word<T> {
    /**
     * Returns word length (number of containing symbols).
     */
    int getLength();

    /**
     * Selects and returns symbol at the specified position (index).
     */
    T getSymbol(int position);
}