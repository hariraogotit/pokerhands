package com.instil.services;

import com.instil.constants.PokerHandRankEnum;
import com.instil.models.FiveCard;

import java.util.Map;

/**
 * Created by Hari Rao on 26/02/20.
 */
public interface PokerHandService {

    Map<FiveCard, PokerHandRankEnum> processPokerHand(String fileName);
}
