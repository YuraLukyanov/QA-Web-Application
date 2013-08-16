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
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReferencePK that = (ReferencePK) o;

        if (attrId != null ? !attrId.equals(that.attrId) : that.attrId != null) return false;
        if (objectId != null ? !objectId.equals(that.objectId) : that.objectId != null) return false;
        if (reference != null ? !reference.equals(that.reference) : that.reference != null) return false;
        if (showOrder != null ? !showOrder.equals(that.showOrder) : that.showOrder != null) return false;

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
}
