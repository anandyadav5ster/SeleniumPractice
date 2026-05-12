package com.example.demo;
import java.util.*;

public class Programs {

	public static void main(String[] args) {
		int[] a = {4, 7, 2, 3, 8, 9, 5, 2};
		ascendingOrder(a);

	}

	// ascending order
	public static void ascendingOrder(int[] arr) {
		Set<Integer> a = new TreeSet<>();
		for(int x : arr) {
			a.add(x);
		}
	
		System.out.println(a);
	}
	
	public static void removeDuplicate() {
		
	}
}
