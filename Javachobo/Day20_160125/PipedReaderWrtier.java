package Day20_160125;

import java.io.*;

public class PipedReaderWrtier {
	public static void main(String[] args) {
		InputThread inThread = new InputThread("InputThread");
		OutputThread outThread = new OutputThread("OutputThread");

		// PipedReader�� PipedWriter�� �����Ѵ�.
		inThread.connect(outThread.getOutput());
		inThread.start();
		outThread.start();
	}// main
}

class InputThread extends Thread {
	PipedReader input = new PipedReader();
	StringWriter sw = new StringWriter();

	public InputThread(String name) {
		// TODO Auto-generated constructor stub
		super(name);// Thread(String name);
	}

	public void run() {
		try {
			int data = 0;
			while ((data = input.read()) != -1) {
				sw.write(data);
			}
			System.out.println(getName() + " received : " + sw.toString());
		} catch (IOException e) {
		}
	}// run

	public PipedReader getInput() {
		return input;
	}

	public void connect(PipedWriter output) {
		try {
			input.connect(output);
		} catch (IOException e) {
		}
	}// connect
}

class OutputThread extends Thread {
	PipedWriter output = new PipedWriter();

	public OutputThread(String name) {
		// TODO Auto-generated constructor stub
		super(name);// Thread(String name);
	}

	public void run() {
		try {
			String msg = "Hello?";
			System.out.println(getName() + " sent: " + msg);
			output.write(msg);
			output.close();// piped������ ���ʸ� �ݾ��ָ� ��Ʈ���� ������.
		} catch (IOException e) {
		}
	}// run

	public PipedWriter getOutput() {
		return output;
	}

	public void connect(PipedReader input) {
		try {
			output.connect(input);
		} catch (IOException e) {
		}

	}// connect
}
