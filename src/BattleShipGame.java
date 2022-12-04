import java.util.Scanner;

public class BattleShipGame {

    private Display display;
    private Game game = new Game();
    private Input input;

    public BattleShipGame() {
       display = new Display();
    }

    public void start() {
        display.gameBeginning();
        mainMenu();
    }


    public void mainMenu() {

       int userChoice;
        boolean exit = false;
        input = new Input();

        while (!exit) {
            display.printMenu();
            System.out.println("Choose a option:");
            System.out.println();
            userChoice = input.getMenuOption();
            switch (userChoice) {
                case 0:
                    System.out.println("The game will start");
                    game.gameOn();
                    break;
                case 1:
                    System.out.println("See u next time");
                    exit();
                    break;
            }
        }
    }

    public void exit() {
        System.exit(0);
    }
}
