package machine;

public enum CoffeeType {

    ESSPRESSO(250, 0, 16,4 ),
    LATTE(350, 75, 20, 7),
    CAPUCCINO(200,100, 12, 6);



    private int requiredWater;
    private  int requiredMilk;
    private int requiredCoffee;
    private int price;


    CoffeeType(int requiredWater, int requiredMilk, int requiredCOffee, int price) {
        this.requiredWater = requiredWater;
        this.requiredMilk = requiredMilk;
        this.requiredCoffee = requiredCOffee;
        this.price = price;

    }

    public int getRequiredWater()
    {
        return requiredWater;
    }

    public int getRequiredMilk() {
        return requiredMilk;
    }

    public int getRequiredCoffee(){
        return requiredCoffee;
    }

    public int getPrice(){
        return price;
    }
}
