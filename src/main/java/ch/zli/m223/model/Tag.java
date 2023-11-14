package ch.zli.m223.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Fetch;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="TAG")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @NotBlank(message="Title may not be blank")
    @Column(nullable = false)
    private String title;

    @ManyToMany(mappedBy = "tags")
    @Fetch(FetchMode.JOIN)
    Set<Entry> entries;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Entry> getEntries() {
        return entries;
    }

    public void setEntries(Set<Entry> entries) {
        this.entries = entries;
    }


}
