package com.watercooler.feedle;

public class FeedParserException extends Exception
{
    public FeedParserException(String s)
    {
        super(s);
    }

    public FeedParserException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public FeedParserException(Throwable throwable)
    {
        super(throwable);
    }
}
