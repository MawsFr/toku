package nezzari.projects.vue.composants;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.text.Document;

import nezzari.projects.vue.composants.focusable.FocusableTextField;

public class JTextFieldHint extends FocusableTextField {
	private static final long serialVersionUID = 1L;
	private String hint = "";

	public JTextFieldHint() {
		this.setMinimumSize(new Dimension(150, 20));
		this.setPreferredSize(new Dimension(150, 20));
	}

	public JTextFieldHint(final Document doc, final String text, final int columns) {
		super(doc, text, columns);
	}

	public JTextFieldHint(final int columns) {
		super(columns);
	}

	public JTextFieldHint(final String text) {
		super(text);
	}

	public JTextFieldHint(final String text, final int columns) {
		super(text, columns);
	}

	public String getHint() {
		return hint;
	}

	@Override
	protected void paintComponent(final Graphics pG) {
		super.paintComponent(pG);

		if (hint.length() == 0 || getText().length() > 0) {
			return;
		}

		final Graphics2D g = (Graphics2D) pG;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(getDisabledTextColor());
		g.drawString(hint, getInsets().left, pG.getFontMetrics().getMaxAscent() + getInsets().top);
	}

	public void setHint(final String hint) {
		this.hint = hint;
	}

}