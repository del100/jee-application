package ie.ait.msc.discount.store.dto;

import java.io.Serializable;

public class OfferDto implements Serializable {

    private static final long serialVersionUID = 6471064387403206476L;

    private String url;
    private String description;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
