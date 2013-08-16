package orm;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.lang.*;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: serduk
 * Date: 16.08.13
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "OBJECT_TYPES", schema = "DB_ALEX", catalog = "")
@Entity
public class ObjectType {
    private Integer typeId;

    @javax.persistence.Column(name = "TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Id
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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

        ObjectType that = (ObjectType) o;

        if (descr != null ? !descr.equals(that.descr) : that.descr != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeId != null ? typeId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (descr != null ? descr.hashCode() : 0);
        return result;
    }

    private Collection<AttrObjectType> binds;

    @OneToMany(mappedBy = "objectType")
    public Collection<AttrObjectType> getBinds() {
        return binds;
    }

    public void setBinds(Collection<AttrObjectType> binds) {
        this.binds = binds;
    }

    private Collection<Grant> grants;

    @OneToMany(mappedBy = "objectType")
    public Collection<Grant> getGrants() {
        return grants;
    }

    public void setGrants(Collection<Grant> grants) {
        this.grants = grants;
    }

    private Collection<EntityObject> objects;

    @OneToMany(mappedBy = "objectType")
    public Collection<EntityObject> getObjects() {
        return objects;
    }

    public void setObjects(Collection<EntityObject> objects) {
        this.objects = objects;
    }
}
