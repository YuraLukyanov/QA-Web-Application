package sumy.qa.courses.orm;

import javax.persistence.*;

@IdClass(AttrObjectTypePK.class)
@Table(name = "ATTR_OBJECT_TYPES", schema = "system", catalog = "")
@Entity
public class AttrObjectType {
    private Integer objectTypeId;

    @Column(name = "object_type_id", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Id
    public Integer getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(Integer objectTypeId) {
        this.objectTypeId = objectTypeId;
    }

    private Integer attrId;

    @Column(name = "ATTR_ID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Id
    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    private Integer flags;

    @Column(name = "FLAGS", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public Integer getFlags() {
        return flags;
    }

    public void setFlags(Integer flags) {
        this.flags = flags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttrObjectType that = (AttrObjectType) o;

        if (!attrId.equals(that.getAttrId())) return false;
        if (!objectTypeId.equals(that.getObjectTypeId())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectTypeId.hashCode();
        result = 31 * result + attrId.hashCode();
        return result;
    }

    private Attribute attribute;

    @ManyToOne
    @JoinColumn( name = "ATTR_ID", referencedColumnName = "ATTR_ID", nullable = false, insertable = false, updatable = false)
    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    private ObjectType objectType;

    @ManyToOne
    @JoinColumn( name = "OBJECT_TYPE_ID", referencedColumnName = "TYPE_ID", nullable = false, insertable = false, updatable = false)
    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }
}
