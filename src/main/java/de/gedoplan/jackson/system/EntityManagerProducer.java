package de.gedoplan.jackson.system;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author GEDOPLAN, Dominik Mathmann
 */
@ApplicationScoped
public class EntityManagerProducer {

    @PersistenceContext(unitName = "default")
    @Produces
    EntityManager entityManager;
}
