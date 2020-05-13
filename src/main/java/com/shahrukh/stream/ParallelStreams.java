package com.shahrukh.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreams {

	public static void main(String[] args) {
		System.out.println("|<-----Simple * pattern----->|");
	    Stream.iterate("*", s->s + "*")
	          .limit(6)
	          .forEach(System.out::println);
	    
	    System.out.println("|<----* pattern with parallel stream----->|");
	    Stream.iterate("*", s->s + "*")
	          .parallel()
	          .limit(6)
	          .forEach(System.out::println);
	    
	    System.out.println("|<----Simple IntStream---->|");
	    IntStream strm = IntStream.rangeClosed(1, 10);
	    strm.forEach(System.out::println);
	    
	    System.out.println("|<----Parallel IntStream---->|");
	    IntStream Pstrm = IntStream.rangeClosed(1, 10).parallel();
	    Pstrm.forEach(System.out::println);
	    
	    
	    

	}

}
