import javax.swing.JFrame;
import javax.swing.JPanel;

class Main {
  public static void main(String[] args) {
    JFrame homeFrame = new JFrame("Home");
    homeFrame.setSize(400,500);
    homeFrame.setVisible(true);
    homeFrame.setLayout(null);

    JFrame instructionsFrame = new JFrame ("Instructions");
    instructionsFrame.setSize(400,500);
    instructionsFrame.setVisible(false);
    instructionsFrame.setLayout(null);

    JFrame playFrame = new JFrame("Play");
    playFrame.setSize(400,500);
    instructionsFrame.setVisible(false);
    instructionsFrame.setLayout(null);

    HomePanel home = new HomePanel(homeFrame, instructionsFrame, playFrame);
    homeFrame.add(home);

    InstructionsPanel instructions = new InstructionsPanel(homeFrame, instructionsFrame, playFrame);
    instructionsFrame.add(instructions);

    PlayPanel play = new PlayPanel(homeFrame, instructionsFrame, playFrame);
    playFrame.add(play);
  }
}