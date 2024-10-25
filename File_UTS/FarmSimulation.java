import java.util.Scanner;

public class FarmSimulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        System.out.print("Enter your farm's name: ");
        String farmName = scanner.nextLine();
        System.out.print("Enter land soil type (Loamy, Sandy, Clay): ");
        String soilType = scanner.nextLine();
        System.out.print("Enter land size (e.g., 5): ");
        int landSize = scanner.nextInt();

        Player player = new Player(playerName, 1000, farmName);
        Land land = new Land(soilType, landSize);
        Time gameTime = new Time();
        Weather weather = new Weather();

        boolean gameRunning = true;
        while (gameRunning) {
            displayStatus(player, land, gameTime, weather);

            System.out.println("1. Plant crop");
            System.out.println("2. Water crops");
            System.out.println("3. Fertilize crops");
            System.out.println("4. Harvest crops");
            System.out.println("5. Rest");
            System.out.println("6. Pass day");
            System.out.println("7. Visit Store");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Choose a crop to plant:");
                    System.out.println("1. Wheat, 2. Tomato, 3. Carrot, 4. Strawberry, 5. Potato");
                    int cropChoice = scanner.nextInt();
                    Crop cropToPlant;
                    switch (cropChoice) {
                        case 1: cropToPlant = new Wheat(); break;
                        case 2: cropToPlant = new Tomato(); break;
                        case 3: cropToPlant = new Carrot(); break;
                        case 4: cropToPlant = new Strawberry(); break;
                        case 5: cropToPlant = new Potato(); break;
                        default: System.out.println("Invalid choice."); continue;
                    }
                    player.plantCrop(land, cropToPlant, gameTime.getSeason());
                    break;

                case 2:
                    System.out.print("Enter the amount of water: ");
                    int waterAmount = scanner.nextInt();
                    player.waterLand(land, waterAmount);
                    break;

                case 3:
                    player.fertilizeLand(land);
                    break;

                case 4:
                    player.harvestLand(land);
                    break;

                case 5:
                    player.rest();
                    break;

                case 6:
                    gameTime.passDay();
                    weather.changeWeather();
                    weather.applyWeatherEffects(land);
                    System.out.println("A new day has passed.");
                    break;

                case 7:
                    System.out.println("1. Buy Seeds (1. Wheat, 2. Tomato, 3. Carrot, 4. Strawberry, 5. Potato)");
                    System.out.println("2. Buy Fertilizer");
                    System.out.println("3. Buy Tools (1. Watering Can, 2. Hoe)");
                    int storeChoice = scanner.nextInt();
                    switch (storeChoice) {
                        case 1:
                            System.out.println("Choose a seed type:");
                            System.out.println("1. Wheat");
                            System.out.println("2. Tomato");
                            System.out.println("3. Carrot");
                            System.out.println("4. Strawberry");
                            System.out.println("5. Potato");
                            int seedChoice = scanner.nextInt();
                            Crop crop;
                            switch (seedChoice) {
                                case 1: crop = new Wheat(); break;
                                case 2: crop = new Tomato(); break;
                                case 3: crop = new Carrot(); break;
                                case 4: crop = new Strawberry(); break;
                                case 5: crop = new Potato(); break;
                                default: System.out.println("Invalid choice."); continue;
                            }
                            player.buySeeds(crop);
                            break;

                        case 2:
                            player.buyFertilizer();
                            break;

                        case 3:
                            System.out.println("1. Watering Can");
                            System.out.println("2. Hoe");
                            int toolChoice = scanner.nextInt();
                            switch (toolChoice) {
                                case 1: player.buyTool("Watering Can"); break;
                                case 2: player.buyTool("Hoe"); break;
                                default: System.out.println("Invalid tool choice.");
                            }
                            break;

                        default:
                            System.out.println("Invalid store option.");
                    }
                    break;

                case 8:
                    gameRunning = false;
                    System.out.println("Exiting the simulation. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
        scanner.close();
    }

    private static void displayStatus(Player player, Land land, Time gameTime, Weather weather) {
        System.out.println("\n========= Current Status =========");
        System.out.println("Player Name: " + player.getName());
        System.out.println("Farm Name: " + player.getFarmName());
        System.out.println("Energy: " + player.getEnergy());
        System.out.println("Money: $" + player.getMoney());
        System.out.println("Land: " + land.getSize() + " square meters, Soil Type: " + land.getSoilType());
        System.out.println("Current day: " + gameTime.getCurrentDay());
        System.out.println("Season: " + gameTime.getSeason());
        System.out.println("Weather: " + weather.getCondition());
        if (!land.isEmpty()) {
            System.out.println("Planted Crops:");
            for (Crop crop : land.getPlantedCrops()) {
                System.out.println("- " + crop.name + " (Growth Stage: " + crop.growthStage + ")");
            }
        } else {
            System.out.println("No crop is currently planted.");
        }
        System.out.println("====================================\n");
    }
}
