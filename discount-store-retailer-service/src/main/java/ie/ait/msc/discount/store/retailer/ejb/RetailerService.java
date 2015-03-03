package ie.ait.msc.discount.store.retailer.ejb;

import ie.ait.msc.discount.store.db.service.api.DiscountStoreDaoLocal;
import ie.ait.msc.discount.store.db.service.model.Offer;
import ie.ait.msc.discount.store.db.service.model.User;
import ie.ait.msc.discount.store.dto.OfferDto;
import ie.ait.msc.discount.store.dto.RetailerDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class RetailerService implements RetailerServiceLocal {

    @Inject
    DiscountStoreDaoLocal dao;

    @Override
    public void createAccount(RetailerDto retailerDto) {
        User user = createUserFromDto(retailerDto);
        dao.addUser(user);
    }

    private User createUserFromDto(RetailerDto retailerDto) {
        User user = new User();
        user.setUserName(retailerDto.getUserName());
        user.setPassword(retailerDto.getPassword());
        return user;
    }

    @Override
    public List<OfferDto> getAllOffers(String username) {
        Set<Offer> offers = dao.getOffers(username);
        List<OfferDto> dtoOffers = createDtoOffers(offers);
        return dtoOffers;
    }

    private List<OfferDto> createDtoOffers(Set<Offer> offers) {
        List<OfferDto> dtoOffers = new ArrayList<OfferDto>();
        for (Offer offer : offers) {
            OfferDto dto = new OfferDto();
            dto.setDescription(offer.getDescription());
            dto.setUrl(offer.getUrl());
            dtoOffers.add(dto);
        }
        return dtoOffers;
    }
}
