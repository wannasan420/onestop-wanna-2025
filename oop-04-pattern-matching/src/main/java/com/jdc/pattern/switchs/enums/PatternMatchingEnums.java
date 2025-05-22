package com.jdc.pattern.switchs.enums;

public class PatternMatchingEnums {

	public int getLevel(Card card) {
		return switch(card) {
		case GameCard.Spade, TarrotCard.Angel -> 1;
		case GameCard.Heart, TarrotCard.Saint -> 2;
		case GameCard.Diamond, TarrotCard.People -> 3;
		case GameCard.Clover, TarrotCard.Demon -> 4;
		};
	}
}
