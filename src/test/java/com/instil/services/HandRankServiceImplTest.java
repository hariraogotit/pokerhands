package com.instil.services;

import com.instil.models.Card;
import com.instil.models.FiveCard;
import org.junit.Test;

import static com.instil.utils.PokerHandAppUtil.buildFiveCard;
import static com.instil.utils.PokerHandAppUtil.convertToCard;
import static com.instil.utils.PokerHandAppUtil.replaceRoyalsToNumberValue;
import static org.junit.Assert.*;

/**
 * Created by Hari Rao on 28/02/20.
 */
public class HandRankServiceImplTest {
    @Test
    public void testIsRoyalFlush_ForTrue() throws Exception {
        HandRankService handRankService = new HandRankServiceImpl();
        Card cardOne = convertToCard("AH");
        Card cardTwo = convertToCard("QH");
        Card cardThree = convertToCard("KH");
        Card cardFour = convertToCard("JH");
        Card cardFive = convertToCard("10H");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        replaceRoyalsToNumberValue(fiveCard);
        assertTrue(handRankService.isRoyalFlush(fiveCard));
    }

    @Test
    public void testIsRoyalFlush_ForFalse() throws Exception {
        HandRankService handRankService = new HandRankServiceImpl();
        Card cardOne = convertToCard("9H");
        Card cardTwo = convertToCard("QH");
        Card cardThree = convertToCard("KH");
        Card cardFour = convertToCard("JH");
        Card cardFive = convertToCard("10H");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        replaceRoyalsToNumberValue(fiveCard);
        assertFalse(handRankService.isRoyalFlush(fiveCard));
    }

    @Test
    public void testIsStraightFlush_ForTrue() throws Exception {
        HandRankService handRankService = new HandRankServiceImpl();
        Card cardOne = convertToCard("6H");
        Card cardTwo = convertToCard("7H");
        Card cardThree = convertToCard("8H");
        Card cardFour = convertToCard("10H");
        Card cardFive = convertToCard("9H");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        replaceRoyalsToNumberValue(fiveCard);
        assertTrue(handRankService.isStraightFlush(fiveCard));
    }

    @Test
    public void testIsStraightFlush_ForFalse() throws Exception {
        HandRankService handRankService = new HandRankServiceImpl();
        Card cardOne = convertToCard("7H");
        Card cardTwo = convertToCard("7H");
        Card cardThree = convertToCard("8H");
        Card cardFour = convertToCard("10H");
        Card cardFive = convertToCard("9H");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        replaceRoyalsToNumberValue(fiveCard);
        assertFalse(handRankService.isStraightFlush(fiveCard));
    }

    @Test
    public void testIsFourOFAKind_ForTrue() throws Exception {
        HandRankService handRankService = new HandRankServiceImpl();
        Card cardOne = convertToCard("AH");
        Card cardTwo = convertToCard("AD");
        Card cardThree = convertToCard("AS");
        Card cardFour = convertToCard("AC");
        Card cardFive = convertToCard("9H");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        replaceRoyalsToNumberValue(fiveCard);
        assertTrue(handRankService.isFourOFAKind(fiveCard));
    }

    @Test
    public void testIsFourOFAKind_ForFalse() throws Exception {
        HandRankService handRankService = new HandRankServiceImpl();
        Card cardOne = convertToCard("AH");
        Card cardTwo = convertToCard("AD");
        Card cardThree = convertToCard("AS");
        Card cardFour = convertToCard("AC");
        Card cardFive = convertToCard("AH");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        replaceRoyalsToNumberValue(fiveCard);
        assertFalse(handRankService.isFourOFAKind(fiveCard));
    }

    @Test
    public void testIsFullHouse_ForTrue() throws Exception {
        HandRankService handRankService = new HandRankServiceImpl();
        Card cardOne = convertToCard("8H");
        Card cardTwo = convertToCard("8D");
        Card cardThree = convertToCard("8S");
        Card cardFour = convertToCard("AC");
        Card cardFive = convertToCard("AH");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        replaceRoyalsToNumberValue(fiveCard);
        assertTrue(handRankService.isFullHouse(fiveCard));
    }

    @Test
    public void testIsFullHouse_ForFalse() throws Exception {
        HandRankService handRankService = new HandRankServiceImpl();
        Card cardOne = convertToCard("AH");
        Card cardTwo = convertToCard("AD");
        Card cardThree = convertToCard("AS");
        Card cardFour = convertToCard("AC");
        Card cardFive = convertToCard("AH");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        replaceRoyalsToNumberValue(fiveCard);
        assertFalse(handRankService.isFullHouse(fiveCard));
    }

    @Test
    public void testIsFlush_ForTrue() throws Exception {
        HandRankService handRankService = new HandRankServiceImpl();
        Card cardOne = convertToCard("10C");
        Card cardTwo = convertToCard("9H");
        Card cardThree = convertToCard("8D");
        Card cardFour = convertToCard("7S");
        Card cardFive = convertToCard("6C");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        replaceRoyalsToNumberValue(fiveCard);
        assertTrue(handRankService.isStraight(fiveCard));

    }

    @Test
    public void testIsStraight_ForFalse() throws Exception {
        HandRankService handRankService = new HandRankServiceImpl();
        Card cardOne = convertToCard("AH");
        Card cardTwo = convertToCard("AD");
        Card cardThree = convertToCard("AS");
        Card cardFour = convertToCard("AC");
        Card cardFive = convertToCard("AH");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        replaceRoyalsToNumberValue(fiveCard);
        assertFalse(handRankService.isStraight(fiveCard));
    }

    @Test
    public void testIsThreeOfAKind_ForTrue() throws Exception {
        HandRankService handRankService = new HandRankServiceImpl();
        Card cardOne = convertToCard("AH");
        Card cardTwo = convertToCard("AD");
        Card cardThree = convertToCard("AS");
        Card cardFour = convertToCard("6C");
        Card cardFive = convertToCard("7H");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        replaceRoyalsToNumberValue(fiveCard);
        assertTrue(handRankService.isThreeOfAKind(fiveCard));
    }

    @Test
    public void testIsThreeOfAKind_ForFalse() throws Exception {
        HandRankService handRankService = new HandRankServiceImpl();
        Card cardOne = convertToCard("AH");
        Card cardTwo = convertToCard("AD");
        Card cardThree = convertToCard("AS");
        Card cardFour = convertToCard("AC");
        Card cardFive = convertToCard("AH");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        replaceRoyalsToNumberValue(fiveCard);
        assertFalse(handRankService.isThreeOfAKind(fiveCard));
    }

    @Test
    public void testIsTwoPairs_ForTrue() throws Exception {
        HandRankService handRankService = new HandRankServiceImpl();
        Card cardOne = convertToCard("AH");
        Card cardTwo = convertToCard("AD");
        Card cardThree = convertToCard("5S");
        Card cardFour = convertToCard("5C");
        Card cardFive = convertToCard("3H");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        replaceRoyalsToNumberValue(fiveCard);
        assertTrue(handRankService.isTwoPairs(fiveCard));
    }

    @Test
    public void testIsTwoPairs_ForFalse() throws Exception {
        HandRankService handRankService = new HandRankServiceImpl();
        Card cardOne = convertToCard("AH");
        Card cardTwo = convertToCard("4D");
        Card cardThree = convertToCard("5S");
        Card cardFour = convertToCard("5C");
        Card cardFive = convertToCard("3H");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        replaceRoyalsToNumberValue(fiveCard);
        assertFalse(handRankService.isTwoPairs(fiveCard));
    }

    @Test
    public void testIsOnePair_ForTrue() throws Exception {
        HandRankService handRankService = new HandRankServiceImpl();
        Card cardOne = convertToCard("AH");
        Card cardTwo = convertToCard("4D");
        Card cardThree = convertToCard("5S");
        Card cardFour = convertToCard("5C");
        Card cardFive = convertToCard("3H");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        replaceRoyalsToNumberValue(fiveCard);
        assertTrue(handRankService.isOnePair(fiveCard));
    }

    @Test
    public void testIsOnePair_ForFalse() throws Exception {
        HandRankService handRankService = new HandRankServiceImpl();
        Card cardOne = convertToCard("AH");
        Card cardTwo = convertToCard("5D");
        Card cardThree = convertToCard("5S");
        Card cardFour = convertToCard("5C");
        Card cardFive = convertToCard("3H");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        replaceRoyalsToNumberValue(fiveCard);
        assertFalse(handRankService.isOnePair(fiveCard));
    }

    @Test
    public void testIsHighCard_ForTrue() throws Exception {
        HandRankService handRankService = new HandRankServiceImpl();
        Card cardOne = convertToCard("AH");
        Card cardTwo = convertToCard("2D");
        Card cardThree = convertToCard("4S");
        Card cardFour = convertToCard("7C");
        Card cardFive = convertToCard("9H");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        replaceRoyalsToNumberValue(fiveCard);
        assertTrue(handRankService.isHighCard(fiveCard));
    }

    @Test
    public void testIsHighCard_ForFalse() throws Exception {
        HandRankService handRankService = new HandRankServiceImpl();
        Card cardOne = convertToCard("2H");
        Card cardTwo = convertToCard("3D");
        Card cardThree = convertToCard("4S");
        Card cardFour = convertToCard("6C");
        Card cardFive = convertToCard("5H");
        FiveCard fiveCard = buildFiveCard(cardOne, cardTwo, cardThree, cardFour, cardFive);
        replaceRoyalsToNumberValue(fiveCard);
        assertFalse(handRankService.isHighCard(fiveCard));
    }

}