package com.olegusmanov.task2;

import android.content.Context;

/**
 * Created by Олег on 14.11.2015.
 */
public enum DescriptionEnum
{
	AUDI(0, R.string.url_founder_audi,
			R.string.founder_audi,
			R.string.url_logo_audi,
			R.string.models_audi,
			R.string.money_audi),
	BMW(1,
			R.string.url_founder_bmw,
			R.string.founder_bmw,
			R.string.url_logo_bmw,
			R.string.models_bmw,
			R.string.money_bmw),
	TOYOTA(2,
			R.string.url_founder_toyota,
			R.string.founder_toyota,
			R.string.url_logo_toyota,
			R.string.models_toyota,
			R.string.money_toyota),
	MERCEDES_BENZ(3,
			R.string.url_founder_mercedes_benz,
			R.string.founder_mercedes_benz,
			R.string.url_logo_mercedes_benz,
			R.string.models_mercedes_benz,
			R.string.money_mercedes_benz),
	FORD(4,
			R.string.url_founder_ford,
			R.string.founder_ford,
			R.string.url_logo_ford,
			R.string.models_ford,
			R.string.money_ford),
	VOLKSWAGEN(5,
			R.string.url_founder_volkswagen,
			R.string.founder_volkswagen,
			R.string.url_logo_volkswagen,
			R.string.models_volkswagen,
			R.string.money_volkswagen),
	LADA(6,
			R.string.url_founder_lada,
			R.string.founder_lada,
			R.string.url_logo_lada,
			R.string.models_lada,
			R.string.money_lada),
	LEXUS(7,
			R.string.url_founder_lexus,
			R.string.founder_lexus,
			R.string.url_logo_lexus,
			R.string.models_lexus,
			R.string.money_lexus),
	FERRARI(8,
			R.string.url_founder_ferrari,
			R.string.founder_ferrari,
			R.string.url_logo_ferrari,
			R.string.models_ferrari,
			R.string.money_ferrari),
	KIA(9,
			R.string.url_founder_kia,
			R.string.founder_kia,
			R.string.url_logo_kia,
			R.string.models_kia,
			R.string.money_kia);

	private final int imageFounderId;
	private final int textFounderId;
	private final int imageLogoId;
	private final int textModelsId;
	private final int textMoneyId;

	DescriptionEnum(int n, int imf, int tf, int il, int tmod, int tmon)
	{


		descriptionNumber = n;
		imageFounderId = imf;
		textFounderId = tf;
		imageLogoId = il;
		textModelsId = tmod;
		textMoneyId = tmon;

	}

	public final int descriptionNumber;

	public final String getDescriptionImageFounder(Context context)
	{
		return context.getString(imageFounderId);
	}

	public final String getDescriptionTextFounder(Context context)
	{
		return context.getString(textFounderId);
	}

	public final String getDescriptionImageLogo(Context context)
	{
		return context.getString(imageLogoId);
	}

	public final String getDescriptionTextModels(Context context)
	{
		return context.getString(textModelsId);
	}

	public final String getDescriptionTextMoney(Context context)
	{
		return context.getString(textMoneyId);
	}
}
