package ie.ait.msc.discount.store.retailer.ejb;

import ie.ait.msc.discount.store.db.service.api.DiscountStoreDaoLocal;
import ie.ait.msc.discount.store.db.service.model.Offer;
import ie.ait.msc.discount.store.db.service.model.OfferCategory;
import ie.ait.msc.discount.store.db.service.model.User;
import ie.ait.msc.discount.store.dto.OfferDto;
import ie.ait.msc.discount.store.dto.RetailerDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class RetailerService implements RetailerServiceLocal {

    private static final Logger LOGGER = LoggerFactory.getLogger(RetailerService.class);

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
        List<OfferDto> dtoOffers = createOfferDtos(offers);
        return dtoOffers;
    }

    // TODO - create a factory to convert the DTO
    private List<OfferDto> createOfferDtos(Set<Offer> offers) {
        List<OfferDto> dtoOffers = new ArrayList<OfferDto>();
        for (Offer offer : offers) {
            OfferDto dto = new OfferDto();
            dto.setDescription(offer.getDescription());
            dto.setUrl(offer.getUrl());
            dtoOffers.add(dto);
        }
        return dtoOffers;
    }

    @Override
    public void addNewOffer(OfferDto offerDto, String username) {
        LOGGER.info("Adding new offer [{}]", offerDto.getUrl());
        OfferCategory category = new OfferCategory();
        // TODO - create enum to represent category type
        category.setDescription("test");
        Offer offer = new Offer();
        offer.setDescription(offerDto.getDescription());
        offer.setUrl(offerDto.getUrl());
        offer.setCategory(category);
        dao.addOffer(offer, username);
    }
}
