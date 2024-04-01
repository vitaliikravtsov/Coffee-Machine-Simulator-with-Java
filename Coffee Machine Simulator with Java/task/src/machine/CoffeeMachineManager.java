package machine;

import java.util.Scanner;

public class CoffeeMachineManager {
    public static Scanner scanner = new Scanner(System.in);
    private CoffeeMachine coffeeMachine = new CoffeeMachine();
    private CoffeeMachineState coffeeMachineState = CoffeeMachineState.CHOOSING_AN_ACTION;
    public void coffeeMachineStart() {
        while (!coffeeMachineState.equals(CoffeeMachineState.FINISH)) {
            String clientAnswer = "";
            switch (coffeeMachineState) {
                case CHOOSING_AN_ACTION -> {
                    clientAnswer = userInteraction(coffeeMachineState.getPrompt());
                    System.out.println(clientAnswer);
                    switch (clientAnswer) {
                        case "buy" -> coffeeMachineState = CoffeeMachineState.CHOOSING_A_COFFEE_TYPE;
                        case "fill" -> {
                            coffeeMachineState = CoffeeMachineState.FILL_INGREDIENTS;
                            String water = userInteraction(coffeeMachineState.getPrompt().formatted("ml of water"));
                            String milk = userInteraction(coffeeMachineState.getPrompt().formatted("ml of milk"));
                            String coffeeBeans = userInteraction(coffeeMachineState.getPrompt().formatted("grams of coffee beans"));
                            String cups = userInteraction(coffeeMachineState.getPrompt().formatted("disposable cups"));
                            coffeeMachine.fillIngredients(water, milk, coffeeBeans, cups);
                            coffeeMachineState = CoffeeMachineState.CHOOSING_AN_ACTION;
                        }
                        case "take" -> coffeeMachine.takeMoney();
                        case "remaining" -> {
                            coffeeMachine.state();
                            coffeeMachineState = CoffeeMachineState.CHOOSING_AN_ACTION;
                        }
                        case "exit" -> coffeeMachineState = CoffeeMachineState.FINISH;
                        default -> throw new IllegalStateException("Unexpected value: " + clientAnswer);
                    }
                }
                case CHOOSING_A_COFFEE_TYPE -> {
                    clientAnswer = userInteraction(coffeeMachineState.getPrompt());
                    coffeeMachine.buyCoffee(clientAnswer);
                    coffeeMachineState = CoffeeMachineState.CHOOSING_AN_ACTION;
                }
                default -> throw new IllegalStateException();
            }

        }
    }

    public String userInteraction(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

}
