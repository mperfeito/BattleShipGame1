public class Board {
    private int rowSize;
    private int columnSize;
    Spot coordinates[][];


    public Board(int sizeA, int sizeB) {

        this.rowSize = sizeA;
        this.columnSize = sizeB;
        buildBoard(sizeA, sizeB);
    }

    public Spot getCoordinates(int a, int b) {

        return coordinates[a][b];
    }

    public int getRowSize() {

        return rowSize;
    }

    public int getColumnSize() {

        return columnSize;
    }

    public Spot[][] buildBoard(int a, int b) {

        coordinates = new Spot[rowSize][columnSize];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
              coordinates[i][j] = new Spot(i, j, SpotStatus.Ocean);
            }
        }
        return coordinates;
    }

    public void putShip(Spot spot,Ship ship){

        switch(ship.getShipType().getType()){
            case 1 -> {
                spot.setSpotStatus(SpotStatus.Ship);
                ship.add(spot);
            }
            case 2 -> {
                spot.setSpotStatus(SpotStatus.Ship);
                ship.add(spot);
                int a = spot.getA();
                int b = spot.getB();
                ship.add(new Spot(a,b+1,SpotStatus.Ship));
            }
            case 3 -> {
                spot.setSpotStatus(SpotStatus.Ship);
                ship.add(spot);
                 int a = spot.getA();
                int b = spot.getB();
                ship.add(new Spot(a,b+1,SpotStatus.Ship));
                ship.add(new Spot (a, b+2, SpotStatus.Ship));
            }
        }
    }
}
