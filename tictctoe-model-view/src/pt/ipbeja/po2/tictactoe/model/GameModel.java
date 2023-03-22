package pt.ipbeja.po2.tictactoe.model;

public class GameModel {

    private View view;
    private int selectedLine;
    private int selectedCol;
    int counter;


    public GameModel(View board)
    {
        this.view = board;
    }

    public void selectedPosition(int line, int col) {

        // TO DO store line
        // TO DO store col

        view.disablePosition(line, col);
    }



}




