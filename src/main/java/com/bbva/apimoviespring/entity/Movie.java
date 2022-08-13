package com.bbva.apimoviespring.entity;

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
@Table(name = "movies")
@NoArgsConstructor
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long movie_id;
    @NotNull
    private String title;

    @NotNull
    private String image_url;
    @NotNull
    private Long year;
    @NotNull
    private Long score;

    @NotNull
    private boolean deleted = false;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    private List<Character> characters;
    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    private List<Genre> genres;

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", title='" + title + '\'' +
                ", image_url='" + image_url + '\'' +
                ", year=" + year +
                ", score=" + score +
                ", deleted=" + deleted +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", characters=" + characters +
                ", genres=" + genres +
                '}';
    }
}
