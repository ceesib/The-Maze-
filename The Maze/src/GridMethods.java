
import java.util.Map;

public abstract class GridMethods<T,R>{
    public abstract void cleanup(T t);
    public void markPath(R r) throws InterruptedException{};
    public void markPath(Map<Cell,Cell> map) throws InterruptedException{};
}