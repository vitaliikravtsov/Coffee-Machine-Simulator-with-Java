package machine;
import java.util.Scanner;
import java.util.function.Supplier;

import static java.lang.System.in;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int money;
    private int disposableCaps;

    public CoffeeMachine() {
        water = 400;
        milk = 540;
        coffeeBeans = 120;
        money = 550;
        disposableCaps = 9;
    }

    public void state() {
        System.out.printf("""
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                %n""", water, milk, coffeeBeans, disposableCaps, money);
    }

    public void buyCoffee(String chosenCoffeeType) {
        CoffeeType coffeeType;
        switch (chosenCoffeeType) {
            case "1" -> coffeeType = CoffeeType.ESPRESSO;
            case "2" -> coffeeType = CoffeeType.LATTE;
            case "3" -> coffeeType = CoffeeType.CAPPUCCINO;
            case "back" -> {
                return;
            }
            default -> throw new IllegalStateException("Unexpected value: " + chosenCoffeeType);
        }

        if(water < coffeeType.getWater()) {
            System.out.println("Sorry, not enough water!");
            return;
        } else if (milk < coffeeType.getMilk()) {
            System.out.println("Sorry, not enough milk!");
            return;
        } else if (coffeeBeans < coffeeType.getCoffeeBeans()) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        } else if (disposableCaps == 0) {
            System.out.println("Sorry, not enough disposable caps!");
            return;
        }

        water -= coffeeType.getWater();
        milk -= coffeeType.getMilk();
        coffeeBeans -= coffeeType.getCoffeeBeans();
        disposableCaps--;
        money += coffeeType.getPrice();
    }

    public void fillIngredients(String waterToAdd, String milkToAdd, String coffeeBeansToAdd, String cupsToAdd) {
        water += Integer.parseInt(waterToAdd);
        milk += Integer.parseInt(milkToAdd);
        coffeeBeans += Integer.parseInt(coffeeBeansToAdd);
        disposableCaps += Integer.parseInt(cupsToAdd);
    }

    public void takeMoney() {
        System.out.printf("I gave you %d money%n", money);
        money = 0;
    }
}