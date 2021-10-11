package com.greatlearning.dsalab;

import java.util.ArrayList;

public class LongestPathInBT {

	public static void main(String[] args) {
		Node root = newNode(100);
		root.left = newNode(20);
		root.right = newNode(130);

		root.left.left = newNode(10);
		root.left.right = newNode(50);

		root.right.left = newNode(110);
		root.right.right = newNode(140);

		root.left.left.left = newNode(5);

		ArrayList<Integer> longestPath = findLongestPath(root);
		int size = longestPath.size();
		System.out.println("Longest Path:");
		System.out.print(longestPath.get(size-1));
		for(int i=size-2;i>=0;i--) {
			System.out.print(" -> "+longestPath.get(i));
		}
	}

	static class Node {
		Node left;
		Node right;
		int data;
	}

	public static Node newNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	public static ArrayList<Integer> findLongestPath(Node root) {
		if (root == null)
			return new ArrayList<Integer>();		

		ArrayList<Integer> left = findLongestPath(root.left);
		ArrayList<Integer> right = findLongestPath(root.right);

		if (right.size() < left.size())
			left.add(root.data);
		else
			right.add(root.data);

		return (left.size() > right.size() ? left : right);
	}

}
