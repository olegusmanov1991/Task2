package com.olegusmanov.task2;

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
 * Created by Олег on 10.11.2015 at 19:22.
 * Project Task2
 */
public class DescriptionFragment extends Fragment
{
	public static final String TAG = "DescriptionFragment";

	int number = 100;

	public int change(int position)
	{
		number = position;
		return number;
	}

	ImageView imageFounder;
	TextView textFounder;
	ImageView imageLogo;
	TextView textModels;
	TextView textMoney;

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

		if (number != 100)
		{
			Glide.with(getActivity()).load(DescriptionEnum.values()[number].getDescriptionImageFounder(getActivity())).into(imageFounder);
			textFounder.setText(DescriptionEnum.values()[number].getDescriptionTextFounder(getActivity()));
			Glide.with(getActivity()).load(DescriptionEnum.values()[number].getDescriptionImageLogo(getActivity())).into(imageLogo);
			textModels.setText(DescriptionEnum.values()[number].getDescriptionTextModels(getActivity()));
			textMoney.setText(DescriptionEnum.values()[number].getDescriptionTextMoney(getActivity()));
		}

		return view;
	}

	public void recreate(int position)
	{
		Glide.with(getActivity()).load(DescriptionEnum.values()[position].getDescriptionImageFounder(getActivity())).into(imageFounder);
		textFounder.setText(DescriptionEnum.values()[position].getDescriptionTextFounder(getActivity()));
		Glide.with(getActivity()).load(DescriptionEnum.values()[position].getDescriptionImageLogo(getActivity())).into(imageLogo);
		textModels.setText(DescriptionEnum.values()[position].getDescriptionTextModels(getActivity()));
		textMoney.setText(DescriptionEnum.values()[position].getDescriptionTextMoney(getActivity()));
	}

}
