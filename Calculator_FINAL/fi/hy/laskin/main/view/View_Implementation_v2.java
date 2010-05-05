package fi.hy.laskin.main.view;

import fi.hy.laskin.main.Const;
import fi.hy.laskin.main.Controller;
import fi.hy.laskin.main.View;

import info.clearthought.layout.TableLayout;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class View_Implementation_v2 extends JFrame implements View {

	private static final int			MEMORY_SLOT_MAX_ROWS		= 5;
	private static final int			MEMORY_SLOT_MAX_CHAR_COUNT	= 12;
	private static final String			SKIN_PLASTIC3D				= "skin_3d";
	private static final String			SKIN_SYSTEM					= "skin_system";
	private static final String			SKIN_PLASTIC				= "skin_plastic";
	private static final String			EXIT_PROGRAM				= "Exit";
	private static final long			serialVersionUID			= -2212730761656490235L;

	private Controller					controller;
	private final ActionListener		actionListener;
	private final MemoryTextGenerator	memoryTextGenerator;

	/**
	 * Constructor
	 */
	public View_Implementation_v2() {
		super("Calculator");
		actionListener = new ActionListener_Impl(this);
		memoryTextGenerator = new MemoryTextGenerator(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, MEMORY_SLOT_MAX_CHAR_COUNT, MEMORY_SLOT_MAX_ROWS);
		initComponents();
		addActionListenerToAllButtonsAndMenus();
		this.addKeyListener(new KeyListener_Impl());
		this.setFocusable(true);
		this.requestFocus();
		this.setMemory(null);
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
	public void setMemory(Map<Integer, Double> memory) {
		this.memoryPanel.setText(memoryTextGenerator.generateText(memory));
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

			public void windowDeactivated(WindowEvent e) {}

			public void windowClosed(WindowEvent e) {}

			public void windowActivated(WindowEvent e) {}
		});
		JButton fileDialogCloseButton = new JButton("File " + filename + " has been created to output folder");
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
	 * Causes a button on the UI to be pressed if a key that matches that button
	 * is typed
	 */
	private class KeyListener_Impl implements KeyListener {
		private final static int				KEEP_BUTTON_PRESSED_TIME	= 50;	// ms
		private final Map<Character, JButton>	charToButtonMapping;

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
			JButton button = charToButtonMapping.get(key);
			if (button != null)
				button.doClick(KEEP_BUTTON_PRESSED_TIME);
		}
	}

	/**
	 * Sends events to be processed by the controller
	 */
	private class ActionListener_Impl implements ActionListener {
		private final JFrame	frame;

		public ActionListener_Impl(JFrame frame) {
			this.frame = frame;
		}

		public void actionPerformed(ActionEvent e) {
			// System.out.println(e.getActionCommand());
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
			memoryPanel.setFont(new Font("Monospaced", Font.PLAIN, getFont().getSize()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Swing components and layout generated with NetBeans IDE 5.5.
	 */
	private void initComponents() {
		initButtons();
		initMenubar();
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jScrollPane_output = new JScrollPane();
		{
			jPanel1 = new JPanel();
			TableLayout jPanel1Layout = new TableLayout(new double[][] { { TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL }, { TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL } });
			jPanel1Layout.setHGap(5);
			jPanel1Layout.setVGap(5);
			jPanel1.setLayout(jPanel1Layout);
			{
				button_store = new JButton(Const.STORE);
				jPanel1.add(button_store, "0, 1");
			}
			{
				button_load = new JButton(Const.LOAD);
				jPanel1.add(button_load, "0, 2");
			}
			{
				memoryLabel = new JLabel();
				jPanel1.add(memoryLabel, "1, 0, 3, 0");
				memoryLabel.setText("Memory slot contents:");
			}
			{
				memoryPanel = new JTextPane();
				jPanel1.add(memoryPanel, "1, 1, 3, 3");
				memoryPanel.setEditable(false);
			}
		}
		{
			operandsPanel = new JPanel();
			TableLayout operandsPanelLayout = new TableLayout(new double[][] { { TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL }, { TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL } });
			operandsPanelLayout.setHGap(5);
			operandsPanelLayout.setVGap(5);
			operandsPanel.setLayout(operandsPanelLayout);
			{
				button_backspace = new JButton(Const.BACKSPACE);
				operandsPanel.add(button_backspace, "0, 0, 1, 0");
			}
			{
				button_undo = new JButton(Const.UNDO);
				operandsPanel.add(button_undo, "2, 0");
			}
			{
				button_multiply = new JButton(Const.MULTIPLY);
				operandsPanel.add(button_multiply, "0, 1");
			}
			{
				button_divide = new JButton(Const.DIVIDE);
				operandsPanel.add(button_divide, "1, 1");
			}
			{
				button_power = new JButton(Const.RAISE_TO_POWER);
				operandsPanel.add(button_power, "2, 1");
			}
			{
				button_add = new JButton(Const.ADD);
				operandsPanel.add(button_add, "0, 2");
			}
			{
				button_substraction = new JButton(Const.SUBSTRACT);
				operandsPanel.add(button_substraction, "1, 2");
			}
			{
				button_squareRoot = new JButton(Const.SQRT);
				operandsPanel.add(button_squareRoot, "2, 2");
			}
			{
				button_equals = new JButton(Const.EQUALS);
				operandsPanel.add(button_equals, "0, 3, 1, 3");
			}
			{
				button_ans = new JButton(Const.ANS);
				operandsPanel.add(button_ans, "2, 3, 3, 3");
			}
			{
				button_clear = new JButton(Const.CLEAR);
				operandsPanel.add(button_clear, "3, 0, 3, 1");
			}
			{
				button_pi = new JButton(Const.PI);
				operandsPanel.add(button_pi, "3, 2");
			}
		}
		{
			numbersPanel = new JPanel();
			GridLayout numbersPanelLayout = new GridLayout(4, 3);
			numbersPanelLayout.setColumns(1);
			numbersPanelLayout.setHgap(5);
			numbersPanelLayout.setVgap(5);
			numbersPanel.setLayout(numbersPanelLayout);
			{
				button_7 = new JButton(Const.SEVEN);
				numbersPanel.add(button_7);
			}
			{
				button_8 = new JButton(Const.EIGHT);
				numbersPanel.add(button_8);
			}
			{
				button_9 = new JButton(Const.NINE);
				numbersPanel.add(button_9);
			}
			{
				button_4 = new JButton(Const.FOUR);
				numbersPanel.add(button_4);
			}
			{
				button_5 = new JButton(Const.FIVE);
				numbersPanel.add(button_5);
			}
			{
				button_6 = new JButton(Const.SIX);
				numbersPanel.add(button_6);
			}
			{
				button_1 = new JButton(Const.ONE);
				numbersPanel.add(button_1);
			}
			{
				button_2 = new JButton(Const.TWO);
				numbersPanel.add(button_2);
			}
			{
				button_3 = new JButton(Const.THREE);
				numbersPanel.add(button_3);
			}
			{
				button_0 = new JButton(Const.ZERO);
				numbersPanel.add(button_0);
			}
			{
				button_decimalPoint = new JButton(Const.DECIMAL_SEPARATOR);
				numbersPanel.add(button_decimalPoint);
			}
			{
				button_signChange = new JButton(Const.CHANGE_SIGN);
				numbersPanel.add(button_signChange);
			}
		}
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addComponent(jScrollPane_output, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup()
						.addGroup(layout.createSequentialGroup()
								.addComponent(operandsPanel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
								.addComponent(numbersPanel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
								.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(95, Short.MAX_VALUE));
		layout.setHorizontalGroup(layout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
						.addComponent(jScrollPane_output, 0, 993, Short.MAX_VALUE)
						.addContainerGap())
				.addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
						.addPreferredGap(jScrollPane_output, numbersPanel, LayoutStyle.ComponentPlacement.INDENT)
						.addComponent(numbersPanel, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
						.addGap(20)
						.addComponent(operandsPanel, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
						.addGap(63)
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(94, Short.MAX_VALUE)));

		textArea_output = new JTextArea();
		textArea_output.setEditable(false);
		jScrollPane_output.setViewportView(textArea_output);

		setResizable(false);

		pack();
		setSkin(SKIN_SYSTEM);
	}

	private JButton					button_0;
	private JButton					button_1;
	private JButton					button_2;
	private JButton					button_3;
	private JButton					button_4;
	private JButton					button_5;
	private JButton					button_6;
	private JButton					button_7;
	private JButton					button_8;
	private JButton					button_9;
	private JButton					button_add;
	private JButton					button_backspace;
	private JButton					button_clear;
	private JButton					button_decimalPoint;
	private JButton					button_divide;
	private JButton					button_equals;
	private JButton					button_multiply;
	private JButton					button_power;
	private JButton					button_signChange;
	private JButton					button_squareRoot;
	private JButton					button_substraction;
	private JButton					button_undo;
	private JButton					button_store;
	private JButton					button_load;
	private JButton					button_pi;
	private JScrollPane				jScrollPane_output;
	private JTextArea				textArea_output;
	private JButton					button_ans;
	private JMenuBar				menubar;
	private JMenu					fileMenu;
	private JMenuItem				exportToFile;
	private JMenuItem				exit;
	private JMenu					optionsMenu;
	private JMenu					audioMenu;
	private JMenu					skinMenu;
	private JTextPane				memoryPanel;
	private JPanel					jPanel1;
	private JPanel					operandsPanel;
	private JPanel					numbersPanel;
	private JLabel					memoryLabel;
	private JRadioButtonMenuItem	audio_1;
	private JRadioButtonMenuItem	audio_2;
	private JRadioButtonMenuItem	audio_3;
	private JRadioButtonMenuItem	skin_1;
	private JRadioButtonMenuItem	skin_2;
	private JRadioButtonMenuItem	skin_3;
	private Dialog					fileDialog;

	private void initButtons() {}

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
		audio_1.setActionCommand(Const.SOUND_EFFECT_THEME__NO_SOUNDS);
		audio_2.setActionCommand(Const.SOUND_EFFECT_THEME__CLICKS);
		audio_3.setActionCommand(Const.SOUND_EFFECT_THEME__BEEPS);
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
		button_store.addActionListener(actionListener);
		button_load.addActionListener(actionListener);
		button_signChange.addActionListener(actionListener);
		button_substraction.addActionListener(actionListener);
		button_backspace.addActionListener(actionListener);
		button_ans.addActionListener(actionListener);
		exportToFile.addActionListener(actionListener);
		exit.addActionListener(actionListener);
		audio_1.addActionListener(actionListener);
		audio_2.addActionListener(actionListener);
		audio_3.addActionListener(actionListener);
		skin_1.addActionListener(actionListener);
		skin_2.addActionListener(actionListener);
		skin_3.addActionListener(actionListener);
	}

}
