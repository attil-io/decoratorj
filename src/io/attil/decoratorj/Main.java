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
import marvin.image.MarvinImageMask; 
import marvin.plugin.MarvinImagePlugin; 
import marvin.util.MarvinPluginLoader;



public class Main extends JFrame implements ActionListener { 
	private static final long serialVersionUID = 1L;


	private JPanel  panelBottom; 

	private JButton buttonFlip,
					buttonGaussianBlur,
					buttonUndo,
					buttonCommit;

	private MarvinImagePanel imagePanel;
	private Image image;
	
	public Main() { 
		super("First Application");

		// Create Graphical Interface 
		buttonFlip = new JButton("Flip");
		buttonFlip.addActionListener(this); 
		buttonGaussianBlur = new JButton("Gaussian");
		buttonGaussianBlur.addActionListener(this); 
		buttonUndo = new JButton("Undo");
		buttonUndo.addActionListener(this); 
		buttonCommit = new JButton("Commit");
		buttonCommit.addActionListener(this); 

		panelBottom = new JPanel();
		panelBottom.add(buttonFlip);
		panelBottom.add(buttonGaussianBlur);
		panelBottom.add(buttonUndo);
		panelBottom.add(buttonCommit); 

		// ImagePanel 
		imagePanel = new MarvinImagePanel();
		
		Container l_c = getContentPane();
		l_c.setLayout(new BorderLayout());
		l_c.add(panelBottom, BorderLayout.SOUTH);
		l_c.add(imagePanel, BorderLayout.NORTH);
		
		MarvinImage marvinImage = MarvinImageIO.loadImage("./lena.gif");
		image = new BaseImage(marvinImage);
		
		refreshImage();
		
		setSize(marvinImage.getWidth() + 50, marvinImage.getHeight() + 100);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == buttonFlip) {
			image = new ImageFlipper(image);
		}
		else if (e.getSource() == buttonGaussianBlur) {
			image = new BlurFilter(image);
		}
		else if(e.getSource() == buttonUndo){
			image = image.getParent();
		}
		else if(e.getSource() == buttonCommit){
			image = new BaseImage(image.getInternalImage());
		}
		refreshImage();
	}
	
	private void refreshImage() {
		imagePanel.setImage(image.getInternalImage());
	}

	public static void main(String args[]){
		Main t = new Main(); 
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
}
