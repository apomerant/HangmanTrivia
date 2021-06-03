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
  public JTextField guessFieldTxt;
  public String question;
  

  public PlayPanel(JFrame homeFrame, JFrame instructionsFrame, JFrame playFrame) {
    super();
    this.setBounds(0, 0, 400, 30);
    this.setVisible(true);
    this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
    //creating buttons on play screen
    this.questionLbl = new JLabel("Question is here");
    this.instructionsBtn = new JButton("Instructions");
    this.homeBtn = new JButton("Home");
    this.guessBtn = new JButton ("Guess");
    this.guessFieldTxt = new JTextField("");
    this.question = question;

    //come back and check if this set the size correctly
    guessFieldTxt.setMaximumSize(new Dimension(100, 30));

    this.add(questionLbl);
    this.add(guessFieldTxt);
    this.add(guessBtn);
    this.add(instructionsBtn);
    this.add(homeBtn);
  

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

    guessBtn.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent playerGuessing) {
        String guessString = guessFieldTxt.getText();
        System.out.println(guessString);
        char [] guessCharArray = guessString.toCharArray();
        for (char c : guessCharArray) {
          System.out.println(c);
        }
        int lengthOfInput = guessCharArray.length;
        System.out.println("Length: " + lengthOfInput);
        if (lengthOfInput > 1){
          JOptionPane.showMessageDialog(playFrame, "Too many characters, please try again, with just one character.", "Oops!", JOptionPane.WARNING_MESSAGE);
        }
        else if (lengthOfInput < 1){
          JOptionPane.showMessageDialog(playFrame, "You need to enter a charcter to make a guess.", "Woopsie!", JOptionPane.WARNING_MESSAGE);
        }
      }
    });

  }
  
}