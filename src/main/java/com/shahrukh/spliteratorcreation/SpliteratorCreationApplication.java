package com.shahrukh.spliteratorcreation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.shahrukh.spliteratorcreation.model.Persion;

public class SpliteratorCreationApplication {

	public static void main(String[] args) {
		
		Path path =Paths.get("Files/person.txt");
		
		try (Stream<String> lines= Files.lines(path);){
			Spliterator<String> lineSpliterator= lines.spliterator();
			Spliterator<Persion> peopleSpliterator=new PersionSpliterator(lineSpliterator);
			
			Stream<Persion> people = StreamSupport.stream(peopleSpliterator, false);
			people.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
