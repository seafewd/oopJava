
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class GUI extends Application{

    double GAME_WIDTH = 400;
    double GAME_HEIGHT = 400;

    private AnimationTimer timer;
    private GraphicsContext fg;
    private GraphicsContext bg;


    private Car saab = new Saab95();

    @Override
    public void start(Stage stage) throws Exception {

        saab.startEngine();

        BorderPane root = new BorderPane();

        Canvas background = new Canvas(GAME_WIDTH, GAME_HEIGHT);
        bg = background.getGraphicsContext2D();
        Canvas foreground = new Canvas(GAME_WIDTH, GAME_HEIGHT);
        fg = foreground.getGraphicsContext2D();

        Pane pane = new Pane(background, foreground);
        root.setCenter(pane);

        timer = new AnimationTimer() {
            public void handle(long now) {
                render();
                saab.move(); // TODO create update method
            }
        };
        timer.start(); // TODO Move later

        Scene scene = new Scene(root ,600, 300);

        stage.setScene(scene);
        stage.show();
    }

    private void render() {
        fg.clearRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        draw(fg);
        fg.setFont(Font.font(14));
    }

    private void draw(GraphicsContext gc) {
        double x = saab.getXPos();
        double y = saab.getYPos();
        gc.fillRect(x, y, 50, 30);
    }


    public static void main(String[] args){
        launch(args);
    }


    // TODO update method
    // TODO menu for cars
    // TODO key events
    // TODO movement (steering, gas and brake) including rotation of square rendering


}
