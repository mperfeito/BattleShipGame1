import java.util.ArrayList;

public class Player {

    private ArrayList<Ship> ships;
    private Board board;

    public Player(ArrayList<Ship> ships, Board board) {

        this.ships = ships;
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public int spotsOccupied(ArrayList<Ship> ships){

        int numberOfSpots = 0;
        for (Ship ship : ships) {
            numberOfSpots += ship.getShipType().getType();
        }
        return numberOfSpots;
    }

    public boolean isHit(int a, int b) {

        for (Ship ship : ships) {
            for (Spot spot : ship.getNewShip()) {
                if (spot.getB() == b && spot.getA() == a && spot.getSpotStatus().equals(SpotStatus.Ship)){
                    spot.setSpotStatus(SpotStatus.Hit);
                    board.getCoordinates(a,b).setSpotStatus(SpotStatus.Hit);
                    System.out.println("\u001B[35m" + "U hit a ship!" + "\u001B[0m");
                    return true;
                } else if (spot.getB() == b && spot.getA() == a && spot.getSpotStatus().equals(SpotStatus.Hit)){
                    spot.setSpotStatus(SpotStatus.Hit);
                    board.getCoordinates(a,b).setSpotStatus(SpotStatus.Hit);
                    System.out.println("\u001B[35m" + "Already Hit" + "\u001B[0m");
                    return false;
                }
            }
        }
        board.getCoordinates(a,b).setSpotStatus(SpotStatus.Miss);
        System.out.println("\u001B[35m" + "Try again" +  "\u001B[0m");
        return false;
    }
}


