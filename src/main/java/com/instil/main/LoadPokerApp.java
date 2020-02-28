package com.instil.main;

import com.instil.services.PokerHandService;
import com.instil.services.PokerHandServiceImpl;

/**
 * Created by Hari Rao on 26/02/20.
 */
public class LoadPokerApp {

    public static void main(String[] args) {
        PokerHandService pokerHandService = new PokerHandServiceImpl();
        System.out.println(pokerHandService.processPokerHand("/home/shyamali/pokerhands/src/main/resources/input-five-cards.txt"));
    }
}
