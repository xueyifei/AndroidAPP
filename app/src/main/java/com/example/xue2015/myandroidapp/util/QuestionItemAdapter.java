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

public class QuestionItemAdapter extends ArrayAdapter<ListItemQuestions> {

	private int resourceId;
	private boolean flag;

	public QuestionItemAdapter(Context context, int textViewResourceId,
			List<ListItemQuestions> objects,boolean flag) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub

		resourceId = textViewResourceId;
		this.flag=flag;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ListItemQuestions question = getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.questionImage = (ImageView) view
					.findViewById(R.id.questionnaire_image);
			viewHolder.questionName = (TextView) view
					.findViewById(R.id.questionnaire_name);
			viewHolder.questionRemain = (TextView) view
					.findViewById(R.id.questionnaire_remain);
			viewHolder.questionPoint = (TextView) view
					.findViewById(R.id.questionnaire_point);
			if(flag==true)
				viewHolder.questionPoint.setBackgroundResource(R.drawable.round_corner);
			else
				viewHolder.questionPoint.setBackgroundResource(R.drawable.round_corner_blue);
			view.setTag(viewHolder); // ��ViewHolder�洢��View�� 
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag(); // ���»�ȡViewHolder
		}
		viewHolder.questionImage.setImageResource(question.getImageId());
		viewHolder.questionName.setText(question.getName());
		viewHolder.questionRemain.setText(question.getRemain() + "/"
				+ question.getCount() + "份");
		viewHolder.questionPoint.setText(question.getPoint() + "积分");

		return view;
	}

	class ViewHolder {
		ImageView questionImage;
		TextView questionName, questionRemain, questionPoint;
	}
}
