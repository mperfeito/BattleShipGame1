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
                    System.out.println("U hit a ship!");
                    return true;
                } else if (spot.getB() == b && spot.getA() == a && spot.getSpotStatus().equals(SpotStatus.Hit)){
                    spot.setSpotStatus(SpotStatus.Hit);
                    board.getCoordinates(a,b).setSpotStatus(SpotStatus.Hit);
                    System.out.println("Already Hit");
                    return false;
                }
            }
        }
        board.getCoordinates(a,b).setSpotStatus(SpotStatus.Miss);
        System.out.println("Try again");
        return false;
    }
}


