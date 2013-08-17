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
@Table(name = "ATTRIBUTES", schema = "system", catalog = "")
@Entity
public class Attribute {
    private Integer attrId;

    @Column(name = "ATTR_ID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Id
    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
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

    private String properties;

    @Column(name = "PROPERTIES", nullable = true, insertable = true, updatable = true, length = 1024, precision = 0)
    @Basic
    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    private Integer flags;

    @Column(name = "FLAGS", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public Integer getFlags() {
        return flags;
    }

    public void setFlags(Integer flags) {
        this.flags = flags;
    }

    private String description;

    @Column(name = "DESCRIPTION", nullable = true, insertable = true, updatable = true, length = 1000, precision = 0)
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

        Attribute attribute = (Attribute) o;

        if (!attrId.equals(attribute.getAttrId())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return attrId.hashCode();
    }

    private AttrType attrType;

    @ManyToOne
    @JoinColumn(name = "ATTR_TYPE_ID", referencedColumnName = "TYPE_ID", nullable = false)
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
