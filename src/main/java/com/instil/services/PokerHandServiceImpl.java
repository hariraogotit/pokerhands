package com.instil.services;

import com.instil.models.FiveCard;
import com.instil.validators.FiveCardsValidator;
import com.instil.validators.FiveCardsValidatorImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Hari Rao on 26/02/20.
 */
public class PokerHandServiceImpl implements PokerHandService {
    private static Logger logger = Logger.getLogger(PokerHandServiceImpl.class);

    @Override
    public void processPokerHand(String fileName) {
        FiveCardsValidator fiveCardsValidator = new FiveCardsValidatorImpl();
        List<String> rawFiveCards = readFiveCards(fileName);
        List<FiveCard> fiveCards = validate(fiveCardsValidator, rawFiveCards);
        System.out.printf(fiveCards.toString());
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
