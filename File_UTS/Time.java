package File_UTS;

class Time {
    private int days;
    private String season;

    public Time() {
        this.days = 0;
        this.season = "Spring";
    }

    public void passDay() {
        days++;
        if (days % 90 == 0) {
            changeSeason();
        }
        System.out.println("Day " + days + " of " + season);
    }

    private void changeSeason() {
        switch (season) {
            case "Spring":
                season = "Summer";
                break;
            case "Summer":
                season = "Fall";
                break;
            case "Fall":
                season = "Winter";
                break;
            case "Winter":
                season = "Spring";
                break;
        }
    }

    public int getCurrentDay() {
        return days;
    }

    public String getSeason() {
        return season;
    }
}
