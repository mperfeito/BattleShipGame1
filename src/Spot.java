public class Spot {

    private int a;

    private int b;

    private SpotStatus spotStatus;

    public Spot(int a, int b, SpotStatus spotStatus) {
        this.a = a;
        this.b = b;
        this.spotStatus = spotStatus;
    }

    public Spot(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void setSpotStatus(SpotStatus spotStatus) {

        this.spotStatus = spotStatus;
    }

    public int getA() {

        return a;
    }

    public int getB() {

        return b;
    }

    public SpotStatus getSpotStatus() {

        return spotStatus;
    }

    public char getCharacter() {

        char character = ' ';
        switch (spotStatus) {
            case Hit -> character = 'H';
            case Miss -> character =  'M';
            case Ocean -> character = 'O';

        }
        return character;
    }
}
 