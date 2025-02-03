public class Game {
    private UI aUI;
    private Engine aEngine;

    public Game(){
        aUI = new UI();
        aEngine = new Engine(new Player("A",0), new Player("B",1));
    }
}
