package com.instil.main;

import com.instil.constants.PokerHandRankEnum;
import com.instil.models.FiveCard;
import com.instil.services.PokerHandService;
import com.instil.services.PokerHandServiceImpl;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * Created by Hari Rao on 26/02/20.
 */
public class LoadPokerApp {

    private static Logger logger = Logger.getLogger(LoadPokerApp.class);


    public static void main(String[] args) {
        if(args.length == 0){
            logger.error("Please provide a input file in input directory like input/input-five-cards.txt");
        }else {
            PokerHandService pokerHandService = new PokerHandServiceImpl();
            Map<FiveCard, PokerHandRankEnum> fiveCardPokerHandMap =
                    pokerHandService.processPokerHand(args[0]);
            fiveCardPokerHandMap.entrySet()
                    .forEach(fiveCardStringEntry -> {
                        logger.info(fiveCardStringEntry.getKey() + "=>" + fiveCardStringEntry.getValue().getValue());
                    });
        }
    }
}
