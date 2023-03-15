package life;

import javax.swing.*;

public class Evolution {

    Universe newUniverse;
    Universe baseUniverse;
    int generations;

    GameOfLife gameOfLife;
    public Timer timer;
    public Evolution(Universe baseUniverse, Universe newUniverse,int generations, GameOfLife gameOfLife) {
        this.baseUniverse = baseUniverse;
        this.newUniverse = newUniverse;
        this.generations = generations;
        this.gameOfLife = gameOfLife;
    }

    public void evolutionGo() {
        timer = new Timer(300, e -> {
            gameOfLife.setGeneration(gameOfLife.generation + 1);
            calculateNewUniverse();
            gameOfLife.setGenerationLabel(gameOfLife.generation);
            gameOfLife.setAliveLabel(newUniverse.getAlive());
            gameOfLife.updateUniverse(newUniverse.getUniverse());
        });
        timer.restart();
        gameOfLife.setTimer(timer);
    }

    private void calculateNewUniverse() {
        Universe universe = this.baseUniverse;
        Universe newUniverse = this.newUniverse;
        String[][] currentUniverse = universe.universe;
        String[][] newUniverseArray = newUniverse.universe;
        int numberOfNeighbours;
        for (int i = 0; i < universe.size; i++) {
            for (int j = 0; j < universe.size; j++) {
                numberOfNeighbours = findNumberOfNeighbours(currentUniverse, i, j);
                if (numberOfNeighbours < 2 || numberOfNeighbours > 3) {
                    newUniverseArray[i][j] = " ";
                } else if ((numberOfNeighbours == 2 || numberOfNeighbours == 3) && currentUniverse[i][j].equals("O")) {
                    newUniverseArray[i][j] = "O";
                } else if (currentUniverse[i][j].equals(" ") && numberOfNeighbours == 3) {
                    newUniverseArray[i][j] = "O";
                }
            }
        }
        this.baseUniverse.saveState(newUniverseArray);
    }

    private int findNumberOfNeighbours(String[][] currentUniverse, int row, int column) {
        int numberOfNeighbours = 0;
        int newRow;
        int newColumn;
        int size = currentUniverse.length;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                newRow = row + i;
                newColumn = column + j;

                if(newRow < 0) {
                    newRow = size - 1;
                }

                if(newRow >= size) {
                    newRow = 0;
                }

                if(newColumn < 0) {
                    newColumn = size - 1;
                }

                if(newColumn >= size) {
                    newColumn = 0;
                }

                if(currentUniverse[newRow][newColumn].equals("O") && !(newRow == row && newColumn == column)){
                    numberOfNeighbours++;
                }
            }
        }
        return numberOfNeighbours;
    }
}
