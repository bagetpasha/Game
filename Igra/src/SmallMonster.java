import java.util.Scanner;

public class SmallMonster extends  Monster {

    private String image = "\uD83D\uDC79";

    SmallMonster(int sizeBoard) {
        super(sizeBoard);
    }

    public String getImage() {
        return image;
    }

    @Override
    public  boolean taskMonster(int difficultGame) {
        System.out.println("Реши задачу:");

        if (difficultGame == 2) {
            return taskMonster();

        } else {

            int x = random.nextInt(10);
            int y = random.nextInt(10);

            int trueAnswer = x - y;

            System.out.println("Реши пример: " + x + " - " + y + " = ?");

            Scanner scanner = new Scanner(System.in);
            int ans = scanner.nextInt();

            if (trueAnswer == ans) {
                System.out.println("Ура! Всё верно, победа!");
                return true;

            } else {

                System.out.println("Не верно, ты проиграл эту битву!");
                return false;

            }

        }

    }

    public boolean taskMonster() {
        return  super.taskMonster(0);
    }

}
