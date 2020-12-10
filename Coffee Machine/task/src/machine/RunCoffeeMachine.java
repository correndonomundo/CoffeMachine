package machine;

import java.util.Scanner;

    public class RunCoffeeMachine {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            CoffeeMachine coffeeMachine = new CoffeeMachine();
            String userOption = "";

       /* CoffeeMachine a = new CoffeeMachine();
        CoffeeMachine b = new CoffeeMachine();
        CoffeeMachine c = new CoffeeMachine();
        CoffeeMachine d = new CoffeeMachine();*/

            while (true) {

                userOption = scan.next();
                coffeeMachine.processUserInput(userOption);

            }


        }
    }

