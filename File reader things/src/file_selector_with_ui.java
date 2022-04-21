import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class file_selector_with_ui {

	public static void main(String[] args) {
		// TODO Make a working GUI for my file reader
		// declaring the JFrame elements
		Font spaceman = new Font("Courier",Font.PLAIN,15);
		JTextField box = new JTextField("Enter text file directory");
		JTextArea bigbox = new JTextArea("No file loaded");
		JFrame frame = new JFrame();
		JButton open = new JButton("open file");
		
		// Set the modifiers for the JButton
		open.setBounds(0, 560, 130, 100);
		open.setFont(spaceman);
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String red = "";
					File text = new File(box.getText());
					Scanner scan = new  Scanner(text);
					while(scan.hasNext()) {
						red = red + (scan.nextLine()+"\n");
					}
					bigbox.setText(red);
					scan.close();
				} catch (FileNotFoundException e1) {
					bigbox.setText("File not Found\nPlease try again");
				}
			}
		});
		
		// Modifiers for the JTextField
		box.setBounds(130,560,570,100);
		box.setFont(spaceman);
		
		// Modifiers for the JTextArea
		bigbox.setBounds(0,0,700,560);
		bigbox.setFont(spaceman);
		
		// Initialize the JFrame 
		frame.add(bigbox);
		frame.add(box);
		frame.add(open);
		frame.setSize(700,700);
		frame.setLayout(null);
		frame.setVisible(true);
	}

}
