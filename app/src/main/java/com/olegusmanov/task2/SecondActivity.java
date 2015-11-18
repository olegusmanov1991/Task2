package com.olegusmanov.task2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;

/**
 * Created by Олег on 15.11.2015.
 */
public class SecondActivity extends FragmentActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		Intent intent = getIntent();
		int position = intent.getIntExtra("pos", 0);

		DescriptionFragment descriptionFragment = new DescriptionFragment();
		FragmentManager fragmentManager = getSupportFragmentManager();

		descriptionFragment.change(position);

		if (fragmentManager.findFragmentByTag(DescriptionFragment.TAG) != null)
		{
			fragmentManager.beginTransaction()
					.remove(fragmentManager.findFragmentByTag(DescriptionFragment.TAG))
					.commit();
		}

		fragmentManager.beginTransaction()
				.add(R.id.container_second, descriptionFragment, DescriptionFragment.TAG)
				.commit();
	}
}
