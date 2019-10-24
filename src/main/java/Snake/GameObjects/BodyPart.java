package Snake.GameObjects;

public class BodyPart {
    public int bodyXPos;
    public int bodyYPos;
    int prevBodyXPos;
    int prevBodyYPos;
    public BodyPart nextBodyPart = null;
    public BodyPart prevBodyPart = null;
    public char bodySymbol;

    BodyPart(int XPos,int YPos, char bodySymbol){
        bodyXPos = XPos;
        bodyYPos = YPos;
        this.bodySymbol = bodySymbol;
    }
    void addBodyPart(char bodySymbol){
        nextBodyPart = new BodyPart(prevBodyXPos,prevBodyYPos,bodySymbol);
        nextBodyPart.prevBodyPart = this;
    }
    void addBodyPartInLocation(int locX,int locY,char bodySymbol){
        nextBodyPart = new BodyPart(locX,locY,bodySymbol);
        nextBodyPart.prevBodyPart = this;
    }
    void update(){
        if(prevBodyPart!=null){
            prevBodyXPos = bodyXPos;
            prevBodyYPos = bodyYPos;
            bodyXPos = prevBodyPart.prevBodyXPos;
            bodyYPos = prevBodyPart.prevBodyYPos;
        }if(nextBodyPart!=null){
            nextBodyPart.update();
        }
    }
}
