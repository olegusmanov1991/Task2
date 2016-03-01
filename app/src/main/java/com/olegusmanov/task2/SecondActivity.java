package com.olegusmanov.task2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.bumptech.glide.Glide;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by Олег on 15.11.2015 at 19:23.
 * Project Task2
 */
public class SecondActivity extends FragmentActivity
{
	public static final String KEY_POS = "pos";
	public static boolean sOnSecondActivityCreated = false;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		Intent intent = getIntent();
		int position = intent.getIntExtra(KEY_POS, 0);

		DescriptionFragment descriptionFragment = new DescriptionFragment();
		FragmentManager fragmentManager = getSupportFragmentManager();

		descriptionFragment.change(position);
		sOnSecondActivityCreated = true;


		if (getResources().getBoolean(R.bool.screen_width))
		{
			Intent intent1 = new Intent(SecondActivity.this, MainActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK);
			startActivity(intent1);
		}
		else
		{
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

}
