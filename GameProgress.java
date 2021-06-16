import java.util.*;
import javax.swing.JFrame;

public class GameProgress{
  String answer;
  String gameResult;
  int lettersRemaining;
  HashSet<Character> wrongGuessSet = new HashSet(); 
  StringBuilder wrongGuessBuilder = new StringBuilder(); 
  public GuessValidator validator;
  public JFrame playFrame;


  public GameProgress(String answer, JFrame playFrame){
    this.answer = answer;
    char [] result = this.answer.toCharArray();
    this.lettersRemaining = result.length;
    this.playFrame = playFrame;
    this.validator = new GuessValidator(playFrame);
    

    for(int i = 0; i < result.length; i++){
      result[i] = '-';
    }
    this.gameResult = String.valueOf(result);
  }

  public String guessCharacter(char guess){
    char [] answerArray = this.answer.toCharArray();
    char [] resultArray = this.gameResult.toCharArray();
    

    this.wrongGuessSet.add(guess);
    for(int i = 0; i < answerArray.length; i++){
      if (guess == answerArray[i]){
        resultArray[i] = guess;
        lettersRemaining--;
        this.wrongGuessSet.remove(guess);
      }
    }
    
    this.gameResult = String.valueOf(resultArray);
    return this.gameResult;
  }

  public String getGameResult(){
    return this.gameResult;
  }

  public boolean isGameOver(){
    return this.lettersRemaining == 0;
  }
}