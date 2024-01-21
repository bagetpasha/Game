import java.util.Random;

public class Hero {
    private int x, y;
    private String image = "\uD83E\uDDD9\u200D";
    private int live = 3;
    Random random = new Random();

    Hero(int sizeBoard) {
        y = sizeBoard;
        int n = random.nextInt(sizeBoard);
        x = n == 0 ? 1 : n;
    }

   Hero(int x, int y){
        this.x = x;
        this.y = y;
    }
    Hero(){
        this(1, 1);
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLive() {
        return live;
    }

    public String getImage(){
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean moveCorrect(int x, int y){
        if (this.x == x && Math.abs(this.y - y) == 1 || this.y == y && Math.abs(this.x - x) == 1){
            return true;
        }
        return false;
    }

    void move(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void downLive(){
        live--;
    }
}

