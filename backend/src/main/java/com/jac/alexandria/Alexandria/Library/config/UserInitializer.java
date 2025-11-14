package com.jac.alexandria.Alexandria.Library.config;

import com.jac.alexandria.Alexandria.Library.entity.UserEntity;
import com.jac.alexandria.Alexandria.Library.entity.Authority;
import com.jac.alexandria.Alexandria.Library.entity.AuthorityId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserInitializer implements CommandLineRunner {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) {
        final String ADMIN = "admin";
        final String USER = "user";

        // Check for admin user by username
        UserEntity admin = entityManager.createQuery(
                "SELECT u FROM UserEntity u WHERE u.username = :username", UserEntity.class)
                .setParameter("username", ADMIN)
                .getResultStream().findFirst().orElse(null);
        if (admin == null) {
            admin = new UserEntity();
            admin.setUsername(ADMIN);
            admin.setPassword("{noop}adminpass"); // Use encoder in real apps
            admin.setEnabled(true);
            entityManager.persist(admin);

            // Grant admin both ROLE_ADMIN and ROLE_USER
            AuthorityId adminAdminAuthId = new AuthorityId(ADMIN, "ROLE_ADMIN");
            Authority adminAdminAuth = new Authority(adminAdminAuthId);
            entityManager.persist(adminAdminAuth);

            AuthorityId adminUserAuthId = new AuthorityId(ADMIN, "ROLE_USER");
            Authority adminUserAuth = new Authority(adminUserAuthId);
            entityManager.persist(adminUserAuth);
        }

        // Check for regular user by username
        UserEntity user = entityManager.createQuery(
                "SELECT u FROM UserEntity u WHERE u.username = :username", UserEntity.class)
                .setParameter("username", USER)
                .getResultStream().findFirst().orElse(null);
        if (user == null) {
            user = new UserEntity();
            user.setUsername(USER);
            user.setPassword("{noop}userpass"); // Use encoder in real apps
            user.setEnabled(true);
            entityManager.persist(user);

            AuthorityId userAuthId = new AuthorityId(USER, "ROLE_USER");
            Authority userAuth = new Authority(userAuthId);
            entityManager.persist(userAuth);
        }
    }
}
