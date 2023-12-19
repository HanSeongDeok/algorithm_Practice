package ProgrammersPractice;

public class StationFunc {
    private StationRecord record = null;
    private int count;
    private int begin;

    public int getCount() {
        return count;
    }
    public int getBegin(){
        return begin;
    }
    private StationFunc(StationRecord record){
        this.record = record;
    }
    public static StationFunc defaultFunc(StationRecord record){
        return new StationFunc(record);
    }
    public StationFunc calCount(){
        count += record.calCount();
        return this;
    }
    public StationFunc nextBegin(){
        begin = record.nextBegin();
        return this;
    }
    public void done(){
        // do Nothing
    }
}
