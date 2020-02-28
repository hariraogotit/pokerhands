package com.instil.services;

import com.instil.constants.PokerHandRankEnum;
import com.instil.models.FiveCard;
import com.instil.validators.FiveCardsValidator;
import com.instil.validators.FiveCardsValidatorImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Hari Rao on 26/02/20.
 */
public class PokerHandServiceImpl implements PokerHandService {
    private static Logger logger = Logger.getLogger(PokerHandServiceImpl.class);

    @Override
    public Map<FiveCard, PokerHandRankEnum> processPokerHand(String fileName) {
        FiveCardsValidator fiveCardsValidator = new FiveCardsValidatorImpl();
        List<String> rawFiveCards = readFiveCards(fileName);
        List<FiveCard> fiveCards = validate(fiveCardsValidator, rawFiveCards);
        return determineHandRank(fiveCards);
    }

    private Map<FiveCard, PokerHandRankEnum> determineHandRank(List<FiveCard> fiveCards){
        Map<FiveCard, PokerHandRankEnum> mappedFiveCardWithHandRank = new HashedMap<>();
        HandRankService handRankService = new HandRankServiceImpl();
        for(FiveCard fiveCard : fiveCards){
            processFiveCards(mappedFiveCardWithHandRank, handRankService, fiveCard);
        }
        return mappedFiveCardWithHandRank;
    }

    private void processFiveCards(Map<FiveCard, PokerHandRankEnum> mappedFiveCardWithHandRank, HandRankService handRankService, FiveCard fiveCard) {
        if(mappedFiveCardWithHandRank.get(fiveCard)==null){
            if(handRankService.isFullHouse(fiveCard)){
                mappedFiveCardWithHandRank.put(fiveCard, PokerHandRankEnum.FULL_HOUSE);
            }
        }
        if(mappedFiveCardWithHandRank.get(fiveCard)==null){
            if(handRankService.isFourOFAKind(fiveCard)){
                mappedFiveCardWithHandRank.put(fiveCard, PokerHandRankEnum.FOUR_OF_A_KIND);
            }
        }
        if(mappedFiveCardWithHandRank.get(fiveCard)==null){
            if(handRankService.isTwoPairs(fiveCard)){
                mappedFiveCardWithHandRank.put(fiveCard, PokerHandRankEnum.TWO_PAIRS);
            }
        }
        if(mappedFiveCardWithHandRank.get(fiveCard)==null){
            if(handRankService.isThreeOfAKind(fiveCard)){
                mappedFiveCardWithHandRank.put(fiveCard, PokerHandRankEnum.THREE_OF_A_KIND);
            }
        }
        if(mappedFiveCardWithHandRank.get(fiveCard)==null){
            if(handRankService.isOnePair(fiveCard)){
                mappedFiveCardWithHandRank.put(fiveCard, PokerHandRankEnum.ONE_PAIR);
            }
        }
        processMoreFiveCards(mappedFiveCardWithHandRank, handRankService, fiveCard);
    }

    private void processMoreFiveCards(Map<FiveCard, PokerHandRankEnum> mappedFiveCardWithHandRank, HandRankService handRankService, FiveCard fiveCard) {
        if(mappedFiveCardWithHandRank.get(fiveCard)==null){
            if(handRankService.isStraightFlush(fiveCard)){
                mappedFiveCardWithHandRank.put(fiveCard, PokerHandRankEnum.STRAIGHT_FLUSH);
            }
        }
        if(mappedFiveCardWithHandRank.get(fiveCard)==null){
            if(handRankService.isRoyalFlush(fiveCard)){
                mappedFiveCardWithHandRank.put(fiveCard, PokerHandRankEnum.ROYAL_FLUSH);
            }
        }
        if(mappedFiveCardWithHandRank.get(fiveCard)==null){
            if(handRankService.isFlush(fiveCard)){
                mappedFiveCardWithHandRank.put(fiveCard, PokerHandRankEnum.FLUSH);
            }
        }
        if(mappedFiveCardWithHandRank.get(fiveCard)==null){
            if(handRankService.isStraight(fiveCard)){
                mappedFiveCardWithHandRank.put(fiveCard, PokerHandRankEnum.STRAIGHT);
            }
        }
        if(mappedFiveCardWithHandRank.get(fiveCard)==null){
            if(handRankService.isHighCard(fiveCard)){
                mappedFiveCardWithHandRank.put(fiveCard, PokerHandRankEnum.HIGH_CARD);
            }
        }
    }

    private List<FiveCard> validate(FiveCardsValidator fiveCardsValidator, List<String> rawFiveCards) {
        List<FiveCard> fiveCards = Collections.emptyList();
        if(CollectionUtils.isNotEmpty(rawFiveCards)){
            fiveCards = fiveCardsValidator.validateIfTheyAreInPairs(rawFiveCards);
        }
        return fiveCards;
    }

    private List<String> readFiveCards(String fileName) {
        try(Stream<String> stream = Files.lines(Paths.get(fileName))){
            return stream.collect(Collectors.toList());
        } catch (IOException ex) {
            logger.error("Error while reading the input-five-cards.txt file", ex);
        }
        return Collections.emptyList();
    }
}
