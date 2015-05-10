package ie.ait.msc.discount.store.retailer.ejb;

import ie.ait.msc.discount.store.dto.OfferDto;
import ie.ait.msc.discount.store.dto.RetailerDto;

import java.util.List;

import javax.ejb.Local;

@Local
public interface RetailerServiceLocal {
    void createAccount(RetailerDto retailerDto);

    List<OfferDto> getAllOffers(String username);

    void addNewOffer(OfferDto offerDto, String username);
}
