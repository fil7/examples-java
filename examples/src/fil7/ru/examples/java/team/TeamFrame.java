package fil7.ru.examples.java.team;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Java 8 для чайников
 */
@SuppressWarnings("serial")
public class TeamFrame extends JFrame{

    public TeamFrame() throws IOException {
        Player player;
        Scanner hankeesData = new Scanner(new File("C:\\Users\\Мария\\IdeaProjects\\fil7\\java_tutorial\\src\\fil7.ru.java.team\\Hankees.txt"));
        String name;
        double d;
        for (int num = 1; num <= 9; num++) {
            name = hankeesData.nextLine();
            d = hankeesData.nextDouble();
            player = new Player(name, d);
            //hankeesData.nextLine();
            addPlayerInfo(player);
        }

        setTitle("Average hankees");
        setLayout(new GridLayout(9, 2, 20, 3));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        hankeesData.close();
    }

    void addPlayerInfo (Player player) {
        add(new JLabel(" " + player.getName()));
        add(new JLabel(player.getAverageString()));
    }
}
