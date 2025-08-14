
import java.util.*;

public class Opening{
    public static Map<String,Struct<String,Integer>> borderCells = new HashMap<>();
    public static Set<String> cellsSet = new HashSet<>();

    public static void addBorderCell(Cell c){
        if (c.x==1 && c.y>=1 && !borderCells.containsKey(c.x+" "+c.y)) {
            Struct<String,Integer> struct = new Struct<>(c.x+" "+c.y,0);
            borderCells.put(c.x+" "+c.y,struct);
        
        }
        else if(c.x>=1 && c.y==1 && !borderCells.containsKey(c.x+" "+c.y)) {
            Struct<String,Integer> struct = new Struct<>(c.x+" "+c.y,3);
            borderCells.put(c.x+" "+c.y,struct);
        }
        else if(c.x>=1 && c.y==GameFrame.GWIDTH-1 && !borderCells.containsKey(c.x+" "+c.y)) {
            Struct<String,Integer> struct = new Struct<>(c.x+" "+c.y,1);
            borderCells.put(c.x+" "+c.y,struct);
        }
        else if(c.x==GameFrame.GHEIGHT-1 && c.y>=1 && !borderCells.containsKey(c.x+" "+c.y)) {
            Struct<String,Integer> struct = new Struct<>(c.x+" "+c.y,2);
            borderCells.put(c.x+" "+c.y,struct);
        }
    }
    public static void createOpening(Cell cell){
        String key = cell.x+" "+cell.y;
        if(borderCells.containsKey(key)) {
            Struct<String,Integer> cellInfo = borderCells.get(key);
            cell.walls[cellInfo.wall_to_open] = false;
        }
    }

}