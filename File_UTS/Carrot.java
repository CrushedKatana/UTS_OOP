package File_UTS;

class Carrot extends Crop {
    public Carrot() {
        super("Carrot", 7, 1, new String[]{"Spring", "Winter"});
    }

    @Override
    public void grow() {
        if (!isSick) {
            growthStage++;
            System.out.println("Carrot has grown to stage: " + growthStage);
        }
    }

    @Override
    public int getSellPrice() {
        return 120; 
    }
}