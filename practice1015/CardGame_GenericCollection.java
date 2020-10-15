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
		// ��ũ�� ó������ ī�带 �����Ͽ��� ��ȯ�ϴ� �޼ҵ��� deal�� �ۼ��Ѵ�
	}
}

//player �� ī�带 �� �ڽ��� ����Ʈ�� �߰��ϴ� �޼ҵ��� getCard()�� ������ �ִ�
class Player {
	ArrayList<Card> list = new ArrayList<Card>();
	// ArrayList�� ����Ͽ��� ī�带 �����ϵ��� ����. �����ڿ��� ��� ī�带 �����Ѵ�

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