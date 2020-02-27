package com.instil.validators;

import com.instil.models.FiveCard;

import java.util.List;

/**
 * Created by Hari Rao on 26/02/20.
 */
public interface FiveCardsValidator {

    List<FiveCard> validate(List<String> fiveCards);
}
