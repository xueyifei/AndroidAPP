package com.example.xue2015.myandroidapp.util;

import java.util.List;

import com.example.xue2015.myandroidapp.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RewardItemAdapter extends ArrayAdapter<ListItemRewards> {

	private int resourceId;

	public RewardItemAdapter(Context context, int textViewResourceId,
			List<ListItemRewards> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub

		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ListItemRewards rewards = getItem(position); // ��ȡ��ǰ���Fruitʵ��
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.questionImage = (ImageView) view
					.findViewById(R.id.reward_question_image);
			viewHolder.questionName = (TextView) view
					.findViewById(R.id.reward_question_name);
			viewHolder.questionRemain = (TextView) view
					.findViewById(R.id.reward_question_remain);
			viewHolder.questionPoint = (TextView) view
					.findViewById(R.id.reward_question_point);
			// viewHolder.questionPoint.setBackgroundResource(R.drawable.round_corner_blue);
			viewHolder.rewardImage = (ImageView) view
					.findViewById(R.id.reward_image);
			viewHolder.rewardName = (TextView) view
					.findViewById(R.id.reward_name);
			view.setTag(viewHolder); // ��ViewHolder�洢��View��
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag(); // ���»�ȡViewHolder
		}
		viewHolder.questionImage.setImageResource(rewards.getQuestionImageId());
		viewHolder.questionName.setText(rewards.getQuestionName());
		viewHolder.questionRemain.setText(rewards.getQuestionRemain() + "/"
				+ rewards.getQuestionCount() + "份");
		viewHolder.questionPoint.setText(rewards.getQuestionPoint() + "积分");
		viewHolder.rewardImage.setImageResource(rewards.getRewardImageId());
		viewHolder.rewardName.setText(rewards.getRewardName());
		return view;
	}

	class ViewHolder {
		ImageView questionImage, rewardImage;
		TextView questionName, questionRemain, questionPoint, rewardName;
	}

}
