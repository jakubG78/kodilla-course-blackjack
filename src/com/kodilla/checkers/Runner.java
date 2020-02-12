package com.kodilla.checkers;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Runner extends Application {

    private Image imageback = new Image("file:resources/testField/chessboard.png");
    private Image piece = new Image("file:resources/testField/pieces/black_pawn.png");
//    private GridPane gridPane = new GridPane();

    @Override
    public void start (Stage primaryStage) throws Exception {

        ChessBoard thisBorad = new ChessBoard();
        thisBorad.initBoard();
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(0, 5, 5, 5));
        grid.setBackground(background);
        for (int i = 0; i < 8; i++) {
            ColumnConstraints column = new ColumnConstraints(60);
            grid.getColumnConstraints().add(column);
        }
        for (int i = 0; i < 8; i++) {
            RowConstraints row = new RowConstraints(60);
            grid.getRowConstraints().add(row);
        }
        grid.add(new ImageView(new Image("file:resources/testField/pieces/black_pawn.png")),0,0);
        grid.add(new ImageView(piece),0,1);
        grid.add(new ImageView(piece),1,2);
        grid.add(new ImageView(piece),7,7);
        Scene scene = new Scene(grid, 480, 480, Color.BLACK);
        Game game = new Game(thisBorad, grid);
//        game.displayBoard();
        primaryStage.setTitle("Chess board test");
        primaryStage.setScene(scene);
        primaryStage.show();
//
//        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
//        BackgroundImage backgroundImage = new BackgroundImage(new Image("file:resources/chessboard.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
//        Background background = new Background(backgroundImage);
//        gridPane.setAlignment(Pos.TOP_LEFT);
//        gridPane.setPadding(new Insets(0, 5, 5, 5));
//        gridPane.setBackground(background);
//        for (int i = 0; i < 8; i++) {
//            ColumnConstraints column = new ColumnConstraints(60);
//            gridPane.getColumnConstraints().add(column);
//        }
//        for (int i = 0; i < 8; i++) {
//            RowConstraints row = new RowConstraints(60);
//            gridPane.getRowConstraints().add(row);
//        }
//        Game game = new Game(thisBorad,gridPane);
//        game.displayBoard();
//        Scene scene = new Scene(gridPane, 480, 480);
//
//        primaryStage.setTitle("Checkers display test");
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
