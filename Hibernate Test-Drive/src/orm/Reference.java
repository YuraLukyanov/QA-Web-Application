package orm;

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
@javax.persistence.IdClass(orm.ReferencePK.class)
@javax.persistence.Table(name = "REFERENCES", schema = "DB_ALEX", catalog = "")
@Entity
public class Reference {
    private Integer objectId;

    @javax.persistence.Column(name = "OBJECT_ID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Id
    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
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

    private Integer reference;

    @javax.persistence.Column(name = "REFERENCE", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Id
    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    private Integer showOrder;

    @javax.persistence.Column(name = "SHOW_ORDER", nullable = false, insertable = true, updatable = true, length = 6, precision = 0)
    @Id
    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reference reference1 = (Reference) o;

        if (attrId != null ? !attrId.equals(reference1.attrId) : reference1.attrId != null) return false;
        if (objectId != null ? !objectId.equals(reference1.objectId) : reference1.objectId != null) return false;
        if (reference != null ? !reference.equals(reference1.reference) : reference1.reference != null) return false;
        if (showOrder != null ? !showOrder.equals(reference1.showOrder) : reference1.showOrder != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectId != null ? objectId.hashCode() : 0;
        result = 31 * result + (attrId != null ? attrId.hashCode() : 0);
        result = 31 * result + (reference != null ? reference.hashCode() : 0);
        result = 31 * result + (showOrder != null ? showOrder.hashCode() : 0);
        return result;
    }

    private Attribute attribute;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "ATTR_ID", referencedColumnName = "ATTR_ID", nullable = false, insertable = false, updatable = false)
    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    private EntityObject object;

    @ManyToOne
    @javax.persistence.JoinColumn( name = "OBJECT_ID", referencedColumnName = "OBJECT_ID", nullable = false, insertable = false, updatable = false)
    public EntityObject getObject() {
        return object;
    }

    public void setObject(EntityObject object) {
        this.object = object;
    }

    private EntityObject referencedObject;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "REFERENCE", referencedColumnName = "OBJECT_ID", nullable = false, insertable = false, updatable = false)
    public EntityObject getReferencedObject() {
        return referencedObject;
    }

    public void setReferencedObject(EntityObject referencedObject) {
        this.referencedObject = referencedObject;
    }
}
