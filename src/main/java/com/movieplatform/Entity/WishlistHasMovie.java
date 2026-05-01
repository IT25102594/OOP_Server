package com.movieplatform.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "wishlist_has_movie", schema = "oop_db")
public class WishlistHasMovie {
    @EmbeddedId
    private WishlistHasMovieId id;

    //TODO [Reverse Engineering] generate columns from DB
}