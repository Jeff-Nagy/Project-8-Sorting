import java.util.*;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;


public class SortGUI extends Application {

	private Button sortButton;
	private Pane selectionSortPane, insertionSortPane;
	
	// variables for the display
	private static final int ARRAY_SIZE = 50, BAR_WIDTH = 8, SPACE_APART = 5; 
	private static final int SSORT_Y_START = 120, ISORT_Y_START = 170;

	private static final int MAX = 80, MIN = 1;
	private int[] selectionArray, insertionArray;
	
	private int buttonClickCount;

	
	public void start(Stage primaryStage) {
		
		sortButton = new Button("Click to take one step in the sort");
		sortButton.setOnAction(this::handleButton);
		HBox buttonBox = new HBox(sortButton);
		buttonBox.setAlignment(Pos.CENTER);
		
		selectionArray = new int[ARRAY_SIZE];
		insertionArray = new int[ARRAY_SIZE];

		
		// EXTRA CREDIT HERE
		Random random = new Random();
		Set<Integer> uniqueNums = new LinkedHashSet<Integer>(ARRAY_SIZE);
		while(uniqueNums.size() < ARRAY_SIZE) {
			uniqueNums.add(random.nextInt(MAX) + MIN);
		}
		// ??? YOUR CODE HERE- FILL THE ARRAYS WITH RANDOM NUMBERS USING MIN AND MAX VARIABLES (DECLARED ABOVE)
		// PUT THE SAME NUMBERS IN BOTH ARRAYS
		// IF COMPLETING EXTRA CREDIT, ENSURE THAT THERE ARE NO DUPLICATE VALUES WITHIN EACH ARRAY
		Iterator<Integer> iterator = uniqueNums.iterator();
		for(int i = 0; iterator.hasNext(); i++) {
			int uniqueNum = iterator.next();
				selectionArray[i] = uniqueNum;
				insertionArray[i] = uniqueNum;
		}
			
		selectionSortPane = new Pane();
		setupSortPane(selectionSortPane, SSORT_Y_START, selectionArray, Color.BLUE);
		
		insertionSortPane = new Pane();
		setupSortPane(insertionSortPane, ISORT_Y_START, insertionArray, Color.RED);

		Text selectionText = new Text("  Selection Sort");
		selectionText.setFont(Font.font(20));
		Text insertionText = new Text("  Insertion Sort");
		insertionText.setFont(Font.font(20));
		
		VBox primaryBox = new VBox(buttonBox, selectionSortPane, selectionText, insertionSortPane, insertionText);
		primaryBox.setStyle("-fx-background-color: white");
		Scene scene = new Scene(primaryBox, 700, 400, Color.TRANSPARENT);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Sorting GUI");
		primaryStage.show();
	}
	
	private void setupSortPane(Pane pane, int startingY, int[] array, Color color) {
		pane.getChildren().clear();
		int x = 20; 
		for (int index = 0; index < ARRAY_SIZE; index++) {
			Rectangle rect = new Rectangle(x, startingY - array[index], BAR_WIDTH,	array[index]);
			x = x + BAR_WIDTH + SPACE_APART; // Adds width and spaces so bars don't overlap
			rect.setFill(color);
			pane.getChildren().add(rect);
		}
	}
	
	// ??? YOUR CODE HERE- THIS SHOULD BE ONE SINGLE STEP OF THE SELECTION SORT
	private void modifiedSelectionSort() {
		int index = buttonClickCount - 1;
		int currentMin = selectionArray[index];
		int indexOfMin = index;
			
		for(int j = index + 1; j < selectionArray.length; j++) {
			if(selectionArray[j] < currentMin) { 
				currentMin = selectionArray[j];
				indexOfMin = j;
			}
		}
		swap(selectionArray, index, indexOfMin);
	}
	private void swap(int[] selectionArray2, int i, int j) {
		int temp = selectionArray2[i];
		selectionArray2[i] = selectionArray2[j];
		selectionArray2[j] = temp;
	}
	
	// ??? YOUR CODE HERE- THIS SHOULD BE ONE SINGLE STEP OF THE INSERTION SORT
	private void modifiedInsertionSort() {
		int index = buttonClickCount;
		int firstUnsorted = insertionArray[index];
		int position = index;
		
			while (position > 0 && firstUnsorted < insertionArray[position - 1]) {
				insertionArray[position] = insertionArray[position - 1];
				position--;
			}
			insertionArray[position] = firstUnsorted;
	}
	
	// ??? YOUR CODE HERE- WHAT HAPPENS EACH TIME THE BUTTON IS CLICKED
	private void handleButton(ActionEvent event) {
		buttonClickCount++;
		
		modifiedSelectionSort();
		modifiedInsertionSort();
		
		if(buttonClickCount < ARRAY_SIZE - 1) {
			setupSortPane(selectionSortPane, SSORT_Y_START, selectionArray, Color.BLUE);
			setupSortPane(insertionSortPane, ISORT_Y_START, insertionArray, Color.RED);
		} else {
			sortButton.setDisable(true);
			setupSortPane(selectionSortPane, SSORT_Y_START, selectionArray, Color.GREEN);
			setupSortPane(insertionSortPane, ISORT_Y_START, insertionArray, Color.GREEN);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
