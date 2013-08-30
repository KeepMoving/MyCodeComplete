package socketSampleFromHeadFirstJava;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class SimpleChatClient 
{
	JTextArea incoming;
	JTextField outgoing;
	BufferedReader reader;
	PrintWriter writer;
	Socket sock;
	public static void main(String[] args) 
	{
		SimpleChatClient client = new SimpleChatClient();
		client.go();
	}
	
	public void go()
	{
		JFrame frame = new JFrame("Ludicrously Simple Chat Client");
		JPanel mainPanel = new JPanel();
		incoming = new JTextArea(15,50);
		incoming.setLineWrap(true);
		incoming.setEditable(false);
		JScrollPane qScroller = new JScrollPane(incoming);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("send");
		sendButton.addActionListener(new SendButtonListener());
		mainPanel.add(qScroller);
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		setUpNetWorking();
		
		Thread readerThread = new Thread(new IncomingReader());
		readerThread.start();
		
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		frame.setSize(400,500);
		frame.setVisible(true);
	}
	
	private void setUpNetWorking()
	{
		try {
			sock = new Socket("127.0.0.1",5000);
			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(streamReader);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("networking established");
		} catch (UnknownHostException uhe) {
			// TODO Auto-generated catch block
			System.out.println("UnknownHostException:" + uhe.getMessage());
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			System.out.println("IOException:" + ioe.getMessage());
		}
	}
	
	public class SendButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ev) 
		{
			writer.println(outgoing.getText());
			writer.flush();
			
			outgoing.setText("");
			outgoing.requestFocus();
		}
	}
	
	public class IncomingReader implements Runnable
	{
		public void run()
		{
			String message;

			try {
				while((message = reader.readLine()) != null)
				{
					System.out.println(message);
					incoming.append(message + "\n");
				}
			} catch (IOException ioe) {
				// TODO Auto-generated catch block
				System.out.println("IOException:" + ioe.getMessage());
			} catch (Exception e){
				System.out.println("Exception:" + e.getMessage());
			}

		}
	}
}
