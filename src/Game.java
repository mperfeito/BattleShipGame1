import java.util.ArrayList;

public class Game {

    private ArrayList<Ship> player1Ships = new ArrayList<>();
    private ArrayList<Ship> player2Ships = new ArrayList<>();
    ArrayList<Board> boards;

    public void gameOn(){

        Input board = new Input();
        boards = board.getGameBoards();
        Board player1Board = boards.get(0);
        Board player2Board = boards.get(1);
        for (int i = 0; i < 3 ; i++) {
            Ship ship = board.createShip(0);
            while(!ship.verifications(ship, player1Ships, player1Board)){
                System.out.println("Invalid ship coords, enter again");
                ship = board.createShip(0);
            }
            player1Ships.add(ship);
        }
        for (int i = 0; i < 3 ; i++) {
            Ship ship = board.createShip(1);
            while(!ship.verifications(ship,player2Ships, player2Board)){
                System.out.println("Invalid ship coords, enter again");
                ship = board.createShip(1);
            }
            player2Ships.add(ship);
        }
        Player player1 = new Player(player1Ships, player1Board);
        Player player2 = new Player(player2Ships, player2Board);
        boolean game = true;
        Display display = new Display();
        System.out.println("\u001B[34m" + "\uD83C\uDD3F\uD83C\uDD3B\uD83C\uDD30\uD83C\uDD48\uD83C\uDD34\uD83C\uDD41 1 \uD83C\uDD31\uD83C\uDD3E\uD83C\uDD30\uD83C\uDD41\uD83C\uDD33" + "\u001B[0m");
        display.printBoard(player1Board);
        System.out.println("\u001B[34m" + "---------------------" + "\u001B[0m" );
        System.out.println("\u001B[34m" + "\uD83C\uDD3F\uD83C\uDD3B\uD83C\uDD30\uD83C\uDD48\uD83C\uDD34\uD83C\uDD41 2 \uD83C\uDD31\uD83C\uDD3E\uD83C\uDD30\uD83C\uDD41\uD83C\uDD33" + "\u001B[0m");
        display.printBoard(player2Board);
        int numOfShipsPlayer1 = player1.spotsOccupied(player1Ships);
        int numOfShipsPlayer2 = player2.spotsOccupied(player2Ships);
        while (game) {
            int[] shootCoords;

            shootCoords = board.trys(0);
            if (player2.isHit(shootCoords[0], shootCoords[1])) numOfShipsPlayer2--;
            display.printBoard(player2.getBoard());
            if (numOfShipsPlayer2 == 0) {
                display.printBoard(player2.getBoard());
                System.out.println("\u001B[33m" + "\uD83C\uDD3F\uD83C\uDD3B\uD83C\uDD30\uD83C\uDD48\uD83C\uDD34\uD83C\uDD41 1 \uD83C\uDD46\uD83C\uDD38\uD83C\uDD3D\uD83C\uDD42 !" + "\u001B[0m");
                break;
            }

            shootCoords = board.trys(1);
            if (player1.isHit(shootCoords[0], shootCoords[1])) numOfShipsPlayer1--;
            display.printBoard(player1.getBoard());
            if (numOfShipsPlayer1 == 0) {
                display.printBoard(player1.getBoard());
                System.out.println("\u001B[33m" + "\uD83C\uDD3F\uD83C\uDD3B\uD83C\uDD30\uD83C\uDD48\uD83C\uDD34\uD83C\uDD41 2 \uD83C\uDD46\uD83C\uDD38\uD83C\uDD3D\uD83C\uDD42 !" + "\u001B[0m");
                break;
            }

        }

    }

}
