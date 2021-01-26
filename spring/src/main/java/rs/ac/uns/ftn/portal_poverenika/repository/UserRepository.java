package rs.ac.uns.ftn.portal_poverenika.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.portal_poverenika.db.ExistManager;
import rs.ac.uns.ftn.portal_poverenika.model.user.User;

import java.util.UUID;

@Repository
public class UserRepository {

    private static final String COLLECTION_URI = "db/poverenik/user";

    @Autowired
    private ExistManager existManager;

    public void create(User user) throws Exception {
        existManager.store(COLLECTION_URI, UUID.randomUUID().toString(), user);
    }
}
