package fables.kotlin.jee.converted.business

import java.util.*
import javax.ejb.Stateless
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

/**
 * CRud kitten operations.
 *
 * @author Zeljko Trogrlic
 */
@Stateless
open class KittenBusinessService {

    @PersistenceContext
    protected lateinit var entityManager: EntityManager

    open fun add(kitten: KittenEntity): Int {
        entityManager.persist(kitten)
        return kitten.id!!
    }

    open fun find(id: Int): Optional<KittenEntity> =
            Optional.ofNullable(entityManager.find(KittenEntity::class.java, id))
}