package com.harystolho.utils;

public class Pair<T, U> {

	private T t;
	private U u;

	public Pair(T t, U u) {
		this.t = t;
		this.u = u;
	}

	public static <T, U> Pair<T, U> of(T t, U u) {
		return new Pair<T, U>(t, u);
	}

	public T getFirst() {
		return t;
	}

	public U getSecond() {
		return u;
	}

}
