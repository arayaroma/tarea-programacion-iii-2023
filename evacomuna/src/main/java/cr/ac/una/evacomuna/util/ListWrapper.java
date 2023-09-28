package cr.ac.una.evacomuna.util;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

import java.util.List;

@XmlRootElement(name = "listWrapper")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListWrapper<D> {

    @XmlElement(name = "element")
    private List<D> list;

    public ListWrapper() {
        list = new ArrayList<>();
    }

    public List<D> getList() {
        return list;
    }

    public void setList(List<D> list) {
        this.list = list;
    }

}
