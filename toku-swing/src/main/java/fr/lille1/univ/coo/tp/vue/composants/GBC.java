package fr.lille1.univ.coo.tp.vue.composants;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GBC extends GridBagConstraints {
	private static final long serialVersionUID = 1L;

	private Container c;

	public GBC(Container c) {
		this.c = c;
		this.insets = new Insets(0, 0, 0, 0);
	}

	public GBC ajouter(Component component) {
		this.c.add(component, this);
		return this;
	}

	public GBC setX(int x) {
		this.gridx = x;
		return this;
	}

	public GBC setY(int y) {
		this.gridy = y;
		return this;
	}

	public GBC setIpadX(int ipadx) {
		this.ipadx = ipadx;
		return this;
	}

	public GBC setIpadY(int ipady) {
		this.ipady = ipady;
		return this;
	}

	public GBC setWidth(int width) {
		this.gridwidth = width;
		return this;
	}

	public GBC setHeight(int height) {
		this.gridheight = height;
		return this;
	}

	public GBC setWeightX(double weightx) {
		this.weightx = weightx;
		return this;
	}

	public GBC setWeightY(double weighty) {
		this.weighty = weighty;
		return this;
	}

	public GBC setFill(int fill) {
		this.fill = fill;
		return this;
	}

	public GBC setAnchor(int anchor) {
		this.anchor = anchor;
		return this;
	}

	public GBC setInsets(int top, int left, int bottom, int right) {
		this.insets.top = top;
		this.insets.left = left;
		this.insets.bottom = bottom;
		this.insets.right = right;
		return this;
	}

	public GBC setTopInsets(int top) {
		this.insets.top = top;
		return this;
	}

	public GBC setLeftInsets(int left) {
		this.insets.left = left;
		return this;
	}

	public GBC setBottomInsets(int bottom) {
		this.insets.bottom = bottom;
		return this;
	}

	public GBC setRightInsets(int right) {
		this.insets.right = right;
		return this;
	}

	public GBC setContainer(Container c) {
		this.c = c;
		return this;
	}

	public GBC reset() {
		return setAnchor(CENTER).setFill(NONE).setSize(1, 1).setIpads(0, 0)
				.setInsets(0, 0, 0, 0).setWeights(0., 0.);
	}
	
	public GBC setWeights(double weightx, double weighty) {
		return setWeightX(weightx).setWeightY(weighty);
	}
	
	public GBC setPosition(int x, int y) {
		return setX(x).setY(y);
	}
	
	public GBC setIpads(int ipadx, int ipady) {
		return setIpadX(ipadx).setIpadY(ipady);
	}
	
	public GBC setSize(int width, int height) {
		return setWidth(width).setHeight(height);
	}
	
	public GBC reculer() {
		return setX(gridx == 0 ? 0 : gridx - 1);
	}
	
	public GBC avancer() {
		return setX(gridx + 1);
	}
	
	public GBC descendre() {
		return setY(gridy + 1);
	}
	
	public GBC monter() {
		return setY(gridy == 0 ? 0 : gridy - 1);
	}

}
