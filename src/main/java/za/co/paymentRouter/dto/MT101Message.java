package za.co.paymentRouter.dto;

public class MT101Message extends MTMessage{

    private Block3 block3;
    private Block5 block5;

    public Block3 getBlock3() {
        return block3;
    }

    public void setBlock3(Block3 block3) {
        this.block3 = block3;
    }

    public Block5 getBlock5() {
        return block5;
    }

    public void setBlock5(Block5 block5) {
        this.block5 = block5;
    }
}
