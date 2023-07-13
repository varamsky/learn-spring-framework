package com.in28minutes.learnspringframework.game;

public class GameRunner {
    /**
     * Tightly coupled code
     * Here, GameRunner is tightly coupled to the MarioGame and SuperContraGame
     * In the AppGamingBasicJava.java if we want to change the game from MarioGame to SuperContraGame and vice versa
     * We will need to make changes to this GameRunner class as well
     * This brings in a lot of work for a very simple objective of "changing the game"
     * Therefore, this code is tightly coupled.*/

    private SuperContraGame game;

    public GameRunner(SuperContraGame game) {
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
