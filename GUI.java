import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Objects;

public class GUI {
	JFrame frame;
    Date date;
	JPanel panel[] = new JPanel[7];
    JLabel dateLabel[] = new JLabel[7];
    JTextArea dayList[] = new JTextArea[7];
    JTextField addDayList[] = new JTextField[7];
    JButton addButton[] = new JButton[7];
    JButton removeButton[] = new JButton[7];
    
    String day[] = new String[7];
    int windowWidth = 0;

    GUI(LocalDate today) {
        date = new Date(today);
    }

    public void createGUI() {
        frame = new JFrame("Java Calendar");
        frame.setSize(1241,539);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        for (int i=0; i<addButton.length;i++) {
            addButton[i] = new JButton();
            addButton[i].setText("ADD");
        }

        for (int i=0; i<removeButton.length;i++) {
            removeButton[i] = new JButton();
            removeButton[i].setText("Remove");
        }

        for (int i=0; i<day.length;i++)
            day[i] = "";

        //Aktiviteter i schemat
        day[0] = "Föreläsning på Grit\n";
        day[1] = "Spela golf.\n";
        day[2] = "Föreläsning på Grit\nNytt avsnitt av Andor\n";
        day[3] = "Föreläsning på Grit\n";
        day[4] = "Fredagsmys\n";

        for (int i=0; i<dateLabel.length;i++) {
            dateLabel[i] = new JLabel();
            dateLabel[i].setText(date.printDate(i));
            dateLabel[i].setFont(new Font("Helvetica",Font.BOLD,12));
            dateLabel[i].setForeground(Color.black);
        }

        for (int i=0; i<dayList.length;i++) {
            dayList[i] = new JTextArea(day[i], 25, 12);
            dayList[i].setLineWrap(true);
        }

        for (int i=0; i<addDayList.length;i++) {
            addDayList[i] = new JTextField(12);
        }

        actionAddActivity();

        actionRemoveActivity();

        setDateToday();

        for (int i=0; i<panel.length;i++) {
            panel[i] = new JPanel();
            panel[i].add(dateLabel[i]);
            panel[i].add(dayList[i]);
            panel[i].add(addDayList[i]);
            panel[i].add(addButton[i]);
            panel[i].add(removeButton[i]);
            panel[i].setBounds(windowWidth, 0, 175, 500);
            windowWidth += 175;
            if(i%2 == 1) {
            	panel[i].setBackground(new Color(124,124,124));
            }
            else {
            	panel[i].setBackground(new Color(77,77,77));
            }
        }

        for (int i=0; i<panel.length;i++)
            frame.add(panel[i]);
        
        frame.setVisible(true);
    }

    public void actionAddActivity() {
        for (int i=0; i<addButton.length;i++) {

            int j = i;

            addButton[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    day[j] += addDayList[j].getText() + "\n";
                    dayList[j].setText(day[j]);
                    addDayList[j].setText("");
                }
            });
        }
    }

    public void actionRemoveActivity() {
        for (int i=0; i<removeButton.length;i++) {
            int j = i;

            removeButton[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    day[j] = "";
                    dayList[j].setText(day[j]);
                }
            });
        }
    }

    public void setDateToday() {

        for (int i=0; i<dateLabel.length; i++) {
            if (Objects.equals(date.checkDate(i), date.dateToday())) dateLabel[i].setForeground(Color.red);
        }
    }
}
