package com.movieplatform.Repository;

import com.movieplatform.Entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByGmail(@Size(max = 45) @NotNull String gmail);
}
