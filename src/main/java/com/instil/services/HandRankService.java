package com.instil.services;

import com.instil.models.FiveCard;

/**
 * Created by Hari Rao on 27/02/20.
 */
public interface HandRankService {

    boolean isRoyalFlush(FiveCard fiveCard);
    boolean isStraightFlush(FiveCard fiveCard);
    boolean isFourOFAKind(FiveCard fiveCard);
    boolean isFullHouse(FiveCard fiveCard);
    boolean isFlush(FiveCard fiveCard);
    boolean isStraight(FiveCard fiveCard);
    boolean isThreeOfAKind(FiveCard fiveCard);
    boolean isTwoPairs(FiveCard fiveCard);
    boolean isOnePair(FiveCard fiveCard);
    boolean isHighCard(FiveCard fiveCard);

}
