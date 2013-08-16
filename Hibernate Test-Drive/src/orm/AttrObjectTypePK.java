package orm;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: serduk
 * Date: 16.08.13
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
public class AttrObjectTypePK implements Serializable {
    private Integer objectTypeId;

    @Id
    @Column(name = "OBJECT_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    public Integer getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(Integer objectTypeId) {
        this.objectTypeId = objectTypeId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttrObjectTypePK that = (AttrObjectTypePK) o;

        if (attrId != null ? !attrId.equals(that.attrId) : that.attrId != null) return false;
        if (objectTypeId != null ? !objectTypeId.equals(that.objectTypeId) : that.objectTypeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectTypeId != null ? objectTypeId.hashCode() : 0;
        result = 31 * result + (attrId != null ? attrId.hashCode() : 0);
        return result;
    }
}
