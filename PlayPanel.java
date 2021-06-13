import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;

public class PlayPanel extends JPanel{
  public JButton instructionsBtn;
  public JButton homeBtn;
  public JButton guessBtn;
  public JLabel questionLbl;
  public JTextField guessFieldTxt;
  public String question = "TEST";
  public String answer = "TEST";
  public GuessValidator validator;
  public JLabel gameResultLbl;
  public GameProgress gameProgress;
  public JLabel wrongGuessLbl;
  

  public PlayPanel(JFrame homeFrame, JFrame instructionsFrame, JFrame playFrame) {
    super();
    
    //creating buttons on play screen
    this.questionLbl = new JLabel(question);
    this.instructionsBtn = new JButton("Instructions");
    this.homeBtn = new JButton("Home");
    this.guessBtn = new JButton ("Guess");
    this.guessFieldTxt = new JTextField("");
    this.question = question;
    this.validator = new GuessValidator(playFrame);
    this.answer = answer;
    this.gameProgress = new GameProgress(answer, playFrame);
    this.gameResultLbl = new JLabel(this.gameProgress.getGameResult());
    this.wrongGuessLbl = new JLabel("Wrong guesses: ");


    this.setBounds(0, 0, 400, 30);
    this.setVisible(true);
    this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
    //come back and check if this set the size correctly
    guessFieldTxt.setMaximumSize(new Dimension(100, 30));

    this.add(questionLbl);
    this.add(guessFieldTxt);
    this.add(guessBtn);
    this.add(instructionsBtn);
    this.add(homeBtn);
    this.add(gameResultLbl);
    this.add(wrongGuessLbl);
  

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
        if(!validator.isValid(guessString)){
          return;
        }
        String newResult = gameProgress.guessCharacter(guessString.toUpperCase().charAt(0));
        gameResultLbl.setText(newResult);
        Iterator<Character> n = gameProgress.wrongGuessSet.iterator();
        gameProgress.wrongGuessBuilder.setLength(0); 
        while(n.hasNext()){
          gameProgress.wrongGuessBuilder.append(n.next()).append("     ");
        }
        String wrongGuessStr = "Wrong guesses: " + gameProgress.wrongGuessBuilder.toString();
        wrongGuessLbl.setText(wrongGuessStr);
        if (gameProgress.isGameOver()){
          System.out.println("You win");
        }
      }
    });

  }
  
}