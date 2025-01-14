package ch.zli.m223.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Fetch;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="ENTRY")
public class Entry {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  @Column(nullable = false)
  private LocalDateTime checkIn;

  @Column(nullable = false)
  private LocalDateTime checkOut;

  @ManyToOne(optional = true)
  @Fetch(FetchMode.JOIN)
  private Category category;

  @ManyToOne(optional = true)
  @Fetch(FetchMode.JOIN)
  private ApplicationUser applicationUser;
  
  @ManyToMany
  @JoinTable(
  name = "entry_tags", 
  joinColumns = @JoinColumn(name = "entry_id"), 
  inverseJoinColumns = @JoinColumn(name = "tag_id"))
  Set<Tag> tags;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getCheckIn() {
    return checkIn;
  }

  public void setCheckIn(LocalDateTime checkIn) {
    this.checkIn = checkIn;
  }

  public LocalDateTime getCheckOut() {
    return checkOut;
  }

  public void setCheckOut(LocalDateTime checkOut) {
    this.checkOut = checkOut;
  }
}