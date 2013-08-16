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
public class GrantPK implements Serializable {
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

    private Integer objectTypeId;

    @Id
    @Column(name = "OBJECT_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    public Integer getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(Integer objectTypeId) {
        this.objectTypeId = objectTypeId;
    }

    private Integer grants;

    @Id
    @Column(name = "GRANTS", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getGrants() {
        return grants;
    }

    public void setGrants(Integer grants) {
        this.grants = grants;
    }

    private Integer userId;

    @Id
    @Column(name = "USER_ID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GrantPK grantPK = (GrantPK) o;

        if (attrId != null ? !attrId.equals(grantPK.attrId) : grantPK.attrId != null) return false;
        if (grants != null ? !grants.equals(grantPK.grants) : grantPK.grants != null) return false;
        if (objectId != null ? !objectId.equals(grantPK.objectId) : grantPK.objectId != null) return false;
        if (objectTypeId != null ? !objectTypeId.equals(grantPK.objectTypeId) : grantPK.objectTypeId != null)
            return false;
        if (userId != null ? !userId.equals(grantPK.userId) : grantPK.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectId != null ? objectId.hashCode() : 0;
        result = 31 * result + (attrId != null ? attrId.hashCode() : 0);
        result = 31 * result + (objectTypeId != null ? objectTypeId.hashCode() : 0);
        result = 31 * result + (grants != null ? grants.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
