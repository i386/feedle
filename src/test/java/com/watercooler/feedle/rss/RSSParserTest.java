package com.watercooler.feedle.rss;

import com.watercooler.feedle.Feed;
import com.watercooler.feedle.FeedParser;
import junit.framework.TestCase;

import java.io.InputStream;

/**
 * Tests here test the sample files from the RSS spec website
 *
 * http://cyber.law.harvard.edu/rss/rss.html
 */
public class RSSParserTest extends TestCase
{
    private static final String RSS2_SAMPLE = "/com/watercooler/feedle/rss/rss2sample.xml.rss";

    public void testRSS2Sample() throws Exception
    {
        InputStream inputStream = getClass().getResourceAsStream(RSS2_SAMPLE);
        FeedParser feedParser = new RSSParser();
        Feed feed = feedParser.parse(inputStream);
        
        assertEquals("Liftoff News", feed.getTitle());
        assertEquals("Liftoff to Space Exploration.", feed.getDescription());
        assertEquals("en-us", feed.getLanguage());
        assertEquals("Tue, 10 Jun 2003 04:00:00 GMT", feed.getPubDate());
        assertEquals("Tue, 10 Jun 2003 09:41:01 GMT", feed.getLastBuildDate());
        assertEquals("Weblog Editor 2.0", feed.getGenerator());
        assertEquals("editor@example.com", feed.getManagingEditor());
        assertEquals("webmaster@example.com", feed.getWebMaster());
        assertEquals("http://to/my/image.png", feed.getImage());

        assertEquals(4, feed.getEntries().size());
    }
}
