package com;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataManage {
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] a = new int[10];
		DataManage dm = new DataManage();
		dm.notice();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while(true) {
			int input = sc.nextInt();
			if(input != 0) {
				switch (input) {
				case 1 : a = dm.insertData();
						 break;
				case 2 : dm.showData(a, a.length - 1);
						 break;
				case 3 : dm.insertAtArray(a);
						 break;
				case 4 : dm.divThree(a);
						 break;
				default : System.out.println("输入数据有误，请重新输入：");
				}
			} else {
				break;
			}
		}
	}

	// 显示提示信息
	public void notice() {
		System.out.println("*******************************");
		System.out.println("        1--插入数据");
		System.out.println("        2--显示所有数据");
		System.out.println("        3--在指定位置插入数据");
		System.out.println("        4--查询能被3整除的数据");
		System.out.println("        0--退出");
		System.out.println("*******************************");
		System.out.println("请输入对应的数字进行操作：");
	}

	// 插入数据
	public int[] insertData() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.println("请输入第" + (i + 1) + "个数据：");
			try {
				arr[i] = sc.nextInt();
			} catch(InputMismatchException e) {
				sc.next();
				System.out.println("格式输入错误。。。");
				notice();
				return null;
			}
		}
		showData(arr, arr.length - 1);
		return arr;
	}

	// 显示所有数据
	public void showData(int[] a, int length) {
		System.out.println("数组元素为：");
		for (int i = 0; i < length; i++) {
			System.out.print(a[i] + "  ");
		}
		System.out.println();
		notice();
	}

	// 在指定位置插入数据
	public void insertAtArray(int[] a) {
		int n;
		int k;
		System.out.println("请输入要插入的数据：");
		try {
			n = sc.nextInt();
			System.out.println("请输入要插入数据的位置：");
			k = sc.nextInt();
		} catch(InputMismatchException e) {
			sc.next();
			System.out.println("格式输入错误。。。");
			notice();
			return;
		}
		for (int i = a.length - 2; i > 0; i--) {
			if (i >= k) {
				a[i + 1] = a[i];
			}
		}
		a[k-1] = n;
		showData(a, a.length);
	}

	// 查询能被3整除的数据
	public void divThree(int[] a) {
		System.out.print("数组中能被3整除的元素为：");
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 3 == 0) {
				System.out.print(a[i] + "  ");
			}
		}
		System.out.println();
		notice();
	}
}