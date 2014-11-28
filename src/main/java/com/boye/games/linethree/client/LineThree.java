package com.boye.games.linethree.client;

import static com.boye.games.linethree.client.Consts.BOARD_SIDE;
import static com.boye.games.linethree.client.Consts.PIECE_DIAMETER;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class LineThree implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		Canvas canvas = Canvas.createIfSupported();
		canvas.setWidth(BOARD_SIDE + "px");
		canvas.setCoordinateSpaceWidth(BOARD_SIDE);
		canvas.setHeight(BOARD_SIDE + "px");
		canvas.setCoordinateSpaceHeight(BOARD_SIDE);
		RootPanel.get("lineThreeContainer").add(canvas);
		//
		Context2d context = canvas.getContext2d();
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
		//
		context.beginPath();
		context.setFillStyle(CssColor.make(255, 0, 0));
		// red piece 1
		context.arc(PIECE_DIAMETER / 2, PIECE_DIAMETER / 2, PIECE_DIAMETER / 2, 0, Math.PI * 2.0, true);
		// red piece 2
		context.arc(BOARD_SIDE / 2, PIECE_DIAMETER / 2, PIECE_DIAMETER / 2, 0, Math.PI * 2.0, true);
		// red piece 3
		context.arc(BOARD_SIDE - PIECE_DIAMETER / 2, PIECE_DIAMETER / 2, PIECE_DIAMETER / 2, 0, Math.PI * 2.0, true);
		context.closePath();
		context.fill();
		context.beginPath();
		context.setFillStyle(CssColor.make(0, 255, 0));
		// green piece 1
		context.arc(PIECE_DIAMETER / 2, BOARD_SIDE - PIECE_DIAMETER / 2, PIECE_DIAMETER / 2, 0, Math.PI * 2.0, true);
		// green piece 2
		context.arc(BOARD_SIDE / 2, BOARD_SIDE - PIECE_DIAMETER / 2, PIECE_DIAMETER / 2, 0, Math.PI * 2.0, true);
		// green piece 3
		context.arc(BOARD_SIDE - PIECE_DIAMETER / 2, BOARD_SIDE - PIECE_DIAMETER / 2, PIECE_DIAMETER / 2, 0, Math.PI * 2.0, true);
		context.closePath();
		context.fill();
	}
}
