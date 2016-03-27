package com.boye.threekings.gwt.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Controller {
	private static Controller controller = null;
	// /for status
	private String currentPlayer = null;
	private PieceComponent currentSelected = null;
	private Map<PiecePosition, PieceComponent> layout = new HashMap<PiecePosition, PieceComponent>();
	// /for connectivity between positions
	private Map<PiecePosition, PiecePosition[]> positionMovables = new HashMap<PiecePosition, PiecePosition[]>();

	private List<PiecePosition[]> winPatterns = new ArrayList<PiecePosition[]>();

	private Controller() {
	}

	public static Controller getInstance() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}

	public void initialize() {
		this.currentPlayer = Consts.GREEN;
		this.currentSelected = null;
		layout.put(PiecePosition.A1, null);
		layout.put(PiecePosition.A2, null);
		layout.put(PiecePosition.A3, null);
		layout.put(PiecePosition.B1, null);
		layout.put(PiecePosition.B2, null);
		layout.put(PiecePosition.B3, null);
		layout.put(PiecePosition.C1, null);
		layout.put(PiecePosition.C2, null);
		layout.put(PiecePosition.C3, null);

		positionMovables.put(PiecePosition.A1, new PiecePosition[] { PiecePosition.A2, PiecePosition.B1, PiecePosition.B2 });
		positionMovables.put(PiecePosition.A2, new PiecePosition[] { PiecePosition.A1, PiecePosition.A3, PiecePosition.B2 });
		positionMovables.put(PiecePosition.A3, new PiecePosition[] { PiecePosition.A2, PiecePosition.B2, PiecePosition.B3 });
		positionMovables.put(PiecePosition.B1, new PiecePosition[] { PiecePosition.A1, PiecePosition.B2, PiecePosition.C1 });
		positionMovables.put(PiecePosition.B2, new PiecePosition[] { PiecePosition.A1, PiecePosition.A2, PiecePosition.A3, PiecePosition.B1, PiecePosition.B3, PiecePosition.C1,
				PiecePosition.C2, PiecePosition.C3 });
		positionMovables.put(PiecePosition.B3, new PiecePosition[] { PiecePosition.A3, PiecePosition.B2, PiecePosition.C3 });
		positionMovables.put(PiecePosition.C1, new PiecePosition[] { PiecePosition.B1, PiecePosition.B2, PiecePosition.C2 });
		positionMovables.put(PiecePosition.C2, new PiecePosition[] { PiecePosition.B2, PiecePosition.C1, PiecePosition.C3 });
		positionMovables.put(PiecePosition.C3, new PiecePosition[] { PiecePosition.B2, PiecePosition.B3, PiecePosition.C2 });

		winPatterns.add(new PiecePosition[] { PiecePosition.B1, PiecePosition.B2, PiecePosition.B3 });
		winPatterns.add(new PiecePosition[] { PiecePosition.A1, PiecePosition.B1, PiecePosition.C1 });
		winPatterns.add(new PiecePosition[] { PiecePosition.A2, PiecePosition.B2, PiecePosition.C2 });
		winPatterns.add(new PiecePosition[] { PiecePosition.A3, PiecePosition.B3, PiecePosition.C3 });
		winPatterns.add(new PiecePosition[] { PiecePosition.A1, PiecePosition.B2, PiecePosition.C3 });
		winPatterns.add(new PiecePosition[] { PiecePosition.A3, PiecePosition.B2, PiecePosition.C1 });
	}

	public void manage(PieceComponent pieceComponent) {
		layout.put(pieceComponent.getPiecePosition(), pieceComponent);
	}

	// /// process click events
	private boolean isMovable(PiecePosition from, PiecePosition to) {
		PiecePosition[] movables = positionMovables.get(from);
		return Arrays.binarySearch(movables, to) > -1;
	}

	private void changePlayer() {
		currentSelected.deSelect();
		currentSelected = null;
		if (currentPlayer.equals(Consts.GREEN)) {
			currentPlayer = Consts.RED;
		} else {
			currentPlayer = Consts.GREEN;
		}
	}

	public void positionClicked(PiecePosition clickedPosition) {
		if (layout.get(clickedPosition) != null) {
			PieceComponent clickedPiece = layout.get(clickedPosition);
			pieceClicked(clickedPiece);
		} else {
			destinationClicked(clickedPosition);
		}
	}

	private void pieceClicked(PieceComponent clickedPiece) {
		String selectedColor = clickedPiece.getColor();
		if (selectedColor.equals(currentPlayer)) {
			if (currentSelected != null) {
				currentSelected.deSelect();
			}
			clickedPiece.select();
			currentSelected = clickedPiece;
		}
	}

	private void destinationClicked(PiecePosition clickedPosition) {
		if (currentSelected != null) {
			PiecePosition from = currentSelected.getPiecePosition();
			PiecePosition to = clickedPosition;
			if (isMovable(from, to)) {
				currentSelected.moveTo(clickedPosition);
				layout.put(from, null);
				layout.put(to, currentSelected);
				if (this.isThreeLined()) {
					alert("Message", "Congratulation! " + this.currentPlayer + " player WON!");
				}
				changePlayer();
			}
		}
	}

	/**
	 * Tell if one player win.
	 */
	private boolean isThreeLined() {
		List<PiecePosition> positions = new ArrayList<PiecePosition>();
		for (Map.Entry<PiecePosition, PieceComponent> entry : layout.entrySet()) {
			if (entry.getValue() != null) {
				PieceComponent pieceComponent = entry.getValue();
				if (pieceComponent.getColor().equals(this.currentPlayer)) {
					positions.add(entry.getKey());
				}
			}
		}
		// check win patterns
		for (PiecePosition[] winPattern : winPatterns) {
			boolean flag = true;
			for (PiecePosition winPosition : winPattern) {
				if (!positions.contains(winPosition)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				return true;
			}
		}
		return false;
	}

	private void alert(final String header, final String content) {
		final DialogBox box = new DialogBox();
		final VerticalPanel panel = new VerticalPanel();
		box.setText(header);
		panel.add(new Label(content));
		final Button buttonClose = new Button("Close", new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				box.hide();
				Window.Location.reload();
			}
		});
		// few empty labels to make widget larger
		final Label emptyLabel = new Label("");
		emptyLabel.setSize("auto", "25px");
		panel.add(emptyLabel);
		panel.add(emptyLabel);
		buttonClose.setWidth("90px");
		panel.add(buttonClose);
		panel.setCellHorizontalAlignment(buttonClose, HasAlignment.ALIGN_RIGHT);
		box.add(panel);
		box.setAnimationEnabled(true);
		box.setGlassEnabled(true);
		box.center();
		box.show();
	}
}
