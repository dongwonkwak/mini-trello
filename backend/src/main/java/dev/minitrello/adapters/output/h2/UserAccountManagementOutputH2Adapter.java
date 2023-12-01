package dev.minitrello.adapters.output.h2;


import dev.minitrello.application.ports.output.UserManagementOutputPort;
import dev.minitrello.domain.entity.UserAccount;
import jakarta.persistence.*;


public class UserAccountManagementOutputH2Adapter implements UserManagementOutputPort {

    private static UserAccountManagementOutputH2Adapter instance;

    //private final UserAccountRepository userAccountRepository;
//    @PersistenceUnit
//    private final EntityManagerFactory entityManagerFactory =
//            Persistence.createEntityManagerFactory("user_account");
    @PersistenceContext
    private EntityManager em;

    public UserAccountManagementOutputH2Adapter() {
        setUpH2Database();
    }

    @Override
    public UserAccount persistUserAccount(UserAccount userAccount) {
        //return userAccountRepository
        //return Optional.empty();
        return null;
    }

    @Override
    public Integer countUserAccountByUsername(String username) {
       // return this.userAccountRepository.countByUsername(username);
        return null;
    }

    @Override
    public Integer countUserAccountByEmail(String email) {
        //return this.userAccountRepository.countByEmail(email);
        return null;
    }

    private void setUpH2Database() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("user_account");
        this.em = entityManagerFactory.createEntityManager();
    }

    public static UserAccountManagementOutputH2Adapter getInstance() {
        if (instance == null) {
            instance = new UserAccountManagementOutputH2Adapter();
        }

        return instance;
    }
}
