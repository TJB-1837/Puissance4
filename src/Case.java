public class Case {
    private int aState;
    private int[] aGridPos;


    public Case(int pState, int pX, int pY) {
        this.aState = pState;
        this.aGridPos = new int[2];
        this.aGridPos[0] = pX;
        this.aGridPos[1] = pY;

    }

    public int getState() { // 0: empty, 1: rouge, 2: jaune
        return this.aState;
    }

    public void setState(int pState) {
        this.aState = pState;
    }

    public int[] getGridPos() {
        return this.aGridPos;
    }

    public void setRow(final int pRow){
        this.aGridPos[0] = pRow;
    }

    public void setCol(final int pCol){
        this.aGridPos[1] = pCol;
    }

    public int getRow(){
        return this.aGridPos[0];
    }

    public int getCol(){
        return this.aGridPos[1];
    }


}
