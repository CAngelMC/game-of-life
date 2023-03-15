package life;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {

    private final JLabel generationLabel;

    public void setGenerationLabel(int generation) {
        generationLabel.setText("Generation #" + generation);
    }

    public void setAliveLabel(int alive) {
        aliveLabel.setText("Alive: " + alive);
    }

    private final JLabel aliveLabel;
    private final JPanel[][] grids;
    private final JToggleButton play;

    public Timer timer;


    public int generation = 0;
    public void setGeneration(int generation) {
        this.generation = generation;
    }


    public GameOfLife() {
        super("Game of Life");
        generationLabel = new JLabel();
        aliveLabel = new JLabel();
        JPanel scenarioBackground = new JPanel();
        play = new JToggleButton("Play");
        JButton resetButton = new JButton("Reset");

        generationLabel.setName("GenerationLabel");
        aliveLabel.setName("AliveLabel");
        play.setName("PlayToggleButton");
        resetButton.setName("ResetButton");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 850);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setVisible(true);

        generationLabel.setText("Generation #0");
        aliveLabel.setText("Alive: 0");

        scenarioBackground.setBackground(Color.BLACK);
        scenarioBackground.setBounds(0, 100, 750, 800);

        play.addActionListener(actionEvent -> {
            if (play.isSelected()) {
                timer.restart();
            } else {
                timer.stop();
            }
        });

        resetButton.addActionListener(actionEvent -> {
            setAliveLabel(0);
            setGeneration(0);
        });

        add(generationLabel);
        add(aliveLabel);
        add(scenarioBackground);
        add(play);
        add(resetButton);

        int size = 75;
        boolean flag = true;

        grids = new JPanel[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grids[i][j] = new JPanel();
                if (flag) {
                   grids[i][j].setBackground(Color.GREEN);
                } else {
                    grids[i][j].setBackground(Color.BLACK);
                }
                flag = !flag;

                grids[i][j].setBounds(j * 10, i*10, 10, 10);
                scenarioBackground.add(grids[i][j]);
            }
            flag = !flag;
        }

        scenarioBackground.setLayout(new GridLayout(size, size, 0, 0));

        try {
            life(size, 100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public void life(int size, int generations) throws InterruptedException {
        Universe baseUniverse = new Universe(size);
        Universe newUniverse = new Universe(size);
        Evolution evolution = new Evolution(baseUniverse, newUniverse, generations, this);

        evolution.evolutionGo();
    }

    public void updateUniverse(String[][] universe) {
        for (int i = 0; i < universe.length; i++) {
            for (int j = 0; j < universe.length; j++) {
                if (universe[i][j].equals("O")) {
                   grids[i][j].setBackground(Color.GREEN);
                } else {
                    grids[i][j].setBackground(Color.BLACK);
                }
            }
        }
    }

}