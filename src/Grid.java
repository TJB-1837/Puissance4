import java.util.Arrays;

public class Grid {
    private Case[][] grid;
    public final int ROWS = 6;
    public final int COLS = 7;

    public Grid() {
        grid = new Case[ROWS][COLS];
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                grid[i][j] = new Case(0, i, j);         // initialisation de la grille ( toutes les cases sont vides )
            }
        }
    }

    public Case[][] getGrid() {
        return grid;
    }

    public void insert(final int pCol,final int player_id){
        if( pCol < 0 || pCol >= COLS ) throw new IndexOutOfBoundsException("Numéro de colonne invalide");
        int r = 0;
        int row = ROWS-1;
        while(row >= 0) {
            if(this.grid[row][pCol].getState() == 0) r = row;
            System.out.println(r+ " ");
            row--;
        }
        grid[r][pCol].setState(player_id);
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = ROWS-1; i >= 0; i--) {
            for(int j = 0; j < COLS; j++) {
                sb.append(grid[i][j].getState()).append(" | ");
                if(j == COLS-1) sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Grid grid = new Grid();
        grid.insert(0, 1);
        grid.insert(1, 2);
        grid.insert(2, 1);
        grid.insert(1,2);
        System.out.printf(grid.toString())
        ;

    }

}
