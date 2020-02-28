package com.instil.services;

import com.instil.constants.PokerHandEnum;
import com.instil.models.FiveCard;

import java.util.Map;

/**
 * Created by Hari Rao on 26/02/20.
 */
public interface PokerHandService {

    Map<FiveCard, PokerHandEnum> processPokerHand(String fileName);
}
