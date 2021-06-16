import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePanel extends JPanel{
  public JLabel welcomeLbl;
  public JButton instructionsBtn;
  public JButton playBtn;
  

  public HomePanel(JFrame homeFrame, JFrame instructionsFrame, JFrame playFrame) {
    super();
    this.setBounds(0, 0, 400, 150);
    this.setVisible(true);
    this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
    //creating buttons on play screen
    this.welcomeLbl = new JLabel("Welcome to Hangman Trivia!");
    this.instructionsBtn = new JButton("Instructions");
    this.playBtn = new JButton("Play!");

    this.add(welcomeLbl);
    this.add(instructionsBtn);
    this.add(playBtn);
  

    instructionsBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent homeToInstructions) {
        homeFrame.setVisible(false);
        instructionsFrame.setVisible(true);
      }
    });

    playBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent homeToPlay) {
        homeFrame.setVisible(false);
        playFrame.setVisible(true);
      }
    });

  }
  
}