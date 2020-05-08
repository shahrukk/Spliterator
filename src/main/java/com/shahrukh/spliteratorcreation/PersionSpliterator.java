package com.shahrukh.spliteratorcreation;

import java.util.Spliterator;
import java.util.function.Consumer;

import com.shahrukh.spliteratorcreation.model.Persion;

public class PersionSpliterator implements Spliterator<Persion> {

	private Spliterator<String> lineSpliterator;
	private String name;
	private int age;
	private String city;

	public PersionSpliterator(Spliterator<String> lineSpliterator) {
		this.lineSpliterator= lineSpliterator;
	}
	
	@Override
	public int characteristics() {
		return this.lineSpliterator.characteristics();
	}

	@Override
	public long estimateSize() {
		return this.lineSpliterator.estimateSize()/3;
	}

	@Override
	public boolean tryAdvance(Consumer<? super Persion> action) {
		if(
		this.lineSpliterator.tryAdvance(line->this.name=line) &&
		  this.lineSpliterator.tryAdvance(line->this.age=Integer.parseInt(line)) &&
		this.lineSpliterator.tryAdvance(line->this.city=line)) {
		
		Persion p = new Persion(name ,age ,city);
		action.accept(p);
		return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Spliterator<Persion> trySplit() {
		return null;
	}

}
