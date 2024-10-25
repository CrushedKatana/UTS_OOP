package File_UTS;

import java.util.ArrayList;
import java.util.List;

class Land {
    private String soilType;
    private List<Crop> plantedCrops; // Modified to hold multiple crops
    private int size;

    public Land(String soilType, int size) {
        this.soilType = soilType;
        this.size = size;
        this.plantedCrops = new ArrayList<>(); // Initialize the list for crops
    }

    public String getSoilType() { return soilType; }
    public int getSize() { return size; }
    public boolean isEmpty() { return plantedCrops.isEmpty(); }
    public List<Crop> getPlantedCrops() { return plantedCrops; }

    public void plantCrop(Crop crop) {
        if (plantedCrops.size() < size) { // Check if land has space
            plantedCrops.add(crop);
            System.out.println("Planted " + crop.name + " in the land.");
        } else {
            System.out.println("Land is fully occupied.");
        }
    }

    public void waterCrops(int waterAmount) {
        for (Crop crop : plantedCrops) {
            crop.water(waterAmount);
        }
    }

    public void fertilizeCrops() {
        for (Crop crop : plantedCrops) {
            crop.fertilize();
        }
    }

    public void harvestCrops() {
        List<Crop> harvestedCrops = new ArrayList<>();
        for (Crop crop : plantedCrops) {
            if (crop.isReadyToHarvest()) {
                crop.harvest();
                harvestedCrops.add(crop); // Track crops to remove
            } else {
                System.out.println(crop.name + " is not ready to harvest yet.");
            }
        }
        plantedCrops.removeAll(harvestedCrops); // Remove harvested crops
    }
}
