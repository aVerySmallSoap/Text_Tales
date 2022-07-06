package Lirys.Interface;
import javax.swing.*;
import java.awt.*;

public class UserInterface {

    // Get Screen
    private final Dimension userScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final double getUserScreenHeight = userScreenSize.getHeight();
    private final double getUserScreenWidth = userScreenSize.getWidth();


    private final JFrame Frame1 = new JFrame();

    private final JPanel logPanel = new JPanel();

    private final JButton Button1 = new JButton("Hello");

    private final JLabel welcomeLabel = new JLabel("Text-Tales!");

    private final ImageIcon ICON = new ImageIcon(
            Toolkit
                    .getDefaultToolkit()
                    .getImage(
                            getClass().getResource("/Images/Text-tales.png")
                    )
    );


    public void createUI()
    {
        //Panels
        logPanel.setBounds(new Rectangle(Frame1.getWidth(), Frame1.getHeight()/2));
        logPanel.setLayout(new BorderLayout());
        logPanel.setBackground(Color.BLACK);

        //Buttons
        Button1.setSize(new Dimension(0,0));

        //Labels


        //Main UI Frame
        Frame1.add(logPanel);
        logPanel.add(Button1, BorderLayout.AFTER_LAST_LINE);
        logPanel.add(welcomeLabel);
        Frame1.setLayout(new CardLayout());
        Frame1.setSize(userScreenSize);
        Frame1.setTitle("Text-Tales!");
        Frame1.setIconImage(ICON.getImage());
        Frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        logPanel.setVisible(true);
        Frame1.setVisible(true);
        Button1.setVisible(true);
        welcomeLabel.setVisible(true);
    }
}
