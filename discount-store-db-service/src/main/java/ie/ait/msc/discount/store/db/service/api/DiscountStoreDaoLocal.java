package ie.ait.msc.discount.store.db.service.api;

import ie.ait.msc.discount.store.db.service.model.Offer;
import ie.ait.msc.discount.store.db.service.model.User;

import java.util.Set;

public interface DiscountStoreDaoLocal {

    void addUser(User user);

    Set<Offer> getOffers(String username);
}
