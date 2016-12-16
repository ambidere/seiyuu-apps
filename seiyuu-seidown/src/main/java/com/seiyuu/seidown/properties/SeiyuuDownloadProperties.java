package com.seiyuu.seidown.properties;

/**
 * Created by ambidere on 12/16/16.
 */
public class SeiyuuDownloadProperties
{
    private String url;

    private int firstPage = -1;

    private int lastPage = -1;

    private int numberOfPages = -1;

    public SeiyuuDownloadProperties( String url )
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }

    public void setFirstPage(int firstPage)
    {
        this.firstPage = firstPage;
    }

    public int getFirstPage()
    {
        return firstPage;
    }

    public void setLastPage(int lastPage)
    {
        this.lastPage = lastPage;
    }

    public int getLastPage()
    {
        return lastPage;
    }

    public void setNumberOfPages(int numberOfPages)
    {
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfPages()
    {
        if ( numberOfPages < 0 )
        {
            numberOfPages = lastPage - firstPage + 1;
        }
        return numberOfPages;
    }
}
