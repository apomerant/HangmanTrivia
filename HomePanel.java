import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;



public class HomePanel extends JPanel{
  public JLabel welcomeLbl;
  public JButton instructionsBtn;
  public JButton playBtn;

  public HomePanel() {
    super();
    this.setBounds(0, 0, 500, 150);
    this.setVisible(true);
    this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
    //creating buttons on play screen
    this.welcomeLbl = new JLabel("Welcome to hangman trivia");
    this.instructionsBtn = new JButton("Instructions");
    this.playBtn = new JButton("Play!");

    this.add(welcomeLbl);
    this.add(instructionsBtn);
    this.add(playBtn);
  }}