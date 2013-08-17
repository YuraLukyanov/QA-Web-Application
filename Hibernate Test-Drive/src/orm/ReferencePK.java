package orm;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.lang.*;

/**
 * Created with IntelliJ IDEA.
 * User: serduk
 * Date: 16.08.13
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
public class ReferencePK implements Serializable {
    private Integer objectId;

    @Id
    @Column(name = "OBJECT_ID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    private Integer attrId;

    @Id
    @Column(name = "ATTR_ID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    private Integer reference;

    @Id
    @Column(name = "REFERENCE", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    private Integer showOrder;

    @Id
    @Column(name = "SHOW_ORDER", nullable = false, insertable = true, updatable = true, length = 6, precision = 0)
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
}
