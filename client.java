import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {
	public static void main(String[] args) throws IOException {
		
			Scanner reader = new Scanner(System.in);
			
			System.out.print("Please enter an ip: ");
			String ip = reader.nextLine();
		
			Socket socket = new Socket(ip, 4732);
			
			System.out.println("you have connected to the server");
			
			Thread receive = new Thread(new listener(socket));
			receive.start();
			
			PrintWriter pr = new PrintWriter(socket.getOutputStream());
			
			while(receive.isAlive()) {
				String input = reader.nextLine();
				pr.println(input);
				pr.flush();
			}
	}
}

