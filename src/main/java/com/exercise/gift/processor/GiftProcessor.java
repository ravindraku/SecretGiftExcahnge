package com.exercise.gift.processor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import org.springframework.scheduling.annotation.Async;

import com.exercise.gift.data.Person;

/**
 * This is the processor class and entry point for Secret Gift Exchange application
 * @author Ravindra Kumar
 *
 */
public class GiftProcessor {
	
	private EmailProcessor emailProcessor = null;
	
	/**
	 * Method to process Gift
	 */
	public void processGiftExchange(String[] args) {
		Map<String, String> fromToMailMap = new HashMap<String, String>();
		Map<Person, Person> exclusionMap = new LinkedHashMap<Person, Person>();
		FileReader secretFileReader = new FileReader();
		List<Person> particpants = secretFileReader.parseInputFile(args);
		GiftProcessor giftProcessor = new GiftProcessor();
		
		List<Person> receiver = new ArrayList<Person>(particpants); //copy
		
		final Random random = new Random();
		Collections.shuffle(particpants, random);
		
		System.out.println("\nOUTPUT - Gift Exchange distribution List : ");
		Set<String> uniqueExclusion = new LinkedHashSet<String>();
		
		for (Person particpant : particpants) {
			int target = 0;
			
			if (receiver.get(target).equals(particpant)) {
				//shuffle again if both names are same
				final Random random2 = new Random();
				Collections.shuffle(receiver, random2);
				continue;
			}
			
			//exclude family member with last matching name
			if(!receiver.get(target).getLastName().equals(particpant.getLastName())) {
				System.out.println(particpant.getFirstName() + " " + particpant.getLastName()  + " - " + receiver.get(target).getFirstName() +" "+ receiver.get(target).getLastName());
				
				fromToMailMap.put(particpant.getEmail(), receiver.get(target).getEmail()); //send email to Person who received gift
				
				receiver.remove(receiver.get(target)); //remove the gift receiver from collection
			}
			else  
			{
				//add all participants left out from random logic
				uniqueExclusion.add(receiver.get(target).getFirstName() + " " + receiver.get(target).getLastName());
				exclusionMap.put(particpant, receiver.get(target));
			}
				
		}
		
		//print name of the person not getting the gifts because of family name restriction
		if (uniqueExclusion != null && exclusionMap.size() > 0) {
			printExcludedMembers(uniqueExclusion, exclusionMap.size());
		}
		
		if(!exclusionMap.isEmpty()){
			System.out.println(exclusionMap);
		}
		
		//send email to receiver
		//@TODO following line is being commented - this need valid email setup 
		giftProcessor.sendMail(fromToMailMap);
	}
	
	/**
	 * Method to print name of the Person not getting the gifts because of family name restriction
	 * @param exclusion
	 * @param exclusionSize
	 */
	private void printExcludedMembers(Set<String> exclusion, int exclusionSize) {
		System.out.println("\nFollowing person will not get gift because of family gift policy restriction : ");
		for (String exclusionName : exclusion) {
			System.out.println(exclusionName);
		}
		
	}

	/**
	 * Utility method to send email to a given address
	 * @param fromToMailMap Map<String, String>
	 */
	@Async
	private void sendMail(Map<String, String> fromToMailMap) {
		emailProcessor = new EmailProcessor();
		Set<Entry<String, String>> entries = fromToMailMap.entrySet();
		for (Entry<String, String> entry : entries) {
			emailProcessor.mailSender(entry.getKey(),entry.getValue());
		}
	}

}
