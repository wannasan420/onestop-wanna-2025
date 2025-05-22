package com.jdc.pattern.switchs.enums;

public class GuardedPatternDemo {

	public static String getLabel(CardValue<GameCard> v1) {
		
		return switch(v1) {
		case CardValue(var card,var value) when card == GameCard.Spade && value == 1 -> "Best Card";
		case CardValue(var card,var value) when value == 1 -> "Best value card";
		case CardValue(var card,var value) when value <= 13 -> "%s : %d".formatted(card, value);
		default -> throw new IllegalArgumentException();
		};
	}
}
