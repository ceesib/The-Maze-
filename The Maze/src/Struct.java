public class Struct<K,I>{
    public K key;
    public I current_wall,opposite_wall,wall_to_open;
    public Struct(K key, I current_wall,I opposite_wall){
        this.key = key;
        this.current_wall= current_wall;
        this.opposite_wall = opposite_wall;
    } 
    public Struct(K key, I wall_to_open){
        this.key = key;
        this.wall_to_open = wall_to_open;
    }
}