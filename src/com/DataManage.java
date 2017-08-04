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
				default : System.out.println("���������������������룺");
				}
			} else {
				break;
			}
		}
	}

	// ��ʾ��ʾ��Ϣ
	public void notice() {
		System.out.println("*******************************");
		System.out.println("        1--��������");
		System.out.println("        2--��ʾ��������");
		System.out.println("        3--��ָ��λ�ò�������");
		System.out.println("        4--��ѯ�ܱ�3����������");
		System.out.println("        0--�˳�");
		System.out.println("*******************************");
		System.out.println("�������Ӧ�����ֽ��в�����");
	}

	// ��������
	public int[] insertData() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.println("�������" + (i + 1) + "�����ݣ�");
			try {
				arr[i] = sc.nextInt();
			} catch(InputMismatchException e) {
				sc.next();
				System.out.println("��ʽ������󡣡���");
				notice();
				return null;
			}
		}
		showData(arr, arr.length - 1);
		return arr;
	}

	// ��ʾ��������
	public void showData(int[] a, int length) {
		System.out.println("����Ԫ��Ϊ��");
		for (int i = 0; i < length; i++) {
			System.out.print(a[i] + "  ");
		}
		System.out.println();
		notice();
	}

	// ��ָ��λ�ò�������
	public void insertAtArray(int[] a) {
		int n;
		int k;
		System.out.println("������Ҫ��������ݣ�");
		try {
			n = sc.nextInt();
			System.out.println("������Ҫ�������ݵ�λ�ã�");
			k = sc.nextInt();
		} catch(InputMismatchException e) {
			sc.next();
			System.out.println("��ʽ������󡣡���");
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

	// ��ѯ�ܱ�3����������
	public void divThree(int[] a) {
		System.out.print("�������ܱ�3������Ԫ��Ϊ��");
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 3 == 0) {
				System.out.print(a[i] + "  ");
			}
		}
		System.out.println();
		notice();
	}
}