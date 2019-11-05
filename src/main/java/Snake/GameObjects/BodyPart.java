package Snake.GameObjects;
import java.util.Objects;

public class BodyPart extends GameObject{
    int prevBodyXPos;
    int prevBodyYPos;
    public BodyPart nextBodyPart = null;
    public BodyPart prevBodyPart = null;
    public char bodySymbol;
    public boolean doIhaveToSpawnBodyPart;

    BodyPart(int XPos,int YPos, char bodySymbol){
        super(XPos,YPos);
        this.bodySymbol = bodySymbol;
        doIhaveToSpawnBodyPart = false;
    }
    void addBodyPart(char bodySymbol){
        nextBodyPart = new BodyPart(prevBodyXPos,prevBodyYPos,bodySymbol);
        nextBodyPart.prevBodyPart = this;
    }
    void addBodyPartInLocation(int locX,int locY,char bodySymbol){
        nextBodyPart = new BodyPart(locX,locY,bodySymbol);
        nextBodyPart.prevBodyPart = this;
    }
    public void update(){
        if(prevBodyPart!=null){
            prevBodyXPos = bodyXPos;
            prevBodyYPos = bodyYPos;
            bodyXPos = prevBodyPart.prevBodyXPos;
            bodyYPos = prevBodyPart.prevBodyYPos;
        }if(nextBodyPart!=null){
            nextBodyPart.update();
        }if(doIhaveToSpawnBodyPart){
            addBodyPart(bodySymbol);
            doIhaveToSpawnBodyPart = false;
        }
    }

}
