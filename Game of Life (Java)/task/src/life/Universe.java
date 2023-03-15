package life;

import java.util.Random;

public class Universe {
    String [][]universe;

    int size;


    public Universe(int size) {
        this.size = size;
        createUniverse(size);
    }

    public String[][] getUniverse() {
        return universe;
    }

    @Override
    public String toString() {
        String printedUniverse = "";
        String [][]universe = this.universe;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                printedUniverse += universe[i][j];
            }
            printedUniverse +="\n";
        }
        return printedUniverse;
    }

    public int getAlive() {
        int alive = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(universe[i][j].equals("O")) {
                   alive++;
                }
            }
        }

        return alive;
    }

    public void setUniverse(String[][] universe) {
        this.universe = universe;
    }

    public void saveState(String[][] universe) {
        int size = this.size;
        String[][] newUniverse = new String[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newUniverse[i][j] = universe[i][j];
            }
        }
        this.setUniverse(newUniverse);
    }

    void createUniverse(int size) {
        Random rand = new Random();
        String[][] universe = new String[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                universe[i][j] = rand.nextBoolean() ? "O" : " ";
            }
        }

        setUniverse(universe);
    }
}
