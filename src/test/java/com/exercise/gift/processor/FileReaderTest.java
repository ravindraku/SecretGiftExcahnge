package com.exercise.gift.processor;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.exercise.gift.data.Person;

public class FileReaderTest {
	
	private FileReader fileReader = null;

	@Test
	public void testParseFile() {
		fileReader = new FileReader();
		List<Person> participents = fileReader.parseInputFile(new String[]{"players.txt"});
		Assert.assertTrue(!participents.isEmpty());
		if(null != participents && !participents.isEmpty()){
			Person player = participents.get(0);
			assertEquals(player.getFirstName(), "Pernell");
			assertEquals(player.getLastName(), "Subban");
			assertEquals(player.getEmail(), "psubban@example.com");
		}
		
	}

}