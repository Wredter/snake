package Snake.GameObjects.Static;

import Snake.GameObjects.GameObject;

public class BoardTile extends GameObject {
    char defultTileSymbol;
    char currentTileSymbol;
    public BoardTile(int XPos, int YPos, boolean canEnter, char defultTileSymbol) {
        super(XPos, YPos);
        this.canEnter = canEnter;
        this.defultTileSymbol = defultTileSymbol;
        currentTileSymbol = defultTileSymbol;
    }
}
