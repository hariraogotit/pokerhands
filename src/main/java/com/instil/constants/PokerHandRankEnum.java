package com.instil.constants;

/**
 * Created by Hari Rao on 28/02/20.
 */
public enum PokerHandRankEnum {

    HIGH_CARD("High Card"),
    ONE_PAIR("One Pair"),
    TWO_PAIRS("Two Pairs"),
    THREE_OF_A_KIND("Three Of A Kind"),
    STRAIGHT("Straight"),
    FLUSH("Flush"),
    FULL_HOUSE("Full House"),
    FOUR_OF_A_KIND("Four Of A Kind"),
    STRAIGHT_FLUSH("Straight Flush"),
    ROYAL_FLUSH("Royal Flush");

    private String value;

    PokerHandRankEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
