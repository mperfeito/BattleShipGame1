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
        System.out.println("\u001B[35m" + "Select x:" + "\u001B[0m");
        int userChoice1 = sc.nextInt();
        sc.nextLine();
        System.out.println("\u001B[35m" + "Select y:" + "\u001B[0m");
        int userChoice2 = sc.nextInt();
        sc.nextLine();
        System.out.println("\u001B[35m" + "Select ship: \n" +
                "1 Carrier \n" +
                "2 Cruiser \n" +
                "3 BattleShip" + "\u001B[0m");
        int userChoice3 = sc.nextInt();
        if (userChoice3 > 3){
            System.out.println("Choose a valid option");
        }
        coords.add(userChoice1);
        coords.add(userChoice2);
        coords.add(userChoice3);
        return coords;
    }
    public Ship createShip(int player){

        int turn = player + 1;
        Spot shipPart;
        Ship ship;
        System.out.println( "\u001B[35m" + "\uD83C\uDD3F\uD83C\uDD3B\uD83C\uDD30\uD83C\uDD48\uD83C\uDD34\uD83C\uDD41 "  + turn  + " \uD83C\uDD3F\uD83C\uDD3B\uD83C\uDD30\uD83C\uDD32\uD83C\uDD34 \uD83C\uDD42\uD83C\uDD37\uD83C\uDD38\uD83C\uDD3F" + "\u001B[0m");
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

        System.out.println("\u001B[35m" + "Select x size:" + "\u001B[35m" );
        int x = sc.nextInt();
        sc.nextLine();
        System.out.println("\u001B[35m" + "Select y size:" + "\u001B[0m" );
        int y = sc.nextInt();
        Board player1Board = new Board(x,y);
        Board player2Board = new Board(x,y);
        gameBoards.add(player1Board);
        gameBoards.add(player2Board);

    }

    public int[] trys(int player){

        int turn = player + 1;
        System.out.println("\u001B[35m" + "\uD83C\uDD3F\uD83C\uDD3B\uD83C\uDD30\uD83C\uDD48\uD83C\uDD34\uD83C\uDD41 " + turn + " \uD83C\uDD42\uD83C\uDD37\uD83C\uDD3E\uD83C\uDD3E\uD83C\uDD43" + "\u001B[0m");
        System.out.println("\u001B[35m" + "select x:" + "\u001B[0m");
        int x = sc.nextInt();
        sc.nextLine();
        System.out.println("\u001B[35m" + "Select y:" + "\u001B[0m");
        int y = sc.nextInt();
        return new int[]{x,y};

    }
}
