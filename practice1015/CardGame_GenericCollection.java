package practice1015;

import java.util.*;

class Card {
	String suit;
	String number;

	public Card(String suit, String number) {
		this.suit = suit;
		this.number = number;
	}

	public String toString() {
		return "(" + suit + " " + number + ")";
	}
}

class Deck {
	ArrayList<Card> deck = new ArrayList<Card>();
	String[] suit = { "CLUB", "DIAMOND", "HEART", "SPACE" };
	String[] number = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

	public Deck() {
		for (int i = 0; i < suit.length; i++) {
			for (int j = 0; j < number.length; j++) {
				deck.add(new Card(suit[i], number[j]));
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public Card deal() {
		return deck.remove(0);
		// 데크의 처음에서 카드를 제거하여서 반환하는 메소드인 deal을 작성한다
	}
}

//player 는 카드를 얻어서 자신의 리스트에 추가하는 메소드인 getCard()를 가지고 있다
class Player {
	ArrayList<Card> list = new ArrayList<Card>();
	// ArrayList를 사용하여서 카드를 저장하도록 하자. 생성자에서 모든 카드를 생성한다

	public void getCard(Card card) {
		list.add(card);
	}

	public void showCards() {
		System.out.println(list);
	}
}

public class CardGame_GenericCollection {
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.shuffle();
		Player p1 = new Player();
		Player p2 = new Player();
		p1.getCard(deck.deal());
		p2.getCard(deck.deal());
		p1.showCards();
		p2.showCards();

	}
}