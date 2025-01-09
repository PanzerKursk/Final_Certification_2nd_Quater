public class Counter implements AutoCloseable {
    private int count = 0;
    private boolean closed = false;

    public int getCount() {
        return count;
    }

    public void add(){
        if (closed) {
            throw new IllegalStateException("Счетчик уже закрыт!");
        }
        count++;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
        if (!closed) {
            closed = true;
            System.out.println("Счетчик успешно закрыт");
        }else{
            throw new IllegalStateException("Счетчик уже закрыт!");
        }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Текущее значение счетчика: " + count;
    }
}
