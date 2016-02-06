package ge.edu.sangu.teamproj.stringsearching;

/**
 * Unicode character string implementation of Word interface.
 */
public class Text implements Word<Character> {
    private String text;

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public int getLength() {
        return text.length();
    }

    @Override
    public Character getSymbol(int position) {

        if (position < 0 || position >= getLength()) {
            throw new IndexOutOfBoundsException();
        }

        return text.charAt(position);
    }
}



