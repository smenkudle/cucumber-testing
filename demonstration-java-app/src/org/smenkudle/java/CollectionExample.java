package org.smenkudle.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class CollectionExample {

	public static void main(String[] args) {
		// System.out.println("Welcome to Java world");
		// collectionListExample();
		// collectionMapExample();
		// equalsExample();
		// vectorExample();
		// stackExample();
		// queueExample();
		// cloneExample();
		// tryWithResouces();
		// staticMethods();
		// spanThreadLamda();
		// customObjectInTreeSet();
		// treeMapExample();
		 int[] data = { 10, -1, 11, 15, 20 };
		 sortArray(data);
		// findNearestToZero(data);
		// System.out.println(findMultSer(5));

	}

	public int solution(String S, int[] C) {

		int cost = 0;
		char[] string = S.toCharArray();
		for (int i = 0; i < string.length; i++) {
			int endIndex = -1;
			int startIndex = i;
			int j;
			for (j = i + 1; j < string.length; j++) {
				if (string[i] == string[j])
					endIndex = j;
				else {
					break;
				}
			}
			i = j - 1;
			if (endIndex > 0) {
				cost += lowCostBetween(C, startIndex, endIndex);
			}
		}
		return cost;

	}

	private int lowCostBetween(int[] c, int startIndex, int endIndex) {
		int lowestCost = 0;
		int maxIndex = -1;
		int maxValue = -1;
		for (int i = startIndex; i <= endIndex; i++) {
			if (c[i] > maxValue) {
				maxValue = c[i];
				maxIndex = i;
			}
		}

		for (int i = startIndex; i <= endIndex; i++) {
			if (i != maxIndex)
				lowestCost += c[i];
		}
		return lowestCost;
	}

	public int solution(int[] blocks) {
		int distanceNumber = 0;
		for (int sit = 0; sit < blocks.length; sit++) {
			int toRight = 0;
			int toLeft = 0;
			int apartBy = 0;
			int i, j;
			for (i = sit; i < (blocks.length - 1); i++) {
				if (!canFrogJump(blocks[i], blocks[i + 1]))
					break;
			}
			toRight = i - sit;
			for (j = sit; j >= 1; j--) {
				if (!canFrogJump(blocks[j], blocks[j - 1]))
					break;
			}
			toLeft = sit - j;
			apartBy = toRight + toLeft + 1;
			sit += toRight;
			if (apartBy > distanceNumber)
				distanceNumber = apartBy;
		}

		return distanceNumber;
	}

	private boolean canFrogJump(int block1, int block2) {
		return block1 <= block2;
	}

	public static int findMultSer(int number) {
		if (number == 1)
			return 1;
		return number * findMultSer(number - 1);
	}

	static int findNearestToZero(int[] arr) {
		int nearestNumber = arr[0];
		for (int num : arr) {
			if (num <= 0 && num < nearestNumber)
				nearestNumber = num;
			if (num > 0 && num > nearestNumber)
				nearestNumber = num;
		}

		System.out.println(nearestNumber);
		return nearestNumber;
	}

	public static int[] sortArray(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			if (temp < arr[i - 1]) {
				arr[i] = arr[i - 1];
				arr[i - 1] = temp;
			}
		}

		for (int num : arr) {
			System.out.println(num);
		}
		return arr;
	}

	private static void treeMapExample() {
		// TODO Auto-generated method stub
		Map<ParentA, String> map = new TreeMap<>((o1, o2) -> o1.getNumber().compareTo(o2.getNumber()));
		map.put(new ParentA(10), "Somnath");
		map.put(new ParentA(3), "Amol");
		map.put(new ParentA(12), "Amol");
		map.put(new ParentA(123), "Somnath");
		map.entrySet().forEach(System.out::println);

	}

	private static void customObjectInTreeSet() {
		// TODO Auto-generated method stub
		Set<Integer> sm = new TreeSet<>();
		sm.add(13);
		sm.add(10);
		sm.add(14);
		sm.add(12);
		sm.forEach(System.out::println);

		Set<ParentB> sb = new TreeSet<>();
		sb.add(new ParentB(11, "Somnath"));
		sb.add(new ParentB(10, "Somnath"));
		sb.add(new ParentB(9, "Amol"));
		sb.forEach(System.out::println);
	}

	private static void spanThreadLamda() {
		// TODO Auto-generated method stub
		Thread thread = new Thread(() -> System.out.println("Spaning thead using lamda"));
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("In main thread");
	}

	private static void staticMethods() {
		// TODO Auto-generated method stub
		ParentA a = new ParentA();
		ParentA a1 = new ParentB();
		ParentB b = new ParentB();
		a.print();
		a1.print();
		b.print();

	}

	private static void tryWithResouces() {
		// TODO Auto-generated method stub
		try (FileInputStream input = new FileInputStream("file.txt")) {

			int data = input.read();
			while (data != -1) {
				System.out.print((char) data);
				data = input.read();
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void cloneExample() {

		Emp emp = new Emp(10, "Somnath");
		try {
			System.out.println(emp.clone());
			emp = null;
			Thread.sleep(10000000);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Method completed");

	}

	private static void queueExample() {
		Queue<Emp> pQueue = new PriorityQueue<>();
		pQueue.add(new Emp(10, "Somnath"));
		pQueue.add(new Emp(12, "Amol"));
		pQueue.add(new Emp(9, "Nishant"));
		pQueue.add(new Emp(15, "Aditya"));

		System.out.println(pQueue.poll());
	}

	private static void stackExample() {
		Stack<String> s = new Stack<>();

		s.push("somnath");
		s.push("puja");
		s.push("aditya");

		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());

		// You will EmptyStackException in both
		// System.out.println(s.pop());
		// System.out.println(s.peek());
	}

	private static void vectorExample() {
		Vector<String> v = new Vector<>();
		v.add("Somnath");
		v.add("Puja");
		v.add("Aditya");
		v.forEach(System.out::println);

	}

	private static void equalsExample() {
		Emp emp1 = new Emp(1, "Somnath");
		Emp emp2 = new Emp(2, "Somnath");

		if (emp1.equals(emp2))
			System.out.println("Equals");
		else
			System.out.println("Not");

	}

	public static void collectionMapExample() {
		Map<Emp, String> map = new HashMap<>();

		map.put(new Emp(1, "Somnath"), "ABC");
		map.put(new Emp(1, "Somnath"), "PQR");
		map.put(new Emp(1, "Somnath"), "Menkudle");
		map.put(new Emp(2, "Somnath"), "Dhumal");
		map.put(new Emp(3, "Somnath"), "XYZ");

		for (Emp key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}

		System.out.println("Map size is: " + map.size());

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void main() {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			int i = s.nextInt();
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBizz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 3 == 0) {
				System.out.println("Bizz");
			} else {
				System.out.println(i);

			}
		}
	}

	public static void collectionListExample() {
		List<Integer> list = new ArrayList<>();

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);

		System.out.println("Interation");
		Iterator<Integer> i = list.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
			// i.remove(); //it allows remove opt
		}

		System.out.println("Interation for each");
		for (Integer item : list) {
			System.out.println(item);
		}
		System.out.println("Interation by forEach");
		list.forEach(System.out::println);

		System.out.println("Enumeration");
		Enumeration<Integer> e = Collections.enumeration(list);
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}

		System.out.println("ListIterator: Print in reverse");
		ListIterator<Integer> lt = list.listIterator(list.size());
		while (lt.hasPrevious()) {
			System.out.println(lt.previous());
		}

	}
}

class ParentA {
	private Integer number;

	public ParentA() {
		super();
	}

	public ParentA(int number) {
		this.number = number;
	}

	public static void print() {
		System.out.println("From ParentA");
	}

	@Override
	public String toString() {
		return this.number.toString();
	}

	public Integer getNumber() {
		return this.number;
	}
}

class ParentB extends ParentA implements Comparable<ParentB> {
	private Integer number;
	private String name;

	public ParentB() {
		super();
	}

	public ParentB(int number, String name) {
		this.number = number;
		this.name = name;
	}

	public static void print() {
		System.out.println("From ParentB");
	}

	@Override
	public int compareTo(ParentB o) {
		// TODO Auto-generated method stub
		return this.number.compareTo(o.number);
	}

	@Override
	public String toString() {
		return this.name + " " + this.number;
	}
}

class Emp extends Object implements Comparable<Emp> /* , Cloneable */ {
	private int number;
	private String name;

	public Emp(int number, String name) {
		this.number = number;
		this.name = name;
	}

	public String toString() {
		return name + " " + number;
	}

	public int hashCode() {
		return number / 10;
	}

	public Emp clone() throws CloneNotSupportedException {

		if (this.number == 0)
			throw new CloneNotSupportedException();

		return new Emp(number, name);
	}

	public boolean equals(Object emp) {
		if (emp instanceof Emp) {
			Emp empObj = (Emp) emp;
			if (this.number == empObj.number && this.name.equalsIgnoreCase(empObj.name))
				return true;
		}

		return false;
	}

	@Override
	public int compareTo(Emp o) {
		return this.number - o.number;
	}

	@Override
	public void finalize() {
		System.out.println("DELETED");
	}
}
