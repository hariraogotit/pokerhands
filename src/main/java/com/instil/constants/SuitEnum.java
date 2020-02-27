package com.instil.constants;

/**
 * Created by Hari Rao on 26/02/20.
 */
public enum SuitEnum {

    H("HEART"),
    D("DIAMOND"),
    S("SPADE"),
    C("CLUB");

    private String suit;

    private SuitEnum(String suit){
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

}
