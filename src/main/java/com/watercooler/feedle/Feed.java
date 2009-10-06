package com.watercooler.feedle;

import java.util.LinkedList;
import java.util.List;

public class Feed
{
    private String title;
    private String link;
    private String description;
    private String language;
    private String copyright;
    private String pubDate;
    private String lastBuildDate;
    private String category;
    private String generator;
    private String image;
    private String managingEditor;
    private String webMaster;
    private List<Entry> entries = new LinkedList<Entry>();

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getCopyright()
    {
        return copyright;
    }

    public void setCopyright(String copyright)
    {
        this.copyright = copyright;
    }

    public String getPubDate()
    {
        return pubDate;
    }

    public void setPubDate(String pubDate)
    {
        this.pubDate = pubDate;
    }

    public String getLastBuildDate()
    {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate)
    {
        this.lastBuildDate = lastBuildDate;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getGenerator()
    {
        return generator;
    }

    public void setGenerator(String generator)
    {
        this.generator = generator;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public String getManagingEditor()
    {
        return managingEditor;
    }

    public void setManagingEditor(String managingEditor)
    {
        this.managingEditor = managingEditor;
    }

    public String getWebMaster()
    {
        return webMaster;
    }

    public void setWebMaster(String webMaster)
    {
        this.webMaster = webMaster;
    }

    public List<Entry> getEntries()
    {
        return entries;
    }

    public void setEntries(List<Entry> entries)
    {
        this.entries = entries;
    }
}
