package com.instil.utils;

import com.instil.models.Card;
import com.instil.models.FiveCard;

/**
 * Created by Hari Rao on 26/02/20.
 */
public class FiveCardBuilder {

    private Card cardOne;
    private Card cardTwo;
    private Card cardThree;
    private Card cardFour;
    private Card cardFive;

    public FiveCardBuilder setCard(Card card){
        if(cardOne==null){
            return setCardOne(card);
        }else if(cardTwo==null){
            return setCardTwo(card);
        }else if(cardThree==null){
            return setCardThree(card);
        }else if(cardFour==null){
            return setCardFour(card);
        }else if (cardFive==null){
            return setCardFive(card);
        }
        return this;
    }

    public FiveCardBuilder setCardOne(Card cardOne) {
        this.cardOne = cardOne;
        return this;
    }

    public FiveCardBuilder setCardTwo(Card cardTwo) {
        this.cardTwo = cardTwo;
        return this;
    }

    public FiveCardBuilder setCardThree(Card cardThree) {
        this.cardThree = cardThree;
        return this;
    }

    public FiveCardBuilder setCardFour(Card cardFour) {
        this.cardFour = cardFour;
        return this;
    }

    public FiveCardBuilder setCardFive(Card cardFive) {
        this.cardFive = cardFive;
        return this;
    }

    public FiveCard build(){
        return new FiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
    }

}
