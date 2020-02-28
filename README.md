#Poker Hands

## How to run the jar
1. Run mvn clean install.
2. Run the uber jar
    2.1 Navigate to pokerhands/target
    2.2 Create a directory called input.
    2.3 Create a file something like input-five-cards.txt with the input. Refer the below for format
    2.3 Run :- java -jar poker-hands-1.0-SNAPSHOT.jar  input/inpit-five-cards.txt
3. To check the log navigate to pokerhands/target/log

## Example input file
10C 9H 8D 7S 6C
JS JD JH 6C 3S
KS KH 8D 8H 4S
AH AS 8D 6S 3C
KD 7S 5D 3C 2S
AH KH QH JH 10H
10H 9H 8H 7H 6H
AH AD AS AC 3S
8S 8C 8D AC AH
KC QC 10C 8C 6C

## Sample Output from the log
2020-02-28 10:47:02 INFO  LoadPokerApp:27 - KS	KH	8D	8H	4S=>Two Pair
2020-02-28 10:47:02 INFO  LoadPokerApp:27 - 6H	7H	8H	9H	10H=>Straight Flush
2020-02-28 10:47:02 INFO  LoadPokerApp:27 - 2S	3C	5D	7S	13D=>High Card
2020-02-28 10:47:02 INFO  LoadPokerApp:27 - AH	AS	8D	6S	3C=>One Pair
2020-02-28 10:47:02 INFO  LoadPokerApp:27 - AH	AD	AS	AC	3S=>Four Of A Kind
2020-02-28 10:47:02 INFO  LoadPokerApp:27 - JS	JD	JH	6C	3S=>Three Of A Kind
2020-02-28 10:47:02 INFO  LoadPokerApp:27 - 8S	8C	8D	AC	AH=>Full House
2020-02-28 10:47:02 INFO  LoadPokerApp:27 - 6C	7S	8D	9H	10C=>Straight
2020-02-28 10:47:02 INFO  LoadPokerApp:27 - 10H	11H	12H	13H	14H=>Royal Flush
2020-02-28 10:47:02 INFO  LoadPokerApp:27 - 6C	8C	10C	12C	13C=>Flush