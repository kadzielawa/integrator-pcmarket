package integrator.Model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "wykazy")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Lists implements Serializable {

    @XmlElement(name = "towary")
    private List<Products> products;
}
