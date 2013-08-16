package orm;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: serduk
 * Date: 16.08.13
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "OBJECTS", schema = "DB_ALEX", catalog = "")
@Entity
@javax.persistence.SequenceGenerator(
    name="SEQ_STORE",
    sequenceName="ENTITY_OBJECTS_SEQ",
    allocationSize=1
)
public class EntityObject {
    private Integer objectId;

    @javax.persistence.Column(name = "OBJECT_ID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SEQ_STORE")
    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    private String name;

    @javax.persistence.Column(name = "NAME", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer orderNumber;

    @javax.persistence.Column(name = "ORDER_NUMBER", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    private String descr;

    @javax.persistence.Column(name = "DESCR", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityObject object = (EntityObject) o;

        if (descr != null ? !descr.equals(object.descr) : object.descr != null) return false;
        if (name != null ? !name.equals(object.name) : object.name != null) return false;
        if (objectId != null ? !objectId.equals(object.objectId) : object.objectId != null) return false;
        if (orderNumber != null ? !orderNumber.equals(object.orderNumber) : object.orderNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectId != null ? objectId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (orderNumber != null ? orderNumber.hashCode() : 0);
        result = 31 * result + (descr != null ? descr.hashCode() : 0);
        return result;
    }

    private Collection<Grant> userGrants;

    @OneToMany(mappedBy = "user")
    public Collection<Grant> getUserGrants() {
        return userGrants;
    }

    public void setUserGrants(Collection<Grant> userGrants) {
        this.userGrants = userGrants;
    }

    private Collection<Grant> allowedObjects;

    @OneToMany(mappedBy = "object")
    public Collection<Grant> getAllowedObjects() {
        return allowedObjects;
    }

    public void setAllowedObjects(Collection<Grant> allowedObjects) {
        this.allowedObjects = allowedObjects;
    }

    private EntityObject parentObject;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID", referencedColumnName = "OBJECT_ID")
    public EntityObject getParentObject() {
        return parentObject;
    }

    public void setParentObject(EntityObject parentObject) {
        this.parentObject = parentObject;
    }

    private Collection<EntityObject> children;

    @OneToMany(mappedBy = "parentObject")
    public Collection<EntityObject> getChildren() {
        return children;
    }

    public void setChildren(Collection<EntityObject> children) {
        this.children = children;
    }

    private ObjectType objectType;

    @ManyToOne
    @JoinColumn(name = "OBJECT_TYPE_ID", referencedColumnName = "TYPE_ID", nullable = false)
    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    private Collection<Param> params;

    @OneToMany(mappedBy = "objectsByObjectId")
    public Collection<Param> getParams() {
        return params;
    }

    public void setParams(Collection<Param> params) {
        this.params = params;
    }

    private Collection<Reference> references;

    @OneToMany(mappedBy = "object")
    public Collection<Reference> getReferences() {
        return references;
    }

    public void setReferences(Collection<Reference> references) {
        this.references = references;
    }

    private Collection<Reference> backReferences;

    @OneToMany(mappedBy = "referencedObject")
    public Collection<Reference> getBackReferences() {
        return backReferences;
    }

    public void setBackReferences(Collection<Reference> backReferences) {
        this.backReferences = backReferences;
    }
}
