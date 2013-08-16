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
@javax.persistence.Table(name = "ATTRIBUTES", schema = "DB_ALEX", catalog = "")
@Entity
public class Attribute {
    private Integer attrId;

    @javax.persistence.Column(name = "ATTR_ID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Id
    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
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

    private String properties;

    @javax.persistence.Column(name = "PROPERTIES", nullable = true, insertable = true, updatable = true, length = 1024, precision = 0)
    @Basic
    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    private Integer flags;

    @javax.persistence.Column(name = "FLAGS", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public Integer getFlags() {
        return flags;
    }

    public void setFlags(Integer flags) {
        this.flags = flags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attribute attribute = (Attribute) o;

        if (attrId != null ? !attrId.equals(attribute.attrId) : attribute.attrId != null) return false;
        if (flags != null ? !flags.equals(attribute.flags) : attribute.flags != null) return false;
        if (name != null ? !name.equals(attribute.name) : attribute.name != null) return false;
        if (properties != null ? !properties.equals(attribute.properties) : attribute.properties != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = attrId != null ? attrId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        result = 31 * result + (flags != null ? flags.hashCode() : 0);
        return result;
    }

    private AttrType attrType;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "ATTR_TYPE_ID", referencedColumnName = "TYPE_ID", nullable = false)
    public AttrType getAttrType() {
        return attrType;
    }

    public void setAttrType(AttrType attrType) {
        this.attrType = attrType;
    }

    private Collection<AttrObjectType> binds;

    @OneToMany(mappedBy = "attribute")
    public Collection<AttrObjectType> getBinds() {
        return binds;
    }

    public void setBinds(Collection<AttrObjectType> binds) {
        this.binds = binds;
    }

    private Collection<Grant> grants;

    @OneToMany(mappedBy = "attribute")
    public Collection<Grant> getGrants() {
        return grants;
    }

    public void setGrants(Collection<Grant> grants) {
        this.grants = grants;
    }

    private Collection<Param> params;

    @OneToMany(mappedBy = "attributesByAttrId")
    public Collection<Param> getParams() {
        return params;
    }

    public void setParams(Collection<Param> params) {
        this.params = params;
    }

    private Collection<Reference> references;

    @OneToMany(mappedBy = "attribute")
    public Collection<Reference> getReferences() {
        return references;
    }

    public void setReferences(Collection<Reference> references) {
        this.references = references;
    }
}
