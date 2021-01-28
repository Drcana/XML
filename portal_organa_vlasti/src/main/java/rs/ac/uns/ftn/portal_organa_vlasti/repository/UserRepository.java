package rs.ac.uns.ftn.portal_organa_vlasti.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.portal_organa_vlasti.db.ExistManager;
import rs.ac.uns.ftn.portal_organa_vlasti.model.user.User;

@Repository
public class UserRepository {

    private static final String COLLECTION_URI = "db/organ_vlasti/user";

    @Autowired
    private ExistManager existManager;

    public void create(User user) throws Exception {
        existManager.store(COLLECTION_URI, user.getEmail(), user);
    }

    public User findUserByPasswordAndEmail(String password, String email) {
        User user = existManager.get(COLLECTION_URI, email, User.class);

        if (user != null) {
            return (user.getPassword().equals(password)) ? user : null;
        }

        return null;
    }
}
