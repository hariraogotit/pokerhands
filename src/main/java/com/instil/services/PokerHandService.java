package com.instil.services;

import com.instil.models.FiveCard;

import java.util.Map;

/**
 * Created by Hari Rao on 26/02/20.
 */
public interface PokerHandService {

    Map<FiveCard, String> processPokerHand(String fileName);
}
