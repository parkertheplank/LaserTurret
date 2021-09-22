import javax.swing.JFrame;

public class TurretPanel {
	
	public static void main(String[] args) {
		JFrame window = new JFrame("Laser Turret");
		window.getContentPane().addMouseMotionListener(new TurretMouseMotion());
		window.setSize(800, 800);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setVisible(true);
		window.setLocation(400,0);
	}
}
