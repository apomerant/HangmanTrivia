import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Arrays;
import java.lang.Object;
import java.util.Random;

public class GetTrivia{
  
  private String fileName;
  
  public List<TriviaQuestion> triviaQuestions;
  

  public GetTrivia(String fileName){
    
    this.fileName = fileName;
    
    this.triviaQuestions = this.readQuestions();
  }

  //turns each line in text file into question+answer
  public List<TriviaQuestion> readQuestions(){
    List<TriviaQuestion> result = new ArrayList<TriviaQuestion>();
    try{
      BufferedReader reader = new BufferedReader(new FileReader(this.fileName));

      String line = null;
      while ((line = reader.readLine()) != null) {
        
        String [] triviaParts = line.split(",");
        TriviaQuestion question = new TriviaQuestion(triviaParts[0], triviaParts[1]);
        result.add(question);
      }
      reader.close();
    } catch (IOException x) {
      System.err.format("IOException: %s%n", x);
    }
    return result;
  }

  //randomly chooses which line of text file to use as question and answer
  public TriviaQuestion getRandomQuestion(){
    int max = this.triviaQuestions.size();
    int min = 0;
    
    int index = (int)Math.floor(Math.random()*(max-min+1)+min);
    return this.triviaQuestions.get(index);
  }
}