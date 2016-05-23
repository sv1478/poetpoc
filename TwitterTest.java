package com.sample.twitter;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterTest {

	public static void main(String[] args) {

		ConfigurationBuilder cb = new ConfigurationBuilder();

		cb.setDebugEnabled(true).setOAuthConsumerKey("GT4ohpMEZnYVs9WTbmPagtkby")
				.setOAuthConsumerSecret("st13M5kOFWk2qoKuK1uYnKe87NrVUVxaEntRUPyCCDuyPRym0e")
				.setOAuthAccessToken("734077242226147328-4qUrYAN1ghXosreDTH6g35Tolr7onxA")
				.setOAuthAccessTokenSecret("BCikWp2E35Lo3RaC1OG8YK8rBOQqqqf6EFstnoUXYx5Tx");

		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();

		try {
			twitter.verifyCredentials();

			Query query = new Query("Penguin Random");
			QueryResult result;
			do {
				result = twitter.search(query);
				List<Status> tweets = result.getTweets();
				for (Status tweet : tweets) {
					System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
				}
			} while ((query = result.nextQuery()) != null);

		} catch (TwitterException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
