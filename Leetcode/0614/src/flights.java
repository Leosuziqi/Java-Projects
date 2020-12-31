import java.util.ArrayList;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int price=0;
        if (src==dst){
            return 0;
        }
        ArrayList<Integer> cheap= new ArrayList<Integer>();
        if (K>0) {
            for (int i = 0; i < flights.length; i++) {
                price=0;
                if (flights[i][0]==src){
                    price = findCheapestPrice(n, flights, flights[i][1],dst, K- 1);
                    if (price!=-1) {
                        price += flights[i][2];

                        cheap.add(price);
                    }
                }
            }
        } else {
            price=zerostop(n,flights,src,dst);
            return price;
        }

        if (cheap.size()==0){
            return -1;
        }

        int cheapest=cheap.get(0);
        for(int j=0;j<cheap.size();j++) {
            if (cheap.get(j) < cheapest) {
                cheapest = cheap.get(j);
            }
        }
        return cheapest;
    }


    public int zerostop (int n, int[][] flights, int src, int dst){
        for (int i=0;i<flights.length;i++){
            if (flights[i][0]==src&&flights[i][1]==dst){
                return flights[i][2];
            }
        }
        return -1;
    }
}
