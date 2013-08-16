package orm;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: serduk
 * Date: 16.08.13
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "ATTR_TYPES", schema = "DB_ALEX", catalog = "")
@Entity
public class AttrType {
    private Integer typeId;

    @javax.persistence.Column(name = "TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Id
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    private String name;

    @javax.persistence.Column(name = "NAME", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String descr;

    @javax.persistence.Column(name = "DESCR", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttrType attrType = (AttrType) o;

        if (descr != null ? !descr.equals(attrType.descr) : attrType.descr != null) return false;
        if (name != null ? !name.equals(attrType.name) : attrType.name != null) return false;
        if (typeId != null ? !typeId.equals(attrType.typeId) : attrType.typeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeId != null ? typeId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (descr != null ? descr.hashCode() : 0);
        return result;
    }

    private Collection<Attribute> attributesByTypeId;

    @OneToMany(mappedBy = "attrType")
    public Collection<Attribute> getAttributesByTypeId() {
        return attributesByTypeId;
    }

    public void setAttributesByTypeId(Collection<Attribute> attributesByTypeId) {
        this.attributesByTypeId = attributesByTypeId;
    }
}
