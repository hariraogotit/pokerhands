package com.instil.validators;

import com.instil.constants.SuitEnum;
import com.instil.models.Card;
import com.instil.models.FiveCard;
import com.instil.utils.CardBuilder;
import com.instil.utils.FiveCardBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Hari Rao on 26/02/20.
 */
public class FiveCardsValidatorImpl implements FiveCardsValidator {
    @Override
    public List<FiveCard> validate(List<String> rawFiveCards) {
        return validateIfTheyAreInPairs(rawFiveCards);
    }

    public List<FiveCard> validateIfTheyAreInPairs(List<String> rawFiveCards){
        Iterator<String> iter = rawFiveCards.iterator();
        while(iter.hasNext()){
            String[] fiveCardPairs = iter.next().split(" ");
            for(String tuple: fiveCardPairs){
                if(tuple.length() !=2){
                    iter.remove();
                }
            }
        }
        return convertToFiveCard(rawFiveCards);
    }

    private List<FiveCard> convertToFiveCard(List<String> rawFiveCards) {
        List<FiveCard> fiveCards = new ArrayList<>();
        for(String rawFiveCard : rawFiveCards){
            String[] rawFiveCardPairs = rawFiveCard.split(" ");
            FiveCardBuilder fiveCardBuilder = new FiveCardBuilder();
            for(String rawCard : rawFiveCardPairs){
                fiveCardBuilder.setCard(convertToCard(rawCard));
            }
            fiveCards.add(fiveCardBuilder.build());
        }
        return fiveCards;
    }

    private Card convertToCard(String rawCard) {
        return new CardBuilder()
                            .setName(String.valueOf(rawCard.charAt(0)))
                            .setSuit(SuitEnum.valueOf(String.valueOf(rawCard.charAt(1))))
                            .build();

    }
}
