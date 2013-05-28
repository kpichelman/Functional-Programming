package com.pichelman.functionalProgramming;

public class Chap2Ex4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Chap2Ex4 app = new Chap2Ex4();
		Function<String, Object> f = new Function<String, Object>();
		m1(f);
	}

	public static void m1(Function<String, Object> fun) {
		
	}
}

class Function<T1, T2> {
	private T1 t1;
	private T2 t2;
	
	public void set(T1 t1, T2 t2) {
		this.t1 = t1;
		this.t2 = t2;
	}
	
	public T1 getT1() {
		return t1;
	}
	
	public T2 getT2() {
		return t2;
	}
}
