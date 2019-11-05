package Snake.GameObjects;
import java.util.Objects;

public class BodyPart extends GameObject{
    int prevBodyXPos;
    int prevBodyYPos;
    public BodyPart nextBodyPart = null;
    public BodyPart prevBodyPart = null;
    public char bodySymbol;

    BodyPart(int XPos,int YPos, char bodySymbol){
        super(XPos,YPos);
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
    public void update(){
        if(prevBodyPart!=null){
            prevBodyXPos = bodyXPos;
            prevBodyYPos = bodyYPos;
            bodyXPos = prevBodyPart.prevBodyXPos;
            bodyYPos = prevBodyPart.prevBodyYPos;
        }if(nextBodyPart!=null){
            nextBodyPart.update();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BodyPart part = (BodyPart) o;
        return prevBodyXPos == part.prevBodyXPos &&
                prevBodyYPos == part.prevBodyYPos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prevBodyXPos, prevBodyYPos);
    }
}
