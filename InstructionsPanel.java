import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InstructionsPanel extends JPanel{
  public JLabel instructionsLbl;
  public JButton homeBtn;
  public JButton playBtn;

  public InstructionsPanel(JFrame homeFrame, JFrame instructionsFrame, JFrame playFrame) {
    super();
    this.setBounds(0, 0, 400, 150);
    this.setVisible(true);
    this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
    //creating buttons on play screen
    this.instructionsLbl = new JLabel("These are the instructions");
    this.homeBtn = new JButton("Home");
    this.playBtn = new JButton("Play!");

    this.add(instructionsLbl);
    this.add(homeBtn);
    this.add(playBtn);

    homeBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent instructionsToHome) {
        instructionsFrame.setVisible(false);
        homeFrame.setVisible(true);
      }
    });

    playBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent instructionsToHome) {
        instructionsFrame.setVisible(false);
        playFrame.setVisible(true);
      }
    });

  }

  
}