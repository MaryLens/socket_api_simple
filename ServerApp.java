package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

	public static void main(String[] args) throws IOException {

		System.out.println("Server starting");

		// create socket; wait for connections
		ServerSocket serverSocket = new ServerSocket(7777);
		Socket clientSocket = serverSocket.accept();

		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

		String strArr[] = (in.readLine().split(","));
		int sum = 0;
		for (int i = 0; i < strArr.length; i++) {
			sum += Integer.parseInt(strArr[i]);
			System.out.println(strArr[i]);
		}

		out.write(sum);
		out.flush();

		System.out.println("Server ending");
		clientSocket.close();
		out.close();
		in.close();

	}

}
