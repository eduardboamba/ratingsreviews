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
package de.hybris.hackathon.ratingreviews.api.generated;

import javax.inject.Singleton;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;


/**
 * Resource class containing the custom logic. Please put your logic here!
 */
@Component("apiTenantReviewsResource")
@Singleton
public class DefaultTenantReviewsResource implements TenantReviewsResource
{
	@javax.ws.rs.core.Context
	private javax.ws.rs.core.UriInfo uriInfo;

	/* GET / */
	@Override
	public Response get(final YaasAwareParameters yaasAware, final java.lang.String tenant)
	{
		// place some logic here
		return Response.ok()
				.entity(new java.util.ArrayList<>()).build();
	}

	/* POST / */
	@Override
	public Response post(final YaasAwareParameters yaasAware, final java.lang.String tenant, final Review review)
	{
		// place some logic here
		return Response.created(uriInfo.getAbsolutePath())
				.build();
	}

	/* GET /{reviewId} */
	@Override
	public Response getByReviewId(final YaasAwareParameters yaasAware, final java.lang.String tenant,
			final java.lang.String reviewId)
	{
		// place some logic here
		return Response.ok()
				.entity(new Review()).build();
	}

	/* PUT /{reviewId} */
	@Override
	public Response putByReviewId(final YaasAwareParameters yaasAware, final java.lang.String tenant,
			final java.lang.String reviewId, final Review review)
	{
		// place some logic here
		return Response.ok()
				.build();
	}

	/* DELETE /{reviewId} */
	@Override
	public Response deleteByReviewId(final YaasAwareParameters yaasAware, final java.lang.String tenant,
			final java.lang.String reviewId)
	{
		// place some logic here
		return Response.noContent()
				.build();
	}

}
