public class Sloution22 {

    int maxCap = Integer.MAX_VALUE;
    int minCap = 0;
    int currCap = (maxCap + minCap)/2;

    int[] weights;
    int days;

    public int shipWithinDays(int[] weights, int days) {
        this.weights = weights;
        this.days = days;

        binaryCapSearch();

        return this.currCap;
    }

    void binaryCapSearch(){
        
    }
}
