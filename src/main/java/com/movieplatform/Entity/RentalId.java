package com.movieplatform.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class RentalId implements Serializable {
    private static final long serialVersionUID = 3977332003027119918L;
    @NotNull
    @Column(name = "users_id", nullable = false)
    private Integer usersId;

    @NotNull
    @Column(name = "movies_id", nullable = false)
    private Integer moviesId;


}