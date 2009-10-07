package com.watercooler.feedle;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

public interface FeedParser
{
    Feed parse(InputStream inputStream) throws FeedParserException, IOException;
}
