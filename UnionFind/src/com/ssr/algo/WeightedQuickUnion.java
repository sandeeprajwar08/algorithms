package com.ssr.algo;

import java.util.Arrays;
import java.util.Scanner;

public class WeightedQuickUnion {
	
	int [] index;
	int [] arr;
	int [] size;
	
	public WeightedQuickUnion(int n) {
		arr = new int[n];
		index = new int[n];
		size = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = i;
			index[i] = i;
			size[i] = 1;
		}
	}
	
	public void showArray() {
		System.out.println("index q :"+Arrays.toString(index));
		System.out.println("arr[q]  :"+Arrays.toString(arr));
		System.out.println("Size[q] :"+Arrays.toString(size));

	}

	public int root(int q) {
		int counter = q;
		while(counter != arr[counter]) {
			counter = arr[counter];
		}
		return counter;
	}
	
	public void union(int p, int q) {
		System.out.println("root("+q+") : "+root(q));
		
		if(arr[root(p)] != root(q)) {
			if(size[root(p)] < size[root(q)]) {
				arr[root(p)] = root(q);
				size[q] += size[p];
			} else {
				arr[root(q)] = root(p);
				size[p] += size[q];
			}
				
			
		} else {
			System.out.println(p+" and "+q+" are already connected.");
		}
		System.out.println("Union done with "+p+" and "+q+".");
	}
	
	public void connected(int p, int q) {
		if(root(arr[p]) ==  root(arr[q]))
			System.out.println("Connected : "+p+" and "+q);
		else
			System.out.println("Not connected : "+p+" and "+q);

	}
	
	public static void main(String [] args) {
		 
		int n = 10;
		WeightedQuickUnion qf = new WeightedQuickUnion(n);
		qf.showArray();
		
		Scanner src = new Scanner(System.in);
		
		boolean testFlag = true;
		int p=0, q=0;
		
		while(testFlag) {
			System.out.println("Union or Connected or Show or Quit (U/C/S/Q)?");
			String selectedOption = src.nextLine().trim();
			
			if("U".equalsIgnoreCase(selectedOption) || "C".equalsIgnoreCase(selectedOption)) {
				System.out.println("Enter the value of p and q : ");
				String inputValues = src.nextLine();
				if(inputValues != null && !inputValues.isEmpty() && inputValues.contains(" ")) {
					String[] inputArray = inputValues.trim().split(" ");
					p = Integer.parseInt(inputArray[0].trim());
					q = Integer.parseInt(inputArray[1].trim());
				}
				if(p >= n || q >= n) {
					System.out.println("Enter a value index. ");
				} else {
					if("U".equalsIgnoreCase(selectedOption)) {
						qf.union(p, q);
					} else {
						qf.connected(p, q);
					}
				}
				
			} else if("S".equalsIgnoreCase(selectedOption)) {
				qf.showArray();
			}  else {
				System.out.println("Thank you !!");
				testFlag = false;
			}
		}
		
		if(src != null)
			src.close();
		
	}
	
	
}
