import java.util.ArrayList;

public class Ship {
    private ArrayList<Spot> newShip;
    private ShipType shipType;

    public Ship(ArrayList<Spot> spot, ShipType shipType) {

        this.newShip = spot;
        this.shipType = shipType;
    }

    public ArrayList<Spot> getNewShip() {

        return newShip;
    }

    public ShipType getShipType() {

        return shipType;
    }

    public void add(Spot spot) {
        newShip.add(spot);
    }

    public boolean verifications(Ship ship, ArrayList<Ship> ships, Board board) {

        for (int i = 0; i < ship.getNewShip().size(); i++) {
            Spot spot = ship.getNewShip().get(i);
            if (spot.getB() < 0) return false;
            if (spot.getA() < 0) return false;
            if (spot.getB() >= board.getColumnSize()) return false;
            if (spot.getA() >= board.getRowSize()) return false;

            for (int k = 0; k < ships.size(); k++) {
                for (int j = 0; j < ships.get(k).getNewShip().size(); j++) {
                    Spot spot2 = ships.get(k).getNewShip().get(j);
                    if (spot.getA() == spot2.getA()) return false;
                    if (spot.getB() == spot2.getB()) return false;
                }
            }
        }

        return true;
    }
}

