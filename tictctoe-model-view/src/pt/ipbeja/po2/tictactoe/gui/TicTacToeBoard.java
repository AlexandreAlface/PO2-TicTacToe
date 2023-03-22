package pt.ipbeja.po2.tictactoe.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import pt.ipbeja.po2.tictactoe.model.GameModel;
import pt.ipbeja.po2.tictactoe.model.View;

public class TicTacToeBoard extends VBox
                            implements View {

    private static final int SIZE = 3;
    private GameModel gameModel;
    private BoardButton[][] buttons;
    private int counter = 0;

    private GridPane gridPane = new GridPane();
    private Label label = new Label("0");

    public TicTacToeBoard()
    {
        this.buttons = new BoardButton[SIZE][SIZE];
        this.gameModel =  new GameModel( this );
        this.createBoard();
    }

    private void createBoard() {
        EventHandler<ActionEvent> bHandler = (event) ->  {
                BoardButton button = (BoardButton)event.getSource();
                int line = button.getLine();
                int col = button.getCol();
                gameModel.selectedPosition(line, col);
                this.incrementCounter(++this.counter);

        };
        for (int line = 0; line < SIZE; line++) {
            for (int col = 0; col < SIZE; col++) {
                BoardButton button = new BoardButton(line + ", " + col, line, col);
                button.setOnAction( bHandler ) ;
                this.gridPane.add(button, col, line); // add grid
                buttons[line][col] = button;
            }
        }

        this.getChildren().addAll(label, gridPane);
    }


    public void disablePosition(int line, int col) {
        buttons[line][col].setDisable(true);
    }

    @Override
    public void incrementCounter(int count) {

        this.label.setText(count+ "");

    }



    // older notation (the newwer is translated to this one)
//    private void createBoard() {
//        ButtonHandler bHandler = new ButtonHandler();
//        for (int line = 0; line < SIZE; line++) {
//            for (int col = 0; col < SIZE; col++) {
//                BoardButton button = new BoardButton(line + ", " + col, line, col);
//                button.setOnAction( bHandler ) ;
//                this.add(button, col, line); // add grid
//                buttons[line][col] = button;
//            }
//        }
//    }
//
//    class ButtonHandler implements EventHandler<ActionEvent>
//    {
//        @Override
//        public void handle(ActionEvent event) {
//            BoardButton button = (BoardButton)event.getSource();
//            int line = button.getLine();
//            int col = button.getCol();
//            gameModel.selectedPosition(line, col);
//        }
//    }
}
