package com.example.xue2015.myandroidapp.util;

public class ListItemQuestions {

	private String name;
	private int count, remain, point;
	private int imageId;

	public ListItemQuestions(String name, int count, int remain, int point,
			int imageId) {
		this.name = name;
		this.count = count;
		this.remain = remain;
		this.point = point;
		this.imageId = imageId;
	}

	public String getName() {
		return name;
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

	public int getImageId() {
		return imageId;
	}

}
