package com.epam.lab.aircompany.planes;

import com.epam.lab.aircompany.models.ClassificationLevel;
import com.epam.lab.aircompany.models.ExperimentalTypes;

public class ExperimentalPlane extends Plane {

	private ExperimentalTypes type;
	private ClassificationLevel classificationLevel;

	public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance,
			int maxLoadCapacity, ExperimentalTypes type,
			ClassificationLevel classificationLevel) {
		super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
		this.type = type;
		this.classificationLevel = classificationLevel;
	}

	public ClassificationLevel getClassificationLevel() {
		return classificationLevel;
	}

	public void setClassificationLevel(ClassificationLevel classificationLevel) {
		this.classificationLevel = classificationLevel;
	}

	public ExperimentalTypes getType() {
		return type;
	}

	public void setType(ExperimentalTypes type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExperimentalPlane other = (ExperimentalPlane) obj;
		if (classificationLevel != other.classificationLevel)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((classificationLevel == null) ? 0 : classificationLevel
						.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return super.toString().replace(
				"}",
				" type=" + type + ", classificationLevel="
						+ classificationLevel + "}");
	}
}
