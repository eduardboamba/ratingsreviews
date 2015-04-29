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

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Assert;
import org.junit.Test;


public final class DefaultTenantReviewsResourceTest extends AbstractResourceTest
{
	/**
	 * Server side root resource /{tenant}/reviews,
	 * evaluated with some default value(s).
	 */
	private static final String ROOT_RESOURCE_PATH = "/tenant/reviews";

	/* get() /tenant/reviews */
	@Test
	public void testGet()
	{
		final WebTarget target = getRootTarget(ROOT_RESOURCE_PATH).path("");

		final Response response = target.request().get();

		Assert.assertNotNull("Response must not be null", response);
		Assert.assertEquals("Response does not have expected response code", Status.OK.getStatusCode(), response.getStatus());
	}

	/* post(entity) /tenant/reviews */
	@Test
	public void testPostWithReview()
	{
		final WebTarget target = getRootTarget(ROOT_RESOURCE_PATH).path("");
		final Review entityBody =
				new Review();
		final javax.ws.rs.client.Entity<Review> entity =
				javax.ws.rs.client.Entity.entity(entityBody, "application/json");

		final Response response = target.request().post(entity);

		Assert.assertNotNull("Response must not be null", response);
		Assert.assertEquals("Response does not have expected response code", Status.CREATED.getStatusCode(), response.getStatus());
	}

	/* get() /tenant/reviews/reviewId */
	@Test
	public void testGetByReviewId()
	{
		final WebTarget target = getRootTarget(ROOT_RESOURCE_PATH).path("/reviewId");

		final Response response = target.request().get();

		Assert.assertNotNull("Response must not be null", response);
		Assert.assertEquals("Response does not have expected response code", Status.OK.getStatusCode(), response.getStatus());
	}

	/* put(entity) /tenant/reviews/reviewId */
	@Test
	public void testPutByReviewIdWithReview()
	{
		final WebTarget target = getRootTarget(ROOT_RESOURCE_PATH).path("/reviewId");
		final Review entityBody =
				new Review();
		final javax.ws.rs.client.Entity<Review> entity =
				javax.ws.rs.client.Entity.entity(entityBody, "application/json");

		final Response response = target.request().put(entity);

		Assert.assertNotNull("Response must not be null", response);
		Assert.assertEquals("Response does not have expected response code", Status.OK.getStatusCode(), response.getStatus());
	}

	/* delete() /tenant/reviews/reviewId */
	@Test
	public void testDeleteByReviewId()
	{
		final WebTarget target = getRootTarget(ROOT_RESOURCE_PATH).path("/reviewId");

		final Response response = target.request().delete();

		Assert.assertNotNull("Response must not be null", response);
		Assert.assertEquals("Response does not have expected response code", Status.NO_CONTENT.getStatusCode(),
				response.getStatus());
	}

	@Override
	protected ResourceConfig configureApplication()
	{
		final ResourceConfig application = new ResourceConfig();
		application.register(DefaultTenantReviewsResource.class);
		return application;
	}
}
