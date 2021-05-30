public class HomeFrame{
  
  JFrame homeFrame = new JFrame("Home");
  homeFrame.setSize(500,600);
  homeFrame.setVisible(true);
  homeFrame.setLayout(null);

  JPanel homePanel = new JPanel();
  homePanel.setBounds(0, 0, 500, 600);
  homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.Y_AXIS));

  JLabel welcomeLbl = new JLabel("Welcome to hangman trivia!");
  JButton instructionsBtn = new JButton("Instructions");
  JButton playBtn = new JButton("Play!");

  //constructor
  public HomeFrame(JFrame homeFrame, JPanel homePanel, JLabel welcomeLbl, JButton instructionsBtn, JButton playBtn){
    this.homeFrame = homeFrame;
    this.homePanel = homePanel;
    this.welcomeLbl = welcomeLbl;
    this.instructionsBtn = instructionsBtn;
    this.playBtn = playBtn;
  }

  instructionsBtn.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent homeToInstructions) {
      this.homeFrame.setVisible(false);
      InstructionsFrame.instructionsFrame.setVisible(true);
    }
  });

  playBtn.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent homeToInstructions) {
      this.homeFrame.setVisible(false);
      PlayFrame.playFrame.setVisible(true);
    }
  });

  this.homeFrame.add(homePanel);
  
  this.homePanel.add(welcomeLbl);
  this.homePanel.add(instructionsBtn);
  this.homePanel.add(playBtn);
}