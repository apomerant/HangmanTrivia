import javax.swing.JFrame;
import javax.swing.JPanel;

class Main {
  public static void main(String[] args) {
    JFrame homeFrame = new JFrame("Home");
    homeFrame.setSize(500,600);
    homeFrame.setVisible(true);
    homeFrame.setLayout(null);

    JFrame instructionsFrame = new JFrame ("Instructions");
    instructionsFrame.setSize(500,600);
    instructionsFrame.setVisible(false);
    instructionsFrame.setLayout(null);

    HomePanel home = new HomePanel(homeFrame, instructionsFrame);
    homeFrame.add(home);

    InstructionsPanel instructions = new InstructionsPanel(homeFrame, instructionsFrame);
    instructionsFrame.add(instructions);
    System.out.println("Panel has been created");
  }
}