package Game;

import java.util.Arrays;
import java.util.List;

/**
 * Classe représentant une carte du jeu, implémentant l'interface CardComponent.
 * Cette classe peut être décorée par d'autres décorateurs pour ajouter des fonctionnalités.
 *
 * @author MSI
 */
public class Card implements CardComponent, MyComparator<Card> {
    private char suit;
    private int value;
    private String rank;

    // Constructeur
    public Card(char suit, int value, String rank) throws InvalidCardValueException, InvalidCardSuitException, InvalidCardRankExeception {
        String[] stringArray = {"Ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "Jack", "Queen", "King"};
        List<String> stringList = Arrays.asList(stringArray);

        if (value < 1 || value > 10) {
            throw new InvalidCardValueException(value);
        } else {
            this.value = value;
        }

        if (suit != 'H' && suit != 'S' && suit != 'D' && suit != 'C') {
            throw new InvalidCardSuitException(suit);
        } else {
            this.suit = suit;
        }

        if (stringList.contains(rank)) {
            this.rank = rank;
        } else {
            throw new InvalidCardRankExeception(rank);
        }
    }

    // Méthodes de l'interface CardComponent
    @Override
    public String getSuit() {
        switch (this.suit) {
            case 'H': return "Hearts";
            case 'S': return "Spades";
            case 'C': return "Clubs";
            case 'D': return "Diamonds";
            default: return "Unknown";
        }
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getRank() {
        return rank;
    }

    @Override
    public String ShowCard() {
        return "cards/" + getValue() + "-" + getSuit1() + "-" + getRank() + ".png";
    }

    public char getSuit1() {
        return suit;
    }

    // Méthodes de modification des propriétés
    public void setSuit(char suit) {
        this.suit = suit;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    // Méthode de comparaison (MyComparator)
    @Override
    public boolean compareTo(Card other) {
        return this.value > other.value;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", value=" + value +
                ", rank='" + rank + '\'' +
                '}';
    }
}
