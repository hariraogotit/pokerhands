

# PokerHands

## Highlevel overview
1. LoadPokerApp.java reads the input file. Then delegates the processing of poker cards to PokerHandServiceImpl.java<br/>
2. PokerHandServiceImpl.java delegates validation processing to FiveCardsValidatorImpl.java <br/>
3. After validation PokerHandServiceImpl.java determines hand rank by delegating to HandRankServiceImpl.java<br/>

## Improvements that I can think of now
1. <div class="text-red mb-2"> Currently the App considers "A" as greater than "K". Further coding needs to make it consider "A" as 1</div><BR>
2. More validations like validate the Card and Suit
3. PokerHandServiceImpl.java processFiveCards and processMoreFiveCards methods are big and would love to come up with an alternative
4. A highlevel class diagram
5. More unit tests although I think the main core logics are tested.
6. Add more loggings

## How to run the jar
1. Run mvn clean install.
2. Run the uber jar<br/>
    2.1 Navigate to pokerhands/target<br/>
    2.2 Create a directory called input.<br/>
    2.3 Create a file something like input-five-cards.txt with the input. Refer the below for format<br/>
    2.3 Run :- java -jar poker-hands-1.0-SNAPSHOT.jar  input/inpit-five-cards.txt<br/>
3. To check the log navigate to pokerhands/target/log

## Example input file :- space between cards-suits pair
10C 9H 8D 7S 6C<br/>
JS JD JH 6C 3S<br/>
KS KH 8D 8H 4S<br/>
AH AS 8D 6S 3C<br/>
KD 7S 5D 3C 2S<br/>
AH KH QH JH 10H<br/>
10H 9H 8H 7H 6H<br/>
AH AD AS AC 3S<br/>
8S 8C 8D AC AH<br/>
KC QC 10C 8C 6C<br/>

## Sample output from the log
2020-02-28 10:47:02 INFO  LoadPokerApp:27 - KS	KH	8D	8H	4S=>Two Pair<br/>
2020-02-28 10:47:02 INFO  LoadPokerApp:27 - 6H	7H	8H	9H	10H=>Straight Flush<br/>
2020-02-28 10:47:02 INFO  LoadPokerApp:27 - 2S	3C	5D	7S	13D=>High Card<br/>
2020-02-28 10:47:02 INFO  LoadPokerApp:27 - AH	AS	8D	6S	3C=>One Pair<br/>
2020-02-28 10:47:02 INFO  LoadPokerApp:27 - AH	AD	AS	AC	3S=>Four Of A Kind<br/>
2020-02-28 10:47:02 INFO  LoadPokerApp:27 - JS	JD	JH	6C	3S=>Three Of A Kind<br/>
2020-02-28 10:47:02 INFO  LoadPokerApp:27 - 8S	8C	8D	AC	AH=>Full House<br/>
2020-02-28 10:47:02 INFO  LoadPokerApp:27 - 6C	7S	8D	9H	10C=>Straight<br/>
2020-02-28 10:47:02 INFO  LoadPokerApp:27 - 10H	11H	12H	13H	14H=>Royal Flush<br/>
2020-02-28 10:47:02 INFO  LoadPokerApp:27 - 6C	8C	10C	12C	13C=>Flush

