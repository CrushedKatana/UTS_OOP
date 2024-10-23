package File_UTS;

class Wheat extends Crop {
    public Wheat() {
        super("Wheat", 70, 2, new String[]{"Spring", "Fall"});
    }

    @Override
    public void grow() {
        if (!isSick) {
            growthStage++;
            System.out.println("Wheat has grown to stage: " + growthStage);
        }
    }

    @Override
    public int getSellPrice() {
        return 150; 
    }
}