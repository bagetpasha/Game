import java.util.Random;
import java.util.Scanner;

public class Monster {


    private String image = "\uD83E\uDDDF\u200D";
    private final int x, y;
    Random random = new Random();

    Monster(int sizeBoard){
        this.y = random.nextInt(sizeBoard - 1);
        this.x = random.nextInt(sizeBoard);
    }

    public String getImage() {
        return image;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public boolean conflictHero(int perX, int perY){
        return perY - 1 == this.y && perX - 1 == this.x;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean taskMonster(int difficultGame) {

        System.out.println("Реши задачу:");

        int x = random.nextInt(100);
        int y = random.nextInt(100);
        int trueAnswer = x + y;

        System.out.println("Реши пример: " + x + " + " + y + " = ?");

        Scanner scanner = new Scanner(System.in);
        int ans = scanner.nextInt();

        if (trueAnswer == ans) {
            System.out.println("Ура! Всё верно, победа!");
            return true;
        } else {
            System.out.println("Не верно, ты проиграл эту битву!");
            return  false;
        }

    }

}







