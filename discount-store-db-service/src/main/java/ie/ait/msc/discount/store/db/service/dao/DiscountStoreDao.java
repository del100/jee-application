package ie.ait.msc.discount.store.db.service.dao;

import ie.ait.msc.discount.store.db.service.api.DiscountStoreDaoLocal;
import ie.ait.msc.discount.store.db.service.model.Offer;
import ie.ait.msc.discount.store.db.service.model.Retailer;
import ie.ait.msc.discount.store.db.service.model.User;

import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class DiscountStoreDao implements DiscountStoreDaoLocal {

    @PersistenceContext(unitName = "DiscountStorePu")
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public Set<Offer> getOffers(String username) {

        Retailer retailer = getRetailer(username);
        return retailer.getOffers();
    }

    private Retailer getRetailer(String username) {

        TypedQuery<Retailer> queryProductsByName = entityManager.createNamedQuery("Retailer.getRetailerWithUserName", Retailer.class);
        queryProductsByName.setParameter("username", username);
        List<Retailer> retailers = queryProductsByName.getResultList();
        return retailers.get(0);
    }
}