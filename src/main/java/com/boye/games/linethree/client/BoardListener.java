package com.boye.games.linethree.client;

import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;

public class BoardListener implements MouseDownHandler {

	private double distance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

	private PiecePosition determinePosition(int x, int y) {
		// A1
		double distanceToA1 = distance(x, y, PiecePosition.A1.getX(), PiecePosition.A1.getY());
		if (distanceToA1 <= Consts.PIECE_DIAMETER / 2) {
			return PiecePosition.A1;
		}
		// A2
		double distanceToA2 = distance(x, y, PiecePosition.A2.getX(), PiecePosition.A2.getY());
		if (distanceToA2 <= Consts.PIECE_DIAMETER / 2) {
			return PiecePosition.A2;
		}
		// A3
		double distanceToA3 = distance(x, y, PiecePosition.A3.getX(), PiecePosition.A3.getY());
		if (distanceToA3 <= Consts.PIECE_DIAMETER / 2) {
			return PiecePosition.A3;
		}
		// B1
		double distanceToB1 = distance(x, y, PiecePosition.B1.getX(), PiecePosition.B1.getY());
		if (distanceToB1 <= Consts.PIECE_DIAMETER / 2) {
			return PiecePosition.B1;
		}
		// B2
		double distanceToB2 = distance(x, y, PiecePosition.B2.getX(), PiecePosition.B2.getY());
		if (distanceToB2 <= Consts.PIECE_DIAMETER / 2) {
			return PiecePosition.B2;
		}
		// B3
		double distanceToB3 = distance(x, y, PiecePosition.B3.getX(), PiecePosition.B3.getY());
		if (distanceToB3 <= Consts.PIECE_DIAMETER / 2) {
			return PiecePosition.B3;
		}
		// C1
		double distanceToC1 = distance(x, y, PiecePosition.C1.getX(), PiecePosition.C1.getY());
		if (distanceToC1 <= Consts.PIECE_DIAMETER / 2) {
			return PiecePosition.C1;
		}
		// C2
		double distanceToC2 = distance(x, y, PiecePosition.C2.getX(), PiecePosition.C2.getY());
		if (distanceToC2 <= Consts.PIECE_DIAMETER / 2) {
			return PiecePosition.C2;
		}
		// C3
		double distanceToC3 = distance(x, y, PiecePosition.C3.getX(), PiecePosition.C3.getY());
		if (distanceToC3 <= Consts.PIECE_DIAMETER / 2) {
			return PiecePosition.C3;
		}
		return null;
	}

	@Override
	public void onMouseDown(MouseDownEvent event) {
		int x = event.getX();
		int y = event.getY();
		PiecePosition clickedPosition = determinePosition(x, y);
		if (clickedPosition != null) {
			Controller.getInstance().positionClicked(clickedPosition);
		}
	}
}
