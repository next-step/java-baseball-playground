package Baseball;

public class Count {
    final int MIN_COUNT = 0;
    final int MAX_COUNT = 3;

    private int count;

    public Count() {
        this.count = MIN_COUNT;
    }

    public int getCount() {
        return count;
    }

    private int plusCount() {
        return count++;
    }

    public int count() {
        if(this.getCount() > MAX_COUNT) {
            throw new IllegalArgumentException("개수가 4개 이상될 수 없습니다.");
        }

        return plusCount();
    }
}
