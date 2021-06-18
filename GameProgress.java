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
  public int guessesLeft;


  public GameProgress(String answer, JFrame playFrame){
    this.answer = answer;
    char [] result = this.answer.toCharArray();
    this.lettersRemaining = result.length;
    this.playFrame = playFrame;
    this.validator = new GuessValidator(playFrame);
    this.guessesLeft = 3;
    
    //setting up initial dashes on screen for the answer word
    for(int i = 0; i < result.length; i++){
      result[i] = '-';
    }
    this.gameResult = String.valueOf(result);
  }

  public String initializeDash(String answer){
    char [] result = answer.toCharArray();
    for(int i = 0; i < result.length; i++){
      result[i] = '-';
    }
    return String.valueOf(result);
  }

  public String guessCharacter(char guess){
    char [] answerArray = this.answer.toCharArray();
    char [] resultArray = this.gameResult.toCharArray();
    
    //runs after user inputs a guess
    boolean found = false;
    int foundCount = 0;
    boolean previouslyGuessed = false;
    for(int i = 0; i < answerArray.length; i++){
      if (guess == resultArray[i]){
        previouslyGuessed = true;
      }
      else if (guess == answerArray[i]){
        resultArray[i] = guess;
        found = true;
        foundCount++;
      }
    }
    if (!previouslyGuessed){
      if (!found){
        this.guessesLeft--;
        this.wrongGuessSet.add(guess);
      }
      else{
        this.lettersRemaining -= foundCount;
      }
    }
        
    this.gameResult = String.valueOf(resultArray);
    return this.gameResult;
  }

  //ending game or showing wrong guesses that are left
  public String getGameProgress(){
    if (this.isGameOver()){
      if (this.lettersRemaining == 0){
        return "You win!";
      }
      else{
        return "Loser";
      }
    }
    else if (this.guessesLeft > 0){
      return "You have " + this.guessesLeft + " guesses left";
    }
    else{
      return "";
    }
    
  }

  public String getGameResult(){
    return this.gameResult;
  }

  public boolean isGameOver(){
    return this.lettersRemaining == 0 || this.guessesLeft == 0;
  }
}