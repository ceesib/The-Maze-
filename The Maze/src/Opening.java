
import java.util.*;

public class Opening{
    public static List<Struct<String,Integer>> borderCells = new LinkedList<>();
    public static Set<String> cellsSet = new HashSet<>();

    public static void addBorderCell(Cell c){
        if (c.x==1 && c.y>=1 && !cellsSet.contains(c.x+" "+c.y)) {
            Struct<String,Integer> struct = new Struct<>(c.x+" "+c.y,0);
            borderCells.add(struct);
            cellsSet.add(c.x+" "+c.y);
        }
        else if(c.x>=1 && c.y==1 && !cellsSet.contains(c.x+" "+c.y)) {
            Struct<String,Integer> struct = new Struct<>(c.x+" "+c.y,3);
            borderCells.add(struct);
            cellsSet.add(c.x+" "+c.y);
        }
        else if(c.x>=1 && c.y==GameFrame.GWIDTH-1 && !cellsSet.contains(c.x+" "+c.y)) {
            Struct<String,Integer> struct = new Struct<>(c.x+" "+c.y,1);
            borderCells.add(struct);
            cellsSet.add(c.x+" "+c.y);
        }
        else if(c.x==GameFrame.GHEIGHT-1 && c.y>=1 && !cellsSet.contains(c.x+" "+c.y)) {
            Struct<String,Integer> struct = new Struct<>(c.x+" "+c.y,2);
            borderCells.add(struct);
            cellsSet.add(c.x+" "+c.y);
        }
    }
    public static void createOpenings(int openings){
        Random random = new Random();
        while(openings>0){
            Struct<String,Integer> cellInfo = borderCells.get(random.nextInt(0,borderCells.size()));
            Cell cell = GameFrame.population.get(cellInfo.key);
            cell.walls[cellInfo.wall_to_open] = false;
            openings--;
        }
    }

}