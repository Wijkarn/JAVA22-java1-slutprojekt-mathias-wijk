import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        GUI GUI = new GUI(today);

        GUI.createGUI();

    }
}