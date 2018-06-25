package de.gedoplan.jackson.system;

import de.gedoplan.jackson.entity.Speaker;
import de.gedoplan.jackson.entity.Talk;
import de.gedoplan.jackson.entity.TalkType;
import java.text.ParseException;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * @author GEDOPLAN, Dominik Mathmann
 */
@ApplicationScoped
@Transactional
public class InitDataService {

    @Inject
    EntityManager em;


    void initDemoData(@Observes @Initialized(ApplicationScoped.class) Object event) throws ParseException {
        if (this.em.createQuery("select count(t) from Talk t", Long.class).getSingleResult() == 0) {
            
            Speaker speakerLanger=em.merge(new Speaker("Angelika", "Langer"));
            Speaker speakerKreft=em.merge(new Speaker("Klaus", "Kreft"));
            Speaker speakerWeil=em.merge(new Speaker("Dirk", "Weil"));
            Speaker speakerBean=em.merge(new Speaker("Adam", "Bean"));
            Speaker speakerChin=em.merge(new Speaker("Stephen", "Chin"));
            
            
            
            Talk lambdasAndStreams = new Talk("Workshop zu Lambdas und Streams in Java 8", TalkType.WORKSHOP, 480, speakerLanger, speakerKreft);
            Talk javaEEWorkshop = new Talk("Power Workshop Java EE", TalkType.WORKSHOP, 480, speakerWeil);
            this.em.persist(javaEEWorkshop);
            this.em.persist(lambdasAndStreams);


            Talk javaEEQuantumOfCode = new Talk("JavaEE (7) Quantum of Code", TalkType.SESSION, 75, speakerWeil);
            Talk feigeSein = new Talk("Feige sein!", TalkType.SESSION, 60, speakerKreft);
            Talk hypermediaMitJaxRs = new Talk("Hypermedia mit JAX-RS 2.0", TalkType.SESSION, 60, speakerBean);
            this.em.persist(javaEEQuantumOfCode);
            this.em.persist(feigeSein);
            this.em.persist(hypermediaMitJaxRs);

   
            Talk eclipseSmartHome = new Talk("Eclipse SmartHome", TalkType.SESSION, 60, speakerLanger);
            Talk javaSe8ForTabletsPisAndLegos = new Talk("Java SE 8 for Tablets, Pis, and Legos", TalkType.SESSION, 60, speakerChin);
            Talk realSteal = new Talk("Real Steel – der ultimative Roboterfight!", TalkType.SESSION, 120, speakerBean);
            this.em.persist(eclipseSmartHome);
            this.em.persist(javaSe8ForTabletsPisAndLegos);
            this.em.persist(realSteal);
        }
    }

}
