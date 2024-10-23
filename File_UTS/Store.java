package File_UTS;

class Store {
    private int money;
    
    public Store(int money) {
        this.money = money;
    }

    public void buySeeds(Crop crop) {
        System.out.println("Buying seeds for " + crop.name);
        money -= 100;
    }

    public void sellHarvest(Crop crop) {
        System.out.println("Selling " + crop.name);
        money += 200;
    }

    public int getMoney() {
        return money;
    }
}
