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
  public GetTrivia getTrivia;
  public JLabel progressLbl;  
  public JButton restartBtn;

  public PlayPanel(JFrame homeFrame, JFrame instructionsFrame, JFrame playFrame) {
    super();
    
    //creating buttons, JLabels and txt field on play screen
    //initializes other classes in this class
    this.getTrivia = new GetTrivia("QuestionAnswer.txt");
    this.validator = new GuessValidator(playFrame);
    TriviaQuestion trivia = getTrivia.getRandomQuestion();
    this.question = trivia.question;
    this.answer = trivia.answer;

    this.instructionsBtn = new JButton("Instructions");
    this.homeBtn = new JButton("Home");
    this.guessBtn = new JButton ("Guess");
    this.guessFieldTxt = new JTextField("");
    this.questionLbl = new JLabel(question);
    this.wrongGuessLbl = new JLabel("Wrong guesses: ");
    this.restartBtn = new JButton("Restart");

    this.gameProgress = new GameProgress(answer, playFrame);
    this.gameResultLbl = new JLabel(this.gameProgress.getGameResult());
    this.progressLbl = new JLabel(this.gameProgress.getGameProgress());
    
    this.setBounds(0, 0, 400, 30);
    this.setVisible(true);
    this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
    guessFieldTxt.setMaximumSize(new Dimension(100, 30));

    this.add(questionLbl);
    this.add(guessFieldTxt);
    this.add(guessBtn);
    this.add(gameResultLbl);
    this.add(wrongGuessLbl);
    this.add(progressLbl);
    this.add(restartBtn);
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
        progressLbl.setText(gameProgress.getGameProgress());
        if (gameProgress.isGameOver()){
          guessBtn.setEnabled(false);
        }
      }
    });

    restartBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent restart) {
        System.out.println("reset");
        
        TriviaQuestion trivia = getTrivia.getRandomQuestion();
        answer = trivia.answer;
        char [] result = answer.toCharArray();
        for(int i = 0; i < result.length; i++){
          result[i] = '-';
        }
        
        String gameResult = String.valueOf(result);
        
        question = trivia.question;
        questionLbl.setText(question);
        gameProgress = new GameProgress(answer, playFrame);
        
        gameResultLbl.setText(gameResult);
        gameProgress.wrongGuessSet.clear();
        gameProgress.guessesLeft = 3;
        wrongGuessLbl.setText("Wrong guesses: ");
        progressLbl.setText("You have 3 guesses left");
        guessBtn.setEnabled(true);
      }
    });

  }
  
}