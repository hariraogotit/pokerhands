package com.instil.validators;

import com.google.common.collect.ImmutableList;
import com.instil.models.FiveCard;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Hari Rao on 28/02/20.
 */
public class FiveCardsValidatorImplTest {
    @Test
    public void testValidateIfTheyAreInPairs() throws Exception {
        FiveCardsValidator fiveCardsValidator = new FiveCardsValidatorImpl();
        List<String> rawFiveCards = new ArrayList<String>(){
            {
            add("10C 9H 8D 7S 6C");
            add("1C 2");
            }
        };
        List<FiveCard> validatedFiveCards = fiveCardsValidator.validateIfTheyAreInPairs(rawFiveCards);
        assertTrue(validatedFiveCards.size()==1);

    }

}