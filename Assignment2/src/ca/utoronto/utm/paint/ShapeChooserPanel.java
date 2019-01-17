package ca.utoronto.utm.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class ShapeChooserPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view
	private ArrayList<JButton> modeButtons; // will store buttons so we can modify them later
	
	public ShapeChooserPanel(View view) {	
		this.view=view;
		this.modeButtons = new ArrayList<JButton>();
		
		ImageIcon icircle = new ImageIcon("icons\\icon-ios7-circle-outline-128.png","Circle");
		ImageIcon irect = new ImageIcon("icons\\square-icon-37191.png", "Rectangle");
		ImageIcon isquare = new ImageIcon("icons\\square-icon-37191.png","Square");
		ImageIcon isquiggle = new ImageIcon("icons\\doodles-36-128.png","Squiggle");
		ImageIcon ipolyline = new ImageIcon("icons\\actions-draw-freehand-icon.png","Polyline");
		ImageIcon iline = new ImageIcon("icons\\actions-draw-freehand-icon.png","Line");
		ImageIcon[] buttonIcons = {icircle,irect,isquare,isquiggle,ipolyline,iline};
		this.setLayout(new GridLayout(buttonIcons.length, 1));
		for (ImageIcon icons : buttonIcons) {
			JButton button = new JButton(icons.toString(), icons);
			this.add(button);
			button.addActionListener(this);
			modeButtons.add(button);
		}
	}
	
	/**
	 * Controller aspect of this
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.view.getPaintPanel().setMode(e.getActionCommand());
		this.view.getPaintPanel().setStrategy((e.getActionCommand()));
		for (JButton b: modeButtons) {
			b.setEnabled(true);
		}
		((JButton) e.getSource()).setEnabled(false);
		System.out.println(e.getActionCommand());
	}

	
}
