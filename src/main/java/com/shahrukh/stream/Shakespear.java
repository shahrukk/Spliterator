package com.shahrukh.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;

public class Shakespear {

	public static void main(String[] args) throws IOException {
		
		Set<String> shakespeareWord=
				Files.lines(Paths.get("Files/shakespeare.txt"))
				.map(word -> word.toLowerCase())
				.collect(Collectors.toSet());
		
		
		Set<String> ospdWords=
				Files.lines(Paths.get("Files/ospd.txt"))
				.map(word ->word.toLowerCase())
				.collect(Collectors.toSet());
		
		System.out.println("Words of shakespeare :" +shakespeareWord.size());
		System.out.println("Words of ospd :" +ospdWords.size());

	}

}
