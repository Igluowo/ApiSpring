package com.example.springproyecto.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reviews", schema = "pitchfork", catalog = "")
public class ReviewsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "reviewid")
    private Integer reviewid;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "artist")
    private String artist;
    @Basic
    @Column(name = "url")
    private String url;
    @Basic
    @Column(name = "score")
    private BigDecimal score;
    @Basic
    @Column(name = "best_new_music")
    private Byte bestNewMusic;
    @Basic
    @Column(name = "author")
    private String author;
    @Basic
    @Column(name = "author_type")
    private String authorType;
    @Basic
    @Column(name = "pub_date")
    private String pubDate;
    @Basic
    @Column(name = "pub_weekday")
    private Byte pubWeekday;
    @Basic
    @Column(name = "pub_day")
    private Byte pubDay;
    @Basic
    @Column(name = "pub_month")
    private Byte pubMonth;
    @Basic
    @Column(name = "pub_year")
    private Short pubYear;

    public Object getReviewid() {
        return reviewid;
    }

    public void setReviewid(Integer reviewid) {
        this.reviewid = reviewid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Byte getBestNewMusic() {
        return bestNewMusic;
    }

    public void setBestNewMusic(Byte bestNewMusic) {
        this.bestNewMusic = bestNewMusic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorType() {
        return authorType;
    }

    public void setAuthorType(String authorType) {
        this.authorType = authorType;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public Byte getPubWeekday() {
        return pubWeekday;
    }

    public void setPubWeekday(Byte pubWeekday) {
        this.pubWeekday = pubWeekday;
    }

    public Byte getPubDay() {
        return pubDay;
    }

    public void setPubDay(Byte pubDay) {
        this.pubDay = pubDay;
    }

    public Byte getPubMonth() {
        return pubMonth;
    }

    public void setPubMonth(Byte pubMonth) {
        this.pubMonth = pubMonth;
    }

    public Short getPubYear() {
        return pubYear;
    }

    public void setPubYear(Short pubYear) {
        this.pubYear = pubYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReviewsEntity that = (ReviewsEntity) o;

        if (reviewid != null ? !reviewid.equals(that.reviewid) : that.reviewid != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (artist != null ? !artist.equals(that.artist) : that.artist != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;
        if (bestNewMusic != null ? !bestNewMusic.equals(that.bestNewMusic) : that.bestNewMusic != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (authorType != null ? !authorType.equals(that.authorType) : that.authorType != null) return false;
        if (pubDate != null ? !pubDate.equals(that.pubDate) : that.pubDate != null) return false;
        if (pubWeekday != null ? !pubWeekday.equals(that.pubWeekday) : that.pubWeekday != null) return false;
        if (pubDay != null ? !pubDay.equals(that.pubDay) : that.pubDay != null) return false;
        if (pubMonth != null ? !pubMonth.equals(that.pubMonth) : that.pubMonth != null) return false;
        if (pubYear != null ? !pubYear.equals(that.pubYear) : that.pubYear != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reviewid != null ? reviewid.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (bestNewMusic != null ? bestNewMusic.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (authorType != null ? authorType.hashCode() : 0);
        result = 31 * result + (pubDate != null ? pubDate.hashCode() : 0);
        result = 31 * result + (pubWeekday != null ? pubWeekday.hashCode() : 0);
        result = 31 * result + (pubDay != null ? pubDay.hashCode() : 0);
        result = 31 * result + (pubMonth != null ? pubMonth.hashCode() : 0);
        result = 31 * result + (pubYear != null ? pubYear.hashCode() : 0);
        return result;
    }
}
