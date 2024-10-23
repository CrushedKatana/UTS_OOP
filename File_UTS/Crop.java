package File_UTS;

abstract class Crop {
    protected String name;
    protected int harvestTime;
    protected int waterNeeds;
    protected int growthStage;
    protected boolean isSick;
    protected String[] plantableSeasons;

    public Crop(String name, int harvestTime, int waterNeeds, String[] plantableSeasons) {
        this.name = name;
        this.harvestTime = harvestTime;
        this.waterNeeds = waterNeeds;
        this.growthStage = 0;
        this.isSick = false;
        this.plantableSeasons = plantableSeasons;
    }

    public int getWaterNeeds() {
        return waterNeeds;
    }

    public boolean canBePlantedIn(String currentSeason) {
        for (String season : plantableSeasons) {
            if (season.equals(currentSeason)) {
                return true;
            }
        }
        return false;
    }

    public void water(int waterAmount) {
        if (waterAmount >= waterNeeds) {
            grow();
        } else {
            System.out.println(name + " didn't get enough water.");
        }
    }

    public void fertilize() {
        System.out.println(name + " has been fertilized and will grow faster.");
        grow();
    }

    public void getSick() {
        isSick = true;
        System.out.println(name + " is sick and will not grow.");
    }

    public abstract void grow();

    public boolean isReadyToHarvest() {
        return growthStage >= harvestTime && !isSick;
    }

    public void harvest() {
        if (isReadyToHarvest()) {
            System.out.println("Harvesting " + name);
        } else {
            System.out.println(name + " is not ready to harvest yet.");
        }
    }

    public abstract int getSellPrice();
}