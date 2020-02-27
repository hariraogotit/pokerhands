package com.instil.models;

/**
 * Created by Hari Rao on 26/02/20.
 */
public class FiveCard {

    private Card cardOne;
    private Card cardTwo;
    private Card cardThree;
    private Card cardFour;
    private Card cardFive;

    public FiveCard(Card cardOne, Card cardTwo, Card cardThree, Card cardFour, Card cardFive) {
        this.cardOne = cardOne;
        this.cardTwo = cardTwo;
        this.cardThree = cardThree;
        this.cardFour = cardFour;
        this.cardFive = cardFive;
    }

    public Card getCardOne() {
        return cardOne;
    }

    public void setCardOne(Card cardOne) {
        this.cardOne = cardOne;
    }

    public Card getCardTwo() {
        return cardTwo;
    }

    public void setCardTwo(Card cardTwo) {
        this.cardTwo = cardTwo;
    }

    public Card getCardThree() {
        return cardThree;
    }

    public void setCardThree(Card cardThree) {
        this.cardThree = cardThree;
    }

    public Card getCardFour() {
        return cardFour;
    }

    public void setCardFour(Card cardFour) {
        this.cardFour = cardFour;
    }

    public Card getCardFive() {
        return cardFive;
    }

    public void setCardFive(Card cardFive) {
        this.cardFive = cardFive;
    }

}
