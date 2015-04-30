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

import java.util.logging.Logger;

import javax.inject.Singleton;
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

		final DocumentRepositoryClient client = new DocumentRepositoryClient(DocumentRepositoryClient.DEFAULT_BASE_URI,
				ClientBuilder.newClient()
						.register(
								new LoggingFilter(Logger.getLogger(DocumentRepositoryClient.class.getCanonicalName() + ".jersey"),
										true)));
		final Response response = client.tenant(yaasAware.getHybrisTenant()).clientData(CLIENT).type("reviews")
				.prepareGet().withAuthorization(getOAuthAccessToken(yaasAware.getHybrisTenant()))
				.execute();
		return response;
	}

	/* POST / */
	@Override
	public Response post(final YaasAwareParameters yaasAware, final java.lang.String tenant, final Review review)
	{
		// place some logic here
		final DocumentRepositoryClient client = new DocumentRepositoryClient(DocumentRepositoryClient.DEFAULT_BASE_URI);
		final Response response = client.tenant(yaasAware.getHybrisClient()).clientData(CLIENT).type("reviews")
				.preparePost().withAuthorization(getOAuthAccessToken(yaasAware.getHybrisTenant()))
				.withPayload(Entity.json(review)).execute();
		return response;
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

	private String getOAuthAccessToken(final String tenant)
	{

		final OAuth2AuthorizationServerClient oAuthClient = new OAuth2AuthorizationServerClient(
				OAuth2AuthorizationServerClient.DEFAULT_BASE_URI, ClientBuilder.newClient()
						.register(
								new LoggingFilter(Logger.getLogger(OAuth2AuthorizationServerClient.class.getCanonicalName() + ".jersey"),
										true)));
		final Form form = new Form();
		form.param("client_id", "kjAMBN3efLDmEjO3GR7GrHjqK6v6DdZ6");
		form.param("client_secret", "C8gR4MMhgylkFK64");
		form.param("grant_type", "client_credentials");
		// form.param("hybris-tenant", tenant);
		form.param("scope", "hybris.tenant=" + tenant + " FULL_ACCESS");
		final Entity<Form> entity = Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE);
		final Response response = oAuthClient.token().preparePost().withPayload(entity).execute();
		final OAuthToken token = response.readEntity(OAuthToken.class);
		return "Bearer " + token.getAccessToken();
	}
}
