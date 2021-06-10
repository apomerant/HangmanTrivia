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
  public String question = "TEST";
  public String answer = "TEST";
  public GuessValidator validator;
  public JLabel gameResultLbl;
  public GameProgress gameProgress;
  

  public PlayPanel(JFrame homeFrame, JFrame instructionsFrame, JFrame playFrame) {
    super();
    
    //creating buttons on play screen
    this.questionLbl = new JLabel("Question is here");
    this.instructionsBtn = new JButton("Instructions");
    this.homeBtn = new JButton("Home");
    this.guessBtn = new JButton ("Guess");
    this.guessFieldTxt = new JTextField("");
    this.question = question;
    this.validator = new GuessValidator(playFrame);
    this.answer = answer;
    this.gameProgress = new GameProgress(answer);
    this.gameResultLbl = new JLabel(this.gameProgress.getGameResult());


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
        validator.validate(guessString);
        String newResult = gameProgress.guessCharacter(guessString.toUpperCase().charAt(0));
        gameResultLbl.setText(newResult);
        if (gameProgress.isGameOver()){
          System.out.println("You win");
        }
      }
    });

  }
  
}