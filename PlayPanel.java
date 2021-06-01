import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayPanel extends JPanel{
  public JButton instructionsBtn;
  public JButton homeBtn;
  public JButton guessBtn;
  public JLabel questionLbl;
  //public JText guessFieldTxt;
  public String question;
  

  public PlayPanel(JFrame homeFrame, JFrame instructionsFrame, JFrame playFrame) {
    super();
    this.setBounds(0, 0, 450, 150);
    this.setVisible(true);
    this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
    //creating buttons on play screen
    this.questionLbl = new JLabel("Question is here");
    this.instructionsBtn = new JButton("Instructions");
    this.homeBtn = new JButton("Home");
    this.guessBtn = new JButton ("Guess");
    //this.guessFieldTxt = new JText();
    this.question = question;

    this.add(questionLbl);
    this.add(instructionsBtn);
    this.add(homeBtn);
    //this.add(guessFieldTxt);
    this.add(guessBtn);
  

    instructionsBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent playToInstructions) {
        playFrame.setVisible(false);
        instructionsFrame.setVisible(true);
      }
    });

    homeBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent playToHome) {
        playFrame.setVisible(false);
        homeFrame.setVisible(true);
      }
    });

  }
  
}