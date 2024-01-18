package ProgrammersPractice;

public record StationRecord(int station, int w, int begin) {
    public int end(){
        return station - w;
    }
    public int possLen(){
        return end() - begin;
    }
    public boolean isExistCount(){
        return possLen() > 0;
    }
    public int nextBegin() {
        return station + w + 1;
    }
    // (2 * w + 1) 전파 가능 거리
    public int result(){
        return possLen() / (2 * w + 1);
    }

    // (2 * w + 1) 전파 가능 거리
    public boolean isRest(){
        return possLen() % (2 * w + 1) > 0;
    }
    public int calCount() {
        if (isExistCount()) return 0;
        return isRest() ?
                result() + 1 :
                result();
    }
}
