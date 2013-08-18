package sumy.qa.courses.orm;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: serduk
 * Date: 16.08.13
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
@IdClass(ReferencePK.class)
@Table(name = "REFERENCES", schema = "system", catalog = "")
@Entity
public class Reference {
    private Integer objectId;

    @Column(name = "OBJECT_ID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Id
    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
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

    private Integer reference;

    @Column(name = "REFERENCE", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Id
    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    private Integer showOrder;

    @Column(name = "SHOW_ORDER", nullable = false, insertable = true, updatable = true, length = 6, precision = 0)
    @Id
    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reference reference1 = (Reference) o;

        if (!attrId.equals(reference1.getAttrId())) return false;
        if (!objectId.equals(reference1.getObjectId())) return false;
        if (!reference.equals(reference1.getReference())) return false;
        if (showOrder != null ? !showOrder.equals(reference1.getShowOrder()) : reference1.getShowOrder() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectId.hashCode();
        result = 31 * result + attrId.hashCode();
        result = 31 * result + reference.hashCode();
        result = 31 * result + (showOrder != null ? showOrder.hashCode() : 0);
        return result;
    }

    private Attribute attribute;

    @ManyToOne
    @JoinColumn(name = "ATTR_ID", referencedColumnName = "ATTR_ID", nullable = false, insertable = false, updatable = false)
    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    private EntityObject object;

    @ManyToOne
    @JoinColumn( name = "OBJECT_ID", referencedColumnName = "OBJECT_ID", nullable = false, insertable = false, updatable = false)
    public EntityObject getObject() {
        return object;
    }

    public void setObject(EntityObject object) {
        this.object = object;
    }

    private EntityObject referencedObject;

    @ManyToOne
    @JoinColumn(name = "REFERENCE", referencedColumnName = "OBJECT_ID", nullable = false, insertable = false, updatable = false)
    public EntityObject getReferencedObject() {
        return referencedObject;
    }

    public void setReferencedObject(EntityObject referencedObject) {
        this.referencedObject = referencedObject;
    }
}
