package File_UTS;

class Weather {
    private String condition;

    public Weather() {
        this.condition = "Sunny";
    }

    public void changeWeather() {
        int random = (int) (Math.random() * 4);
        switch (random) {
            case 0: condition = "Sunny"; break;
            case 1: condition = "Rainy"; break;
            case 2: condition = "Stormy"; break;
            case 3: condition = "Drought"; break;
        }
        System.out.println("The weather is now " + condition);
    }

    public String getCondition() {
        return condition;
    }

    public void applyWeatherEffects(Land land) {
        for (Crop crop : land.getPlantedCrops()) {
            switch (condition) {
                case "Sunny":
                    System.out.println("Sunny weather! Crops grow well if watered.");
                    break;
                case "Rainy":
                    System.out.println("Rainy weather! Crops are watered automatically.");
                    land.waterCrops(crop.getWaterNeeds());
                    break;
                case "Stormy":
                    System.out.println("Stormy weather! Crops are at risk of getting sick.");
                    if (Math.random() < 0.3) { // 30% chance crop gets sick
                        crop.getSick();
                    }
                    break;
                case "Drought":
                    System.out.println("Drought! Crops need double the water.");
                    crop.water(crop.getWaterNeeds() * 2); // Double water needs
                    break;
            }
        }
    }
}
