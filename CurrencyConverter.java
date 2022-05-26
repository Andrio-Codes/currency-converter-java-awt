import java.util.Scanner;
import java.awt.event.*;
import java.awt.*;


public class CurrencyConverter {
	private Frame mainFrame;
	private Panel upperPanel;
	private Panel lowerPanel;
	private Label fromLabel;
	private Label toLabel;
	private TextField fromTextField;
	private TextField toTextField;
	private Choice fromChoice;
	private Choice toChoice;
	private Button convertButton;
	private Button resetButton;
	private Label emptyLabel1;
	private Label emptyLabel2;


	public CurrencyConverter() {
		gui();
	}


	private void gui() {
		mainFrame = new Frame("Currency Converter");
		upperPanel = new Panel();
		lowerPanel = new Panel();
		fromLabel = new Label("From", Label.CENTER); 
		toLabel = new Label("To", Label.CENTER);
		fromTextField = new TextField();
		toTextField = new TextField();
		// toTextField.setEnabled(false); // disable writing 
		fromChoice = new Choice();
		fromChoice.add("INR");
		fromChoice.add("USD");
		fromChoice.add("EUR");
		fromChoice.add("QAR");
		toChoice = new Choice();
		toChoice.add("USD");
		toChoice.add("INR");
		toChoice.add("EUR");
		toChoice.add("QAR");
		emptyLabel1 = new Label();
		emptyLabel2 = new Label();
		convertButton = new Button("Convert");
		resetButton = new Button("Reset");
		resetButton.setEnabled(false); // disable the button by default

		// mainframe stuff
		mainFrame.setLayout(new GridLayout(2, 1));
		mainFrame.setSize(500, 500);
		mainFrame.setVisible(true);
		mainFrame.add(upperPanel);
		mainFrame.add(lowerPanel);

		// window closing func
		mainFrame.addWindowListener(new WindowAdapter() {
  			public void windowClosing(WindowEvent we) {
  				System.exit(0);
  			}
 		});

 		// upper panel stuff
		upperPanel.setLayout(new GridLayout(3, 3, 80, 5));
		upperPanel.add(fromLabel);
		upperPanel.add(toLabel);
		upperPanel.add(fromTextField);
		upperPanel.add(toTextField);
		upperPanel.add(fromChoice);
		upperPanel.add(toChoice);
		
		// lower panel stuff
		lowerPanel.setLayout(new GridLayout(2, 2, 50, 80));
		lowerPanel.add(convertButton);
		lowerPanel.add(resetButton);
		lowerPanel.add(emptyLabel1);
		lowerPanel.add(emptyLabel2);
	}

	private void actions() {
		// convert button actions
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer.parseInt(fromTextField.getText());
					
					// conversions
					// switch()
				}
				catch(NumberFormatException nfe) {
					fromTextField.setText("Invalid Input");
				}
				finally {
					resetButton.setEnabled(true);
				}
			}
		});

		// reset button actions
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ea) {
				fromTextField.setText("");
				toTextField.setText("");
				resetButton.setEnabled(false);
			}
		});
	}

	public static void main(String[] args) {
		CurrencyConverter cc = new CurrencyConverter();
		cc.actions();
	}

}