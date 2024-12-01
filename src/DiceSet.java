import java.io.BufferedReader;
import java.io.FileReader;

public class DiceSet {
    private static final int DICE_COUNT = 16;
    private Die[] dice;


    public DiceSet(String filename) {
        this.dice = new Die[DICE_COUNT];
        loadDice(filename);

        for (Die d : dice) {
            d.rollDie();
            System.out.println(d);
        }
    }

    public void loadDice(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            int cnt = 0;

            while ( (line = br.readLine()) != null ) {
                System.out.println(line);
                String[] elements = line.split(",");
                Die die = new Die(elements); // Build the die
                dice[cnt++] = die;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
