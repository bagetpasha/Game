import java.util.Scanner;

public class BigMonster extends Monster {

    private String image = "\uD83D\uDC79";


    BigMonster(int sizeBoard) {
        super(sizeBoard);
    }


    public String getImage() {
        return image;
    }

    @Override
    public boolean taskMonster(int difficultGame) {
        System.out.println("Реши задачу:");

        if (difficultGame == 1) {
            return taskMonster();

        } else {

            int x = random.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
            int y = random.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
            int z = random.nextInt(100 * (difficultGame - 1), 100 * difficultGame);

            int trueAnswer = x * y - z;

            System.out.println("Реши пример: " + x + " * " + y + " - " + z + " = ?");

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






