package com.instil.models;

import com.instil.constants.SuitEnum;

/**
 * Created by Hari Rao on 26/02/20.
 */
public class Card implements Comparable<Card>{

    private String name;
    private SuitEnum suit;

    public Card(String name, SuitEnum suit) {
        this.name = name;
        this.suit = suit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SuitEnum getSuit() {
        return suit;
    }

    public void setSuit(SuitEnum suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return name + suit;
    }

    @Override
    public int compareTo(Card card) {
        return Integer.valueOf(this.name) - Integer.valueOf(card.getName()) ;
    }
}
