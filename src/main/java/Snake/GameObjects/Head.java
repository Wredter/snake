package Snake.GameObjects;

public class Head extends BodyPart {
    public Head(int XPos,int YPos,char bodySymbol,char headSymbol, int initialLenght) {
        super(XPos, YPos, headSymbol);
        for(int i = 0;i<initialLenght;i++){
            BodyPart part = this;
            while (part.nextBodyPart != null){
                part = part.nextBodyPart;
            }
            part.addBodyPartInLocation(XPos+1+i,YPos,bodySymbol);
        }
    }
    public void update(char input) {
        prevBodyXPos = bodyXPos;
        prevBodyYPos = bodyYPos;
        switch (input){
            case 'w':
                bodyXPos -=1;
                break;
            case 's':
                bodyXPos +=1;
                break;
            case 'a':
                bodyYPos -=1;
                break;
            case 'd':
                bodyYPos +=1;
                break;
        }
        nextBodyPart.update();
    }
}
