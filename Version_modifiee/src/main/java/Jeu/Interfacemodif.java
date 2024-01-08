    package Jeu;


    import entites.*;
    import javafx.animation.AnimationTimer;
    import javafx.animation.KeyFrame;
    import javafx.animation.PathTransition;
    import javafx.animation.Timeline;
    import javafx.application.Application;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.image.Image;
    import javafx.scene.image.ImageView;
    import javafx.scene.input.MouseEvent;
    import javafx.scene.layout.Pane;
    import javafx.scene.paint.Color;
    import javafx.scene.shape.Line;
    import javafx.stage.Stage;
    import javafx.scene.control.Label;
    import javafx.scene.text.Font;
    import javafx.util.Duration;

    import java.io.File;
    import java.util.ArrayList;
    import java.util.Random;
    import javafx.scene.media.Media;
    import javafx.scene.media.MediaPlayer;
    import javafx.stage.WindowEvent;
    import javafx.util.Duration;


    public class Interfacemodif extends Application {

        private Frog frog;
        private Pane gamePane;

        private final ArrayList<ImageView> flyImageViews = new ArrayList<>();
        private final ArrayList<ImageView> abeilleImageViews = new ArrayList<>();
        private final ArrayList<ImageView> btflyImageViews = new ArrayList<>();
        private final ArrayList<ImageView> moImageViews = new ArrayList<>();

        private final Random random = new Random();
        private final int flyGenerationInterval = 10; // seconds
        private final int beeGenerationInterval = 5; // seconds
        private final int btGenerationInterval = 8;
        private final int moGenerationInterval = 13;
        private long lastFlyGenerationTime = 0;
        private long lastBeeGenerationTime = 0;
        private long lastbtflyGenerationTime = 0;
        private long lastmoGenerationTime = 0;
        private MediaPlayer backgroundMediaPlayer;
        private MediaPlayer clickMediaPlayer;
        private MediaPlayer eatMediaPlayer;
        private boolean gameOver = false;

        private Line tongue;


        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) {


            frog = new Frog("Freddy");
            gamePane = new Pane();
            Label label = new Label(String.valueOf(frog.Score));
            label.setTextFill(Color.RED);
            label.setFont(new Font(20));
            label.setTranslateX(550);
            label.setTranslateY(30);
            Label label2 = new Label("Score:");
            label2.setTranslateX(550);
            label2.setTextFill(Color.RED);
            label2.setFont(new Font(20));

            //playSoundBG("./src/main/java/sounds/background.mp3");
            backgroundMediaPlayer = createMediaPlayer("./src/main/java/sounds/background.mp3");
            clickMediaPlayer = createMediaPlayer("./src/main/java/sounds/tonge.mp3");
            eatMediaPlayer = createMediaPlayer("./src/main/java/sounds/eatfly.mp3");
            backgroundMediaPlayer.play();
            ImageView frogImageView = createFrogImageView();

            Image backgroundImage = new Image("file:src/main/java/images/img.jpg");
            ImageView backgroundImageView = new ImageView(backgroundImage);
            backgroundImageView.setFitWidth(600);
            backgroundImageView.setFitHeight(400);

            tongue = new Line();
            Color lineColor = Color.web("#ff7887");
            tongue.setStroke(lineColor);
            tongue.setStrokeWidth(10);



            gamePane.getChildren().add(backgroundImageView);
            gamePane.getChildren().add(frogImageView);
            gamePane.getChildren().add(label);
            gamePane.getChildren().add(label2);
            gamePane.getChildren().add(tongue);


            // Add initial insects
            for (int i = 0; i < 5; i++) {
                flyImageViews.add(createFlyImageView());
            }

            gamePane.setOnMouseClicked(this::handleMouseClick);

            Scene scene = new Scene(gamePane, 600, 400);


            primaryStage.setTitle("Frog Fly Game");
            primaryStage.setScene(scene);
            primaryStage.show();
            /*primaryStage.getScene().addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
                clickMediaPlayer.seek(Duration.ZERO);
                clickMediaPlayer.play();
            });*/


            // Start the game loop
            startGameLoop(label);
        }




        private MediaPlayer createMediaPlayer(String soundURL) {
            String uriString = new File(soundURL).toURI().toString();
            Media media = new Media(uriString);
            return new MediaPlayer(media);
        }
        private ImageView createFrogImageView() {
            Image frogImage = new Image("file:src/main/java/images/Capture.PNG");
            ImageView frogImageView = new ImageView(frogImage);
            frogImageView.setFitWidth(100);
            frogImageView.setFitHeight(100);
            frogImageView.relocate(300, 200);
            frogImageView.setUserData(frog);
            return frogImageView;
        }

        private ImageView createAbeilleImageView() {
            Image beeImage = new Image("file:src/main/java/images/bee.png");
            Abeille abeille = new Abeille(11, 1, 5);
            ImageView abeilleImageView = new ImageView(beeImage);
            abeilleImageView.setFitWidth(25);
            abeilleImageView.setFitHeight(25);
            abeilleImageView.relocate(Math.random() * 250, Math.random() * 150);
            gamePane.getChildren().add(abeilleImageView);
            abeilleImageView.setUserData(abeille);
            return abeilleImageView;
        }

        private ImageView createFlyImageView() {
            Random random = new Random();
            int masse= random.nextInt(5) + 1;
            int speed= random.nextInt(5) + 1;
            Fly fly = new Fly(10,1);
            Image flyImage = new Image("file:src/main/java/images/ahmad.png");
            ImageView flyImageView = new ImageView(flyImage);
            flyImageView.setFitWidth(25);
            flyImageView.setFitHeight(25);
            flyImageView.relocate(Math.random() * 250, Math.random() * 150);
            gamePane.getChildren().add(flyImageView);
            flyImageView.setUserData(fly);
            return flyImageView;
        }

        private ImageView createbtflyImageView() {
            Image btflyImage = new Image("file:src/main/java/images/butterfly.png");
            Papillon btfly = new Papillon(5, 5, "red");
            ImageView btflyImageView = new ImageView(btflyImage);
            btflyImageView.setFitWidth(25);
            btflyImageView.setFitHeight(25);
            btflyImageView.relocate(Math.random() * 250, Math.random() * 150);
            gamePane.getChildren().add(btflyImageView);
            btflyImageView.setUserData(btfly);
            return btflyImageView;
        }

        private ImageView createmoImageView() {
            Random random = new Random();
            int rnd= random.nextInt(2);
            Image moImage;
            Moustique mous;

            if(rnd == 0)
            {
                moImage = new Image("file:src/main/java/images/moustique.png");
                mous = new Moustique(11, 1, false);

            }
            else
            {
                moImage = new Image("file:src/main/java/images/moustiquep.png");
                mous = new Moustique(11, 1, true);
            }

            ImageView moImageView = new ImageView(moImage);
            moImageView.setFitWidth(25);
            moImageView.setFitHeight(25);
            moImageView.relocate(Math.random() * 250, Math.random() * 150);
            gamePane.getChildren().add(moImageView);
            moImageView.setUserData(mous);
            return moImageView;
        }

        private void handleMouseClick(MouseEvent event) {
            clickMediaPlayer.seek(Duration.ZERO);
            clickMediaPlayer.play();
            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();

            double frogX = 350; // Set the frog's X position
            double frogY = 240; // Set the frog's Y position
            tongue.setVisible(true);
            tongue.setStartX(frogX);
            tongue.setStartY(frogY);

            // Set the end point of the tongue to the clicked position
            tongue.setEndX(mouseX);
            tongue.setEndY(mouseY);

            //tongue.setEndX(frogX);
            //tongue.setEndY(frogY);
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(0.2), event1 -> tongue.setVisible(false))
            );
            timeline.play();






            // Animate the tongue using PathTransition

            flyImageViews.stream()
                    .filter(flyImageView -> isClicked(flyImageView, mouseX, mouseY))
                    .findFirst()
                    .ifPresent(this::feedFrogFly);

            abeilleImageViews.stream()
                    .filter(AbeilleImageView -> isClicked(AbeilleImageView, mouseX, mouseY))
                    .findFirst()
                    .ifPresent(this::feedFrogAbeille);

            btflyImageViews.stream()
                    .filter(btflyImageView -> isClicked(btflyImageView, mouseX, mouseY))
                    .findFirst()
                    .ifPresent(this::feedFrogbtfly);

            moImageViews.stream()
                    .filter(moImageView -> isClicked(moImageView, mouseX, mouseY))
                    .findFirst()
                    .ifPresent(this::feedFrogmo);
        }

        private boolean isClicked(ImageView imageView, double mouseX, double mouseY) {
            double imageX = imageView.getLayoutX() + imageView.getTranslateX();
            double imageY = imageView.getLayoutY() + imageView.getTranslateY();
            double distance = Math.sqrt(Math.pow(imageX - mouseX, 2) + Math.pow(imageY - mouseY, 2));
            return distance <= imageView.getFitWidth() / 2;
        }

        private void feedFrogFly(ImageView flyImageView) {
            frog.eat((Fly) flyImageView.getUserData());
            if(((Fly) flyImageView.getUserData()).isDead())
            {
                gamePane.getChildren().remove(flyImageView);
                eatMediaPlayer.seek(Duration.ZERO);
                eatMediaPlayer.play();
            }
        }

        private void feedFrogAbeille(ImageView AbeilleImageView) {
            frog.eat((Abeille) AbeilleImageView.getUserData());
            gamePane.getChildren().remove(AbeilleImageView);
        }

        private void feedFrogbtfly(ImageView btflyImageView) {
            frog.eat((Papillon) btflyImageView.getUserData());
            if(((Papillon) btflyImageView.getUserData()).isDead())
            {
                gamePane.getChildren().remove(btflyImageView);
                eatMediaPlayer.seek(Duration.ZERO);
                eatMediaPlayer.play();
            }
        }

        private void feedFrogmo(ImageView moImageView) {
            frog.eat((Moustique) moImageView.getUserData());
            gamePane.getChildren().remove(moImageView);
        }

        private void startGameLoop(Label label) {
            new AnimationTimer() {
                @Override
                public void handle(long now) {
                    moveInsects();
                    label.setText(String.valueOf(frog.Score));
                    generateInsects(now);


                }
            }.start();
        }


        private void moveInsects() {
            flyImageViews.forEach(this::moveFly);
            abeilleImageViews.forEach(this::moveAbeille);
            btflyImageViews.forEach(this::movebtfly);
            moImageViews.forEach(this::movemo);
        }

        private void moveFly(ImageView flyImageView) {
            /*flyImageView.setTranslateX(flyImageView.getTranslateX() + Math.random() * 2 );
            if(flyImageView.getTranslateX()>400)
            flyImageView.setTranslateX(-600);*/


            flyImageView.setTranslateX(flyImageView.getTranslateX() + Math.random() * 5 - 2.5);
            flyImageView.setTranslateY(flyImageView.getTranslateY() + Math.random() * 5 - 2.5);
            constrainInsectToBounds(flyImageView);
        }

        private void moveAbeille(ImageView AbeilleImageView) {
            AbeilleImageView.setTranslateX(AbeilleImageView.getTranslateX() + Math.random() * 5 - 2.5);
            AbeilleImageView.setTranslateY(AbeilleImageView.getTranslateY() + Math.random() * 5 - 2.5);
            constrainInsectToBounds(AbeilleImageView);
        }

        private void movebtfly(ImageView btflyImageView) {
            btflyImageView.setTranslateX(btflyImageView.getTranslateX() + Math.random() * 5 - 2.5);
            btflyImageView.setTranslateY(btflyImageView.getTranslateY() + Math.random() * 5 - 2.5);
            constrainInsectToBounds(btflyImageView);
        }

        private void movemo(ImageView moImageView) {
            moImageView.setTranslateX(moImageView.getTranslateX() + Math.random() * 5 - 2.5);
            moImageView.setTranslateY(moImageView.getTranslateY() + Math.random() * 5 - 2.5);
            constrainInsectToBounds(moImageView);
        }

        private void constrainInsectToBounds(ImageView insectImageView) {
            double maxX = gamePane.getWidth() - insectImageView.getFitWidth();
            double maxY = gamePane.getHeight() - insectImageView.getFitHeight();
            double newX = Math.min(maxX, Math.max(0, insectImageView.getTranslateX()));
            double newY = Math.min(maxY, Math.max(0, insectImageView.getTranslateY()));
            insectImageView.setTranslateX(newX);
            insectImageView.setTranslateY(newY);
        }


        private void generateInsects(long now) {
            if (frog.Score >= 50 && (now - lastbtflyGenerationTime) >= 1_000_000_000L * btGenerationInterval) {
                btflyImageViews.add(createbtflyImageView());
                lastbtflyGenerationTime = now;
            }
            if (frog.Score >= 50 && (now - lastmoGenerationTime) >= 1_000_000_000L * moGenerationInterval) {
                moImageViews.add(createmoImageView());
                lastmoGenerationTime = now;
            }
            if (frog.Score > 100 && (now - lastBeeGenerationTime) >= 1_000_000_000L * beeGenerationInterval) {
                abeilleImageViews.add(createAbeilleImageView());
                lastBeeGenerationTime = now;
            }
            if ((now - lastFlyGenerationTime) >= 1_000_000_000L * flyGenerationInterval) {
                flyImageViews.add(createFlyImageView());
                lastFlyGenerationTime = now;
            }
        }
    }





