package machine;

public class RomanianConsoleOutput implements ConsoleOutput{
    @Override
    public void printMainMenu() {
        System.out.println("tasteaza 1 pentru a cumpara / 2 pentru a reincarca/ 3 pentru a colecta soldul / 4 pntru a consulta statusul" +
                        "5 pentru iesire");
    }
    @Override
    public void printCoffeeMenu() {
        System.out.println("tasteaza 1 pentru espresso, 2 pentru latte, 3 pentru capuccino, 4 pentru meniul anterior");
    }
    @Override
    public void printWaterQprompt() {
        System.out.println("Introdu cantitaatea de apa");
    }

    @Override
    public void printMilkQprompt() {
        System.out.println("Introdu cantitaatea de lapte");
    }

    @Override
    public void printCoffeeQprompt() {
        System.out.println("Introdu cantitaatea de cafea");
    }

    @Override
    public void printCupsQprompt() {
        System.out.println("Introdu numarul de pahare");
    }

    @Override
    public void printTakeMoneyPrompt(String amountOfMoney) {
        System.out.println("Am eliberat " + amountOfMoney + " $");
    }

    @Override
    public void printStatus(String waterQuantity, String milkQuantity, String coffeeQuantity, String noOfCups, int amountOfMoney) {
        System.out.println("Status:");
        System.out.println(waterQuantity + " ml de apa");
        System.out.println(milkQuantity + " ml  de lapte");
        System.out.println(coffeeQuantity + " boabe de cafe");
        System.out.println(noOfCups + " pahare");
        System.out.println(amountOfMoney + " $");

    }
}


