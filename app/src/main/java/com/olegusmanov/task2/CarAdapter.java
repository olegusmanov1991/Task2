package com.olegusmanov.task2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Олег on 10.11.2015.
 */
public class CarAdapter extends BaseAdapter
{
	public CarAdapter(Activity activity, LayoutInflater layoutInflater)
	{
		mActivity = activity;
		inflater = layoutInflater;

	}

	private Activity mActivity;
	LayoutInflater inflater;


	@Override
	public int getCount()
	{
		return Cars.values().length;
	}

	@Override
	public Object getItem(int position)
	{
		return Cars.values()[position];
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ViewHolder holder;
		if (convertView != null)
		{
			holder = (ViewHolder) convertView.getTag();
		}
		else
		{
			convertView = inflater.inflate(R.layout.adapter_car, parent, false);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		}


		Glide.with(mActivity).load(Cars.values()[position].getName(mActivity)).into(holder.previewImage);
		holder.previewImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
		holder.nameText.setText(Cars.values()[position].carBrand);
		holder.descriptionText.setText(Cars.values()[position].carCountry);

		return convertView;
	}

	static class ViewHolder

	{
		@Bind(R.id.fragment_car_image_view_preview)
		ImageView previewImage;
		@Bind(R.id.fragment_car_text_view_name)
		TextView nameText;
		@Bind(R.id.fragment_car_text_view_description)
		TextView descriptionText;

		public ViewHolder(View view)
		{
			ButterKnife.bind(this, view);
		}
	}
}
