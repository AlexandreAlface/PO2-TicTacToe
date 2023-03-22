package pt.ipbeja.po2.tictactoe.tui;

import pt.ipbeja.po2.tictactoe.model.GameModel;
import pt.ipbeja.po2.tictactoe.model.View;

import java.util.Scanner;

public class TUI implements View {

    private final GameModel gameModel;

    public TUI()
    {

        this.gameModel =  new GameModel( this );

    }

    public void disablePosition(int line, int col) {
        System.out.println("Disable position (" +
                            line + "), (" + col + ")");
    }

    @Override
    public void incrementCounter(int count) {

        System.out.println(count + "");

    }

    private void askValue()
    {
        System.out.println("Specify line and col");
        Scanner s = new Scanner(System.in);
        int line = s.nextInt();
        int col = s.nextInt();

        this.gameModel.selectedPosition(line, col);
    }


    public static void main(String[] args)
    {
        TUI tui = new TUI();
        tui.askValue();
    }
}
