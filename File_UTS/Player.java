package File_UTS;

class Player {
    private String name;
    private int money;
    private int energy;
    private String farmName;
    private Store store;

    public Player(String name, int initialMoney, String farmName) {
        this.name = name;
        this.money = initialMoney;
        this.energy = 100;
        this.farmName = farmName;
        this.store = new Store(initialMoney);
    }

    public String getName() { return name; }
    public String getFarmName() { return farmName; }
    public int getMoney() { return money; }
    public int getEnergy() { return energy; }

    public void plantCrop(Land land, Crop crop, String season) {
        if (crop.canBePlantedIn(season)) {
            if (energy > 10) {
                land.plantCrop(crop);
                energy -= 10;
                System.out.println("You planted " + crop.name + " on your land.");
            } else {
                System.out.println("You don't have enough energy to plant crops.");
            }
        } else {
            System.out.println(crop.name + " cannot be planted in this season.");
        }
    }

    public void waterLand(Land land, int waterAmount) {
        if (!land.isEmpty()) {
            if (energy > 5) {
                land.waterCrops(waterAmount);
                energy -= 5;
            } else {
                System.out.println("You don't have enough energy to water crops.");
            }
        } else {
            System.out.println("There's no crop to water.");
        }
    }

    public void fertilizeLand(Land land) {
        if (!land.isEmpty()) {
            if (energy > 8) {
                land.fertilizeCrops();
                energy -= 8;
            } else {
                System.out.println("You don't have enough energy to fertilize crops.");
            }
        } else {
            System.out.println("There's no crop to fertilize.");
        }
    }

    public void harvestLand(Land land) {
        if (!land.isEmpty()) {
            land.harvestCrops();
            energy -= 15;
        } else {
            System.out.println("There's no crop to harvest.");
        }
    }
}
