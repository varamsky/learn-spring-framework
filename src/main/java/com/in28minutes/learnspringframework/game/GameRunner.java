package com.in28minutes.learnspringframework.game;

public class GameRunner {
    /**
     * Loosely coupled code
     * With the GamingConsole Interface we have loosely coupled the GameRunner class and the MarioGame, SuperContraGame and PacmanGame classes
     * Now, in the AppGamingBasicJava.java if we want to change the game from MarioGame to another other game and vice versa
     * We will need to change only the object in the AppGamingBasicJava.java
     * No changes will be needed in the GameRunner class
     * This solves the problem and minimizes the number of code changes needed for a very simple objective of "changing the game"
     * Therefore, this code is loosely coupled.*/

    private GamingConsole game;

    public GameRunner(GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running game: " + game);

        game.up();
        game.down();
        game.left();
        game.right();
    }
}
