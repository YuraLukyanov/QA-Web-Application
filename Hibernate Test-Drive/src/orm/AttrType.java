package orm;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: serduk
 * Date: 16.08.13
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "ATTR_TYPES", schema = "system", catalog = "")
@Entity
public class AttrType {
    private Integer typeId;

    @Column(name = "TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Id
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    private String name;

    @Column(name = "NAME", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String descr;

    @Column(name = "DESCR", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
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

        if (!typeId.equals(attrType.getTypeId())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return typeId.hashCode();
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
