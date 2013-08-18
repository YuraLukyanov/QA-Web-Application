package sumy.qa.courses.orm;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: serduk
 * Date: 16.08.13
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
@IdClass(GrantPK.class)
@Table(name = "GRANTS", schema = "system", catalog = "")
@Entity
public class Grant {
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

    private Integer objectTypeId;

    @Column(name = "OBJECT_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Id
    public Integer getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(Integer objectTypeId) {
        this.objectTypeId = objectTypeId;
    }

    private Integer grants;

    @Column(name = "GRANTS", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public Integer getGrants() {
        return grants;
    }

    public void setGrants(Integer grants) {
        this.grants = grants;
    }

    private Integer userId;

    @Column(name = "USER_ID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
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

        if (attrId != null ? !attrId.equals(grant.getAttrId()) : grant.getAttrId() != null) return false;
        if (objectId != null ? !objectId.equals(grant.getObjectId()) : grant.getObjectId() != null) return false;
        if (objectTypeId != null ? !objectTypeId.equals(grant.getObjectTypeId()) : grant.getObjectTypeId() != null) return false;
        if (!userId.equals(grant.getUserId())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectId != null ? objectId.hashCode() : 0;
        result = 31 * result + (attrId != null ? attrId.hashCode() : 0);
        result = 31 * result + (objectTypeId != null ? objectTypeId.hashCode() : 0);
        result = 31 * result + userId.hashCode();
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

    private EntityObject user;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "OBJECT_ID", nullable = false, insertable = false, updatable = false)
    public EntityObject getUser() {
        return user;
    }

    public void setUser(EntityObject user) {
        this.user = user;
    }

    private EntityObject object;

    @ManyToOne
    @JoinColumn(name = "OBJECT_ID", referencedColumnName = "OBJECT_ID", nullable = false, insertable = false, updatable = false)
    public EntityObject getObject() {
        return object;
    }

    public void setObject(EntityObject object) {
        this.object = object;
    }

    private ObjectType objectType;

    @ManyToOne
    @JoinColumn(name = "OBJECT_TYPE_ID", referencedColumnName = "TYPE_ID", nullable = false, insertable = false, updatable = false)
    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }
}
