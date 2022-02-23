package com.epam.spring.library.repository;

import com.epam.spring.library.exception.EntityNotFoundException;
import com.epam.spring.library.model.User;
import com.epam.spring.library.model.User.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Predicate;

import static com.epam.spring.library.model.User.State.DELETED;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Page<User> findTop10ByStateNot(State state, Pageable pageable);

    default User getActiveUser(String email) {
        return findByEmail(email).filter(notDeleted())
                                 .orElseThrow(() -> new EntityNotFoundException(
                                         "User with email " + email
                                         + " was not found"));
    }

    default Predicate<User> notDeleted() {
        return user -> user.getState() != DELETED;
    }
}
