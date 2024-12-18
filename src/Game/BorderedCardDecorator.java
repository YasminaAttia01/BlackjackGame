package Game;

public class BorderedCardDecorator extends CardDecorator {

    public BorderedCardDecorator(CardComponent card) {
        super(card);
    }

    @Override
    public String ShowCard() {
        return "Bordered " + decoratedCard.ShowCard();
    }
}
