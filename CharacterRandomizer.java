import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Random;


public class CharacterRandomizer extends Application {

    String[] names = {"Amari", "Blake", "Casey", "Drew", "Everest", "Finn", "Grey", "Harper", "Indigo", "Jules", "Koda", "Laven", 
    "Marlow", "Nova", "Olin", "Prism", "Quinn", "Ridley", "Sutton", "Tatum", "Umber", "Vesper", "Wren", "Xeneth", "Yael", "Zephyr"};

    String[] pronouns = {"they/them/their", "she/her/hers", "he/him/his"};

    String[] weapons = {"sword", "bow", "revolver"};

    String[] attributes = {"strength", "charisma", "wit"};

    String[] motives = {"love", "justice", "riches", "duty", "vengeance", "knowledge"};

    public Label name;
    public Label pronoun;
    public Label age;
    public Label gold;
    public Label weapon;
    public Label attribute;
    public Label motive;

    public TextField nameField;
    public TextField pronounField;
    public TextField ageField;
    public TextField goldField;
    public TextField weaponField;
    public TextField attributeField;
    public TextField motiveField;

    public Button generateButton;

    public int col = 15;

    public String returnRandom(String[] array) {
        int index;
        index = returnRandomInt(0, array.length - 1);
        return array[index];
    }

    public int returnRandomInt(int min, int max){
        Random random = new Random();
        int randomNum;
        randomNum = random.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    @Override
    public void start(Stage applicationStage) {
        
        Scene scene = null;
        GridPane gridPane = null;

        gridPane = new GridPane();
        scene = new Scene(gridPane);

        name = new Label("Name:");
        pronoun = new Label("Pronouns:");
        age = new Label("Age:");
        gold = new Label("Starting Gold:");
        weapon = new Label("Weapon:");
        attribute = new Label("Primary Attribute:");
        motive = new Label("Motive:");

        nameField = new TextField();
        nameField.setEditable(false);
        nameField.setPrefColumnCount(col);

        pronounField = new TextField();
        pronounField.setEditable(false);
        pronounField.setPrefColumnCount(col);

        ageField = new TextField();
        ageField.setEditable(false);
        ageField.setPrefColumnCount(col);

        goldField = new TextField();
        goldField.setEditable(false);
        goldField.setPrefColumnCount(col);

        weaponField = new TextField();
        weaponField.setEditable(false);
        weaponField.setPrefColumnCount(col);

        attributeField = new TextField();
        attributeField.setEditable(false);
        attributeField.setPrefColumnCount(col);

        motiveField = new TextField();
        motiveField.setEditable(false);
        motiveField.setPrefColumnCount(col);

        generateButton = new Button("Generate Character");

        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        gridPane.add(name, 0, 0);
        gridPane.add(nameField, 1, 0);
        gridPane.add(pronoun, 0, 1);
        gridPane.add(pronounField, 1, 1);
        gridPane.add(age, 0, 2);
        gridPane.add(ageField, 1, 2);
        gridPane.add(gold, 0, 3);
        gridPane.add(goldField, 1, 3);
        gridPane.add(weapon, 0, 4);
        gridPane.add(weaponField, 1, 4);
        gridPane.add(attribute, 0, 5);
        gridPane.add(attributeField, 1, 5);
        gridPane.add(motive, 0, 6);
        gridPane.add(motiveField, 1, 6);
        gridPane.add(generateButton, 0, 7, 2, 1);

        applicationStage.setScene(scene);
        applicationStage.setTitle("Character Randomizer");
        applicationStage.show();

        generateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nameField.setText(returnRandom(names));
                pronounField.setText(returnRandom(pronouns));
                ageField.setText(Integer.toString(returnRandomInt(18, 60)));
                goldField.setText(Integer.toString(returnRandomInt(10, 30)));
                weaponField.setText(returnRandom(weapons));
                attributeField.setText(returnRandom(attributes));
                motiveField.setText(returnRandom(motives));
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
