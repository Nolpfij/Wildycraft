package wildycraft.structures;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.util.MathHelper;

public class KalphiteLairGraph {
	
	public ArrayList<Point> vertices = new ArrayList<Point>();
	public boolean[][] corridors;
	
	public void generateFloor(int x, int y, int z, int rooms, Random rand){
		vertices.add(new Point(x,z, 0, 7, 7));
		for(int i = 0; i < rooms; i++){
			double angle = rand.nextDouble()*2*Math.PI;
			double distance = rand.nextDouble()*100 + 15;
			
			Point p = new Point(x + (int)(Math.cos(angle)*distance), z + (int)(Math.sin(angle)*distance), 
					i + 1, rand.nextInt(3) + 5, rand.nextInt(3) + 5);
			vertices.add(p);
		}
		
		for(int i = 0; i < vertices.size(); i++){
			for(int j = i + 1; j < vertices.size(); j++){
				if(checkBoxOverlap(vertices.get(i), 10, vertices.get(j))){
					vertices.remove(j);
					j--;
				}
			}
		}
		
		corridors = new boolean[vertices.size()][];
		for(int i = 0; i < vertices.size(); i++){
			corridors[i] = new boolean[i+1];
		}
		
		int currentMax = 1;
		int corridorLength = 4;
		
		while(currentMax < vertices.size()){
			for(int i = 0; i < vertices.size(); i++){
				for(int j = 0; j < vertices.size(); j++){
					if(i != j){
						if(vertices.get(i).leader != vertices.get(j).leader){
							if(checkBox(vertices.get(i), corridorLength, vertices.get(j))){
								
								corridors[Math.max(i, j)][Math.min(i, j)] = true;
								
								vertices.get(i).leader.groupSize += vertices.get(j).leader.groupSize;
								
								for(int k = 0; k < vertices.size(); k++){
									if(j != k){
										if(vertices.get(k).leader == vertices.get(j).leader){
											vertices.get(k).leader = vertices.get(i).leader;
										}
									}
								}
								
								vertices.get(j).leader = vertices.get(i).leader;
								
								if(currentMax < vertices.get(i).leader.groupSize){
									currentMax = vertices.get(i).leader.groupSize;
								}
								
							} 
						}
					}
				}
			}
			corridorLength *= 2;
		}
	}
	
	private boolean checkBox(Point p, int r, Point target){
		boolean xRange = Math.abs(p.x - target.x) + Math.abs(p.z - target.z) < r;
		return xRange;
	}
	
	private boolean checkBoxOverlap(Point p, int r, Point target){
		boolean xRange = Math.abs(p.x - target.x)< r;
		boolean yRange = Math.abs(p.z - target.z)< r;
		return yRange;
	}
	
	public class Point {
		public int x;
		public int z;
		public int xSize;
		public int zSize;
		Point leader = this;
		private int groupSize = 1;
		private int index;
		
		public Point(int xC, int yC, int i, int xS, int zS){
			x = xC;
			z = yC;
			index = i;
			xSize = xS;
			zSize = zS;
		}
	}
}
