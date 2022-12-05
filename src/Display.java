public class Display {

    public void gameBeginning() {

        System.out.println("\u001B[33m" + "\n" +
                "\uD83C\uDD31\uD83C\uDD30\uD83C\uDD43\uD83C\uDD43\uD83C\uDD3B\uD83C\uDD34 \uD83C\uDD42\uD83C\uDD37\uD83C\uDD38\uD83C\uDD3F \uD83C\uDD36\uD83C\uDD30\uD83C\uDD3C\uD83C\uDD34" + "\u001B[0m");
    }

    public void printMenu() {

        System.out.println("\u001B[36m" +"\uD83C\uDD3C\uD83C\uDD34\uD83C\uDD3D\uD83C\uDD44:" + "\u001B[0m \n" +
                "\u001B[36m" + "0 🄿🄻🄰🅈" + "\u001B[0m \n" +
                "\u001B[36m" + "1 🄴🅇🄸🅃 🄶🄰🄼🄴" + "\u001B[0m");
    }

    public void printBoard(Board board) {

        System.out.print("  ");
        for (int i = 0; i < board.getRowSize(); i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int j = 0; j < board.getRowSize(); j++) {
            if (j < 10) {
                System.out.print(j + " ");
            } else {
                System.out.println(j);
            }
            for (int i = 0; i < board.getColumnSize(); i++) {
                switch (board.getCoordinates(j, i).getCharacter()) {
                    case 'H' -> System.out.print("\u001B[32m" + '✔' + "\u001B[0m" + " ");
                    case 'M' -> System.out.print("\u001B[31m" + '✘' + "\u001B[0m"  + " ");
                    case 'O' -> System.out.print("\u001B[34m" + '~' + "\u001B[0m"  + " ");

                }
            }
            System.out.println();
        }
    }
}


