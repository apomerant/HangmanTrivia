import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InstructionsPanel extends JPanel{
  public JButton homeBtn;
  public JButton playBtn;

  public InstructionsPanel(JFrame homeFrame, JFrame instructionsFrame, JFrame playFrame) {
    super();
    this.setBounds(0, 0, 400, 200);
    this.setVisible(true);
    this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
    //creating buttons on play screen
    String[] lines = this.toString().split("\n");
    for (String line : lines) {
      JLabel label = new JLabel(line);
      this.add(label);
    }
    this.homeBtn = new JButton("Home");
    this.playBtn = new JButton("Play!");

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

  //sets text of the instructions screen
  public String toString(){
    StringBuffer sb = new StringBuffer();
    sb.append("The goal of Hangman Trivia is to answer the trivia \n");
    sb.append("question, character by character. At the top of the \n");
    sb.append("\"Play\" screen, there is a trivia question. Enter \n");
    sb.append("letters one at a time in the textbox and hit the guess \n");
    sb.append("button to find out if that letter is in the answer to that \n");
    sb.append("question. Win by completing the word. 3 wrong \n");
    sb.append("guesses are allowed, before you lose. \n");
    return sb.toString();
  }

  
}