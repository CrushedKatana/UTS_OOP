package File_UTS;

class Rice extends Crop {
    public Rice() {
        super("Rice", 90, 3, new String[]{"Summer"});
    }

    @Override
    public void grow() {
        if (!isSick) {
            growthStage++;
            System.out.println("Rice has grown to stage: " + growthStage);
        }
    }
}