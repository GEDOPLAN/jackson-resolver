package de.gedoplan.jackson.persistence;

import de.gedoplan.jackson.entity.Talk;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * @author GEDOPLAN, Dominik Mathmann
 */
@ApplicationScoped
@Transactional
public class TalkRepository {
    
    @Inject
    EntityManager em;
    
    public Talk merge(Talk talk){
        return this.em.merge(talk);
    }
    
    public Talk findById(Integer id){
        return this.em.find(Talk.class, id);
    }
    
    public List<Talk> findAll(){
        return this.em.createQuery("select t from Talk t", Talk.class).getResultList();
    }
}
