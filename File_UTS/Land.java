package File_UTS;

class Land {
    private String soilType;
    private Crop plantedCrop;
    private int size;

    public Land(String soilType, int size) {
        this.soilType = soilType;
        this.size = size;
        this.plantedCrop = null; // Initially, the land has no crops
    }

    public String getSoilType() {
        return soilType;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return plantedCrop == null;
    }

    public Crop getPlantedCrop() {
        return plantedCrop;
    }

    public void plantCrop(Crop crop) {
        if (plantedCrop == null) {
            this.plantedCrop = crop;
            System.out.println("Planted " + crop.name + " in the land.");
        } else {
            System.out.println("Land is already occupied by " + plantedCrop.name);
        }
    }

    public void waterCrop(int waterAmount) {
        if (plantedCrop != null) {
            plantedCrop.water(waterAmount);
        } else {
            System.out.println("No crop to water.");
        }
    }

    public void fertilizeCrop() {
        if (plantedCrop != null) {
            plantedCrop.fertilize();
        } else {
            System.out.println("No crop to fertilize.");
        }
    }

    public void harvestCrop() {
        if (plantedCrop != null && plantedCrop.isReadyToHarvest()) {
            plantedCrop.harvest();
            plantedCrop = null; // Clear the land after harvesting
        } else {
            System.out.println("No crop to harvest or crop is not ready.");
        }
    }
}
