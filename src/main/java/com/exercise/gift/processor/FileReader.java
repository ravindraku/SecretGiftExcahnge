package com.exercise.gift.processor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.exercise.gift.constant.GiftExchangeConstants;
import com.exercise.gift.data.Person;

/**
 * This is utility class to do the IO operation, read files and so string operations
 * @author Ravindra Kumar
 *
 */
public class FileReader {
	private static final String SPACE = " ";
	
	/**
	 * Utility method to parse the file, tokenize file entry
	 * @param args
	 * @return List<Person>
	 */
	public List<Person> parseInputFile(String[] args) {
		List<Person> players = new ArrayList<Person>();
		File file = null;
		Scanner input = null;
		try { 
			if (0 < args.length) {
				file = new File(args[0]);
			}
			else {
				input = new Scanner(System.in);
	        	System.out.print("Enter the file name with extention : ");
	        	file = new File(input.nextLine());
			}
	        input = new Scanner(file);
	        
	        //System.out.println("\nINPUT - Participents List : ");
	        while (input.hasNextLine()) {
	            String playerInfo = input.nextLine();
	            System.out.println(playerInfo);
	            String[] arrPlayerInfo = playerInfo.split(GiftExchangeConstants.SPACE); //tokenize the entry
	            players.add(populatePlayer(arrPlayerInfo));
	        }
		}catch (FileNotFoundException e) {
        	System.out.println("Specified file not available, please check the file name and localtion.");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
		finally {
			if (input != null)
				input.close();
		}
		return players;
	}
	
	/**
	 * Utility method to populate Person object
	 * @param name
	 * @return Person
	 */
	private Person populatePlayer(String[] name) {
		Person player = null;
		if (name.length == 3) {
			player = new Person(name[0], name[1], name[2]); //assuming every entry in the file will have first_name, last_name and email
		}
		return player;
	}

}
