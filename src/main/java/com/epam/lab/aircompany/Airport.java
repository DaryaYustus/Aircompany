package com.epam.lab.aircompany;

import java.util.*;

import com.epam.lab.aircompany.models.MilitaryType;
import com.epam.lab.aircompany.planes.MilitaryPlane;
import com.epam.lab.aircompany.planes.PassengerPlane;
import com.epam.lab.aircompany.planes.Plane;
import com.epam.lab.aircompany.planes.ExperimentalPlane;

public class Airport {
	private List<? extends Plane> planes;

	public List<PassengerPlane> getPassengerPlane() {
		List<PassengerPlane> passengerPlanes = new ArrayList<>();
		for (Plane plane : planes) {
			if (plane instanceof PassengerPlane) {
				passengerPlanes.add((PassengerPlane) plane);
			}
		}
		return passengerPlanes;
	}

	public List<MilitaryPlane> getMilitaryPlanes() {
		List<MilitaryPlane> militaryPlanes = new ArrayList<>();
		for (Plane plane : planes) {
			if (plane instanceof MilitaryPlane) {
				militaryPlanes.add((MilitaryPlane) plane);
			}
		}
		return militaryPlanes;
	}

	public List<ExperimentalPlane> getExperimentalPlanes() {
		List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
		for (Plane plane : planes) {
			if (plane instanceof ExperimentalPlane) {
				experimentalPlanes.add((ExperimentalPlane) plane);
			}
		}
		return experimentalPlanes;
	}

	public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
		List<PassengerPlane> passengerPlanes = getPassengerPlane();
		PassengerPlane planeWithMaxCapacity = null;
		if (passengerPlanes.size() > 0) {
			planeWithMaxCapacity = passengerPlanes.get(0);
			for (int i = 0; i < passengerPlanes.size(); i++) {
				if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity
						.getPassengersCapacity()) {
					planeWithMaxCapacity = passengerPlanes.get(i);
				}
			}
		}
		return planeWithMaxCapacity;
	}

	public List<MilitaryPlane> getTransportMilitaryPlanes() {
		return getMilitaryPlanesByType(MilitaryType.TRANSPORT);
	}

	public List<MilitaryPlane> getBomberMilitaryPlanes() {
		return getMilitaryPlanesByType(MilitaryType.BOMBER);

	}

	private List<MilitaryPlane> getMilitaryPlanesByType(MilitaryType type) {
		List<MilitaryPlane> resultPlanes = new ArrayList<>();
		List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
		for (int i = 0; i < militaryPlanes.size(); i++) {
			MilitaryPlane plane = militaryPlanes.get(i);
			if (type.equals(plane.getType())) {
				resultPlanes.add(plane);
			}
		}
		return resultPlanes;
	}

	public Airport sortByMaxDistance() {
		Collections.sort(planes, new Comparator<Plane>() {
			public int compare(Plane o1, Plane o2) {
				return o1.getMaxFlighDistance() - o2.getMaxFlighDistance();
			}
		});
		return this;
	}

	public Airport sortByMaxSpeed() {
		Collections.sort(planes, new Comparator<Plane>() {
			public int compare(Plane o1, Plane o2) {
				return o1.getMaxSpeed() - o2.getMaxSpeed();
			}
		});
		return this;
	}

	public Airport sortByMaxLoadCapacity() {
		Collections.sort(planes, new Comparator<Plane>() {
			public int compare(Plane o1, Plane o2) {
				return o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity();
			}
		});
		return this;
	}

	public List<? extends Plane> getPlanes() {
		return planes;
	}

	private void print(Collection<? extends Plane> collection) {
		Iterator<? extends Plane> iterator = collection.iterator();
		while (iterator.hasNext()) {
			Plane plane = iterator.next();
			System.out.println(plane);
		}
	}

	public Airport(List<? extends Plane> planes) {
		this.planes = planes;
	}

}
