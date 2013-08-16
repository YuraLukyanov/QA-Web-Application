package orm;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created with IntelliJ IDEA.
 * User: serduk
 * Date: 16.08.13
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(orm.AttrObjectTypePK.class)
@javax.persistence.Table(name = "ATTR_OBJECT_TYPES", schema = "DB_ALEX", catalog = "")
@Entity
public class AttrObjectType {
    private Integer objectTypeId;

    @javax.persistence.Column(name = "object_type_id", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Id
    public Integer getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(Integer objectTypeId) {
        this.objectTypeId = objectTypeId;
    }

    private Integer attrId;

    @javax.persistence.Column(name = "ATTR_ID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Id
    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    private Integer flags;

    @javax.persistence.Column(name = "FLAGS", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
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

        if (attrId != null ? !attrId.equals(that.attrId) : that.attrId != null) return false;
        if (flags != null ? !flags.equals(that.flags) : that.flags != null) return false;
        if (objectTypeId != null ? !objectTypeId.equals(that.objectTypeId) : that.objectTypeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectTypeId != null ? objectTypeId.hashCode() : 0;
        result = 31 * result + (attrId != null ? attrId.hashCode() : 0);
        result = 31 * result + (flags != null ? flags.hashCode() : 0);
        return result;
    }

    private Attribute attribute;

    @ManyToOne
    @javax.persistence.JoinColumn( name = "ATTR_ID", referencedColumnName = "ATTR_ID", nullable = false, insertable = false, updatable = false)
    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    private ObjectType objectType;

    @ManyToOne
    @javax.persistence.JoinColumn( name = "OBJECT_TYPE_ID", referencedColumnName = "TYPE_ID", nullable = false, insertable = false, updatable = false)
    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }
}
