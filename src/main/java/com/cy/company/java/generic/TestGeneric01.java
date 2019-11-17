package com.cy.company.java.generic;
interface Container<T>{
	void add(T t);
	T get(int i);
	int size();
}
abstract class AbsContatiner<T> implements Container<T>{
	@Override
	public int size() {
		return 0;
	}
} 
class ArrayContatiner extends AbsContatiner<Integer>{
	@Override
	public void add(Integer t) {
	}
	@Override
	public Integer get(int i) {
		return 0;
	}
}

public class TestGeneric01 {

}
