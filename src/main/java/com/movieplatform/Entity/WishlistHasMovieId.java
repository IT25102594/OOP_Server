package com.movieplatform.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter@EqualsAndHashCode
@Embeddable
public class WishlistHasMovieId implements Serializable {
    private static final long serialVersionUID = 3173434818491058446L;
    @NotNull
    @Column(name = "wishlist_id", nullable = false)
    private Integer wishlistId;

    @NotNull
    @Column(name = "movie_id", nullable = false)
    private Integer movieId;


}