package com.bbva.apimoviespring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name ="genres")
@NoArgsConstructor
@Getter
@Setter
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Long genre_id;
    @NotNull
    private String name;
    @NotNull
    private String image;

    @NotNull
    private boolean deleted = false;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;



    @JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "genres_movies",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movies;

    @Override
    public String toString() {
        return "Genre{" +
                "genre_id=" + genre_id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", deleted=" + deleted +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", movies=" + movies +
                '}';
    }
}
