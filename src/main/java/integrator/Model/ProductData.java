package integrator.Model;

import javax.xml.bind.annotation.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "towar")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductData {

    @XmlElement(name = "towar_id")
    private String product_id;
    @XmlElement(name = "kod",required = true)
    private String sku;
    private String cku;
    @XmlElement(name = "do_usuniecia")
    private String is_delete;
    @XmlElement(name = "czy_opakowanie")
    private String is_package;
    @XmlElement(name = "nazwa")
    private String name;
    @XmlElement(name = "skrot")
    private String shortcut;
    @XmlElement(name = "typ_towaru")
    private String product_type;
    private String vat_id;
    private String pkwiu;
    @XmlElement(name = "asortyment_id")
    private String asortyment_id;
    @XmlElement(name = "sww_indeks")
    private String sww_index;
    private String jm_id;
    @XmlElement(name = "waga")
    private String weight;
    @XmlElement(name = "wysokosc")
    private String height;
    @XmlElement(name = "szerokosc")
    private String width;
    @XmlElement(name = "glebokosc")
    private String depth;
    private String il_w_zgrzewce;
    private String il_paleta;
    private String il_kg_litrow;
    private String il_warstwa;
    @XmlElement(name = "cena_zakupu")
    private String price;
    @XmlElement(name = "cena_detal")
    private String price_detal;
    @XmlElement(name = "cena_hurtowa")
    private String price_hurt;
    @XmlElement(name = "cena_nocna")
    private String price_night;
    @XmlElement(name = "cena_dodatkowa")
    private String price_additional;
    @XmlElement(name = "cena_detal_przed_prom")
    private String price_detal_before_prom;
    @XmlElement(name = "cena_hurtowa_przed_prom")
    private String price_hurt_before_prom;
    @XmlElement(name = "cena_nocna_przed_prom")
    private String price_night_before_prom;
    @XmlElement(name = "cena_dodatkowa_przed_prom")
    private String price_addition_before_prom;
    @XmlElement(name = "marza_suger")
    private String margin_sugest;
    @XmlElement(name = "narzut_nocny")
    private String night_overhead;
    @XmlElement(name = "discount_hurt")
    private String rabat_hurtowy;
    @XmlElement(name = "discount_additional")
    private String rabat_dodatkowy;
    @XmlElement(name = "status_ceny")
    private String status_price;
    @XmlElement(name = "opakowanie_id")
    private String package_id;
    @XmlElement(name = "ilosc_w_opakowaniu")
    private String quantity_in_package;
    @XmlElement(name = "czy_tandem")
    private String is_tandem;
    @XmlElement(name = "czy_karton")
    private String is_box;
    @XmlElement(name = "czy_artykul")
    private String is_article;
    @XmlElement(name = "artykul_id")
    private String article_id;
    @XmlElement(name = "kategoria_id")
    private String category_id;
    @XmlElement(name = "producent_id")
    private String manufacturer_id;
    @XmlElement(name = "dostawcy")
    private String deliveries;
    @XmlElement(name = "delivery_id")
    private String dostawca_id;
    @XmlElement(name = "opis1")
    private String description;
    @XmlElement(name = "opis2")
    private String description2;
    @XmlElement(name = "opis3")
    private String description3;
    @XmlElement(name = "opis4")
    private String description4;
    @XmlElement(name = "notatki")
    private String notes;
    @XmlElement(name = "uwagi_do_dostaw")
    private String attention_to_deliveries;
    @XmlElement(name = "nr_drukarki")
    private String nr_printer;
    @XmlElement(name = "folder_zdjec")
    private String folder_images;
    @XmlElement(name = "plik_zdjecia")
    private String image;

    public ProductData getObjectData() {
        return this;
    }
}
