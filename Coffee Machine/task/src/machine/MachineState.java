package machine;

public enum MachineState {

    CHOOSING_LANGUAGE{
        @Override
        void process(CoffeeMachine machine, String input) {
            System.out.println(input);
             machine.setConsoleOutput(input);
            machine.transitionToChoosing_option();
        }
    },
    CHOOSING_OPTION{
        @Override
        void process(CoffeeMachine machine, String input) {
            //1. Execute choosing option
            //2. transition in the new state
            //3. Very strict rule: when transition to a new state we must also print the menu
            switch(input){
                case "1":
                    machine.transitionToChoosingCoffeeType();
                    break;
                case "2":
                    System.out.println("filling stuff");
                    machine.transitionToInputWater();
                    break;
                case "3":
                    machine.transitionToTakeMoney(); // starea "take" este diferite de Choosing_option prin faptul ca ea nu are nevoie de userInput
                    break;
                case "4":
                    System.out.println("remaining stuff");
                    machine.transitionToPrintStatus();
                    break;
                case "5":
                    System.out.println("exit stuff");
                    break;
                default:
                    System.out.println("You did not type correctly");
                    break;


            }
        }
    },
    CHOOSING_COFFEE_TYPE{
        @Override
        void process(CoffeeMachine machine, String input) {
            CoffeeType coffeeType;
            if(input.equals("1")) {
                coffeeType = CoffeeType.ESSPRESSO;
            } else if(input.equals("2")){
                coffeeType = CoffeeType.LATTE;
            }else if(input.equals("3")){
                coffeeType = CoffeeType.CAPUCCINO;
            } else if(input.equals("4")){
                machine.transitionToChoosing_option();
                return;
            } else {
                System.out.println("your input was incorrect ");
                machine.transitionToChoosingCoffeeType();
                return;
            }

            machine.checkAndBuy(coffeeType.getRequiredWater(), coffeeType.getRequiredMilk(), coffeeType.getRequiredCoffee(), coffeeType.getPrice(), coffeeType);
            machine.transitionToChoosing_option();
        }
    },
    FILL_WATER{
        @Override
        void process(CoffeeMachine machine, String input) {
            int waterQuantity = machine.getWaterQuantity() + Integer.valueOf(input);
            machine.setWaterQuantity(waterQuantity);
            System.out.println("Now I have " + waterQuantity + " water");
            machine.transitionToInputMilk();


        }
    },
    FILL_MILK{
        @Override
        void process(CoffeeMachine machine, String input) {
            int milkQuantity = machine.getMilkQuantity() + Integer.valueOf(input);
            machine.setMilkQuantity(milkQuantity);
            System.out.println("Now I have " + milkQuantity + " milk");
            machine.transitionToInputCoffee();

        }
    },
    FILL_COFFEE{
        @Override
        void process(CoffeeMachine machine, String input) {
            int coffeeQuantity = machine.getCoffeeQuantity() + Integer.valueOf(input);
            machine.setCoffeeQuantity(coffeeQuantity);
            System.out.println("Now I have " + coffeeQuantity + " coffee");
            machine.transitionToInputCups();

        }
    },
    FILL_CUPS{
        @Override
        void process(CoffeeMachine machine, String input) {
            int noOfCups = machine.getNoOfCups() + Integer.valueOf(input);
            machine.setNoOfCups(noOfCups);
            machine.transitionToInputCups();
            System.out.println("Now I have " + noOfCups + " cups");
            machine.transitionToChoosing_option();
        }
    },
    PRINTING_STATUS{
        @Override
        void process(CoffeeMachine machine, String input) {
            machine.transitionToChoosing_option();
        }
    },
    TAKING_MONEY{
        @Override
        void process(CoffeeMachine machine, String input) {
            machine.transitionToChoosing_option();
        }
    },
    EXIT{
        @Override
        void process(CoffeeMachine machine, String input) {
            machine.setRunning(false);
            return;
        }
    };

    abstract void process(CoffeeMachine machine, String input);
}
