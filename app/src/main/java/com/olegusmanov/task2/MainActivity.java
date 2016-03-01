package com.olegusmanov.task2;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends FragmentActivity implements ItemClickListener
{
	public static int sPositionTurn;

	@Override
	public void onItemClick(int position)
	{
		if (!getResources().getBoolean(R.bool.screen_width))
		{
			Intent intent = new Intent(MainActivity.this, SecondActivity.class);
			intent.putExtra(SecondActivity.KEY_POS, position);
			startActivity(intent);
		}
		else
		{
			DescriptionFragment fragmentByTag = (DescriptionFragment) getSupportFragmentManager().findFragmentByTag(DescriptionFragment.TAG);
			fragmentByTag.init(position);
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


		if (getResources().getBoolean(R.bool.screen_width))
		{
			if (fragmentManager.findFragmentByTag(CarFragment.TAG) == null)
			{
				fragmentManager.beginTransaction()
						.add(R.id.container, carFragment, CarFragment.TAG)
						.commit();
			}

			if (fragmentManager.findFragmentByTag(DescriptionFragment.TAG) == null)
			{
				descriptionFragment.change(sPositionTurn);
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


				Intent intent1 = new Intent(MainActivity.this, SecondActivity.class);
				intent1.putExtra(SecondActivity.KEY_POS, sPositionTurn);
				startActivity(intent1);
			}
		}
	}
}
