public class Game {
    private UI aUI;
    private Engine aEngine;

    public Game(){
        aUI = new UI();
        aEngine = new Engine(new Player("A",1), new Player("B",2));
    }
}
