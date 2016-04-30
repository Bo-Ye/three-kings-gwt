package com.boye.threekings.gwt.client;

import static com.boye.threekings.gwt.client.Consts.BOARD_SIDE;
import static com.boye.threekings.gwt.client.Consts.PIECE_DIAMETER;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ThreeKings implements EntryPoint {
	private Canvas initBoard() {
		Canvas canvasBoard = Canvas.createIfSupported();
		canvasBoard.setWidth(BOARD_SIDE + "px");
		canvasBoard.setCoordinateSpaceWidth(BOARD_SIDE);
		canvasBoard.setHeight(BOARD_SIDE + "px");
		canvasBoard.setCoordinateSpaceHeight(BOARD_SIDE);
		canvasBoard.getElement().getStyle().setPosition(Position.ABSOLUTE);
		canvasBoard.getElement().getStyle().setLeft(0, Unit.PX);
		canvasBoard.getElement().getStyle().setTop(0, Unit.PX);
		canvasBoard.getElement().getStyle().setZIndex(0);
		Context2d context = canvasBoard.getContext2d();
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
		return canvasBoard;
	}

	private Canvas initPieces() {
		Canvas canvasPieces = Canvas.createIfSupported();
		canvasPieces.setWidth(BOARD_SIDE + "px");
		canvasPieces.setCoordinateSpaceWidth(BOARD_SIDE);
		canvasPieces.setHeight(BOARD_SIDE + "px");
		canvasPieces.setCoordinateSpaceHeight(BOARD_SIDE);
		canvasPieces.getElement().getStyle().setPosition(Style.Position.ABSOLUTE);
		canvasPieces.getElement().getStyle().setLeft(0, Unit.PX);
		canvasPieces.getElement().getStyle().setTop(0, Unit.PX);
		canvasPieces.getElement().getStyle().setZIndex(1);
		Context2d context = canvasPieces.getContext2d();
		// piece red player
		PieceComponent pieceRedOne = new PieceComponent(context, PIECE_DIAMETER, Consts.RED, PiecePosition.A1);
		PieceComponent pieceRedTwo = new PieceComponent(context, PIECE_DIAMETER, Consts.RED, PiecePosition.A2);
		PieceComponent pieceRedThree = new PieceComponent(context, PIECE_DIAMETER, Consts.RED, PiecePosition.A3);
		// piece green player
		PieceComponent pieceGreenOne = new PieceComponent(context, PIECE_DIAMETER, Consts.GREEN, PiecePosition.C1);
		PieceComponent pieceGreenTwo = new PieceComponent(context, PIECE_DIAMETER, Consts.GREEN, PiecePosition.C2);
		PieceComponent pieceGreenThree = new PieceComponent(context, PIECE_DIAMETER, Consts.GREEN, PiecePosition.C3);
		Controller.getInstance().initialize();
		Controller.getInstance().manage(pieceRedOne);
		Controller.getInstance().manage(pieceRedTwo);
		Controller.getInstance().manage(pieceRedThree);
		Controller.getInstance().manage(pieceGreenOne);
		Controller.getInstance().manage(pieceGreenTwo);
		Controller.getInstance().manage(pieceGreenThree);
		canvasPieces.addMouseDownHandler(new BoardListener());
		return canvasPieces;
	}

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		RootPanel.get("ThreeKingsContainer").add(initBoard());
		RootPanel.get("ThreeKingsContainer").add(initPieces());
	}
}
