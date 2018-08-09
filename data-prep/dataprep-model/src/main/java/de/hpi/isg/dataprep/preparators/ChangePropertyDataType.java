package de.hpi.isg.dataprep.preparators;

import de.hpi.isg.dataprep.Consequences;
import de.hpi.isg.dataprep.exceptions.PreparationHasErrorException;
import de.hpi.isg.dataprep.model.metadata.ChangePropertyDataTypeMetadata;
import de.hpi.isg.dataprep.model.target.Metadata;
import de.hpi.isg.dataprep.model.target.preparator.Preparator;
import de.hpi.isg.dataprep.preparators.impl.ChangePropertyDataTypeImpl;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

/**
 * @author Lan Jiang
 * @since 2018/8/7
 */
public class ChangePropertyDataType extends Preparator {

    public enum PropertyType {
        STRING,
        INTEGER,
        DOUBLE,
        DATE,
        DATETIME,
        DATETIMESTAMP
    }

    private String propertyName;
    private PropertyType targetType;
    private String datePattern;

    private ChangePropertyDataTypeImpl impl;

    public ChangePropertyDataType(String propertyName, PropertyType targetType) {
        this.propertyName = propertyName;
        this.targetType = targetType;
    }

    public ChangePropertyDataType(String propertyName, PropertyType sourceType, PropertyType targetType) {
        this(propertyName, targetType);
    }

    public ChangePropertyDataType(ChangePropertyDataTypeImpl impl) {
        this.impl = impl;
    }

    @Override
    protected boolean checkMetadata() {
        prerequisites = new ChangePropertyDataTypeMetadata();
        for (String metadata : prerequisites.getPrerequisites()) {
            if (false) {
                // this metadata is not satisfied, add it to the invalid metadata set.
                this.getInvalid().add(new Metadata(metadata));
                return false;
            }
        }
        return true;
    }

    @Override
    protected void executePreparator() throws Exception {
        impl.execute(this);
    }

    @Override
    protected void recordProvenance() {

    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public PropertyType getTargetType() {
        return targetType;
    }

    public void setTargetType(PropertyType targetType) {
        this.targetType = targetType;
    }

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }
}
