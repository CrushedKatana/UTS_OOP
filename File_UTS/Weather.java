package File_UTS;

class Weather {
    private String condition; // e.g., sunny, rainy, stormy

    public Weather() {
        this.condition = "Sunny";
    }

    public void changeWeather() {
        int random = (int) (Math.random() * 3);
        switch (random) {
            case 0:
                condition = "Sunny";
                break;
            case 1:
                condition = "Rainy";
                break;
            case 2:
                condition = "Stormy";
                break;
        }
        System.out.println("The weather is now " + condition);
    }

    public String getCondition() {
        return condition;
    }
}
