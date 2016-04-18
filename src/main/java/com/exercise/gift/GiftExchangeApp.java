package com.exercise.gift;

import com.exercise.gift.processor.GiftProcessor;

/**
 * Secret Gift Exchange App
 * @author Ravindra Kumar
 */
public class GiftExchangeApp 
{
	public static void main(String[] args) {
		new GiftProcessor().processGiftExchange(args);;
    }
}
