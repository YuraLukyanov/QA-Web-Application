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
@Table(name = "OBJECTS", schema = "system", catalog = "")
@Entity
@SequenceGenerator(
    name="SEQ_STORE",
    sequenceName="ENTITY_OBJECTS_SEQ",
    allocationSize=1
)
public class EntityObject {
    private Integer objectId;

    @Column(name = "OBJECT_ID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SEQ_STORE")
    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    private String name;

    @Column(name = "NAME", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer orderNumber;

    @Column(name = "ORDER_NUMBER", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    private String description;

    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityObject that = (EntityObject) o;

        if (!objectId.equals(that.getObjectId())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return objectId.hashCode();
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
