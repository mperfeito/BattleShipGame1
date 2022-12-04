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

        System.out.println("created ships");
        Player player1 = new Player(player1Ships, player1Board);
        Player player2 = new Player(player2Ships, player2Board);
        boolean game = true;
        Display display = new Display();
        System.out.println("Player 1 board");
        display.printBoard(player1Board);
        System.out.println("------------------");
        System.out.println("Player 2 board");
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
                System.out.println("Player 1 wins");
                break;
            }

            shootCoords = board.trys(1);
            if (player1.isHit(shootCoords[0], shootCoords[1])) numOfShipsPlayer1--;
            display.printBoard(player1.getBoard());
            if (numOfShipsPlayer1 == 0) {
                display.printBoard(player1.getBoard());
                System.out.println("Player 2 wins");
                break;
            }

        }

    }

}
