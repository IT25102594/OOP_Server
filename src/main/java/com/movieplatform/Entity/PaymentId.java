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
public class PaymentId implements Serializable {
    private static final long serialVersionUID = 2046932496740177522L;
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "rentals_users_id", nullable = false)
    private Integer rentalsUsersId;

    @NotNull
    @Column(name = "rentals_movies_id", nullable = false)
    private Integer rentalsMoviesId;


}