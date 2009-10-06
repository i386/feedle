package com.watercooler.feedle.rss;

import com.watercooler.feedle.Feed;
import com.watercooler.feedle.FeedParser;
import org.kxml2.io.KXmlParser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RSSParser implements FeedParser
{
    public Feed parse(final InputStream inputStream) throws XmlPullParserException, IOException
    {
        final Feed feed = new Feed();
        final KXmlParser parser = new KXmlParser();

        parser.setInput(new InputStreamReader(inputStream));
        parser.nextTag();

        parser.require(XmlPullParser.START_TAG, null, "rss");
        parser.nextTag();

        parser.require(XmlPullParser.START_TAG, null, "channel");
        parser.nextTag();

        while (parser.getEventType() != XmlPullParser.END_TAG)
        {
            final String nodeName = parser.getName();
            if ("title".equals(nodeName))
            {
                feed.setTitle(parser.nextText());
            }
            else if ("link".equals(nodeName))
            {
                feed.setLink(parser.nextText());
            }
            else if ("description".equals(nodeName))
            {
                feed.setDescription(parser.nextText());
            }
            else if ("language".endsWith(nodeName))
            {
                feed.setLanguage(parser.nextText());
            }
            else if ("pubDate".endsWith(nodeName))
            {
                feed.setPubDate(parser.nextText());
            }
            else if ("lastBuildDate".endsWith(nodeName))
            {
                feed.setLastBuildDate(parser.nextText());
            }
            else if ("generator".endsWith(nodeName))
            {
                feed.setGenerator(parser.nextText());
            }
            else if ("managingEditor".endsWith(nodeName))
            {
                feed.setManagingEditor(parser.nextText());
            }
            else if ("webMaster".endsWith(nodeName))
            {
                feed.setWebMaster(parser.nextText());
            }
            else
            {
                parser.skipSubTree();
            }
            parser.nextTag();
        }
        
        return feed;
    }
}
