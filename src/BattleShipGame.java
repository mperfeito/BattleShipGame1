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
            userChoice = input.getMenuOption();
            switch (userChoice) {
                case 0:
                    System.out.println("\u001B[35m" +"🅃🄷🄴 🄶🄰🄼🄴 🅆🄸🄻🄻 🅂🅃🄰🅁🅃 ..." + "\u001B[0m");
                    game.gameOn();
                    break;
                case 1:
                    System.out.println("\u001B[36m" + "See u next time ! " + "\u001B[0m" );
                    exit();
                    break;
            }
        }
    }
    public void exit() {
        System.exit(0);
    }
}
