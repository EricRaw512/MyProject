import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame myFrame = new JFrame();
		Panel myPanel = new Panel();
		myFrame.setDefaultCloseOperation(myFrame.EXIT_ON_CLOSE);
		myFrame.add(myPanel);
		myFrame.pack();
		myFrame.setVisible(true);
		myFrame.setResizable(false);
		}
}
