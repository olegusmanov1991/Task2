package com.olegusmanov.task2;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by Олег on 15.11.2015.
 */
public class SecondActivity extends FragmentActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		CarFragment carFragment = (CarFragment) getSupportFragmentManager().findFragmentByTag(CarFragment.TAG);
		DescriptionFragment descriptionFragment = (DescriptionFragment) getSupportFragmentManager().findFragmentByTag(DescriptionFragment.TAG);
		FragmentManager fragmentManager = getSupportFragmentManager();



		fragmentManager.beginTransaction()
				.remove(carFragment)
				.attach(descriptionFragment)
				.commit();

	}
}
