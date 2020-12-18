package machine;

public class EnglishConsoleOutput  implements ConsoleOutput{
    @Override
    public void printMainMenu() {
        System.out.println("type 1 to buy / 2 to fill / 3 to  take money / 4 to see the remaining quantities/ 5 to exit");
    }

    @Override
    public void printCoffeeMenu() {
        System.out.println("type 1 for espresso, 2 for latte, 3 for capuccino, 4 to go back");
    }

    @Override
    public void printWaterQprompt() {
        System.out.println("Input water quantity");
    }

    @Override
    public void printMilkQprompt() {
        System.out.println("Input milk quantity");
    }

    @Override
    public void printCoffeeQprompt() {
        System.out.println("Input coffee quantity");
    }

    @Override
    public void printCupsQprompt() {
        System.out.println("Input number of cups");
    }

    @Override
    public void printTakeMoneyPrompt(String amountOfMoney) {
        System.out.println("I gave you $" + amountOfMoney);
    }

    @Override
    public void printStatus(String waterQuantity, String milkQuantity, String coffeeQuantity, String noOfCups, int amountOfMoney) {
        System.out.println("The coffee machine has:");
        System.out.println(waterQuantity + " of water");
        System.out.println(milkQuantity + " of milk");
        System.out.println(coffeeQuantity + " of coffee beans");
        System.out.println(noOfCups + " of disposable cups");
        System.out.println(amountOfMoney + " of money");

    }
    // Alt insert ctrl I
}
