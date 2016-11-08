package ch.diso.q02;

enum Rank implements Cloneable {
    ACE(1), DUECE(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8),
    NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10);
    public int value;

    private Rank(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Rank card1 = Rank.ACE;
        Rank card2 = Rank.KING;
        System.out.println(card1.compareTo(card2));
    }
}
