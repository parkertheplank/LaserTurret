import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.OutputStream;
import java.io.PrintWriter;

import com.fazecast.jSerialComm.SerialPort;

public class TurretMouseMotion extends MouseAdapter {
	SerialPort port= SerialPort.getCommPort("COM4");
	String s="X20Y50";
	int x;
	int y;
	
	PrintWriter output = new PrintWriter(port.getOutputStream());
	
	public TurretMouseMotion() {
		port.openPort();
		port.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
		port.setComPortParameters(9600, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY); //not sure stop bit is correct
		
	}
	
	
	@Override
	public void mouseMoved(MouseEvent e) {
		x=(e.getX()*180)/800;
		y=(e.getY()*180)/800;
		s="X"+x+"Y"+y;
		
		System.out.println(s);
		output.print(s);
		output.flush();
		
	}
}
