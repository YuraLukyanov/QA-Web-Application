package orm;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.lang.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: serduk
 * Date: 16.08.13
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(orm.ParamPK.class)
@javax.persistence.Table(name = "PARAMS", schema = "DB_ALEX", catalog = "")
@Entity
public class Param {
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

    private String value;

    @javax.persistence.Column(name = "VALUE", nullable = false, insertable = true, updatable = true, length = 4000, precision = 0)
    @Id
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private Timestamp dateValue;

    @javax.persistence.Column(name = "DATE_VALUE", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Id
    public Timestamp getDateValue() {
        return dateValue;
    }

    public void setDateValue(Timestamp dateValue) {
        this.dateValue = dateValue;
    }

    private Integer showOrder;

    @javax.persistence.Column(name = "SHOW_ORDER", nullable = false, insertable = true, updatable = true, length = 6, precision = 0)
    @Id
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

        Param param = (Param) o;

        if (attrId != null ? !attrId.equals(param.attrId) : param.attrId != null) return false;
        if (dateValue != null ? !dateValue.equals(param.dateValue) : param.dateValue != null) return false;
        if (objectId != null ? !objectId.equals(param.objectId) : param.objectId != null) return false;
        if (showOrder != null ? !showOrder.equals(param.showOrder) : param.showOrder != null) return false;
        if (value != null ? !value.equals(param.value) : param.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectId != null ? objectId.hashCode() : 0;
        result = 31 * result + (attrId != null ? attrId.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (dateValue != null ? dateValue.hashCode() : 0);
        result = 31 * result + (showOrder != null ? showOrder.hashCode() : 0);
        return result;
    }

    private Attribute attributesByAttrId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "ATTR_ID", referencedColumnName = "ATTR_ID", nullable = false, insertable = false, updatable = false)
    public Attribute getAttributesByAttrId() {
        return attributesByAttrId;
    }

    public void setAttributesByAttrId(Attribute attributesByAttrId) {
        this.attributesByAttrId = attributesByAttrId;
    }

    private EntityObject objectsByObjectId;

    @ManyToOne
    @javax.persistence.JoinColumn( name = "OBJECT_ID", referencedColumnName = "OBJECT_ID", nullable = false, insertable = false, updatable = false)
    public EntityObject getObjectsByObjectId() {
        return objectsByObjectId;
    }

    public void setObjectsByObjectId(EntityObject objectsByObjectId) {
        this.objectsByObjectId = objectsByObjectId;
    }
}
