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
@Table(name = "characters")
@NoArgsConstructor
@Getter
@Setter
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private Long character_id;

    @NotNull
    private String imagen;
    @NotNull
    private String nombre;
    @NotNull
    private String edad;
    @NotNull
    private  String peso;
    @NotNull
    private String historia;

    @NotNull
    private boolean deleted = false;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // si hay un error a borrar un personaje con peliculas cambiar la cascadde a Detalles
    @JoinTable(name = "characters_movies",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movies;

    @Override
    public String toString() {
        return "Character{" +
                "character_id=" + character_id +
                ", imagen='" + imagen + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", peso='" + peso + '\'' +
                ", historia='" + historia + '\'' +
                '}';
    }
}
