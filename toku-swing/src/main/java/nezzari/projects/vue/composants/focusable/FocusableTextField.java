package nezzari.projects.vue.composants.focusable;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.text.Document;

public class FocusableTextField extends JTextField implements FocusListener {
	/**
	 * 
	 */
	public FocusableTextField() {
		super();
		init();
	}

	/**
	 * @param doc
	 * @param text
	 * @param columns
	 */
	public FocusableTextField(Document doc, String text, int columns) {
		super(doc, text, columns);
		init();
	}

	/**
	 * @param columns
	 */
	public FocusableTextField(int columns) {
		super(columns);
		init();
	}

	/**
	 * @param text
	 * @param columns
	 */
	public FocusableTextField(String text, int columns) {
		super(text, columns);
		init();
	}

	/**
	 * @param text
	 */
	public FocusableTextField(String text) {
		super(text);
		init();
	}
	
	public void init() {
		this.addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent e) {
		this.select(0, getText().length());
	}

	@Override
	public void focusLost(FocusEvent e) {
		this.select(0, 0);
	}
}
