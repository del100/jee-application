package ie.ait.msc.discount.store.db.service.dao;

import ie.ait.msc.discount.store.db.service.api.DiscountStoreDaoLocal;
import ie.ait.msc.discount.store.db.service.api.DiscountStoreDbException;
import ie.ait.msc.discount.store.db.service.model.Offer;
import ie.ait.msc.discount.store.db.service.model.Retailer;
import ie.ait.msc.discount.store.db.service.model.User;

import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
        return entityManager.createNamedQuery("getUserWithUserName", User.class).setParameter("userName", username).getSingleResult().getRetailer();
    }

    @Override
    public void addOffer(Offer offer, String username) {
        try {
            entityManager.persist(offer);
            Retailer retailer = getRetailer(username);
            retailer.getOffers().add(offer);
            entityManager.persist(retailer);
        } catch (Exception e) {
            throw new DiscountStoreDbException(e.getMessage(), e);
        }
    }
}
