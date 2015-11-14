package com.olegusmanov.task2;

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
		DescriptionFragment fragmentByTag = (DescriptionFragment) getSupportFragmentManager().findFragmentByTag(DescriptionFragment.TAG);
		fragmentByTag.change(position);

		DisplayMetrics mDisplayMetrics = getResources().getDisplayMetrics();
		if (mDisplayMetrics.widthPixels < 720)
		{
			Intent intent = new Intent(MainActivity.this, SecondActivity.class);
			startActivity(intent);
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
			if (fragmentManager.findFragmentByTag(carFragment.TAG) == null)
			{
				fragmentManager.beginTransaction()
						.add(R.id.container, carFragment, carFragment.TAG)
						.commit();
			}

			if (fragmentManager.findFragmentByTag(descriptionFragment.TAG) == null)
			{
				fragmentManager.beginTransaction()
						.add(R.id.container, descriptionFragment, descriptionFragment.TAG)
						.commit();
			}
		}
		else
		{
			if (fragmentManager.findFragmentByTag(carFragment.TAG) == null)
			{
				fragmentManager.beginTransaction()
						.add(R.id.container, carFragment, carFragment.TAG)
						.commit();
			}

			if (fragmentManager.findFragmentByTag(descriptionFragment.TAG) != null)
			{
				fragmentManager.beginTransaction()
						.add(R.id.container, descriptionFragment, DescriptionFragment.TAG)
						.detach(descriptionFragment)
						.commit();
			}
		}
	}
}
