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

import de.hybris.hackathon.ratingreviews.OAuthToken;
import de.hybris.hackathon.ratingreviews.api.generated.documentrepository.DocumentRepositoryClient;
import de.hybris.hackathon.ratingreviews.api.generated.oauth.OAuth2AuthorizationServerClient;

import com.hybris.patterns.schemas.ResourceLocation;

import java.util.logging.Logger;

import javax.inject.Singleton;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.filter.LoggingFilter;
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

	private final String CLIENT = "dopeyhackaton.ratings-reviews";


	/* GET / */
	@Override
	public Response get(final YaasAwareParameters yaasAware, final java.lang.String tenant)
	{
		// place some logic here

		final DocumentRepositoryClient client = getDocumentRepositoryClient();
		final Response response = client.tenant(tenant).clientData(CLIENT).type("reviews")
				.prepareGet().withAuthorization(getOAuthAccessToken(tenant))
				.execute();
		if (response.getStatus() == Response.Status.OK.getStatusCode())
		{
			// final Map<String, Object> repoDocument = response.readEntity(Map.class);
			// final Review review = new Review();
			// review.setComment(repoDocument.get(""));
			// final GenericType<ArrayList<Review>> reviewListType = new GenericType<ArrayList<Review>>()
			// {};
			// final ArrayList<Review> reviews = response.readEntity(reviewListType);
			// return Response.ok(reviews).build();
			return response;
		}
		throw new InternalServerErrorException();
	}

	/* POST / */
	@Override
	public Response post(final YaasAwareParameters yaasAware, final java.lang.String tenant, final Review review)
	{
		// place some logic here
		final DocumentRepositoryClient client = getDocumentRepositoryClient();
		final Response response = client.tenant(tenant).clientData(CLIENT).type("reviews")
				.preparePost().withAuthorization(getOAuthAccessToken(yaasAware.getHybrisTenant()))
				.withPayload(Entity.json(review)).execute();
		if (response.getStatus() == Response.Status.CREATED.getStatusCode())
		{
			final ResourceLocation location = response.readEntity(ResourceLocation.class);
			return Response.created(location.getLink()).build();
		}
		throw new InternalServerErrorException();
	}

	/* GET /{reviewId} */
	@Override
	public Response getByReviewId(final YaasAwareParameters yaasAware, final java.lang.String tenant,
			final java.lang.String reviewId)
	{
		final DocumentRepositoryClient client = getDocumentRepositoryClient();
		final Response response = client.tenant(yaasAware.getHybrisTenant()).clientData(CLIENT).type("reviews").dataId(reviewId)
				.prepareGet().withAuthorization(getOAuthAccessToken(yaasAware.getHybrisTenant()))
				.execute();
		if (response.getStatus() == Response.Status.OK.getStatusCode())
		{
			final Review review = response.readEntity(Review.class);
			return Response.ok(review).build();
		}
		throw new InternalServerErrorException();
	}

	/* PUT /{reviewId} */
	@Override
	public Response putByReviewId(final YaasAwareParameters yaasAware, final java.lang.String tenant,
			final java.lang.String reviewId, final Review review)
	{
		// place some logic here
		final DocumentRepositoryClient client = getDocumentRepositoryClient();
		final Response response = client.tenant(tenant).clientData(CLIENT).type("reviews").dataId(reviewId)
				.preparePut().withAuthorization(getOAuthAccessToken(yaasAware.getHybrisTenant()))
				.withPayload(Entity.json(review)).execute();
		// if (response.getStatus() == Response.Status.OK.getStatusCode())
		// {
		// final ResourceLocation location = response.readEntity(ResourceLocation.class);
		// return Response.created(location.getLink()).build();
		// }
		// throw new InternalServerErrorException();
		return response;
	}

	/* DELETE /{reviewId} */
	@Override
	public Response deleteByReviewId(final YaasAwareParameters yaasAware, final java.lang.String tenant,
			final java.lang.String reviewId)
	{
		final DocumentRepositoryClient client = getDocumentRepositoryClient();
		final Response response = client.tenant(tenant).clientData(CLIENT).type("reviews").dataId(reviewId)
				.prepareDelete().withAuthorization(getOAuthAccessToken(tenant))
				.execute();

		if (response.getStatus() == Response.Status.NO_CONTENT.getStatusCode())
		{

			return Response.noContent().build();
		}
		throw new InternalServerErrorException();
	}

	private String getOAuthAccessToken(final String tenant)
	{

		final OAuth2AuthorizationServerClient oAuthClient = new OAuth2AuthorizationServerClient(
				OAuth2AuthorizationServerClient.DEFAULT_BASE_URI, ClientBuilder.newClient()
						.register(
								new LoggingFilter(Logger.getLogger(OAuth2AuthorizationServerClient.class.getCanonicalName()),
										true)));

		final Form form = new Form();
		form.param("client_id", "kjAMBN3efLDmEjO3GR7GrHjqK6v6DdZ6");
		form.param("client_secret", "C8gR4MMhgylkFK64");
		form.param("grant_type", "client_credentials");
		form.param("scope", "hybris.tenant=" + tenant + " FULL_ACCESS");

		final Entity<Form> entity = Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE);
		final Response response = oAuthClient.token().preparePost().withPayload(entity).execute();
		final OAuthToken token = response.readEntity(OAuthToken.class);
		return token.getTokenType() + " " + token.getAccessToken();
	}

	private DocumentRepositoryClient getDocumentRepositoryClient()
	{
		return new DocumentRepositoryClient(DocumentRepositoryClient.DEFAULT_BASE_URI,
				ClientBuilder.newClient()
						.register(
								new LoggingFilter(Logger.getLogger(DocumentRepositoryClient.class.getCanonicalName()),
										true)));
	}

	private Review readReview(final Response response)
	{
		return null;
	}
}
