package integrator.Model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dane")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class RootData implements Serializable {

    @XmlElement(name = "dane_sklepu")
    private List<ShopData> shopData;

    @XmlElement(name = "wykazy")
    private Lists list;

}
