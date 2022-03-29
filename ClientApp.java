package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientApp {

	public static void main(String[] args) throws UnknownHostException, IOException {

		System.out.println("Client starting");

		// create socket; try to connect
		Socket clientSocket = new Socket("localhost", 7777);

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

		System.out.println("enter numbers separated by \",\"");

		String numbers = reader.readLine();
		out.write(numbers + "\n");
		out.flush();

		int sum = in.read();

		System.out.println("sum = " + sum);

		System.out.println("Cient ending");
		clientSocket.close();
		out.close();
		in.close();
	}

}
