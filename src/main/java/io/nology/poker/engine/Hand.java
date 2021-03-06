package io.nology.poker.engine;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class Hand {
    private List<Card> cards;

    public Hand(List<Card> cards) {
        setCards(cards);
    }

    public Hand(String hand) {
        setCards(getCardsFromString(hand));
    }

    public void setCards(List<Card> cards) {
        cards = cards.stream().filter(card -> card.isValidCard()).collect(Collectors.toList());
        Collections.sort(cards, Comparator.comparingInt(Card::getCardValue).reversed());
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public static List<Card> getCardsFromString(String cards) {
        return Splitter
                .on(CharMatcher.anyOf(";,-/:|.{}[]<># "))
                .trimResults()
                .omitEmptyStrings()
                .splitToList(cards)
                .stream()
                .map((String card) -> new Card(card))
                .collect(Collectors.toList());
    }

    public Map<Card.CardRank, Long> getRankVarieties() {
        return cards.stream()
                .collect(groupingBy(Card::getRank, Collectors.counting()));
    }

    public long getOccurrencesOfHighestOccurringRank() {
        return getRankVarieties().entrySet().stream()
                .max(comparing(Map.Entry::getValue))
                .get().getValue();
    }

    public List<Card.CardRank> getRanksInOrderOfImportance() {
        return getRankVarieties().entrySet().stream()
                .sorted((card1, card2) -> {
                    if (card1.getValue().equals(card2.getValue()))
                        return card2.getKey().getValue() - card1.getKey().getValue();
                    else
                        return card2.getValue().intValue() - card1.getValue().intValue();
                })
                .map(item -> item.getKey())
                .collect(Collectors.toList());
    }

    public boolean hasSameSuit() {
        return cards.stream()
                .map(Card::getSuit)
                .collect(toSet())
                .size() == 1;
    }

    public boolean isStraight() {
        int previousCardValue = 0;
        for (Card card : cards) {
            if (previousCardValue == 0) previousCardValue = card.getCardValue() + 1;
            if (previousCardValue - card.getCardValue() != 1) return false;
            previousCardValue = card.getCardValue();
        }
        return true;
    }

    public int getSize() {
        return cards.size();
    }
}
