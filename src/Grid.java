import java.util.Arrays;

public class Grid {
    private Case[][] grid;
    private int rows;
    private int cols;

    public Grid() {
        rows = 6;
        cols = 7;
        grid = new Case[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                grid[i][j].setState(0);         // initialisation de la grille ( toutes les cases sont vides )
            }
        }
    }


    public boolean gridIsEmptyBelow(final Case aCase){
        if(aCase.getState() == 0){
            return true;
        }
        return false;
    }

    public void insert(final Case aCase){
        if(gridIsEmptyBelow(aCase)){
            grid[aCase.getRow()][aCase.getCol()] = aCase;
        }
        insert()
    }

}
