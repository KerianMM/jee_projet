package montp.data;

import montp.data.entity.PersonEntity;
import montp.data.entity.security.GroupEntity;
import montp.data.entity.security.UserEntity;
import montp.services.PersonService;
import montp.services.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Singleton
@Startup
public class Seeder {
    
    @Inject private UserService userService;
    @Inject private PersonService personService;

    @PersistenceContext private EntityManager em;
    
    @PostConstruct
    public void init() {
        if (personService.isEmpty() &&
            userService.isEmpty()
        ) {
            //region PERSON
            PersonEntity kerian = new PersonEntity(false, "Kérian", "MONTES-MORIN", "kerianmontes@test.com", "0642624880", new Date(1997, Calendar.JULY, 3), "4 chemin des jardins neufs, Avignon", "84000", new Float("20000"), new Float("12.5"));
            PersonEntity ben    = new PersonEntity(false, "Ben", "CLEMENT", "ben.clement@test.com", new Date(1996, Calendar.DECEMBER, 14), new Float("18000"), new Float("10.5"));
            PersonEntity loic   = new PersonEntity(false, "Loic", "Wernert", "lw@test.com", new Date(1998, Calendar.NOVEMBER, 14), new Float("2000"), new Float("15"));

            PersonEntity esimed     = new PersonEntity(true, "", "Esimed", "esimed@test.com", new Date(1990, Calendar.JANUARY, 1), new Float("30000"), new Float("14.50"));
            PersonEntity aubanel    = new PersonEntity(true, "", "Théodore Aubanel", "aubanel@test.com", new Date(1990, Calendar.JANUARY, 1), new Float("30000"), new Float("14.50"));
            //endregion

            if (userService.getGroup("USER") == null) {
                GroupEntity groupUser = new GroupEntity("USER");
                GroupEntity groupAdmin = new GroupEntity("ADMIN");
                em.persist(groupUser);
                em.persist(groupAdmin);

                UserEntity userKerian = new UserEntity("kerian", "kerian", kerian);
                List<GroupEntity> groupesKerian = new ArrayList<>();
                groupesKerian.add(groupUser);
                groupesKerian.add(groupAdmin);
                userKerian.setGroups(groupesKerian);

                UserEntity userBen = new UserEntity("ben", "ben", ben);
                List<GroupEntity> groupesBen = new ArrayList<>();
                groupesBen.add(groupUser);
                userBen.setGroups(groupesBen);

                UserEntity userLoic = new UserEntity("loic", "loic", loic);
                List<GroupEntity> groupesLoic = new ArrayList<>();
                groupesLoic.add(groupUser);
                userLoic.setGroups(groupesLoic);

                UserEntity userEsimed = new UserEntity("esimed", "esimed", esimed);
                List<GroupEntity> groupesEsimed = new ArrayList<>();
                groupesEsimed.add(groupUser);
                userEsimed.setGroups(groupesEsimed);

                UserEntity userAubanel = new UserEntity("aubanel", "aubanel", aubanel);
                List<GroupEntity> groupesAubanel = new ArrayList<>();
                groupesAubanel.add(groupUser);
                userAubanel.setGroups(groupesAubanel);

                userService.insert(userKerian);
                userService.insert(userBen);
                userService.insert(userLoic);
                userService.insert(userEsimed);
                userService.insert(userAubanel);
            }
        }
    }
}