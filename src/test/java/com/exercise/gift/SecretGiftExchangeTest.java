package com.exercise.gift;

import org.junit.Test;

public class SecretGiftExchangeTest {

	@Test
	public void testSecretsanta() {
		GiftExchangeApp.main(new String[] { "players.txt" });
	}

}