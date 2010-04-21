package fi.hy.laskin.main.view;

import fi.hy.laskin.main.Const;
import fi.hy.laskin.main.Controller;
import fi.hy.laskin.main.View;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class View_Implementation extends JFrame  implements View {

	private static final String	SKIN_PLASTIC3D	= "skin_3d";
	private static final String	SKIN_SYSTEM	= "skin_system";
	private static final String	SKIN_PLASTIC	= "skin_plastic";
	private static final int	OUTPUT_AREA_WIDTH	= 1; // Element layout is broken (should be redone); if this is set wider than the actual size of the textarea, things look odd
	private static final int	OUTPUT_AREA_HEIGHT	= 250;
	private static final String	EXIT_PROGRAM	= "Exit";

	private static final long	serialVersionUID	= -2212730761656490235L;
	
	/**
	 * Causes a button on the UI to be pressed if a key that matches that button is typed 
	 */
	private class KeyListener_Impl implements KeyListener {
		private final static int KEEP_BUTTON_PRESSED_TIME = 50; // ms
		private final Map<Character, JButton> charToButtonMapping;
		public KeyListener_Impl() {
			this.charToButtonMapping = new HashMap<Character, JButton>();
			charToButtonMapping.put('0', button_0);
			charToButtonMapping.put('1', button_1);
			charToButtonMapping.put('2', button_2);
			charToButtonMapping.put('3', button_3);
			charToButtonMapping.put('4', button_4);
			charToButtonMapping.put('5', button_5);
			charToButtonMapping.put('6', button_6);
			charToButtonMapping.put('7', button_7);
			charToButtonMapping.put('8', button_8);
			charToButtonMapping.put('9', button_9);
			charToButtonMapping.put('+', button_add);
			charToButtonMapping.put('-', button_substraction);
			charToButtonMapping.put('*', button_multiply);
			charToButtonMapping.put('/', button_divide);
			charToButtonMapping.put('^', button_power);
			charToButtonMapping.put(',', button_decimalPoint);
			charToButtonMapping.put('.', button_decimalPoint);
			charToButtonMapping.put('=', button_equals);
			charToButtonMapping.put('\r', button_equals);
			charToButtonMapping.put('\n', button_equals);
			charToButtonMapping.put('\b', button_backspace);
		}

		@Override
		public void keyPressed(KeyEvent e) {}

		@Override
		public void keyReleased(KeyEvent e) {}

		@Override
		public void keyTyped(KeyEvent e) {
			Character key = e.getKeyChar();
			charToButtonMapping.get(key).doClick(KEEP_BUTTON_PRESSED_TIME);
		}
	}

	/**
	 * Sends events to be processed by the controller
	 */
	private class ActionListener_Impl implements ActionListener {
		private final JFrame frame;
		public ActionListener_Impl(JFrame frame) {
			this.frame = frame;
		}
		public void actionPerformed(ActionEvent e) {
			//System.out.println(e.getActionCommand());
			String action = e.getActionCommand();
			if (action.equals(EXIT_PROGRAM)) {
				System.exit(0);
			} else if (action.startsWith("skin_")) {
				setSkin(action);
			} else {
				controller.process(e);
			}
			frame.requestFocus();
		}
	}

	private void setSkin(String skin) {
		String lookAndFeelClass = UIManager.getSystemLookAndFeelClassName();
		if (skin.equals(SKIN_PLASTIC)) lookAndFeelClass = "com.jgoodies.looks.plastic.PlasticLookAndFeel"; 
		if (skin.equals(SKIN_PLASTIC3D)) lookAndFeelClass = "com.jgoodies.looks.plastic.Plastic3DLookAndFeel";
		try {
			UIManager.setLookAndFeel(lookAndFeelClass);
			SwingUtilities.updateComponentTreeUI(this);
			this.pack();
			textArea_output.setFont(new Font("Monospaced", Font.PLAIN, getFont().getSize()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Controller controller;
	private JButton button_0;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_add;
	private JButton button_backspace;
	private JButton button_clear;
	private JButton button_decimalPoint;
	private JButton button_divide;
	private JButton button_equals;
	private JButton button_multiply;
	private JButton button_power;
	private JButton button_signChange;
	private JButton button_squareRoot;
	private JButton button_substraction;
	private JButton button_undo;
	private javax.swing.JScrollPane jScrollPane_output;
	private javax.swing.JTextArea textArea_output;
	private JButton button_ans;
	private JMenuBar menubar;
	private JMenu fileMenu;
	private JMenuItem exportToFile;
	private JMenuItem exit;
	private JMenu optionsMenu;
	private JMenu audioMenu;
	private JMenu skinMenu;
	private JRadioButtonMenuItem audio_1;
	private JRadioButtonMenuItem audio_2;
	private JRadioButtonMenuItem audio_3;
	private JRadioButtonMenuItem skin_1;
	private JRadioButtonMenuItem skin_2;
	private JRadioButtonMenuItem skin_3;
	private final ActionListener actionListener;
	private Dialog fileDialog;

	public View_Implementation() {
		super("Calculator");
		initComponents();
		this.addKeyListener(new KeyListener_Impl());
		actionListener = new ActionListener_Impl(this);
		addActionListenerToAllButtonsAndMenus();
		this.setFocusable(true);
		this.requestFocus();
	}

	private void addActionListenerToAllButtonsAndMenus() {
		button_7.addActionListener(actionListener);
		button_8.addActionListener(actionListener);
		button_9.addActionListener(actionListener);
		button_4.addActionListener(actionListener);
		button_5.addActionListener(actionListener);
		button_6.addActionListener(actionListener);
		button_1.addActionListener(actionListener);
		button_2.addActionListener(actionListener);
		button_3.addActionListener(actionListener);
		button_0.addActionListener(actionListener);
		button_decimalPoint.addActionListener(actionListener);
		button_equals.addActionListener(actionListener);
		button_multiply.addActionListener(actionListener);
		button_clear.addActionListener(actionListener);
		button_squareRoot.addActionListener(actionListener);
		button_power.addActionListener(actionListener);
		button_divide.addActionListener(actionListener);
		button_add.addActionListener(actionListener);
		button_undo.addActionListener(actionListener);
		button_signChange.addActionListener(actionListener);
		button_substraction.addActionListener(actionListener);
		button_backspace.addActionListener(actionListener);
		button_ans.addActionListener(actionListener);
		//fileMenu.addActionListener(actionListener);
		exportToFile.addActionListener(actionListener);
		exit.addActionListener(actionListener);
		audio_1.addActionListener(actionListener);
		audio_2.addActionListener(actionListener);
		audio_3.addActionListener(actionListener);
		skin_1.addActionListener(actionListener);
		skin_2.addActionListener(actionListener);
		skin_3.addActionListener(actionListener);
	}

	@Override
	public void assignController(Controller controller) {
		this.controller = controller;				
	}

	@Override
	public void setVisible() {
		this.setVisible(true);
	}

	@Override
	public void setOutput(String output) {
		textArea_output.setText(output);
	}

	@Override
	public void fileCreated(String filename) {
		fileDialog = new Dialog(this, "File created", true);
		fileDialog.addWindowListener(new WindowListener() {
			public void windowClosing(WindowEvent e) {
				fileDialog.dispose();
			}
			public void windowOpened(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) { }
			public void windowClosed(WindowEvent e) {}
			public void windowActivated(WindowEvent e) {}
		});
		JButton fileDialogCloseButton = new JButton("File " +filename+ " has been created to output folder");
		fileDialogCloseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileDialog.dispose();
			}
		});
		fileDialog.add(fileDialogCloseButton);
		fileDialog.pack();
		fileDialog.setResizable(false);
		fileDialog.setVisible(true);
		fileDialog.validate();
	}

	/**
	 * Swing components and layout generated with NetBeans IDE 5.5.
	 */
	private void initComponents() {
		initButtons(); 
		initMenubar();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jScrollPane_output = new JScrollPane();
		textArea_output = new JTextArea();
		textArea_output.setEditable(false);
		jScrollPane_output.setViewportView(textArea_output);

		setResizable(false);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addComponent(jScrollPane_output, GroupLayout.PREFERRED_SIZE, OUTPUT_AREA_HEIGHT, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(button_undo, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_backspace, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_7, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_8, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_9, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup()
								.addGroup(layout.createSequentialGroup()
										.addGap(0, 0, Short.MAX_VALUE)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(button_power, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(button_divide, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(button_multiply, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(button_4, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(button_5, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(button_6, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, GroupLayout.PREFERRED_SIZE)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(button_squareRoot, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(button_substraction, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(button_add, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(button_1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(button_2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(button_3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
														.addComponent(button_clear, GroupLayout.Alignment.LEADING, 0, 47, Short.MAX_VALUE))
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
																.addComponent(button_equals, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(button_0, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(button_decimalPoint, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(button_signChange, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(button_ans, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
																.addContainerGap());
		layout.setHorizontalGroup(layout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
						.addComponent(jScrollPane_output, 0, OUTPUT_AREA_WIDTH, Short.MAX_VALUE)
						.addContainerGap())
						.addGroup(layout.createSequentialGroup()
								.addPreferredGap(jScrollPane_output, button_0, LayoutStyle.ComponentPlacement.INDENT)
								.addGroup(layout.createParallelGroup()
										.addComponent(button_0, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
										.addComponent(button_1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
										.addComponent(button_4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
										.addComponent(button_7, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup()
												.addComponent(button_decimalPoint, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
												.addComponent(button_2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
												.addComponent(button_5, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
												.addComponent(button_8, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(layout.createParallelGroup()
														.addComponent(button_signChange, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
														.addComponent(button_3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
														.addComponent(button_6, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
														.addComponent(button_9, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
														.addGap(25)
														.addGroup(layout.createParallelGroup()
																.addGroup(layout.createSequentialGroup()
																		.addGroup(layout.createParallelGroup()
																				.addComponent(button_equals, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
																				.addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
																						.addComponent(button_backspace, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
																						.addGroup(layout.createParallelGroup()
																								.addGroup(layout.createSequentialGroup()
																										.addComponent(button_undo, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
																										.addGap(0, 0, Short.MAX_VALUE))
																										.addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
																												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																												.addComponent(button_ans, 0, 102, Short.MAX_VALUE))))
																												.addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
																														.addGroup(layout.createParallelGroup()
																																.addComponent(button_add, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
																																.addComponent(button_multiply, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
																																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																																.addGroup(layout.createParallelGroup()
																																		.addComponent(button_substraction, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
																																		.addComponent(button_divide, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
																																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																																		.addGroup(layout.createParallelGroup()
																																				.addComponent(button_squareRoot, GroupLayout.Alignment.LEADING, 0, 66, Short.MAX_VALUE)
																																				.addGroup(layout.createSequentialGroup()
																																						.addComponent(button_power, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
																																						.addGap(0, 0, Short.MAX_VALUE)))
																																						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																																						.addComponent(button_clear, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)))
																																						.addContainerGap(2, 2)));
		pack();
		setSkin(SKIN_SYSTEM);
	}

	private void initButtons() {
		button_0 = new JButton();
		button_7 = new JButton();
		button_8 = new JButton();
		button_9 = new JButton();
		button_4 = new JButton();
		button_5 = new JButton();
		button_6 = new JButton();
		button_1 = new JButton();
		button_2 = new JButton();
		button_3 = new JButton();
		button_decimalPoint = new JButton();
		button_equals = new JButton();
		button_multiply = new JButton();
		button_clear = new JButton();
		button_squareRoot = new JButton();
		button_power = new JButton();
		button_divide = new JButton();
		button_add = new JButton();
		button_undo = new JButton();
		button_signChange = new JButton();
		button_substraction = new JButton();
		button_backspace = new JButton();
		button_ans = new JButton();

		button_0.setText(Const.ZERO);
		button_1.setText(Const.ONE);
		button_2.setText(Const.TWO);
		button_3.setText(Const.THREE);
		button_4.setText(Const.FOUR);
		button_5.setText(Const.FIVE);
		button_6.setText(Const.SIX);
		button_7.setText(Const.SEVEN);
		button_8.setText(Const.EIGHT);
		button_9.setText(Const.NINE);
		button_decimalPoint.setText(Const.DECIMAL_SEPARATOR);
		button_equals.setText(Const.EQUALS);
		button_multiply.setText(Const.MULTIPLY);
		button_clear.setText(Const.CLEAR);
		button_squareRoot.setText(Const.SQRT);
		button_power.setText(Const.RAISE_TO_POWER);
		button_divide.setText(Const.DIVIDE);
		button_add.setText(Const.ADD);
		button_undo.setText(Const.UNDO);
		button_signChange.setText(Const.CHANGE_SIGN);
		button_substraction.setText(Const.SUBSTRACT);
		button_backspace.setText(Const.BACKSPACE);
		button_ans.setText(Const.ANS);
	}

	private void initMenubar() {

		menubar = new JMenuBar();

		fileMenu = new JMenu("File");
		exportToFile = new JMenuItem(Const.EXPORT_TO_TEXTFILE);
		exit = new JMenuItem(EXIT_PROGRAM);
		fileMenu.add(exportToFile);
		fileMenu.addSeparator();
		fileMenu.add(exit);


		optionsMenu = new JMenu("Options");
		audioMenu = new JMenu("Sounds");
		skinMenu = new JMenu("Appearance");
		optionsMenu.add(audioMenu);
		optionsMenu.add(skinMenu);

		ButtonGroup audios = new ButtonGroup();
		audio_1 = new JRadioButtonMenuItem("No sounds");
		audio_2 = new JRadioButtonMenuItem("Clicks");
		audio_3 = new JRadioButtonMenuItem("Beeps");
		audio_1.setActionCommand("audio_1");
		audio_2.setActionCommand("audio_2");
		audio_3.setActionCommand("audio_3");
		audio_1.setSelected(true);
		audios.add(audio_1);
		audios.add(audio_2);
		audios.add(audio_3);
		audioMenu.add(audio_1);
		audioMenu.add(audio_2);
		audioMenu.add(audio_3);
		
		ButtonGroup skins = new ButtonGroup();
		skin_1 = new JRadioButtonMenuItem("Plastic");
		skin_2 = new JRadioButtonMenuItem("System");
		skin_3 = new JRadioButtonMenuItem("Plastic 3D");
		skin_1.setActionCommand(SKIN_PLASTIC);
		skin_2.setActionCommand(SKIN_SYSTEM);
		skin_3.setActionCommand(SKIN_PLASTIC3D);
		skin_2.setSelected(true);
		skins.add(skin_1);
		skins.add(skin_2);
		skins.add(skin_3);
		skinMenu.add(skin_2);
		skinMenu.add(skin_1);
		skinMenu.add(skin_3);

		menubar.add(fileMenu);
		menubar.add(optionsMenu);
		this.setJMenuBar(menubar);
	}


}
