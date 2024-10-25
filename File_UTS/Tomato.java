package File_UTS;

class Tomato extends Crop {
    public Tomato() {
        super("Tomato", 4, 3, new String[]{"Summer"});
    }

    @Override
    public void grow() {
        if (!isSick) {
            growthStage++;
            System.out.println("Tomato has grown to stage: " + growthStage);
        }
    }

    @Override
    public int getSellPrice() {
        return 180; 
    }
}
