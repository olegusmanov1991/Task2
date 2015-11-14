package com.olegusmanov.task2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


/**
 * Created by Олег on 10.11.2015.
 */
public class DescriptionFragment extends Fragment
{
	public static final String TAG = "DescriptionFragment";

	ImageView imageFounder;
	TextView textFounder;
	ImageView imageLogo;
	TextView textModels;
	TextView textMoney;

	private Activity mActivity;


	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_descriprion, container, false);


		imageFounder = (ImageView) view.findViewById(R.id.fragment_descriprion_image_view_founder);
		textFounder = (TextView) view.findViewById(R.id.fragment_descriprion_text_view_founder);
		imageLogo = (ImageView) view.findViewById(R.id.fragment_descriprion_image_view_logo);
		textModels = (TextView) view.findViewById(R.id.fragment_descriprion_text_view_models);
		textMoney = (TextView) view.findViewById(R.id.fragment_descriprion_text_view_money);


		return view;

	}

	public void change(int position)
	{

		mActivity = getActivity();

		Glide.with(mActivity).load(DescriptionEnum.values()[position].descriptionImageFounder).into(imageFounder);
		textFounder.setText(DescriptionEnum.values()[position].descriptionTextFounder);
		Glide.with(mActivity).load(DescriptionEnum.values()[position].descriptionImageLogo).into(imageLogo);
		textModels.setText(DescriptionEnum.values()[position].descriptionTextModels);
		textMoney.setText(DescriptionEnum.values()[position].descriptionTextMoney);
	}

}