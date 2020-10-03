import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class listener implements Runnable{
	
	public Socket socket;
	
	public listener(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		InputStreamReader in = null;
		try {
			in = new InputStreamReader(socket.getInputStream());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		BufferedReader bf = new BufferedReader(in);
		String StrIn = null;
		
		final boolean running = true;
		
		while(running & socket.isConnected()) {
			try {
				StrIn = bf.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("server: " + StrIn);
		}
	}
	
}

