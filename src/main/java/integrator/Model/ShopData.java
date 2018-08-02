package integrator.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "dane_sklepu")
@XmlAccessorType(XmlAccessType.FIELD)

@Getter
@Setter
public class ShopData {

    @XmlElement(name = "nazwa1")
    private String name_1;
    @XmlElement(name = "nazwa2")
    private String name_2;
    @XmlElement(name = "ulica")
    private String street;
    @XmlElement(name = "nazwa_ulicy")
    private String street_name;
    @XmlElement(name = "nr_domu")
    private String house_number;
    @XmlElement(name = "nr_lokalu")
    private String apartament_number;
    @XmlElement(name = "miasto")
    private String city;
    @XmlElement(name = "kod_pocztowy")
    private String zip_code;
    @XmlElement(name = "poczta")
    private String post_office;
    @XmlElement(name = "powiat")
    private String county;
    @XmlElement(name = "wojewodztwo")
    private String voivodeship;
    @XmlElement(name = "gmina")
    private String commune;
    @XmlElement(name = "kod_kraju")
    private String code_country;
    @XmlElement(name = "nazwa_kraju")
    private String country_name;
    private String email;
    @XmlElement(name = "telefon")
    private String phone;
    @XmlElement(name = "bank1")
    private String bank_number;
    @XmlElement(name = "konto1")
    private String account_number;
    @XmlElement(name = "nip")
    private String nip;
    @XmlElement(name = "nr_sklepu")
    private String shop_numer;
    @XmlElement(name = "nr_seryjny")
    private String shop_serial_number;


}
