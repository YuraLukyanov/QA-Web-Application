package sumy.qa.courses.orm;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.lang.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: serduk
 * Date: 16.08.13
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
public class ParamPK implements Serializable {
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

    private String value;

    @Id
    @Column(name = "VALUE", nullable = false, insertable = true, updatable = true, length = 4000, precision = 0)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private Timestamp dateValue;

    @Id
    @Column(name = "DATE_VALUE", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    public Timestamp getDateValue() {
        return dateValue;
    }

    public void setDateValue(Timestamp dateValue) {
        this.dateValue = dateValue;
    }

    private Integer showOrder;

    @Id
    @Column(name = "SHOW_ORDER", nullable = false, insertable = true, updatable = true, length = 6, precision = 0)
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
}
