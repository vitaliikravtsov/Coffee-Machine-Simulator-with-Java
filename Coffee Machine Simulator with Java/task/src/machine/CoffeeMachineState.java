package machine;

public enum CoffeeMachineState {
    CHOOSING_AN_ACTION("Write action (buy, fill, take, remaining, exit):"),
    CHOOSING_A_COFFEE_TYPE("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:"),
    FILL_INGREDIENTS("Write how many %s you want to add:"),
    FINISH("");
    private final String prompt;

    CoffeeMachineState(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }
}
