public class Hole {
    private int x;
    private int y;
    private int ballsCount;

    public Hole(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean checkHit(int x1, int x2, int y1, int y2) {
        boolean isHit = (x1 == this.x && y1 == this.y) ||
                (x1 == this.x && y2 == this.y) ||
                (x2 == this.x && y1 == this.y) ||
                (x2 == this.x && y2 == this.y);
        if (isHit)
            ballsCount++;
        return isHit;
    }

    public String getInfo() {
        return String.format("Hole (%d, %d): %d balls", x, y, ballsCount);
    }
}
