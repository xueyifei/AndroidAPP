package com.example.xue2015.myandroidapp.util;

public class ListItemQCenter {

	String name, type;
	int count, remain, point, money, condition;

	public ListItemQCenter(String name, String type, int count, int remain,
			int point, int money, int condition) {
		this.name = name;
		this.type = type;
		this.count = count;
		this.remain = remain;
		this.point = point;
		this.money = money;
		this.condition = condition;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getCount() {
		return count;
	}

	public int getRemain() {
		return remain;
	}

	public int getPoint() {
		return point;
	}

	public int getMoney() {
		return money;
	}

	public String getCondition() {
		switch (condition) {
		case -1:
			return "δ���";
		case 1:
			return "���";
		default:
			return "�������";
		}
	}
}
