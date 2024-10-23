package File_UTS;

class Corn extends Crop {
    public Corn() {
        super("Corn", 60, 2, new String[]{"Spring", "Summer"});
    }

    @Override
    public void grow() {
        if (!isSick) {
            growthStage++;
            System.out.println("Corn has grown to stage: " + growthStage);
        }
    }
}