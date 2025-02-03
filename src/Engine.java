public class Engine {
    private Player aP1;
    private Player aP2;
    private UI aUI;


    public Engine(Player aP1, Player aP2) {
        this.aP1 = aP1;
        this.aP2 = aP2;
    }

    public void setUI(final UI pUI){
        this.aUI = pUI;
    }


}
