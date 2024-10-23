package File_UTS;

class Potato extends Crop {
    public Potato() {
        super("Potato", 40, 2, new String[]{"Fall", "Winter"});
    }

    @Override
    public void grow() {
        if (!isSick) {
            growthStage++;
            System.out.println("Potato has grown to stage: " + growthStage);
        }
    }

    @Override
    public int getSellPrice() {
        return 140;
    }
}