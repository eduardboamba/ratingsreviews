/*
 * [y] hybris Platform
 * 
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 */
package de.hybris.hackathon.ratingreviews;


import de.hybris.hackathon.ratingreviews.api.generated.ApiFeature;

import com.hybris.api.console.web.ApiConsoleFeature;
import com.hybris.jersey.features.BeanValidationFeature;
import com.hybris.jersey.features.JerseyFeature;
import com.hybris.jersey.features.JsonFeature;
import com.hybris.jersey.features.SecurityFeature;
import com.hybris.monitoring.status.endpoint.StatusFeature;

import org.glassfish.jersey.server.ResourceConfig;


/**
 * Defines the REST application.
 */
public class JerseyApplication extends ResourceConfig
{
	/**
	 * Initialized the jersey application.
	 */
	public JerseyApplication()
	{
		// enable error responses in JSON format
		register(JerseyFeature.class);

		// enable JSON support
		register(JsonFeature.class);

		// hybris-scopes support for @RolesAllowed
		register(SecurityFeature.class);

		// bean validation support
		register(BeanValidationFeature.class);

		// enable api-console
		register(ApiConsoleFeature.class);

		// application status page
		register(StatusFeature.class);

		// enable custom resources
		register(ApiFeature.class);
	}
}
