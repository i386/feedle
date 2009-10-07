package com.watercooler.feedle.rss;

import com.watercooler.feedle.Entry;
import com.watercooler.feedle.Feed;
import com.watercooler.feedle.FeedParser;
import com.watercooler.feedle.FeedParserException;
import org.kxml2.io.KXmlParser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RSSParser implements FeedParser
{
    public Feed parse(final InputStream inputStream) throws FeedParserException, IOException
    {
        final Feed feed = new Feed();
        final KXmlParser parser = new KXmlParser();

        try
        {
            parser.setInput(new InputStreamReader(inputStream));
            parser.nextTag();

            parser.require(XmlPullParser.START_TAG, null, "rss");
            parser.nextTag();

            parser.require(XmlPullParser.START_TAG, null, "channel");
            parser.nextTag();

            parseChannel(feed, parser);
        }
        catch (XmlPullParserException e)
        {
            throw new FeedParserException(e.getMessage(), e);
        }

        return feed;
    }

    private void parseChannel(Feed feed, KXmlParser parser)
            throws XmlPullParserException, IOException
    {
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
            else if ("item".endsWith(nodeName))
            {
                parseItem(feed, parser);
            }
            else if ("image".endsWith(nodeName))
            {
                feed.setImage(parser.nextText());
            }
            else
            {
                parser.skipSubTree();
            }
            parser.nextTag();
        }
    }

    private void parseItem(Feed feed, KXmlParser parser) throws IOException, XmlPullParserException
    {
        final Entry entry = new Entry();
        feed.getEntries().add(entry);

        parser.nextTag();

        while (parser.getEventType() != XmlPullParser.END_TAG)
        {
            final String nodeName = parser.getName();

            if ("title".equals(nodeName))
            {
                entry.setTitle(parser.nextText());
            }
            else if ("link".equals(nodeName))
            {
                entry.setLink(parser.nextText());
            }
            else if ("description".equals(nodeName))
            {
                entry.setDescription(parser.nextText());
            }
            else if ("author".equals(nodeName))
            {
                entry.setAuthor(parser.nextText());
            }
            else if ("category".equals(nodeName))
            {
                entry.setCategory(parser.nextText());
            }
            else if ("comments".equals(nodeName))
            {
                entry.setComments(parser.nextText());
            }
            else if ("enclosure".equals(nodeName))
            {
                entry.setEnclosure(parser.nextText());
            }
            else if ("guid".equals(nodeName))
            {
                entry.setGuid(parser.nextText());
            }
            else if ("pubDate".equals(nodeName))
            {
                entry.setPubDate(parser.nextText());
            }
            else if ("source".equals(nodeName))
            {
                entry.setSource(parser.nextText());
            }
            else
            {
                parser.skipSubTree();
            }
            parser.nextTag();
        }
    }
}
