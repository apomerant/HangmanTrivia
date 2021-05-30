import javax.swing.JFrame;
import javax.swing.JPanel;

class Main {
  public static void main(String[] args) {
    JFrame homeFrame = new JFrame("Home");
    homeFrame.setSize(500,600);
    homeFrame.setVisible(true);
    homeFrame.setLayout(null);

    HomePanel home = new HomePanel();
    homeFrame.add(home);
    System.out.println("Panel has been created");
  }
}