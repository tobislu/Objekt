package oving1;

public class LineEditor {
    private int insertionIndex = 0;
    private String text = "";

    public LineEditor(int insertionIndex, String text){
        this.insertionIndex = insertionIndex;
        this.text = text;
    }

    public LineEditor(){
        
    }

    public void left() {
        if (insertionIndex > 0) {
            insertionIndex -=1;
        }
    }
    public void right() {
        if (insertionIndex < text.length()) {
            insertionIndex +=1;
        }
    }
    public void insertString(String s) {
        this.text = this.text.substring(0, insertionIndex)
        + s + this.text.substring(insertionIndex);
        insertionIndex += s.length();
    }
    public void deleteLeft() {
        if (insertionIndex > 0) {
            text = text.substring(0, insertionIndex-1)
            +text.substring(insertionIndex);
            insertionIndex -= 1;
        }
    }
    public void deleteRight() {
        if (insertionIndex < text.length()) {
            text = text.substring(0, insertionIndex)
            +text.substring(insertionIndex+1);
        }
    }
    public String getText() {
        return text;
    }
    public void setText(String s) {
        text = s;
    }
    public int getInsertionIndex(){
        return insertionIndex;
    }

    public void setInsertionIndex(int i){
        insertionIndex = i;
    }
    
    @Override
    public String toString() {
        //return String.format("", , );'¨
        
        //var clone = new LineEditor(insertionIndex, text);
        //clone.insertString("|");
        //return clone.getText();
        String textOutput = text.substring(0, insertionIndex) 
        + "|" + text.substring(insertionIndex);
        return textOutput;
    }
    public static void main(String[] args) {
        //System.out.print("Start"+"Test".substring(4,4)+"end");
        var editor=new LineEditor(0, "Tobias Lunde");
        editor.right();
        editor.right();
        editor.insertString("x");
        System.out.println(editor);
        System.out.println(editor);
        System.out.println(editor);
        System.out.println(editor);
    }
}
