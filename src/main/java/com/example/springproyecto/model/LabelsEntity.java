package com.example.springproyecto.model;

import jakarta.persistence.*;

@Entity
@Table(name = "labels", schema = "pitchfork", catalog = "")
public class LabelsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "labelid")
    private int labelid;
    @Basic
    @Column(name = "reviewid")
    private Integer reviewid;
    @Basic
    @Column(name = "label")
    private String label;

    public int getLabelid() {
        return labelid;
    }

    public void setLabelid(int labelid) {
        this.labelid = labelid;
    }

    public Object getReviewid() {
        return reviewid;
    }

    public void setReviewid(Integer reviewid) {
        this.reviewid = reviewid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LabelsEntity that = (LabelsEntity) o;

        if (labelid != that.labelid) return false;
        if (reviewid != null ? !reviewid.equals(that.reviewid) : that.reviewid != null) return false;
        if (label != null ? !label.equals(that.label) : that.label != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = labelid;
        result = 31 * result + (reviewid != null ? reviewid.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        return result;
    }
}
