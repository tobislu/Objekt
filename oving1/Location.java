package oving1;

public class Location {
    private int x = 0;
    private int y = 0;

    public void up(){
        y -= 1;
    }
    public void down(){
        y += 1;
    }
    public void left(){
        x -= 1;
    }
    public void right(){
        x += 1;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    @Override
    public String toString(){
        return String.format("x=%s, y=%s", x, y);
    }

    public static void main(String[] args){
        System.out.println(new Location());
    }
}
