package Game;

public class CardDecorator implements CardComponent {
    protected CardComponent decoratedCard;

    public CardDecorator(CardComponent card) {
        this.decoratedCard = card;
    }

    @Override
    public String getSuit() {
        return decoratedCard.getSuit();
    }

    @Override
    public int getValue() {
        return decoratedCard.getValue();
    }

    @Override
    public String getRank() {
        return decoratedCard.getRank();
    }

    @Override
    public String ShowCard() {
        return decoratedCard.ShowCard(); // Peut être étendu pour ajouter plus de fonctionnalités
    }
}
