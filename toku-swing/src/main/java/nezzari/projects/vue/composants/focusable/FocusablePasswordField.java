package nezzari.projects.vue.composants.focusable;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;
import javax.swing.text.Document;

public class FocusablePasswordField extends JPasswordField implements FocusListener {
	/**
	 * 
	 */
	public FocusablePasswordField() {
		super();
		init();
	}

	/**
	 * @param doc
	 * @param txt
	 * @param columns
	 */
	public FocusablePasswordField(Document doc, String txt, int columns) {
		super(doc, txt, columns);
		init();
	}

	/**
	 * @param columns
	 */
	public FocusablePasswordField(int columns) {
		super(columns);
		init();
	}

	/**
	 * @param text
	 * @param columns
	 */
	public FocusablePasswordField(String text, int columns) {
		super(text, columns);
		init();
	}

	/**
	 * @param text
	 */
	public FocusablePasswordField(String text) {
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
