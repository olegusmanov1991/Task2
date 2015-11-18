package com.olegusmanov.task2;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;

public class MainActivity extends FragmentActivity implements ItemClickListener
{
	@Override
	public void onItemClick(int position)
	{
		DisplayMetrics mDisplayMetrics = getResources().getDisplayMetrics();
		if (mDisplayMetrics.widthPixels < 720)
		{
			Intent intent = new Intent(MainActivity.this, SecondActivity.class);
			intent.putExtra("pos", position);
			startActivity(intent);
		}
		else
		{
			DescriptionFragment fragmentByTag = (DescriptionFragment) getSupportFragmentManager().findFragmentByTag(DescriptionFragment.TAG);
			fragmentByTag.recreate(position);
		}
	}


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		CarFragment carFragment = new CarFragment();
		DescriptionFragment descriptionFragment = new DescriptionFragment();
		FragmentManager fragmentManager = getSupportFragmentManager();

		DisplayMetrics mDisplayMetrics = getResources().getDisplayMetrics();
		if (mDisplayMetrics.widthPixels > 720)
		{
			if (fragmentManager.findFragmentByTag(CarFragment.TAG) == null)
			{
				fragmentManager.beginTransaction()
						.add(R.id.container, carFragment, CarFragment.TAG)
						.commit();
			}

			if (fragmentManager.findFragmentByTag(DescriptionFragment.TAG) == null)
			{
				fragmentManager.beginTransaction()
						.add(R.id.container, descriptionFragment, DescriptionFragment.TAG)
						.commit();
			}
		}
		else
		{
			if (fragmentManager.findFragmentByTag(CarFragment.TAG) == null)
			{
				fragmentManager.beginTransaction()
						.add(R.id.container, carFragment, CarFragment.TAG)
						.commit();
			}

			if (fragmentManager.findFragmentByTag(DescriptionFragment.TAG) != null)
			{
				fragmentManager.beginTransaction()
						.remove(getSupportFragmentManager().findFragmentByTag(DescriptionFragment.TAG))
						.commit();
			}
		}
	}
}
