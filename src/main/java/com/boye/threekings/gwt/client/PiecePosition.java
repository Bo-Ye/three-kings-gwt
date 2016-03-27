package com.boye.threekings.gwt.client;

//@formatter:off
/**
 *   1 2 3
 * A * * *
 * B * * *
 * C * * *
 * 
 * two dimension coordinates
 * 
 * @author YE BO
 * 
 */
// @formatter:on
public enum PiecePosition {
	A1, A2, A3, B1, B2, B3, C1, C2, C3;
	public int getX() {
		String number = this.name().substring(1, 2);
		switch (Integer.valueOf(number).intValue()) {
		case 1:
			return Consts.PIECE_DIAMETER / 2;
		case 2:
			return Consts.BOARD_SIDE / 2;
		case 3:
			return Consts.BOARD_SIDE - Consts.PIECE_DIAMETER / 2;
		default:
			throw new RuntimeException("It's a typo bug!");
		}
	}

	public int getY() {
		String letter = this.name().substring(0, 1);
		switch (letter) {
		case "A":
			return Consts.PIECE_DIAMETER / 2;
		case "B":
			return Consts.BOARD_SIDE / 2;
		case "C":
			return Consts.BOARD_SIDE - Consts.PIECE_DIAMETER / 2;
		default:
			throw new RuntimeException("It's a typo bug!");
		}

	}
}
