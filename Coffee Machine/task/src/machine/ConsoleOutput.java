package machine;

public interface ConsoleOutput {

    abstract void printMainMenu();
    abstract void printCoffeeMenu();
    abstract void printWaterQprompt();
    abstract void printMilkQprompt();
    abstract void printCoffeeQprompt();
    abstract void printCupsQprompt();
    abstract void printTakeMoneyPrompt(String amountOfMoney);
    abstract void printStatus(String waterQuantity, String milkQuantity, String coffeeQuantity, String noOfCups, int amountOfMoney);






}
