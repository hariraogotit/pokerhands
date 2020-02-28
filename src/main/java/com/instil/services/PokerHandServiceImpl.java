package com.instil.services;

import com.instil.models.FiveCard;
import com.instil.validators.FiveCardsValidator;
import com.instil.validators.FiveCardsValidatorImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.FileVisitOption;
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
    public Map<FiveCard, String> processPokerHand(String fileName) {
        FiveCardsValidator fiveCardsValidator = new FiveCardsValidatorImpl();
        List<String> rawFiveCards = readFiveCards(fileName);
        List<FiveCard> fiveCards = validate(fiveCardsValidator, rawFiveCards);
        return determineHandRank(fiveCards);
    }

    private Map<FiveCard, String> determineHandRank(List<FiveCard> fiveCards){
        Map<FiveCard, String> mappedFiveCardWithHandRank = new HashedMap<>();
        HandRankService handRankService = new HandRankServiceImpl();
        for(FiveCard fiveCard : fiveCards){
            if(mappedFiveCardWithHandRank.get(fiveCard)==null){
                if(handRankService.isFullHouse(fiveCard)){
                    mappedFiveCardWithHandRank.put(fiveCard, "Full House");
                }
            }
            if(mappedFiveCardWithHandRank.get(fiveCard)==null){
                if(handRankService.isFourOFAKind(fiveCard)){
                    mappedFiveCardWithHandRank.put(fiveCard, "Four Of A Kind");
                }
            }
            if(mappedFiveCardWithHandRank.get(fiveCard)==null){
                if(handRankService.isTwoPairs(fiveCard)){
                    mappedFiveCardWithHandRank.put(fiveCard, "Two Pair");
                }
            }
            if(mappedFiveCardWithHandRank.get(fiveCard)==null){
                if(handRankService.isThreeOfAKind(fiveCard)){
                    mappedFiveCardWithHandRank.put(fiveCard, "Three Of A Kind");
                }
            }
            if(mappedFiveCardWithHandRank.get(fiveCard)==null){
                if(handRankService.isOnePair(fiveCard)){
                    mappedFiveCardWithHandRank.put(fiveCard, "One Pair");
                }
            }
            if(mappedFiveCardWithHandRank.get(fiveCard)==null){
                if(handRankService.isStraightFlush(fiveCard)){
                    mappedFiveCardWithHandRank.put(fiveCard, "Straight Flush");
                }
            }
            if(mappedFiveCardWithHandRank.get(fiveCard)==null){
                if(handRankService.isRoyalFlush(fiveCard)){
                    mappedFiveCardWithHandRank.put(fiveCard, "Royal Flush");
                }
            }
            if(mappedFiveCardWithHandRank.get(fiveCard)==null){
                if(handRankService.isFlush(fiveCard)){
                    mappedFiveCardWithHandRank.put(fiveCard, "Flush");
                }
            }
            if(mappedFiveCardWithHandRank.get(fiveCard)==null){
                if(handRankService.isStraight(fiveCard)){
                    mappedFiveCardWithHandRank.put(fiveCard, "Straight");
                }
            }
            if(mappedFiveCardWithHandRank.get(fiveCard)==null){
                if(handRankService.isHighCard(fiveCard)){
                    mappedFiveCardWithHandRank.put(fiveCard, "High Card");
                }
            }
        }
        return mappedFiveCardWithHandRank;
    }

    private List<FiveCard> validate(FiveCardsValidator fiveCardsValidator, List<String> rawFiveCards) {
        List<FiveCard> fiveCards = Collections.emptyList();
        if(CollectionUtils.isNotEmpty(rawFiveCards)){
            fiveCards = fiveCardsValidator.validate(rawFiveCards);
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
