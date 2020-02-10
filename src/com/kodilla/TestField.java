package com.kodilla;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TestField extends Application {
    private Image imageback = new Image("file:resources/testField/chessboard.png");
    private Image piece = new Image("file:resources/testField/pieces/black_pawn.png");

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        primaryStage.setTitle("Chess board test");

        ImageView img = new ImageView(piece);

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
        grid.add(new ImageView(piece),0,0);
        grid.add(new ImageView(piece),0,1);
        grid.add(new ImageView(piece),1,2);
        grid.add(new ImageView(piece),7,7);
        Scene scene = new Scene(grid, 480, 480, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
