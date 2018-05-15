/**
 * @(#)NamexTweet.java
 *
 *
 * @author 
 * @version 1.00 2018/5/15
 */


import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY = "3SNNPQrNoFJ6wZNedLqwMEkaD";
    private final static String CONSUMER_KEY_SECRET = "m44hesCznBRUo9JK0mPwEr5mfJcIdLjhcF2LheuAbdpUETCyxW";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Hi, im  updating status again from Namex Tweet for Demo");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "sEE1Mwj8Xu2D0bTC5GxA7CMnBkDBwdUgVVn3Ry1LX462R";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "703259927033180164-ITMvosYqQHo6F3X2HemMOxf6NubwVgX";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}