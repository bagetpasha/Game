import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        String castle = "\uD83C\uDFF0";
        int sizeBoard = 5;

        Hero hero = new Hero(sizeBoard);


        int step = 0;

        String[][] board = new String[sizeBoard][sizeBoard];
        for (int y = 0; y < sizeBoard; y++) {
            for (int x = 0; x < sizeBoard; x++) {
                board[y][x] = "  ";
            }
        }


        int countMonster = sizeBoard * sizeBoard - sizeBoard - 5;
        Random random = new Random();

        Monster[] arrMonster = new Monster[countMonster + 1];
        int count = 0;
        Monster test;
        while (count <= countMonster) {
            int value = random.nextInt(3);
            if (value == 0) {
                test = new Monster(sizeBoard);

            } else if(value == 1){
                test = new BigMonster(sizeBoard);

            } else {
                test = new SmallMonster(sizeBoard);
            }


            if (board[test.getY()][test.getX()].equals("  ")){
                board[test.getY()][test.getX()] = test.getImage();
                arrMonster[count] = test;
                count++;
            }

        }

        int castleX = random.nextInt(sizeBoard);
        int castleY = 0;


        board[castleY][castleX] = castle;

        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        System.out.println("Ваш ответ:\t" + answer);



        switch (answer) {
            case "ДА" -> {
                System.out.println("Выбери сложность игры(от 1 до 5):");
                int difficultGame = scanner.nextInt();
                System.out.println("Выбранная сложность:\t" + difficultGame);
                while (true) {
                    board[hero.getY() - 1][hero.getX() - 1] = hero.getImage();
                    outputBoard(board, hero.getLive());
                    System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку;" +
                            "\nКоординаты персонажа - (x: " + hero.getX() + ", y: " + hero.getY() + "))");
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();

                    if (hero.moveCorrect(x, y)) {
                        String next = board[y - 1][x - 1];
                        if (next.equals("  ")) {
                            board[hero.getY() - 1][hero.getX() - 1] = "  ";
                            hero.move(x, y);
                            step++;
                            System.out.println("Ход корректный; Новые координаты: " + hero.getX() + ", " + hero.getY() +
                                    "\nХод номер: " + step);
                        } else if (next.equals(castle)) {
                            System.out.println("Вы прошли игру!");
                            break;
                        }else {
                            for (Monster monster : arrMonster) {
                                if (monster.conflictHero(x, y)) {
                                    if (monster.taskMonster(difficultGame)) {
                                        board[hero.getY() - 1][hero.getX() - 1] = "  ";
                                        hero.move(x, y);

                                    } else {
                                        hero.downLive();
                                    }
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Неккоректный ход");
                    }
                }
            }
            case "НЕТ" -> System.out.println("Жаль, приходи еще!");
            default -> System.out.println("Данные введены неккоректно");
        }

    }

    static void outputBoard(String[][] board, int live) {
        String leftBlock = "| ";
        String rightBlock = "|";
        String wall = "+ —— + —— + —— + —— + —— +";

        for (String[] raw : board) {
            System.out.println(wall);
            for (String col : raw) {
                System.out.print(leftBlock + col + " ");
            }
            System.out.println(rightBlock);
        }
        System.out.println(wall);


        System.out.println("HPs:\t" + live + "\n");
    }
}