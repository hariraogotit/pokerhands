package com.instil.utils;

import com.google.common.collect.ImmutableMap;
import com.instil.models.Card;
import com.instil.models.FiveCard;
import org.junit.Test;

import java.util.Map;

import static com.instil.utils.PokerHandAppUtil.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Hari Rao on 28/02/20.
 */
public class PokerHandAppUtilTest {
    @Test
    public void testReplaceRoyalsToNumberValue_ForTrue() throws Exception {
        Card cardOne = convertToCard("KH");
        Card cardTwo = convertToCard("JH");
        Card cardThree = convertToCard("QH");
        Card cardFour = convertToCard("KS");
        Card cardFive = convertToCard("KC");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        replaceRoyalsToNumberValue(fiveCard);
        assertTrue(Integer.valueOf(cardOne.getName()) > 10);
        assertTrue(Integer.valueOf(cardTwo.getName()) > 10);
        assertTrue(Integer.valueOf(cardThree.getName()) > 10);
        assertTrue(Integer.valueOf(cardFour.getName()) > 10);
        assertTrue(Integer.valueOf(cardFive.getName()) > 10);
    }

    @Test
    public void testReplaceRoyalsToNumberValue_ForFalse() throws Exception {
        Card cardOne = convertToCard("10H");
        Card cardTwo = convertToCard("3H");
        Card cardThree = convertToCard("4H");
        Card cardFour = convertToCard("6S");
        Card cardFive = convertToCard("9C");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        replaceRoyalsToNumberValue(fiveCard);
        assertFalse(Integer.valueOf(cardOne.getName()) > 10);
        assertFalse(Integer.valueOf(cardTwo.getName()) > 10);
        assertFalse(Integer.valueOf(cardThree.getName()) > 10);
        assertFalse(Integer.valueOf(cardFour.getName()) > 10);
        assertFalse(Integer.valueOf(cardFive.getName()) > 10);
    }

    @Test
    public void testSortFiveCard() throws Exception {
        Card cardOne = convertToCard("10H");
        Card cardTwo = convertToCard("3H");
        Card cardThree = convertToCard("4H");
        Card cardFour = convertToCard("6S");
        Card cardFive = convertToCard("9C");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        sortFiveCard(fiveCard);
        assertTrue(Integer.valueOf(fiveCard.getCardOne().getName()) <= Integer.valueOf(fiveCard.getCardTwo().getName()));
        assertTrue(Integer.valueOf(fiveCard.getCardTwo().getName()) <= Integer.valueOf(fiveCard.getCardThree().getName()));
        assertTrue(Integer.valueOf(fiveCard.getCardThree().getName()) <= Integer.valueOf(fiveCard.getCardFour().getName()));
        assertTrue(Integer.valueOf(fiveCard.getCardFour().getName()) <= Integer.valueOf(fiveCard.getCardFive().getName()));
    }

    @Test
    public void testAreTheseMayBeRoyalFlushCards_ForTrue() throws Exception {
        Card cardOne = convertToCard("KH");
        Card cardTwo = convertToCard("JH");
        Card cardThree = convertToCard("QH");
        Card cardFour = convertToCard("KS");
        Card cardFive = convertToCard("KC");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        replaceRoyalsToNumberValue(fiveCard);
        assertTrue(areTheseMayBeRoyalFlushCards(fiveCard));
    }

    @Test
    public void testAreTheseMayBeRoyalFlushCards_ForFalse() throws Exception {
        Card cardOne = convertToCard("9H");
        Card cardTwo = convertToCard("JH");
        Card cardThree = convertToCard("QH");
        Card cardFour = convertToCard("KS");
        Card cardFive = convertToCard("KC");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        replaceRoyalsToNumberValue(fiveCard);
        assertFalse(areTheseMayBeRoyalFlushCards(fiveCard));
    }

    @Test
    public void testAreTheCardsInSequentialOrder_ForTrue() throws Exception {
        Card cardOne = convertToCard("6H");
        Card cardTwo = convertToCard("7H");
        Card cardThree = convertToCard("8H");
        Card cardFour = convertToCard("9S");
        Card cardFive = convertToCard("10C");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        assertTrue(areTheCardsInSequentialOrder(fiveCard));
    }

    @Test
    public void testAreTheCardsInSequentialOrder_ForFalse() throws Exception {
        Card cardOne = convertToCard("2H");
        Card cardTwo = convertToCard("7H");
        Card cardThree = convertToCard("8H");
        Card cardFour = convertToCard("9S");
        Card cardFive = convertToCard("10C");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        assertFalse(areTheCardsInSequentialOrder(fiveCard));
    }

    @Test
    public void testGetNoOfIdenticalCardsCounter_ReturnTwo() throws Exception {
        Card cardOne = convertToCard("2H");
        Card cardTwo = convertToCard("2H");
        Card cardThree = convertToCard("8H");
        Card cardFour = convertToCard("9S");
        Card cardFive = convertToCard("10C");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        assertTrue(getNoOfIdenticalCardsCounter(fiveCard).get(cardOne.getName())==2);
    }

    @Test
    public void testGetNoOfIdenticalCardsCounter_ReturnThree() throws Exception {
        Card cardOne = convertToCard("2H");
        Card cardTwo = convertToCard("2H");
        Card cardThree = convertToCard("2H");
        Card cardFour = convertToCard("9S");
        Card cardFive = convertToCard("10C");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        assertTrue(getNoOfIdenticalCardsCounter(fiveCard).get(cardOne.getName())==3);
    }

    @Test
    public void testGetNoOfIdenticalCardsCounter_ReturnFour() throws Exception {
        Card cardOne = convertToCard("2H");
        Card cardTwo = convertToCard("2H");
        Card cardThree = convertToCard("2H");
        Card cardFour = convertToCard("2S");
        Card cardFive = convertToCard("10C");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        assertTrue(getNoOfIdenticalCardsCounter(fiveCard).get(cardOne.getName())==4);
    }

    @Test
    public void testGetNoOfIdenticalCardsCounter_ReturnFive() throws Exception {
        Card cardOne = convertToCard("2H");
        Card cardTwo = convertToCard("2H");
        Card cardThree = convertToCard("2H");
        Card cardFour = convertToCard("2S");
        Card cardFive = convertToCard("2C");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        assertTrue(getNoOfIdenticalCardsCounter(fiveCard).get(cardOne.getName())==5);
    }

    @Test
    public void testIsTheNumberOfPairFound_ForFourOfAKind() throws Exception {
        Map<String, Integer> noOfIdenticalCardsCounter = ImmutableMap.of("3", 4, "2",1);
        assertTrue(isTheNumberOfPairFound(noOfIdenticalCardsCounter, 4));
    }

    @Test
    public void testIsTheNumberOfPairFound_ForAPair() throws Exception {
        Map<String, Integer> noOfIdenticalCardsCounter = ImmutableMap.of("3", 2, "2",1, "10", 1, "9",1);
        assertTrue(isTheNumberOfPairFound(noOfIdenticalCardsCounter, 2));

    }

    @Test
    public void testIsTheNumberOfPairFound_ForThreeOfAKind() throws Exception {
        Map<String, Integer> noOfIdenticalCardsCounter = ImmutableMap.of("3", 3, "2",1, "10", 1);
        assertTrue(isTheNumberOfPairFound(noOfIdenticalCardsCounter, 3));
    }

    @Test
    public void testIsTwoPairFound_ForTrue() throws Exception {
        Map<String, Integer> noOfIdenticalCardsCounter = ImmutableMap.of("3", 2, "2",2, "10", 1);
        assertTrue(isTwoPairFound(noOfIdenticalCardsCounter, 2, 2));
    }

    @Test
    public void testIsTwoPairFound_ForFalse() throws Exception {
        Map<String, Integer> noOfIdenticalCardsCounter = ImmutableMap.of("3", 1, "2",2, "10", 1,"7", 1);
        assertFalse(isTwoPairFound(noOfIdenticalCardsCounter, 2, 2));
    }

    @Test
    public void testGetNoOfIdenticalSuitsCounter_ForTwo() throws Exception {
        Card cardOne = convertToCard("2H");
        Card cardTwo = convertToCard("2H");
        Card cardThree = convertToCard("8D");
        Card cardFour = convertToCard("9S");
        Card cardFive = convertToCard("10C");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        assertTrue(getNoOfIdenticalSuitsCounter(fiveCard).get("H")==2);
    }

    @Test
    public void testGetNoOfIdenticalSuitsCounter_ForThree() throws Exception {
        Card cardOne = convertToCard("2H");
        Card cardTwo = convertToCard("2H");
        Card cardThree = convertToCard("8H");
        Card cardFour = convertToCard("9S");
        Card cardFive = convertToCard("10C");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        assertTrue(getNoOfIdenticalSuitsCounter(fiveCard).get("H")==3);
    }

    @Test
    public void testGetNoOfIdenticalSuitsCounter_ForFour() throws Exception {
        Card cardOne = convertToCard("2H");
        Card cardTwo = convertToCard("2H");
        Card cardThree = convertToCard("8H");
        Card cardFour = convertToCard("9H");
        Card cardFive = convertToCard("10C");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        assertTrue(getNoOfIdenticalSuitsCounter(fiveCard).get("H")==4);
    }

    @Test
    public void testGetNoOfIdenticalSuitsCounter_ForFive() throws Exception {
        Card cardOne = convertToCard("2H");
        Card cardTwo = convertToCard("2H");
        Card cardThree = convertToCard("8H");
        Card cardFour = convertToCard("9H");
        Card cardFive = convertToCard("10H");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        assertTrue(getNoOfIdenticalSuitsCounter(fiveCard).get("H")==5);
    }


}