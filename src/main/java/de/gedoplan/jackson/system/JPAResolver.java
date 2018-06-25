package de.gedoplan.jackson.system;

import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.annotation.SimpleObjectIdResolver;
import javax.enterprise.inject.spi.CDI;
import javax.persistence.EntityManager;

/**
 * @author GEDOPLAN, Dominik Mathmann
 */
public class JPAResolver extends SimpleObjectIdResolver {

    private EntityManager em;

    public JPAResolver() {
        this.em = CDI.current().select(EntityManager.class).get();
    }

    @Override
    public void bindItem(IdKey id, Object pojo) {
        super.bindItem(id, pojo);
    }

    @Override
    public Object resolveId(IdKey id) {
        Object resolved = super.resolveId(id);
        if (resolved == null) {
            resolved = loadFromDatabase(id);
            bindItem(id, resolved);
        }

        return resolved;
    }

    private Object loadFromDatabase(IdKey idKey) {
        return this.em.getReference(idKey.scope, idKey.key);
    }

    @Override
    public ObjectIdResolver newForDeserialization(Object context) {
        return new JPAResolver();
    }

    @Override
    public boolean canUseFor(ObjectIdResolver resolverType) {
        return resolverType.getClass() == JPAResolver.class;
    }
}
