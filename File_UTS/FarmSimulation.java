package File_UTS;

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
        System.out.print("Enter land size (e.g., 100): ");
        int landSize = scanner.nextInt();

        Player player = new Player(playerName, 1000, farmName);
        Land land = new Land(soilType, landSize);
        Time gameTime = new Time();
        Weather weather = new Weather();

        boolean gameRunning = true;

        while (gameRunning) {
            displayStatus(player, land, gameTime, weather);
            System.out.println("\n========== Farm Simulation ==========");
            System.out.println("1. Plant crop");
            System.out.println("2. Water crop");
            System.out.println("3. Fertilize crop");
            System.out.println("4. Harvest crop");
            System.out.println("5. Rest");
            System.out.println("6. Pass day");
            System.out.println("7. Visit Store");
            System.out.println("8. Exit");
            System.out.println("====================================\n");

            System.out.print("Choose an action (1-8): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (land.isEmpty()) {
                        System.out.println("Choose a crop to plant:");
                        System.out.println("1. Rice");
                        System.out.println("2. Corn");
                        System.out.println("3. Wheat");
                        System.out.println("4. Tomato");
                        System.out.println("5. Carrot");
                        System.out.println("6. Strawberry");
                        System.out.println("7. Potato");

                        int cropChoice = scanner.nextInt();
                        Crop cropToPlant;
                        switch (cropChoice) {
                            case 1:
                                cropToPlant = new Rice();
                                break;
                            case 2:
                                cropToPlant = new Corn();
                                break;
                            case 3:
                                cropToPlant = new Wheat();
                                break;
                            case 4:
                                cropToPlant = new Tomato();
                                break;
                            case 5:
                                cropToPlant = new Carrot();
                                break;
                            case 6:
                                cropToPlant = new Strawberry();
                                break;
                            case 7:
                                cropToPlant = new Potato();
                                break;
                            default:
                                System.out.println("Invalid choice.");
                                continue;
                        }
                        player.plantCrop(land, cropToPlant, gameTime.getSeason());
                    } else {
                        System.out.println("There's already a crop on this land.");
                    }
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
                    System.out.println("1. Buy Seeds (1. Rice, 2. Corn, 3. Wheat, 4. Tomato, 5. Carrot, 6. Strawberry, 7. Potato)");
                    System.out.println("2. Buy Fertilizer");
                    System.out.println("3. Buy Tools (1. Watering Can, 2. Hoe)");
                    int storeChoice = scanner.nextInt();
                    switch (storeChoice) {
                        case 1:
                            System.out.println("Choose a seed type:");
                            System.out.println("1. Rice");
                            System.out.println("2. Corn");
                            System.out.println("3. Wheat");
                            System.out.println("4. Tomato");
                            System.out.println("5. Carrot");
                            System.out.println("6. Strawberry");
                            System.out.println("7. Potato");
                            int seedChoice = scanner.nextInt();
                            Crop crop;
                            switch (seedChoice) {
                                case 1:
                                    crop = new Rice();
                                    break;
                                case 2:
                                    crop = new Corn();
                                    break;
                                case 3:
                                    crop = new Wheat();
                                    break;
                                case 4:
                                    crop = new Tomato();
                                    break;
                                case 5:
                                    crop = new Carrot();
                                    break;
                                case 6:
                                    crop = new Strawberry();
                                    break;
                                case 7:
                                    crop = new Potato();
                                    break;
                                default:
                                    System.out.println("Invalid choice.");
                                    continue;
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
                                case 1:
                                    player.buyTool("Watering Can");
                                    break;
                                case 2:
                                    player.buyTool("Hoe");
                                    break;
                                default:
                                    System.out.println("Invalid tool choice.");
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
        if (land.getPlantedCrop() != null) {
            System.out.println("Planted Crop: " + land.getPlantedCrop().name + " (Growth Stage: " + land.getPlantedCrop().growthStage + ")");
        } else {
            System.out.println("No crop is currently planted.");
        }
        System.out.println("====================================\n");
    }
}
