package com.instil.utils;

import com.instil.constants.SuitEnum;
import com.instil.models.Card;

/**
 * Created by Hari Rao on 26/02/20.
 */
public class CardBuilder {

    private String name;
    private SuitEnum suit;

    public CardBuilder setName(String name){
        this.name = name;
        return this;
    }

    public CardBuilder setSuit(SuitEnum suit) {
        this.suit = suit;
        return this;
    }

    public Card build(){
        return new Card(name, suit);
    }
}
