package com.boye.games.linethree.client;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.user.client.Timer;

public class PieceComponent {
	private Context2d context;
	private int diameter;
	private String strColor;
	private PiecePosition currentPosition;
	private boolean visible;
	private Timer flashTimer;

	public PieceComponent(Context2d context, int diameter, String strColor, PiecePosition piecePosition) {
		this.context = context;
		this.strColor = strColor;
		this.diameter = diameter;
		this.draw(piecePosition);
		this.visible = true;
		this.currentPosition = piecePosition;
	}

	private void draw(PiecePosition piecePosition) {
		context.setFillStyle(CssColor.make(strColor));
		context.beginPath();
		context.arc(piecePosition.getX(), piecePosition.getY(), diameter / 2, 0, 2 * Math.PI, true);
		context.fill();
	}

	private void clear(PiecePosition piecePosition) {
		context.beginPath();
		context.arc(piecePosition.getX(), piecePosition.getY(), diameter / 2, 0, 2 * Math.PI, true);
		//context.clip();
		context.clearRect(piecePosition.getX() - diameter / 2, piecePosition.getY() - diameter / 2, diameter, diameter);
	}

	public void moveTo(PiecePosition piecePosition) {
		this.clear(currentPosition);
		this.draw(piecePosition);
		this.currentPosition = piecePosition;
	}

	public String getColor() {
		return this.strColor;
	}

	public PiecePosition getPiecePosition() {
		return this.currentPosition;
	}

	public void select() {
		flashTimer = new Timer() {
			@Override
			public void run() {
				if (visible) {
					clear(currentPosition);
				} else {
					draw(currentPosition);
				}
				visible = !visible;
			}
		};
		flashTimer.scheduleRepeating(500);
	}

	public void deSelect() {
		flashTimer.cancel();
		if (!visible) {
			draw(currentPosition);
		}
	}
}
