package com.boye.games.linethree.client;

import static com.boye.games.linethree.client.Consts.BOARD_SIDE;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
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
		//context.beginPath();
		context.moveTo(0, 0);
		context.lineTo(BOARD_SIDE, 0);
		//context.stroke();
		// line 2
		//context.beginPath();
		context.moveTo(0, BOARD_SIDE);
		context.lineTo(BOARD_SIDE, BOARD_SIDE);
		//context.stroke();
		// line 3
		//context.beginPath();
		context.moveTo(0, 0);
		context.lineTo(0, BOARD_SIDE);
		//context.stroke();
		// line 4
		//context.beginPath();
		context.moveTo(BOARD_SIDE, 0);
		context.lineTo(BOARD_SIDE, BOARD_SIDE);
		//context.stroke();
		// line 5
		//context.beginPath();
		context.moveTo(0, BOARD_SIDE / 2);
		context.lineTo(BOARD_SIDE, BOARD_SIDE / 2);
		//context.stroke();
		// line 6
		//context.beginPath();
		context.moveTo(BOARD_SIDE / 2, 0);
		context.lineTo(BOARD_SIDE / 2, BOARD_SIDE);
		//context.stroke();
		// line 7
		//context.beginPath();
		context.moveTo(0, 0);
		context.lineTo(BOARD_SIDE, BOARD_SIDE);
		//context.stroke();
		// line 8
		//context.beginPath();
		context.moveTo(BOARD_SIDE, 0);
		context.lineTo(0, BOARD_SIDE);
		//context.stroke();
	}
}
