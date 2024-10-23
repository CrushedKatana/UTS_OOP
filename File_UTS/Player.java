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

    public String getName() {
        return name;
    }

    public String getFarmName() {
        return farmName;
    }

    public int getMoney() {
        return money;
    }

    public int getEnergy() {
        return energy;
    }

    // Rest and regain energy
    public void rest() {
        energy = 100; // Reset energy after rest
        System.out.println(name + " has rested and regained energy.");
    }

    // Buy seeds through the store
    public void buySeeds(Crop crop) {
        if (store.buySeeds(crop)) {
            money = store.getMoney(); // Update player's money after purchase
        }
    }

    // Buy fertilizer through the store
    public void buyFertilizer() {
        if (store.buyFertilizer()) {
            money = store.getMoney(); // Update player's money after purchase
        }
    }

    // Buy tools through the store
    public void buyTool(String tool) {
        if (store.buyTool(tool)) {
            money = store.getMoney(); // Update player's money after purchase
        }
    }

    // Plant a crop
    public void plantCrop(Land land, Crop crop, String season) {
        if (crop.canBePlantedIn(season)) {
            if (energy > 10) {
                land.plantCrop(crop);
                energy -= 10; // Planting a crop reduces player's energy
                System.out.println("You planted " + crop.name + " on your land.");
            } else {
                System.out.println("You don't have enough energy to plant crops.");
            }
        } else {
            System.out.println(crop.name + " cannot be planted in this season.");
        }
    }

    // Water the crop in the land
    public void waterLand(Land land, int waterAmount) {
        if (land.getPlantedCrop() != null) {
            if (energy > 5) {
                land.waterCrop(waterAmount);
                energy -= 5; // Watering crops reduces player's energy
            } else {
                System.out.println("You don't have enough energy to water crops.");
            }
        } else {
            System.out.println("There's no crop to water.");
        }
    }

    // Fertilize the land
    public void fertilizeLand(Land land) {
        if (land.getPlantedCrop() != null) {
            if (energy > 8) {
                land.fertilizeCrop();
                energy -= 8; // Fertilizing crops reduces player's energy
            } else {
                System.out.println("You don't have enough energy to fertilize crops.");
            }
        } else {
            System.out.println("There's no crop to fertilize.");
        }
    }

    // Harvest crops
    public void harvestLand(Land land) {
        if (land.getPlantedCrop() != null && land.getPlantedCrop().isReadyToHarvest()) {
            land.harvestCrop();
            energy -= 15; // Harvesting crops reduces player's energy
        } else {
            System.out.println("There's no crop to harvest or crop is not ready.");
        }
    }
}


