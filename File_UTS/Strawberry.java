package File_UTS;

class Strawberry extends Crop {
    public Strawberry() {
        super("Strawberry", 4, 2, new String[]{"Spring"});
    }

    @Override
    public void grow() {
        if (!isSick) {
            growthStage++;
            System.out.println("Strawberry has grown to stage: " + growthStage);
        }
    }

    @Override
    public int getSellPrice() {
        return 200; 
    }
}
