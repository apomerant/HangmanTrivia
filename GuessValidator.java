import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.lang.*;


public class GuessValidator{
  public JFrame frame;
  
  public GuessValidator (JFrame frame){
    this.frame = frame;
  }

  public boolean isValid(String guessString) {
    char [] guessCharArray = guessString.toCharArray();
    int lengthOfInput = guessCharArray.length;
    if (lengthOfInput > 1){
      JOptionPane.showMessageDialog(frame, "Too many characters, please try again, with just one character.", "Oops!", JOptionPane.WARNING_MESSAGE);
      return false;
    }
    else if (lengthOfInput < 1){
      JOptionPane.showMessageDialog(frame, "You need to enter a charcter to make a guess.", "Woopsie!", JOptionPane.WARNING_MESSAGE);
      return false;
    }
    else if (Character.isDigit(guessString.toCharArray()[0])){
      JOptionPane.showMessageDialog(frame, "This character is a number. It's not valid", "Oh no!", JOptionPane.WARNING_MESSAGE);
      return false;
    }
    else{
      return true;
    }
    
  }
  
}