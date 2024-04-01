package machine;

import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        CoffeeMachineManager coffeeMachineManager = new CoffeeMachineManager();
        coffeeMachineManager.coffeeMachineStart();















//        CoffeeMachine coffeeMachine = new CoffeeMachine();
//        while (true) {
//            System.out.println("Write action (buy, fill, take, remaining, exit):");
//            String action = scanner.nextLine();
//            switch (action) {
//                case "buy" -> coffeeMachine.buyCoffee();
//                case "fill" -> coffeeMachine.fillIngredients();
//                case "take" -> coffeeMachine.takeMoney();
//                case "remaining" -> coffeeMachine.state();
//                case "exit" -> {
//                    return;
//                }
//            }
//        }
    }
}
