package com.olegusmanov.task2;

import android.content.Context;

/**
 * Created by Олег on 14.11.2015.
 */
public enum Cars
{
	AUDI(1, R.string.url_audi,
			"Audi",
			"Германия"),
	BMW(2,
			R.string.url_bmw,
			"BMW",
			"Германия"),
	TOYOTA(3,
			R.string.url_toyota,
			"Toyota",
			"Япония"),
	MERCEDES_BENZ(4,
			R.string.url_mercedes_benz,
			"Mercedez-Benz",
			"Герамания"),
	FORD(5,
			R.string.url_ford,
			"Ford",
			"США"),
	VOLKSWAGEN(6,
			R.string.url_volkswagen,
			"Volkswagen",
			"Германия"),
	LADA(7,
			R.string.url_lada,
			"Lada",
			"Россия"),
	LEXUS(8,
			R.string.url_lexus,
			"Lexus",
			"США"),
	FERRARI(9,
			R.string.url_ferrari,
			"Ferrari",
			"Италия"),
	KIA(10,
			R.string.url_kia,
			"Kia Motors",
			"Южная Корея");

	private final int carPictureId;

	Cars(int n, int picId, String br, String co)
	{
		carNumber = n;
		carPictureId = picId;
		carCountry = co;
		carBrand = br;
	}

	public final String getName(Context context){
		return context.getString(carPictureId);
	}

	public final int carNumber;
	public final String carCountry;
	public final String carBrand;

}
