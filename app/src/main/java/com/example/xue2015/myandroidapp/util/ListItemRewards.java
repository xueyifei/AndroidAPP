package com.example.xue2015.myandroidapp.util;

public class ListItemRewards {

	private String questionName, rewardName;
	private int questionCount, questionRemain, questionPoint, questionImageId,
			rewardImageId;

	public ListItemRewards(String questionName, int questionCount,
			int questionRemain, int questionPoint, int questionImageId,
			String rewardName, int rewardImageId) {
		this.questionName = questionName;
		this.questionCount = questionCount;
		this.questionRemain = questionRemain;
		this.questionPoint = questionPoint;
		this.questionImageId = questionImageId;
		this.rewardName = rewardName;
		this.rewardImageId = rewardImageId;
	}

	public String getQuestionName() {
		return questionName;
	}

	public int getQuestionCount() {
		return questionCount;
	}

	public int getQuestionRemain() {
		return questionRemain;
	}

	public int getQuestionPoint() {
		return questionPoint;
	}

	public int getQuestionImageId() {
		return questionImageId;
	}

	public String getRewardName() {
		return rewardName;
	}

	public int getRewardImageId() {
		return rewardImageId;
	}

}
