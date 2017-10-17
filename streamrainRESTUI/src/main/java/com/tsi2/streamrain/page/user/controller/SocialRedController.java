package com.tsi2.streamrain.page.user.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.oauth1.AuthorizedRequestToken;
import org.springframework.social.oauth1.OAuth1Operations;
import org.springframework.social.oauth1.OAuth1Parameters;
import org.springframework.social.oauth1.OAuthToken;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SocialRedController {
			
	@RequestMapping(value = "/{tenant}/auth/twitter", method = RequestMethod.GET)
	public String showLogin(HttpServletRequest request, HttpServletResponse response) {
		try {
			Resource resource = new ClassPathResource("/application.properties");
			Properties props = PropertiesLoaderUtils.loadProperties(resource);
			String twitterKey = props.getProperty("twitter.consumer.key");
			String twitterSecret = props.getProperty("twitter.consumer.secret");
					
			TwitterConnectionFactory connectionFactoryTwitter = new TwitterConnectionFactory(twitterKey,twitterSecret);
			
			OAuth1Operations oauth1Operations = connectionFactoryTwitter.getOAuthOperations();
						 
			OAuth1Parameters oAuth1Parameters=new OAuth1Parameters();
			 
			OAuthToken requestToken=oauth1Operations.fetchRequestToken("http://127.0.0.1:8080/streamrainRESTUI/auth/twitter/callback",null);
			 
			String authorizeUrl = oauth1Operations.buildAuthorizeUrl(requestToken.getValue(),oAuth1Parameters);
						
			return "redirect:"+authorizeUrl;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/auth/twitter/callback", method = RequestMethod.GET)
	public ModelAndView twitterCallback(@RequestParam(value="oauth_token", required=false) String oauthToken,
			@RequestParam(value="oauth_verifier", required=false) String oauthVerifier, WebRequest request) {
		try {			
			Resource resource = new ClassPathResource("/application.properties");
			Properties props = PropertiesLoaderUtils.loadProperties(resource);
			String twitterKey = props.getProperty("twitter.consumer.key");
			String twitterSecret = props.getProperty("twitter.consumer.secret");
			
		
			TwitterConnectionFactory connectionFactoryTwitter = new TwitterConnectionFactory(twitterKey,twitterSecret);
			
			OAuth1Operations oauth1Operations = connectionFactoryTwitter.getOAuthOperations();
			
			OAuthToken requestToken = new OAuthToken(oauthToken, null);
			
			OAuthToken accessToken = oauth1Operations.exchangeForAccessToken(new AuthorizedRequestToken(requestToken, oauthVerifier), null);
	
			Connection<Twitter> connection = connectionFactoryTwitter.createConnection(accessToken);
	
			Twitter twitter = connection != null ? connection.getApi() : new TwitterTemplate(accessToken.getValue());
	
			TwitterProfile twitterProfile=twitter.userOperations().getUserProfile();
				
			ConnectionKey connectionKey=connection.getKey();
			
			String name = connection.getDisplayName();
			
		    ModelAndView mav = null;
		    	    
	    	mav = new ModelAndView("welcome");
	        mav.addObject("firstname", name);
		    
		    return mav;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
