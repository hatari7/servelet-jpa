package sit.int202.jpa_demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Setter
@Getter
@ToString
@NamedQueries({
        @NamedQuery(name = "OFFICE.FINF_ALL", query = "select o from office o"),
        @NamedQuery(name = "OFFICE.FIND_BY_CITY",
        query = "select o from Office o where o.city like :cityParam")
})
@Table(name = "Offices")
public class Office {
    @Id
    private String officeCode;
    private String city;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private String postalCode;
    private String territory;


}
