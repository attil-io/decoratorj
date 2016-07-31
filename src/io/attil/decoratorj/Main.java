package io.attil.decoratorj;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import marvin.gui.MarvinImagePanel;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO; 

public class Main extends JFrame implements ActionListener { 
	private static final long serialVersionUID = 1L;


	private JPanel  panelBottom; 

	private JButton buttonGray,
					buttonEdgeDetector,
					buttonInvert,
					buttonReset;

	private MarvinImagePanel imagePanel;
	private MarvinImage      image,
							 backupImage;
	
	public Main() { 
		super("First Application");

		// Create Graphical Interface 
		buttonGray = new JButton("Gray");
		buttonGray.addActionListener(this); 
		buttonEdgeDetector = new JButton("EdgeDetector");
		buttonEdgeDetector.addActionListener(this); 
		buttonInvert = new JButton("Invert");
		buttonInvert.addActionListener(this); 
		buttonReset = new JButton("Reset");
		buttonReset.addActionListener(this); 

		panelBottom = new JPanel();
		panelBottom.add(buttonGray);
		panelBottom.add(buttonEdgeDetector);
		panelBottom.add(buttonInvert);
		panelBottom.add(buttonReset); 

		// ImagePanel 
		imagePanel = new MarvinImagePanel();
		
		Container l_c = getContentPane();
		l_c.setLayout(new BorderLayout());
		l_c.add(panelBottom, BorderLayout.SOUTH);
		l_c.add(imagePanel, BorderLayout.NORTH);
		
		image = MarvinImageIO.loadImage("./lena.gif");
		backupImage = image.clone();
		imagePanel.setImage(image);
		
		setSize(image.getWidth() + 50,image.getHeight() + 100);
		setVisible(true);
	}

	public static void main(String args[]){
		Main t = new Main(); 
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == buttonGray) {
		}
		else if (e.getSource() == buttonEdgeDetector) {
		}
		else if(e.getSource() == buttonInvert){
		}
	}
}