package com.example.springproyecto.model;

import jakarta.persistence.*;

@Entity
@Table(name = "years", schema = "pitchfork", catalog = "")
public class YearsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "yearid")
    private int yearid;
    @Basic
    @Column(name = "reviewid")
    private Integer reviewid;
    @Basic
    @Column(name = "year")
    private String year;

    public int getYearid() {
        return yearid;
    }

    public void setYearid(int yearid) {
        this.yearid = yearid;
    }

    public Object getReviewid() {
        return reviewid;
    }

    public void setReviewid(Integer reviewid) {
        this.reviewid = reviewid;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YearsEntity that = (YearsEntity) o;

        if (yearid != that.yearid) return false;
        if (reviewid != null ? !reviewid.equals(that.reviewid) : that.reviewid != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = yearid;
        result = 31 * result + (reviewid != null ? reviewid.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }
}
