package com.olegusmanov.task2;

import android.content.Context;

/**
 * Created by Олег on 14.11.2015.
 */
public enum Cars
{
	AUDI(0, R.string.url_audi,
			R.string.name_audi,
			R.string.country_audi),
	BMW(1,
			R.string.url_bmw,
			R.string.name_bmw,
			R.string.country_bmw),
	TOYOTA(2,
			R.string.url_toyota,
			R.string.name_toyota,
			R.string.country_toyota),
	MERCEDES_BENZ(3,
			R.string.url_mercedes_benz,
			R.string.name_mercedes_benz,
			R.string.country_mercedes_benz),
	FORD(4,
			R.string.url_ford,
			R.string.name_ford,
			R.string.country_ford),
	VOLKSWAGEN(5,
			R.string.url_volkswagen,
			R.string.name_volkswagen,
			R.string.country_volkswagen),
	LADA(6,
			R.string.url_lada,
			R.string.name_lada,
			R.string.country_lada),
	LEXUS(7,
			R.string.url_lexus,
			R.string.name_lexus,
			R.string.country_lexus),
	FERRARI(8,
			R.string.url_ferrari,
			R.string.name_ferrari,
			R.string.country_ferrari),
	KIA(9,
			R.string.url_kia,
			R.string.name_kia,
			R.string.country_kia);

	private final int carPictureId;
	private final int carBrandId;
	private final int carCountryId;

	Cars(int n, int picId, int brId, int coId)
	{
		carNumber = n;
		carPictureId = picId;
		carCountryId = coId;
		carBrandId = brId;
	}

	public final int carNumber;
	public final String getName(Context context)
	{
		return context.getString(carPictureId);
	}
	public final String getCarCountry(Context context)
	{
		return context.getString(carCountryId);
	}
	public final String getCarBrand(Context context)
	{
		return context.getString(carBrandId);
	}
}
