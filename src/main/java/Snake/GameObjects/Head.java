package Snake.GameObjects;


import Snake.GameObjects.Static.DataTypes.SnakeData;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Head extends BodyPart {
    public Head(int XPos,int YPos,char bodySymbol,char headSymbol, int initialLenght) {
        super(XPos, YPos, headSymbol);
        for(int i = 0;i<initialLenght;i++){
            BodyPart part = this;
            while (part.nextBodyPart != null){
                part = part.nextBodyPart;
            }
            part.addBodyPartInLocation(XPos+1+i,YPos,bodySymbol);
            part.canEnter = false;
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
    public List<SnakeData> getSnakePosition(){
        List<SnakeData> positions = new ArrayList<>();
        Integer x;
        Integer y;
        char symbol;

        BodyPart part = this;
        do{
            x = part.bodyXPos;
            y = part.bodyYPos;
            symbol = part.bodySymbol;
            positions.add(new SnakeData(x,y,symbol,part.prevBodyXPos,part.prevBodyYPos));
            part = part.nextBodyPart;
        }
        while (part != null);
        return positions;

    }
}
