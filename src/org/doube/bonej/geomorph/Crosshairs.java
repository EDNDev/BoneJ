package org.doube.bonej.geomorph;

import java.util.ArrayList;

import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;

import ij.IJ;
import ij3d.Content;
import ij3d.Image3DUniverse;

/**
 * 
 * 
 * @author Michael Doube
 */
public class Crosshairs {
	private Image3DUniverse univ;
	private Content content;
	private double x, y, z;
	private ArrayList<Point3f> mesh;
	
	public Crosshairs(double x, double y, double z, Image3DUniverse univ){
		this.x = x;
		this.y = y;
		this.z = z;
		this.univ = univ;
		create();
	}
	
	private void create() {
		Point3d globalMax = new Point3d();
		univ.getGlobalMaxPoint(globalMax);
		
		Point3d globalMin = new Point3d();
		univ.getGlobalMinPoint(globalMin);
		
		mesh = new ArrayList<Point3f>();
		Point3f start1 = new Point3f();
		start1.x = (float) x;
		start1.y = (float) y;
		start1.z = (float) globalMin.z;
		mesh.add(start1);

		Point3f end1 = new Point3f();
		end1.x = (float) x;
		end1.y = (float) y;
		end1.z = (float) globalMax.z;
		mesh.add(end1);

		Point3f start2 = new Point3f();
		start2.x = (float) x;
		start2.y = (float) globalMin.y;
		start2.z = (float) z;
		mesh.add(start2);

		Point3f end2 = new Point3f();
		end2.x = (float) x;
		end2.y = (float) globalMax.y;
		end2.z = (float) z;
		mesh.add(end2);

		Point3f start3 = new Point3f();
		start3.x = (float) globalMin.x;
		start3.y = (float) y;
		start3.z = (float) z;
		mesh.add(start3);

		Point3f end3 = new Point3f();
		end3.x = (float) globalMax.x;
		end3.y = (float) y;
		end3.z = (float) z;
		mesh.add(end3);
		
		try {
			content = univ.addLineMesh(mesh, (new Color3f(1.0f, 1.0f, 0.0f)), "Crosshairs", false);
		} catch (NullPointerException npe) {
			IJ.log("3D Viewer was closed before rendering completed.");
			return;
		}
	}

	public void set(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void update(){
		
		Point3d globalMax = new Point3d();
		univ.getGlobalMaxPoint(globalMax);
		
		Point3d globalMin = new Point3d();
		univ.getGlobalMinPoint(globalMin);
		
		univ.removeContent(content.getName());
		mesh.clear();
		
		Point3f start1 = new Point3f();
		start1.x = (float) x;
		start1.y = (float) y;
		start1.z = (float) globalMin.z;
		mesh.add(start1);

		Point3f end1 = new Point3f();
		end1.x = (float) x;
		end1.y = (float) y;
		end1.z = (float) globalMax.z;
		mesh.add(end1);

		Point3f start2 = new Point3f();
		start2.x = (float) x;
		start2.y = (float) globalMin.y;
		start2.z = (float) z;
		mesh.add(start2);

		Point3f end2 = new Point3f();
		end2.x = (float) x;
		end2.y = (float) globalMax.y;
		end2.z = (float) z;
		mesh.add(end2);

		Point3f start3 = new Point3f();
		start3.x = (float) globalMin.x;
		start3.y = (float) y;
		start3.z = (float) z;
		mesh.add(start3);

		Point3f end3 = new Point3f();
		end3.x = (float) globalMax.x;
		end3.y = (float) y;
		end3.z = (float) z;
		mesh.add(end3);
		
		try {
			content = univ.addLineMesh(mesh, (new Color3f(1.0f, 1.0f, 0.0f)), "Crosshairs", false);
		} catch (NullPointerException npe) {
			IJ.log("3D Viewer was closed before rendering completed.");
			return;
		}
		
	}
}
