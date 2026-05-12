package com.example.demo;
import java.util.*;

public class Programs {

	public static void main(String[] args) {
		
		ascendingOrder();
		descendingOrder();
		removeDuplicate();

	}

	// ascending order
	public static void ascendingOrder() {
		int[] arr = {4, 7, 2, 3, 8, 9, 5, 2};
		Set<Integer> a = new TreeSet<>();
		for(int x : arr) {
			a.add(x);
		}
	
		System.out.println("Sort in ascending order " +a);
	}
	
	// public static void descending order
	public static void descendingOrder() {
		int[] arr = {4, 7, 2, 3, 8, 9, 5, 2};
		Set<Integer> a = new TreeSet<>(Collections.reverseOrder());
		for(int x : arr) {
			a.add(x);
		}
		System.out.println("Sort in descending order "+a);
	}
	
	
	public static void removeDuplicate() {
		String item = "Deelhhiii";
		String reverse = "";
		char[] ch = item.toCharArray();
		for(int i = item.length()-1;i>=0;i--) {
			reverse =reverse+item.charAt(i);
		}
		System.out.println("Reverse of the string is " +reverse);
		System.out.println("======Remove Duplicates============");
		HashMap<Character,Integer> hmap = new HashMap<>();
		for(Character c: ch) {
			hmap.put(c, (hmap.getOrDefault(c, 0))+1);
		}
		System.out.println(hmap);
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Character, Integer> map : hmap.entrySet()) {
			if(map.getValue() ==1) {
				sb.append(map.getKey()).append(map.getValue());
			}
		}
		System.out.print("Count the value and output in key Value format " +sb);
	}
}
