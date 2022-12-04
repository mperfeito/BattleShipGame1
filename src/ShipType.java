public enum ShipType {

    Carrier(1),

    Cruiser(2),

    BattleShip(3);
    private int type;

    public int getType() {
        return type;
    }
    ShipType(int type) {

        this.type = type;
    }
}
