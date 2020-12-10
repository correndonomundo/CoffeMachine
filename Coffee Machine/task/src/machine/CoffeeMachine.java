package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        String userOption = "";

        /*CoffeeMachine a = new CoffeeMachine();
        CoffeeMachine b = new CoffeeMachine();
        CoffeeMachine c = new CoffeeMachine();
        CoffeeMachine d = new CoffeeMachine();*/

        while (true) {

            userOption = scan.next();
            coffeeMachine.processUserInput(userOption);

        }


    }

    private int waterQuantity = 400;
    private int milkQuantity = 540;
    private int coffeeQuantity = 120;
    private int noOfCups = 9;
    private int amountOfMoney = 550;
    private boolean exit = false;
    private MachineState machineState = MachineState.CHOOSING_OPTION;

    public CoffeeMachine(){
         waterQuantity = 400;
        milkQuantity = 540;
         coffeeQuantity = 120;
         noOfCups = 9;
         amountOfMoney = 550;
         exit = false;
      machineState = MachineState.CHOOSING_OPTION;
        System.out.println("type buy / fill / take / remaining/ exit");
    }

    public int getWaterQuantity() {
        return waterQuantity;
    }

    public void setWaterQuantity(int waterQuantity) {
        this.waterQuantity = waterQuantity;
    }

    public int getMilkQuantity() {
        return milkQuantity;
    }

    public void setMilkQuantity(int milkQuantity) {
        this.milkQuantity = milkQuantity;
    }

    public int getCoffeeQuantity() {
        return coffeeQuantity;
    }

    public void setCoffeeQuantity(int coffeeQuantity) {
        this.coffeeQuantity = coffeeQuantity;
    }

    public int getNoOfCups() {
        return noOfCups;
    }

    public void setNoOfCups(int noOfCups) {
        this.noOfCups = noOfCups;
    }

    public void processUserInput(String userInput) {
        machineState.process(this, userInput);
    }

    public void checkAndBuy(int requestedWater, int requestedCoffee, int requestedMilk, int price, CoffeeType coffeType) {
        boolean checkWater = checkIfIsEnough(requestedWater, waterQuantity);
        boolean checkMilk = checkIfIsEnough(requestedMilk, milkQuantity);
        boolean checkCoffe = checkIfIsEnough(requestedCoffee, coffeeQuantity);
        boolean checkCups = checkNoOfCups();

        if (checkWater && checkCoffe && checkMilk && checkCups) {
            waterQuantity = waterQuantity - requestedWater;
            milkQuantity = milkQuantity - requestedMilk;
            coffeeQuantity = coffeeQuantity - requestedCoffee;
            noOfCups = noOfCups - 1;
            amountOfMoney = amountOfMoney + price;
            System.out.println("Here's your " + coffeType);
        } else {
            System.out.println("Some ingredients missing");
        }

    }

    private boolean checkIfIsEnough(int requested, int available) {
       return  requested < available ;

    }

        private boolean checkNoOfCups() {
            return noOfCups >= 1;

        }

        private void printTheStatus() {
            System.out.println("The coffee machine has:");
            System.out.println(waterQuantity + " of water");
            System.out.println(milkQuantity + " of milk");
            System.out.println(coffeeQuantity + " of coffee beans");
            System.out.println(noOfCups + " of disposable cups");
            System.out.println(amountOfMoney + " of money");
        }


        public void transitionToChoosing_option(){
            machineState = MachineState.CHOOSING_OPTION;
            System.out.println("type buy / fill / take / remaining/ exit");
        }
        // This is very similar to a setter method
        public void transitionToChoosingCoffeeType() {
            machineState = MachineState.CHOOSING_COFFEE_TYPE;
            System.out.println("type 1 for espresso, 2 for latte, 3 for capuccino, 4 to go back");
        }
    public void transitionToInputWater() {
        machineState = MachineState.FILL_WATER;
        System.out.println("Input water quantity");
    }

        public void transitionToInputMilk(){
            machineState = MachineState.FILL_MILK;
            System.out.println("Input milk quantity");
        }

        public void transitionToInputCoffee(){
            machineState = MachineState.FILL_COFFEE;
            System.out.println("Input coffee quantity");
        }

    public void transitionToInputCups(){
        machineState = MachineState.FILL_CUPS;
        System.out.println("Input number of cups");
    }
        public void transitionToTakeMoney() {
            machineState = MachineState.TAKING_MONEY;
            System.out.println("I gave you $" + amountOfMoney);
            amountOfMoney = 0;
            machineState.process(this,"");
    }

    public void  transitionToPrintStatus(){
        machineState = MachineState.PRINTING_STATUS;
        printTheStatus();
        machineState.process(this,"");
    }

    public boolean isRunning(String input){
        if(input.equals("exit")){
            exit = true;
        }
        return exit;
    }

    public void transitionToExit(){
        machineState = MachineState.EXIT;
    }

}
