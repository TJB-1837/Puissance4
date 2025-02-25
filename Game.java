public class Game {
    private UserInterface aUI;
    private Engine aEngine;

    public Game(){
        this.aEngine = new Engine(new Player("A",1), new Player("B",2));
        this.aUI = new UserInterface(aEngine);
        this.aEngine.setUI(this.aUI);
    }
}
