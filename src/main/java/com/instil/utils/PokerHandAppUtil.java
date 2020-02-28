package com.instil.utils;

import com.google.common.collect.ImmutableMap;
import com.instil.constants.SuitEnum;
import com.instil.models.Card;
import com.instil.models.FiveCard;

import java.util.*;

/**
 * Created by Hari Rao on 27/02/20.
 */
public class PokerHandAppUtil {
    public static final Map<String, Integer> cardValue = ImmutableMap.of("A",14,"K",13,"Q",12,"J",11);

    public static void replaceRoyalsToNumberValue(FiveCard fiveCard){
        replaceToNumberValue(fiveCard.getCardOne());
        replaceToNumberValue(fiveCard.getCardTwo());
        replaceToNumberValue(fiveCard.getCardThree());
        replaceToNumberValue(fiveCard.getCardFour());
        replaceToNumberValue(fiveCard.getCardFive());
    }

    private static void replaceToNumberValue(Card card){
        if(cardValue.get(card.getName())!=null){
            card.setName(String.valueOf(cardValue.get(card.getName())));
        }
    }

    public static void sortFiveCard(FiveCard fiveCard){
        List<Card> cards = new ArrayList<>();
        cards.add(fiveCard.getCardOne());
        cards.add(fiveCard.getCardTwo());
        cards.add(fiveCard.getCardThree());
        cards.add(fiveCard.getCardFour());
        cards.add(fiveCard.getCardFive());
        Collections.sort(cards);
        fiveCard.setCardOne(cards.get(0));
        fiveCard.setCardTwo(cards.get(1));
        fiveCard.setCardThree(cards.get(2));
        fiveCard.setCardFour(cards.get(3));
        fiveCard.setCardFive(cards.get(4));
    }

    public static boolean areTheseMayBeRoyalFlushCards(FiveCard fiveCard){
        return Integer.valueOf(fiveCard.getCardOne().getName()) >= 10;
    }

    public static boolean areTheCardsInSequentialOrder(FiveCard fiveCard){
        Integer cardOne = Integer.valueOf(fiveCard.getCardOne().getName());
        Integer cardTwo = Integer.valueOf(fiveCard.getCardTwo().getName());
        Integer cardThree = Integer.valueOf(fiveCard.getCardThree().getName());
        Integer cardFour = Integer.valueOf(fiveCard.getCardFour().getName());
        Integer cardFive = Integer.valueOf(fiveCard.getCardFive().getName());
        return (cardTwo ==cardOne +1 && cardThree == cardTwo + 1 && cardFour  ==cardThree +1 && cardFive ==cardFour + 1)
                ? true:false;
    }

    public static Map<String, Integer> getNoOfIdenticalCardsCounter(FiveCard fiveCard){
        Map<String, Integer> noOfIdenticalCardsCounter = new HashMap<>();
        if (fiveCard!=null){
            populateNoOFPairsCounter(noOfIdenticalCardsCounter, fiveCard.getCardOne().getName());
            populateNoOFPairsCounter(noOfIdenticalCardsCounter, fiveCard.getCardTwo().getName());
            populateNoOFPairsCounter(noOfIdenticalCardsCounter, fiveCard.getCardThree().getName());
            populateNoOFPairsCounter(noOfIdenticalCardsCounter, fiveCard.getCardFour().getName());
            populateNoOFPairsCounter(noOfIdenticalCardsCounter, fiveCard.getCardFive().getName());
        }
        return noOfIdenticalCardsCounter;
    }

    private static void populateNoOFPairsCounter(Map<String, Integer> noOfIdenticalCardsCounter, String name){
        Integer count = noOfIdenticalCardsCounter.get(name);
        noOfIdenticalCardsCounter.put(name, (count==null)? 1 : count+1);
    }

    public static boolean isTheNumberOfPairFound(Map<String, Integer> noOfIdenticalCardsCounter, int numberOfPair){
        return noOfIdenticalCardsCounter.entrySet()
                .stream()
                .filter(stringIntegerEntry -> stringIntegerEntry.getValue()==numberOfPair)
                .findFirst()
                .isPresent();
    }

    public static boolean isTwoPairFound(Map<String, Integer> noOfIdenticalCardsCounter, int couple, int countOfCouple){
       return noOfIdenticalCardsCounter.entrySet()
                .stream()
                .filter(stringIntegerEntry -> stringIntegerEntry.getValue()==couple)
                .count() == countOfCouple ? true : false;
    }

    public static Map<String, Integer> getNoOfIdenticalSuitsCounter(FiveCard fiveCard){
        Map<String, Integer> noOfIdenticalSuitsCounter = new HashMap<>();
        if (fiveCard!=null){
            populateNoOFPairsCounter(noOfIdenticalSuitsCounter, fiveCard.getCardOne().getSuit().name());
            populateNoOFPairsCounter(noOfIdenticalSuitsCounter, fiveCard.getCardTwo().getSuit().name());
            populateNoOFPairsCounter(noOfIdenticalSuitsCounter, fiveCard.getCardThree().getSuit().name());
            populateNoOFPairsCounter(noOfIdenticalSuitsCounter, fiveCard.getCardFour().getSuit().name());
            populateNoOFPairsCounter(noOfIdenticalSuitsCounter, fiveCard.getCardFive().getSuit().name());
        }
        return noOfIdenticalSuitsCounter;
    }

    public static boolean isAllSameSuit(Map<String, Integer> noOfIdenticalSuitsCounter){
        return  isTheNumberOfPairFound(noOfIdenticalSuitsCounter, 5);
    }


    public static Card convertToCard(String rawCard) {
        if(rawCard.length() > 2){
            return new CardBuilder()
                    .setName(String.valueOf(rawCard.charAt(0)) + String.valueOf(rawCard.charAt(1)))
                    .setSuit(SuitEnum.valueOf(String.valueOf(rawCard.charAt(2))))
                    .build();
        }
        return new CardBuilder()
                .setName(String.valueOf(rawCard.charAt(0)))
                .setSuit(SuitEnum.valueOf(String.valueOf(rawCard.charAt(1))))
                .build();

    }

}
