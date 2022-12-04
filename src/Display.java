public class Display {

    public void gameBeginning() {

        System.out.println("\u001B[33m" + "\n" +
                "▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\n" +
                "█▄ ▄ ▀██ ▄ ██ ▄ ▄ █ ▄ ▄ █▄ ▄███▄ ▄▄ ██████ ▄▄▄▄█ █ █▄ ▄█▄ ▄▄ █\n" +
                "██ ▄ ▀██ ▀ ████ █████ ████ ██▀██ ▄█▀██████▄▄▄▄ █ ▄ ██ ███ ▄▄▄█\n" +
                "▀▄▄▄▄▀▀▄▄▀▄▄▀▀▄▄▄▀▀▀▄▄▄▀▀▄▄▄▄▄▀▄▄▄▄▄▀▀▀███▄▄▄▄▄▀▄▀▄▀▄▄▄▀▄▄▄▀▀▀" + "\u001B[0m");
    }

    public void printMenu() {

        System.out.println("(0) Play \n" +
                "(1) Exit game");
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
                    case 'H' -> System.out.print('✔' + " ");
                    case 'M' -> System.out.print('✘' + " ");
                    case 'O' -> System.out.print('~' + " ");

                }
            }
            System.out.println();
        }
    }
}


