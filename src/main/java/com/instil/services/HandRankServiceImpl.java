package com.instil.services;

import com.instil.models.FiveCard;

import java.util.Map;

import static com.instil.utils.PokerHandAppUtil.*;

/**
 * Created by Hari Rao on 27/02/20.
 */
public class HandRankServiceImpl implements HandRankService {
    @Override
    public boolean isRoyalFlush(FiveCard fiveCard) {
        boolean isRoyalFlush = false;
        Map<String, Integer> noOfIdenticalSuitsCounter = getNoOfIdenticalSuitsCounter(fiveCard);
        if(isAllSameSuit(noOfIdenticalSuitsCounter)){
            replaceRoyalsToNumberValue(fiveCard);
            sortFiveCard(fiveCard);
            if(areTheseMayBeRoyalFlushCards(fiveCard)){
                isRoyalFlush = areTheCardsInSequentialOrder(fiveCard);
            }
        }
        return isRoyalFlush;
    }

    @Override
    public boolean isStraightFlush(FiveCard fiveCard) {
        boolean isStraightFlush = false;
        Map<String, Integer> noOfIdenticalSuitsCounter = getNoOfIdenticalSuitsCounter(fiveCard);
        if(isAllSameSuit(noOfIdenticalSuitsCounter)){
            replaceRoyalsToNumberValue(fiveCard);
            sortFiveCard(fiveCard);
            if(!areTheseMayBeRoyalFlushCards(fiveCard)) {
                isStraightFlush = areTheCardsInSequentialOrder(fiveCard);
            }
        }
        return isStraightFlush;
    }

    @Override
    public boolean isFourOFAKind(FiveCard fiveCard) {
        boolean fourOfAKind = false;
        Map<String, Integer>  noOfIdenticalCardsCounter = getNoOfIdenticalCardsCounter(fiveCard);
        fourOfAKind = isTheNumberOfPairFound(noOfIdenticalCardsCounter, 4);
        return fourOfAKind;
    }

    @Override
    public boolean isFullHouse(FiveCard fiveCard) {
        return isThreeOfAKind(fiveCard) && isOnePair(fiveCard);
    }

    @Override
    public boolean isFlush(FiveCard fiveCard) {
        Map<String, Integer> noOfIdenticalSuitsCounter = getNoOfIdenticalSuitsCounter(fiveCard);
        return isAllSameSuit(noOfIdenticalSuitsCounter);
    }

    @Override
    public boolean isStraight(FiveCard fiveCard) {
        boolean isStraight = false;
        replaceRoyalsToNumberValue(fiveCard);
        sortFiveCard(fiveCard);
        isStraight = areTheCardsInSequentialOrder(fiveCard);
        return isStraight;
    }

    @Override
    public boolean isThreeOfAKind(FiveCard fiveCard) {
        boolean threeOfAKind = false;
        Map<String, Integer>  noOfIdenticalCardsCounter = getNoOfIdenticalCardsCounter(fiveCard);
        threeOfAKind = isTheNumberOfPairFound(noOfIdenticalCardsCounter, 3);
        return threeOfAKind;
    }

    @Override
    public boolean isTwoPairs(FiveCard fiveCard) {
        boolean twoPair = false;
        Map<String, Integer>  noOfIdenticalCardsCounter = getNoOfIdenticalCardsCounter(fiveCard);
        twoPair = isTwoPairFound(noOfIdenticalCardsCounter, 2, 2);
        return twoPair;
    }

    @Override
    public boolean isOnePair(FiveCard fiveCard) {
        boolean onePair = false;
        Map<String, Integer>  noOfIdenticalCardsCounter = getNoOfIdenticalCardsCounter(fiveCard);
        onePair = isTheNumberOfPairFound(noOfIdenticalCardsCounter, 2);
        return onePair;
    }


    @Override
    public boolean isHighCard(FiveCard fiveCard) {
        boolean isNotHighCard = false;
        replaceRoyalsToNumberValue(fiveCard);
        sortFiveCard(fiveCard);
        isNotHighCard = areTheCardsInSequentialOrder(fiveCard);
        return !isNotHighCard;
    }
}
