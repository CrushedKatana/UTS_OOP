package File_UTS;

class Store {
    private int money;

    public Store(int money) {
        this.money = money;
    }

    public boolean buySeeds(Crop crop) {
        int seedPrice = 100;  
        if (money >= seedPrice) {
            System.out.println("Bought seeds for " + crop.name + " for $" + seedPrice);
            money -= seedPrice;
            return true;
        } else {
            System.out.println("Not enough money to buy seeds.");
            return false;
        }
    }

    public boolean buyFertilizer() {
        int fertilizerPrice = 50;  
        if (money >= fertilizerPrice) {
            System.out.println("Bought fertilizer for $" + fertilizerPrice);
            money -= fertilizerPrice;
            return true;
        } else {
            System.out.println("Not enough money to buy fertilizer.");
            return false;
        }
    }

    public boolean buyTool(String tool) {
        int toolPrice = 0;
        switch (tool) {
            case "Watering Can":
                toolPrice = 150;
                break;
            case "Hoe":
                toolPrice = 200;
                break;
            default:
                System.out.println("Invalid tool selected.");
                return false;
        }

        if (money >= toolPrice) {
            System.out.println("Bought " + tool + " for $" + toolPrice);
            money -= toolPrice;
            return true;
        } else {
            System.out.println("Not enough money to buy " + tool);
            return false;
        }
    }

    public void sellHarvest(Crop crop) {
        int sellPrice = crop.getSellPrice();
        System.out.println("Sold " + crop.name + " for $" + sellPrice);
        money += sellPrice;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

