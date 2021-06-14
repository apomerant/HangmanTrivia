import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GetTrivia{
  public String answer;
  public String question;
  private String fileName;
  public String [] triviaParts;
  
  public GetTrivia(String fileName){
    this.answer = answer;
    this.question = question;
    this.fileName = fileName;
    this.triviaParts = triviaParts;
  }

  public String getAnswer(){
    try{
      BufferedReader reader = new BufferedReader(new FileReader(this.fileName));

      String line = null;
      while ((line = reader.readLine()) != null) {
        triviaParts = line.split(",");
      }
      reader.close();
    } catch (IOException x) {
      System.err.format("IOException: %s%n", x);
    }
    return triviaParts[1];
  }

  public String getQuestion(){
    try{
      BufferedReader reader = new BufferedReader(new FileReader(this.fileName));

      String line = null;
      while ((line = reader.readLine()) != null) {
        triviaParts = line.split(",");
      }
      reader.close();
    } catch (IOException x) {
      System.err.format("IOException: %s%n", x);
    }
    return triviaParts[0];
  }
}