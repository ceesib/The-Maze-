public interface GridMethods<T,R>{
    public abstract void cleanup(T t);
    public abstract void markPath(R r) throws InterruptedException;

}