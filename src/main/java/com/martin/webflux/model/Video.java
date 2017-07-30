package com.martin.webflux.model;

import java.util.HashMap;
import java.util.Map;

public class Video
{
    private Integer unit;
    private Integer showId;
    private String showTitle;
    private String releaseYear;
    private String rating;
    private String category;
    private String showCast;
    private String director;
    private String summary;
    private String poster;
    private Integer mediatype;
    private String runtime;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public Integer getUnit()
    {
        return unit;
    }

    public void setUnit(Integer unit)
    {
        this.unit = unit;
    }

    public Integer getShowId()
    {
        return showId;
    }

    public void setShowId(Integer showId)
    {
        this.showId = showId;
    }

    public String getShowTitle()
    {
        return showTitle;
    }

    public void setShowTitle(String showTitle)
    {
        this.showTitle = showTitle;
    }

    public String getReleaseYear()
    {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear)
    {
        this.releaseYear = releaseYear;
    }

    public String getRating()
    {
        return rating;
    }

    public void setRating(String rating)
    {
        this.rating = rating;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getShowCast()
    {
        return showCast;
    }

    public void setShowCast(String showCast)
    {
        this.showCast = showCast;
    }

    public String getDirector()
    {
        return director;
    }

    public void setDirector(String director)
    {
        this.director = director;
    }

    public String getSummary()
    {
        return summary;
    }

    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    public String getPoster()
    {
        return poster;
    }

    public void setPoster(String poster)
    {
        this.poster = poster;
    }

    public Integer getMediatype()
    {
        return mediatype;
    }

    public void setMediatype(Integer mediatype)
    {
        this.mediatype = mediatype;
    }

    public String getRuntime()
    {
        return runtime;
    }

    public void setRuntime(String runtime)
    {
        this.runtime = runtime;
    }

    public Map<String, Object> getAdditionalProperties()
    {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value)
    {
        this.additionalProperties.put(name, value);
    }

}