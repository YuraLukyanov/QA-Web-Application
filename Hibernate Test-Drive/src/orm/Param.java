package orm;

import javax.persistence.*;
import java.lang.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: serduk
 * Date: 16.08.13
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
@IdClass(orm.ParamPK.class)
@Table(name = "PARAMS", schema = "system", catalog = "")
@Entity
public class Param {
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

    private String value;

    @Column(name = "VALUE", nullable = false, insertable = true, updatable = true, length = 4000, precision = 0)
    @Id
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private Timestamp dateValue;

    @Column(name = "DATE_VALUE", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Id
    public Timestamp getDateValue() {
        return dateValue;
    }

    public void setDateValue(Timestamp dateValue) {
        this.dateValue = dateValue;
    }

    private Integer showOrder;

    @Column(name = "SHOW_ORDER", nullable = false, insertable = true, updatable = true, length = 6, precision = 0)
    @Id
    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Param param = (Param) o;

        if (!attrId.equals(param.getAttrId())) return false;
        if (dateValue != null ? !dateValue.equals(param.getDateValue()) : param.getDateValue() != null) return false;
        if (!objectId.equals(param.getObjectId())) return false;
        if (showOrder != null ? !showOrder.equals(param.getShowOrder()) : param.getShowOrder() != null) return false;
        if (value != null ? !value.equals(param.getValue()) : param.getValue() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectId.hashCode();
        result = 31 * result + attrId.hashCode();
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (dateValue != null ? dateValue.hashCode() : 0);
        result = 31 * result + (showOrder != null ? showOrder.hashCode() : 0);
        return result;
    }

    private Attribute attributesByAttrId;

    @ManyToOne
    @JoinColumn(name = "ATTR_ID", referencedColumnName = "ATTR_ID", nullable = false, insertable = false, updatable = false)
    public Attribute getAttributesByAttrId() {
        return attributesByAttrId;
    }

    public void setAttributesByAttrId(Attribute attributesByAttrId) {
        this.attributesByAttrId = attributesByAttrId;
    }

    private EntityObject objectsByObjectId;

    @ManyToOne
    @JoinColumn( name = "OBJECT_ID", referencedColumnName = "OBJECT_ID", nullable = false, insertable = false, updatable = false)
    public EntityObject getObjectsByObjectId() {
        return objectsByObjectId;
    }

    public void setObjectsByObjectId(EntityObject objectsByObjectId) {
        this.objectsByObjectId = objectsByObjectId;
    }
}
