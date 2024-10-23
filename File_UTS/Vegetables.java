package File_UTS;

class Vegetables extends Crop {
    public Vegetables() {
        super("Vegetables", 30, 1, new String[]{"Spring", "Fall"});
    }

    @Override
    public void grow() {
        if (!isSick) {
            growthStage++;
            System.out.println("Vegetables have grown to stage: " + growthStage);
        }
    }
}