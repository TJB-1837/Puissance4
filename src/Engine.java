public class Engine {
    private Player aP1;
    private Player aP2;
    private Grid aGrid;
    private int aMainPlayer;


    public Engine(Player aP1, Player aP2) {
        this.aP1 = aP1;
        this.aP2 = aP2;
        this.aGrid = new Grid();
        this.aMainPlayer = this.aP1.getId();
    }

    public void move(final Player p) {
        this.aGrid.insert(/* numéro de colonne donnée par l'utilisateur */,p.getId());
        this.checkVictory(p);
        move(this.alternate2());

    }

    public void setMainPlayer(int aMainPlayer) {
        this.aMainPlayer = aMainPlayer;
    }

    /**
     * Methode à utiliser après le jeu du joueur pour faire changer le joueur principal
     */
    public void alternate() {
        if (this.aMainPlayer == this.aP1.getId())
            this.setMainPlayer(this.aP2.getId());
        else
            this.setMainPlayer(this.aP1.getId());
    }

    public Player alternate2() {
        if (this.aMainPlayer == this.aP1.getId()){
            this.setMainPlayer(this.aP2.getId());
            return this.aP2;
        }else {
            this.setMainPlayer(this.aP1.getId());
            return this.aP1;
        }
    }

    public boolean checkAlignementHorizontal(final Player p) {
        int rows = this.aGrid.ROWS;
        int cols = this.aGrid.COLS;
        int playerId = p.getId();
        int cpt;
        for (int i = 0; i < rows; i++) {
            cpt = 0;
            for (int j = 1; j < cols; j++) {
                if (this.aGrid.getGrid()[i][j].getState() == playerId) {
                    cpt++;
                    if (cpt == 4) return true;
                } else
                    cpt = 0;
            }
        }
        return false;
    }


    public boolean checkAlignementVertical(final Player p){
        int rows = this.aGrid.ROWS;
        int cols = this.aGrid.COLS;
        int playerId = p.getId();
        int cpt;
        for(int i = 0; i<cols; i++ ){
            cpt = 0;
            for(int j = 0; j<rows; j++){
                if(this.aGrid.getGrid()[i][j].getState() == playerId){
                    cpt++;
                    if(cpt == 4) return true;
                }else
                    cpt = 0;
            }
        }
        return false;
    }

    public boolean checkAlignementDiagonalM(final Player p) {
        int rows = this.aGrid.ROWS;
        int cols = this.aGrid.COLS;
        int playerId = p.getId();

        for (int i = 3; i < rows; i++) {
            for (int j = 0; j < cols - 3; j++) {
                if (this.aGrid.getGrid()[i][j].getState() == playerId &&
                        this.aGrid.getGrid()[i - 1][j + 1].getState() == playerId &&
                        this.aGrid.getGrid()[i - 2][j + 2].getState() == playerId &&
                        this.aGrid.getGrid()[i - 3][j + 3].getState() == playerId)
                    return true;

            }
        }
        return false;
    }

    public boolean checkAlignementDiagonalD(final Player p) {
        int rows = this.aGrid.ROWS;
        int cols = this.aGrid.COLS;
        int playerId = p.getId();

        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < cols - 3; j++) {
                if (this.aGrid.getGrid()[i][j].getState() == playerId &&
                        this.aGrid.getGrid()[i + 1][j + 1].getState() == playerId &&
                        this.aGrid.getGrid()[i + 2][j + 2].getState() == playerId &&
                        this.aGrid.getGrid()[i + 3][j + 3].getState() == playerId)
                    return true;
            }
        }
        return false;
    }

    public boolean checkVictory(final Player p){
        boolean result = false;
        if(checkAlignementHorizontal(p)){
            result = true;
        }else if(checkAlignementVertical(p)){
            result = true;
        }else if(checkAlignementDiagonalM(p)){
            result = true;
        }else if(checkAlignementDiagonalD(p)){
            result = true;
        }
        return result;
    }

}
