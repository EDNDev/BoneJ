package org.doube.bonej.geomorph;

import javax.vecmath.Point3d;

/**
 * Landmark class for storing multidimensional points. Extends Tuple3d / Point3d
 * by adding a name and timepoint
 * 
 * @author Michael Doube
 * 
 */
public class Landmark extends Point3d {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4713913304554138975L;
	/**
	 * UNIX timestamp, the difference, measured in milliseconds, between the
	 * current time and midnight, January 1, 1970 UTC.
	 */
	private long t;
	private String spaceUnit;
	private String name;

	public Landmark(double x, double y, double z, String name) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.name = name;
	}

	public long getT() {
		return t;
	}

	public String getName() {
		return name;
	}

	public void set(double x, double y, double z, long t) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.t = t;
	}

	public void setTime(long t) {
		this.t = t;
	}

	public void setName(String name) {
		this.name = name;
	}
}
