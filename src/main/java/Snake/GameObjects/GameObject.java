package Snake.GameObjects;

public class GameObject {
    public int bodyXPos;
    public int bodyYPos;
    public boolean canEnter;

    public GameObject(int XPos,int YPos){
        bodyXPos = XPos;
        bodyYPos = YPos;
        canEnter = true;

    }
    public void update(){

    }
    public boolean isOnTheSamePositionAs(GameObject o){
        if (this == o) return true;
        return bodyXPos == o.bodyXPos &&
                bodyYPos == o.bodyYPos;
    }
}
