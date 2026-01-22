package oving1;

public class LineEditor {
    private int insertionIndex;
    private String text;

    public LineEditor(){
        this.insertionIndex = insertionIndex;
        this.text = text;
    }
    public void left() {
        this.insertionIndex -=1;
    }
    public void right() {
        this.insertionIndex +=1;
    }
    public void insertString(String s) {
        this.text = this.text.substring(0, insertionIndex)
        + s + this.text.substring(insertionIndex);
    }
    public void deleteLeft() {

    }
    public void deleteRight() {

    }
    public String getText() {
        return null;
    }
    public void setText(String s) {

    }
    public int getInsertionIndex(){
        return null;
    }

    public String toString() {
        return String.format("", , );
    }
    public static void main(String[] args) {

    }
}
