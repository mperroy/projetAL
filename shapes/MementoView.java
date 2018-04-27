package shapes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MementoView implements Memento{
	private ArrayList<ShapeInterface> state;
	private static String fileName = "viewSave.txt";

	public MementoView() {
		state = new ArrayList<ShapeInterface>();
	}
	
	public MementoView(ArrayList<ShapeInterface> state) {
		setState(state);
	}

	public void setState(ArrayList<ShapeInterface> state) {
		this.state = state;

		try {
			FileWriter fileWriter = new FileWriter(fileName);

			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			for(ShapeInterface s : state) {
				bufferedWriter.write(s.toString());
				bufferedWriter.newLine();
			}

			bufferedWriter.close();
		} catch (IOException ex) {
			System.out.println("Error writing to file '" + fileName + "'");
		}
	}

	public ArrayList<ShapeInterface> getState() {
		while(!state.isEmpty()) {
			state.remove(0);
		}
		
		String line = null;

		try {
			FileReader fileReader =
					new FileReader(fileName);

			BufferedReader bufferedReader =
					new BufferedReader(fileReader);

			ArrayList<String> list = new ArrayList<String>();
			while((line = bufferedReader.readLine()) != null) {
				list.add(line);
			}
			
			int count = 0;
			String[] str;
			while(count < list.size()) {
				if(list.get(count).contains("Rectangle")) {
					RectangleSimple r = new RectangleSimple();
					str = list.get(count+1).split(" ");
					r.setPosition(new Coordinates(Double.parseDouble(str[0]), Double.parseDouble(str[1])));
					str = list.get(count+2).split(" ");
					r.setRotationCenter(new Coordinates(Double.parseDouble(str[0]), Double.parseDouble(str[1])));
					str = list.get(count+3).split(" ");
					r.setTranslation(new Coordinates(Double.parseDouble(str[0]), Double.parseDouble(str[1])));
					str = list.get(count+4).split(" ");
					r.setColor(new ColorSimple(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2])));
					r.setRotation(Double.parseDouble(list.get(count+5)));
					str = list.get(count+6).split(" ");
					for(int i = 0 ; i < 8 ; i+=2) {
						r.addVertix(new Coordinates(Double.parseDouble(str[i]), Double.parseDouble(str[i+1])));
					}
					str = list.get(count+7).split(" ");
					r.setWidth(Double.parseDouble(str[0]));
					r.setHeight(Double.parseDouble(str[1]));
					r.setBorderCurve(Double.parseDouble(str[2]));
					
					count+=8;
					state.add(r);
				}
				if(list.get(count).contains("RegularPolygon")) {
					RegularPolygonSimple rP = new RegularPolygonSimple();
					str = list.get(count+1).split(" ");
					rP.setEdgeLength(Double.parseDouble(str[0]));
					rP.setEdgeNumber(Integer.parseInt(str[1]));
					str = list.get(count+2).split(" ");
					rP.setPosition(new Coordinates(Double.parseDouble(str[0]), Double.parseDouble(str[1])));
					str = list.get(count+3).split(" ");
					rP.setRotationCenter(new Coordinates(Double.parseDouble(str[0]), Double.parseDouble(str[1])));
					str = list.get(count+4).split(" ");
					rP.setTranslation(new Coordinates(Double.parseDouble(str[0]), Double.parseDouble(str[1])));
					str = list.get(count+5).split(" ");
					rP.setColor(new ColorSimple(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2])));
					rP.setRotation(Double.parseDouble(list.get(count+6)));
					str = list.get(count+7).split(" ");
					for(int i = 0 ; i < rP.getEdgeNumber()*2 ; i+=2) {
						rP.addVertix(new Coordinates(Double.parseDouble(str[i]), Double.parseDouble(str[i+1])));
					}
					count+=8;
					state.add(rP);
				}
				count++;
			}
			
			
			bufferedReader.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" +
							fileName + "'");
		}
		catch(IOException ex) {
			System.out.println(
					"Error reading file '"
							+ fileName + "'");
		}

		return state;
	}
}
