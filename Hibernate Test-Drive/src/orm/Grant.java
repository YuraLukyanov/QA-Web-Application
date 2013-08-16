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
@javax.persistence.IdClass(orm.GrantPK.class)
@javax.persistence.Table(name = "GRANTS", schema = "DB_ALEX", catalog = "")
@Entity
public class Grant {
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

    private Integer objectTypeId;

    @javax.persistence.Column(name = "OBJECT_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Id
    public Integer getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(Integer objectTypeId) {
        this.objectTypeId = objectTypeId;
    }

    private Integer grants;

    @javax.persistence.Column(name = "GRANTS", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public Integer getGrants() {
        return grants;
    }

    public void setGrants(Integer grants) {
        this.grants = grants;
    }

    private Integer userId;

    @javax.persistence.Column(name = "USER_ID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Id
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

        Grant grant = (Grant) o;

        if (attrId != null ? !attrId.equals(grant.attrId) : grant.attrId != null) return false;
        if (grants != null ? !grants.equals(grant.grants) : grant.grants != null) return false;
        if (objectId != null ? !objectId.equals(grant.objectId) : grant.objectId != null) return false;
        if (objectTypeId != null ? !objectTypeId.equals(grant.objectTypeId) : grant.objectTypeId != null) return false;
        if (userId != null ? !userId.equals(grant.userId) : grant.userId != null) return false;

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

    private Attribute attribute;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "ATTR_ID", referencedColumnName = "ATTR_ID", nullable = false, insertable = false, updatable = false)
    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    private EntityObject user;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "USER_ID", referencedColumnName = "OBJECT_ID", nullable = false, insertable = false, updatable = false)
    public EntityObject getUser() {
        return user;
    }

    public void setUser(EntityObject user) {
        this.user = user;
    }

    private EntityObject object;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "OBJECT_ID", referencedColumnName = "OBJECT_ID", nullable = false, insertable = false, updatable = false)
    public EntityObject getObject() {
        return object;
    }

    public void setObject(EntityObject object) {
        this.object = object;
    }

    private ObjectType objectType;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "OBJECT_TYPE_ID", referencedColumnName = "TYPE_ID", nullable = false, insertable = false, updatable = false)
    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }
}
