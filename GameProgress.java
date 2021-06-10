import java.util.*;

public class GameProgress{
  String answer;
  String gameResult;
  int lettersRemaining;
  HashSet<Character> wrongGuessSet = new HashSet(); 
  StringBuilder wrongGuessBuilder = new StringBuilder(); 

  public GameProgress(String answer){
    this.answer = answer;
    char [] result = this.answer.toCharArray();
    this.lettersRemaining = result.length;
    
    for(int i = 0; i < result.length; i++){
      result[i] = '-';
    }
    this.gameResult = String.valueOf(result);
  }

  public String guessCharacter(char guess){
    char [] answerArray = this.answer.toCharArray();
    char [] resultArray = this.gameResult.toCharArray();
    for(int i = 0; i < answerArray.length; i++){
      if (guess == answerArray[i]){
        resultArray[i] = guess;
        lettersRemaining--;
      }
      else{
        this.wrongGuessSet.add(guess);
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