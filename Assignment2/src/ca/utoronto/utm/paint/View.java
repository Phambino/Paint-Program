package ca.utoronto.utm.paint;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
/**
 * This is the top level View+Controller, it contains other aspects of the View+Controller.
 * @author arnold
 *
 */
public class View extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private PaintModel model;
	
	// The components that make this up
	private PaintPanel paintPanel;
	private ShapeChooserPanel shapeChooserPanel;
	private ColorChooserPanel colorChooserPanel;
	private StrokeSizeSlider strokeSizeSlider;
	private JPanel subPanel;
	private ShapeFillPanel shapeFillPanel;
	
	public View(PaintModel model) {
		super("Paint"); // set the title and do other JFrame init
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(createMenuBar());
		
		Container c=this.getContentPane();
		this.shapeChooserPanel = new ShapeChooserPanel(this);
		c.add(this.shapeChooserPanel,BorderLayout.WEST);
	
		this.model=model;
		subPanel = new JPanel();
		
		this.paintPanel = new PaintPanel(model, this);
		c.add(this.paintPanel, BorderLayout.CENTER);
		
		this.colorChooserPanel = new ColorChooserPanel(this.paintPanel);
		subPanel.add(this.colorChooserPanel);
		
		this.shapeFillPanel = new ShapeFillPanel(this.paintPanel);
		subPanel.add(this.shapeFillPanel);
		
		this.strokeSizeSlider = new StrokeSizeSlider(this,this.paintPanel);
		subPanel.add(this.strokeSizeSlider);
		c.add(subPanel,BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
	}

	public PaintPanel getPaintPanel(){
		return paintPanel;
	}
	
	public ShapeChooserPanel getShapeChooserPanel() {
		return shapeChooserPanel;
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu;
		JMenuItem menuItem;

		menu = new JMenu("File");

		// a group of JMenuItems
		menuItem = new JMenuItem("New");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Open");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		menu = new JMenu("Edit");

		// a group of JMenuItems
		menuItem = new JMenuItem("Cut");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Copy");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Paste");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Undo");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Redo");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		return menuBar;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Exit") {
			System.exit(0);
		}
		if (e.getActionCommand() == "New"){
			model.getShapes().clear();
			model.getundoneShapes().clear();
			paintPanel.repaint();
		}
		if (e.getActionCommand() == "Undo"){
			model.undoShapes();
			paintPanel.repaint();
		}
		if (e.getActionCommand() == "Redo"){
			model.redoShapes();
			paintPanel.repaint();
		}
		System.out.println(e.getActionCommand());
	}

}
