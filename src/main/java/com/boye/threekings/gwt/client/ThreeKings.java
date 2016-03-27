package com.boye.threekings.gwt.client;

import static com.boye.threekings.gwt.client.Consts.BOARD_SIDE;
import static com.boye.threekings.gwt.client.Consts.PIECE_DIAMETER;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ThreeKings implements EntryPoint {
	private Context2d context;

	private void initBoard() {
		// line 1
		context.beginPath();
		context.moveTo(PIECE_DIAMETER / 2, PIECE_DIAMETER / 2);
		context.lineTo(BOARD_SIDE - PIECE_DIAMETER / 2, PIECE_DIAMETER / 2);
		// line 2
		context.moveTo(PIECE_DIAMETER / 2, BOARD_SIDE - PIECE_DIAMETER / 2);
		context.lineTo(BOARD_SIDE - PIECE_DIAMETER / 2, BOARD_SIDE - PIECE_DIAMETER / 2);
		// line 3
		context.moveTo(PIECE_DIAMETER / 2, PIECE_DIAMETER / 2);
		context.lineTo(PIECE_DIAMETER / 2, BOARD_SIDE - PIECE_DIAMETER / 2);
		// line 4
		context.moveTo(BOARD_SIDE - PIECE_DIAMETER / 2, PIECE_DIAMETER / 2);
		context.lineTo(BOARD_SIDE - PIECE_DIAMETER / 2, BOARD_SIDE - PIECE_DIAMETER / 2);
		// line 5
		context.moveTo(PIECE_DIAMETER / 2, BOARD_SIDE / 2);
		context.lineTo(BOARD_SIDE - PIECE_DIAMETER / 2, BOARD_SIDE / 2);
		// line 6
		context.moveTo(BOARD_SIDE / 2, PIECE_DIAMETER / 2);
		context.lineTo(BOARD_SIDE / 2, BOARD_SIDE - PIECE_DIAMETER / 2);
		// line 7
		context.moveTo(PIECE_DIAMETER / 2, PIECE_DIAMETER / 2);
		context.lineTo(BOARD_SIDE - PIECE_DIAMETER / 2, BOARD_SIDE - PIECE_DIAMETER / 2);
		// line 8
		context.moveTo(BOARD_SIDE - PIECE_DIAMETER / 2, PIECE_DIAMETER / 2);
		context.lineTo(PIECE_DIAMETER / 2, BOARD_SIDE - PIECE_DIAMETER / 2);
		context.stroke();
		// //
		// context.beginPath();
		// context.setFillStyle(CssColor.make(255, 0, 0));
		// // red piece 1
		// context.arc(PIECE_DIAMETER / 2, PIECE_DIAMETER / 2, PIECE_DIAMETER / 2, 0, Math.PI * 2.0, true);
		// // red piece 2
		// context.arc(BOARD_SIDE / 2, PIECE_DIAMETER / 2, PIECE_DIAMETER / 2, 0, Math.PI * 2.0, true);
		// // red piece 3
		// context.arc(BOARD_SIDE - PIECE_DIAMETER / 2, PIECE_DIAMETER / 2, PIECE_DIAMETER / 2, 0, Math.PI * 2.0, true);
		// context.closePath();
		// context.fill();
		// context.beginPath();
		// context.setFillStyle(CssColor.make(0, 255, 0));
		// // green piece 1
		// context.arc(PIECE_DIAMETER / 2, BOARD_SIDE - PIECE_DIAMETER / 2, PIECE_DIAMETER / 2, 0, Math.PI * 2.0, true);
		// // green piece 2
		// context.arc(BOARD_SIDE / 2, BOARD_SIDE - PIECE_DIAMETER / 2, PIECE_DIAMETER / 2, 0, Math.PI * 2.0, true);
		// // green piece 3
		// context.arc(BOARD_SIDE - PIECE_DIAMETER / 2, BOARD_SIDE - PIECE_DIAMETER / 2, PIECE_DIAMETER / 2, 0, Math.PI * 2.0, true);
		// context.closePath();
		// context.fill();
	}

	private void initPieces() {
		// piece red player
		PieceComponent pieceRedOne = new PieceComponent(context, PIECE_DIAMETER, Consts.RED, PiecePosition.A1);
		PieceComponent pieceRedTwo = new PieceComponent(context, PIECE_DIAMETER, Consts.RED, PiecePosition.A2);
		PieceComponent pieceRedThree = new PieceComponent(context, PIECE_DIAMETER, Consts.RED, PiecePosition.A3);
		// piece green player
		PieceComponent pieceGreenOne = new PieceComponent(context, PIECE_DIAMETER, Consts.GREEN, PiecePosition.C1);
		PieceComponent pieceGreenTwo = new PieceComponent(context, PIECE_DIAMETER, Consts.GREEN, PiecePosition.C2);
		PieceComponent pieceGreenThree = new PieceComponent(context, PIECE_DIAMETER, Consts.GREEN, PiecePosition.C3);
		Controller.getInstance().manage(pieceRedOne);
		Controller.getInstance().manage(pieceRedTwo);
		Controller.getInstance().manage(pieceRedThree);
		Controller.getInstance().manage(pieceGreenOne);
		Controller.getInstance().manage(pieceGreenTwo);
		Controller.getInstance().manage(pieceGreenThree);
	}

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		Controller.getInstance().initialize();
		Canvas canvas = Canvas.createIfSupported();
		canvas.setWidth(BOARD_SIDE + "px");
		canvas.setCoordinateSpaceWidth(BOARD_SIDE);
		canvas.setHeight(BOARD_SIDE + "px");
		canvas.setCoordinateSpaceHeight(BOARD_SIDE);
		RootPanel.get("ThreeKingsContainer").add(canvas);
		//
		context = canvas.getContext2d();
		initBoard();
		initPieces();
		canvas.addMouseDownHandler(new BoardListener());
	}
}
