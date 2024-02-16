package Program;

/**
 * Name: Anupama Bhatta
 * Date: 04/17/2018
 * Description: Java application that allows searching for files and rename files in batches.
 */

public class RenameTemplate {
    
    private String chars;
    private int counterLength;

    public RenameTemplate(String chars, int counterLength) {
        this.chars = chars;
        this.counterLength = counterLength;
    }

    public String getChars() {
        return chars;
    }

    public void setChars(String chars) {
        this.chars = chars;
    }

    public int getCounterLength() {
        return counterLength;
    }

    public void setCounterLength(int counterLength) {
        this.counterLength = counterLength;
    }
}
