/*
 * This file is part of websocktets-gl - simple WebSocket example
 * Copyright (C) 2012  Burt Parkers
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ejbsolution.dao;

import ejbsolution.model.Possession;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Dao Bean to access the database.
 * <p/>
 * <h3>Extra-Info</h3>
 * Created: 17:50 07.06.12
 *
 * @author Burt Parkers
 * @version 1.0
 */
@Stateless
public class PossessionDaoBean {

    /** The EntityManager. */
    @PersistenceContext(unitName = "possession-persistence")
    private EntityManager entityManager;

    public void persist(Possession possession) {
        entityManager.persist(possession);
    }

    @SuppressWarnings("unchecked")
    public List<Possession> findAll() {
        CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(Possession.class));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public Possession find(int id) {
        try {
            return entityManager.find(Possession.class, id);
        } catch (NoResultException e) {
            return null;
        }
    }
}
