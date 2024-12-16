import java.util.Stack;

public class BubbleAndSelectionSorterAndStack {

    // The creature data is already set here
    static String[] names = {"Dragon:", "Griffin:", "Unicorn:", "Phoenix:", "Centaur:"};
    static int[] powerLevels = {95, 88, 78, 92, 85};

    public static void main(String[] args) {
        // Bubble Sort
        System.out.println("\n- - { { [ Bubble Sort: Descending Order by Power Level ] } } - - \n");
        bubbleSortDescending();
        displayCreatures();

        // Selection Sort
        System.out.println("\n- - { { [ Selection Sort: Ascending Order by Power Level ] } } - - \n");
        selectionSortAscending();
        displayCreatures();

        // Stack Implementation
        System.out.println("\n- - { { [ Stack Implementation: Popping Creatures ] } } - -\n");
        bubbleSortDescending(); // Sorting in descending order for the stack
        stackImplementation();
    }

    // Bubble Sort to arrange the power levels from highest to lowest
    public static void bubbleSortDescending() {
        for (int i = 0; i < powerLevels.length - 1; i++) {
            for (int j = 0; j < powerLevels.length - i - 1; j++) {
                if (powerLevels[j] < powerLevels[j + 1]) {
                    // Switch the power levels
                    int temp = powerLevels[j];
                    powerLevels[j] = powerLevels[j + 1];
                    powerLevels[j + 1] = temp;

                    // Switch the names to match the sorted power levels
                    String tempName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;
                }
            }
        }
    }

    // Selection Sort to arrange the power levels from lowest to highest
    public static void selectionSortAscending() {
        for (int i = 0; i < powerLevels.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < powerLevels.length; j++) {
                if (powerLevels[j] < powerLevels[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap power levels
            int temp = powerLevels[minIndex];
            powerLevels[minIndex] = powerLevels[i];
            powerLevels[i] = temp;

            // Swap corresponding names
            String tempName = names[minIndex];
            names[minIndex] = names[i];
            names[i] = tempName;
        }
    }

    // Stack Implementation
    public static void stackImplementation() {
        Stack<String> creatureStack = new Stack<>();

        // Add all the creatures to the stack
        for (int i = 0; i < names.length; i++) {
            creatureStack.push(names[i] + " - " + powerLevels[i]);
        }

        // Remove and show creatures from the stack
        while (!creatureStack.isEmpty()) {
            System.out.println("Popped: " + creatureStack.pop());
            
        }
    }

    // Show the list of creatures
    public static void displayCreatures() {
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " " + powerLevels[i]);
        }
    }
}
