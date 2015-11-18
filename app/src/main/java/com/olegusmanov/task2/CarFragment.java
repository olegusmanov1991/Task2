package com.olegusmanov.task2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Олег on 11.11.2015 at 19:22.
 * Project Task2
 */
public class CarFragment extends Fragment implements AdapterView.OnItemClickListener
{
	public static final String TAG = "CarFragment";

	CarAdapter mCarAdapter;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		mCarAdapter = new CarAdapter(getActivity(), getActivity().getLayoutInflater());

		View view = inflater.inflate(R.layout.fragment_car, container, false);

		ListView listView = (ListView) view.findViewById(R.id.fragment_car_list_view);
		listView.setAdapter(mCarAdapter);
		listView.setOnItemClickListener(this);

		return view;
	}


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		FragmentActivity activity = getActivity();

		if (activity instanceof ItemClickListener)
		{
			((ItemClickListener) activity).onItemClick(position);
		}
	}
}
