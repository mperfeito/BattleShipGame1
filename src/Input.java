import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    private Scanner sc = new Scanner(System.in);
    private ArrayList<Board> gameBoards = new ArrayList<>();
    int choice;
    private ArrayList<Integer> coords = new ArrayList<>();

    public ArrayList<Board> getGameBoards() {
        generateBoard();
        return gameBoards;
    }

    public int getMenuOption(){
        choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }
    public ArrayList<Integer> coordsAndTypeShip(){

        this.coords= new ArrayList<>();
        System.out.println("Select x:");
        int userChoice1 = sc.nextInt();
        sc.nextLine();
        System.out.println("Select y:");
        int userChoice2 = sc.nextInt();
        sc.nextLine();
        System.out.println("Select ship : \n " +
                "(1) Carrier \n+" +
                "(2) Cruiser \n+" +
                "(3) BattleShip");
        int userChoice3 = sc.nextInt();
        coords.add(userChoice1);
        coords.add(userChoice2);
        coords.add(userChoice3);
        return coords;
    }
    public Ship createShip(int player){

        int turn = player + 1;
        Spot shipPart;
        Ship ship;
        System.out.println("Player " + turn + "place ship");
        coords = coordsAndTypeShip();
        int x = coords.get(0);
        int y = coords.get(1);
        int shipType = coords.get(2);
        shipPart = new Spot(x,y,SpotStatus.Ship);
        ship = new Ship(new ArrayList<>(), ShipType.values()[shipType -1]);
       gameBoards.get(player).putShip(shipPart,ship);
       return ship;

    }

    public void generateBoard() {

        System.out.println("Select x size;");
        int x = sc.nextInt();
        sc.nextLine();
        System.out.println("Select y size:");
        int y = sc.nextInt();
        Board player1Board = new Board(x,y);
        Board player2Board = new Board(x,y);
        gameBoards.add(player1Board);
        gameBoards.add(player2Board);

    }

    public int[] trys(int player){

        int turn = player + 1;
        System.out.println("Player " + turn + "shoot");
        System.out.println("select x:");
        int x = sc.nextInt();
        sc.nextLine();
        System.out.println("Select y:");
        int y = sc.nextInt();
        return new int[]{x,y};

    }
}
